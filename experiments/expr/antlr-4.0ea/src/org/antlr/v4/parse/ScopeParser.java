/*
 [The "BSD license"]
 Copyright (c) 2011 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:

 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.antlr.v4.parse;

import org.antlr.v4.tool.*;

import java.util.*;

/** Parse args, return values, and dynamic scopes.
 *
 *  rule[arg1, arg2, ..., argN] returns [ret1, ..., retN]
 *  scope { decl1; decl2; ... declN; }
 *
 *  The ',' and ';' are significant.  Use \, and \; to use within
 *  types if necessary like [Map<String\,String> foo, int y].
 *
 *  arg, ret, and decl are target language dependent.  Java/C#/C/C++ would
 *  use "int i" but ruby/python would use "i".
 */
public class ScopeParser {
    /** Given an arg or retval scope definition list like
     *
     *  Map<String, String>, int[] j3, char *foo32[3]
     *
     *  or
     *
     *  int i=3, j=a[34]+20
     *
     *  convert to an attribute scope.
     */
    public static AttributeDict parseTypedArgList(String s, ErrorManager errMgr) { return parse(s, ',', errMgr); }

    public static AttributeDict parse(String s, char separator, ErrorManager errMgr) {
        int i = 0;
        int n = s.length();
        AttributeDict dict = new AttributeDict();
        while ( i<n ) {
            StringBuilder buf = new StringBuilder();
            while ( i<n && s.charAt(i)!=separator ) {
                if ( s.charAt(i)=='\\' ) {
                    i++;
                    if ( i<n && s.charAt(i)==separator ) {
                        buf.append(s.charAt(i));
                        i++;
                        continue;
                    }
                    buf.append('\\');
                }
                buf.append(s.charAt(i));
                i++;
            }
            i++; // skip separator
            String def = buf.toString();
            //System.out.println("def="+ def);
            if ( def.trim().length()>0 ) {
                Attribute a = parseAttributeDef(def, errMgr);
                dict.add(a);
            }
        }
        return dict;
    }

    /** For decls like "String foo" or "char *foo32[]" compute the ID
     *  and type declarations.  Also handle "int x=3" and 'T t = new T("foo")'
     *  but if the separator is ',' you cannot use ',' in the initvalue
     *  unless you escape use "\," escape.
     */
    public static Attribute parseAttributeDef(String decl, ErrorManager errMgr) {
        if ( decl==null ) return null;
        Attribute attr = new Attribute();
        boolean inID = false;
        int start = -1;
        int rightEdgeOfDeclarator = decl.length()-1;
        int equalsIndex = decl.indexOf('=');
        if ( equalsIndex>0 ) {
            // everything after the '=' is the init value
            attr.initValue = decl.substring(equalsIndex+1,decl.length());
            rightEdgeOfDeclarator = equalsIndex-1;
        }
        // walk backwards looking for start of an ID
        for (int i=rightEdgeOfDeclarator; i>=0; i--) {
            // if we haven't found the end yet, keep going
            if ( !inID && Character.isLetterOrDigit(decl.charAt(i)) ) {
                inID = true;
            }
            else if ( inID &&
                      !(Character.isLetterOrDigit(decl.charAt(i))||
                       decl.charAt(i)=='_') ) {
                start = i+1;
                break;
            }
        }
        if ( start<0 && inID ) {
            start = 0;
        }
        if ( start<0 ) {
            errMgr.toolError(ErrorType.CANNOT_FIND_ATTRIBUTE_NAME_IN_DECL,decl);
        }
        // walk forwards looking for end of an ID
        int stop=-1;
        for (int i=start; i<=rightEdgeOfDeclarator; i++) {
            // if we haven't found the end yet, keep going
            if ( !(Character.isLetterOrDigit(decl.charAt(i))||
                decl.charAt(i)=='_') )
            {
                stop = i;
                break;
            }
            if ( i==rightEdgeOfDeclarator ) {
                stop = i+1;
            }
        }

        // the name is the last ID
        attr.name = decl.substring(start,stop);

        // the type is the decl minus the ID (could be empty)
        attr.type = decl.substring(0,start);
        if ( stop<=rightEdgeOfDeclarator ) {
            attr.type += decl.substring(stop,rightEdgeOfDeclarator+1);
        }
        attr.type = attr.type.trim();
        if ( attr.type.length()==0 ) {
            attr.type = null;
        }

        attr.decl = decl;
        return attr;
    }

    /** Given an argument list like
     *
     *  x, (*a).foo(21,33), 3.2+1, '\n',
     *  "a,oo\nick", {bl, "fdkj"eck}, ["cat\n,", x, 43]
     *
     *  convert to a list of attributes.  Allow nested square brackets etc...
     *  Set separatorChar to ';' or ',' or whatever you want.
     */
    public static List<String> splitArgumentList(String s, int separatorChar) {
        List<String> args = new ArrayList<String>();
        _splitArgumentList(s, 0, -1, separatorChar, args);
        return args;
    }


    public static int _splitArgumentList(String actionText,
                                         int start,
                                         int targetChar,
                                         int separatorChar,
                                         List<String> args)
    {
        if ( actionText==null ) {
            return -1;
        }
        actionText = actionText.replaceAll("//.*\n", "");
        int n = actionText.length();
        //System.out.println("actionText@"+start+"->"+(char)targetChar+"="+actionText.substring(start,n));
        int p = start;
        int last = p;
        while ( p<n && actionText.charAt(p)!=targetChar ) {
            int c = actionText.charAt(p);
            switch ( c ) {
                case '\'' :
                    p++;
                    while ( p<n && actionText.charAt(p)!='\'' ) {
                        if ( actionText.charAt(p)=='\\' && (p+1)<n &&
                             actionText.charAt(p+1)=='\'' )
                        {
                            p++; // skip escaped quote
                        }
                        p++;
                    }
                    p++;
                    break;
                case '"' :
                    p++;
                    while ( p<n && actionText.charAt(p)!='\"' ) {
                        if ( actionText.charAt(p)=='\\' && (p+1)<n &&
                             actionText.charAt(p+1)=='\"' )
                        {
                            p++; // skip escaped quote
                        }
                        p++;
                    }
                    p++;
                    break;
                case '(' :
                    p = _splitArgumentList(actionText,p+1,')',separatorChar,args);
                    break;
                case '{' :
                    p = _splitArgumentList(actionText,p+1,'}',separatorChar,args);
                    break;
                case '<' :
                    if ( actionText.indexOf('>',p+1)>=p ) {
                        // do we see a matching '>' ahead?  if so, hope it's a generic
                        // and not less followed by expr with greater than
                        p = _splitArgumentList(actionText,p+1,'>',separatorChar,args);
                    }
                    else {
                        p++; // treat as normal char
                    }
                    break;
                case '[' :
                    p = _splitArgumentList(actionText,p+1,']',separatorChar,args);
                    break;
                default :
                    if ( c==separatorChar && targetChar==-1 ) {
                        String arg = actionText.substring(last, p);
                        //System.out.println("arg="+arg);
                        args.add(arg.trim());
                        last = p+1;
                    }
                    p++;
                    break;
            }
        }
        if ( targetChar==-1 && p<=n ) {
            String arg = actionText.substring(last, p).trim();
            //System.out.println("arg="+arg);
            if ( arg.length()>0 ) {
                args.add(arg.trim());
            }
        }
        p++;
        return p;
    }

}

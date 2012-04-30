// $ANTLR 3.4 ANTLRLexer.g 2012-04-29 22:33:12

/*
 [The "BSD licence"]
 Copyright (c) 2005-2009 Terence Parr
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


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** Read in an ANTLR grammar and build an AST.  Try not to do
 *  any actions, just build the tree.
 *
 *  The phases are:
 *
 *		A3Lexer.g (this file)
 *              A3Parser.g
 *              A3Verify.g (derived from A3Walker.g)
 *		assign.types.g
 *		define.g
 *		buildnfa.g
 *		antlr.print.g (optional)
 *		codegen.g
 *
 *  Terence Parr
 *  University of San Francisco
 *  2005
 *  Jim Idle (this v3 grammar)
 *  Temporal Wave LLC
 *  2009
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class ANTLRLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ACTION=4;
    public static final int ACTION_CHAR_LITERAL=5;
    public static final int ACTION_ESC=6;
    public static final int ACTION_STRING_LITERAL=7;
    public static final int ARG_ACTION=8;
    public static final int ARG_OR_CHARSET=9;
    public static final int ASSIGN=10;
    public static final int AT=11;
    public static final int CATCH=12;
    public static final int COLON=13;
    public static final int COLONCOLON=14;
    public static final int COMMA=15;
    public static final int COMMENT=16;
    public static final int DOC_COMMENT=17;
    public static final int DOLLAR=18;
    public static final int DOT=19;
    public static final int ERRCHAR=20;
    public static final int ESC_SEQ=21;
    public static final int ETC=22;
    public static final int FINALLY=23;
    public static final int FRAGMENT=24;
    public static final int GRAMMAR=25;
    public static final int GT=26;
    public static final int HEX_DIGIT=27;
    public static final int ID=28;
    public static final int IMPORT=29;
    public static final int INT=30;
    public static final int LEXER=31;
    public static final int LEXER_CHAR_SET=32;
    public static final int LOCALS=33;
    public static final int LPAREN=34;
    public static final int LT=35;
    public static final int MODE=36;
    public static final int NESTED_ACTION=37;
    public static final int NLCHARS=38;
    public static final int NOT=39;
    public static final int NameChar=40;
    public static final int NameStartChar=41;
    public static final int OPTIONS=42;
    public static final int OR=43;
    public static final int PARSER=44;
    public static final int PLUS=45;
    public static final int PLUS_ASSIGN=46;
    public static final int POUND=47;
    public static final int PRIVATE=48;
    public static final int PROTECTED=49;
    public static final int PUBLIC=50;
    public static final int QUESTION=51;
    public static final int RANGE=52;
    public static final int RARROW=53;
    public static final int RBRACE=54;
    public static final int RETURNS=55;
    public static final int RPAREN=56;
    public static final int RULE_REF=57;
    public static final int SEMI=58;
    public static final int SEMPRED=59;
    public static final int SRC=60;
    public static final int STAR=61;
    public static final int STRING_LITERAL=62;
    public static final int THROWS=63;
    public static final int TOKENS_SPEC=64;
    public static final int TOKEN_REF=65;
    public static final int UNICODE_ESC=66;
    public static final int WS=67;
    public static final int WSCHARS=68;
    public static final int WSNLCHARS=69;

        public CommonTokenStream tokens; // track stream we push to; need for context info
        public boolean isLexerRule = false;

    	/** scan backwards from current point in this.tokens list
    	 *  looking for the start of the rule or subrule.
    	 *  Return token or null if for some reason we can't find the start.
    	 */
    	public Token getRuleOrSubruleStartToken() {
    	    if ( tokens==null ) return null;
    		int i = tokens.index();
            int n = tokens.size();
            if ( i>=n ) i = n-1; // seems index == n as we lex
    		while ( i>=0 && i<n) {
    			int ttype = tokens.get(i).getType();
    			if ( ttype == LPAREN || ttype == TOKEN_REF || ttype == RULE_REF ) {
    				return tokens.get(i);
    			}
    			i--;
    		}
    		return null;
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ANTLRLexer() {} 
    public ANTLRLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ANTLRLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "ANTLRLexer.g"; }

    // $ANTLR start "DOC_COMMENT"
    public final void mDOC_COMMENT() throws RecognitionException {
        try {
            // ANTLRLexer.g:156:22: ()
            // ANTLRLexer.g:156:24: 
            {
            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOC_COMMENT"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;


            	// Record the start line and offsets as if we need to report an
            	// unterminated comment, then we want to show the start of the comment
            	// we think is broken, not the end, where people will have to try and work
            	// it out themselves.
            	//
            	int startLine = state.tokenStartLine;
            	int offset    = getCharPositionInLine();

            // ANTLRLexer.g:168:5: ( '/' ( '/' ( ( ' $ANTLR' )=> ' $ANTLR' SRC | (~ ( NLCHARS ) )* ) | '*' ({...}? => '*' |{...}? =>) ({...}? . )* ( '*/' |) |) )
            // ANTLRLexer.g:171:7: '/' ( '/' ( ( ' $ANTLR' )=> ' $ANTLR' SRC | (~ ( NLCHARS ) )* ) | '*' ({...}? => '*' |{...}? =>) ({...}? . )* ( '*/' |) |)
            {
            match('/'); if (state.failed) return ;

            // ANTLRLexer.g:173:7: ( '/' ( ( ' $ANTLR' )=> ' $ANTLR' SRC | (~ ( NLCHARS ) )* ) | '*' ({...}? => '*' |{...}? =>) ({...}? . )* ( '*/' |) |)
            int alt6=3;
            switch ( input.LA(1) ) {
            case '/':
                {
                alt6=1;
                }
                break;
            case '*':
                {
                alt6=2;
                }
                break;
            default:
                alt6=3;
            }

            switch (alt6) {
                case 1 :
                    // ANTLRLexer.g:179:11: '/' ( ( ' $ANTLR' )=> ' $ANTLR' SRC | (~ ( NLCHARS ) )* )
                    {
                    match('/'); if (state.failed) return ;

                    // ANTLRLexer.g:180:13: ( ( ' $ANTLR' )=> ' $ANTLR' SRC | (~ ( NLCHARS ) )* )
                    int alt2=2;
                    alt2 = dfa2.predict(input);
                    switch (alt2) {
                        case 1 :
                            // ANTLRLexer.g:181:17: ( ' $ANTLR' )=> ' $ANTLR' SRC
                            {
                            match(" $ANTLR"); if (state.failed) return ;



                            mSRC(); if (state.failed) return ;


                            }
                            break;
                        case 2 :
                            // ANTLRLexer.g:182:17: (~ ( NLCHARS ) )*
                            {
                            // ANTLRLexer.g:182:17: (~ ( NLCHARS ) )*
                            loop1:
                            do {
                                int alt1=2;
                                int LA1_0 = input.LA(1);

                                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
                                    alt1=1;
                                }


                                switch (alt1) {
                            	case 1 :
                            	    // ANTLRLexer.g:
                            	    {
                            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
                            	        input.consume();
                            	        state.failed=false;
                            	    }
                            	    else {
                            	        if (state.backtracking>0) {state.failed=true; return ;}
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop1;
                                }
                            } while (true);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ANTLRLexer.g:189:12: '*' ({...}? => '*' |{...}? =>) ({...}? . )* ( '*/' |)
                    {
                    match('*'); if (state.failed) return ;

                    // ANTLRLexer.g:189:16: ({...}? => '*' |{...}? =>)
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='*') && ((( input.LA(2) != '/')||( true )))) {
                        int LA3_1 = input.LA(2);

                        if ( (( input.LA(2) != '/')) ) {
                            alt3=1;
                        }
                        else if ( (( true )) ) {
                            alt3=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 3, 1, input);

                            throw nvae;

                        }
                    }
                    else {
                        alt3=2;
                    }
                    switch (alt3) {
                        case 1 :
                            // ANTLRLexer.g:190:17: {...}? => '*'
                            {
                            if ( !(( input.LA(2) != '/')) ) {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                throw new FailedPredicateException(input, "COMMENT", " input.LA(2) != '/'");
                            }

                            match('*'); if (state.failed) return ;

                            if ( state.backtracking==0 ) { _type = DOC_COMMENT; }

                            }
                            break;
                        case 2 :
                            // ANTLRLexer.g:191:17: {...}? =>
                            {
                            if ( !(( true )) ) {
                                if (state.backtracking>0) {state.failed=true; return ;}
                                throw new FailedPredicateException(input, "COMMENT", " true ");
                            }

                            }
                            break;

                    }


                    // ANTLRLexer.g:196:16: ({...}? . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='*') ) {
                            int LA4_1 = input.LA(2);

                            if ( (LA4_1=='/') ) {
                                int LA4_4 = input.LA(3);

                                if ( ((    !(input.LA(1) == '*' && input.LA(2) == '/') )) ) {
                                    alt4=1;
                                }


                            }

                            else {
                                alt4=1;
                            }


                        }
                        else if ( ((LA4_0 >= '\u0000' && LA4_0 <= ')')||(LA4_0 >= '+' && LA4_0 <= '\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ANTLRLexer.g:200:20: {...}? .
                    	    {
                    	    if ( !((    !(input.LA(1) == '*' && input.LA(2) == '/') )) ) {
                    	        if (state.backtracking>0) {state.failed=true; return ;}
                    	        throw new FailedPredicateException(input, "COMMENT", "    !(input.LA(1) == '*' && input.LA(2) == '/') ");
                    	    }

                    	    matchAny(); if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    // ANTLRLexer.g:207:13: ( '*/' |)
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='*') ) {
                        alt5=1;
                    }
                    else {
                        alt5=2;
                    }
                    switch (alt5) {
                        case 1 :
                            // ANTLRLexer.g:213:18: '*/'
                            {
                            match("*/"); if (state.failed) return ;



                            }
                            break;
                        case 2 :
                            // ANTLRLexer.g:217:18: 
                            {
                            if ( state.backtracking==0 ) {
                                               // ErrorManager.msg(Msg.UNTERMINATED_DOC_COMMENT, startLine, offset, state.tokenStartCharPositionInLine, startLine, offset, state.tokenStartCharPositionInLine, (Object)null);
                                             }

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ANTLRLexer.g:225:12: 
                    {
                    if ( state.backtracking==0 ) {
                               	 // TODO: Insert error message relative to comment start
                                 //
                               }

                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                     // Unless we had a documentation comment, then we do not wish to
                     // pass the comments in to the parser. If you are writing a formatter
                     // then you will want to preserve the comments off channel, but could
                     // just skip and save token space if not.
                     //
                     if (_type != DOC_COMMENT) {

                         _channel=2;  // Comments are on channel 2
                     }
                   }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "ARG_OR_CHARSET"
    public final void mARG_OR_CHARSET() throws RecognitionException {
        try {
            int _type = ARG_OR_CHARSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:245:5: ({...}? => LEXER_CHAR_SET |{...}? => ARG_ACTION )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='[') && (((!isLexerRule)||(isLexerRule)))) {
                int LA7_1 = input.LA(2);

                if ( ((isLexerRule)) ) {
                    alt7=1;
                }
                else if ( ((!isLexerRule)) ) {
                    alt7=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // ANTLRLexer.g:245:9: {...}? => LEXER_CHAR_SET
                    {
                    if ( !((isLexerRule)) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ARG_OR_CHARSET", "isLexerRule");
                    }

                    mLEXER_CHAR_SET(); if (state.failed) return ;


                    if ( state.backtracking==0 ) {_type=LEXER_CHAR_SET;}

                    }
                    break;
                case 2 :
                    // ANTLRLexer.g:246:9: {...}? => ARG_ACTION
                    {
                    if ( !((!isLexerRule)) ) {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        throw new FailedPredicateException(input, "ARG_OR_CHARSET", "!isLexerRule");
                    }

                    mARG_ACTION(); if (state.failed) return ;


                    if ( state.backtracking==0 ) {_type=ARG_ACTION;}

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARG_OR_CHARSET"

    // $ANTLR start "LEXER_CHAR_SET"
    public final void mLEXER_CHAR_SET() throws RecognitionException {
        try {
            // ANTLRLexer.g:251:5: ( '[' ( '\\\\]' | '\\\\' ~ ']' |~ ( '\\\\' | ']' ) )* ']' )
            // ANTLRLexer.g:251:9: '[' ( '\\\\]' | '\\\\' ~ ']' |~ ( '\\\\' | ']' ) )* ']'
            {
            match('['); if (state.failed) return ;

            // ANTLRLexer.g:251:13: ( '\\\\]' | '\\\\' ~ ']' |~ ( '\\\\' | ']' ) )*
            loop8:
            do {
                int alt8=4;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2==']') ) {
                        alt8=1;
                    }
                    else if ( ((LA8_2 >= '\u0000' && LA8_2 <= '\\')||(LA8_2 >= '^' && LA8_2 <= '\uFFFF')) ) {
                        alt8=2;
                    }


                }
                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '[')||(LA8_0 >= '^' && LA8_0 <= '\uFFFF')) ) {
                    alt8=3;
                }


                switch (alt8) {
            	case 1 :
            	    // ANTLRLexer.g:251:14: '\\\\]'
            	    {
            	    match("\\]"); if (state.failed) return ;



            	    }
            	    break;
            	case 2 :
            	    // ANTLRLexer.g:251:20: '\\\\' ~ ']'
            	    {
            	    match('\\'); if (state.failed) return ;

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\\')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;
            	case 3 :
            	    // ANTLRLexer.g:251:30: ~ ( '\\\\' | ']' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '[')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            match(']'); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEXER_CHAR_SET"

    // $ANTLR start "ARG_ACTION"
    public final void mARG_ACTION() throws RecognitionException {
        try {
            CommonToken as=null;
            CommonToken ac=null;
            int c;


            	StringBuffer theText = new StringBuffer();

            // ANTLRLexer.g:268:2: ( '[' ( ( '\\\\' )=> '\\\\' ( ( ']' )=> ']' |c= . ) | ( '\"' )=>as= ACTION_STRING_LITERAL | ( '\\'' )=>ac= ACTION_CHAR_LITERAL |c=~ ']' )* ']' )
            // ANTLRLexer.g:268:4: '[' ( ( '\\\\' )=> '\\\\' ( ( ']' )=> ']' |c= . ) | ( '\"' )=>as= ACTION_STRING_LITERAL | ( '\\'' )=>ac= ACTION_CHAR_LITERAL |c=~ ']' )* ']'
            {
            match('['); if (state.failed) return ;

            // ANTLRLexer.g:269:10: ( ( '\\\\' )=> '\\\\' ( ( ']' )=> ']' |c= . ) | ( '\"' )=>as= ACTION_STRING_LITERAL | ( '\\'' )=>ac= ACTION_CHAR_LITERAL |c=~ ']' )*
            loop10:
            do {
                int alt10=5;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // ANTLRLexer.g:270:14: ( '\\\\' )=> '\\\\' ( ( ']' )=> ']' |c= . )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    // ANTLRLexer.g:271:18: ( ( ']' )=> ']' |c= . )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==']') ) {
            	        int LA9_1 = input.LA(2);

            	        if ( (synpred3_ANTLRLexer()) ) {
            	            alt9=1;
            	        }
            	        else if ( (true) ) {
            	            alt9=2;
            	        }
            	        else {
            	            if (state.backtracking>0) {state.failed=true; return ;}
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 9, 1, input);

            	            throw nvae;

            	        }
            	    }
            	    else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\\')||(LA9_0 >= '^' && LA9_0 <= '\uFFFF')) ) {
            	        alt9=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // ANTLRLexer.g:272:22: ( ']' )=> ']'
            	            {
            	            match(']'); if (state.failed) return ;

            	            if ( state.backtracking==0 ) {
            	                                       // We do not include the \ character itself when picking up an escaped ]
            	                                       //
            	                                       theText.append(']');
            	                                   }

            	            }
            	            break;
            	        case 2 :
            	            // ANTLRLexer.g:278:22: c= .
            	            {
            	            c = input.LA(1);

            	            matchAny(); if (state.failed) return ;

            	            if ( state.backtracking==0 ) {
            	                                       // We DO include the \ character when finding any other escape
            	                                       //
            	                                       theText.append('\\');
            	                                       theText.append((char)c);
            	                                   }

            	            }
            	            break;

            	    }


            	    }
            	    break;
            	case 2 :
            	    // ANTLRLexer.g:287:14: ( '\"' )=>as= ACTION_STRING_LITERAL
            	    {
            	    int asStart1276 = getCharIndex();
            	    int asStartLine1276 = getLine();
            	    int asStartCharPos1276 = getCharPositionInLine();
            	    mACTION_STRING_LITERAL(); if (state.failed) return ;
            	    as = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, asStart1276, getCharIndex()-1);
            	    as.setLine(asStartLine1276);
            	    as.setCharPositionInLine(asStartCharPos1276);


            	    if ( state.backtracking==0 ) {
            	                        // Append the embedded string literal test
            	                        //
            	                        theText.append((as!=null?as.getText():null));
            	                    }

            	    }
            	    break;
            	case 3 :
            	    // ANTLRLexer.g:294:14: ( '\\'' )=>ac= ACTION_CHAR_LITERAL
            	    {
            	    int acStart1316 = getCharIndex();
            	    int acStartLine1316 = getLine();
            	    int acStartCharPos1316 = getCharPositionInLine();
            	    mACTION_CHAR_LITERAL(); if (state.failed) return ;
            	    ac = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, acStart1316, getCharIndex()-1);
            	    ac.setLine(acStartLine1316);
            	    ac.setCharPositionInLine(acStartCharPos1316);


            	    if ( state.backtracking==0 ) {
            	                        // Append the embedded chracter literal text
            	                        //
            	                        theText.append((ac!=null?ac.getText():null));
            	                    }

            	    }
            	    break;
            	case 4 :
            	    // ANTLRLexer.g:301:14: c=~ ']'
            	    {
            	    c= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\\')||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( state.backtracking==0 ) {
            	                        // Whatever else we found in the scan
            	                        //
            	                        theText.append((char)c);
            	                    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(']'); if (state.failed) return ;

            if ( state.backtracking==0 ) {
                       // Set the token text to our gathered string
                       //
                       setText(theText.toString());
                   }

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARG_ACTION"

    // $ANTLR start "ACTION"
    public final void mACTION() throws RecognitionException {
        try {
            int _type = ACTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:329:2: ( NESTED_ACTION ( '?' )? )
            // ANTLRLexer.g:329:4: NESTED_ACTION ( '?' )?
            {
            mNESTED_ACTION(); if (state.failed) return ;


            // ANTLRLexer.g:329:18: ( '?' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='?') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ANTLRLexer.g:329:19: '?'
                    {
                    match('?'); if (state.failed) return ;

                    if ( state.backtracking==0 ) {_type = SEMPRED;}

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACTION"

    // $ANTLR start "NESTED_ACTION"
    public final void mNESTED_ACTION() throws RecognitionException {
        try {


            	// Record the start line and offsets as if we need to report an
            	// unterminated block, then we want to show the start of the comment
            	// we think is broken, not the end, where people will have to try and work
            	// it out themselves.
            	//
            	int startLine = getLine();
            	int offset    = getCharPositionInLine();

            // ANTLRLexer.g:356:5: ( '{' ( NESTED_ACTION | ACTION_CHAR_LITERAL | COMMENT | ACTION_STRING_LITERAL | ACTION_ESC |~ ( '\\\\' | '\"' | '\\'' | '/' | '{' | '}' ) )* ( '}' |) )
            // ANTLRLexer.g:358:4: '{' ( NESTED_ACTION | ACTION_CHAR_LITERAL | COMMENT | ACTION_STRING_LITERAL | ACTION_ESC |~ ( '\\\\' | '\"' | '\\'' | '/' | '{' | '}' ) )* ( '}' |)
            {
            match('{'); if (state.failed) return ;

            // ANTLRLexer.g:359:7: ( NESTED_ACTION | ACTION_CHAR_LITERAL | COMMENT | ACTION_STRING_LITERAL | ACTION_ESC |~ ( '\\\\' | '\"' | '\\'' | '/' | '{' | '}' ) )*
            loop12:
            do {
                int alt12=7;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='{') ) {
                    alt12=1;
                }
                else if ( (LA12_0=='\'') ) {
                    alt12=2;
                }
                else if ( (LA12_0=='/') ) {
                    alt12=3;
                }
                else if ( (LA12_0=='\"') ) {
                    alt12=4;
                }
                else if ( (LA12_0=='\\') ) {
                    alt12=5;
                }
                else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= '&')||(LA12_0 >= '(' && LA12_0 <= '.')||(LA12_0 >= '0' && LA12_0 <= '[')||(LA12_0 >= ']' && LA12_0 <= 'z')||LA12_0=='|'||(LA12_0 >= '~' && LA12_0 <= '\uFFFF')) ) {
                    alt12=6;
                }


                switch (alt12) {
            	case 1 :
            	    // ANTLRLexer.g:374:8: NESTED_ACTION
            	    {
            	    mNESTED_ACTION(); if (state.failed) return ;


            	    }
            	    break;
            	case 2 :
            	    // ANTLRLexer.g:378:11: ACTION_CHAR_LITERAL
            	    {
            	    mACTION_CHAR_LITERAL(); if (state.failed) return ;


            	    }
            	    break;
            	case 3 :
            	    // ANTLRLexer.g:383:11: COMMENT
            	    {
            	    mCOMMENT(); if (state.failed) return ;


            	    }
            	    break;
            	case 4 :
            	    // ANTLRLexer.g:387:11: ACTION_STRING_LITERAL
            	    {
            	    mACTION_STRING_LITERAL(); if (state.failed) return ;


            	    }
            	    break;
            	case 5 :
            	    // ANTLRLexer.g:391:8: ACTION_ESC
            	    {
            	    mACTION_ESC(); if (state.failed) return ;


            	    }
            	    break;
            	case 6 :
            	    // ANTLRLexer.g:396:8: ~ ( '\\\\' | '\"' | '\\'' | '/' | '{' | '}' )
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '.')||(input.LA(1) >= '0' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= 'z')||input.LA(1)=='|'||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            // ANTLRLexer.g:400:2: ( '}' |)
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='}') ) {
                alt13=1;
            }
            else {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // ANTLRLexer.g:403:6: '}'
                    {
                    match('}'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ANTLRLexer.g:408:6: 
                    {
                    if ( state.backtracking==0 ) {
                    	        // TODO: Report imbalanced {}
                    	        System.out.println("Block starting  at line " + startLine + " offset " + (offset+1) + " contains imbalanced {} or is missing a }");
                    	    }

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NESTED_ACTION"

    // $ANTLR start "OPTIONS"
    public final void mOPTIONS() throws RecognitionException {
        try {
            int _type = OPTIONS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:425:14: ( 'options' ( WSNLCHARS )* '{' )
            // ANTLRLexer.g:425:16: 'options' ( WSNLCHARS )* '{'
            {
            match("options"); if (state.failed) return ;



            // ANTLRLexer.g:425:26: ( WSNLCHARS )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= '\t' && LA14_0 <= '\n')||(LA14_0 >= '\f' && LA14_0 <= '\r')||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ANTLRLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OPTIONS"

    // $ANTLR start "TOKENS_SPEC"
    public final void mTOKENS_SPEC() throws RecognitionException {
        try {
            int _type = TOKENS_SPEC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:426:14: ( 'tokens' ( WSNLCHARS )* '{' )
            // ANTLRLexer.g:426:16: 'tokens' ( WSNLCHARS )* '{'
            {
            match("tokens"); if (state.failed) return ;



            // ANTLRLexer.g:426:26: ( WSNLCHARS )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= '\t' && LA15_0 <= '\n')||(LA15_0 >= '\f' && LA15_0 <= '\r')||LA15_0==' ') ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ANTLRLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TOKENS_SPEC"

    // $ANTLR start "IMPORT"
    public final void mIMPORT() throws RecognitionException {
        try {
            int _type = IMPORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:428:14: ( 'import' )
            // ANTLRLexer.g:428:16: 'import'
            {
            match("import"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IMPORT"

    // $ANTLR start "FRAGMENT"
    public final void mFRAGMENT() throws RecognitionException {
        try {
            int _type = FRAGMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:429:14: ( 'fragment' )
            // ANTLRLexer.g:429:16: 'fragment'
            {
            match("fragment"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FRAGMENT"

    // $ANTLR start "LEXER"
    public final void mLEXER() throws RecognitionException {
        try {
            int _type = LEXER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:430:14: ( 'lexer' )
            // ANTLRLexer.g:430:16: 'lexer'
            {
            match("lexer"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LEXER"

    // $ANTLR start "PARSER"
    public final void mPARSER() throws RecognitionException {
        try {
            int _type = PARSER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:431:14: ( 'parser' )
            // ANTLRLexer.g:431:16: 'parser'
            {
            match("parser"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PARSER"

    // $ANTLR start "GRAMMAR"
    public final void mGRAMMAR() throws RecognitionException {
        try {
            int _type = GRAMMAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:432:14: ( 'grammar' )
            // ANTLRLexer.g:432:16: 'grammar'
            {
            match("grammar"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GRAMMAR"

    // $ANTLR start "PROTECTED"
    public final void mPROTECTED() throws RecognitionException {
        try {
            int _type = PROTECTED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:433:14: ( 'protected' )
            // ANTLRLexer.g:433:16: 'protected'
            {
            match("protected"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROTECTED"

    // $ANTLR start "PUBLIC"
    public final void mPUBLIC() throws RecognitionException {
        try {
            int _type = PUBLIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:434:14: ( 'public' )
            // ANTLRLexer.g:434:16: 'public'
            {
            match("public"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PUBLIC"

    // $ANTLR start "PRIVATE"
    public final void mPRIVATE() throws RecognitionException {
        try {
            int _type = PRIVATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:435:14: ( 'private' )
            // ANTLRLexer.g:435:16: 'private'
            {
            match("private"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PRIVATE"

    // $ANTLR start "RETURNS"
    public final void mRETURNS() throws RecognitionException {
        try {
            int _type = RETURNS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:436:14: ( 'returns' )
            // ANTLRLexer.g:436:16: 'returns'
            {
            match("returns"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RETURNS"

    // $ANTLR start "LOCALS"
    public final void mLOCALS() throws RecognitionException {
        try {
            int _type = LOCALS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:437:14: ( 'locals' )
            // ANTLRLexer.g:437:16: 'locals'
            {
            match("locals"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LOCALS"

    // $ANTLR start "THROWS"
    public final void mTHROWS() throws RecognitionException {
        try {
            int _type = THROWS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:438:14: ( 'throws' )
            // ANTLRLexer.g:438:16: 'throws'
            {
            match("throws"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THROWS"

    // $ANTLR start "CATCH"
    public final void mCATCH() throws RecognitionException {
        try {
            int _type = CATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:439:14: ( 'catch' )
            // ANTLRLexer.g:439:16: 'catch'
            {
            match("catch"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CATCH"

    // $ANTLR start "FINALLY"
    public final void mFINALLY() throws RecognitionException {
        try {
            int _type = FINALLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:440:14: ( 'finally' )
            // ANTLRLexer.g:440:16: 'finally'
            {
            match("finally"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FINALLY"

    // $ANTLR start "MODE"
    public final void mMODE() throws RecognitionException {
        try {
            int _type = MODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:441:14: ( 'mode' )
            // ANTLRLexer.g:441:16: 'mode'
            {
            match("mode"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MODE"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:448:14: ( ':' )
            // ANTLRLexer.g:448:16: ':'
            {
            match(':'); if (state.failed) return ;

            if ( state.backtracking==0 ) {
                           // scan backwards, looking for a RULE_REF or TOKEN_REF.
                           // which would indicate the start of a rule definition.
                           // If we see a LPAREN, then it's the start of the subrule.
                           // this.tokens is the token string we are pushing into, so
                           // just loop backwards looking for a rule definition. Then
                           // we set isLexerRule.
                           Token t = getRuleOrSubruleStartToken();
                           if ( t!=null ) {
                                if ( t.getType()==RULE_REF ) isLexerRule = false;
                                else if ( t.getType()==TOKEN_REF ) isLexerRule = true;
                                // else must be subrule; don't alter context
                           }
                           }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "COLONCOLON"
    public final void mCOLONCOLON() throws RecognitionException {
        try {
            int _type = COLONCOLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:464:14: ( '::' )
            // ANTLRLexer.g:464:16: '::'
            {
            match("::"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLONCOLON"

    // $ANTLR start "COMMA"
    public final void mCOMMA() throws RecognitionException {
        try {
            int _type = COMMA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:465:14: ( ',' )
            // ANTLRLexer.g:465:16: ','
            {
            match(','); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMA"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:466:14: ( ';' )
            // ANTLRLexer.g:466:16: ';'
            {
            match(';'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:467:14: ( '(' )
            // ANTLRLexer.g:467:16: '('
            {
            match('('); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:468:14: ( ')' )
            // ANTLRLexer.g:468:16: ')'
            {
            match(')'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "RARROW"
    public final void mRARROW() throws RecognitionException {
        try {
            int _type = RARROW;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:469:14: ( '->' )
            // ANTLRLexer.g:469:16: '->'
            {
            match("->"); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RARROW"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:470:14: ( '<' )
            // ANTLRLexer.g:470:16: '<'
            {
            match('<'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:471:14: ( '>' )
            // ANTLRLexer.g:471:16: '>'
            {
            match('>'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:472:14: ( '=' )
            // ANTLRLexer.g:472:16: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "QUESTION"
    public final void mQUESTION() throws RecognitionException {
        try {
            int _type = QUESTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:473:14: ( '?' )
            // ANTLRLexer.g:473:16: '?'
            {
            match('?'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUESTION"

    // $ANTLR start "STAR"
    public final void mSTAR() throws RecognitionException {
        try {
            int _type = STAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:474:14: ( '*' )
            // ANTLRLexer.g:474:16: '*'
            {
            match('*'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STAR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:475:14: ( '+' )
            // ANTLRLexer.g:475:16: '+'
            {
            match('+'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "PLUS_ASSIGN"
    public final void mPLUS_ASSIGN() throws RecognitionException {
        try {
            int _type = PLUS_ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:476:14: ( '+=' )
            // ANTLRLexer.g:476:16: '+='
            {
            match("+="); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS_ASSIGN"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:477:14: ( '|' )
            // ANTLRLexer.g:477:16: '|'
            {
            match('|'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "DOLLAR"
    public final void mDOLLAR() throws RecognitionException {
        try {
            int _type = DOLLAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:478:14: ( '$' )
            // ANTLRLexer.g:478:16: '$'
            {
            match('$'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOLLAR"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            int _type = DOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:479:11: ( '.' )
            // ANTLRLexer.g:479:13: '.'
            {
            match('.'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:480:14: ( '..' )
            // ANTLRLexer.g:480:16: '..'
            {
            match(".."); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "ETC"
    public final void mETC() throws RecognitionException {
        try {
            int _type = ETC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:481:14: ( '...' )
            // ANTLRLexer.g:481:16: '...'
            {
            match("..."); if (state.failed) return ;



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ETC"

    // $ANTLR start "AT"
    public final void mAT() throws RecognitionException {
        try {
            int _type = AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:482:14: ( '@' )
            // ANTLRLexer.g:482:16: '@'
            {
            match('@'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AT"

    // $ANTLR start "POUND"
    public final void mPOUND() throws RecognitionException {
        try {
            int _type = POUND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:483:14: ( '#' )
            // ANTLRLexer.g:483:16: '#'
            {
            match('#'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "POUND"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:484:14: ( '~' )
            // ANTLRLexer.g:484:16: '~'
            {
            match('~'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:485:14: ( '}' )
            // ANTLRLexer.g:485:16: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            int _type = ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken a=null;

            // ANTLRLexer.g:488:6: (a= NameStartChar ( NameChar )* )
            // ANTLRLexer.g:488:8: a= NameStartChar ( NameChar )*
            {
            int aStart3061 = getCharIndex();
            int aStartLine3061 = getLine();
            int aStartCharPos3061 = getCharPositionInLine();
            mNameStartChar(); if (state.failed) return ;
            a = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, aStart3061, getCharIndex()-1);
            a.setLine(aStartLine3061);
            a.setCharPositionInLine(aStartCharPos3061);


            // ANTLRLexer.g:488:24: ( NameChar )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= '0' && LA16_0 <= '9')||(LA16_0 >= 'A' && LA16_0 <= 'Z')||LA16_0=='_'||(LA16_0 >= 'a' && LA16_0 <= 'z')||LA16_0=='\u00B7'||(LA16_0 >= '\u00C0' && LA16_0 <= '\u00D6')||(LA16_0 >= '\u00D8' && LA16_0 <= '\u00F6')||(LA16_0 >= '\u00F8' && LA16_0 <= '\u037D')||(LA16_0 >= '\u037F' && LA16_0 <= '\u1FFF')||(LA16_0 >= '\u200C' && LA16_0 <= '\u200D')||(LA16_0 >= '\u203F' && LA16_0 <= '\u2040')||(LA16_0 >= '\u2070' && LA16_0 <= '\u218F')||(LA16_0 >= '\u2C00' && LA16_0 <= '\u2FEF')||(LA16_0 >= '\u3001' && LA16_0 <= '\uD7FF')||(LA16_0 >= '\uF900' && LA16_0 <= '\uFDCF')||(LA16_0 >= '\uFDF0' && LA16_0 <= '\uFFFD')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ANTLRLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||input.LA(1)=='\u00B7'||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u037D')||(input.LA(1) >= '\u037F' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u200C' && input.LA(1) <= '\u200D')||(input.LA(1) >= '\u203F' && input.LA(1) <= '\u2040')||(input.LA(1) >= '\u2070' && input.LA(1) <= '\u218F')||(input.LA(1) >= '\u2C00' && input.LA(1) <= '\u2FEF')||(input.LA(1) >= '\u3001' && input.LA(1) <= '\uD7FF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFDCF')||(input.LA(1) >= '\uFDF0' && input.LA(1) <= '\uFFFD') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            if ( state.backtracking==0 ) {
            				if ( Character.isUpperCase((a!=null?a.getText():null).charAt(0)) ) _type = TOKEN_REF;
            				else _type = RULE_REF;
            				}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "NameChar"
    public final void mNameChar() throws RecognitionException {
        try {
            // ANTLRLexer.g:496:13: ( NameStartChar | '0' .. '9' | '_' | '\\u00B7' | '\\u0300' .. '\\u036F' | '\\u203F' .. '\\u2040' )
            // ANTLRLexer.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||input.LA(1)=='\u00B7'||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u037D')||(input.LA(1) >= '\u037F' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u200C' && input.LA(1) <= '\u200D')||(input.LA(1) >= '\u203F' && input.LA(1) <= '\u2040')||(input.LA(1) >= '\u2070' && input.LA(1) <= '\u218F')||(input.LA(1) >= '\u2C00' && input.LA(1) <= '\u2FEF')||(input.LA(1) >= '\u3001' && input.LA(1) <= '\uD7FF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFDCF')||(input.LA(1) >= '\uFDF0' && input.LA(1) <= '\uFFFD') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NameChar"

    // $ANTLR start "NameStartChar"
    public final void mNameStartChar() throws RecognitionException {
        try {
            // ANTLRLexer.g:506:13: ( 'A' .. 'Z' | 'a' .. 'z' | '\\u00C0' .. '\\u00D6' | '\\u00D8' .. '\\u00F6' | '\\u00F8' .. '\\u02FF' | '\\u0370' .. '\\u037D' | '\\u037F' .. '\\u1FFF' | '\\u200C' .. '\\u200D' | '\\u2070' .. '\\u218F' | '\\u2C00' .. '\\u2FEF' | '\\u3001' .. '\\uD7FF' | '\\uF900' .. '\\uFDCF' | '\\uFDF0' .. '\\uFFFD' )
            // ANTLRLexer.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z')||(input.LA(1) >= '\u00C0' && input.LA(1) <= '\u00D6')||(input.LA(1) >= '\u00D8' && input.LA(1) <= '\u00F6')||(input.LA(1) >= '\u00F8' && input.LA(1) <= '\u02FF')||(input.LA(1) >= '\u0370' && input.LA(1) <= '\u037D')||(input.LA(1) >= '\u037F' && input.LA(1) <= '\u1FFF')||(input.LA(1) >= '\u200C' && input.LA(1) <= '\u200D')||(input.LA(1) >= '\u2070' && input.LA(1) <= '\u218F')||(input.LA(1) >= '\u2C00' && input.LA(1) <= '\u2FEF')||(input.LA(1) >= '\u3001' && input.LA(1) <= '\uD7FF')||(input.LA(1) >= '\uF900' && input.LA(1) <= '\uFDCF')||(input.LA(1) >= '\uFDF0' && input.LA(1) <= '\uFFFD') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NameStartChar"

    // $ANTLR start "ACTION_CHAR_LITERAL"
    public final void mACTION_CHAR_LITERAL() throws RecognitionException {
        try {
            // ANTLRLexer.g:539:2: ( '\\'' ( ( '\\\\' )=> ACTION_ESC |~ '\\'' )* '\\'' )
            // ANTLRLexer.g:539:4: '\\'' ( ( '\\\\' )=> ACTION_ESC |~ '\\'' )* '\\''
            {
            match('\''); if (state.failed) return ;

            // ANTLRLexer.g:539:9: ( ( '\\\\' )=> ACTION_ESC |~ '\\'' )*
            loop17:
            do {
                int alt17=3;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\\') ) {
                    int LA17_2 = input.LA(2);

                    if ( (LA17_2=='\'') ) {
                        int LA17_4 = input.LA(3);

                        if ( (LA17_4=='\'') && (synpred6_ANTLRLexer())) {
                            alt17=1;
                        }
                        else if ( (LA17_4=='\\') && (synpred6_ANTLRLexer())) {
                            alt17=1;
                        }
                        else if ( ((LA17_4 >= '\u0000' && LA17_4 <= '&')||(LA17_4 >= '(' && LA17_4 <= '[')||(LA17_4 >= ']' && LA17_4 <= '\uFFFF')) && (synpred6_ANTLRLexer())) {
                            alt17=1;
                        }

                        else {
                            alt17=2;
                        }


                    }
                    else if ( (LA17_2=='\\') ) {
                        int LA17_5 = input.LA(3);

                        if ( (synpred6_ANTLRLexer()) ) {
                            alt17=1;
                        }
                        else if ( (true) ) {
                            alt17=2;
                        }


                    }
                    else if ( ((LA17_2 >= '\u0000' && LA17_2 <= '&')||(LA17_2 >= '(' && LA17_2 <= '[')||(LA17_2 >= ']' && LA17_2 <= '\uFFFF')) ) {
                        int LA17_6 = input.LA(3);

                        if ( (synpred6_ANTLRLexer()) ) {
                            alt17=1;
                        }
                        else if ( (true) ) {
                            alt17=2;
                        }


                    }


                }
                else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '&')||(LA17_0 >= '(' && LA17_0 <= '[')||(LA17_0 >= ']' && LA17_0 <= '\uFFFF')) ) {
                    alt17=2;
                }


                switch (alt17) {
            	case 1 :
            	    // ANTLRLexer.g:539:10: ( '\\\\' )=> ACTION_ESC
            	    {
            	    mACTION_ESC(); if (state.failed) return ;


            	    }
            	    break;
            	case 2 :
            	    // ANTLRLexer.g:539:31: ~ '\\''
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACTION_CHAR_LITERAL"

    // $ANTLR start "ACTION_STRING_LITERAL"
    public final void mACTION_STRING_LITERAL() throws RecognitionException {
        try {
            // ANTLRLexer.g:549:2: ( '\"' ( ( '\\\\' )=> ACTION_ESC |~ '\"' )* '\"' )
            // ANTLRLexer.g:549:4: '\"' ( ( '\\\\' )=> ACTION_ESC |~ '\"' )* '\"'
            {
            match('\"'); if (state.failed) return ;

            // ANTLRLexer.g:549:8: ( ( '\\\\' )=> ACTION_ESC |~ '\"' )*
            loop18:
            do {
                int alt18=3;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\\') ) {
                    int LA18_2 = input.LA(2);

                    if ( (LA18_2=='\"') ) {
                        int LA18_4 = input.LA(3);

                        if ( (LA18_4=='\"') && (synpred7_ANTLRLexer())) {
                            alt18=1;
                        }
                        else if ( (LA18_4=='\\') && (synpred7_ANTLRLexer())) {
                            alt18=1;
                        }
                        else if ( ((LA18_4 >= '\u0000' && LA18_4 <= '!')||(LA18_4 >= '#' && LA18_4 <= '[')||(LA18_4 >= ']' && LA18_4 <= '\uFFFF')) && (synpred7_ANTLRLexer())) {
                            alt18=1;
                        }

                        else {
                            alt18=2;
                        }


                    }
                    else if ( (LA18_2=='\\') ) {
                        int LA18_5 = input.LA(3);

                        if ( (synpred7_ANTLRLexer()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }


                    }
                    else if ( ((LA18_2 >= '\u0000' && LA18_2 <= '!')||(LA18_2 >= '#' && LA18_2 <= '[')||(LA18_2 >= ']' && LA18_2 <= '\uFFFF')) ) {
                        int LA18_6 = input.LA(3);

                        if ( (synpred7_ANTLRLexer()) ) {
                            alt18=1;
                        }
                        else if ( (true) ) {
                            alt18=2;
                        }


                    }


                }
                else if ( ((LA18_0 >= '\u0000' && LA18_0 <= '!')||(LA18_0 >= '#' && LA18_0 <= '[')||(LA18_0 >= ']' && LA18_0 <= '\uFFFF')) ) {
                    alt18=2;
                }


                switch (alt18) {
            	case 1 :
            	    // ANTLRLexer.g:549:9: ( '\\\\' )=> ACTION_ESC
            	    {
            	    mACTION_ESC(); if (state.failed) return ;


            	    }
            	    break;
            	case 2 :
            	    // ANTLRLexer.g:549:30: ~ '\"'
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            match('\"'); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACTION_STRING_LITERAL"

    // $ANTLR start "ACTION_ESC"
    public final void mACTION_ESC() throws RecognitionException {
        try {
            // ANTLRLexer.g:559:2: ( '\\\\' . )
            // ANTLRLexer.g:559:4: '\\\\' .
            {
            match('\\'); if (state.failed) return ;

            matchAny(); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACTION_ESC"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:567:5: ( ( '0' .. '9' )+ )
            // ANTLRLexer.g:567:7: ( '0' .. '9' )+
            {
            // ANTLRLexer.g:567:7: ( '0' .. '9' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= '0' && LA19_0 <= '9')) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ANTLRLexer.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "SRC"
    public final void mSRC() throws RecognitionException {
        try {
            CommonToken file=null;
            CommonToken line=null;

            // ANTLRLexer.g:579:5: ( 'src' ( WSCHARS )+ file= ACTION_STRING_LITERAL ( WSCHARS )+ line= INT )
            // ANTLRLexer.g:579:7: 'src' ( WSCHARS )+ file= ACTION_STRING_LITERAL ( WSCHARS )+ line= INT
            {
            match("src"); if (state.failed) return ;



            // ANTLRLexer.g:579:13: ( WSCHARS )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0=='\t'||LA20_0=='\f'||LA20_0==' ') ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ANTLRLexer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);


            int fileStart3613 = getCharIndex();
            int fileStartLine3613 = getLine();
            int fileStartCharPos3613 = getCharPositionInLine();
            mACTION_STRING_LITERAL(); if (state.failed) return ;
            file = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, fileStart3613, getCharIndex()-1);
            file.setLine(fileStartLine3613);
            file.setCharPositionInLine(fileStartCharPos3613);


            // ANTLRLexer.g:579:49: ( WSCHARS )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\t'||LA21_0=='\f'||LA21_0==' ') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ANTLRLexer.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            int lineStart3620 = getCharIndex();
            int lineStartLine3620 = getLine();
            int lineStartCharPos3620 = getCharPositionInLine();
            mINT(); if (state.failed) return ;
            line = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, lineStart3620, getCharIndex()-1);
            line.setLine(lineStartLine3620);
            line.setCharPositionInLine(lineStartCharPos3620);


            if ( state.backtracking==0 ) {
                     // TODO: Add target specific code to change the source file name and current line number
                     //
                  }

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SRC"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;

               int len = 0;

            // ANTLRLexer.g:597:5: ( '\\'' ( ( ESC_SEQ |~ ( '\\\\' | '\\'' ) ) )* '\\'' )
            // ANTLRLexer.g:597:8: '\\'' ( ( ESC_SEQ |~ ( '\\\\' | '\\'' ) ) )* '\\''
            {
            match('\''); if (state.failed) return ;

            // ANTLRLexer.g:597:13: ( ( ESC_SEQ |~ ( '\\\\' | '\\'' ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= '\u0000' && LA23_0 <= '&')||(LA23_0 >= '(' && LA23_0 <= '\uFFFF')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ANTLRLexer.g:597:15: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )
            	    {
            	    // ANTLRLexer.g:597:15: ( ESC_SEQ |~ ( '\\\\' | '\\'' ) )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0=='\\') ) {
            	        alt22=1;
            	    }
            	    else if ( ((LA22_0 >= '\u0000' && LA22_0 <= '&')||(LA22_0 >= '(' && LA22_0 <= '[')||(LA22_0 >= ']' && LA22_0 <= '\uFFFF')) ) {
            	        alt22=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // ANTLRLexer.g:597:17: ESC_SEQ
            	            {
            	            mESC_SEQ(); if (state.failed) return ;


            	            }
            	            break;
            	        case 2 :
            	            // ANTLRLexer.g:597:27: ~ ( '\\\\' | '\\'' )
            	            {
            	            if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '&')||(input.LA(1) >= '(' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	                input.consume();
            	                state.failed=false;
            	            }
            	            else {
            	                if (state.backtracking>0) {state.failed=true; return ;}
            	                MismatchedSetException mse = new MismatchedSetException(null,input);
            	                recover(mse);
            	                throw mse;
            	            }


            	            }
            	            break;

            	    }


            	    if ( state.backtracking==0 ) {len++;}

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            match('\''); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "HEX_DIGIT"
    public final void mHEX_DIGIT() throws RecognitionException {
        try {
            // ANTLRLexer.g:603:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
            // ANTLRLexer.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HEX_DIGIT"

    // $ANTLR start "ESC_SEQ"
    public final void mESC_SEQ() throws RecognitionException {
        try {
            // ANTLRLexer.g:610:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | UNICODE_ESC |) )
            // ANTLRLexer.g:610:7: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | UNICODE_ESC |)
            {
            match('\\'); if (state.failed) return ;

            // ANTLRLexer.g:611:9: ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' | UNICODE_ESC |)
            int alt24=10;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt24=1;
                }
                break;
            case 't':
                {
                alt24=2;
                }
                break;
            case 'n':
                {
                alt24=3;
                }
                break;
            case 'f':
                {
                alt24=4;
                }
                break;
            case 'r':
                {
                alt24=5;
                }
                break;
            case '\"':
                {
                alt24=6;
                }
                break;
            case '\'':
                {
                alt24=7;
                }
                break;
            case '\\':
                {
                alt24=8;
                }
                break;
            case 'u':
                {
                alt24=9;
                }
                break;
            default:
                alt24=10;
            }

            switch (alt24) {
                case 1 :
                    // ANTLRLexer.g:615:9: 'b'
                    {
                    match('b'); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // ANTLRLexer.g:615:13: 't'
                    {
                    match('t'); if (state.failed) return ;

                    }
                    break;
                case 3 :
                    // ANTLRLexer.g:615:17: 'n'
                    {
                    match('n'); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // ANTLRLexer.g:615:21: 'f'
                    {
                    match('f'); if (state.failed) return ;

                    }
                    break;
                case 5 :
                    // ANTLRLexer.g:615:25: 'r'
                    {
                    match('r'); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // ANTLRLexer.g:615:29: '\\\"'
                    {
                    match('\"'); if (state.failed) return ;

                    }
                    break;
                case 7 :
                    // ANTLRLexer.g:615:34: '\\''
                    {
                    match('\''); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // ANTLRLexer.g:615:39: '\\\\'
                    {
                    match('\\'); if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // ANTLRLexer.g:619:12: UNICODE_ESC
                    {
                    mUNICODE_ESC(); if (state.failed) return ;


                    }
                    break;
                case 10 :
                    // ANTLRLexer.g:623:12: 
                    {
                    if ( state.backtracking==0 ) {
                        	      	// TODO: Issue error message
                        	      	//
                        	      }

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ESC_SEQ"

    // $ANTLR start "UNICODE_ESC"
    public final void mUNICODE_ESC() throws RecognitionException {
        try {


            	// Flag to tell us whether we have a valid number of
            	// hex digits in the escape sequence
            	//
            	int	hCount = 0;

            // ANTLRLexer.g:640:5: ( 'u' ( ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |) |) ) |) )
            // ANTLRLexer.g:640:9: 'u' ( ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |) |) ) |)
            {
            match('u'); if (state.failed) return ;

            // ANTLRLexer.g:649:6: ( ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |) |) ) |)
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0 >= '0' && LA28_0 <= '9')||(LA28_0 >= 'A' && LA28_0 <= 'F')||(LA28_0 >= 'a' && LA28_0 <= 'f')) ) {
                alt28=1;
            }
            else {
                alt28=2;
            }
            switch (alt28) {
                case 1 :
                    // ANTLRLexer.g:650:9: ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |) |) )
                    {
                    // ANTLRLexer.g:650:9: ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |) |) )
                    // ANTLRLexer.g:651:12: HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |) |)
                    {
                    mHEX_DIGIT(); if (state.failed) return ;


                    if ( state.backtracking==0 ) { hCount++; }

                    // ANTLRLexer.g:652:14: ( HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |) |)
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( ((LA27_0 >= '0' && LA27_0 <= '9')||(LA27_0 >= 'A' && LA27_0 <= 'F')||(LA27_0 >= 'a' && LA27_0 <= 'f')) ) {
                        alt27=1;
                    }
                    else {
                        alt27=2;
                    }
                    switch (alt27) {
                        case 1 :
                            // ANTLRLexer.g:653:19: HEX_DIGIT ( HEX_DIGIT ( HEX_DIGIT |) |)
                            {
                            mHEX_DIGIT(); if (state.failed) return ;


                            if ( state.backtracking==0 ) { hCount++; }

                            // ANTLRLexer.g:654:16: ( HEX_DIGIT ( HEX_DIGIT |) |)
                            int alt26=2;
                            int LA26_0 = input.LA(1);

                            if ( ((LA26_0 >= '0' && LA26_0 <= '9')||(LA26_0 >= 'A' && LA26_0 <= 'F')||(LA26_0 >= 'a' && LA26_0 <= 'f')) ) {
                                alt26=1;
                            }
                            else {
                                alt26=2;
                            }
                            switch (alt26) {
                                case 1 :
                                    // ANTLRLexer.g:655:21: HEX_DIGIT ( HEX_DIGIT |)
                                    {
                                    mHEX_DIGIT(); if (state.failed) return ;


                                    if ( state.backtracking==0 ) { hCount++; }

                                    // ANTLRLexer.g:656:21: ( HEX_DIGIT |)
                                    int alt25=2;
                                    int LA25_0 = input.LA(1);

                                    if ( ((LA25_0 >= '0' && LA25_0 <= '9')||(LA25_0 >= 'A' && LA25_0 <= 'F')||(LA25_0 >= 'a' && LA25_0 <= 'f')) ) {
                                        alt25=1;
                                    }
                                    else {
                                        alt25=2;
                                    }
                                    switch (alt25) {
                                        case 1 :
                                            // ANTLRLexer.g:659:25: HEX_DIGIT
                                            {
                                            mHEX_DIGIT(); if (state.failed) return ;


                                            if ( state.backtracking==0 ) { hCount++; }

                                            }
                                            break;
                                        case 2 :
                                            // ANTLRLexer.g:662:21: 
                                            {
                                            }
                                            break;

                                    }


                                    }
                                    break;
                                case 2 :
                                    // ANTLRLexer.g:665:17: 
                                    {
                                    }
                                    break;

                            }


                            }
                            break;
                        case 2 :
                            // ANTLRLexer.g:668:11: 
                            {
                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ANTLRLexer.g:671:6: 
                    {
                    }
                    break;

            }


            if ( state.backtracking==0 ) {
                		if	(hCount != 4) {

                			// TODO: Issue error message
                		}
                	}

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UNICODE_ESC"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:691:5: ( ( ' ' | '\\t' | '\\r' | '\\n' | '\\f' )+ )
            // ANTLRLexer.g:691:7: ( ' ' | '\\t' | '\\r' | '\\n' | '\\f' )+
            {
            // ANTLRLexer.g:691:7: ( ' ' | '\\t' | '\\r' | '\\n' | '\\f' )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0 >= '\t' && LA29_0 <= '\n')||(LA29_0 >= '\f' && LA29_0 <= '\r')||LA29_0==' ') ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ANTLRLexer.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            if ( state.backtracking==0 ) {_channel=HIDDEN;}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "NLCHARS"
    public final void mNLCHARS() throws RecognitionException {
        try {
            // ANTLRLexer.g:706:5: ( '\\n' | '\\r' )
            // ANTLRLexer.g:
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NLCHARS"

    // $ANTLR start "WSCHARS"
    public final void mWSCHARS() throws RecognitionException {
        try {
            // ANTLRLexer.g:714:5: ( ' ' | '\\t' | '\\f' )
            // ANTLRLexer.g:
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WSCHARS"

    // $ANTLR start "WSNLCHARS"
    public final void mWSNLCHARS() throws RecognitionException {
        try {
            // ANTLRLexer.g:723:5: ( ' ' | '\\t' | '\\f' | '\\n' | '\\r' )
            // ANTLRLexer.g:
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WSNLCHARS"

    // $ANTLR start "ERRCHAR"
    public final void mERRCHAR() throws RecognitionException {
        try {
            int _type = ERRCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ANTLRLexer.g:738:5: ( . )
            // ANTLRLexer.g:738:7: .
            {
            matchAny(); if (state.failed) return ;

            if ( state.backtracking==0 ) {
                     // TODO: Issue error message
                     //
                     skip();
                  }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ERRCHAR"

    public void mTokens() throws RecognitionException {
        // ANTLRLexer.g:1:8: ( COMMENT | ARG_OR_CHARSET | ACTION | OPTIONS | TOKENS_SPEC | IMPORT | FRAGMENT | LEXER | PARSER | GRAMMAR | PROTECTED | PUBLIC | PRIVATE | RETURNS | LOCALS | THROWS | CATCH | FINALLY | MODE | COLON | COLONCOLON | COMMA | SEMI | LPAREN | RPAREN | RARROW | LT | GT | ASSIGN | QUESTION | STAR | PLUS | PLUS_ASSIGN | OR | DOLLAR | DOT | RANGE | ETC | AT | POUND | NOT | RBRACE | ID | INT | STRING_LITERAL | WS | ERRCHAR )
        int alt30=47;
        alt30 = dfa30.predict(input);
        switch (alt30) {
            case 1 :
                // ANTLRLexer.g:1:10: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;


                }
                break;
            case 2 :
                // ANTLRLexer.g:1:18: ARG_OR_CHARSET
                {
                mARG_OR_CHARSET(); if (state.failed) return ;


                }
                break;
            case 3 :
                // ANTLRLexer.g:1:33: ACTION
                {
                mACTION(); if (state.failed) return ;


                }
                break;
            case 4 :
                // ANTLRLexer.g:1:40: OPTIONS
                {
                mOPTIONS(); if (state.failed) return ;


                }
                break;
            case 5 :
                // ANTLRLexer.g:1:48: TOKENS_SPEC
                {
                mTOKENS_SPEC(); if (state.failed) return ;


                }
                break;
            case 6 :
                // ANTLRLexer.g:1:60: IMPORT
                {
                mIMPORT(); if (state.failed) return ;


                }
                break;
            case 7 :
                // ANTLRLexer.g:1:67: FRAGMENT
                {
                mFRAGMENT(); if (state.failed) return ;


                }
                break;
            case 8 :
                // ANTLRLexer.g:1:76: LEXER
                {
                mLEXER(); if (state.failed) return ;


                }
                break;
            case 9 :
                // ANTLRLexer.g:1:82: PARSER
                {
                mPARSER(); if (state.failed) return ;


                }
                break;
            case 10 :
                // ANTLRLexer.g:1:89: GRAMMAR
                {
                mGRAMMAR(); if (state.failed) return ;


                }
                break;
            case 11 :
                // ANTLRLexer.g:1:97: PROTECTED
                {
                mPROTECTED(); if (state.failed) return ;


                }
                break;
            case 12 :
                // ANTLRLexer.g:1:107: PUBLIC
                {
                mPUBLIC(); if (state.failed) return ;


                }
                break;
            case 13 :
                // ANTLRLexer.g:1:114: PRIVATE
                {
                mPRIVATE(); if (state.failed) return ;


                }
                break;
            case 14 :
                // ANTLRLexer.g:1:122: RETURNS
                {
                mRETURNS(); if (state.failed) return ;


                }
                break;
            case 15 :
                // ANTLRLexer.g:1:130: LOCALS
                {
                mLOCALS(); if (state.failed) return ;


                }
                break;
            case 16 :
                // ANTLRLexer.g:1:137: THROWS
                {
                mTHROWS(); if (state.failed) return ;


                }
                break;
            case 17 :
                // ANTLRLexer.g:1:144: CATCH
                {
                mCATCH(); if (state.failed) return ;


                }
                break;
            case 18 :
                // ANTLRLexer.g:1:150: FINALLY
                {
                mFINALLY(); if (state.failed) return ;


                }
                break;
            case 19 :
                // ANTLRLexer.g:1:158: MODE
                {
                mMODE(); if (state.failed) return ;


                }
                break;
            case 20 :
                // ANTLRLexer.g:1:163: COLON
                {
                mCOLON(); if (state.failed) return ;


                }
                break;
            case 21 :
                // ANTLRLexer.g:1:169: COLONCOLON
                {
                mCOLONCOLON(); if (state.failed) return ;


                }
                break;
            case 22 :
                // ANTLRLexer.g:1:180: COMMA
                {
                mCOMMA(); if (state.failed) return ;


                }
                break;
            case 23 :
                // ANTLRLexer.g:1:186: SEMI
                {
                mSEMI(); if (state.failed) return ;


                }
                break;
            case 24 :
                // ANTLRLexer.g:1:191: LPAREN
                {
                mLPAREN(); if (state.failed) return ;


                }
                break;
            case 25 :
                // ANTLRLexer.g:1:198: RPAREN
                {
                mRPAREN(); if (state.failed) return ;


                }
                break;
            case 26 :
                // ANTLRLexer.g:1:205: RARROW
                {
                mRARROW(); if (state.failed) return ;


                }
                break;
            case 27 :
                // ANTLRLexer.g:1:212: LT
                {
                mLT(); if (state.failed) return ;


                }
                break;
            case 28 :
                // ANTLRLexer.g:1:215: GT
                {
                mGT(); if (state.failed) return ;


                }
                break;
            case 29 :
                // ANTLRLexer.g:1:218: ASSIGN
                {
                mASSIGN(); if (state.failed) return ;


                }
                break;
            case 30 :
                // ANTLRLexer.g:1:225: QUESTION
                {
                mQUESTION(); if (state.failed) return ;


                }
                break;
            case 31 :
                // ANTLRLexer.g:1:234: STAR
                {
                mSTAR(); if (state.failed) return ;


                }
                break;
            case 32 :
                // ANTLRLexer.g:1:239: PLUS
                {
                mPLUS(); if (state.failed) return ;


                }
                break;
            case 33 :
                // ANTLRLexer.g:1:244: PLUS_ASSIGN
                {
                mPLUS_ASSIGN(); if (state.failed) return ;


                }
                break;
            case 34 :
                // ANTLRLexer.g:1:256: OR
                {
                mOR(); if (state.failed) return ;


                }
                break;
            case 35 :
                // ANTLRLexer.g:1:259: DOLLAR
                {
                mDOLLAR(); if (state.failed) return ;


                }
                break;
            case 36 :
                // ANTLRLexer.g:1:266: DOT
                {
                mDOT(); if (state.failed) return ;


                }
                break;
            case 37 :
                // ANTLRLexer.g:1:270: RANGE
                {
                mRANGE(); if (state.failed) return ;


                }
                break;
            case 38 :
                // ANTLRLexer.g:1:276: ETC
                {
                mETC(); if (state.failed) return ;


                }
                break;
            case 39 :
                // ANTLRLexer.g:1:280: AT
                {
                mAT(); if (state.failed) return ;


                }
                break;
            case 40 :
                // ANTLRLexer.g:1:283: POUND
                {
                mPOUND(); if (state.failed) return ;


                }
                break;
            case 41 :
                // ANTLRLexer.g:1:289: NOT
                {
                mNOT(); if (state.failed) return ;


                }
                break;
            case 42 :
                // ANTLRLexer.g:1:293: RBRACE
                {
                mRBRACE(); if (state.failed) return ;


                }
                break;
            case 43 :
                // ANTLRLexer.g:1:300: ID
                {
                mID(); if (state.failed) return ;


                }
                break;
            case 44 :
                // ANTLRLexer.g:1:303: INT
                {
                mINT(); if (state.failed) return ;


                }
                break;
            case 45 :
                // ANTLRLexer.g:1:307: STRING_LITERAL
                {
                mSTRING_LITERAL(); if (state.failed) return ;


                }
                break;
            case 46 :
                // ANTLRLexer.g:1:322: WS
                {
                mWS(); if (state.failed) return ;


                }
                break;
            case 47 :
                // ANTLRLexer.g:1:325: ERRCHAR
                {
                mERRCHAR(); if (state.failed) return ;


                }
                break;

        }

    }

    // $ANTLR start synpred1_ANTLRLexer
    public final void synpred1_ANTLRLexer_fragment() throws RecognitionException {
        // ANTLRLexer.g:181:17: ( ' $ANTLR' )
        // ANTLRLexer.g:181:18: ' $ANTLR'
        {
        match(" $ANTLR"); if (state.failed) return ;



        }

    }
    // $ANTLR end synpred1_ANTLRLexer

    // $ANTLR start synpred2_ANTLRLexer
    public final void synpred2_ANTLRLexer_fragment() throws RecognitionException {
        // ANTLRLexer.g:270:14: ( '\\\\' )
        // ANTLRLexer.g:270:15: '\\\\'
        {
        match('\\'); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_ANTLRLexer

    // $ANTLR start synpred3_ANTLRLexer
    public final void synpred3_ANTLRLexer_fragment() throws RecognitionException {
        // ANTLRLexer.g:272:22: ( ']' )
        // ANTLRLexer.g:272:23: ']'
        {
        match(']'); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_ANTLRLexer

    // $ANTLR start synpred4_ANTLRLexer
    public final void synpred4_ANTLRLexer_fragment() throws RecognitionException {
        // ANTLRLexer.g:287:14: ( '\"' )
        // ANTLRLexer.g:287:15: '\"'
        {
        match('\"'); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_ANTLRLexer

    // $ANTLR start synpred5_ANTLRLexer
    public final void synpred5_ANTLRLexer_fragment() throws RecognitionException {
        // ANTLRLexer.g:294:14: ( '\\'' )
        // ANTLRLexer.g:294:15: '\\''
        {
        match('\''); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_ANTLRLexer

    // $ANTLR start synpred6_ANTLRLexer
    public final void synpred6_ANTLRLexer_fragment() throws RecognitionException {
        // ANTLRLexer.g:539:10: ( '\\\\' )
        // ANTLRLexer.g:539:11: '\\\\'
        {
        match('\\'); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred6_ANTLRLexer

    // $ANTLR start synpred7_ANTLRLexer
    public final void synpred7_ANTLRLexer_fragment() throws RecognitionException {
        // ANTLRLexer.g:549:9: ( '\\\\' )
        // ANTLRLexer.g:549:10: '\\\\'
        {
        match('\\'); if (state.failed) return ;

        }

    }
    // $ANTLR end synpred7_ANTLRLexer

    public final boolean synpred5_ANTLRLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_ANTLRLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_ANTLRLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_ANTLRLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_ANTLRLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_ANTLRLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_ANTLRLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_ANTLRLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_ANTLRLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ANTLRLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ANTLRLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ANTLRLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_ANTLRLexer() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ANTLRLexer_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA10 dfa10 = new DFA10(this);
    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA2_eotS =
        "\2\2\1\uffff\16\2\1\uffff\3\2\1\uffff\2\2\2\uffff";
    static final String DFA2_eofS =
        "\32\uffff";
    static final String DFA2_minS =
        "\1\40\1\44\1\uffff\1\101\1\116\1\124\1\114\1\122\1\163\1\162\1\143"+
        "\2\11\3\0\1\11\1\uffff\3\0\1\uffff\1\11\3\0";
    static final String DFA2_maxS =
        "\1\40\1\44\1\uffff\1\101\1\116\1\124\1\114\1\122\1\163\1\162\1\143"+
        "\1\40\1\42\3\uffff\1\40\1\uffff\3\uffff\1\uffff\1\71\1\uffff\2\0";
    static final String DFA2_acceptS =
        "\2\uffff\1\2\16\uffff\1\1\3\uffff\1\1\4\uffff";
    static final String DFA2_specialS =
        "\15\uffff\1\4\1\6\1\5\2\uffff\1\10\1\2\1\1\2\uffff\1\0\1\3\1\7}>";
    static final String[] DFA2_transitionS = {
            "\1\1",
            "\1\3",
            "",
            "\1\4",
            "\1\5",
            "\1\6",
            "\1\7",
            "\1\10",
            "\1\11",
            "\1\12",
            "\1\13",
            "\1\14\2\uffff\1\14\23\uffff\1\14",
            "\1\14\2\uffff\1\14\23\uffff\1\14\1\uffff\1\15",
            "\12\17\1\21\2\17\1\21\24\17\1\20\71\17\1\16\uffa3\17",
            "\12\24\1\25\2\24\1\25\24\24\1\22\71\24\1\23\uffa3\24",
            "\12\17\1\21\2\17\1\21\24\17\1\20\71\17\1\16\uffa3\17",
            "\1\26\2\uffff\1\26\23\uffff\1\26",
            "",
            "\11\17\1\27\1\21\1\17\1\27\1\21\22\17\1\27\1\17\1\20\71\17"+
            "\1\16\uffa3\17",
            "\12\24\1\25\2\24\1\25\24\24\1\22\71\24\1\23\uffa3\24",
            "\12\17\1\21\2\17\1\21\24\17\1\20\71\17\1\16\uffa3\17",
            "",
            "\1\26\2\uffff\1\26\23\uffff\1\26\17\uffff\12\30",
            "\11\17\1\27\1\21\1\17\1\27\1\21\22\17\1\27\1\17\1\20\15\17"+
            "\12\31\42\17\1\16\uffa3\17",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "180:13: ( ( ' $ANTLR' )=> ' $ANTLR' SRC | (~ ( NLCHARS ) )* )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA2_23 = input.LA(1);

                         
                        int index2_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_23=='\"') ) {s = 16;}

                        else if ( (LA2_23=='\\') ) {s = 14;}

                        else if ( ((LA2_23 >= '0' && LA2_23 <= '9')) ) {s = 25;}

                        else if ( (LA2_23=='\t'||LA2_23=='\f'||LA2_23==' ') ) {s = 23;}

                        else if ( ((LA2_23 >= '\u0000' && LA2_23 <= '\b')||LA2_23=='\u000B'||(LA2_23 >= '\u000E' && LA2_23 <= '\u001F')||LA2_23=='!'||(LA2_23 >= '#' && LA2_23 <= '/')||(LA2_23 >= ':' && LA2_23 <= '[')||(LA2_23 >= ']' && LA2_23 <= '\uFFFF')) ) {s = 15;}

                        else if ( (LA2_23=='\n'||LA2_23=='\r') && (synpred1_ANTLRLexer())) {s = 17;}

                        else s = 2;

                         
                        input.seek(index2_23);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA2_20 = input.LA(1);

                         
                        int index2_20 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_20=='\"') ) {s = 16;}

                        else if ( (LA2_20=='\\') ) {s = 14;}

                        else if ( ((LA2_20 >= '\u0000' && LA2_20 <= '\t')||(LA2_20 >= '\u000B' && LA2_20 <= '\f')||(LA2_20 >= '\u000E' && LA2_20 <= '!')||(LA2_20 >= '#' && LA2_20 <= '[')||(LA2_20 >= ']' && LA2_20 <= '\uFFFF')) ) {s = 15;}

                        else if ( (LA2_20=='\n'||LA2_20=='\r') && (synpred1_ANTLRLexer())) {s = 17;}

                        else s = 2;

                         
                        input.seek(index2_20);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA2_19 = input.LA(1);

                         
                        int index2_19 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_19=='\"') ) {s = 18;}

                        else if ( (LA2_19=='\\') ) {s = 19;}

                        else if ( ((LA2_19 >= '\u0000' && LA2_19 <= '\t')||(LA2_19 >= '\u000B' && LA2_19 <= '\f')||(LA2_19 >= '\u000E' && LA2_19 <= '!')||(LA2_19 >= '#' && LA2_19 <= '[')||(LA2_19 >= ']' && LA2_19 <= '\uFFFF')) ) {s = 20;}

                        else if ( (LA2_19=='\n'||LA2_19=='\r') && (synpred1_ANTLRLexer())) {s = 21;}

                        else s = 2;

                         
                        input.seek(index2_19);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA2_24 = input.LA(1);

                         
                        int index2_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_ANTLRLexer()) ) {s = 21;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index2_24);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA2_13 = input.LA(1);

                         
                        int index2_13 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_13=='\\') ) {s = 14;}

                        else if ( ((LA2_13 >= '\u0000' && LA2_13 <= '\t')||(LA2_13 >= '\u000B' && LA2_13 <= '\f')||(LA2_13 >= '\u000E' && LA2_13 <= '!')||(LA2_13 >= '#' && LA2_13 <= '[')||(LA2_13 >= ']' && LA2_13 <= '\uFFFF')) ) {s = 15;}

                        else if ( (LA2_13=='\"') ) {s = 16;}

                        else if ( (LA2_13=='\n'||LA2_13=='\r') && (synpred1_ANTLRLexer())) {s = 17;}

                        else s = 2;

                         
                        input.seek(index2_13);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA2_15 = input.LA(1);

                         
                        int index2_15 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_15=='\"') ) {s = 16;}

                        else if ( (LA2_15=='\\') ) {s = 14;}

                        else if ( ((LA2_15 >= '\u0000' && LA2_15 <= '\t')||(LA2_15 >= '\u000B' && LA2_15 <= '\f')||(LA2_15 >= '\u000E' && LA2_15 <= '!')||(LA2_15 >= '#' && LA2_15 <= '[')||(LA2_15 >= ']' && LA2_15 <= '\uFFFF')) ) {s = 15;}

                        else if ( (LA2_15=='\n'||LA2_15=='\r') && (synpred1_ANTLRLexer())) {s = 17;}

                        else s = 2;

                         
                        input.seek(index2_15);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA2_14 = input.LA(1);

                         
                        int index2_14 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_14=='\"') ) {s = 18;}

                        else if ( (LA2_14=='\\') ) {s = 19;}

                        else if ( ((LA2_14 >= '\u0000' && LA2_14 <= '\t')||(LA2_14 >= '\u000B' && LA2_14 <= '\f')||(LA2_14 >= '\u000E' && LA2_14 <= '!')||(LA2_14 >= '#' && LA2_14 <= '[')||(LA2_14 >= ']' && LA2_14 <= '\uFFFF')) ) {s = 20;}

                        else if ( (LA2_14=='\n'||LA2_14=='\r') && (synpred1_ANTLRLexer())) {s = 21;}

                        else s = 2;

                         
                        input.seek(index2_14);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA2_25 = input.LA(1);

                         
                        int index2_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred1_ANTLRLexer()) ) {s = 21;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index2_25);

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA2_18 = input.LA(1);

                         
                        int index2_18 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA2_18=='\"') ) {s = 16;}

                        else if ( (LA2_18=='\\') ) {s = 14;}

                        else if ( (LA2_18=='\t'||LA2_18=='\f'||LA2_18==' ') ) {s = 23;}

                        else if ( ((LA2_18 >= '\u0000' && LA2_18 <= '\b')||LA2_18=='\u000B'||(LA2_18 >= '\u000E' && LA2_18 <= '\u001F')||LA2_18=='!'||(LA2_18 >= '#' && LA2_18 <= '[')||(LA2_18 >= ']' && LA2_18 <= '\uFFFF')) ) {s = 15;}

                        else if ( (LA2_18=='\n'||LA2_18=='\r') && (synpred1_ANTLRLexer())) {s = 17;}

                        else s = 2;

                         
                        input.seek(index2_18);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 2, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA10_eotS =
        "\6\uffff\1\5\5\uffff\1\5\4\uffff\1\5\12\uffff\1\5\7\uffff\1\5\5"+
        "\uffff\1\5\7\uffff\1\5\12\uffff\1\5\16\uffff\1\5\13\uffff\1\160"+
        "\15\uffff\1\176\12\uffff\1\160\5\uffff\1\160\7\uffff\1\176\5\uffff"+
        "\1\176\14\uffff\1\160\12\uffff\1\176\14\uffff";
    static final String DFA10_eofS =
        "\u00aa\uffff";
    static final String DFA10_minS =
        "\1\0\1\uffff\3\0\1\uffff\17\0\5\uffff\5\0\3\uffff\13\0\3\uffff\100"+
        "\0\1\uffff\15\0\1\uffff\53\0";
    static final String DFA10_maxS =
        "\1\uffff\1\uffff\3\uffff\1\uffff\1\uffff\4\0\2\uffff\1\0\4\uffff"+
        "\1\0\2\uffff\5\uffff\1\0\4\uffff\3\uffff\1\0\4\uffff\2\0\4\uffff"+
        "\3\uffff\1\0\4\uffff\6\0\10\uffff\7\0\10\uffff\6\0\3\uffff\1\0\5"+
        "\uffff\5\0\2\uffff\1\0\6\uffff\1\0\1\uffff\3\uffff\1\0\4\uffff\1"+
        "\0\1\uffff\3\0\1\uffff\2\uffff\1\0\5\uffff\1\0\1\uffff\7\0\3\uffff"+
        "\1\0\1\uffff\6\0\3\uffff\1\0\1\uffff\12\0";
    static final String DFA10_acceptS =
        "\1\uffff\1\5\3\uffff\1\4\17\uffff\5\1\5\uffff\3\2\13\uffff\3\3\100"+
        "\uffff\1\2\15\uffff\1\3\53\uffff";
    static final String DFA10_specialS =
        "\1\145\1\uffff\1\u009a\1\70\1\u0099\1\uffff\1\103\1\131\1\76\1\113"+
        "\1\147\1\67\1\31\1\36\1\106\1\143\1\154\1\142\1\135\1\7\1\151\5"+
        "\uffff\1\5\1\63\1\24\1\105\1\122\3\uffff\1\u008f\1\4\1\161\1\134"+
        "\1\167\1\35\1\165\1\160\1\55\1\73\1\3\3\uffff\1\u0089\1\1\1\u0083"+
        "\1\150\1\155\1\136\1\6\1\37\1\u0090\1\40\1\u0081\1\126\1\170\1\116"+
        "\1\61\1\25\1\32\1\110\1\65\1\u0091\1\u0092\1\166\1\137\1\u008a\1"+
        "\140\1\77\1\115\1\162\1\146\1\47\1\112\1\10\1\107\1\22\1\u008b\1"+
        "\u008c\1\u0082\1\u0093\1\u0094\1\u0095\1\141\1\33\1\60\1\50\1\11"+
        "\1\120\1\u0096\1\64\1\41\1\34\1\75\1\u0088\1\u0087\1\u0086\1\56"+
        "\1\66\1\54\1\72\1\144\1\57\1\2\1\42\1\101\1\133\1\uffff\1\71\1\111"+
        "\1\125\1\u0098\1\102\1\43\1\163\1\117\1\21\1\114\1\46\1\20\1\u008e"+
        "\1\uffff\1\26\1\62\1\157\1\100\1\123\1\23\1\u008d\1\124\1\u0080"+
        "\1\u0084\1\53\1\177\1\u0085\1\45\1\u0097\1\17\1\44\1\30\1\164\1"+
        "\104\1\130\1\0\1\16\1\15\1\52\1\156\1\176\1\51\1\27\1\132\1\121"+
        "\1\153\1\74\1\175\1\174\1\14\1\127\1\13\1\12\1\173\1\152\1\172\1"+
        "\171}>";
    static final String[] DFA10_transitionS = {
            "\42\5\1\3\4\5\1\4\64\5\1\2\1\1\uffa2\5",
            "",
            "\42\12\1\10\4\12\1\11\64\12\1\7\1\6\uffa2\12",
            "\42\17\1\15\4\17\1\16\64\17\1\13\1\14\uffa2\17",
            "\42\24\1\23\4\24\1\22\64\24\1\20\1\21\uffa2\24",
            "",
            "\42\31\1\27\4\31\1\30\64\31\1\26\1\25\uffa2\31",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\42\36\1\32\4\36\1\35\64\36\1\33\1\34\uffa2\36",
            "\42\41\1\37\71\41\1\40\uffa3\41",
            "\1\uffff",
            "\42\46\1\42\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\42\17\1\47\4\17\1\16\64\17\1\13\1\14\uffa2\17",
            "\42\54\1\53\4\54\1\50\64\54\1\51\1\52\uffa2\54",
            "\47\57\1\55\64\57\1\56\uffa3\57",
            "\1\uffff",
            "\42\64\1\63\4\64\1\60\64\64\1\61\1\62\uffa2\64",
            "\42\24\1\23\4\24\1\65\64\24\1\20\1\21\uffa2\24",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\42\36\1\66\4\36\1\35\64\36\1\33\1\34\uffa2\36",
            "\42\17\1\67\4\17\1\16\64\17\1\13\1\14\uffa2\17",
            "\42\46\1\70\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\42\17\1\71\4\17\1\16\64\17\1\13\1\14\uffa2\17",
            "",
            "",
            "",
            "\1\uffff",
            "\42\76\1\72\4\76\1\74\64\76\1\73\1\75\uffa2\76",
            "\42\102\1\77\4\102\1\101\64\102\1\100\uffa3\102",
            "\42\46\1\103\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\42\46\1\104\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\1\uffff",
            "\1\uffff",
            "\42\54\1\53\4\54\1\105\64\54\1\51\1\52\uffa2\54",
            "\42\24\1\23\4\24\1\106\64\24\1\20\1\21\uffa2\24",
            "\42\64\1\63\4\64\1\107\64\64\1\61\1\62\uffa2\64",
            "\42\24\1\23\4\24\1\110\64\24\1\20\1\21\uffa2\24",
            "",
            "",
            "",
            "\1\uffff",
            "\42\115\1\113\4\115\1\111\64\115\1\112\1\114\uffa2\115",
            "\42\121\1\120\4\121\1\116\64\121\1\117\uffa3\121",
            "\42\64\1\63\4\64\1\122\64\64\1\61\1\62\uffa2\64",
            "\42\64\1\63\4\64\1\123\64\64\1\61\1\62\uffa2\64",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\42\76\1\124\4\76\1\74\64\76\1\73\1\75\uffa2\76",
            "\42\46\1\125\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\42\46\1\126\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\42\46\1\127\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\42\134\1\132\4\134\1\133\64\134\1\131\1\130\uffa2\134",
            "\42\140\1\135\4\140\1\137\64\140\1\136\uffa3\140",
            "\42\17\1\141\4\17\1\16\64\17\1\13\1\14\uffa2\17",
            "\42\102\1\77\4\102\1\101\64\102\1\100\uffa3\102",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\42\115\1\113\4\115\1\142\64\115\1\112\1\114\uffa2\115",
            "\42\64\1\63\4\64\1\143\64\64\1\61\1\62\uffa2\64",
            "\42\64\1\63\4\64\1\144\64\64\1\61\1\62\uffa2\64",
            "\42\64\1\63\4\64\1\145\64\64\1\61\1\62\uffa2\64",
            "\42\152\1\150\4\152\1\151\64\152\1\147\1\146\uffa2\152",
            "\42\156\1\155\4\156\1\153\64\156\1\154\uffa3\156",
            "\42\24\1\23\4\24\1\157\64\24\1\20\1\21\uffa2\24",
            "\42\121\1\120\4\121\1\116\64\121\1\117\uffa3\121",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\0\5",
            "\42\165\1\163\4\165\1\164\64\165\1\162\1\161\uffa2\165",
            "\42\172\1\170\4\172\1\171\64\172\1\166\1\167\uffa2\172",
            "\1\uffff",
            "\42\134\1\132\4\134\1\173\64\134\1\131\1\130\uffa2\134",
            "\42\172\1\170\4\172\1\174\64\172\1\166\1\167\uffa2\172",
            "\42\140\1\135\4\140\1\137\64\140\1\136\uffa3\140",
            "\42\46\1\175\4\46\1\45\64\46\1\43\1\44\uffa2\46",
            "\42\102\1\77\4\102\1\101\64\102\1\100\uffa3\102",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\0\5",
            "\42\u0083\1\u0081\4\u0083\1\u0082\64\u0083\1\u0080\1\177\uffa2"+
            "\u0083",
            "\1\uffff",
            "\42\u0088\1\u0087\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\42\152\1\u0089\4\152\1\151\64\152\1\147\1\146\uffa2\152",
            "\42\u0088\1\u008a\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\42\156\1\155\4\156\1\153\64\156\1\154\uffa3\156",
            "\42\64\1\63\4\64\1\u008b\64\64\1\61\1\62\uffa2\64",
            "\42\121\1\120\4\121\1\116\64\121\1\117\uffa3\121",
            "\1\uffff",
            "",
            "\42\134\1\132\4\134\1\u008c\64\134\1\131\1\130\uffa2\134",
            "\42\165\1\163\4\165\1\u008d\64\165\1\162\1\161\uffa2\165",
            "\42\172\1\170\4\172\1\u008e\64\172\1\166\1\167\uffa2\172",
            "\1\uffff",
            "\42\134\1\132\4\134\1\u008f\64\134\1\131\1\130\uffa2\134",
            "\42\u0094\1\u0090\4\u0094\1\u0093\64\u0094\1\u0091\1\u0092"+
            "\uffa2\u0094",
            "\42\102\1\77\4\102\1\101\64\102\1\100\uffa3\102",
            "\42\172\1\170\4\172\1\u0095\64\172\1\166\1\167\uffa2\172",
            "\1\uffff",
            "\42\172\1\170\4\172\1\u0096\64\172\1\166\1\167\uffa2\172",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "\42\152\1\u0097\4\152\1\151\64\152\1\147\1\146\uffa2\152",
            "\42\u0083\1\u0098\4\u0083\1\u0082\64\u0083\1\u0080\1\177\uffa2"+
            "\u0083",
            "\1\uffff",
            "\42\u0088\1\u0099\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\42\152\1\u009a\4\152\1\151\64\152\1\147\1\146\uffa2\152",
            "\42\u009f\1\u009e\4\u009f\1\u009b\64\u009f\1\u009c\1\u009d"+
            "\uffa2\u009f",
            "\42\121\1\120\4\121\1\116\64\121\1\117\uffa3\121",
            "\42\u0088\1\u00a0\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\1\uffff",
            "\42\u0088\1\u00a1\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\42\172\1\170\4\172\1\u00a2\64\172\1\166\1\167\uffa2\172",
            "\42\u0094\1\u0090\4\u0094\1\u00a3\64\u0094\1\u0091\1\u0092"+
            "\uffa2\u0094",
            "\42\172\1\170\4\172\1\u00a4\64\172\1\166\1\167\uffa2\172",
            "\1\uffff",
            "\42\172\1\170\4\172\1\u00a5\64\172\1\166\1\167\uffa2\172",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\42\u0088\1\u00a6\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\42\u009f\1\u00a7\4\u009f\1\u009b\64\u009f\1\u009c\1\u009d"+
            "\uffa2\u009f",
            "\42\u0088\1\u00a8\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\1\uffff",
            "\42\u0088\1\u00a9\4\u0088\1\u0086\64\u0088\1\u0084\1\u0085"+
            "\uffa2\u0088",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff"
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "()* loopback of 269:10: ( ( '\\\\' )=> '\\\\' ( ( ']' )=> ']' |c= . ) | ( '\"' )=>as= ACTION_STRING_LITERAL | ( '\\'' )=>ac= ACTION_CHAR_LITERAL |c=~ ']' )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_148 = input.LA(1);

                        s = -1;
                        if ( (LA10_148=='\"') ) {s = 120;}

                        else if ( (LA10_148=='\\') ) {s = 118;}

                        else if ( (LA10_148=='\'') ) {s = 165;}

                        else if ( (LA10_148==']') ) {s = 119;}

                        else if ( ((LA10_148 >= '\u0000' && LA10_148 <= '!')||(LA10_148 >= '#' && LA10_148 <= '&')||(LA10_148 >= '(' && LA10_148 <= '[')||(LA10_148 >= '^' && LA10_148 <= '\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA10_49 = input.LA(1);

                        s = -1;
                        if ( (LA10_49=='\'') ) {s = 73;}

                        else if ( (LA10_49=='\\') ) {s = 74;}

                        else if ( (LA10_49=='\"') ) {s = 75;}

                        else if ( (LA10_49==']') ) {s = 76;}

                        else if ( ((LA10_49 >= '\u0000' && LA10_49 <= '!')||(LA10_49 >= '#' && LA10_49 <= '&')||(LA10_49 >= '(' && LA10_49 <= '[')||(LA10_49 >= '^' && LA10_49 <= '\uFFFF')) ) {s = 77;}

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA10_108 = input.LA(1);

                        s = -1;
                        if ( (LA10_108=='\'') ) {s = 107;}

                        else if ( (LA10_108=='\\') ) {s = 108;}

                        else if ( (LA10_108=='\"') ) {s = 109;}

                        else if ( ((LA10_108 >= '\u0000' && LA10_108 <= '!')||(LA10_108 >= '#' && LA10_108 <= '&')||(LA10_108 >= '(' && LA10_108 <= '[')||(LA10_108 >= ']' && LA10_108 <= '\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA10_44 = input.LA(1);

                        s = -1;
                        if ( (LA10_44=='\'') ) {s = 72;}

                        else if ( (LA10_44=='\\') ) {s = 16;}

                        else if ( (LA10_44==']') ) {s = 17;}

                        else if ( (LA10_44=='\"') ) {s = 19;}

                        else if ( ((LA10_44 >= '\u0000' && LA10_44 <= '!')||(LA10_44 >= '#' && LA10_44 <= '&')||(LA10_44 >= '(' && LA10_44 <= '[')||(LA10_44 >= '^' && LA10_44 <= '\uFFFF')) ) {s = 20;}

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA10_35 = input.LA(1);

                        s = -1;
                        if ( (LA10_35=='\"') ) {s = 58;}

                        else if ( (LA10_35=='\\') ) {s = 59;}

                        else if ( (LA10_35=='\'') ) {s = 60;}

                        else if ( (LA10_35==']') ) {s = 61;}

                        else if ( ((LA10_35 >= '\u0000' && LA10_35 <= '!')||(LA10_35 >= '#' && LA10_35 <= '&')||(LA10_35 >= '(' && LA10_35 <= '[')||(LA10_35 >= '^' && LA10_35 <= '\uFFFF')) ) {s = 62;}

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA10_26 = input.LA(1);

                         
                        int index10_26 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_26);

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA10_54 = input.LA(1);

                         
                        int index10_54 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_54);

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA10_19 = input.LA(1);

                        s = -1;
                        if ( (LA10_19=='\'') ) {s = 48;}

                        else if ( (LA10_19=='\\') ) {s = 49;}

                        else if ( (LA10_19==']') ) {s = 50;}

                        else if ( (LA10_19=='\"') ) {s = 51;}

                        else if ( ((LA10_19 >= '\u0000' && LA10_19 <= '!')||(LA10_19 >= '#' && LA10_19 <= '&')||(LA10_19 >= '(' && LA10_19 <= '[')||(LA10_19 >= '^' && LA10_19 <= '\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA10_79 = input.LA(1);

                        s = -1;
                        if ( (LA10_79=='\'') ) {s = 107;}

                        else if ( (LA10_79=='\\') ) {s = 108;}

                        else if ( (LA10_79=='\"') ) {s = 109;}

                        else if ( ((LA10_79 >= '\u0000' && LA10_79 <= '!')||(LA10_79 >= '#' && LA10_79 <= '&')||(LA10_79 >= '(' && LA10_79 <= '[')||(LA10_79 >= ']' && LA10_79 <= '\uFFFF')) ) {s = 110;}

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA10_92 = input.LA(1);

                        s = -1;
                        if ( (LA10_92==']') ) {s = 88;}

                        else if ( (LA10_92=='\\') ) {s = 89;}

                        else if ( (LA10_92=='\"') ) {s = 90;}

                        else if ( (LA10_92=='\'') ) {s = 123;}

                        else if ( ((LA10_92 >= '\u0000' && LA10_92 <= '!')||(LA10_92 >= '#' && LA10_92 <= '&')||(LA10_92 >= '(' && LA10_92 <= '[')||(LA10_92 >= '^' && LA10_92 <= '\uFFFF')) ) {s = 92;}

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA10_165 = input.LA(1);

                         
                        int index10_165 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_165);

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA10_164 = input.LA(1);

                         
                        int index10_164 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_164);

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA10_162 = input.LA(1);

                         
                        int index10_162 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_162);

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA10_150 = input.LA(1);

                         
                        int index10_150 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_150);

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA10_149 = input.LA(1);

                         
                        int index10_149 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_149);

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA10_142 = input.LA(1);

                         
                        int index10_142 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_142);

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA10_124 = input.LA(1);

                         
                        int index10_124 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_124);

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA10_121 = input.LA(1);

                         
                        int index10_121 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_121);

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA10_81 = input.LA(1);

                        s = -1;
                        if ( (LA10_81=='\'') ) {s = 78;}

                        else if ( (LA10_81=='\\') ) {s = 79;}

                        else if ( (LA10_81=='\"') ) {s = 80;}

                        else if ( ((LA10_81 >= '\u0000' && LA10_81 <= '!')||(LA10_81 >= '#' && LA10_81 <= '&')||(LA10_81 >= '(' && LA10_81 <= '[')||(LA10_81 >= ']' && LA10_81 <= '\uFFFF')) ) {s = 81;}

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA10_132 = input.LA(1);

                        s = -1;
                        if ( (LA10_132=='\'') ) {s = 155;}

                        else if ( (LA10_132=='\\') ) {s = 156;}

                        else if ( (LA10_132==']') ) {s = 157;}

                        else if ( (LA10_132=='\"') ) {s = 158;}

                        else if ( ((LA10_132 >= '\u0000' && LA10_132 <= '!')||(LA10_132 >= '#' && LA10_132 <= '&')||(LA10_132 >= '(' && LA10_132 <= '[')||(LA10_132 >= '^' && LA10_132 <= '\uFFFF')) ) {s = 159;}

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA10_28 = input.LA(1);

                        s = -1;
                        if ( (LA10_28=='\"') ) {s = 55;}

                        else if ( (LA10_28=='\\') ) {s = 11;}

                        else if ( (LA10_28==']') ) {s = 12;}

                        else if ( (LA10_28=='\'') ) {s = 14;}

                        else if ( ((LA10_28 >= '\u0000' && LA10_28 <= '!')||(LA10_28 >= '#' && LA10_28 <= '&')||(LA10_28 >= '(' && LA10_28 <= '[')||(LA10_28 >= '^' && LA10_28 <= '\uFFFF')) ) {s = 15;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA10_63 = input.LA(1);

                        s = -1;
                        if ( (LA10_63==']') ) {s = 88;}

                        else if ( (LA10_63=='\\') ) {s = 89;}

                        else if ( (LA10_63=='\"') ) {s = 90;}

                        else if ( (LA10_63=='\'') ) {s = 91;}

                        else if ( ((LA10_63 >= '\u0000' && LA10_63 <= '!')||(LA10_63 >= '#' && LA10_63 <= '&')||(LA10_63 >= '(' && LA10_63 <= '[')||(LA10_63 >= '^' && LA10_63 <= '\uFFFF')) ) {s = 92;}

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA10_127 = input.LA(1);

                         
                        int index10_127 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_127=='\"') ) {s = 151;}

                        else if ( (LA10_127=='\\') ) {s = 103;}

                        else if ( (LA10_127==']') ) {s = 102;}

                        else if ( (LA10_127=='\'') ) {s = 105;}

                        else if ( ((LA10_127 >= '\u0000' && LA10_127 <= '!')||(LA10_127 >= '#' && LA10_127 <= '&')||(LA10_127 >= '(' && LA10_127 <= '[')||(LA10_127 >= '^' && LA10_127 <= '\uFFFF')) ) {s = 106;}

                        else s = 126;

                         
                        input.seek(index10_127);

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA10_155 = input.LA(1);

                        s = -1;
                        if ( (LA10_155=='\'') ) {s = 134;}

                        else if ( (LA10_155=='\\') ) {s = 132;}

                        else if ( (LA10_155=='\"') ) {s = 166;}

                        else if ( (LA10_155==']') ) {s = 133;}

                        else if ( ((LA10_155 >= '\u0000' && LA10_155 <= '!')||(LA10_155 >= '#' && LA10_155 <= '&')||(LA10_155 >= '(' && LA10_155 <= '[')||(LA10_155 >= '^' && LA10_155 <= '\uFFFF')) ) {s = 136;}

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA10_144 = input.LA(1);

                        s = -1;
                        if ( (LA10_144=='\"') ) {s = 120;}

                        else if ( (LA10_144=='\\') ) {s = 118;}

                        else if ( (LA10_144=='\'') ) {s = 162;}

                        else if ( (LA10_144==']') ) {s = 119;}

                        else if ( ((LA10_144 >= '\u0000' && LA10_144 <= '!')||(LA10_144 >= '#' && LA10_144 <= '&')||(LA10_144 >= '(' && LA10_144 <= '[')||(LA10_144 >= '^' && LA10_144 <= '\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA10_12 = input.LA(1);

                         
                        int index10_12 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_12=='\"') && (synpred4_ANTLRLexer())) {s = 31;}

                        else if ( (LA10_12=='\\') && (synpred4_ANTLRLexer())) {s = 32;}

                        else if ( ((LA10_12 >= '\u0000' && LA10_12 <= '!')||(LA10_12 >= '#' && LA10_12 <= '[')||(LA10_12 >= ']' && LA10_12 <= '\uFFFF')) && (synpred4_ANTLRLexer())) {s = 33;}

                        else s = 5;

                         
                        input.seek(index10_12);

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA10_64 = input.LA(1);

                        s = -1;
                        if ( (LA10_64=='\"') ) {s = 93;}

                        else if ( (LA10_64=='\\') ) {s = 94;}

                        else if ( (LA10_64=='\'') ) {s = 95;}

                        else if ( ((LA10_64 >= '\u0000' && LA10_64 <= '!')||(LA10_64 >= '#' && LA10_64 <= '&')||(LA10_64 >= '(' && LA10_64 <= '[')||(LA10_64 >= ']' && LA10_64 <= '\uFFFF')) ) {s = 96;}

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA10_89 = input.LA(1);

                        s = -1;
                        if ( (LA10_89==']') ) {s = 113;}

                        else if ( (LA10_89=='\\') ) {s = 114;}

                        else if ( (LA10_89=='\"') ) {s = 115;}

                        else if ( (LA10_89=='\'') ) {s = 116;}

                        else if ( ((LA10_89 >= '\u0000' && LA10_89 <= '!')||(LA10_89 >= '#' && LA10_89 <= '&')||(LA10_89 >= '(' && LA10_89 <= '[')||(LA10_89 >= '^' && LA10_89 <= '\uFFFF')) ) {s = 117;}

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA10_97 = input.LA(1);

                         
                        int index10_97 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_97);

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA10_39 = input.LA(1);

                         
                        int index10_39 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_39);

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA10_13 = input.LA(1);

                         
                        int index10_13 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_13);

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA10_55 = input.LA(1);

                         
                        int index10_55 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_55);

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA10_57 = input.LA(1);

                         
                        int index10_57 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_57);

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA10_96 = input.LA(1);

                        s = -1;
                        if ( (LA10_96=='\"') ) {s = 63;}

                        else if ( (LA10_96=='\\') ) {s = 64;}

                        else if ( (LA10_96=='\'') ) {s = 65;}

                        else if ( ((LA10_96 >= '\u0000' && LA10_96 <= '!')||(LA10_96 >= '#' && LA10_96 <= '&')||(LA10_96 >= '(' && LA10_96 <= '[')||(LA10_96 >= ']' && LA10_96 <= '\uFFFF')) ) {s = 66;}

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA10_109 = input.LA(1);

                        s = -1;
                        if ( (LA10_109=='\'') ) {s = 139;}

                        else if ( (LA10_109=='\\') ) {s = 49;}

                        else if ( (LA10_109=='\"') ) {s = 51;}

                        else if ( (LA10_109==']') ) {s = 50;}

                        else if ( ((LA10_109 >= '\u0000' && LA10_109 <= '!')||(LA10_109 >= '#' && LA10_109 <= '&')||(LA10_109 >= '(' && LA10_109 <= '[')||(LA10_109 >= '^' && LA10_109 <= '\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA10_118 = input.LA(1);

                        s = -1;
                        if ( (LA10_118=='\"') ) {s = 144;}

                        else if ( (LA10_118=='\\') ) {s = 145;}

                        else if ( (LA10_118==']') ) {s = 146;}

                        else if ( (LA10_118=='\'') ) {s = 147;}

                        else if ( ((LA10_118 >= '\u0000' && LA10_118 <= '!')||(LA10_118 >= '#' && LA10_118 <= '&')||(LA10_118 >= '(' && LA10_118 <= '[')||(LA10_118 >= '^' && LA10_118 <= '\uFFFF')) ) {s = 148;}

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA10_143 = input.LA(1);

                         
                        int index10_143 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_143);

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA10_140 = input.LA(1);

                         
                        int index10_140 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_140);

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA10_123 = input.LA(1);

                         
                        int index10_123 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_123);

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA10_77 = input.LA(1);

                        s = -1;
                        if ( (LA10_77=='\'') ) {s = 101;}

                        else if ( (LA10_77=='\\') ) {s = 49;}

                        else if ( (LA10_77=='\"') ) {s = 51;}

                        else if ( (LA10_77==']') ) {s = 50;}

                        else if ( ((LA10_77 >= '\u0000' && LA10_77 <= '!')||(LA10_77 >= '#' && LA10_77 <= '&')||(LA10_77 >= '(' && LA10_77 <= '[')||(LA10_77 >= '^' && LA10_77 <= '\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA10_91 = input.LA(1);

                         
                        int index10_91 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_91);

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA10_154 = input.LA(1);

                         
                        int index10_154 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_154);

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA10_151 = input.LA(1);

                         
                        int index10_151 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_151);

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA10_137 = input.LA(1);

                         
                        int index10_137 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_137);

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA10_104 = input.LA(1);

                         
                        int index10_104 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_104);

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA10_42 = input.LA(1);

                        s = -1;
                        if ( (LA10_42=='\'') ) {s = 70;}

                        else if ( (LA10_42=='\\') ) {s = 16;}

                        else if ( (LA10_42==']') ) {s = 17;}

                        else if ( (LA10_42=='\"') ) {s = 19;}

                        else if ( ((LA10_42 >= '\u0000' && LA10_42 <= '!')||(LA10_42 >= '#' && LA10_42 <= '&')||(LA10_42 >= '(' && LA10_42 <= '[')||(LA10_42 >= '^' && LA10_42 <= '\uFFFF')) ) {s = 20;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA10_102 = input.LA(1);

                         
                        int index10_102 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_102 >= '\u0000' && LA10_102 <= '\uFFFF')) ) {s = 5;}

                        else s = 126;

                         
                        input.seek(index10_102);

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA10_107 = input.LA(1);

                        s = -1;
                        if ( (LA10_107=='\'') ) {s = 134;}

                        else if ( (LA10_107=='\\') ) {s = 132;}

                        else if ( (LA10_107=='\"') ) {s = 138;}

                        else if ( (LA10_107==']') ) {s = 133;}

                        else if ( ((LA10_107 >= '\u0000' && LA10_107 <= '!')||(LA10_107 >= '#' && LA10_107 <= '&')||(LA10_107 >= '(' && LA10_107 <= '[')||(LA10_107 >= '^' && LA10_107 <= '\uFFFF')) ) {s = 136;}

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA10_90 = input.LA(1);

                        s = -1;
                        if ( (LA10_90=='\\') ) {s = 118;}

                        else if ( (LA10_90==']') ) {s = 119;}

                        else if ( (LA10_90=='\"') ) {s = 120;}

                        else if ( (LA10_90=='\'') ) {s = 121;}

                        else if ( ((LA10_90 >= '\u0000' && LA10_90 <= '!')||(LA10_90 >= '#' && LA10_90 <= '&')||(LA10_90 >= '(' && LA10_90 <= '[')||(LA10_90 >= '^' && LA10_90 <= '\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA10_62 = input.LA(1);

                        s = -1;
                        if ( (LA10_62=='\"') ) {s = 87;}

                        else if ( (LA10_62=='\\') ) {s = 35;}

                        else if ( (LA10_62=='\'') ) {s = 37;}

                        else if ( (LA10_62==']') ) {s = 36;}

                        else if ( ((LA10_62 >= '\u0000' && LA10_62 <= '!')||(LA10_62 >= '#' && LA10_62 <= '&')||(LA10_62 >= '(' && LA10_62 <= '[')||(LA10_62 >= '^' && LA10_62 <= '\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA10_128 = input.LA(1);

                        s = -1;
                        if ( (LA10_128=='\"') ) {s = 152;}

                        else if ( (LA10_128=='\\') ) {s = 128;}

                        else if ( (LA10_128==']') ) {s = 127;}

                        else if ( (LA10_128=='\'') ) {s = 130;}

                        else if ( ((LA10_128 >= '\u0000' && LA10_128 <= '!')||(LA10_128 >= '#' && LA10_128 <= '&')||(LA10_128 >= '(' && LA10_128 <= '[')||(LA10_128 >= '^' && LA10_128 <= '\uFFFF')) ) {s = 131;}

                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA10_27 = input.LA(1);

                        s = -1;
                        if ( (LA10_27=='\"') ) {s = 54;}

                        else if ( (LA10_27=='\\') ) {s = 27;}

                        else if ( (LA10_27==']') ) {s = 28;}

                        else if ( (LA10_27=='\'') ) {s = 29;}

                        else if ( ((LA10_27 >= '\u0000' && LA10_27 <= '!')||(LA10_27 >= '#' && LA10_27 <= '&')||(LA10_27 >= '(' && LA10_27 <= '[')||(LA10_27 >= '^' && LA10_27 <= '\uFFFF')) ) {s = 30;}

                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA10_95 = input.LA(1);

                        s = -1;
                        if ( (LA10_95=='\"') ) {s = 125;}

                        else if ( (LA10_95=='\\') ) {s = 35;}

                        else if ( (LA10_95=='\'') ) {s = 37;}

                        else if ( (LA10_95==']') ) {s = 36;}

                        else if ( ((LA10_95 >= '\u0000' && LA10_95 <= '!')||(LA10_95 >= '#' && LA10_95 <= '&')||(LA10_95 >= '(' && LA10_95 <= '[')||(LA10_95 >= '^' && LA10_95 <= '\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA10_66 = input.LA(1);

                        s = -1;
                        if ( (LA10_66=='\"') ) {s = 63;}

                        else if ( (LA10_66=='\\') ) {s = 64;}

                        else if ( (LA10_66=='\'') ) {s = 65;}

                        else if ( ((LA10_66 >= '\u0000' && LA10_66 <= '!')||(LA10_66 >= '#' && LA10_66 <= '&')||(LA10_66 >= '(' && LA10_66 <= '[')||(LA10_66 >= ']' && LA10_66 <= '\uFFFF')) ) {s = 66;}

                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA10_103 = input.LA(1);

                        s = -1;
                        if ( (LA10_103==']') ) {s = 127;}

                        else if ( (LA10_103=='\\') ) {s = 128;}

                        else if ( (LA10_103=='\"') ) {s = 129;}

                        else if ( (LA10_103=='\'') ) {s = 130;}

                        else if ( ((LA10_103 >= '\u0000' && LA10_103 <= '!')||(LA10_103 >= '#' && LA10_103 <= '&')||(LA10_103 >= '(' && LA10_103 <= '[')||(LA10_103 >= '^' && LA10_103 <= '\uFFFF')) ) {s = 131;}

                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA10_11 = input.LA(1);

                        s = -1;
                        if ( (LA10_11=='\"') ) {s = 26;}

                        else if ( (LA10_11=='\\') ) {s = 27;}

                        else if ( (LA10_11==']') ) {s = 28;}

                        else if ( (LA10_11=='\'') ) {s = 29;}

                        else if ( ((LA10_11 >= '\u0000' && LA10_11 <= '!')||(LA10_11 >= '#' && LA10_11 <= '&')||(LA10_11 >= '(' && LA10_11 <= '[')||(LA10_11 >= '^' && LA10_11 <= '\uFFFF')) ) {s = 30;}

                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA10_3 = input.LA(1);

                        s = -1;
                        if ( (LA10_3=='\\') ) {s = 11;}

                        else if ( (LA10_3==']') ) {s = 12;}

                        else if ( (LA10_3=='\"') ) {s = 13;}

                        else if ( (LA10_3=='\'') ) {s = 14;}

                        else if ( ((LA10_3 >= '\u0000' && LA10_3 <= '!')||(LA10_3 >= '#' && LA10_3 <= '&')||(LA10_3 >= '(' && LA10_3 <= '[')||(LA10_3 >= '^' && LA10_3 <= '\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA10_113 = input.LA(1);

                         
                        int index10_113 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_113=='\'') ) {s = 140;}

                        else if ( (LA10_113=='\\') ) {s = 89;}

                        else if ( (LA10_113==']') ) {s = 88;}

                        else if ( (LA10_113=='\"') ) {s = 90;}

                        else if ( ((LA10_113 >= '\u0000' && LA10_113 <= '!')||(LA10_113 >= '#' && LA10_113 <= '&')||(LA10_113 >= '(' && LA10_113 <= '[')||(LA10_113 >= '^' && LA10_113 <= '\uFFFF')) ) {s = 92;}

                        else s = 112;

                         
                        input.seek(index10_113);

                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA10_105 = input.LA(1);

                        s = -1;
                        if ( (LA10_105=='\\') ) {s = 132;}

                        else if ( (LA10_105==']') ) {s = 133;}

                        else if ( (LA10_105=='\'') ) {s = 134;}

                        else if ( (LA10_105=='\"') ) {s = 135;}

                        else if ( ((LA10_105 >= '\u0000' && LA10_105 <= '!')||(LA10_105 >= '#' && LA10_105 <= '&')||(LA10_105 >= '(' && LA10_105 <= '[')||(LA10_105 >= '^' && LA10_105 <= '\uFFFF')) ) {s = 136;}

                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA10_43 = input.LA(1);

                        s = -1;
                        if ( (LA10_43=='\'') ) {s = 71;}

                        else if ( (LA10_43=='\\') ) {s = 49;}

                        else if ( (LA10_43==']') ) {s = 50;}

                        else if ( (LA10_43=='\"') ) {s = 51;}

                        else if ( ((LA10_43 >= '\u0000' && LA10_43 <= '!')||(LA10_43 >= '#' && LA10_43 <= '&')||(LA10_43 >= '(' && LA10_43 <= '[')||(LA10_43 >= '^' && LA10_43 <= '\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA10_159 = input.LA(1);

                        s = -1;
                        if ( (LA10_159=='\'') ) {s = 134;}

                        else if ( (LA10_159=='\\') ) {s = 132;}

                        else if ( (LA10_159=='\"') ) {s = 169;}

                        else if ( (LA10_159==']') ) {s = 133;}

                        else if ( ((LA10_159 >= '\u0000' && LA10_159 <= '!')||(LA10_159 >= '#' && LA10_159 <= '&')||(LA10_159 >= '(' && LA10_159 <= '[')||(LA10_159 >= '^' && LA10_159 <= '\uFFFF')) ) {s = 136;}

                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA10_98 = input.LA(1);

                         
                        int index10_98 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_98);

                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA10_8 = input.LA(1);

                         
                        int index10_8 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred2_ANTLRLexer()) ) {s = 25;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_8);

                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA10_73 = input.LA(1);

                         
                        int index10_73 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_73);

                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA10_130 = input.LA(1);

                        s = -1;
                        if ( (LA10_130=='\"') ) {s = 153;}

                        else if ( (LA10_130=='\\') ) {s = 132;}

                        else if ( (LA10_130==']') ) {s = 133;}

                        else if ( (LA10_130=='\'') ) {s = 134;}

                        else if ( ((LA10_130 >= '\u0000' && LA10_130 <= '!')||(LA10_130 >= '#' && LA10_130 <= '&')||(LA10_130 >= '(' && LA10_130 <= '[')||(LA10_130 >= '^' && LA10_130 <= '\uFFFF')) ) {s = 136;}

                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA10_110 = input.LA(1);

                        s = -1;
                        if ( (LA10_110=='\'') ) {s = 78;}

                        else if ( (LA10_110=='\\') ) {s = 79;}

                        else if ( (LA10_110=='\"') ) {s = 80;}

                        else if ( ((LA10_110 >= '\u0000' && LA10_110 <= '!')||(LA10_110 >= '#' && LA10_110 <= '&')||(LA10_110 >= '(' && LA10_110 <= '[')||(LA10_110 >= ']' && LA10_110 <= '\uFFFF')) ) {s = 81;}

                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA10_117 = input.LA(1);

                        s = -1;
                        if ( (LA10_117=='\'') ) {s = 143;}

                        else if ( (LA10_117=='\\') ) {s = 89;}

                        else if ( (LA10_117==']') ) {s = 88;}

                        else if ( (LA10_117=='\"') ) {s = 90;}

                        else if ( ((LA10_117 >= '\u0000' && LA10_117 <= '!')||(LA10_117 >= '#' && LA10_117 <= '&')||(LA10_117 >= '(' && LA10_117 <= '[')||(LA10_117 >= '^' && LA10_117 <= '\uFFFF')) ) {s = 92;}

                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA10_6 = input.LA(1);

                         
                        int index10_6 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_6==']') && (synpred2_ANTLRLexer())) {s = 21;}

                        else if ( (LA10_6=='\\') && (synpred2_ANTLRLexer())) {s = 22;}

                        else if ( (LA10_6=='\"') && (synpred2_ANTLRLexer())) {s = 23;}

                        else if ( (LA10_6=='\'') && (synpred2_ANTLRLexer())) {s = 24;}

                        else if ( ((LA10_6 >= '\u0000' && LA10_6 <= '!')||(LA10_6 >= '#' && LA10_6 <= '&')||(LA10_6 >= '(' && LA10_6 <= '[')||(LA10_6 >= '^' && LA10_6 <= '\uFFFF')) && (synpred2_ANTLRLexer())) {s = 25;}

                        else s = 5;

                         
                        input.seek(index10_6);

                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA10_146 = input.LA(1);

                         
                        int index10_146 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_146=='\"') ) {s = 120;}

                        else if ( (LA10_146=='\\') ) {s = 118;}

                        else if ( (LA10_146=='\'') ) {s = 164;}

                        else if ( (LA10_146==']') ) {s = 119;}

                        else if ( ((LA10_146 >= '\u0000' && LA10_146 <= '!')||(LA10_146 >= '#' && LA10_146 <= '&')||(LA10_146 >= '(' && LA10_146 <= '[')||(LA10_146 >= '^' && LA10_146 <= '\uFFFF')) ) {s = 122;}

                        else s = 112;

                         
                        input.seek(index10_146);

                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA10_29 = input.LA(1);

                        s = -1;
                        if ( (LA10_29=='\"') ) {s = 56;}

                        else if ( (LA10_29=='\\') ) {s = 35;}

                        else if ( (LA10_29==']') ) {s = 36;}

                        else if ( (LA10_29=='\'') ) {s = 37;}

                        else if ( ((LA10_29 >= '\u0000' && LA10_29 <= '!')||(LA10_29 >= '#' && LA10_29 <= '&')||(LA10_29 >= '(' && LA10_29 <= '[')||(LA10_29 >= '^' && LA10_29 <= '\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA10_14 = input.LA(1);

                        s = -1;
                        if ( (LA10_14=='\"') ) {s = 34;}

                        else if ( (LA10_14=='\\') ) {s = 35;}

                        else if ( (LA10_14==']') ) {s = 36;}

                        else if ( (LA10_14=='\'') ) {s = 37;}

                        else if ( ((LA10_14 >= '\u0000' && LA10_14 <= '!')||(LA10_14 >= '#' && LA10_14 <= '&')||(LA10_14 >= '(' && LA10_14 <= '[')||(LA10_14 >= '^' && LA10_14 <= '\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA10_80 = input.LA(1);

                        s = -1;
                        if ( (LA10_80=='\'') ) {s = 111;}

                        else if ( (LA10_80=='\\') ) {s = 16;}

                        else if ( (LA10_80==']') ) {s = 17;}

                        else if ( (LA10_80=='\"') ) {s = 19;}

                        else if ( ((LA10_80 >= '\u0000' && LA10_80 <= '!')||(LA10_80 >= '#' && LA10_80 <= '&')||(LA10_80 >= '(' && LA10_80 <= '[')||(LA10_80 >= '^' && LA10_80 <= '\uFFFF')) ) {s = 20;}

                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA10_65 = input.LA(1);

                        s = -1;
                        if ( (LA10_65=='\"') ) {s = 97;}

                        else if ( (LA10_65=='\\') ) {s = 11;}

                        else if ( (LA10_65==']') ) {s = 12;}

                        else if ( (LA10_65=='\'') ) {s = 14;}

                        else if ( ((LA10_65 >= '\u0000' && LA10_65 <= '!')||(LA10_65 >= '#' && LA10_65 <= '&')||(LA10_65 >= '(' && LA10_65 <= '[')||(LA10_65 >= '^' && LA10_65 <= '\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA10_114 = input.LA(1);

                        s = -1;
                        if ( (LA10_114=='\'') ) {s = 141;}

                        else if ( (LA10_114=='\\') ) {s = 114;}

                        else if ( (LA10_114==']') ) {s = 113;}

                        else if ( (LA10_114=='\"') ) {s = 115;}

                        else if ( ((LA10_114 >= '\u0000' && LA10_114 <= '!')||(LA10_114 >= '#' && LA10_114 <= '&')||(LA10_114 >= '(' && LA10_114 <= '[')||(LA10_114 >= '^' && LA10_114 <= '\uFFFF')) ) {s = 117;}

                        if ( s>=0 ) return s;
                        break;

                    case 74 : 
                        int LA10_78 = input.LA(1);

                        s = -1;
                        if ( (LA10_78==']') ) {s = 102;}

                        else if ( (LA10_78=='\\') ) {s = 103;}

                        else if ( (LA10_78=='\"') ) {s = 104;}

                        else if ( (LA10_78=='\'') ) {s = 105;}

                        else if ( ((LA10_78 >= '\u0000' && LA10_78 <= '!')||(LA10_78 >= '#' && LA10_78 <= '&')||(LA10_78 >= '(' && LA10_78 <= '[')||(LA10_78 >= '^' && LA10_78 <= '\uFFFF')) ) {s = 106;}

                        if ( s>=0 ) return s;
                        break;

                    case 75 : 
                        int LA10_9 = input.LA(1);

                         
                        int index10_9 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred2_ANTLRLexer()) ) {s = 25;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_9);

                        if ( s>=0 ) return s;
                        break;

                    case 76 : 
                        int LA10_122 = input.LA(1);

                        s = -1;
                        if ( (LA10_122=='\"') ) {s = 120;}

                        else if ( (LA10_122=='\\') ) {s = 118;}

                        else if ( (LA10_122==']') ) {s = 119;}

                        else if ( (LA10_122=='\'') ) {s = 150;}

                        else if ( ((LA10_122 >= '\u0000' && LA10_122 <= '!')||(LA10_122 >= '#' && LA10_122 <= '&')||(LA10_122 >= '(' && LA10_122 <= '[')||(LA10_122 >= '^' && LA10_122 <= '\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;

                    case 77 : 
                        int LA10_74 = input.LA(1);

                        s = -1;
                        if ( (LA10_74=='\'') ) {s = 98;}

                        else if ( (LA10_74=='\\') ) {s = 74;}

                        else if ( (LA10_74=='\"') ) {s = 75;}

                        else if ( (LA10_74==']') ) {s = 76;}

                        else if ( ((LA10_74 >= '\u0000' && LA10_74 <= '!')||(LA10_74 >= '#' && LA10_74 <= '&')||(LA10_74 >= '(' && LA10_74 <= '[')||(LA10_74 >= '^' && LA10_74 <= '\uFFFF')) ) {s = 77;}

                        if ( s>=0 ) return s;
                        break;

                    case 78 : 
                        int LA10_61 = input.LA(1);

                        s = -1;
                        if ( (LA10_61=='\"') ) {s = 86;}

                        else if ( (LA10_61=='\\') ) {s = 35;}

                        else if ( (LA10_61=='\'') ) {s = 37;}

                        else if ( (LA10_61==']') ) {s = 36;}

                        else if ( ((LA10_61 >= '\u0000' && LA10_61 <= '!')||(LA10_61 >= '#' && LA10_61 <= '&')||(LA10_61 >= '(' && LA10_61 <= '[')||(LA10_61 >= '^' && LA10_61 <= '\uFFFF')) ) {s = 38;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;

                    case 79 : 
                        int LA10_120 = input.LA(1);

                        s = -1;
                        if ( (LA10_120==']') ) {s = 119;}

                        else if ( (LA10_120=='\\') ) {s = 118;}

                        else if ( (LA10_120=='\"') ) {s = 120;}

                        else if ( (LA10_120=='\'') ) {s = 149;}

                        else if ( ((LA10_120 >= '\u0000' && LA10_120 <= '!')||(LA10_120 >= '#' && LA10_120 <= '&')||(LA10_120 >= '(' && LA10_120 <= '[')||(LA10_120 >= '^' && LA10_120 <= '\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;

                    case 80 : 
                        int LA10_93 = input.LA(1);

                        s = -1;
                        if ( (LA10_93=='\"') ) {s = 120;}

                        else if ( (LA10_93=='\\') ) {s = 118;}

                        else if ( (LA10_93=='\'') ) {s = 124;}

                        else if ( (LA10_93==']') ) {s = 119;}

                        else if ( ((LA10_93 >= '\u0000' && LA10_93 <= '!')||(LA10_93 >= '#' && LA10_93 <= '&')||(LA10_93 >= '(' && LA10_93 <= '[')||(LA10_93 >= '^' && LA10_93 <= '\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;

                    case 81 : 
                        int LA10_157 = input.LA(1);

                         
                        int index10_157 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_157=='\'') ) {s = 134;}

                        else if ( (LA10_157=='\\') ) {s = 132;}

                        else if ( (LA10_157=='\"') ) {s = 168;}

                        else if ( (LA10_157==']') ) {s = 133;}

                        else if ( ((LA10_157 >= '\u0000' && LA10_157 <= '!')||(LA10_157 >= '#' && LA10_157 <= '&')||(LA10_157 >= '(' && LA10_157 <= '[')||(LA10_157 >= '^' && LA10_157 <= '\uFFFF')) ) {s = 136;}

                        else s = 126;

                         
                        input.seek(index10_157);

                        if ( s>=0 ) return s;
                        break;

                    case 82 : 
                        int LA10_30 = input.LA(1);

                        s = -1;
                        if ( (LA10_30=='\"') ) {s = 57;}

                        else if ( (LA10_30=='\\') ) {s = 11;}

                        else if ( (LA10_30==']') ) {s = 12;}

                        else if ( (LA10_30=='\'') ) {s = 14;}

                        else if ( ((LA10_30 >= '\u0000' && LA10_30 <= '!')||(LA10_30 >= '#' && LA10_30 <= '&')||(LA10_30 >= '(' && LA10_30 <= '[')||(LA10_30 >= '^' && LA10_30 <= '\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;

                    case 83 : 
                        int LA10_131 = input.LA(1);

                        s = -1;
                        if ( (LA10_131=='\"') ) {s = 154;}

                        else if ( (LA10_131=='\\') ) {s = 103;}

                        else if ( (LA10_131==']') ) {s = 102;}

                        else if ( (LA10_131=='\'') ) {s = 105;}

                        else if ( ((LA10_131 >= '\u0000' && LA10_131 <= '!')||(LA10_131 >= '#' && LA10_131 <= '&')||(LA10_131 >= '(' && LA10_131 <= '[')||(LA10_131 >= '^' && LA10_131 <= '\uFFFF')) ) {s = 106;}

                        if ( s>=0 ) return s;
                        break;

                    case 84 : 
                        int LA10_134 = input.LA(1);

                        s = -1;
                        if ( (LA10_134==']') ) {s = 133;}

                        else if ( (LA10_134=='\\') ) {s = 132;}

                        else if ( (LA10_134=='\"') ) {s = 160;}

                        else if ( (LA10_134=='\'') ) {s = 134;}

                        else if ( ((LA10_134 >= '\u0000' && LA10_134 <= '!')||(LA10_134 >= '#' && LA10_134 <= '&')||(LA10_134 >= '(' && LA10_134 <= '[')||(LA10_134 >= '^' && LA10_134 <= '\uFFFF')) ) {s = 136;}

                        if ( s>=0 ) return s;
                        break;

                    case 85 : 
                        int LA10_115 = input.LA(1);

                        s = -1;
                        if ( (LA10_115=='\'') ) {s = 142;}

                        else if ( (LA10_115=='\\') ) {s = 118;}

                        else if ( (LA10_115==']') ) {s = 119;}

                        else if ( (LA10_115=='\"') ) {s = 120;}

                        else if ( ((LA10_115 >= '\u0000' && LA10_115 <= '!')||(LA10_115 >= '#' && LA10_115 <= '&')||(LA10_115 >= '(' && LA10_115 <= '[')||(LA10_115 >= '^' && LA10_115 <= '\uFFFF')) ) {s = 122;}

                        if ( s>=0 ) return s;
                        break;

                    case 86 : 
                        int LA10_59 = input.LA(1);

                        s = -1;
                        if ( (LA10_59=='\"') ) {s = 84;}

                        else if ( (LA10_59=='\\') ) {s = 59;}

                        else if ( (LA10_59=='\'') ) {s = 60;}

                        else if ( (LA10_59==']') ) {s = 61;}

                        else if ( ((LA10_59 >= '\u0000' && LA10_59 <= '!')||(LA10_59 >= '#' && LA10_59 <= '&')||(LA10_59 >= '(' && LA10_59 <= '[')||(LA10_59 >= '^' && LA10_59 <= '\uFFFF')) ) {s = 62;}

                        if ( s>=0 ) return s;
                        break;

                    case 87 : 
                        int LA10_163 = input.LA(1);

                         
                        int index10_163 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_163);

                        if ( s>=0 ) return s;
                        break;

                    case 88 : 
                        int LA10_147 = input.LA(1);

                         
                        int index10_147 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_147);

                        if ( s>=0 ) return s;
                        break;

                    case 89 : 
                        int LA10_7 = input.LA(1);

                         
                        int index10_7 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred2_ANTLRLexer()) ) {s = 25;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_7);

                        if ( s>=0 ) return s;
                        break;

                    case 90 : 
                        int LA10_156 = input.LA(1);

                        s = -1;
                        if ( (LA10_156=='\'') ) {s = 155;}

                        else if ( (LA10_156=='\\') ) {s = 156;}

                        else if ( (LA10_156=='\"') ) {s = 167;}

                        else if ( (LA10_156==']') ) {s = 157;}

                        else if ( ((LA10_156 >= '\u0000' && LA10_156 <= '!')||(LA10_156 >= '#' && LA10_156 <= '&')||(LA10_156 >= '(' && LA10_156 <= '[')||(LA10_156 >= '^' && LA10_156 <= '\uFFFF')) ) {s = 159;}

                        if ( s>=0 ) return s;
                        break;

                    case 91 : 
                        int LA10_111 = input.LA(1);

                         
                        int index10_111 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_111);

                        if ( s>=0 ) return s;
                        break;

                    case 92 : 
                        int LA10_37 = input.LA(1);

                        s = -1;
                        if ( (LA10_37=='\"') ) {s = 67;}

                        else if ( (LA10_37=='\\') ) {s = 35;}

                        else if ( (LA10_37==']') ) {s = 36;}

                        else if ( (LA10_37=='\'') ) {s = 37;}

                        else if ( ((LA10_37 >= '\u0000' && LA10_37 <= '!')||(LA10_37 >= '#' && LA10_37 <= '&')||(LA10_37 >= '(' && LA10_37 <= '[')||(LA10_37 >= '^' && LA10_37 <= '\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;

                    case 93 : 
                        int LA10_18 = input.LA(1);

                         
                        int index10_18 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_18);

                        if ( s>=0 ) return s;
                        break;

                    case 94 : 
                        int LA10_53 = input.LA(1);

                         
                        int index10_53 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_53);

                        if ( s>=0 ) return s;
                        break;

                    case 95 : 
                        int LA10_70 = input.LA(1);

                         
                        int index10_70 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_70);

                        if ( s>=0 ) return s;
                        break;

                    case 96 : 
                        int LA10_72 = input.LA(1);

                         
                        int index10_72 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_72);

                        if ( s>=0 ) return s;
                        break;

                    case 97 : 
                        int LA10_88 = input.LA(1);

                         
                        int index10_88 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_88 >= '\u0000' && LA10_88 <= '\uFFFF')) ) {s = 5;}

                        else s = 112;

                         
                        input.seek(index10_88);

                        if ( s>=0 ) return s;
                        break;

                    case 98 : 
                        int LA10_17 = input.LA(1);

                         
                        int index10_17 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_17=='\'') && (synpred5_ANTLRLexer())) {s = 45;}

                        else if ( (LA10_17=='\\') && (synpred5_ANTLRLexer())) {s = 46;}

                        else if ( ((LA10_17 >= '\u0000' && LA10_17 <= '&')||(LA10_17 >= '(' && LA10_17 <= '[')||(LA10_17 >= ']' && LA10_17 <= '\uFFFF')) && (synpred5_ANTLRLexer())) {s = 47;}

                        else s = 5;

                         
                        input.seek(index10_17);

                        if ( s>=0 ) return s;
                        break;

                    case 99 : 
                        int LA10_15 = input.LA(1);

                        s = -1;
                        if ( (LA10_15=='\"') ) {s = 39;}

                        else if ( (LA10_15=='\\') ) {s = 11;}

                        else if ( (LA10_15==']') ) {s = 12;}

                        else if ( (LA10_15=='\'') ) {s = 14;}

                        else if ( ((LA10_15 >= '\u0000' && LA10_15 <= '!')||(LA10_15 >= '#' && LA10_15 <= '&')||(LA10_15 >= '(' && LA10_15 <= '[')||(LA10_15 >= '^' && LA10_15 <= '\uFFFF')) ) {s = 15;}

                        if ( s>=0 ) return s;
                        break;

                    case 100 : 
                        int LA10_106 = input.LA(1);

                        s = -1;
                        if ( (LA10_106==']') ) {s = 102;}

                        else if ( (LA10_106=='\\') ) {s = 103;}

                        else if ( (LA10_106=='\"') ) {s = 137;}

                        else if ( (LA10_106=='\'') ) {s = 105;}

                        else if ( ((LA10_106 >= '\u0000' && LA10_106 <= '!')||(LA10_106 >= '#' && LA10_106 <= '&')||(LA10_106 >= '(' && LA10_106 <= '[')||(LA10_106 >= '^' && LA10_106 <= '\uFFFF')) ) {s = 106;}

                        if ( s>=0 ) return s;
                        break;

                    case 101 : 
                        int LA10_0 = input.LA(1);

                        s = -1;
                        if ( (LA10_0==']') ) {s = 1;}

                        else if ( (LA10_0=='\\') ) {s = 2;}

                        else if ( (LA10_0=='\"') ) {s = 3;}

                        else if ( (LA10_0=='\'') ) {s = 4;}

                        else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '!')||(LA10_0 >= '#' && LA10_0 <= '&')||(LA10_0 >= '(' && LA10_0 <= '[')||(LA10_0 >= '^' && LA10_0 <= '\uFFFF')) ) {s = 5;}

                        if ( s>=0 ) return s;
                        break;

                    case 102 : 
                        int LA10_76 = input.LA(1);

                        s = -1;
                        if ( (LA10_76=='\'') ) {s = 100;}

                        else if ( (LA10_76=='\\') ) {s = 49;}

                        else if ( (LA10_76=='\"') ) {s = 51;}

                        else if ( (LA10_76==']') ) {s = 50;}

                        else if ( ((LA10_76 >= '\u0000' && LA10_76 <= '!')||(LA10_76 >= '#' && LA10_76 <= '&')||(LA10_76 >= '(' && LA10_76 <= '[')||(LA10_76 >= '^' && LA10_76 <= '\uFFFF')) ) {s = 52;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;

                    case 103 : 
                        int LA10_10 = input.LA(1);

                         
                        int index10_10 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred2_ANTLRLexer()) ) {s = 25;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_10);

                        if ( s>=0 ) return s;
                        break;

                    case 104 : 
                        int LA10_51 = input.LA(1);

                        s = -1;
                        if ( (LA10_51=='\'') ) {s = 82;}

                        else if ( (LA10_51=='\\') ) {s = 49;}

                        else if ( (LA10_51==']') ) {s = 50;}

                        else if ( (LA10_51=='\"') ) {s = 51;}

                        else if ( ((LA10_51 >= '\u0000' && LA10_51 <= '!')||(LA10_51 >= '#' && LA10_51 <= '&')||(LA10_51 >= '(' && LA10_51 <= '[')||(LA10_51 >= '^' && LA10_51 <= '\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;

                    case 105 : 
                        int LA10_20 = input.LA(1);

                        s = -1;
                        if ( (LA10_20=='\'') ) {s = 53;}

                        else if ( (LA10_20=='\\') ) {s = 16;}

                        else if ( (LA10_20==']') ) {s = 17;}

                        else if ( (LA10_20=='\"') ) {s = 19;}

                        else if ( ((LA10_20 >= '\u0000' && LA10_20 <= '!')||(LA10_20 >= '#' && LA10_20 <= '&')||(LA10_20 >= '(' && LA10_20 <= '[')||(LA10_20 >= '^' && LA10_20 <= '\uFFFF')) ) {s = 20;}

                        if ( s>=0 ) return s;
                        break;

                    case 106 : 
                        int LA10_167 = input.LA(1);

                         
                        int index10_167 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_167);

                        if ( s>=0 ) return s;
                        break;

                    case 107 : 
                        int LA10_158 = input.LA(1);

                         
                        int index10_158 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_158);

                        if ( s>=0 ) return s;
                        break;

                    case 108 : 
                        int LA10_16 = input.LA(1);

                        s = -1;
                        if ( (LA10_16=='\'') ) {s = 40;}

                        else if ( (LA10_16=='\\') ) {s = 41;}

                        else if ( (LA10_16==']') ) {s = 42;}

                        else if ( (LA10_16=='\"') ) {s = 43;}

                        else if ( ((LA10_16 >= '\u0000' && LA10_16 <= '!')||(LA10_16 >= '#' && LA10_16 <= '&')||(LA10_16 >= '(' && LA10_16 <= '[')||(LA10_16 >= '^' && LA10_16 <= '\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;

                    case 109 : 
                        int LA10_52 = input.LA(1);

                        s = -1;
                        if ( (LA10_52=='\'') ) {s = 83;}

                        else if ( (LA10_52=='\\') ) {s = 49;}

                        else if ( (LA10_52=='\"') ) {s = 51;}

                        else if ( (LA10_52==']') ) {s = 50;}

                        else if ( ((LA10_52 >= '\u0000' && LA10_52 <= '!')||(LA10_52 >= '#' && LA10_52 <= '&')||(LA10_52 >= '(' && LA10_52 <= '[')||(LA10_52 >= '^' && LA10_52 <= '\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;

                    case 110 : 
                        int LA10_152 = input.LA(1);

                         
                        int index10_152 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_152);

                        if ( s>=0 ) return s;
                        break;

                    case 111 : 
                        int LA10_129 = input.LA(1);

                         
                        int index10_129 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_129);

                        if ( s>=0 ) return s;
                        break;

                    case 112 : 
                        int LA10_41 = input.LA(1);

                        s = -1;
                        if ( (LA10_41=='\'') ) {s = 69;}

                        else if ( (LA10_41=='\\') ) {s = 41;}

                        else if ( (LA10_41==']') ) {s = 42;}

                        else if ( (LA10_41=='\"') ) {s = 43;}

                        else if ( ((LA10_41 >= '\u0000' && LA10_41 <= '!')||(LA10_41 >= '#' && LA10_41 <= '&')||(LA10_41 >= '(' && LA10_41 <= '[')||(LA10_41 >= '^' && LA10_41 <= '\uFFFF')) ) {s = 44;}

                        if ( s>=0 ) return s;
                        break;

                    case 113 : 
                        int LA10_36 = input.LA(1);

                        s = -1;
                        if ( (LA10_36=='\"') ) {s = 63;}

                        else if ( (LA10_36=='\\') ) {s = 64;}

                        else if ( (LA10_36=='\'') ) {s = 65;}

                        else if ( ((LA10_36 >= '\u0000' && LA10_36 <= '!')||(LA10_36 >= '#' && LA10_36 <= '&')||(LA10_36 >= '(' && LA10_36 <= '[')||(LA10_36 >= ']' && LA10_36 <= '\uFFFF')) ) {s = 66;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;

                    case 114 : 
                        int LA10_75 = input.LA(1);

                        s = -1;
                        if ( (LA10_75=='\'') ) {s = 99;}

                        else if ( (LA10_75=='\\') ) {s = 49;}

                        else if ( (LA10_75=='\"') ) {s = 51;}

                        else if ( (LA10_75==']') ) {s = 50;}

                        else if ( ((LA10_75 >= '\u0000' && LA10_75 <= '!')||(LA10_75 >= '#' && LA10_75 <= '&')||(LA10_75 >= '(' && LA10_75 <= '[')||(LA10_75 >= '^' && LA10_75 <= '\uFFFF')) ) {s = 52;}

                        if ( s>=0 ) return s;
                        break;

                    case 115 : 
                        int LA10_119 = input.LA(1);

                         
                        int index10_119 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_119=='\"') ) {s = 63;}

                        else if ( (LA10_119=='\\') ) {s = 64;}

                        else if ( (LA10_119=='\'') ) {s = 65;}

                        else if ( ((LA10_119 >= '\u0000' && LA10_119 <= '!')||(LA10_119 >= '#' && LA10_119 <= '&')||(LA10_119 >= '(' && LA10_119 <= '[')||(LA10_119 >= ']' && LA10_119 <= '\uFFFF')) ) {s = 66;}

                        else s = 112;

                         
                        input.seek(index10_119);

                        if ( s>=0 ) return s;
                        break;

                    case 116 : 
                        int LA10_145 = input.LA(1);

                        s = -1;
                        if ( (LA10_145=='\"') ) {s = 144;}

                        else if ( (LA10_145=='\\') ) {s = 145;}

                        else if ( (LA10_145=='\'') ) {s = 163;}

                        else if ( (LA10_145==']') ) {s = 146;}

                        else if ( ((LA10_145 >= '\u0000' && LA10_145 <= '!')||(LA10_145 >= '#' && LA10_145 <= '&')||(LA10_145 >= '(' && LA10_145 <= '[')||(LA10_145 >= '^' && LA10_145 <= '\uFFFF')) ) {s = 148;}

                        if ( s>=0 ) return s;
                        break;

                    case 117 : 
                        int LA10_40 = input.LA(1);

                         
                        int index10_40 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_40);

                        if ( s>=0 ) return s;
                        break;

                    case 118 : 
                        int LA10_69 = input.LA(1);

                         
                        int index10_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_69);

                        if ( s>=0 ) return s;
                        break;

                    case 119 : 
                        int LA10_38 = input.LA(1);

                        s = -1;
                        if ( (LA10_38=='\"') ) {s = 68;}

                        else if ( (LA10_38=='\\') ) {s = 35;}

                        else if ( (LA10_38=='\'') ) {s = 37;}

                        else if ( (LA10_38==']') ) {s = 36;}

                        else if ( ((LA10_38 >= '\u0000' && LA10_38 <= '!')||(LA10_38 >= '#' && LA10_38 <= '&')||(LA10_38 >= '(' && LA10_38 <= '[')||(LA10_38 >= '^' && LA10_38 <= '\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;

                    case 120 : 
                        int LA10_60 = input.LA(1);

                        s = -1;
                        if ( (LA10_60=='\"') ) {s = 85;}

                        else if ( (LA10_60=='\\') ) {s = 35;}

                        else if ( (LA10_60=='\'') ) {s = 37;}

                        else if ( (LA10_60==']') ) {s = 36;}

                        else if ( ((LA10_60 >= '\u0000' && LA10_60 <= '!')||(LA10_60 >= '#' && LA10_60 <= '&')||(LA10_60 >= '(' && LA10_60 <= '[')||(LA10_60 >= '^' && LA10_60 <= '\uFFFF')) ) {s = 38;}

                        if ( s>=0 ) return s;
                        break;

                    case 121 : 
                        int LA10_169 = input.LA(1);

                         
                        int index10_169 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_169);

                        if ( s>=0 ) return s;
                        break;

                    case 122 : 
                        int LA10_168 = input.LA(1);

                         
                        int index10_168 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_168);

                        if ( s>=0 ) return s;
                        break;

                    case 123 : 
                        int LA10_166 = input.LA(1);

                         
                        int index10_166 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_166);

                        if ( s>=0 ) return s;
                        break;

                    case 124 : 
                        int LA10_161 = input.LA(1);

                         
                        int index10_161 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_161);

                        if ( s>=0 ) return s;
                        break;

                    case 125 : 
                        int LA10_160 = input.LA(1);

                         
                        int index10_160 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_160);

                        if ( s>=0 ) return s;
                        break;

                    case 126 : 
                        int LA10_153 = input.LA(1);

                         
                        int index10_153 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_153);

                        if ( s>=0 ) return s;
                        break;

                    case 127 : 
                        int LA10_138 = input.LA(1);

                         
                        int index10_138 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_138);

                        if ( s>=0 ) return s;
                        break;

                    case 128 : 
                        int LA10_135 = input.LA(1);

                         
                        int index10_135 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_135);

                        if ( s>=0 ) return s;
                        break;

                    case 129 : 
                        int LA10_58 = input.LA(1);

                         
                        int index10_58 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_58);

                        if ( s>=0 ) return s;
                        break;

                    case 130 : 
                        int LA10_84 = input.LA(1);

                         
                        int index10_84 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_84);

                        if ( s>=0 ) return s;
                        break;

                    case 131 : 
                        int LA10_50 = input.LA(1);

                        s = -1;
                        if ( (LA10_50=='\'') ) {s = 78;}

                        else if ( (LA10_50=='\\') ) {s = 79;}

                        else if ( (LA10_50=='\"') ) {s = 80;}

                        else if ( ((LA10_50 >= '\u0000' && LA10_50 <= '!')||(LA10_50 >= '#' && LA10_50 <= '&')||(LA10_50 >= '(' && LA10_50 <= '[')||(LA10_50 >= ']' && LA10_50 <= '\uFFFF')) ) {s = 81;}

                        else s = 5;

                        if ( s>=0 ) return s;
                        break;

                    case 132 : 
                        int LA10_136 = input.LA(1);

                        s = -1;
                        if ( (LA10_136=='\'') ) {s = 134;}

                        else if ( (LA10_136=='\\') ) {s = 132;}

                        else if ( (LA10_136==']') ) {s = 133;}

                        else if ( (LA10_136=='\"') ) {s = 161;}

                        else if ( ((LA10_136 >= '\u0000' && LA10_136 <= '!')||(LA10_136 >= '#' && LA10_136 <= '&')||(LA10_136 >= '(' && LA10_136 <= '[')||(LA10_136 >= '^' && LA10_136 <= '\uFFFF')) ) {s = 136;}

                        if ( s>=0 ) return s;
                        break;

                    case 133 : 
                        int LA10_139 = input.LA(1);

                         
                        int index10_139 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 126;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_139);

                        if ( s>=0 ) return s;
                        break;

                    case 134 : 
                        int LA10_101 = input.LA(1);

                         
                        int index10_101 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_101);

                        if ( s>=0 ) return s;
                        break;

                    case 135 : 
                        int LA10_100 = input.LA(1);

                         
                        int index10_100 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_100);

                        if ( s>=0 ) return s;
                        break;

                    case 136 : 
                        int LA10_99 = input.LA(1);

                         
                        int index10_99 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_99);

                        if ( s>=0 ) return s;
                        break;

                    case 137 : 
                        int LA10_48 = input.LA(1);

                         
                        int index10_48 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_48);

                        if ( s>=0 ) return s;
                        break;

                    case 138 : 
                        int LA10_71 = input.LA(1);

                         
                        int index10_71 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_71);

                        if ( s>=0 ) return s;
                        break;

                    case 139 : 
                        int LA10_82 = input.LA(1);

                         
                        int index10_82 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_82);

                        if ( s>=0 ) return s;
                        break;

                    case 140 : 
                        int LA10_83 = input.LA(1);

                         
                        int index10_83 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred5_ANTLRLexer()) ) {s = 47;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_83);

                        if ( s>=0 ) return s;
                        break;

                    case 141 : 
                        int LA10_133 = input.LA(1);

                         
                        int index10_133 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_133=='\'') ) {s = 78;}

                        else if ( (LA10_133=='\\') ) {s = 79;}

                        else if ( (LA10_133=='\"') ) {s = 80;}

                        else if ( ((LA10_133 >= '\u0000' && LA10_133 <= '!')||(LA10_133 >= '#' && LA10_133 <= '&')||(LA10_133 >= '(' && LA10_133 <= '[')||(LA10_133 >= ']' && LA10_133 <= '\uFFFF')) ) {s = 81;}

                        else s = 126;

                         
                        input.seek(index10_133);

                        if ( s>=0 ) return s;
                        break;

                    case 142 : 
                        int LA10_125 = input.LA(1);

                         
                        int index10_125 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_125);

                        if ( s>=0 ) return s;
                        break;

                    case 143 : 
                        int LA10_34 = input.LA(1);

                         
                        int index10_34 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_34);

                        if ( s>=0 ) return s;
                        break;

                    case 144 : 
                        int LA10_56 = input.LA(1);

                         
                        int index10_56 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_56);

                        if ( s>=0 ) return s;
                        break;

                    case 145 : 
                        int LA10_67 = input.LA(1);

                         
                        int index10_67 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_67);

                        if ( s>=0 ) return s;
                        break;

                    case 146 : 
                        int LA10_68 = input.LA(1);

                         
                        int index10_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_68);

                        if ( s>=0 ) return s;
                        break;

                    case 147 : 
                        int LA10_85 = input.LA(1);

                         
                        int index10_85 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_85);

                        if ( s>=0 ) return s;
                        break;

                    case 148 : 
                        int LA10_86 = input.LA(1);

                         
                        int index10_86 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_86);

                        if ( s>=0 ) return s;
                        break;

                    case 149 : 
                        int LA10_87 = input.LA(1);

                         
                        int index10_87 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 33;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_87);

                        if ( s>=0 ) return s;
                        break;

                    case 150 : 
                        int LA10_94 = input.LA(1);

                        s = -1;
                        if ( (LA10_94=='\"') ) {s = 93;}

                        else if ( (LA10_94=='\\') ) {s = 94;}

                        else if ( (LA10_94=='\'') ) {s = 95;}

                        else if ( ((LA10_94 >= '\u0000' && LA10_94 <= '!')||(LA10_94 >= '#' && LA10_94 <= '&')||(LA10_94 >= '(' && LA10_94 <= '[')||(LA10_94 >= ']' && LA10_94 <= '\uFFFF')) ) {s = 96;}

                        if ( s>=0 ) return s;
                        break;

                    case 151 : 
                        int LA10_141 = input.LA(1);

                         
                        int index10_141 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_141);

                        if ( s>=0 ) return s;
                        break;

                    case 152 : 
                        int LA10_116 = input.LA(1);

                         
                        int index10_116 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (synpred4_ANTLRLexer()) ) {s = 112;}

                        else if ( (true) ) {s = 5;}

                         
                        input.seek(index10_116);

                        if ( s>=0 ) return s;
                        break;

                    case 153 : 
                        int LA10_4 = input.LA(1);

                        s = -1;
                        if ( (LA10_4=='\\') ) {s = 16;}

                        else if ( (LA10_4==']') ) {s = 17;}

                        else if ( (LA10_4=='\'') ) {s = 18;}

                        else if ( (LA10_4=='\"') ) {s = 19;}

                        else if ( ((LA10_4 >= '\u0000' && LA10_4 <= '!')||(LA10_4 >= '#' && LA10_4 <= '&')||(LA10_4 >= '(' && LA10_4 <= '[')||(LA10_4 >= '^' && LA10_4 <= '\uFFFF')) ) {s = 20;}

                        if ( s>=0 ) return s;
                        break;

                    case 154 : 
                        int LA10_2 = input.LA(1);

                        s = -1;
                        if ( (LA10_2==']') ) {s = 6;}

                        else if ( (LA10_2=='\\') ) {s = 7;}

                        else if ( (LA10_2=='\"') ) {s = 8;}

                        else if ( (LA10_2=='\'') ) {s = 9;}

                        else if ( ((LA10_2 >= '\u0000' && LA10_2 <= '!')||(LA10_2 >= '#' && LA10_2 <= '&')||(LA10_2 >= '(' && LA10_2 <= '[')||(LA10_2 >= '^' && LA10_2 <= '\uFFFF')) ) {s = 10;}

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA30_eotS =
        "\2\uffff\1\45\1\uffff\12\52\1\72\4\uffff\1\45\5\uffff\1\106\2\uffff"+
        "\1\112\6\uffff\1\45\5\uffff\1\52\1\uffff\16\52\20\uffff\1\143\10"+
        "\uffff\20\52\2\uffff\17\52\1\u0083\6\52\1\u008a\7\52\1\u0092\1\uffff"+
        "\2\52\1\u0095\1\u0096\2\52\1\uffff\1\u0099\1\u009a\2\52\1\u009d"+
        "\2\52\1\uffff\1\52\3\uffff\1\52\1\u00a2\2\uffff\1\52\1\u00a4\1\uffff"+
        "\1\u00a5\1\u00a6\1\uffff\1\u00a7\1\uffff\1\52\4\uffff\1\u00a9\1"+
        "\uffff";
    static final String DFA30_eofS =
        "\u00aa\uffff";
    static final String DFA30_minS =
        "\1\0\1\uffff\1\0\1\uffff\1\160\1\150\1\155\1\151\1\145\1\141\1\162"+
        "\1\145\1\141\1\157\1\72\4\uffff\1\76\5\uffff\1\75\2\uffff\1\56\6"+
        "\uffff\1\0\5\uffff\1\164\1\uffff\1\153\1\162\1\160\1\141\1\156\1"+
        "\170\1\143\1\162\1\151\1\142\1\141\2\164\1\144\20\uffff\1\56\10"+
        "\uffff\1\151\1\145\2\157\1\147\1\141\1\145\1\141\1\163\1\164\1\166"+
        "\1\154\1\155\1\165\1\143\1\145\2\uffff\1\157\1\156\1\167\1\162\1"+
        "\155\1\154\1\162\1\154\2\145\1\141\1\151\1\155\1\162\1\150\1\60"+
        "\1\156\2\163\1\164\1\145\1\154\1\60\1\163\1\162\1\143\1\164\1\143"+
        "\1\141\1\156\1\60\1\uffff\1\163\1\11\2\60\1\156\1\171\1\uffff\2"+
        "\60\1\164\1\145\1\60\1\162\1\163\1\uffff\1\11\3\uffff\1\164\1\60"+
        "\2\uffff\1\145\1\60\1\uffff\2\60\1\uffff\1\60\1\uffff\1\144\4\uffff"+
        "\1\60\1\uffff";
    static final String DFA30_maxS =
        "\1\uffff\1\uffff\1\uffff\1\uffff\1\160\1\157\1\155\1\162\1\157\1"+
        "\165\1\162\1\145\1\141\1\157\1\72\4\uffff\1\76\5\uffff\1\75\2\uffff"+
        "\1\56\6\uffff\1\uffff\5\uffff\1\164\1\uffff\1\153\1\162\1\160\1"+
        "\141\1\156\1\170\1\143\1\162\1\157\1\142\1\141\2\164\1\144\20\uffff"+
        "\1\56\10\uffff\1\151\1\145\2\157\1\147\1\141\1\145\1\141\1\163\1"+
        "\164\1\166\1\154\1\155\1\165\1\143\1\145\2\uffff\1\157\1\156\1\167"+
        "\1\162\1\155\1\154\1\162\1\154\2\145\1\141\1\151\1\155\1\162\1\150"+
        "\1\ufffd\1\156\2\163\1\164\1\145\1\154\1\ufffd\1\163\1\162\1\143"+
        "\1\164\1\143\1\141\1\156\1\ufffd\1\uffff\1\163\1\173\2\ufffd\1\156"+
        "\1\171\1\uffff\2\ufffd\1\164\1\145\1\ufffd\1\162\1\163\1\uffff\1"+
        "\173\3\uffff\1\164\1\ufffd\2\uffff\1\145\1\ufffd\1\uffff\2\ufffd"+
        "\1\uffff\1\ufffd\1\uffff\1\144\4\uffff\1\ufffd\1\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\1\1\uffff\1\3\13\uffff\1\26\1\27\1\30\1\31\1\uffff\1"+
        "\33\1\34\1\35\1\36\1\37\1\uffff\1\42\1\43\1\uffff\1\47\1\50\1\51"+
        "\1\52\1\53\1\54\1\uffff\1\56\1\57\1\1\1\2\1\3\1\uffff\1\53\16\uffff"+
        "\1\25\1\24\1\26\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\41"+
        "\1\40\1\42\1\43\1\uffff\1\44\1\47\1\50\1\51\1\52\1\54\1\55\1\56"+
        "\20\uffff\1\46\1\45\37\uffff\1\23\6\uffff\1\10\7\uffff\1\21\1\uffff"+
        "\1\5\1\20\1\6\2\uffff\1\17\1\11\2\uffff\1\14\2\uffff\1\4\1\uffff"+
        "\1\22\1\uffff\1\15\1\12\1\16\1\7\1\uffff\1\13";
    static final String DFA30_specialS =
        "\1\1\1\uffff\1\2\40\uffff\1\0\u0086\uffff}>";
    static final String[] DFA30_transitionS = {
            "\11\45\2\44\1\45\2\44\22\45\1\44\2\45\1\36\1\33\2\45\1\43\1"+
            "\21\1\22\1\30\1\31\1\17\1\23\1\34\1\1\12\42\1\16\1\20\1\24\1"+
            "\26\1\25\1\27\1\35\32\41\1\2\5\45\2\41\1\14\2\41\1\7\1\12\1"+
            "\41\1\6\2\41\1\10\1\15\1\41\1\4\1\11\1\41\1\13\1\41\1\5\6\41"+
            "\1\3\1\32\1\40\1\37\101\45\27\41\1\45\37\41\1\45\u0208\41\160"+
            "\45\16\41\1\45\u1c81\41\14\45\2\41\142\45\u0120\41\u0a70\45"+
            "\u03f0\41\21\45\ua7ff\41\u2100\45\u04d0\41\40\45\u020e\41\2"+
            "\45",
            "",
            "\0\47",
            "",
            "\1\51",
            "\1\54\6\uffff\1\53",
            "\1\55",
            "\1\57\10\uffff\1\56",
            "\1\60\11\uffff\1\61",
            "\1\62\20\uffff\1\63\2\uffff\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "",
            "",
            "",
            "",
            "\1\77",
            "",
            "",
            "",
            "",
            "",
            "\1\105",
            "",
            "",
            "\1\111",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\120",
            "",
            "",
            "",
            "",
            "",
            "\1\122",
            "",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\134\5\uffff\1\133",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\142",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "",
            "\1\u0093",
            "\2\u0094\1\uffff\2\u0094\22\uffff\1\u0094\132\uffff\1\u0094",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\1\u0097",
            "\1\u0098",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\1\u009b",
            "\1\u009c",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\1\u009e",
            "\1\u009f",
            "",
            "\2\u00a0\1\uffff\2\u00a0\22\uffff\1\u00a0\132\uffff\1\u00a0",
            "",
            "",
            "",
            "\1\u00a1",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "",
            "",
            "\1\u00a3",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            "",
            "\1\u00a8",
            "",
            "",
            "",
            "",
            "\12\52\7\uffff\32\52\4\uffff\1\52\1\uffff\32\52\74\uffff\1"+
            "\52\10\uffff\27\52\1\uffff\37\52\1\uffff\u0286\52\1\uffff\u1c81"+
            "\52\14\uffff\2\52\61\uffff\2\52\57\uffff\u0120\52\u0a70\uffff"+
            "\u03f0\52\21\uffff\ua7ff\52\u2100\uffff\u04d0\52\40\uffff\u020e"+
            "\52",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( COMMENT | ARG_OR_CHARSET | ACTION | OPTIONS | TOKENS_SPEC | IMPORT | FRAGMENT | LEXER | PARSER | GRAMMAR | PROTECTED | PUBLIC | PRIVATE | RETURNS | LOCALS | THROWS | CATCH | FINALLY | MODE | COLON | COLONCOLON | COMMA | SEMI | LPAREN | RPAREN | RARROW | LT | GT | ASSIGN | QUESTION | STAR | PLUS | PLUS_ASSIGN | OR | DOLLAR | DOT | RANGE | ETC | AT | POUND | NOT | RBRACE | ID | INT | STRING_LITERAL | WS | ERRCHAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_35 = input.LA(1);

                        s = -1;
                        if ( ((LA30_35 >= '\u0000' && LA30_35 <= '\uFFFF')) ) {s = 80;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA30_0 = input.LA(1);

                        s = -1;
                        if ( (LA30_0=='/') ) {s = 1;}

                        else if ( (LA30_0=='[') ) {s = 2;}

                        else if ( (LA30_0=='{') ) {s = 3;}

                        else if ( (LA30_0=='o') ) {s = 4;}

                        else if ( (LA30_0=='t') ) {s = 5;}

                        else if ( (LA30_0=='i') ) {s = 6;}

                        else if ( (LA30_0=='f') ) {s = 7;}

                        else if ( (LA30_0=='l') ) {s = 8;}

                        else if ( (LA30_0=='p') ) {s = 9;}

                        else if ( (LA30_0=='g') ) {s = 10;}

                        else if ( (LA30_0=='r') ) {s = 11;}

                        else if ( (LA30_0=='c') ) {s = 12;}

                        else if ( (LA30_0=='m') ) {s = 13;}

                        else if ( (LA30_0==':') ) {s = 14;}

                        else if ( (LA30_0==',') ) {s = 15;}

                        else if ( (LA30_0==';') ) {s = 16;}

                        else if ( (LA30_0=='(') ) {s = 17;}

                        else if ( (LA30_0==')') ) {s = 18;}

                        else if ( (LA30_0=='-') ) {s = 19;}

                        else if ( (LA30_0=='<') ) {s = 20;}

                        else if ( (LA30_0=='>') ) {s = 21;}

                        else if ( (LA30_0=='=') ) {s = 22;}

                        else if ( (LA30_0=='?') ) {s = 23;}

                        else if ( (LA30_0=='*') ) {s = 24;}

                        else if ( (LA30_0=='+') ) {s = 25;}

                        else if ( (LA30_0=='|') ) {s = 26;}

                        else if ( (LA30_0=='$') ) {s = 27;}

                        else if ( (LA30_0=='.') ) {s = 28;}

                        else if ( (LA30_0=='@') ) {s = 29;}

                        else if ( (LA30_0=='#') ) {s = 30;}

                        else if ( (LA30_0=='~') ) {s = 31;}

                        else if ( (LA30_0=='}') ) {s = 32;}

                        else if ( ((LA30_0 >= 'A' && LA30_0 <= 'Z')||(LA30_0 >= 'a' && LA30_0 <= 'b')||(LA30_0 >= 'd' && LA30_0 <= 'e')||LA30_0=='h'||(LA30_0 >= 'j' && LA30_0 <= 'k')||LA30_0=='n'||LA30_0=='q'||LA30_0=='s'||(LA30_0 >= 'u' && LA30_0 <= 'z')||(LA30_0 >= '\u00C0' && LA30_0 <= '\u00D6')||(LA30_0 >= '\u00D8' && LA30_0 <= '\u00F6')||(LA30_0 >= '\u00F8' && LA30_0 <= '\u02FF')||(LA30_0 >= '\u0370' && LA30_0 <= '\u037D')||(LA30_0 >= '\u037F' && LA30_0 <= '\u1FFF')||(LA30_0 >= '\u200C' && LA30_0 <= '\u200D')||(LA30_0 >= '\u2070' && LA30_0 <= '\u218F')||(LA30_0 >= '\u2C00' && LA30_0 <= '\u2FEF')||(LA30_0 >= '\u3001' && LA30_0 <= '\uD7FF')||(LA30_0 >= '\uF900' && LA30_0 <= '\uFDCF')||(LA30_0 >= '\uFDF0' && LA30_0 <= '\uFFFD')) ) {s = 33;}

                        else if ( ((LA30_0 >= '0' && LA30_0 <= '9')) ) {s = 34;}

                        else if ( (LA30_0=='\'') ) {s = 35;}

                        else if ( ((LA30_0 >= '\t' && LA30_0 <= '\n')||(LA30_0 >= '\f' && LA30_0 <= '\r')||LA30_0==' ') ) {s = 36;}

                        else if ( ((LA30_0 >= '\u0000' && LA30_0 <= '\b')||LA30_0=='\u000B'||(LA30_0 >= '\u000E' && LA30_0 <= '\u001F')||(LA30_0 >= '!' && LA30_0 <= '\"')||(LA30_0 >= '%' && LA30_0 <= '&')||(LA30_0 >= '\\' && LA30_0 <= '`')||(LA30_0 >= '\u007F' && LA30_0 <= '\u00BF')||LA30_0=='\u00D7'||LA30_0=='\u00F7'||(LA30_0 >= '\u0300' && LA30_0 <= '\u036F')||LA30_0=='\u037E'||(LA30_0 >= '\u2000' && LA30_0 <= '\u200B')||(LA30_0 >= '\u200E' && LA30_0 <= '\u206F')||(LA30_0 >= '\u2190' && LA30_0 <= '\u2BFF')||(LA30_0 >= '\u2FF0' && LA30_0 <= '\u3000')||(LA30_0 >= '\uD800' && LA30_0 <= '\uF8FF')||(LA30_0 >= '\uFDD0' && LA30_0 <= '\uFDEF')||(LA30_0 >= '\uFFFE' && LA30_0 <= '\uFFFF')) ) {s = 37;}

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA30_2 = input.LA(1);

                         
                        int index30_2 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA30_2 >= '\u0000' && LA30_2 <= '\uFFFF')) && (((!isLexerRule)||(isLexerRule)))) {s = 39;}

                        else s = 37;

                         
                        input.seek(index30_2);

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}

            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}
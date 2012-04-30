// $ANTLR 3.4 ANTLRParser.g 2012-04-29 22:33:15

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

import org.antlr.v4.tool.*;
import org.antlr.v4.tool.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


/** The definitive ANTLR v3 grammar to parse ANTLR v4 grammars.
 *  The grammar builds ASTs that are sniffed by subsequent stages.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class ANTLRParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ACTION", "ACTION_CHAR_LITERAL", "ACTION_ESC", "ACTION_STRING_LITERAL", "ARG_ACTION", "ARG_OR_CHARSET", "ASSIGN", "AT", "CATCH", "COLON", "COLONCOLON", "COMMA", "COMMENT", "DOC_COMMENT", "DOLLAR", "DOT", "ERRCHAR", "ESC_SEQ", "ETC", "FINALLY", "FRAGMENT", "GRAMMAR", "GT", "HEX_DIGIT", "ID", "IMPORT", "INT", "LEXER", "LEXER_CHAR_SET", "LOCALS", "LPAREN", "LT", "MODE", "NESTED_ACTION", "NLCHARS", "NOT", "NameChar", "NameStartChar", "OPTIONS", "OR", "PARSER", "PLUS", "PLUS_ASSIGN", "POUND", "PRIVATE", "PROTECTED", "PUBLIC", "QUESTION", "RANGE", "RARROW", "RBRACE", "RETURNS", "RPAREN", "RULE_REF", "SEMI", "SEMPRED", "SRC", "STAR", "STRING_LITERAL", "THROWS", "TOKENS_SPEC", "TOKEN_REF", "UNICODE_ESC", "WS", "WSCHARS", "WSNLCHARS", "ALT", "ALTLIST", "ARG", "ARGLIST", "BLOCK", "CHAR_RANGE", "CLOSURE", "COMBINED", "ELEMENT_OPTIONS", "EPSILON", "INITACTION", "LABEL", "LEXER_ACTION_CALL", "LEXER_ALT_ACTION", "LIST", "OPTIONAL", "POSITIVE_CLOSURE", "PREC_RULE", "RESULT", "RET", "RULE", "RULEACTIONS", "RULEMODIFIERS", "RULES", "SET", "TEMPLATE", "WILDCARD"
    };

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
    public static final int ALT=70;
    public static final int ALTLIST=71;
    public static final int ARG=72;
    public static final int ARGLIST=73;
    public static final int BLOCK=74;
    public static final int CHAR_RANGE=75;
    public static final int CLOSURE=76;
    public static final int COMBINED=77;
    public static final int ELEMENT_OPTIONS=78;
    public static final int EPSILON=79;
    public static final int INITACTION=80;
    public static final int LABEL=81;
    public static final int LEXER_ACTION_CALL=82;
    public static final int LEXER_ALT_ACTION=83;
    public static final int LIST=84;
    public static final int OPTIONAL=85;
    public static final int POSITIVE_CLOSURE=86;
    public static final int PREC_RULE=87;
    public static final int RESULT=88;
    public static final int RET=89;
    public static final int RULE=90;
    public static final int RULEACTIONS=91;
    public static final int RULEMODIFIERS=92;
    public static final int RULES=93;
    public static final int SET=94;
    public static final int TEMPLATE=95;
    public static final int WILDCARD=96;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public ANTLRParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ANTLRParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return ANTLRParser.tokenNames; }
    public String getGrammarFileName() { return "ANTLRParser.g"; }


    Stack paraphrases = new Stack();
    /** Affects tree construction; no SET collapsing if AST (ID|INT) would hide them from rewrite.
     *  Could use for just AST ops, but we can't see -> until after building sets.
    boolean buildAST;
     */


    public static class grammarSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "grammarSpec"
    // ANTLRParser.g:144:1: grammarSpec : ( DOC_COMMENT )? grammarType id SEMI sync ( prequelConstruct sync )* rules ( modeSpec )* EOF -> ^( grammarType id ( DOC_COMMENT )? ( prequelConstruct )* rules ( modeSpec )* ) ;
    public final ANTLRParser.grammarSpec_return grammarSpec() throws RecognitionException {
        ANTLRParser.grammarSpec_return retval = new ANTLRParser.grammarSpec_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token DOC_COMMENT1=null;
        Token SEMI4=null;
        Token EOF10=null;
        ANTLRParser.grammarType_return grammarType2 =null;

        ANTLRParser.id_return id3 =null;

        ANTLRParser.sync_return sync5 =null;

        ANTLRParser.prequelConstruct_return prequelConstruct6 =null;

        ANTLRParser.sync_return sync7 =null;

        ANTLRParser.rules_return rules8 =null;

        ANTLRParser.modeSpec_return modeSpec9 =null;


        GrammarAST DOC_COMMENT1_tree=null;
        GrammarAST SEMI4_tree=null;
        GrammarAST EOF10_tree=null;
        RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        RewriteRuleSubtreeStream stream_modeSpec=new RewriteRuleSubtreeStream(adaptor,"rule modeSpec");
        RewriteRuleSubtreeStream stream_prequelConstruct=new RewriteRuleSubtreeStream(adaptor,"rule prequelConstruct");
        RewriteRuleSubtreeStream stream_grammarType=new RewriteRuleSubtreeStream(adaptor,"rule grammarType");
        RewriteRuleSubtreeStream stream_rules=new RewriteRuleSubtreeStream(adaptor,"rule rules");
        try {
            // ANTLRParser.g:151:5: ( ( DOC_COMMENT )? grammarType id SEMI sync ( prequelConstruct sync )* rules ( modeSpec )* EOF -> ^( grammarType id ( DOC_COMMENT )? ( prequelConstruct )* rules ( modeSpec )* ) )
            // ANTLRParser.g:155:7: ( DOC_COMMENT )? grammarType id SEMI sync ( prequelConstruct sync )* rules ( modeSpec )* EOF
            {
            // ANTLRParser.g:155:7: ( DOC_COMMENT )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DOC_COMMENT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ANTLRParser.g:155:7: DOC_COMMENT
                    {
                    DOC_COMMENT1=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec402);  
                    stream_DOC_COMMENT.add(DOC_COMMENT1);


                    }
                    break;

            }


            pushFollow(FOLLOW_grammarType_in_grammarSpec433);
            grammarType2=grammarType();

            state._fsp--;

            stream_grammarType.add(grammarType2.getTree());

            pushFollow(FOLLOW_id_in_grammarSpec435);
            id3=id();

            state._fsp--;

            stream_id.add(id3.getTree());

            SEMI4=(Token)match(input,SEMI,FOLLOW_SEMI_in_grammarSpec437);  
            stream_SEMI.add(SEMI4);


            pushFollow(FOLLOW_sync_in_grammarSpec475);
            sync5=sync();

            state._fsp--;

            stream_sync.add(sync5.getTree());

            // ANTLRParser.g:173:12: ( prequelConstruct sync )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AT||LA2_0==IMPORT||LA2_0==OPTIONS||LA2_0==TOKENS_SPEC) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ANTLRParser.g:173:14: prequelConstruct sync
            	    {
            	    pushFollow(FOLLOW_prequelConstruct_in_grammarSpec479);
            	    prequelConstruct6=prequelConstruct();

            	    state._fsp--;

            	    stream_prequelConstruct.add(prequelConstruct6.getTree());

            	    pushFollow(FOLLOW_sync_in_grammarSpec481);
            	    sync7=sync();

            	    state._fsp--;

            	    stream_sync.add(sync7.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            pushFollow(FOLLOW_rules_in_grammarSpec506);
            rules8=rules();

            state._fsp--;

            stream_rules.add(rules8.getTree());

            // ANTLRParser.g:181:4: ( modeSpec )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==MODE) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ANTLRParser.g:181:4: modeSpec
            	    {
            	    pushFollow(FOLLOW_modeSpec_in_grammarSpec512);
            	    modeSpec9=modeSpec();

            	    state._fsp--;

            	    stream_modeSpec.add(modeSpec9.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            EOF10=(Token)match(input,EOF,FOLLOW_EOF_in_grammarSpec550);  
            stream_EOF.add(EOF10);


            // AST REWRITE
            // elements: DOC_COMMENT, modeSpec, id, grammarType, rules, prequelConstruct
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 194:7: -> ^( grammarType id ( DOC_COMMENT )? ( prequelConstruct )* rules ( modeSpec )* )
            {
                // ANTLRParser.g:194:10: ^( grammarType id ( DOC_COMMENT )? ( prequelConstruct )* rules ( modeSpec )* )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(stream_grammarType.nextNode(), root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                // ANTLRParser.g:196:14: ( DOC_COMMENT )?
                if ( stream_DOC_COMMENT.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_DOC_COMMENT.nextNode()
                    );

                }
                stream_DOC_COMMENT.reset();

                // ANTLRParser.g:197:14: ( prequelConstruct )*
                while ( stream_prequelConstruct.hasNext() ) {
                    adaptor.addChild(root_1, stream_prequelConstruct.nextTree());

                }
                stream_prequelConstruct.reset();

                adaptor.addChild(root_1, stream_rules.nextTree());

                // ANTLRParser.g:199:14: ( modeSpec )*
                while ( stream_modeSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_modeSpec.nextTree());

                }
                stream_modeSpec.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            GrammarAST options = (GrammarAST)((GrammarAST)retval.tree).getFirstChildWithType(ANTLRParser.OPTIONS);
            if ( options!=null ) {
            	Grammar.setNodeOptions(((GrammarAST)retval.tree), options);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "grammarSpec"


    public static class grammarType_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "grammarType"
    // ANTLRParser.g:203:1: grammarType : (t= LEXER g= GRAMMAR -> GRAMMAR[$g, \"LEXER_GRAMMAR\"] |t= PARSER g= GRAMMAR -> GRAMMAR[$g, \"PARSER_GRAMMAR\"] |g= GRAMMAR -> GRAMMAR[$g, \"COMBINED_GRAMMAR\"] ) ;
    public final ANTLRParser.grammarType_return grammarType() throws RecognitionException {
        ANTLRParser.grammarType_return retval = new ANTLRParser.grammarType_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token t=null;
        Token g=null;

        GrammarAST t_tree=null;
        GrammarAST g_tree=null;
        RewriteRuleTokenStream stream_PARSER=new RewriteRuleTokenStream(adaptor,"token PARSER");
        RewriteRuleTokenStream stream_LEXER=new RewriteRuleTokenStream(adaptor,"token LEXER");
        RewriteRuleTokenStream stream_GRAMMAR=new RewriteRuleTokenStream(adaptor,"token GRAMMAR");

        try {
            // ANTLRParser.g:208:5: ( (t= LEXER g= GRAMMAR -> GRAMMAR[$g, \"LEXER_GRAMMAR\"] |t= PARSER g= GRAMMAR -> GRAMMAR[$g, \"PARSER_GRAMMAR\"] |g= GRAMMAR -> GRAMMAR[$g, \"COMBINED_GRAMMAR\"] ) )
            // ANTLRParser.g:208:7: (t= LEXER g= GRAMMAR -> GRAMMAR[$g, \"LEXER_GRAMMAR\"] |t= PARSER g= GRAMMAR -> GRAMMAR[$g, \"PARSER_GRAMMAR\"] |g= GRAMMAR -> GRAMMAR[$g, \"COMBINED_GRAMMAR\"] )
            {
            // ANTLRParser.g:208:7: (t= LEXER g= GRAMMAR -> GRAMMAR[$g, \"LEXER_GRAMMAR\"] |t= PARSER g= GRAMMAR -> GRAMMAR[$g, \"PARSER_GRAMMAR\"] |g= GRAMMAR -> GRAMMAR[$g, \"COMBINED_GRAMMAR\"] )
            int alt4=3;
            switch ( input.LA(1) ) {
            case LEXER:
                {
                alt4=1;
                }
                break;
            case PARSER:
                {
                alt4=2;
                }
                break;
            case GRAMMAR:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // ANTLRParser.g:208:9: t= LEXER g= GRAMMAR
                    {
                    t=(Token)match(input,LEXER,FOLLOW_LEXER_in_grammarType740);  
                    stream_LEXER.add(t);


                    g=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType744);  
                    stream_GRAMMAR.add(g);


                    // AST REWRITE
                    // elements: GRAMMAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 208:28: -> GRAMMAR[$g, \"LEXER_GRAMMAR\"]
                    {
                        adaptor.addChild(root_0, 
                        new GrammarRootAST(GRAMMAR, g, "LEXER_GRAMMAR")
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:210:6: t= PARSER g= GRAMMAR
                    {
                    t=(Token)match(input,PARSER,FOLLOW_PARSER_in_grammarType767);  
                    stream_PARSER.add(t);


                    g=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType771);  
                    stream_GRAMMAR.add(g);


                    // AST REWRITE
                    // elements: GRAMMAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 210:25: -> GRAMMAR[$g, \"PARSER_GRAMMAR\"]
                    {
                        adaptor.addChild(root_0, 
                        new GrammarRootAST(GRAMMAR, g, "PARSER_GRAMMAR")
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // ANTLRParser.g:213:6: g= GRAMMAR
                    {
                    g=(Token)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarType792);  
                    stream_GRAMMAR.add(g);


                    // AST REWRITE
                    // elements: GRAMMAR
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 213:25: -> GRAMMAR[$g, \"COMBINED_GRAMMAR\"]
                    {
                        adaptor.addChild(root_0, 
                        new GrammarRootAST(GRAMMAR, g, "COMBINED_GRAMMAR")
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            	if ( t!=null ) ((GrammarRootAST)((GrammarAST)retval.tree)).grammarType = (t!=null?t.getType():0);
            	else ((GrammarRootAST)((GrammarAST)retval.tree)).grammarType=COMBINED;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "grammarType"


    public static class prequelConstruct_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "prequelConstruct"
    // ANTLRParser.g:220:1: prequelConstruct : ( optionsSpec | delegateGrammars | tokensSpec | action );
    public final ANTLRParser.prequelConstruct_return prequelConstruct() throws RecognitionException {
        ANTLRParser.prequelConstruct_return retval = new ANTLRParser.prequelConstruct_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.optionsSpec_return optionsSpec11 =null;

        ANTLRParser.delegateGrammars_return delegateGrammars12 =null;

        ANTLRParser.tokensSpec_return tokensSpec13 =null;

        ANTLRParser.action_return action14 =null;



        try {
            // ANTLRParser.g:221:2: ( optionsSpec | delegateGrammars | tokensSpec | action )
            int alt5=4;
            switch ( input.LA(1) ) {
            case OPTIONS:
                {
                alt5=1;
                }
                break;
            case IMPORT:
                {
                alt5=2;
                }
                break;
            case TOKENS_SPEC:
                {
                alt5=3;
                }
                break;
            case AT:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // ANTLRParser.g:222:4: optionsSpec
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_optionsSpec_in_prequelConstruct834);
                    optionsSpec11=optionsSpec();

                    state._fsp--;

                    adaptor.addChild(root_0, optionsSpec11.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:226:7: delegateGrammars
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_delegateGrammars_in_prequelConstruct857);
                    delegateGrammars12=delegateGrammars();

                    state._fsp--;

                    adaptor.addChild(root_0, delegateGrammars12.getTree());

                    }
                    break;
                case 3 :
                    // ANTLRParser.g:233:7: tokensSpec
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_tokensSpec_in_prequelConstruct901);
                    tokensSpec13=tokensSpec();

                    state._fsp--;

                    adaptor.addChild(root_0, tokensSpec13.getTree());

                    }
                    break;
                case 4 :
                    // ANTLRParser.g:239:7: action
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_action_in_prequelConstruct938);
                    action14=action();

                    state._fsp--;

                    adaptor.addChild(root_0, action14.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prequelConstruct"


    public static class optionsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "optionsSpec"
    // ANTLRParser.g:243:1: optionsSpec : OPTIONS ( option SEMI )* RBRACE -> ^( OPTIONS[$OPTIONS, \"OPTIONS\"] ( option )+ ) ;
    public final ANTLRParser.optionsSpec_return optionsSpec() throws RecognitionException {
        ANTLRParser.optionsSpec_return retval = new ANTLRParser.optionsSpec_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token OPTIONS15=null;
        Token SEMI17=null;
        Token RBRACE18=null;
        ANTLRParser.option_return option16 =null;


        GrammarAST OPTIONS15_tree=null;
        GrammarAST SEMI17_tree=null;
        GrammarAST RBRACE18_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_OPTIONS=new RewriteRuleTokenStream(adaptor,"token OPTIONS");
        RewriteRuleSubtreeStream stream_option=new RewriteRuleSubtreeStream(adaptor,"rule option");
        try {
            // ANTLRParser.g:244:2: ( OPTIONS ( option SEMI )* RBRACE -> ^( OPTIONS[$OPTIONS, \"OPTIONS\"] ( option )+ ) )
            // ANTLRParser.g:244:4: OPTIONS ( option SEMI )* RBRACE
            {
            OPTIONS15=(Token)match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec953);  
            stream_OPTIONS.add(OPTIONS15);


            // ANTLRParser.g:244:12: ( option SEMI )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_REF||LA6_0==TOKEN_REF) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ANTLRParser.g:244:13: option SEMI
            	    {
            	    pushFollow(FOLLOW_option_in_optionsSpec956);
            	    option16=option();

            	    state._fsp--;

            	    stream_option.add(option16.getTree());

            	    SEMI17=(Token)match(input,SEMI,FOLLOW_SEMI_in_optionsSpec958);  
            	    stream_SEMI.add(SEMI17);


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            RBRACE18=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_optionsSpec962);  
            stream_RBRACE.add(RBRACE18);


            // AST REWRITE
            // elements: option, OPTIONS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 244:34: -> ^( OPTIONS[$OPTIONS, \"OPTIONS\"] ( option )+ )
            {
                // ANTLRParser.g:244:37: ^( OPTIONS[$OPTIONS, \"OPTIONS\"] ( option )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                (GrammarAST)adaptor.create(OPTIONS, OPTIONS15, "OPTIONS")
                , root_1);

                if ( !(stream_option.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_option.hasNext() ) {
                    adaptor.addChild(root_1, stream_option.nextTree());

                }
                stream_option.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "optionsSpec"


    public static class option_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "option"
    // ANTLRParser.g:247:1: option : id ASSIGN ^ optionValue ;
    public final ANTLRParser.option_return option() throws RecognitionException {
        ANTLRParser.option_return retval = new ANTLRParser.option_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token ASSIGN20=null;
        ANTLRParser.id_return id19 =null;

        ANTLRParser.optionValue_return optionValue21 =null;


        GrammarAST ASSIGN20_tree=null;

        try {
            // ANTLRParser.g:248:5: ( id ASSIGN ^ optionValue )
            // ANTLRParser.g:248:9: id ASSIGN ^ optionValue
            {
            root_0 = (GrammarAST)adaptor.nil();


            pushFollow(FOLLOW_id_in_option991);
            id19=id();

            state._fsp--;

            adaptor.addChild(root_0, id19.getTree());

            ASSIGN20=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_option993); 
            ASSIGN20_tree = 
            (GrammarAST)adaptor.create(ASSIGN20)
            ;
            root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN20_tree, root_0);


            pushFollow(FOLLOW_optionValue_in_option996);
            optionValue21=optionValue();

            state._fsp--;

            adaptor.addChild(root_0, optionValue21.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "option"


    public static class optionValue_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "optionValue"
    // ANTLRParser.g:256:1: optionValue : ( qid | STRING_LITERAL | ACTION | INT );
    public final ANTLRParser.optionValue_return optionValue() throws RecognitionException {
        ANTLRParser.optionValue_return retval = new ANTLRParser.optionValue_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token STRING_LITERAL23=null;
        Token ACTION24=null;
        Token INT25=null;
        ANTLRParser.qid_return qid22 =null;


        GrammarAST STRING_LITERAL23_tree=null;
        GrammarAST ACTION24_tree=null;
        GrammarAST INT25_tree=null;

        try {
            // ANTLRParser.g:257:5: ( qid | STRING_LITERAL | ACTION | INT )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_REF:
            case TOKEN_REF:
                {
                alt7=1;
                }
                break;
            case STRING_LITERAL:
                {
                alt7=2;
                }
                break;
            case ACTION:
                {
                alt7=3;
                }
                break;
            case INT:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // ANTLRParser.g:260:7: qid
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_qid_in_optionValue1039);
                    qid22=qid();

                    state._fsp--;

                    adaptor.addChild(root_0, qid22.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:261:7: STRING_LITERAL
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    STRING_LITERAL23=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_optionValue1047); 
                    STRING_LITERAL23_tree = 
                    (GrammarAST)adaptor.create(STRING_LITERAL23)
                    ;
                    adaptor.addChild(root_0, STRING_LITERAL23_tree);


                    }
                    break;
                case 3 :
                    // ANTLRParser.g:262:4: ACTION
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    ACTION24=(Token)match(input,ACTION,FOLLOW_ACTION_in_optionValue1052); 
                    ACTION24_tree = 
                    new ActionAST(ACTION24) 
                    ;
                    adaptor.addChild(root_0, ACTION24_tree);


                    }
                    break;
                case 4 :
                    // ANTLRParser.g:263:7: INT
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    INT25=(Token)match(input,INT,FOLLOW_INT_in_optionValue1063); 
                    INT25_tree = 
                    (GrammarAST)adaptor.create(INT25)
                    ;
                    adaptor.addChild(root_0, INT25_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "optionValue"


    public static class delegateGrammars_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "delegateGrammars"
    // ANTLRParser.g:268:1: delegateGrammars : IMPORT delegateGrammar ( COMMA delegateGrammar )* SEMI -> ^( IMPORT ( delegateGrammar )+ ) ;
    public final ANTLRParser.delegateGrammars_return delegateGrammars() throws RecognitionException {
        ANTLRParser.delegateGrammars_return retval = new ANTLRParser.delegateGrammars_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token IMPORT26=null;
        Token COMMA28=null;
        Token SEMI30=null;
        ANTLRParser.delegateGrammar_return delegateGrammar27 =null;

        ANTLRParser.delegateGrammar_return delegateGrammar29 =null;


        GrammarAST IMPORT26_tree=null;
        GrammarAST COMMA28_tree=null;
        GrammarAST SEMI30_tree=null;
        RewriteRuleTokenStream stream_IMPORT=new RewriteRuleTokenStream(adaptor,"token IMPORT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleSubtreeStream stream_delegateGrammar=new RewriteRuleSubtreeStream(adaptor,"rule delegateGrammar");
        try {
            // ANTLRParser.g:269:2: ( IMPORT delegateGrammar ( COMMA delegateGrammar )* SEMI -> ^( IMPORT ( delegateGrammar )+ ) )
            // ANTLRParser.g:269:4: IMPORT delegateGrammar ( COMMA delegateGrammar )* SEMI
            {
            IMPORT26=(Token)match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars1079);  
            stream_IMPORT.add(IMPORT26);


            pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars1081);
            delegateGrammar27=delegateGrammar();

            state._fsp--;

            stream_delegateGrammar.add(delegateGrammar27.getTree());

            // ANTLRParser.g:269:27: ( COMMA delegateGrammar )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==COMMA) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ANTLRParser.g:269:28: COMMA delegateGrammar
            	    {
            	    COMMA28=(Token)match(input,COMMA,FOLLOW_COMMA_in_delegateGrammars1084);  
            	    stream_COMMA.add(COMMA28);


            	    pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars1086);
            	    delegateGrammar29=delegateGrammar();

            	    state._fsp--;

            	    stream_delegateGrammar.add(delegateGrammar29.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            SEMI30=(Token)match(input,SEMI,FOLLOW_SEMI_in_delegateGrammars1090);  
            stream_SEMI.add(SEMI30);


            // AST REWRITE
            // elements: IMPORT, delegateGrammar
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 269:57: -> ^( IMPORT ( delegateGrammar )+ )
            {
                // ANTLRParser.g:269:60: ^( IMPORT ( delegateGrammar )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_IMPORT.nextNode()
                , root_1);

                if ( !(stream_delegateGrammar.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_delegateGrammar.hasNext() ) {
                    adaptor.addChild(root_1, stream_delegateGrammar.nextTree());

                }
                stream_delegateGrammar.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "delegateGrammars"


    public static class delegateGrammar_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "delegateGrammar"
    // ANTLRParser.g:274:1: delegateGrammar : ( id ASSIGN ^ id | id );
    public final ANTLRParser.delegateGrammar_return delegateGrammar() throws RecognitionException {
        ANTLRParser.delegateGrammar_return retval = new ANTLRParser.delegateGrammar_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token ASSIGN32=null;
        ANTLRParser.id_return id31 =null;

        ANTLRParser.id_return id33 =null;

        ANTLRParser.id_return id34 =null;


        GrammarAST ASSIGN32_tree=null;

        try {
            // ANTLRParser.g:275:5: ( id ASSIGN ^ id | id )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_REF) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==ASSIGN) ) {
                    alt9=1;
                }
                else if ( (LA9_1==COMMA||LA9_1==SEMI) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA9_0==TOKEN_REF) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==ASSIGN) ) {
                    alt9=1;
                }
                else if ( (LA9_2==COMMA||LA9_2==SEMI) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // ANTLRParser.g:275:9: id ASSIGN ^ id
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_id_in_delegateGrammar1117);
                    id31=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id31.getTree());

                    ASSIGN32=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammar1119); 
                    ASSIGN32_tree = 
                    (GrammarAST)adaptor.create(ASSIGN32)
                    ;
                    root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN32_tree, root_0);


                    pushFollow(FOLLOW_id_in_delegateGrammar1122);
                    id33=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id33.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:276:9: id
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_id_in_delegateGrammar1132);
                    id34=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id34.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "delegateGrammar"


    public static class tokensSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tokensSpec"
    // ANTLRParser.g:285:1: tokensSpec : TOKENS_SPEC ( tokenSpec )+ RBRACE -> ^( TOKENS_SPEC ( tokenSpec )+ ) ;
    public final ANTLRParser.tokensSpec_return tokensSpec() throws RecognitionException {
        ANTLRParser.tokensSpec_return retval = new ANTLRParser.tokensSpec_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token TOKENS_SPEC35=null;
        Token RBRACE37=null;
        ANTLRParser.tokenSpec_return tokenSpec36 =null;


        GrammarAST TOKENS_SPEC35_tree=null;
        GrammarAST RBRACE37_tree=null;
        RewriteRuleTokenStream stream_RBRACE=new RewriteRuleTokenStream(adaptor,"token RBRACE");
        RewriteRuleTokenStream stream_TOKENS_SPEC=new RewriteRuleTokenStream(adaptor,"token TOKENS_SPEC");
        RewriteRuleSubtreeStream stream_tokenSpec=new RewriteRuleSubtreeStream(adaptor,"rule tokenSpec");
        try {
            // ANTLRParser.g:286:2: ( TOKENS_SPEC ( tokenSpec )+ RBRACE -> ^( TOKENS_SPEC ( tokenSpec )+ ) )
            // ANTLRParser.g:286:4: TOKENS_SPEC ( tokenSpec )+ RBRACE
            {
            TOKENS_SPEC35=(Token)match(input,TOKENS_SPEC,FOLLOW_TOKENS_SPEC_in_tokensSpec1148);  
            stream_TOKENS_SPEC.add(TOKENS_SPEC35);


            // ANTLRParser.g:286:16: ( tokenSpec )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_REF||LA10_0==TOKEN_REF) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ANTLRParser.g:286:16: tokenSpec
            	    {
            	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec1150);
            	    tokenSpec36=tokenSpec();

            	    state._fsp--;

            	    stream_tokenSpec.add(tokenSpec36.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            RBRACE37=(Token)match(input,RBRACE,FOLLOW_RBRACE_in_tokensSpec1153);  
            stream_RBRACE.add(RBRACE37);


            // AST REWRITE
            // elements: TOKENS_SPEC, tokenSpec
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 286:34: -> ^( TOKENS_SPEC ( tokenSpec )+ )
            {
                // ANTLRParser.g:286:37: ^( TOKENS_SPEC ( tokenSpec )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_TOKENS_SPEC.nextNode()
                , root_1);

                if ( !(stream_tokenSpec.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_tokenSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_tokenSpec.nextTree());

                }
                stream_tokenSpec.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tokensSpec"


    public static class tokenSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "tokenSpec"
    // ANTLRParser.g:289:1: tokenSpec : ( id ( ASSIGN STRING_LITERAL -> ^( ASSIGN id STRING_LITERAL ) | -> id ) SEMI | RULE_REF );
    public final ANTLRParser.tokenSpec_return tokenSpec() throws RecognitionException {
        ANTLRParser.tokenSpec_return retval = new ANTLRParser.tokenSpec_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token ASSIGN39=null;
        Token STRING_LITERAL40=null;
        Token SEMI41=null;
        Token RULE_REF42=null;
        ANTLRParser.id_return id38 =null;


        GrammarAST ASSIGN39_tree=null;
        GrammarAST STRING_LITERAL40_tree=null;
        GrammarAST SEMI41_tree=null;
        GrammarAST RULE_REF42_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // ANTLRParser.g:290:2: ( id ( ASSIGN STRING_LITERAL -> ^( ASSIGN id STRING_LITERAL ) | -> id ) SEMI | RULE_REF )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_REF) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==ASSIGN||LA12_1==SEMI) ) {
                    alt12=1;
                }
                else if ( (LA12_1==RBRACE||LA12_1==RULE_REF||LA12_1==TOKEN_REF) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA12_0==TOKEN_REF) ) {
                alt12=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // ANTLRParser.g:290:4: id ( ASSIGN STRING_LITERAL -> ^( ASSIGN id STRING_LITERAL ) | -> id ) SEMI
                    {
                    pushFollow(FOLLOW_id_in_tokenSpec1173);
                    id38=id();

                    state._fsp--;

                    stream_id.add(id38.getTree());

                    // ANTLRParser.g:291:3: ( ASSIGN STRING_LITERAL -> ^( ASSIGN id STRING_LITERAL ) | -> id )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==ASSIGN) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==SEMI) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;

                    }
                    switch (alt11) {
                        case 1 :
                            // ANTLRParser.g:291:5: ASSIGN STRING_LITERAL
                            {
                            ASSIGN39=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec1179);  
                            stream_ASSIGN.add(ASSIGN39);


                            STRING_LITERAL40=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenSpec1181);  
                            stream_STRING_LITERAL.add(STRING_LITERAL40);


                            // AST REWRITE
                            // elements: STRING_LITERAL, id, ASSIGN
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 291:27: -> ^( ASSIGN id STRING_LITERAL )
                            {
                                // ANTLRParser.g:291:30: ^( ASSIGN id STRING_LITERAL )
                                {
                                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                                root_1 = (GrammarAST)adaptor.becomeRoot(
                                stream_ASSIGN.nextNode()
                                , root_1);

                                adaptor.addChild(root_1, stream_id.nextTree());

                                adaptor.addChild(root_1, 
                                new TerminalAST(stream_STRING_LITERAL.nextToken())
                                );

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 2 :
                            // ANTLRParser.g:292:11: 
                            {
                            // AST REWRITE
                            // elements: id
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 292:11: -> id
                            {
                                adaptor.addChild(root_0, stream_id.nextTree());

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    SEMI41=(Token)match(input,SEMI,FOLLOW_SEMI_in_tokenSpec1216);  
                    stream_SEMI.add(SEMI41);


                    }
                    break;
                case 2 :
                    // ANTLRParser.g:295:4: RULE_REF
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    RULE_REF42=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_tokenSpec1221); 
                    RULE_REF42_tree = 
                    (GrammarAST)adaptor.create(RULE_REF42)
                    ;
                    adaptor.addChild(root_0, RULE_REF42_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "tokenSpec"


    public static class action_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "action"
    // ANTLRParser.g:302:1: action : AT ( actionScopeName COLONCOLON )? id ACTION -> ^( AT ( actionScopeName )? id ACTION ) ;
    public final ANTLRParser.action_return action() throws RecognitionException {
        ANTLRParser.action_return retval = new ANTLRParser.action_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token AT43=null;
        Token COLONCOLON45=null;
        Token ACTION47=null;
        ANTLRParser.actionScopeName_return actionScopeName44 =null;

        ANTLRParser.id_return id46 =null;


        GrammarAST AT43_tree=null;
        GrammarAST COLONCOLON45_tree=null;
        GrammarAST ACTION47_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_COLONCOLON=new RewriteRuleTokenStream(adaptor,"token COLONCOLON");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_actionScopeName=new RewriteRuleSubtreeStream(adaptor,"rule actionScopeName");
        try {
            // ANTLRParser.g:303:2: ( AT ( actionScopeName COLONCOLON )? id ACTION -> ^( AT ( actionScopeName )? id ACTION ) )
            // ANTLRParser.g:303:4: AT ( actionScopeName COLONCOLON )? id ACTION
            {
            AT43=(Token)match(input,AT,FOLLOW_AT_in_action1238);  
            stream_AT.add(AT43);


            // ANTLRParser.g:303:7: ( actionScopeName COLONCOLON )?
            int alt13=2;
            switch ( input.LA(1) ) {
                case RULE_REF:
                    {
                    int LA13_1 = input.LA(2);

                    if ( (LA13_1==COLONCOLON) ) {
                        alt13=1;
                    }
                    }
                    break;
                case TOKEN_REF:
                    {
                    int LA13_2 = input.LA(2);

                    if ( (LA13_2==COLONCOLON) ) {
                        alt13=1;
                    }
                    }
                    break;
                case LEXER:
                case PARSER:
                    {
                    alt13=1;
                    }
                    break;
            }

            switch (alt13) {
                case 1 :
                    // ANTLRParser.g:303:8: actionScopeName COLONCOLON
                    {
                    pushFollow(FOLLOW_actionScopeName_in_action1241);
                    actionScopeName44=actionScopeName();

                    state._fsp--;

                    stream_actionScopeName.add(actionScopeName44.getTree());

                    COLONCOLON45=(Token)match(input,COLONCOLON,FOLLOW_COLONCOLON_in_action1243);  
                    stream_COLONCOLON.add(COLONCOLON45);


                    }
                    break;

            }


            pushFollow(FOLLOW_id_in_action1247);
            id46=id();

            state._fsp--;

            stream_id.add(id46.getTree());

            ACTION47=(Token)match(input,ACTION,FOLLOW_ACTION_in_action1249);  
            stream_ACTION.add(ACTION47);


            // AST REWRITE
            // elements: id, ACTION, AT, actionScopeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 303:47: -> ^( AT ( actionScopeName )? id ACTION )
            {
                // ANTLRParser.g:303:50: ^( AT ( actionScopeName )? id ACTION )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_AT.nextNode()
                , root_1);

                // ANTLRParser.g:303:55: ( actionScopeName )?
                if ( stream_actionScopeName.hasNext() ) {
                    adaptor.addChild(root_1, stream_actionScopeName.nextTree());

                }
                stream_actionScopeName.reset();

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_1, 
                new ActionAST(stream_ACTION.nextToken())
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "action"


    public static class actionScopeName_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actionScopeName"
    // ANTLRParser.g:309:1: actionScopeName : ( id | LEXER -> ID[$LEXER] | PARSER -> ID[$PARSER] );
    public final ANTLRParser.actionScopeName_return actionScopeName() throws RecognitionException {
        ANTLRParser.actionScopeName_return retval = new ANTLRParser.actionScopeName_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token LEXER49=null;
        Token PARSER50=null;
        ANTLRParser.id_return id48 =null;


        GrammarAST LEXER49_tree=null;
        GrammarAST PARSER50_tree=null;
        RewriteRuleTokenStream stream_PARSER=new RewriteRuleTokenStream(adaptor,"token PARSER");
        RewriteRuleTokenStream stream_LEXER=new RewriteRuleTokenStream(adaptor,"token LEXER");

        try {
            // ANTLRParser.g:310:2: ( id | LEXER -> ID[$LEXER] | PARSER -> ID[$PARSER] )
            int alt14=3;
            switch ( input.LA(1) ) {
            case RULE_REF:
            case TOKEN_REF:
                {
                alt14=1;
                }
                break;
            case LEXER:
                {
                alt14=2;
                }
                break;
            case PARSER:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // ANTLRParser.g:310:4: id
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_id_in_actionScopeName1278);
                    id48=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id48.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:311:4: LEXER
                    {
                    LEXER49=(Token)match(input,LEXER,FOLLOW_LEXER_in_actionScopeName1283);  
                    stream_LEXER.add(LEXER49);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 311:10: -> ID[$LEXER]
                    {
                        adaptor.addChild(root_0, 
                        (GrammarAST)adaptor.create(ID, LEXER49)
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // ANTLRParser.g:312:9: PARSER
                    {
                    PARSER50=(Token)match(input,PARSER,FOLLOW_PARSER_in_actionScopeName1298);  
                    stream_PARSER.add(PARSER50);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 312:16: -> ID[$PARSER]
                    {
                        adaptor.addChild(root_0, 
                        (GrammarAST)adaptor.create(ID, PARSER50)
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionScopeName"


    public static class modeSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "modeSpec"
    // ANTLRParser.g:315:1: modeSpec : MODE id SEMI sync ( lexerRule sync )+ -> ^( MODE id ( lexerRule )+ ) ;
    public final ANTLRParser.modeSpec_return modeSpec() throws RecognitionException {
        ANTLRParser.modeSpec_return retval = new ANTLRParser.modeSpec_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token MODE51=null;
        Token SEMI53=null;
        ANTLRParser.id_return id52 =null;

        ANTLRParser.sync_return sync54 =null;

        ANTLRParser.lexerRule_return lexerRule55 =null;

        ANTLRParser.sync_return sync56 =null;


        GrammarAST MODE51_tree=null;
        GrammarAST SEMI53_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_MODE=new RewriteRuleTokenStream(adaptor,"token MODE");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        RewriteRuleSubtreeStream stream_lexerRule=new RewriteRuleSubtreeStream(adaptor,"rule lexerRule");
        try {
            // ANTLRParser.g:316:5: ( MODE id SEMI sync ( lexerRule sync )+ -> ^( MODE id ( lexerRule )+ ) )
            // ANTLRParser.g:316:7: MODE id SEMI sync ( lexerRule sync )+
            {
            MODE51=(Token)match(input,MODE,FOLLOW_MODE_in_modeSpec1317);  
            stream_MODE.add(MODE51);


            pushFollow(FOLLOW_id_in_modeSpec1319);
            id52=id();

            state._fsp--;

            stream_id.add(id52.getTree());

            SEMI53=(Token)match(input,SEMI,FOLLOW_SEMI_in_modeSpec1321);  
            stream_SEMI.add(SEMI53);


            pushFollow(FOLLOW_sync_in_modeSpec1323);
            sync54=sync();

            state._fsp--;

            stream_sync.add(sync54.getTree());

            // ANTLRParser.g:316:25: ( lexerRule sync )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==DOC_COMMENT||LA15_0==FRAGMENT||LA15_0==TOKEN_REF) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ANTLRParser.g:316:26: lexerRule sync
            	    {
            	    pushFollow(FOLLOW_lexerRule_in_modeSpec1326);
            	    lexerRule55=lexerRule();

            	    state._fsp--;

            	    stream_lexerRule.add(lexerRule55.getTree());

            	    pushFollow(FOLLOW_sync_in_modeSpec1328);
            	    sync56=sync();

            	    state._fsp--;

            	    stream_sync.add(sync56.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            // AST REWRITE
            // elements: id, lexerRule, MODE
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 316:44: -> ^( MODE id ( lexerRule )+ )
            {
                // ANTLRParser.g:316:47: ^( MODE id ( lexerRule )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_MODE.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                if ( !(stream_lexerRule.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_lexerRule.hasNext() ) {
                    adaptor.addChild(root_1, stream_lexerRule.nextTree());

                }
                stream_lexerRule.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "modeSpec"


    public static class rules_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rules"
    // ANTLRParser.g:319:1: rules : sync ( rule sync )* -> ^( RULES ( rule )* ) ;
    public final ANTLRParser.rules_return rules() throws RecognitionException {
        ANTLRParser.rules_return retval = new ANTLRParser.rules_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.sync_return sync57 =null;

        ANTLRParser.rule_return rule58 =null;

        ANTLRParser.sync_return sync59 =null;


        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        RewriteRuleSubtreeStream stream_rule=new RewriteRuleSubtreeStream(adaptor,"rule rule");
        try {
            // ANTLRParser.g:320:5: ( sync ( rule sync )* -> ^( RULES ( rule )* ) )
            // ANTLRParser.g:320:7: sync ( rule sync )*
            {
            pushFollow(FOLLOW_sync_in_rules1359);
            sync57=sync();

            state._fsp--;

            stream_sync.add(sync57.getTree());

            // ANTLRParser.g:320:12: ( rule sync )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==DOC_COMMENT||LA16_0==FRAGMENT||(LA16_0 >= PRIVATE && LA16_0 <= PUBLIC)||LA16_0==RULE_REF||LA16_0==TOKEN_REF) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ANTLRParser.g:320:13: rule sync
            	    {
            	    pushFollow(FOLLOW_rule_in_rules1362);
            	    rule58=rule();

            	    state._fsp--;

            	    stream_rule.add(rule58.getTree());

            	    pushFollow(FOLLOW_sync_in_rules1364);
            	    sync59=sync();

            	    state._fsp--;

            	    stream_sync.add(sync59.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            // AST REWRITE
            // elements: rule
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 324:7: -> ^( RULES ( rule )* )
            {
                // ANTLRParser.g:324:9: ^( RULES ( rule )* )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                (GrammarAST)adaptor.create(RULES, "RULES")
                , root_1);

                // ANTLRParser.g:324:17: ( rule )*
                while ( stream_rule.hasNext() ) {
                    adaptor.addChild(root_1, stream_rule.nextTree());

                }
                stream_rule.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rules"


    public static class sync_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sync"
    // ANTLRParser.g:327:1: sync :;
    public final ANTLRParser.sync_return sync() throws RecognitionException {
        ANTLRParser.sync_return retval = new ANTLRParser.sync_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;


        	BitSet followSet = computeErrorRecoverySet();
        	if ( input.LA(1)!=Token.EOF && !followSet.member(input.LA(1)) ) {
        		reportError(new NoViableAltException("",0,0,input));
               	beginResync();
               	consumeUntil(input, followSet);
               	endResync();
        	}

        try {
            // ANTLRParser.g:336:3: ()
            // ANTLRParser.g:337:2: 
            {
            root_0 = (GrammarAST)adaptor.nil();


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sync"


    public static class rule_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rule"
    // ANTLRParser.g:339:1: rule : ( parserRule | lexerRule );
    public final ANTLRParser.rule_return rule() throws RecognitionException {
        ANTLRParser.rule_return retval = new ANTLRParser.rule_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.parserRule_return parserRule60 =null;

        ANTLRParser.lexerRule_return lexerRule61 =null;



        try {
            // ANTLRParser.g:339:5: ( parserRule | lexerRule )
            int alt17=2;
            switch ( input.LA(1) ) {
            case DOC_COMMENT:
                {
                switch ( input.LA(2) ) {
                case FRAGMENT:
                    {
                    int LA17_2 = input.LA(3);

                    if ( (LA17_2==FRAGMENT||(LA17_2 >= PRIVATE && LA17_2 <= PUBLIC)||LA17_2==RULE_REF) ) {
                        alt17=1;
                    }
                    else if ( (LA17_2==TOKEN_REF) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 2, input);

                        throw nvae;

                    }
                    }
                    break;
                case PRIVATE:
                case PROTECTED:
                case PUBLIC:
                case RULE_REF:
                    {
                    alt17=1;
                    }
                    break;
                case TOKEN_REF:
                    {
                    alt17=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;

                }

                }
                break;
            case FRAGMENT:
                {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==FRAGMENT||(LA17_2 >= PRIVATE && LA17_2 <= PUBLIC)||LA17_2==RULE_REF) ) {
                    alt17=1;
                }
                else if ( (LA17_2==TOKEN_REF) ) {
                    alt17=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;

                }
                }
                break;
            case PRIVATE:
            case PROTECTED:
            case PUBLIC:
            case RULE_REF:
                {
                alt17=1;
                }
                break;
            case TOKEN_REF:
                {
                alt17=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // ANTLRParser.g:339:7: parserRule
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_parserRule_in_rule1426);
                    parserRule60=parserRule();

                    state._fsp--;

                    adaptor.addChild(root_0, parserRule60.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:340:4: lexerRule
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_lexerRule_in_rule1431);
                    lexerRule61=lexerRule();

                    state._fsp--;

                    adaptor.addChild(root_0, lexerRule61.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rule"


    public static class parserRule_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parserRule"
    // ANTLRParser.g:352:1: parserRule : ( DOC_COMMENT )? ( ruleModifiers )? RULE_REF ( ARG_ACTION )? ( ruleReturns )? ( throwsSpec )? ( localsSpec )? rulePrequels COLON ruleBlock SEMI exceptionGroup -> ^( RULE RULE_REF ( DOC_COMMENT )? ( ruleModifiers )? ( ARG_ACTION )? ( ruleReturns )? ( throwsSpec )? ( localsSpec )? ( rulePrequels )? ruleBlock ( exceptionGroup )* ) ;
    public final ANTLRParser.parserRule_return parserRule() throws RecognitionException {
        ANTLRParser.parserRule_return retval = new ANTLRParser.parserRule_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token DOC_COMMENT62=null;
        Token RULE_REF64=null;
        Token ARG_ACTION65=null;
        Token COLON70=null;
        Token SEMI72=null;
        ANTLRParser.ruleModifiers_return ruleModifiers63 =null;

        ANTLRParser.ruleReturns_return ruleReturns66 =null;

        ANTLRParser.throwsSpec_return throwsSpec67 =null;

        ANTLRParser.localsSpec_return localsSpec68 =null;

        ANTLRParser.rulePrequels_return rulePrequels69 =null;

        ANTLRParser.ruleBlock_return ruleBlock71 =null;

        ANTLRParser.exceptionGroup_return exceptionGroup73 =null;


        GrammarAST DOC_COMMENT62_tree=null;
        GrammarAST RULE_REF64_tree=null;
        GrammarAST ARG_ACTION65_tree=null;
        GrammarAST COLON70_tree=null;
        GrammarAST SEMI72_tree=null;
        RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");
        RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");
        RewriteRuleSubtreeStream stream_ruleModifiers=new RewriteRuleSubtreeStream(adaptor,"rule ruleModifiers");
        RewriteRuleSubtreeStream stream_rulePrequels=new RewriteRuleSubtreeStream(adaptor,"rule rulePrequels");
        RewriteRuleSubtreeStream stream_exceptionGroup=new RewriteRuleSubtreeStream(adaptor,"rule exceptionGroup");
        RewriteRuleSubtreeStream stream_ruleReturns=new RewriteRuleSubtreeStream(adaptor,"rule ruleReturns");
        RewriteRuleSubtreeStream stream_throwsSpec=new RewriteRuleSubtreeStream(adaptor,"rule throwsSpec");
        RewriteRuleSubtreeStream stream_ruleBlock=new RewriteRuleSubtreeStream(adaptor,"rule ruleBlock");
        RewriteRuleSubtreeStream stream_localsSpec=new RewriteRuleSubtreeStream(adaptor,"rule localsSpec");
         paraphrases.push("matching a rule"); 
        try {
            // ANTLRParser.g:361:5: ( ( DOC_COMMENT )? ( ruleModifiers )? RULE_REF ( ARG_ACTION )? ( ruleReturns )? ( throwsSpec )? ( localsSpec )? rulePrequels COLON ruleBlock SEMI exceptionGroup -> ^( RULE RULE_REF ( DOC_COMMENT )? ( ruleModifiers )? ( ARG_ACTION )? ( ruleReturns )? ( throwsSpec )? ( localsSpec )? ( rulePrequels )? ruleBlock ( exceptionGroup )* ) )
            // ANTLRParser.g:362:7: ( DOC_COMMENT )? ( ruleModifiers )? RULE_REF ( ARG_ACTION )? ( ruleReturns )? ( throwsSpec )? ( localsSpec )? rulePrequels COLON ruleBlock SEMI exceptionGroup
            {
            // ANTLRParser.g:362:7: ( DOC_COMMENT )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==DOC_COMMENT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ANTLRParser.g:362:7: DOC_COMMENT
                    {
                    DOC_COMMENT62=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_parserRule1471);  
                    stream_DOC_COMMENT.add(DOC_COMMENT62);


                    }
                    break;

            }


            // ANTLRParser.g:368:7: ( ruleModifiers )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==FRAGMENT||(LA19_0 >= PRIVATE && LA19_0 <= PUBLIC)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ANTLRParser.g:368:7: ruleModifiers
                    {
                    pushFollow(FOLLOW_ruleModifiers_in_parserRule1509);
                    ruleModifiers63=ruleModifiers();

                    state._fsp--;

                    stream_ruleModifiers.add(ruleModifiers63.getTree());

                    }
                    break;

            }


            RULE_REF64=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_parserRule1532);  
            stream_RULE_REF.add(RULE_REF64);


            // ANTLRParser.g:382:4: ( ARG_ACTION )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==ARG_ACTION) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ANTLRParser.g:382:4: ARG_ACTION
                    {
                    ARG_ACTION65=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_parserRule1562);  
                    stream_ARG_ACTION.add(ARG_ACTION65);


                    }
                    break;

            }


            // ANTLRParser.g:384:4: ( ruleReturns )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RETURNS) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ANTLRParser.g:384:4: ruleReturns
                    {
                    pushFollow(FOLLOW_ruleReturns_in_parserRule1569);
                    ruleReturns66=ruleReturns();

                    state._fsp--;

                    stream_ruleReturns.add(ruleReturns66.getTree());

                    }
                    break;

            }


            // ANTLRParser.g:386:4: ( throwsSpec )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==THROWS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ANTLRParser.g:386:4: throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_parserRule1576);
                    throwsSpec67=throwsSpec();

                    state._fsp--;

                    stream_throwsSpec.add(throwsSpec67.getTree());

                    }
                    break;

            }


            // ANTLRParser.g:388:4: ( localsSpec )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==LOCALS) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ANTLRParser.g:388:4: localsSpec
                    {
                    pushFollow(FOLLOW_localsSpec_in_parserRule1583);
                    localsSpec68=localsSpec();

                    state._fsp--;

                    stream_localsSpec.add(localsSpec68.getTree());

                    }
                    break;

            }


            pushFollow(FOLLOW_rulePrequels_in_parserRule1621);
            rulePrequels69=rulePrequels();

            state._fsp--;

            stream_rulePrequels.add(rulePrequels69.getTree());

            COLON70=(Token)match(input,COLON,FOLLOW_COLON_in_parserRule1630);  
            stream_COLON.add(COLON70);


            pushFollow(FOLLOW_ruleBlock_in_parserRule1653);
            ruleBlock71=ruleBlock();

            state._fsp--;

            stream_ruleBlock.add(ruleBlock71.getTree());

            SEMI72=(Token)match(input,SEMI,FOLLOW_SEMI_in_parserRule1662);  
            stream_SEMI.add(SEMI72);


            pushFollow(FOLLOW_exceptionGroup_in_parserRule1671);
            exceptionGroup73=exceptionGroup();

            state._fsp--;

            stream_exceptionGroup.add(exceptionGroup73.getTree());

            // AST REWRITE
            // elements: ruleModifiers, ARG_ACTION, DOC_COMMENT, localsSpec, RULE_REF, ruleReturns, rulePrequels, throwsSpec, exceptionGroup, ruleBlock
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 415:7: -> ^( RULE RULE_REF ( DOC_COMMENT )? ( ruleModifiers )? ( ARG_ACTION )? ( ruleReturns )? ( throwsSpec )? ( localsSpec )? ( rulePrequels )? ruleBlock ( exceptionGroup )* )
            {
                // ANTLRParser.g:415:10: ^( RULE RULE_REF ( DOC_COMMENT )? ( ruleModifiers )? ( ARG_ACTION )? ( ruleReturns )? ( throwsSpec )? ( localsSpec )? ( rulePrequels )? ruleBlock ( exceptionGroup )* )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new RuleAST(RULE)
                , root_1);

                adaptor.addChild(root_1, 
                stream_RULE_REF.nextNode()
                );

                // ANTLRParser.g:415:36: ( DOC_COMMENT )?
                if ( stream_DOC_COMMENT.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_DOC_COMMENT.nextNode()
                    );

                }
                stream_DOC_COMMENT.reset();

                // ANTLRParser.g:415:49: ( ruleModifiers )?
                if ( stream_ruleModifiers.hasNext() ) {
                    adaptor.addChild(root_1, stream_ruleModifiers.nextTree());

                }
                stream_ruleModifiers.reset();

                // ANTLRParser.g:415:64: ( ARG_ACTION )?
                if ( stream_ARG_ACTION.hasNext() ) {
                    adaptor.addChild(root_1, 
                    new ActionAST(stream_ARG_ACTION.nextToken())
                    );

                }
                stream_ARG_ACTION.reset();

                // ANTLRParser.g:416:9: ( ruleReturns )?
                if ( stream_ruleReturns.hasNext() ) {
                    adaptor.addChild(root_1, stream_ruleReturns.nextTree());

                }
                stream_ruleReturns.reset();

                // ANTLRParser.g:416:22: ( throwsSpec )?
                if ( stream_throwsSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_throwsSpec.nextTree());

                }
                stream_throwsSpec.reset();

                // ANTLRParser.g:416:34: ( localsSpec )?
                if ( stream_localsSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_localsSpec.nextTree());

                }
                stream_localsSpec.reset();

                // ANTLRParser.g:416:46: ( rulePrequels )?
                if ( stream_rulePrequels.hasNext() ) {
                    adaptor.addChild(root_1, stream_rulePrequels.nextTree());

                }
                stream_rulePrequels.reset();

                adaptor.addChild(root_1, stream_ruleBlock.nextTree());

                // ANTLRParser.g:416:70: ( exceptionGroup )*
                while ( stream_exceptionGroup.hasNext() ) {
                    adaptor.addChild(root_1, stream_exceptionGroup.nextTree());

                }
                stream_exceptionGroup.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            	paraphrases.pop();
            	GrammarAST options = (GrammarAST)((GrammarAST)retval.tree).getFirstChildWithType(ANTLRParser.OPTIONS);
            	if ( options!=null ) {
            		Grammar.setNodeOptions(((GrammarAST)retval.tree), options);
            	}

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parserRule"


    public static class exceptionGroup_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "exceptionGroup"
    // ANTLRParser.g:426:1: exceptionGroup : ( exceptionHandler )* ( finallyClause )? ;
    public final ANTLRParser.exceptionGroup_return exceptionGroup() throws RecognitionException {
        ANTLRParser.exceptionGroup_return retval = new ANTLRParser.exceptionGroup_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.exceptionHandler_return exceptionHandler74 =null;

        ANTLRParser.finallyClause_return finallyClause75 =null;



        try {
            // ANTLRParser.g:427:5: ( ( exceptionHandler )* ( finallyClause )? )
            // ANTLRParser.g:427:7: ( exceptionHandler )* ( finallyClause )?
            {
            root_0 = (GrammarAST)adaptor.nil();


            // ANTLRParser.g:427:7: ( exceptionHandler )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==CATCH) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ANTLRParser.g:427:7: exceptionHandler
            	    {
            	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup1760);
            	    exceptionHandler74=exceptionHandler();

            	    state._fsp--;

            	    adaptor.addChild(root_0, exceptionHandler74.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            // ANTLRParser.g:427:25: ( finallyClause )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==FINALLY) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ANTLRParser.g:427:25: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup1763);
                    finallyClause75=finallyClause();

                    state._fsp--;

                    adaptor.addChild(root_0, finallyClause75.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "exceptionGroup"


    public static class exceptionHandler_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "exceptionHandler"
    // ANTLRParser.g:432:1: exceptionHandler : CATCH ARG_ACTION ACTION -> ^( CATCH ARG_ACTION ACTION ) ;
    public final ANTLRParser.exceptionHandler_return exceptionHandler() throws RecognitionException {
        ANTLRParser.exceptionHandler_return retval = new ANTLRParser.exceptionHandler_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token CATCH76=null;
        Token ARG_ACTION77=null;
        Token ACTION78=null;

        GrammarAST CATCH76_tree=null;
        GrammarAST ARG_ACTION77_tree=null;
        GrammarAST ACTION78_tree=null;
        RewriteRuleTokenStream stream_CATCH=new RewriteRuleTokenStream(adaptor,"token CATCH");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");

        try {
            // ANTLRParser.g:433:2: ( CATCH ARG_ACTION ACTION -> ^( CATCH ARG_ACTION ACTION ) )
            // ANTLRParser.g:433:4: CATCH ARG_ACTION ACTION
            {
            CATCH76=(Token)match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler1780);  
            stream_CATCH.add(CATCH76);


            ARG_ACTION77=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler1782);  
            stream_ARG_ACTION.add(ARG_ACTION77);


            ACTION78=(Token)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler1784);  
            stream_ACTION.add(ACTION78);


            // AST REWRITE
            // elements: ACTION, CATCH, ARG_ACTION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 433:28: -> ^( CATCH ARG_ACTION ACTION )
            {
                // ANTLRParser.g:433:31: ^( CATCH ARG_ACTION ACTION )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_CATCH.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                new ActionAST(stream_ARG_ACTION.nextToken())
                );

                adaptor.addChild(root_1, 
                new ActionAST(stream_ACTION.nextToken())
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "exceptionHandler"


    public static class finallyClause_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "finallyClause"
    // ANTLRParser.g:436:1: finallyClause : FINALLY ACTION -> ^( FINALLY ACTION ) ;
    public final ANTLRParser.finallyClause_return finallyClause() throws RecognitionException {
        ANTLRParser.finallyClause_return retval = new ANTLRParser.finallyClause_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token FINALLY79=null;
        Token ACTION80=null;

        GrammarAST FINALLY79_tree=null;
        GrammarAST ACTION80_tree=null;
        RewriteRuleTokenStream stream_FINALLY=new RewriteRuleTokenStream(adaptor,"token FINALLY");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");

        try {
            // ANTLRParser.g:437:2: ( FINALLY ACTION -> ^( FINALLY ACTION ) )
            // ANTLRParser.g:437:4: FINALLY ACTION
            {
            FINALLY79=(Token)match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause1811);  
            stream_FINALLY.add(FINALLY79);


            ACTION80=(Token)match(input,ACTION,FOLLOW_ACTION_in_finallyClause1813);  
            stream_ACTION.add(ACTION80);


            // AST REWRITE
            // elements: FINALLY, ACTION
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 437:19: -> ^( FINALLY ACTION )
            {
                // ANTLRParser.g:437:22: ^( FINALLY ACTION )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_FINALLY.nextNode()
                , root_1);

                adaptor.addChild(root_1, 
                new ActionAST(stream_ACTION.nextToken())
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "finallyClause"


    public static class rulePrequels_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rulePrequels"
    // ANTLRParser.g:440:1: rulePrequels : sync ( rulePrequel sync )* -> ( rulePrequel )* ;
    public final ANTLRParser.rulePrequels_return rulePrequels() throws RecognitionException {
        ANTLRParser.rulePrequels_return retval = new ANTLRParser.rulePrequels_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.sync_return sync81 =null;

        ANTLRParser.rulePrequel_return rulePrequel82 =null;

        ANTLRParser.sync_return sync83 =null;


        RewriteRuleSubtreeStream stream_rulePrequel=new RewriteRuleSubtreeStream(adaptor,"rule rulePrequel");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
         paraphrases.push("matching rule preamble"); 
        try {
            // ANTLRParser.g:443:2: ( sync ( rulePrequel sync )* -> ( rulePrequel )* )
            // ANTLRParser.g:443:4: sync ( rulePrequel sync )*
            {
            pushFollow(FOLLOW_sync_in_rulePrequels1845);
            sync81=sync();

            state._fsp--;

            stream_sync.add(sync81.getTree());

            // ANTLRParser.g:443:9: ( rulePrequel sync )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==AT||LA26_0==OPTIONS) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ANTLRParser.g:443:10: rulePrequel sync
            	    {
            	    pushFollow(FOLLOW_rulePrequel_in_rulePrequels1848);
            	    rulePrequel82=rulePrequel();

            	    state._fsp--;

            	    stream_rulePrequel.add(rulePrequel82.getTree());

            	    pushFollow(FOLLOW_sync_in_rulePrequels1850);
            	    sync83=sync();

            	    state._fsp--;

            	    stream_sync.add(sync83.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            // AST REWRITE
            // elements: rulePrequel
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 443:29: -> ( rulePrequel )*
            {
                // ANTLRParser.g:443:32: ( rulePrequel )*
                while ( stream_rulePrequel.hasNext() ) {
                    adaptor.addChild(root_0, stream_rulePrequel.nextTree());

                }
                stream_rulePrequel.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

             paraphrases.pop(); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rulePrequels"


    public static class rulePrequel_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "rulePrequel"
    // ANTLRParser.g:449:1: rulePrequel : ( optionsSpec | ruleAction );
    public final ANTLRParser.rulePrequel_return rulePrequel() throws RecognitionException {
        ANTLRParser.rulePrequel_return retval = new ANTLRParser.rulePrequel_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.optionsSpec_return optionsSpec84 =null;

        ANTLRParser.ruleAction_return ruleAction85 =null;



        try {
            // ANTLRParser.g:450:5: ( optionsSpec | ruleAction )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==OPTIONS) ) {
                alt27=1;
            }
            else if ( (LA27_0==AT) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;

            }
            switch (alt27) {
                case 1 :
                    // ANTLRParser.g:450:7: optionsSpec
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_optionsSpec_in_rulePrequel1874);
                    optionsSpec84=optionsSpec();

                    state._fsp--;

                    adaptor.addChild(root_0, optionsSpec84.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:451:7: ruleAction
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_ruleAction_in_rulePrequel1882);
                    ruleAction85=ruleAction();

                    state._fsp--;

                    adaptor.addChild(root_0, ruleAction85.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "rulePrequel"


    public static class ruleReturns_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleReturns"
    // ANTLRParser.g:460:1: ruleReturns : RETURNS ^ ARG_ACTION ;
    public final ANTLRParser.ruleReturns_return ruleReturns() throws RecognitionException {
        ANTLRParser.ruleReturns_return retval = new ANTLRParser.ruleReturns_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token RETURNS86=null;
        Token ARG_ACTION87=null;

        GrammarAST RETURNS86_tree=null;
        GrammarAST ARG_ACTION87_tree=null;

        try {
            // ANTLRParser.g:461:2: ( RETURNS ^ ARG_ACTION )
            // ANTLRParser.g:461:4: RETURNS ^ ARG_ACTION
            {
            root_0 = (GrammarAST)adaptor.nil();


            RETURNS86=(Token)match(input,RETURNS,FOLLOW_RETURNS_in_ruleReturns1902); 
            RETURNS86_tree = 
            (GrammarAST)adaptor.create(RETURNS86)
            ;
            root_0 = (GrammarAST)adaptor.becomeRoot(RETURNS86_tree, root_0);


            ARG_ACTION87=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleReturns1905); 
            ARG_ACTION87_tree = 
            new ActionAST(ARG_ACTION87) 
            ;
            adaptor.addChild(root_0, ARG_ACTION87_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleReturns"


    public static class throwsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "throwsSpec"
    // ANTLRParser.g:475:1: throwsSpec : THROWS qid ( COMMA qid )* -> ^( THROWS ( qid )+ ) ;
    public final ANTLRParser.throwsSpec_return throwsSpec() throws RecognitionException {
        ANTLRParser.throwsSpec_return retval = new ANTLRParser.throwsSpec_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token THROWS88=null;
        Token COMMA90=null;
        ANTLRParser.qid_return qid89 =null;

        ANTLRParser.qid_return qid91 =null;


        GrammarAST THROWS88_tree=null;
        GrammarAST COMMA90_tree=null;
        RewriteRuleTokenStream stream_THROWS=new RewriteRuleTokenStream(adaptor,"token THROWS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_qid=new RewriteRuleSubtreeStream(adaptor,"rule qid");
        try {
            // ANTLRParser.g:476:5: ( THROWS qid ( COMMA qid )* -> ^( THROWS ( qid )+ ) )
            // ANTLRParser.g:476:7: THROWS qid ( COMMA qid )*
            {
            THROWS88=(Token)match(input,THROWS,FOLLOW_THROWS_in_throwsSpec1933);  
            stream_THROWS.add(THROWS88);


            pushFollow(FOLLOW_qid_in_throwsSpec1935);
            qid89=qid();

            state._fsp--;

            stream_qid.add(qid89.getTree());

            // ANTLRParser.g:476:18: ( COMMA qid )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==COMMA) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ANTLRParser.g:476:19: COMMA qid
            	    {
            	    COMMA90=(Token)match(input,COMMA,FOLLOW_COMMA_in_throwsSpec1938);  
            	    stream_COMMA.add(COMMA90);


            	    pushFollow(FOLLOW_qid_in_throwsSpec1940);
            	    qid91=qid();

            	    state._fsp--;

            	    stream_qid.add(qid91.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            // AST REWRITE
            // elements: qid, THROWS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 476:31: -> ^( THROWS ( qid )+ )
            {
                // ANTLRParser.g:476:34: ^( THROWS ( qid )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_THROWS.nextNode()
                , root_1);

                if ( !(stream_qid.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_qid.hasNext() ) {
                    adaptor.addChild(root_1, stream_qid.nextTree());

                }
                stream_qid.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "throwsSpec"


    public static class localsSpec_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "localsSpec"
    // ANTLRParser.g:480:1: localsSpec : LOCALS ^ ARG_ACTION ;
    public final ANTLRParser.localsSpec_return localsSpec() throws RecognitionException {
        ANTLRParser.localsSpec_return retval = new ANTLRParser.localsSpec_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token LOCALS92=null;
        Token ARG_ACTION93=null;

        GrammarAST LOCALS92_tree=null;
        GrammarAST ARG_ACTION93_tree=null;

        try {
            // ANTLRParser.g:480:12: ( LOCALS ^ ARG_ACTION )
            // ANTLRParser.g:480:14: LOCALS ^ ARG_ACTION
            {
            root_0 = (GrammarAST)adaptor.nil();


            LOCALS92=(Token)match(input,LOCALS,FOLLOW_LOCALS_in_localsSpec1965); 
            LOCALS92_tree = 
            (GrammarAST)adaptor.create(LOCALS92)
            ;
            root_0 = (GrammarAST)adaptor.becomeRoot(LOCALS92_tree, root_0);


            ARG_ACTION93=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_localsSpec1968); 
            ARG_ACTION93_tree = 
            new ActionAST(ARG_ACTION93) 
            ;
            adaptor.addChild(root_0, ARG_ACTION93_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "localsSpec"


    public static class ruleAction_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleAction"
    // ANTLRParser.g:491:1: ruleAction : AT id ACTION -> ^( AT id ACTION ) ;
    public final ANTLRParser.ruleAction_return ruleAction() throws RecognitionException {
        ANTLRParser.ruleAction_return retval = new ANTLRParser.ruleAction_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token AT94=null;
        Token ACTION96=null;
        ANTLRParser.id_return id95 =null;


        GrammarAST AT94_tree=null;
        GrammarAST ACTION96_tree=null;
        RewriteRuleTokenStream stream_AT=new RewriteRuleTokenStream(adaptor,"token AT");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        try {
            // ANTLRParser.g:492:2: ( AT id ACTION -> ^( AT id ACTION ) )
            // ANTLRParser.g:492:4: AT id ACTION
            {
            AT94=(Token)match(input,AT,FOLLOW_AT_in_ruleAction1991);  
            stream_AT.add(AT94);


            pushFollow(FOLLOW_id_in_ruleAction1993);
            id95=id();

            state._fsp--;

            stream_id.add(id95.getTree());

            ACTION96=(Token)match(input,ACTION,FOLLOW_ACTION_in_ruleAction1995);  
            stream_ACTION.add(ACTION96);


            // AST REWRITE
            // elements: id, ACTION, AT
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 492:17: -> ^( AT id ACTION )
            {
                // ANTLRParser.g:492:20: ^( AT id ACTION )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                stream_AT.nextNode()
                , root_1);

                adaptor.addChild(root_1, stream_id.nextTree());

                adaptor.addChild(root_1, 
                new ActionAST(stream_ACTION.nextToken())
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleAction"


    public static class ruleModifiers_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleModifiers"
    // ANTLRParser.g:500:1: ruleModifiers : ( ruleModifier )+ -> ^( RULEMODIFIERS ( ruleModifier )+ ) ;
    public final ANTLRParser.ruleModifiers_return ruleModifiers() throws RecognitionException {
        ANTLRParser.ruleModifiers_return retval = new ANTLRParser.ruleModifiers_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.ruleModifier_return ruleModifier97 =null;


        RewriteRuleSubtreeStream stream_ruleModifier=new RewriteRuleSubtreeStream(adaptor,"rule ruleModifier");
        try {
            // ANTLRParser.g:501:5: ( ( ruleModifier )+ -> ^( RULEMODIFIERS ( ruleModifier )+ ) )
            // ANTLRParser.g:501:7: ( ruleModifier )+
            {
            // ANTLRParser.g:501:7: ( ruleModifier )+
            int cnt29=0;
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==FRAGMENT||(LA29_0 >= PRIVATE && LA29_0 <= PUBLIC)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ANTLRParser.g:501:7: ruleModifier
            	    {
            	    pushFollow(FOLLOW_ruleModifier_in_ruleModifiers2027);
            	    ruleModifier97=ruleModifier();

            	    state._fsp--;

            	    stream_ruleModifier.add(ruleModifier97.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt29 >= 1 ) break loop29;
                        EarlyExitException eee =
                            new EarlyExitException(29, input);
                        throw eee;
                }
                cnt29++;
            } while (true);


            // AST REWRITE
            // elements: ruleModifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 501:21: -> ^( RULEMODIFIERS ( ruleModifier )+ )
            {
                // ANTLRParser.g:501:24: ^( RULEMODIFIERS ( ruleModifier )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                (GrammarAST)adaptor.create(RULEMODIFIERS, "RULEMODIFIERS")
                , root_1);

                if ( !(stream_ruleModifier.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ruleModifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_ruleModifier.nextTree());

                }
                stream_ruleModifier.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleModifiers"


    public static class ruleModifier_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleModifier"
    // ANTLRParser.g:510:1: ruleModifier : ( PUBLIC | PRIVATE | PROTECTED | FRAGMENT );
    public final ANTLRParser.ruleModifier_return ruleModifier() throws RecognitionException {
        ANTLRParser.ruleModifier_return retval = new ANTLRParser.ruleModifier_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token set98=null;

        GrammarAST set98_tree=null;

        try {
            // ANTLRParser.g:511:5: ( PUBLIC | PRIVATE | PROTECTED | FRAGMENT )
            // ANTLRParser.g:
            {
            root_0 = (GrammarAST)adaptor.nil();


            set98=(Token)input.LT(1);

            if ( input.LA(1)==FRAGMENT||(input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
                input.consume();
                adaptor.addChild(root_0, 
                (GrammarAST)adaptor.create(set98)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleModifier"


    public static class ruleBlock_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleBlock"
    // ANTLRParser.g:523:1: ruleBlock : ruleAltList -> ^( BLOCK[colon,\"BLOCK\"] ruleAltList ) ;
    public final ANTLRParser.ruleBlock_return ruleBlock() throws RecognitionException {
        ANTLRParser.ruleBlock_return retval = new ANTLRParser.ruleBlock_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.ruleAltList_return ruleAltList99 =null;


        RewriteRuleSubtreeStream stream_ruleAltList=new RewriteRuleSubtreeStream(adaptor,"rule ruleAltList");
        Token colon = input.LT(-1);
        try {
            // ANTLRParser.g:525:5: ( ruleAltList -> ^( BLOCK[colon,\"BLOCK\"] ruleAltList ) )
            // ANTLRParser.g:525:7: ruleAltList
            {
            pushFollow(FOLLOW_ruleAltList_in_ruleBlock2112);
            ruleAltList99=ruleAltList();

            state._fsp--;

            stream_ruleAltList.add(ruleAltList99.getTree());

            // AST REWRITE
            // elements: ruleAltList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 525:19: -> ^( BLOCK[colon,\"BLOCK\"] ruleAltList )
            {
                // ANTLRParser.g:525:22: ^( BLOCK[colon,\"BLOCK\"] ruleAltList )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new BlockAST(BLOCK, colon, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_ruleAltList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (ResyncToEndOfRuleBlock e) {

                	// just resyncing; ignore error
            		retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), null);
                
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleBlock"


    public static class ruleAltList_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleAltList"
    // ANTLRParser.g:532:1: ruleAltList : labeledAlt ( OR labeledAlt )* -> ( labeledAlt )+ ;
    public final ANTLRParser.ruleAltList_return ruleAltList() throws RecognitionException {
        ANTLRParser.ruleAltList_return retval = new ANTLRParser.ruleAltList_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token OR101=null;
        ANTLRParser.labeledAlt_return labeledAlt100 =null;

        ANTLRParser.labeledAlt_return labeledAlt102 =null;


        GrammarAST OR101_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_labeledAlt=new RewriteRuleSubtreeStream(adaptor,"rule labeledAlt");
        try {
            // ANTLRParser.g:533:2: ( labeledAlt ( OR labeledAlt )* -> ( labeledAlt )+ )
            // ANTLRParser.g:533:4: labeledAlt ( OR labeledAlt )*
            {
            pushFollow(FOLLOW_labeledAlt_in_ruleAltList2148);
            labeledAlt100=labeledAlt();

            state._fsp--;

            stream_labeledAlt.add(labeledAlt100.getTree());

            // ANTLRParser.g:533:15: ( OR labeledAlt )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==OR) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ANTLRParser.g:533:16: OR labeledAlt
            	    {
            	    OR101=(Token)match(input,OR,FOLLOW_OR_in_ruleAltList2151);  
            	    stream_OR.add(OR101);


            	    pushFollow(FOLLOW_labeledAlt_in_ruleAltList2153);
            	    labeledAlt102=labeledAlt();

            	    state._fsp--;

            	    stream_labeledAlt.add(labeledAlt102.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            // AST REWRITE
            // elements: labeledAlt
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 533:32: -> ( labeledAlt )+
            {
                if ( !(stream_labeledAlt.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_labeledAlt.hasNext() ) {
                    adaptor.addChild(root_0, stream_labeledAlt.nextTree());

                }
                stream_labeledAlt.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleAltList"


    public static class labeledAlt_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "labeledAlt"
    // ANTLRParser.g:536:1: labeledAlt : alternative ( POUND ! id !)? ;
    public final ANTLRParser.labeledAlt_return labeledAlt() throws RecognitionException {
        ANTLRParser.labeledAlt_return retval = new ANTLRParser.labeledAlt_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token POUND104=null;
        ANTLRParser.alternative_return alternative103 =null;

        ANTLRParser.id_return id105 =null;


        GrammarAST POUND104_tree=null;

        try {
            // ANTLRParser.g:537:2: ( alternative ( POUND ! id !)? )
            // ANTLRParser.g:537:4: alternative ( POUND ! id !)?
            {
            root_0 = (GrammarAST)adaptor.nil();


            pushFollow(FOLLOW_alternative_in_labeledAlt2171);
            alternative103=alternative();

            state._fsp--;

            adaptor.addChild(root_0, alternative103.getTree());

            // ANTLRParser.g:538:3: ( POUND ! id !)?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==POUND) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ANTLRParser.g:538:5: POUND ! id !
                    {
                    POUND104=(Token)match(input,POUND,FOLLOW_POUND_in_labeledAlt2177); 

                    pushFollow(FOLLOW_id_in_labeledAlt2180);
                    id105=id();

                    state._fsp--;


                    ((AltAST)(alternative103!=null?((GrammarAST)alternative103.tree):null)).altLabel=(id105!=null?((GrammarAST)id105.tree):null);

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "labeledAlt"


    public static class lexerRule_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerRule"
    // ANTLRParser.g:543:1: lexerRule : ( DOC_COMMENT )? ( FRAGMENT )? TOKEN_REF COLON lexerRuleBlock SEMI -> ^( RULE TOKEN_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS FRAGMENT ) )? lexerRuleBlock ) ;
    public final ANTLRParser.lexerRule_return lexerRule() throws RecognitionException {
        ANTLRParser.lexerRule_return retval = new ANTLRParser.lexerRule_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token DOC_COMMENT106=null;
        Token FRAGMENT107=null;
        Token TOKEN_REF108=null;
        Token COLON109=null;
        Token SEMI111=null;
        ANTLRParser.lexerRuleBlock_return lexerRuleBlock110 =null;


        GrammarAST DOC_COMMENT106_tree=null;
        GrammarAST FRAGMENT107_tree=null;
        GrammarAST TOKEN_REF108_tree=null;
        GrammarAST COLON109_tree=null;
        GrammarAST SEMI111_tree=null;
        RewriteRuleTokenStream stream_DOC_COMMENT=new RewriteRuleTokenStream(adaptor,"token DOC_COMMENT");
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_FRAGMENT=new RewriteRuleTokenStream(adaptor,"token FRAGMENT");
        RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
        RewriteRuleSubtreeStream stream_lexerRuleBlock=new RewriteRuleSubtreeStream(adaptor,"rule lexerRuleBlock");
         paraphrases.push("matching a lexer rule"); 
        try {
            // ANTLRParser.g:548:5: ( ( DOC_COMMENT )? ( FRAGMENT )? TOKEN_REF COLON lexerRuleBlock SEMI -> ^( RULE TOKEN_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS FRAGMENT ) )? lexerRuleBlock ) )
            // ANTLRParser.g:548:7: ( DOC_COMMENT )? ( FRAGMENT )? TOKEN_REF COLON lexerRuleBlock SEMI
            {
            // ANTLRParser.g:548:7: ( DOC_COMMENT )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==DOC_COMMENT) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ANTLRParser.g:548:7: DOC_COMMENT
                    {
                    DOC_COMMENT106=(Token)match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_lexerRule2213);  
                    stream_DOC_COMMENT.add(DOC_COMMENT106);


                    }
                    break;

            }


            // ANTLRParser.g:548:20: ( FRAGMENT )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==FRAGMENT) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ANTLRParser.g:548:20: FRAGMENT
                    {
                    FRAGMENT107=(Token)match(input,FRAGMENT,FOLLOW_FRAGMENT_in_lexerRule2216);  
                    stream_FRAGMENT.add(FRAGMENT107);


                    }
                    break;

            }


            TOKEN_REF108=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_lexerRule2222);  
            stream_TOKEN_REF.add(TOKEN_REF108);


            COLON109=(Token)match(input,COLON,FOLLOW_COLON_in_lexerRule2224);  
            stream_COLON.add(COLON109);


            pushFollow(FOLLOW_lexerRuleBlock_in_lexerRule2226);
            lexerRuleBlock110=lexerRuleBlock();

            state._fsp--;

            stream_lexerRuleBlock.add(lexerRuleBlock110.getTree());

            SEMI111=(Token)match(input,SEMI,FOLLOW_SEMI_in_lexerRule2228);  
            stream_SEMI.add(SEMI111);


            // AST REWRITE
            // elements: DOC_COMMENT, FRAGMENT, lexerRuleBlock, TOKEN_REF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 550:7: -> ^( RULE TOKEN_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS FRAGMENT ) )? lexerRuleBlock )
            {
                // ANTLRParser.g:550:10: ^( RULE TOKEN_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS FRAGMENT ) )? lexerRuleBlock )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new RuleAST(RULE)
                , root_1);

                adaptor.addChild(root_1, 
                stream_TOKEN_REF.nextNode()
                );

                // ANTLRParser.g:550:37: ( DOC_COMMENT )?
                if ( stream_DOC_COMMENT.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_DOC_COMMENT.nextNode()
                    );

                }
                stream_DOC_COMMENT.reset();

                // ANTLRParser.g:551:9: ( ^( RULEMODIFIERS FRAGMENT ) )?
                if ( stream_FRAGMENT.hasNext() ) {
                    // ANTLRParser.g:551:9: ^( RULEMODIFIERS FRAGMENT )
                    {
                    GrammarAST root_2 = (GrammarAST)adaptor.nil();
                    root_2 = (GrammarAST)adaptor.becomeRoot(
                    (GrammarAST)adaptor.create(RULEMODIFIERS, "RULEMODIFIERS")
                    , root_2);

                    adaptor.addChild(root_2, 
                    stream_FRAGMENT.nextNode()
                    );

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_FRAGMENT.reset();

                adaptor.addChild(root_1, stream_lexerRuleBlock.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            	paraphrases.pop();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerRule"


    public static class lexerRuleBlock_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerRuleBlock"
    // ANTLRParser.g:555:1: lexerRuleBlock : lexerAltList -> ^( BLOCK[colon,\"BLOCK\"] lexerAltList ) ;
    public final ANTLRParser.lexerRuleBlock_return lexerRuleBlock() throws RecognitionException {
        ANTLRParser.lexerRuleBlock_return retval = new ANTLRParser.lexerRuleBlock_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.lexerAltList_return lexerAltList112 =null;


        RewriteRuleSubtreeStream stream_lexerAltList=new RewriteRuleSubtreeStream(adaptor,"rule lexerAltList");
        Token colon = input.LT(-1);
        try {
            // ANTLRParser.g:557:5: ( lexerAltList -> ^( BLOCK[colon,\"BLOCK\"] lexerAltList ) )
            // ANTLRParser.g:557:7: lexerAltList
            {
            pushFollow(FOLLOW_lexerAltList_in_lexerRuleBlock2295);
            lexerAltList112=lexerAltList();

            state._fsp--;

            stream_lexerAltList.add(lexerAltList112.getTree());

            // AST REWRITE
            // elements: lexerAltList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 557:20: -> ^( BLOCK[colon,\"BLOCK\"] lexerAltList )
            {
                // ANTLRParser.g:557:23: ^( BLOCK[colon,\"BLOCK\"] lexerAltList )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new BlockAST(BLOCK, colon, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_lexerAltList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (ResyncToEndOfRuleBlock e) {

                	// just resyncing; ignore error
            		retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), null);
                
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerRuleBlock"


    public static class lexerAltList_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerAltList"
    // ANTLRParser.g:564:1: lexerAltList : lexerAlt ( OR lexerAlt )* -> ( lexerAlt )+ ;
    public final ANTLRParser.lexerAltList_return lexerAltList() throws RecognitionException {
        ANTLRParser.lexerAltList_return retval = new ANTLRParser.lexerAltList_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token OR114=null;
        ANTLRParser.lexerAlt_return lexerAlt113 =null;

        ANTLRParser.lexerAlt_return lexerAlt115 =null;


        GrammarAST OR114_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_lexerAlt=new RewriteRuleSubtreeStream(adaptor,"rule lexerAlt");
        try {
            // ANTLRParser.g:565:2: ( lexerAlt ( OR lexerAlt )* -> ( lexerAlt )+ )
            // ANTLRParser.g:565:4: lexerAlt ( OR lexerAlt )*
            {
            pushFollow(FOLLOW_lexerAlt_in_lexerAltList2331);
            lexerAlt113=lexerAlt();

            state._fsp--;

            stream_lexerAlt.add(lexerAlt113.getTree());

            // ANTLRParser.g:565:13: ( OR lexerAlt )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==OR) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ANTLRParser.g:565:14: OR lexerAlt
            	    {
            	    OR114=(Token)match(input,OR,FOLLOW_OR_in_lexerAltList2334);  
            	    stream_OR.add(OR114);


            	    pushFollow(FOLLOW_lexerAlt_in_lexerAltList2336);
            	    lexerAlt115=lexerAlt();

            	    state._fsp--;

            	    stream_lexerAlt.add(lexerAlt115.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            // AST REWRITE
            // elements: lexerAlt
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 565:28: -> ( lexerAlt )+
            {
                if ( !(stream_lexerAlt.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_lexerAlt.hasNext() ) {
                    adaptor.addChild(root_0, stream_lexerAlt.nextTree());

                }
                stream_lexerAlt.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerAltList"


    public static class lexerAlt_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerAlt"
    // ANTLRParser.g:568:1: lexerAlt : lexerElements ( lexerCommands -> ^( LEXER_ALT_ACTION lexerElements lexerCommands ) | -> lexerElements ) ;
    public final ANTLRParser.lexerAlt_return lexerAlt() throws RecognitionException {
        ANTLRParser.lexerAlt_return retval = new ANTLRParser.lexerAlt_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.lexerElements_return lexerElements116 =null;

        ANTLRParser.lexerCommands_return lexerCommands117 =null;


        RewriteRuleSubtreeStream stream_lexerElements=new RewriteRuleSubtreeStream(adaptor,"rule lexerElements");
        RewriteRuleSubtreeStream stream_lexerCommands=new RewriteRuleSubtreeStream(adaptor,"rule lexerCommands");
        try {
            // ANTLRParser.g:569:2: ( lexerElements ( lexerCommands -> ^( LEXER_ALT_ACTION lexerElements lexerCommands ) | -> lexerElements ) )
            // ANTLRParser.g:569:4: lexerElements ( lexerCommands -> ^( LEXER_ALT_ACTION lexerElements lexerCommands ) | -> lexerElements )
            {
            pushFollow(FOLLOW_lexerElements_in_lexerAlt2354);
            lexerElements116=lexerElements();

            state._fsp--;

            stream_lexerElements.add(lexerElements116.getTree());

            // ANTLRParser.g:570:3: ( lexerCommands -> ^( LEXER_ALT_ACTION lexerElements lexerCommands ) | -> lexerElements )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RARROW) ) {
                alt35=1;
            }
            else if ( (LA35_0==OR||LA35_0==RPAREN||LA35_0==SEMI) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // ANTLRParser.g:570:5: lexerCommands
                    {
                    pushFollow(FOLLOW_lexerCommands_in_lexerAlt2360);
                    lexerCommands117=lexerCommands();

                    state._fsp--;

                    stream_lexerCommands.add(lexerCommands117.getTree());

                    // AST REWRITE
                    // elements: lexerElements, lexerCommands
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 570:19: -> ^( LEXER_ALT_ACTION lexerElements lexerCommands )
                    {
                        // ANTLRParser.g:570:22: ^( LEXER_ALT_ACTION lexerElements lexerCommands )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new AltAST(LEXER_ALT_ACTION)
                        , root_1);

                        adaptor.addChild(root_1, stream_lexerElements.nextTree());

                        adaptor.addChild(root_1, stream_lexerCommands.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:571:9: 
                    {
                    // AST REWRITE
                    // elements: lexerElements
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 571:9: -> lexerElements
                    {
                        adaptor.addChild(root_0, stream_lexerElements.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerAlt"


    public static class lexerElements_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerElements"
    // ANTLRParser.g:575:1: lexerElements : ( lexerElement )+ -> ^( ALT ( lexerElement )+ ) ;
    public final ANTLRParser.lexerElements_return lexerElements() throws RecognitionException {
        ANTLRParser.lexerElements_return retval = new ANTLRParser.lexerElements_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.lexerElement_return lexerElement118 =null;


        RewriteRuleSubtreeStream stream_lexerElement=new RewriteRuleSubtreeStream(adaptor,"rule lexerElement");
        try {
            // ANTLRParser.g:576:5: ( ( lexerElement )+ -> ^( ALT ( lexerElement )+ ) )
            // ANTLRParser.g:576:7: ( lexerElement )+
            {
            // ANTLRParser.g:576:7: ( lexerElement )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==ACTION||LA36_0==DOT||LA36_0==LEXER_CHAR_SET||LA36_0==LPAREN||LA36_0==NOT||LA36_0==RULE_REF||LA36_0==SEMPRED||LA36_0==STRING_LITERAL||LA36_0==TOKEN_REF) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ANTLRParser.g:576:7: lexerElement
            	    {
            	    pushFollow(FOLLOW_lexerElement_in_lexerElements2403);
            	    lexerElement118=lexerElement();

            	    state._fsp--;

            	    stream_lexerElement.add(lexerElement118.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);


            // AST REWRITE
            // elements: lexerElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 576:21: -> ^( ALT ( lexerElement )+ )
            {
                // ANTLRParser.g:576:24: ^( ALT ( lexerElement )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new AltAST(ALT)
                , root_1);

                if ( !(stream_lexerElement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_lexerElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_lexerElement.nextTree());

                }
                stream_lexerElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerElements"


    public static class lexerElement_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerElement"
    // ANTLRParser.g:579:1: lexerElement : ( labeledLexerElement ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledLexerElement.start,\"BLOCK\"] ^( ALT labeledLexerElement ) ) ) | -> labeledLexerElement ) | lexerAtom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$lexerAtom.start,\"BLOCK\"] ^( ALT lexerAtom ) ) ) | -> lexerAtom ) | lexerBlock ( ebnfSuffix -> ^( ebnfSuffix lexerBlock ) | -> lexerBlock ) | actionElement );
    public final ANTLRParser.lexerElement_return lexerElement() throws RecognitionException {
        ANTLRParser.lexerElement_return retval = new ANTLRParser.lexerElement_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.labeledLexerElement_return labeledLexerElement119 =null;

        ANTLRParser.ebnfSuffix_return ebnfSuffix120 =null;

        ANTLRParser.lexerAtom_return lexerAtom121 =null;

        ANTLRParser.ebnfSuffix_return ebnfSuffix122 =null;

        ANTLRParser.lexerBlock_return lexerBlock123 =null;

        ANTLRParser.ebnfSuffix_return ebnfSuffix124 =null;

        ANTLRParser.actionElement_return actionElement125 =null;


        RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");
        RewriteRuleSubtreeStream stream_lexerBlock=new RewriteRuleSubtreeStream(adaptor,"rule lexerBlock");
        RewriteRuleSubtreeStream stream_labeledLexerElement=new RewriteRuleSubtreeStream(adaptor,"rule labeledLexerElement");
        RewriteRuleSubtreeStream stream_lexerAtom=new RewriteRuleSubtreeStream(adaptor,"rule lexerAtom");

        	paraphrases.push("looking for lexer rule element");
        	int m = input.mark();

        try {
            // ANTLRParser.g:585:2: ( labeledLexerElement ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledLexerElement.start,\"BLOCK\"] ^( ALT labeledLexerElement ) ) ) | -> labeledLexerElement ) | lexerAtom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$lexerAtom.start,\"BLOCK\"] ^( ALT lexerAtom ) ) ) | -> lexerAtom ) | lexerBlock ( ebnfSuffix -> ^( ebnfSuffix lexerBlock ) | -> lexerBlock ) | actionElement )
            int alt40=4;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==ASSIGN||LA40_1==PLUS_ASSIGN) ) {
                    alt40=1;
                }
                else if ( (LA40_1==ACTION||LA40_1==DOT||LA40_1==LEXER_CHAR_SET||LA40_1==LPAREN||LA40_1==NOT||LA40_1==OR||LA40_1==PLUS||LA40_1==QUESTION||LA40_1==RARROW||(LA40_1 >= RPAREN && LA40_1 <= SEMPRED)||(LA40_1 >= STAR && LA40_1 <= STRING_LITERAL)||LA40_1==TOKEN_REF) ) {
                    alt40=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 1, input);

                    throw nvae;

                }
                }
                break;
            case TOKEN_REF:
                {
                int LA40_2 = input.LA(2);

                if ( (LA40_2==ASSIGN||LA40_2==PLUS_ASSIGN) ) {
                    alt40=1;
                }
                else if ( (LA40_2==ACTION||LA40_2==DOT||LA40_2==LEXER_CHAR_SET||(LA40_2 >= LPAREN && LA40_2 <= LT)||LA40_2==NOT||LA40_2==OR||LA40_2==PLUS||LA40_2==QUESTION||LA40_2==RARROW||(LA40_2 >= RPAREN && LA40_2 <= SEMPRED)||(LA40_2 >= STAR && LA40_2 <= STRING_LITERAL)||LA40_2==TOKEN_REF) ) {
                    alt40=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 2, input);

                    throw nvae;

                }
                }
                break;
            case DOT:
            case LEXER_CHAR_SET:
            case NOT:
            case STRING_LITERAL:
                {
                alt40=2;
                }
                break;
            case LPAREN:
                {
                alt40=3;
                }
                break;
            case ACTION:
            case SEMPRED:
                {
                alt40=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // ANTLRParser.g:585:4: labeledLexerElement ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledLexerElement.start,\"BLOCK\"] ^( ALT labeledLexerElement ) ) ) | -> labeledLexerElement )
                    {
                    pushFollow(FOLLOW_labeledLexerElement_in_lexerElement2440);
                    labeledLexerElement119=labeledLexerElement();

                    state._fsp--;

                    stream_labeledLexerElement.add(labeledLexerElement119.getTree());

                    // ANTLRParser.g:586:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledLexerElement.start,\"BLOCK\"] ^( ALT labeledLexerElement ) ) ) | -> labeledLexerElement )
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( (LA37_0==PLUS||LA37_0==QUESTION||LA37_0==STAR) ) {
                        alt37=1;
                    }
                    else if ( (LA37_0==ACTION||LA37_0==DOT||LA37_0==LEXER_CHAR_SET||LA37_0==LPAREN||LA37_0==NOT||LA37_0==OR||LA37_0==RARROW||(LA37_0 >= RPAREN && LA37_0 <= SEMPRED)||LA37_0==STRING_LITERAL||LA37_0==TOKEN_REF) ) {
                        alt37=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 37, 0, input);

                        throw nvae;

                    }
                    switch (alt37) {
                        case 1 :
                            // ANTLRParser.g:586:5: ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_lexerElement2446);
                            ebnfSuffix120=ebnfSuffix();

                            state._fsp--;

                            stream_ebnfSuffix.add(ebnfSuffix120.getTree());

                            // AST REWRITE
                            // elements: ebnfSuffix, labeledLexerElement
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 586:16: -> ^( ebnfSuffix ^( BLOCK[$labeledLexerElement.start,\"BLOCK\"] ^( ALT labeledLexerElement ) ) )
                            {
                                // ANTLRParser.g:586:19: ^( ebnfSuffix ^( BLOCK[$labeledLexerElement.start,\"BLOCK\"] ^( ALT labeledLexerElement ) ) )
                                {
                                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                                root_1 = (GrammarAST)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);

                                // ANTLRParser.g:586:33: ^( BLOCK[$labeledLexerElement.start,\"BLOCK\"] ^( ALT labeledLexerElement ) )
                                {
                                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                                root_2 = (GrammarAST)adaptor.becomeRoot(
                                new BlockAST(BLOCK, (labeledLexerElement119!=null?((Token)labeledLexerElement119.start):null), "BLOCK")
                                , root_2);

                                // ANTLRParser.g:586:87: ^( ALT labeledLexerElement )
                                {
                                GrammarAST root_3 = (GrammarAST)adaptor.nil();
                                root_3 = (GrammarAST)adaptor.becomeRoot(
                                new AltAST(ALT)
                                , root_3);

                                adaptor.addChild(root_3, stream_labeledLexerElement.nextTree());

                                adaptor.addChild(root_2, root_3);
                                }

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 2 :
                            // ANTLRParser.g:587:8: 
                            {
                            // AST REWRITE
                            // elements: labeledLexerElement
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 587:8: -> labeledLexerElement
                            {
                                adaptor.addChild(root_0, stream_labeledLexerElement.nextTree());

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ANTLRParser.g:589:4: lexerAtom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$lexerAtom.start,\"BLOCK\"] ^( ALT lexerAtom ) ) ) | -> lexerAtom )
                    {
                    pushFollow(FOLLOW_lexerAtom_in_lexerElement2492);
                    lexerAtom121=lexerAtom();

                    state._fsp--;

                    stream_lexerAtom.add(lexerAtom121.getTree());

                    // ANTLRParser.g:590:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$lexerAtom.start,\"BLOCK\"] ^( ALT lexerAtom ) ) ) | -> lexerAtom )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==PLUS||LA38_0==QUESTION||LA38_0==STAR) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==ACTION||LA38_0==DOT||LA38_0==LEXER_CHAR_SET||LA38_0==LPAREN||LA38_0==NOT||LA38_0==OR||LA38_0==RARROW||(LA38_0 >= RPAREN && LA38_0 <= SEMPRED)||LA38_0==STRING_LITERAL||LA38_0==TOKEN_REF) ) {
                        alt38=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;

                    }
                    switch (alt38) {
                        case 1 :
                            // ANTLRParser.g:590:5: ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_lexerElement2498);
                            ebnfSuffix122=ebnfSuffix();

                            state._fsp--;

                            stream_ebnfSuffix.add(ebnfSuffix122.getTree());

                            // AST REWRITE
                            // elements: ebnfSuffix, lexerAtom
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 590:16: -> ^( ebnfSuffix ^( BLOCK[$lexerAtom.start,\"BLOCK\"] ^( ALT lexerAtom ) ) )
                            {
                                // ANTLRParser.g:590:19: ^( ebnfSuffix ^( BLOCK[$lexerAtom.start,\"BLOCK\"] ^( ALT lexerAtom ) ) )
                                {
                                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                                root_1 = (GrammarAST)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);

                                // ANTLRParser.g:590:33: ^( BLOCK[$lexerAtom.start,\"BLOCK\"] ^( ALT lexerAtom ) )
                                {
                                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                                root_2 = (GrammarAST)adaptor.becomeRoot(
                                new BlockAST(BLOCK, (lexerAtom121!=null?((Token)lexerAtom121.start):null), "BLOCK")
                                , root_2);

                                // ANTLRParser.g:590:77: ^( ALT lexerAtom )
                                {
                                GrammarAST root_3 = (GrammarAST)adaptor.nil();
                                root_3 = (GrammarAST)adaptor.becomeRoot(
                                new AltAST(ALT)
                                , root_3);

                                adaptor.addChild(root_3, stream_lexerAtom.nextTree());

                                adaptor.addChild(root_2, root_3);
                                }

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 2 :
                            // ANTLRParser.g:591:8: 
                            {
                            // AST REWRITE
                            // elements: lexerAtom
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 591:8: -> lexerAtom
                            {
                                adaptor.addChild(root_0, stream_lexerAtom.nextTree());

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ANTLRParser.g:593:4: lexerBlock ( ebnfSuffix -> ^( ebnfSuffix lexerBlock ) | -> lexerBlock )
                    {
                    pushFollow(FOLLOW_lexerBlock_in_lexerElement2544);
                    lexerBlock123=lexerBlock();

                    state._fsp--;

                    stream_lexerBlock.add(lexerBlock123.getTree());

                    // ANTLRParser.g:594:3: ( ebnfSuffix -> ^( ebnfSuffix lexerBlock ) | -> lexerBlock )
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==PLUS||LA39_0==QUESTION||LA39_0==STAR) ) {
                        alt39=1;
                    }
                    else if ( (LA39_0==ACTION||LA39_0==DOT||LA39_0==LEXER_CHAR_SET||LA39_0==LPAREN||LA39_0==NOT||LA39_0==OR||LA39_0==RARROW||(LA39_0 >= RPAREN && LA39_0 <= SEMPRED)||LA39_0==STRING_LITERAL||LA39_0==TOKEN_REF) ) {
                        alt39=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 39, 0, input);

                        throw nvae;

                    }
                    switch (alt39) {
                        case 1 :
                            // ANTLRParser.g:594:5: ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_lexerElement2550);
                            ebnfSuffix124=ebnfSuffix();

                            state._fsp--;

                            stream_ebnfSuffix.add(ebnfSuffix124.getTree());

                            // AST REWRITE
                            // elements: lexerBlock, ebnfSuffix
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 594:16: -> ^( ebnfSuffix lexerBlock )
                            {
                                // ANTLRParser.g:594:19: ^( ebnfSuffix lexerBlock )
                                {
                                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                                root_1 = (GrammarAST)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);

                                adaptor.addChild(root_1, stream_lexerBlock.nextTree());

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 2 :
                            // ANTLRParser.g:595:8: 
                            {
                            // AST REWRITE
                            // elements: lexerBlock
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 595:8: -> lexerBlock
                            {
                                adaptor.addChild(root_0, stream_lexerBlock.nextTree());

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 4 :
                    // ANTLRParser.g:597:4: actionElement
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_actionElement_in_lexerElement2578);
                    actionElement125=actionElement();

                    state._fsp--;

                    adaptor.addChild(root_0, actionElement125.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

             paraphrases.pop(); 
        }
        catch (RecognitionException re) {

                	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
                	int ttype = input.get(input.range()).getType();
            	    // look for anything that really belongs at the start of the rule minus the initial ID
                	if ( ttype==COLON || ttype==RETURNS || ttype==CATCH || ttype==FINALLY || ttype==AT ) {
            			RecognitionException missingSemi =
            				new v4ParserException("unterminated rule (missing ';') detected at '"+
            									  input.LT(1).getText()+" "+input.LT(2).getText()+"'", input);
            			reportError(missingSemi);
            			if ( ttype==CATCH || ttype==FINALLY ) {
            				input.seek(input.range()); // ignore what's before rule trailer stuff
            			}
            			if ( ttype==RETURNS || ttype==AT ) { // scan back looking for ID of rule header
            				int p = input.index();
            				Token t = input.get(p);
            				while ( t.getType()!=RULE_REF && t.getType()!=TOKEN_REF ) {
            					p--;
            					t = input.get(p);
            				}
            				input.seek(p);
            			}
            			throw new ResyncToEndOfRuleBlock(); // make sure it goes back to rule block level to recover
            		}
                    reportError(re);
                    recover(input,re);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerElement"


    public static class labeledLexerElement_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "labeledLexerElement"
    // ANTLRParser.g:627:1: labeledLexerElement : id (ass= ASSIGN |ass= PLUS_ASSIGN ) ( lexerAtom -> ^( $ass id lexerAtom ) | block -> ^( $ass id block ) ) ;
    public final ANTLRParser.labeledLexerElement_return labeledLexerElement() throws RecognitionException {
        ANTLRParser.labeledLexerElement_return retval = new ANTLRParser.labeledLexerElement_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token ass=null;
        ANTLRParser.id_return id126 =null;

        ANTLRParser.lexerAtom_return lexerAtom127 =null;

        ANTLRParser.block_return block128 =null;


        GrammarAST ass_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleTokenStream stream_PLUS_ASSIGN=new RewriteRuleTokenStream(adaptor,"token PLUS_ASSIGN");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_lexerAtom=new RewriteRuleSubtreeStream(adaptor,"rule lexerAtom");
        try {
            // ANTLRParser.g:628:2: ( id (ass= ASSIGN |ass= PLUS_ASSIGN ) ( lexerAtom -> ^( $ass id lexerAtom ) | block -> ^( $ass id block ) ) )
            // ANTLRParser.g:628:4: id (ass= ASSIGN |ass= PLUS_ASSIGN ) ( lexerAtom -> ^( $ass id lexerAtom ) | block -> ^( $ass id block ) )
            {
            pushFollow(FOLLOW_id_in_labeledLexerElement2608);
            id126=id();

            state._fsp--;

            stream_id.add(id126.getTree());

            // ANTLRParser.g:628:7: (ass= ASSIGN |ass= PLUS_ASSIGN )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==ASSIGN) ) {
                alt41=1;
            }
            else if ( (LA41_0==PLUS_ASSIGN) ) {
                alt41=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // ANTLRParser.g:628:8: ass= ASSIGN
                    {
                    ass=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_labeledLexerElement2613);  
                    stream_ASSIGN.add(ass);


                    }
                    break;
                case 2 :
                    // ANTLRParser.g:628:19: ass= PLUS_ASSIGN
                    {
                    ass=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_labeledLexerElement2617);  
                    stream_PLUS_ASSIGN.add(ass);


                    }
                    break;

            }


            // ANTLRParser.g:629:3: ( lexerAtom -> ^( $ass id lexerAtom ) | block -> ^( $ass id block ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==DOT||LA42_0==LEXER_CHAR_SET||LA42_0==NOT||LA42_0==RULE_REF||LA42_0==STRING_LITERAL||LA42_0==TOKEN_REF) ) {
                alt42=1;
            }
            else if ( (LA42_0==LPAREN) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // ANTLRParser.g:629:5: lexerAtom
                    {
                    pushFollow(FOLLOW_lexerAtom_in_labeledLexerElement2624);
                    lexerAtom127=lexerAtom();

                    state._fsp--;

                    stream_lexerAtom.add(lexerAtom127.getTree());

                    // AST REWRITE
                    // elements: ass, id, lexerAtom
                    // token labels: ass
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_ass=new RewriteRuleTokenStream(adaptor,"token ass",ass);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 629:15: -> ^( $ass id lexerAtom )
                    {
                        // ANTLRParser.g:629:18: ^( $ass id lexerAtom )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(stream_ass.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_1, stream_lexerAtom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:630:5: block
                    {
                    pushFollow(FOLLOW_block_in_labeledLexerElement2641);
                    block128=block();

                    state._fsp--;

                    stream_block.add(block128.getTree());

                    // AST REWRITE
                    // elements: block, ass, id
                    // token labels: ass
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_ass=new RewriteRuleTokenStream(adaptor,"token ass",ass);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 630:13: -> ^( $ass id block )
                    {
                        // ANTLRParser.g:630:16: ^( $ass id block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(stream_ass.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "labeledLexerElement"


    public static class lexerBlock_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerBlock"
    // ANTLRParser.g:634:1: lexerBlock : LPAREN lexerAltList RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] lexerAltList ) ;
    public final ANTLRParser.lexerBlock_return lexerBlock() throws RecognitionException {
        ANTLRParser.lexerBlock_return retval = new ANTLRParser.lexerBlock_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token LPAREN129=null;
        Token RPAREN131=null;
        ANTLRParser.lexerAltList_return lexerAltList130 =null;


        GrammarAST LPAREN129_tree=null;
        GrammarAST RPAREN131_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_lexerAltList=new RewriteRuleSubtreeStream(adaptor,"rule lexerAltList");
        try {
            // ANTLRParser.g:635:3: ( LPAREN lexerAltList RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] lexerAltList ) )
            // ANTLRParser.g:635:5: LPAREN lexerAltList RPAREN
            {
            LPAREN129=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_lexerBlock2670);  
            stream_LPAREN.add(LPAREN129);


            pushFollow(FOLLOW_lexerAltList_in_lexerBlock2672);
            lexerAltList130=lexerAltList();

            state._fsp--;

            stream_lexerAltList.add(lexerAltList130.getTree());

            RPAREN131=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_lexerBlock2674);  
            stream_RPAREN.add(RPAREN131);


            // AST REWRITE
            // elements: lexerAltList
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 636:7: -> ^( BLOCK[$LPAREN,\"BLOCK\"] lexerAltList )
            {
                // ANTLRParser.g:636:10: ^( BLOCK[$LPAREN,\"BLOCK\"] lexerAltList )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new BlockAST(BLOCK, LPAREN129, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_lexerAltList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerBlock"


    public static class lexerCommands_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerCommands"
    // ANTLRParser.g:640:1: lexerCommands : RARROW lexerCommand ( COMMA lexerCommand )* -> ( lexerCommand )+ ;
    public final ANTLRParser.lexerCommands_return lexerCommands() throws RecognitionException {
        ANTLRParser.lexerCommands_return retval = new ANTLRParser.lexerCommands_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token RARROW132=null;
        Token COMMA134=null;
        ANTLRParser.lexerCommand_return lexerCommand133 =null;

        ANTLRParser.lexerCommand_return lexerCommand135 =null;


        GrammarAST RARROW132_tree=null;
        GrammarAST COMMA134_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_RARROW=new RewriteRuleTokenStream(adaptor,"token RARROW");
        RewriteRuleSubtreeStream stream_lexerCommand=new RewriteRuleSubtreeStream(adaptor,"rule lexerCommand");
        try {
            // ANTLRParser.g:641:2: ( RARROW lexerCommand ( COMMA lexerCommand )* -> ( lexerCommand )+ )
            // ANTLRParser.g:641:4: RARROW lexerCommand ( COMMA lexerCommand )*
            {
            RARROW132=(Token)match(input,RARROW,FOLLOW_RARROW_in_lexerCommands2708);  
            stream_RARROW.add(RARROW132);


            pushFollow(FOLLOW_lexerCommand_in_lexerCommands2710);
            lexerCommand133=lexerCommand();

            state._fsp--;

            stream_lexerCommand.add(lexerCommand133.getTree());

            // ANTLRParser.g:641:24: ( COMMA lexerCommand )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==COMMA) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // ANTLRParser.g:641:25: COMMA lexerCommand
            	    {
            	    COMMA134=(Token)match(input,COMMA,FOLLOW_COMMA_in_lexerCommands2713);  
            	    stream_COMMA.add(COMMA134);


            	    pushFollow(FOLLOW_lexerCommand_in_lexerCommands2715);
            	    lexerCommand135=lexerCommand();

            	    state._fsp--;

            	    stream_lexerCommand.add(lexerCommand135.getTree());

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            // AST REWRITE
            // elements: lexerCommand
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 641:46: -> ( lexerCommand )+
            {
                if ( !(stream_lexerCommand.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_lexerCommand.hasNext() ) {
                    adaptor.addChild(root_0, stream_lexerCommand.nextTree());

                }
                stream_lexerCommand.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerCommands"


    public static class lexerCommand_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerCommand"
    // ANTLRParser.g:644:1: lexerCommand : ( lexerCommandName LPAREN lexerCommandExpr RPAREN -> ^( LEXER_ACTION_CALL lexerCommandName lexerCommandExpr ) | lexerCommandName );
    public final ANTLRParser.lexerCommand_return lexerCommand() throws RecognitionException {
        ANTLRParser.lexerCommand_return retval = new ANTLRParser.lexerCommand_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token LPAREN137=null;
        Token RPAREN139=null;
        ANTLRParser.lexerCommandName_return lexerCommandName136 =null;

        ANTLRParser.lexerCommandExpr_return lexerCommandExpr138 =null;

        ANTLRParser.lexerCommandName_return lexerCommandName140 =null;


        GrammarAST LPAREN137_tree=null;
        GrammarAST RPAREN139_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_lexerCommandName=new RewriteRuleSubtreeStream(adaptor,"rule lexerCommandName");
        RewriteRuleSubtreeStream stream_lexerCommandExpr=new RewriteRuleSubtreeStream(adaptor,"rule lexerCommandExpr");
        try {
            // ANTLRParser.g:645:2: ( lexerCommandName LPAREN lexerCommandExpr RPAREN -> ^( LEXER_ACTION_CALL lexerCommandName lexerCommandExpr ) | lexerCommandName )
            int alt44=2;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==LPAREN) ) {
                    alt44=1;
                }
                else if ( (LA44_1==COMMA||LA44_1==OR||LA44_1==RPAREN||LA44_1==SEMI) ) {
                    alt44=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;

                }
                }
                break;
            case TOKEN_REF:
                {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==LPAREN) ) {
                    alt44=1;
                }
                else if ( (LA44_2==COMMA||LA44_2==OR||LA44_2==RPAREN||LA44_2==SEMI) ) {
                    alt44=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;

                }
                }
                break;
            case MODE:
                {
                int LA44_3 = input.LA(2);

                if ( (LA44_3==LPAREN) ) {
                    alt44=1;
                }
                else if ( (LA44_3==COMMA||LA44_3==OR||LA44_3==RPAREN||LA44_3==SEMI) ) {
                    alt44=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 3, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // ANTLRParser.g:645:4: lexerCommandName LPAREN lexerCommandExpr RPAREN
                    {
                    pushFollow(FOLLOW_lexerCommandName_in_lexerCommand2733);
                    lexerCommandName136=lexerCommandName();

                    state._fsp--;

                    stream_lexerCommandName.add(lexerCommandName136.getTree());

                    LPAREN137=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_lexerCommand2735);  
                    stream_LPAREN.add(LPAREN137);


                    pushFollow(FOLLOW_lexerCommandExpr_in_lexerCommand2737);
                    lexerCommandExpr138=lexerCommandExpr();

                    state._fsp--;

                    stream_lexerCommandExpr.add(lexerCommandExpr138.getTree());

                    RPAREN139=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_lexerCommand2739);  
                    stream_RPAREN.add(RPAREN139);


                    // AST REWRITE
                    // elements: lexerCommandName, lexerCommandExpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 645:52: -> ^( LEXER_ACTION_CALL lexerCommandName lexerCommandExpr )
                    {
                        // ANTLRParser.g:645:55: ^( LEXER_ACTION_CALL lexerCommandName lexerCommandExpr )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        (GrammarAST)adaptor.create(LEXER_ACTION_CALL, "LEXER_ACTION_CALL")
                        , root_1);

                        adaptor.addChild(root_1, stream_lexerCommandName.nextTree());

                        adaptor.addChild(root_1, stream_lexerCommandExpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:646:4: lexerCommandName
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_lexerCommandName_in_lexerCommand2754);
                    lexerCommandName140=lexerCommandName();

                    state._fsp--;

                    adaptor.addChild(root_0, lexerCommandName140.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerCommand"


    public static class lexerCommandExpr_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerCommandExpr"
    // ANTLRParser.g:649:1: lexerCommandExpr : ( id | INT );
    public final ANTLRParser.lexerCommandExpr_return lexerCommandExpr() throws RecognitionException {
        ANTLRParser.lexerCommandExpr_return retval = new ANTLRParser.lexerCommandExpr_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token INT142=null;
        ANTLRParser.id_return id141 =null;


        GrammarAST INT142_tree=null;

        try {
            // ANTLRParser.g:650:2: ( id | INT )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_REF||LA45_0==TOKEN_REF) ) {
                alt45=1;
            }
            else if ( (LA45_0==INT) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;

            }
            switch (alt45) {
                case 1 :
                    // ANTLRParser.g:650:4: id
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_id_in_lexerCommandExpr2765);
                    id141=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id141.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:651:4: INT
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    INT142=(Token)match(input,INT,FOLLOW_INT_in_lexerCommandExpr2770); 
                    INT142_tree = 
                    (GrammarAST)adaptor.create(INT142)
                    ;
                    adaptor.addChild(root_0, INT142_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerCommandExpr"


    public static class lexerCommandName_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerCommandName"
    // ANTLRParser.g:654:1: lexerCommandName : ( id | MODE -> ID[$MODE] );
    public final ANTLRParser.lexerCommandName_return lexerCommandName() throws RecognitionException {
        ANTLRParser.lexerCommandName_return retval = new ANTLRParser.lexerCommandName_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token MODE144=null;
        ANTLRParser.id_return id143 =null;


        GrammarAST MODE144_tree=null;
        RewriteRuleTokenStream stream_MODE=new RewriteRuleTokenStream(adaptor,"token MODE");

        try {
            // ANTLRParser.g:655:9: ( id | MODE -> ID[$MODE] )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_REF||LA46_0==TOKEN_REF) ) {
                alt46=1;
            }
            else if ( (LA46_0==MODE) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }
            switch (alt46) {
                case 1 :
                    // ANTLRParser.g:655:17: id
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_id_in_lexerCommandName2794);
                    id143=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id143.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:656:17: MODE
                    {
                    MODE144=(Token)match(input,MODE,FOLLOW_MODE_in_lexerCommandName2812);  
                    stream_MODE.add(MODE144);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 656:25: -> ID[$MODE]
                    {
                        adaptor.addChild(root_0, 
                        (GrammarAST)adaptor.create(ID, MODE144)
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerCommandName"


    public static class altList_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "altList"
    // ANTLRParser.g:659:1: altList : alternative ( OR alternative )* -> ( alternative )+ ;
    public final ANTLRParser.altList_return altList() throws RecognitionException {
        ANTLRParser.altList_return retval = new ANTLRParser.altList_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token OR146=null;
        ANTLRParser.alternative_return alternative145 =null;

        ANTLRParser.alternative_return alternative147 =null;


        GrammarAST OR146_tree=null;
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_alternative=new RewriteRuleSubtreeStream(adaptor,"rule alternative");
        try {
            // ANTLRParser.g:660:5: ( alternative ( OR alternative )* -> ( alternative )+ )
            // ANTLRParser.g:660:7: alternative ( OR alternative )*
            {
            pushFollow(FOLLOW_alternative_in_altList2840);
            alternative145=alternative();

            state._fsp--;

            stream_alternative.add(alternative145.getTree());

            // ANTLRParser.g:660:19: ( OR alternative )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==OR) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ANTLRParser.g:660:20: OR alternative
            	    {
            	    OR146=(Token)match(input,OR,FOLLOW_OR_in_altList2843);  
            	    stream_OR.add(OR146);


            	    pushFollow(FOLLOW_alternative_in_altList2845);
            	    alternative147=alternative();

            	    state._fsp--;

            	    stream_alternative.add(alternative147.getTree());

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            // AST REWRITE
            // elements: alternative
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 660:37: -> ( alternative )+
            {
                if ( !(stream_alternative.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_alternative.hasNext() ) {
                    adaptor.addChild(root_0, stream_alternative.nextTree());

                }
                stream_alternative.reset();

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "altList"


    public static class alternative_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alternative"
    // ANTLRParser.g:665:1: alternative : ( elements -> elements | -> ^( ALT EPSILON ) );
    public final ANTLRParser.alternative_return alternative() throws RecognitionException {
        ANTLRParser.alternative_return retval = new ANTLRParser.alternative_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.elements_return elements148 =null;


        RewriteRuleSubtreeStream stream_elements=new RewriteRuleSubtreeStream(adaptor,"rule elements");
         paraphrases.push("matching alternative"); 
        try {
            // ANTLRParser.g:668:5: ( elements -> elements | -> ^( ALT EPSILON ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==ACTION||LA48_0==DOT||LA48_0==LPAREN||LA48_0==NOT||LA48_0==RULE_REF||LA48_0==SEMPRED||LA48_0==STRING_LITERAL||LA48_0==TOKEN_REF) ) {
                alt48=1;
            }
            else if ( (LA48_0==EOF||LA48_0==OR||LA48_0==POUND||LA48_0==RPAREN||LA48_0==SEMI) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;

            }
            switch (alt48) {
                case 1 :
                    // ANTLRParser.g:668:7: elements
                    {
                    pushFollow(FOLLOW_elements_in_alternative2881);
                    elements148=elements();

                    state._fsp--;

                    stream_elements.add(elements148.getTree());

                    // AST REWRITE
                    // elements: elements
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 668:16: -> elements
                    {
                        adaptor.addChild(root_0, stream_elements.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:669:10: 
                    {
                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 669:10: -> ^( ALT EPSILON )
                    {
                        // ANTLRParser.g:669:13: ^( ALT EPSILON )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new AltAST(ALT)
                        , root_1);

                        adaptor.addChild(root_1, 
                        (GrammarAST)adaptor.create(EPSILON, "EPSILON")
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

             paraphrases.pop(); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alternative"


    public static class elements_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elements"
    // ANTLRParser.g:672:1: elements : (e+= element )+ -> ^( ALT ( $e)+ ) ;
    public final ANTLRParser.elements_return elements() throws RecognitionException {
        ANTLRParser.elements_return retval = new ANTLRParser.elements_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        List list_e=null;
        RuleReturnScope e = null;
        RewriteRuleSubtreeStream stream_element=new RewriteRuleSubtreeStream(adaptor,"rule element");
        try {
            // ANTLRParser.g:673:5: ( (e+= element )+ -> ^( ALT ( $e)+ ) )
            // ANTLRParser.g:673:7: (e+= element )+
            {
            // ANTLRParser.g:673:8: (e+= element )+
            int cnt49=0;
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==ACTION||LA49_0==DOT||LA49_0==LPAREN||LA49_0==NOT||LA49_0==RULE_REF||LA49_0==SEMPRED||LA49_0==STRING_LITERAL||LA49_0==TOKEN_REF) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ANTLRParser.g:673:8: e+= element
            	    {
            	    pushFollow(FOLLOW_element_in_elements2925);
            	    e=element();

            	    state._fsp--;

            	    stream_element.add(e.getTree());
            	    if (list_e==null) list_e=new ArrayList();
            	    list_e.add(e.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt49 >= 1 ) break loop49;
                        EarlyExitException eee =
                            new EarlyExitException(49, input);
                        throw eee;
                }
                cnt49++;
            } while (true);


            // AST REWRITE
            // elements: e
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: e
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_e=new RewriteRuleSubtreeStream(adaptor,"token e",list_e);
            root_0 = (GrammarAST)adaptor.nil();
            // 673:19: -> ^( ALT ( $e)+ )
            {
                // ANTLRParser.g:673:22: ^( ALT ( $e)+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new AltAST(ALT)
                , root_1);

                if ( !(stream_e.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_e.hasNext() ) {
                    adaptor.addChild(root_1, stream_e.nextTree());

                }
                stream_e.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elements"


    public static class element_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "element"
    // ANTLRParser.g:676:1: element : ( labeledElement ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledElement.start,\"BLOCK\"] ^( ALT labeledElement ) ) ) | -> labeledElement ) | atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$atom.start,\"BLOCK\"] ^( ALT atom ) ) ) | -> atom ) | ebnf | actionElement );
    public final ANTLRParser.element_return element() throws RecognitionException {
        ANTLRParser.element_return retval = new ANTLRParser.element_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.labeledElement_return labeledElement149 =null;

        ANTLRParser.ebnfSuffix_return ebnfSuffix150 =null;

        ANTLRParser.atom_return atom151 =null;

        ANTLRParser.ebnfSuffix_return ebnfSuffix152 =null;

        ANTLRParser.ebnf_return ebnf153 =null;

        ANTLRParser.actionElement_return actionElement154 =null;


        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");
        RewriteRuleSubtreeStream stream_labeledElement=new RewriteRuleSubtreeStream(adaptor,"rule labeledElement");

        	paraphrases.push("looking for rule element");
        	int m = input.mark();

        try {
            // ANTLRParser.g:682:2: ( labeledElement ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledElement.start,\"BLOCK\"] ^( ALT labeledElement ) ) ) | -> labeledElement ) | atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$atom.start,\"BLOCK\"] ^( ALT atom ) ) ) | -> atom ) | ebnf | actionElement )
            int alt52=4;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==ASSIGN||LA52_1==PLUS_ASSIGN) ) {
                    alt52=1;
                }
                else if ( (LA52_1==EOF||LA52_1==ACTION||LA52_1==ARG_ACTION||LA52_1==DOT||LA52_1==LPAREN||LA52_1==NOT||LA52_1==OR||LA52_1==PLUS||LA52_1==POUND||LA52_1==QUESTION||(LA52_1 >= RPAREN && LA52_1 <= SEMPRED)||(LA52_1 >= STAR && LA52_1 <= STRING_LITERAL)||LA52_1==TOKEN_REF) ) {
                    alt52=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;

                }
                }
                break;
            case TOKEN_REF:
                {
                int LA52_2 = input.LA(2);

                if ( (LA52_2==ASSIGN||LA52_2==PLUS_ASSIGN) ) {
                    alt52=1;
                }
                else if ( (LA52_2==EOF||LA52_2==ACTION||LA52_2==DOT||(LA52_2 >= LPAREN && LA52_2 <= LT)||LA52_2==NOT||LA52_2==OR||LA52_2==PLUS||LA52_2==POUND||LA52_2==QUESTION||(LA52_2 >= RPAREN && LA52_2 <= SEMPRED)||(LA52_2 >= STAR && LA52_2 <= STRING_LITERAL)||LA52_2==TOKEN_REF) ) {
                    alt52=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;

                }
                }
                break;
            case DOT:
            case NOT:
            case STRING_LITERAL:
                {
                alt52=2;
                }
                break;
            case LPAREN:
                {
                alt52=3;
                }
                break;
            case ACTION:
            case SEMPRED:
                {
                alt52=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }

            switch (alt52) {
                case 1 :
                    // ANTLRParser.g:682:4: labeledElement ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledElement.start,\"BLOCK\"] ^( ALT labeledElement ) ) ) | -> labeledElement )
                    {
                    pushFollow(FOLLOW_labeledElement_in_element2963);
                    labeledElement149=labeledElement();

                    state._fsp--;

                    stream_labeledElement.add(labeledElement149.getTree());

                    // ANTLRParser.g:683:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$labeledElement.start,\"BLOCK\"] ^( ALT labeledElement ) ) ) | -> labeledElement )
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==PLUS||LA50_0==QUESTION||LA50_0==STAR) ) {
                        alt50=1;
                    }
                    else if ( (LA50_0==EOF||LA50_0==ACTION||LA50_0==DOT||LA50_0==LPAREN||LA50_0==NOT||LA50_0==OR||LA50_0==POUND||(LA50_0 >= RPAREN && LA50_0 <= SEMPRED)||LA50_0==STRING_LITERAL||LA50_0==TOKEN_REF) ) {
                        alt50=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 50, 0, input);

                        throw nvae;

                    }
                    switch (alt50) {
                        case 1 :
                            // ANTLRParser.g:683:5: ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_element2969);
                            ebnfSuffix150=ebnfSuffix();

                            state._fsp--;

                            stream_ebnfSuffix.add(ebnfSuffix150.getTree());

                            // AST REWRITE
                            // elements: ebnfSuffix, labeledElement
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 683:16: -> ^( ebnfSuffix ^( BLOCK[$labeledElement.start,\"BLOCK\"] ^( ALT labeledElement ) ) )
                            {
                                // ANTLRParser.g:683:19: ^( ebnfSuffix ^( BLOCK[$labeledElement.start,\"BLOCK\"] ^( ALT labeledElement ) ) )
                                {
                                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                                root_1 = (GrammarAST)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);

                                // ANTLRParser.g:683:33: ^( BLOCK[$labeledElement.start,\"BLOCK\"] ^( ALT labeledElement ) )
                                {
                                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                                root_2 = (GrammarAST)adaptor.becomeRoot(
                                new BlockAST(BLOCK, (labeledElement149!=null?((Token)labeledElement149.start):null), "BLOCK")
                                , root_2);

                                // ANTLRParser.g:683:82: ^( ALT labeledElement )
                                {
                                GrammarAST root_3 = (GrammarAST)adaptor.nil();
                                root_3 = (GrammarAST)adaptor.becomeRoot(
                                new AltAST(ALT)
                                , root_3);

                                adaptor.addChild(root_3, stream_labeledElement.nextTree());

                                adaptor.addChild(root_2, root_3);
                                }

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 2 :
                            // ANTLRParser.g:684:8: 
                            {
                            // AST REWRITE
                            // elements: labeledElement
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 684:8: -> labeledElement
                            {
                                adaptor.addChild(root_0, stream_labeledElement.nextTree());

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // ANTLRParser.g:686:4: atom ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$atom.start,\"BLOCK\"] ^( ALT atom ) ) ) | -> atom )
                    {
                    pushFollow(FOLLOW_atom_in_element3015);
                    atom151=atom();

                    state._fsp--;

                    stream_atom.add(atom151.getTree());

                    // ANTLRParser.g:687:3: ( ebnfSuffix -> ^( ebnfSuffix ^( BLOCK[$atom.start,\"BLOCK\"] ^( ALT atom ) ) ) | -> atom )
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==PLUS||LA51_0==QUESTION||LA51_0==STAR) ) {
                        alt51=1;
                    }
                    else if ( (LA51_0==EOF||LA51_0==ACTION||LA51_0==DOT||LA51_0==LPAREN||LA51_0==NOT||LA51_0==OR||LA51_0==POUND||(LA51_0 >= RPAREN && LA51_0 <= SEMPRED)||LA51_0==STRING_LITERAL||LA51_0==TOKEN_REF) ) {
                        alt51=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 51, 0, input);

                        throw nvae;

                    }
                    switch (alt51) {
                        case 1 :
                            // ANTLRParser.g:687:5: ebnfSuffix
                            {
                            pushFollow(FOLLOW_ebnfSuffix_in_element3021);
                            ebnfSuffix152=ebnfSuffix();

                            state._fsp--;

                            stream_ebnfSuffix.add(ebnfSuffix152.getTree());

                            // AST REWRITE
                            // elements: atom, ebnfSuffix
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 687:16: -> ^( ebnfSuffix ^( BLOCK[$atom.start,\"BLOCK\"] ^( ALT atom ) ) )
                            {
                                // ANTLRParser.g:687:19: ^( ebnfSuffix ^( BLOCK[$atom.start,\"BLOCK\"] ^( ALT atom ) ) )
                                {
                                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                                root_1 = (GrammarAST)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);

                                // ANTLRParser.g:687:33: ^( BLOCK[$atom.start,\"BLOCK\"] ^( ALT atom ) )
                                {
                                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                                root_2 = (GrammarAST)adaptor.becomeRoot(
                                new BlockAST(BLOCK, (atom151!=null?((Token)atom151.start):null), "BLOCK")
                                , root_2);

                                // ANTLRParser.g:687:72: ^( ALT atom )
                                {
                                GrammarAST root_3 = (GrammarAST)adaptor.nil();
                                root_3 = (GrammarAST)adaptor.becomeRoot(
                                new AltAST(ALT)
                                , root_3);

                                adaptor.addChild(root_3, stream_atom.nextTree());

                                adaptor.addChild(root_2, root_3);
                                }

                                adaptor.addChild(root_1, root_2);
                                }

                                adaptor.addChild(root_0, root_1);
                                }

                            }


                            retval.tree = root_0;

                            }
                            break;
                        case 2 :
                            // ANTLRParser.g:688:8: 
                            {
                            // AST REWRITE
                            // elements: atom
                            // token labels: 
                            // rule labels: retval
                            // token list labels: 
                            // rule list labels: 
                            // wildcard labels: 
                            retval.tree = root_0;
                            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                            root_0 = (GrammarAST)adaptor.nil();
                            // 688:8: -> atom
                            {
                                adaptor.addChild(root_0, stream_atom.nextTree());

                            }


                            retval.tree = root_0;

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // ANTLRParser.g:690:4: ebnf
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_ebnf_in_element3067);
                    ebnf153=ebnf();

                    state._fsp--;

                    adaptor.addChild(root_0, ebnf153.getTree());

                    }
                    break;
                case 4 :
                    // ANTLRParser.g:691:4: actionElement
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_actionElement_in_element3072);
                    actionElement154=actionElement();

                    state._fsp--;

                    adaptor.addChild(root_0, actionElement154.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

             paraphrases.pop(); 
        }
        catch (RecognitionException re) {

                	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);
                	int ttype = input.get(input.range()).getType();
            	    // look for anything that really belongs at the start of the rule minus the initial ID
                	if ( ttype==COLON || ttype==RETURNS || ttype==CATCH || ttype==FINALLY || ttype==AT ) {
            			RecognitionException missingSemi =
            				new v4ParserException("unterminated rule (missing ';') detected at '"+
            									  input.LT(1).getText()+" "+input.LT(2).getText()+"'", input);
            			reportError(missingSemi);
            			if ( ttype==CATCH || ttype==FINALLY ) {
            				input.seek(input.range()); // ignore what's before rule trailer stuff
            			}
            			if ( ttype==RETURNS || ttype==AT ) { // scan back looking for ID of rule header
            				int p = input.index();
            				Token t = input.get(p);
            				while ( t.getType()!=RULE_REF && t.getType()!=TOKEN_REF ) {
            					p--;
            					t = input.get(p);
            				}
            				input.seek(p);
            			}
            			throw new ResyncToEndOfRuleBlock(); // make sure it goes back to rule block level to recover
            		}
                    reportError(re);
                    recover(input,re);
            	
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "element"


    public static class actionElement_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "actionElement"
    // ANTLRParser.g:720:1: actionElement : ( ACTION | ACTION elementOptions -> ^( ACTION elementOptions ) | SEMPRED | SEMPRED elementOptions -> ^( SEMPRED elementOptions ) );
    public final ANTLRParser.actionElement_return actionElement() throws RecognitionException {
        ANTLRParser.actionElement_return retval = new ANTLRParser.actionElement_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token ACTION155=null;
        Token ACTION156=null;
        Token SEMPRED158=null;
        Token SEMPRED159=null;
        ANTLRParser.elementOptions_return elementOptions157 =null;

        ANTLRParser.elementOptions_return elementOptions160 =null;


        GrammarAST ACTION155_tree=null;
        GrammarAST ACTION156_tree=null;
        GrammarAST SEMPRED158_tree=null;
        GrammarAST SEMPRED159_tree=null;
        RewriteRuleTokenStream stream_SEMPRED=new RewriteRuleTokenStream(adaptor,"token SEMPRED");
        RewriteRuleTokenStream stream_ACTION=new RewriteRuleTokenStream(adaptor,"token ACTION");
        RewriteRuleSubtreeStream stream_elementOptions=new RewriteRuleSubtreeStream(adaptor,"rule elementOptions");
        try {
            // ANTLRParser.g:727:2: ( ACTION | ACTION elementOptions -> ^( ACTION elementOptions ) | SEMPRED | SEMPRED elementOptions -> ^( SEMPRED elementOptions ) )
            int alt53=4;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==ACTION) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==EOF||LA53_1==ACTION||LA53_1==DOT||LA53_1==LEXER_CHAR_SET||LA53_1==LPAREN||LA53_1==NOT||LA53_1==OR||LA53_1==POUND||LA53_1==RARROW||(LA53_1 >= RPAREN && LA53_1 <= SEMPRED)||LA53_1==STRING_LITERAL||LA53_1==TOKEN_REF) ) {
                    alt53=1;
                }
                else if ( (LA53_1==LT) ) {
                    alt53=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA53_0==SEMPRED) ) {
                int LA53_2 = input.LA(2);

                if ( (LA53_2==EOF||LA53_2==ACTION||LA53_2==DOT||LA53_2==LEXER_CHAR_SET||LA53_2==LPAREN||LA53_2==NOT||LA53_2==OR||LA53_2==POUND||LA53_2==RARROW||(LA53_2 >= RPAREN && LA53_2 <= SEMPRED)||LA53_2==STRING_LITERAL||LA53_2==TOKEN_REF) ) {
                    alt53=3;
                }
                else if ( (LA53_2==LT) ) {
                    alt53=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;

            }
            switch (alt53) {
                case 1 :
                    // ANTLRParser.g:727:4: ACTION
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    ACTION155=(Token)match(input,ACTION,FOLLOW_ACTION_in_actionElement3098); 
                    ACTION155_tree = 
                    new ActionAST(ACTION155) 
                    ;
                    adaptor.addChild(root_0, ACTION155_tree);


                    }
                    break;
                case 2 :
                    // ANTLRParser.g:728:6: ACTION elementOptions
                    {
                    ACTION156=(Token)match(input,ACTION,FOLLOW_ACTION_in_actionElement3108);  
                    stream_ACTION.add(ACTION156);


                    pushFollow(FOLLOW_elementOptions_in_actionElement3110);
                    elementOptions157=elementOptions();

                    state._fsp--;

                    stream_elementOptions.add(elementOptions157.getTree());

                    // AST REWRITE
                    // elements: ACTION, elementOptions
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 728:28: -> ^( ACTION elementOptions )
                    {
                        // ANTLRParser.g:728:31: ^( ACTION elementOptions )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new ActionAST(stream_ACTION.nextToken())
                        , root_1);

                        adaptor.addChild(root_1, stream_elementOptions.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // ANTLRParser.g:729:6: SEMPRED
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    SEMPRED158=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_actionElement3128); 
                    SEMPRED158_tree = 
                    new PredAST(SEMPRED158) 
                    ;
                    adaptor.addChild(root_0, SEMPRED158_tree);


                    }
                    break;
                case 4 :
                    // ANTLRParser.g:730:6: SEMPRED elementOptions
                    {
                    SEMPRED159=(Token)match(input,SEMPRED,FOLLOW_SEMPRED_in_actionElement3138);  
                    stream_SEMPRED.add(SEMPRED159);


                    pushFollow(FOLLOW_elementOptions_in_actionElement3140);
                    elementOptions160=elementOptions();

                    state._fsp--;

                    stream_elementOptions.add(elementOptions160.getTree());

                    // AST REWRITE
                    // elements: elementOptions, SEMPRED
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 730:29: -> ^( SEMPRED elementOptions )
                    {
                        // ANTLRParser.g:730:32: ^( SEMPRED elementOptions )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new PredAST(stream_SEMPRED.nextToken())
                        , root_1);

                        adaptor.addChild(root_1, stream_elementOptions.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            	GrammarAST options = (GrammarAST)((GrammarAST)retval.tree).getFirstChildWithType(ANTLRParser.ELEMENT_OPTIONS);
            	if ( options!=null ) {
            		Grammar.setNodeOptions(((GrammarAST)retval.tree), options);
            	}

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "actionElement"


    public static class labeledElement_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "labeledElement"
    // ANTLRParser.g:733:1: labeledElement : id (ass= ASSIGN |ass= PLUS_ASSIGN ) ( atom -> ^( $ass id atom ) | block -> ^( $ass id block ) ) ;
    public final ANTLRParser.labeledElement_return labeledElement() throws RecognitionException {
        ANTLRParser.labeledElement_return retval = new ANTLRParser.labeledElement_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token ass=null;
        ANTLRParser.id_return id161 =null;

        ANTLRParser.atom_return atom162 =null;

        ANTLRParser.block_return block163 =null;


        GrammarAST ass_tree=null;
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleTokenStream stream_PLUS_ASSIGN=new RewriteRuleTokenStream(adaptor,"token PLUS_ASSIGN");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
        RewriteRuleSubtreeStream stream_atom=new RewriteRuleSubtreeStream(adaptor,"rule atom");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // ANTLRParser.g:734:2: ( id (ass= ASSIGN |ass= PLUS_ASSIGN ) ( atom -> ^( $ass id atom ) | block -> ^( $ass id block ) ) )
            // ANTLRParser.g:734:4: id (ass= ASSIGN |ass= PLUS_ASSIGN ) ( atom -> ^( $ass id atom ) | block -> ^( $ass id block ) )
            {
            pushFollow(FOLLOW_id_in_labeledElement3162);
            id161=id();

            state._fsp--;

            stream_id.add(id161.getTree());

            // ANTLRParser.g:734:7: (ass= ASSIGN |ass= PLUS_ASSIGN )
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==ASSIGN) ) {
                alt54=1;
            }
            else if ( (LA54_0==PLUS_ASSIGN) ) {
                alt54=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }
            switch (alt54) {
                case 1 :
                    // ANTLRParser.g:734:8: ass= ASSIGN
                    {
                    ass=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_labeledElement3167);  
                    stream_ASSIGN.add(ass);


                    }
                    break;
                case 2 :
                    // ANTLRParser.g:734:19: ass= PLUS_ASSIGN
                    {
                    ass=(Token)match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_labeledElement3171);  
                    stream_PLUS_ASSIGN.add(ass);


                    }
                    break;

            }


            // ANTLRParser.g:735:3: ( atom -> ^( $ass id atom ) | block -> ^( $ass id block ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==DOT||LA55_0==NOT||LA55_0==RULE_REF||LA55_0==STRING_LITERAL||LA55_0==TOKEN_REF) ) {
                alt55=1;
            }
            else if ( (LA55_0==LPAREN) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;

            }
            switch (alt55) {
                case 1 :
                    // ANTLRParser.g:735:5: atom
                    {
                    pushFollow(FOLLOW_atom_in_labeledElement3178);
                    atom162=atom();

                    state._fsp--;

                    stream_atom.add(atom162.getTree());

                    // AST REWRITE
                    // elements: id, atom, ass
                    // token labels: ass
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_ass=new RewriteRuleTokenStream(adaptor,"token ass",ass);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 735:15: -> ^( $ass id atom )
                    {
                        // ANTLRParser.g:735:18: ^( $ass id atom )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(stream_ass.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_1, stream_atom.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:736:5: block
                    {
                    pushFollow(FOLLOW_block_in_labeledElement3200);
                    block163=block();

                    state._fsp--;

                    stream_block.add(block163.getTree());

                    // AST REWRITE
                    // elements: ass, id, block
                    // token labels: ass
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_ass=new RewriteRuleTokenStream(adaptor,"token ass",ass);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 736:16: -> ^( $ass id block )
                    {
                        // ANTLRParser.g:736:19: ^( $ass id block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(stream_ass.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_id.nextTree());

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "labeledElement"


    public static class ebnf_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ebnf"
    // ANTLRParser.g:742:1: ebnf : block ( blockSuffix -> ^( blockSuffix block ) | -> block ) ;
    public final ANTLRParser.ebnf_return ebnf() throws RecognitionException {
        ANTLRParser.ebnf_return retval = new ANTLRParser.ebnf_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.block_return block164 =null;

        ANTLRParser.blockSuffix_return blockSuffix165 =null;


        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        RewriteRuleSubtreeStream stream_blockSuffix=new RewriteRuleSubtreeStream(adaptor,"rule blockSuffix");
        try {
            // ANTLRParser.g:743:5: ( block ( blockSuffix -> ^( blockSuffix block ) | -> block ) )
            // ANTLRParser.g:743:7: block ( blockSuffix -> ^( blockSuffix block ) | -> block )
            {
            pushFollow(FOLLOW_block_in_ebnf3236);
            block164=block();

            state._fsp--;

            stream_block.add(block164.getTree());

            // ANTLRParser.g:746:7: ( blockSuffix -> ^( blockSuffix block ) | -> block )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==PLUS||LA56_0==QUESTION||LA56_0==STAR) ) {
                alt56=1;
            }
            else if ( (LA56_0==EOF||LA56_0==ACTION||LA56_0==DOT||LA56_0==LPAREN||LA56_0==NOT||LA56_0==OR||LA56_0==POUND||(LA56_0 >= RPAREN && LA56_0 <= SEMPRED)||LA56_0==STRING_LITERAL||LA56_0==TOKEN_REF) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;

            }
            switch (alt56) {
                case 1 :
                    // ANTLRParser.g:746:9: blockSuffix
                    {
                    pushFollow(FOLLOW_blockSuffix_in_ebnf3260);
                    blockSuffix165=blockSuffix();

                    state._fsp--;

                    stream_blockSuffix.add(blockSuffix165.getTree());

                    // AST REWRITE
                    // elements: block, blockSuffix
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 746:21: -> ^( blockSuffix block )
                    {
                        // ANTLRParser.g:746:24: ^( blockSuffix block )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(stream_blockSuffix.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_block.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:747:12: 
                    {
                    // AST REWRITE
                    // elements: block
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 747:12: -> block
                    {
                        adaptor.addChild(root_0, stream_block.nextTree());

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ebnf"


    public static class blockSuffix_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "blockSuffix"
    // ANTLRParser.g:753:1: blockSuffix : ebnfSuffix ;
    public final ANTLRParser.blockSuffix_return blockSuffix() throws RecognitionException {
        ANTLRParser.blockSuffix_return retval = new ANTLRParser.blockSuffix_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.ebnfSuffix_return ebnfSuffix166 =null;



        try {
            // ANTLRParser.g:754:5: ( ebnfSuffix )
            // ANTLRParser.g:754:7: ebnfSuffix
            {
            root_0 = (GrammarAST)adaptor.nil();


            pushFollow(FOLLOW_ebnfSuffix_in_blockSuffix3310);
            ebnfSuffix166=ebnfSuffix();

            state._fsp--;

            adaptor.addChild(root_0, ebnfSuffix166.getTree());

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "blockSuffix"


    public static class ebnfSuffix_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ebnfSuffix"
    // ANTLRParser.g:757:1: ebnfSuffix : ( QUESTION -> OPTIONAL[$start] | STAR -> CLOSURE[$start] | PLUS -> POSITIVE_CLOSURE[$start] );
    public final ANTLRParser.ebnfSuffix_return ebnfSuffix() throws RecognitionException {
        ANTLRParser.ebnfSuffix_return retval = new ANTLRParser.ebnfSuffix_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token QUESTION167=null;
        Token STAR168=null;
        Token PLUS169=null;

        GrammarAST QUESTION167_tree=null;
        GrammarAST STAR168_tree=null;
        GrammarAST PLUS169_tree=null;
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_QUESTION=new RewriteRuleTokenStream(adaptor,"token QUESTION");

        try {
            // ANTLRParser.g:758:2: ( QUESTION -> OPTIONAL[$start] | STAR -> CLOSURE[$start] | PLUS -> POSITIVE_CLOSURE[$start] )
            int alt57=3;
            switch ( input.LA(1) ) {
            case QUESTION:
                {
                alt57=1;
                }
                break;
            case STAR:
                {
                alt57=2;
                }
                break;
            case PLUS:
                {
                alt57=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;

            }

            switch (alt57) {
                case 1 :
                    // ANTLRParser.g:758:4: QUESTION
                    {
                    QUESTION167=(Token)match(input,QUESTION,FOLLOW_QUESTION_in_ebnfSuffix3325);  
                    stream_QUESTION.add(QUESTION167);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 758:13: -> OPTIONAL[$start]
                    {
                        adaptor.addChild(root_0, 
                        new OptionalBlockAST(OPTIONAL, ((Token)retval.start))
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:759:6: STAR
                    {
                    STAR168=(Token)match(input,STAR,FOLLOW_STAR_in_ebnfSuffix3340);  
                    stream_STAR.add(STAR168);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 759:13: -> CLOSURE[$start]
                    {
                        adaptor.addChild(root_0, 
                        new StarBlockAST(CLOSURE, ((Token)retval.start))
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // ANTLRParser.g:760:7: PLUS
                    {
                    PLUS169=(Token)match(input,PLUS,FOLLOW_PLUS_in_ebnfSuffix3358);  
                    stream_PLUS.add(PLUS169);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 760:14: -> POSITIVE_CLOSURE[$start]
                    {
                        adaptor.addChild(root_0, 
                        new PlusBlockAST(POSITIVE_CLOSURE, ((Token)retval.start))
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ebnfSuffix"


    public static class lexerAtom_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "lexerAtom"
    // ANTLRParser.g:763:1: lexerAtom : ( range | terminal | RULE_REF | notSet | wildcard | LEXER_CHAR_SET );
    public final ANTLRParser.lexerAtom_return lexerAtom() throws RecognitionException {
        ANTLRParser.lexerAtom_return retval = new ANTLRParser.lexerAtom_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token RULE_REF172=null;
        Token LEXER_CHAR_SET175=null;
        ANTLRParser.range_return range170 =null;

        ANTLRParser.terminal_return terminal171 =null;

        ANTLRParser.notSet_return notSet173 =null;

        ANTLRParser.wildcard_return wildcard174 =null;


        GrammarAST RULE_REF172_tree=null;
        GrammarAST LEXER_CHAR_SET175_tree=null;

        try {
            // ANTLRParser.g:764:2: ( range | terminal | RULE_REF | notSet | wildcard | LEXER_CHAR_SET )
            int alt58=6;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==RANGE) ) {
                    alt58=1;
                }
                else if ( (LA58_1==ACTION||LA58_1==DOT||LA58_1==LEXER_CHAR_SET||(LA58_1 >= LPAREN && LA58_1 <= LT)||LA58_1==NOT||LA58_1==OR||LA58_1==PLUS||LA58_1==QUESTION||LA58_1==RARROW||(LA58_1 >= RPAREN && LA58_1 <= SEMPRED)||(LA58_1 >= STAR && LA58_1 <= STRING_LITERAL)||LA58_1==TOKEN_REF) ) {
                    alt58=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 1, input);

                    throw nvae;

                }
                }
                break;
            case TOKEN_REF:
                {
                alt58=2;
                }
                break;
            case RULE_REF:
                {
                alt58=3;
                }
                break;
            case NOT:
                {
                alt58=4;
                }
                break;
            case DOT:
                {
                alt58=5;
                }
                break;
            case LEXER_CHAR_SET:
                {
                alt58=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;

            }

            switch (alt58) {
                case 1 :
                    // ANTLRParser.g:764:4: range
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_range_in_lexerAtom3379);
                    range170=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range170.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:765:4: terminal
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_terminal_in_lexerAtom3384);
                    terminal171=terminal();

                    state._fsp--;

                    adaptor.addChild(root_0, terminal171.getTree());

                    }
                    break;
                case 3 :
                    // ANTLRParser.g:766:9: RULE_REF
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    RULE_REF172=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_lexerAtom3394); 
                    RULE_REF172_tree = 
                    new RuleRefAST(RULE_REF172) 
                    ;
                    adaptor.addChild(root_0, RULE_REF172_tree);


                    }
                    break;
                case 4 :
                    // ANTLRParser.g:767:7: notSet
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_notSet_in_lexerAtom3405);
                    notSet173=notSet();

                    state._fsp--;

                    adaptor.addChild(root_0, notSet173.getTree());

                    }
                    break;
                case 5 :
                    // ANTLRParser.g:768:7: wildcard
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_wildcard_in_lexerAtom3413);
                    wildcard174=wildcard();

                    state._fsp--;

                    adaptor.addChild(root_0, wildcard174.getTree());

                    }
                    break;
                case 6 :
                    // ANTLRParser.g:769:7: LEXER_CHAR_SET
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    LEXER_CHAR_SET175=(Token)match(input,LEXER_CHAR_SET,FOLLOW_LEXER_CHAR_SET_in_lexerAtom3421); 
                    LEXER_CHAR_SET175_tree = 
                    (GrammarAST)adaptor.create(LEXER_CHAR_SET175)
                    ;
                    adaptor.addChild(root_0, LEXER_CHAR_SET175_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerAtom"


    public static class atom_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "atom"
    // ANTLRParser.g:772:1: atom : ( range | terminal | ruleref | notSet | wildcard );
    public final ANTLRParser.atom_return atom() throws RecognitionException {
        ANTLRParser.atom_return retval = new ANTLRParser.atom_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        ANTLRParser.range_return range176 =null;

        ANTLRParser.terminal_return terminal177 =null;

        ANTLRParser.ruleref_return ruleref178 =null;

        ANTLRParser.notSet_return notSet179 =null;

        ANTLRParser.wildcard_return wildcard180 =null;



        try {
            // ANTLRParser.g:773:2: ( range | terminal | ruleref | notSet | wildcard )
            int alt59=5;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==RANGE) ) {
                    alt59=1;
                }
                else if ( (LA59_1==EOF||LA59_1==ACTION||LA59_1==DOT||(LA59_1 >= LPAREN && LA59_1 <= LT)||LA59_1==NOT||LA59_1==OR||LA59_1==PLUS||LA59_1==POUND||LA59_1==QUESTION||(LA59_1 >= RPAREN && LA59_1 <= SEMPRED)||(LA59_1 >= STAR && LA59_1 <= STRING_LITERAL)||LA59_1==TOKEN_REF) ) {
                    alt59=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 59, 1, input);

                    throw nvae;

                }
                }
                break;
            case TOKEN_REF:
                {
                alt59=2;
                }
                break;
            case RULE_REF:
                {
                alt59=3;
                }
                break;
            case NOT:
                {
                alt59=4;
                }
                break;
            case DOT:
                {
                alt59=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;

            }

            switch (alt59) {
                case 1 :
                    // ANTLRParser.g:787:9: range
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_range_in_atom3466);
                    range176=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range176.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:788:4: terminal
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_terminal_in_atom3473);
                    terminal177=terminal();

                    state._fsp--;

                    adaptor.addChild(root_0, terminal177.getTree());

                    }
                    break;
                case 3 :
                    // ANTLRParser.g:789:9: ruleref
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_ruleref_in_atom3483);
                    ruleref178=ruleref();

                    state._fsp--;

                    adaptor.addChild(root_0, ruleref178.getTree());

                    }
                    break;
                case 4 :
                    // ANTLRParser.g:790:7: notSet
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_notSet_in_atom3491);
                    notSet179=notSet();

                    state._fsp--;

                    adaptor.addChild(root_0, notSet179.getTree());

                    }
                    break;
                case 5 :
                    // ANTLRParser.g:791:7: wildcard
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_wildcard_in_atom3499);
                    wildcard180=wildcard();

                    state._fsp--;

                    adaptor.addChild(root_0, wildcard180.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
             throw re; 
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "atom"


    public static class wildcard_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "wildcard"
    // ANTLRParser.g:795:1: wildcard : DOT ( elementOptions )? -> ^( WILDCARD[$DOT] ( elementOptions )? ) ;
    public final ANTLRParser.wildcard_return wildcard() throws RecognitionException {
        ANTLRParser.wildcard_return retval = new ANTLRParser.wildcard_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token DOT181=null;
        ANTLRParser.elementOptions_return elementOptions182 =null;


        GrammarAST DOT181_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_elementOptions=new RewriteRuleSubtreeStream(adaptor,"rule elementOptions");
        try {
            // ANTLRParser.g:802:2: ( DOT ( elementOptions )? -> ^( WILDCARD[$DOT] ( elementOptions )? ) )
            // ANTLRParser.g:807:6: DOT ( elementOptions )?
            {
            DOT181=(Token)match(input,DOT,FOLLOW_DOT_in_wildcard3547);  
            stream_DOT.add(DOT181);


            // ANTLRParser.g:807:10: ( elementOptions )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==LT) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ANTLRParser.g:807:10: elementOptions
                    {
                    pushFollow(FOLLOW_elementOptions_in_wildcard3549);
                    elementOptions182=elementOptions();

                    state._fsp--;

                    stream_elementOptions.add(elementOptions182.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: elementOptions
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 808:6: -> ^( WILDCARD[$DOT] ( elementOptions )? )
            {
                // ANTLRParser.g:808:9: ^( WILDCARD[$DOT] ( elementOptions )? )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new TerminalAST(WILDCARD, DOT181)
                , root_1);

                // ANTLRParser.g:808:39: ( elementOptions )?
                if ( stream_elementOptions.hasNext() ) {
                    adaptor.addChild(root_1, stream_elementOptions.nextTree());

                }
                stream_elementOptions.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            	GrammarAST options = (GrammarAST)((GrammarAST)retval.tree).getFirstChildWithType(ANTLRParser.ELEMENT_OPTIONS);
            	if ( options!=null ) {
            		Grammar.setNodeOptions(((GrammarAST)retval.tree), options);
            	}

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "wildcard"


    public static class notSet_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "notSet"
    // ANTLRParser.g:816:1: notSet : ( NOT setElement -> ^( NOT[$NOT] ^( SET[$setElement.start,\"SET\"] setElement ) ) | NOT blockSet -> ^( NOT[$NOT] blockSet ) );
    public final ANTLRParser.notSet_return notSet() throws RecognitionException {
        ANTLRParser.notSet_return retval = new ANTLRParser.notSet_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token NOT183=null;
        Token NOT185=null;
        ANTLRParser.setElement_return setElement184 =null;

        ANTLRParser.blockSet_return blockSet186 =null;


        GrammarAST NOT183_tree=null;
        GrammarAST NOT185_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleSubtreeStream stream_setElement=new RewriteRuleSubtreeStream(adaptor,"rule setElement");
        RewriteRuleSubtreeStream stream_blockSet=new RewriteRuleSubtreeStream(adaptor,"rule blockSet");
        try {
            // ANTLRParser.g:817:5: ( NOT setElement -> ^( NOT[$NOT] ^( SET[$setElement.start,\"SET\"] setElement ) ) | NOT blockSet -> ^( NOT[$NOT] blockSet ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==NOT) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==LEXER_CHAR_SET||LA61_1==STRING_LITERAL||LA61_1==TOKEN_REF) ) {
                    alt61=1;
                }
                else if ( (LA61_1==LPAREN) ) {
                    alt61=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 61, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;

            }
            switch (alt61) {
                case 1 :
                    // ANTLRParser.g:817:7: NOT setElement
                    {
                    NOT183=(Token)match(input,NOT,FOLLOW_NOT_in_notSet3587);  
                    stream_NOT.add(NOT183);


                    pushFollow(FOLLOW_setElement_in_notSet3589);
                    setElement184=setElement();

                    state._fsp--;

                    stream_setElement.add(setElement184.getTree());

                    // AST REWRITE
                    // elements: setElement, NOT
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 817:22: -> ^( NOT[$NOT] ^( SET[$setElement.start,\"SET\"] setElement ) )
                    {
                        // ANTLRParser.g:817:25: ^( NOT[$NOT] ^( SET[$setElement.start,\"SET\"] setElement ) )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new NotAST(NOT, NOT183)
                        , root_1);

                        // ANTLRParser.g:817:45: ^( SET[$setElement.start,\"SET\"] setElement )
                        {
                        GrammarAST root_2 = (GrammarAST)adaptor.nil();
                        root_2 = (GrammarAST)adaptor.becomeRoot(
                        new SetAST(SET, (setElement184!=null?((Token)setElement184.start):null), "SET")
                        , root_2);

                        adaptor.addChild(root_2, stream_setElement.nextTree());

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:818:7: NOT blockSet
                    {
                    NOT185=(Token)match(input,NOT,FOLLOW_NOT_in_notSet3617);  
                    stream_NOT.add(NOT185);


                    pushFollow(FOLLOW_blockSet_in_notSet3619);
                    blockSet186=blockSet();

                    state._fsp--;

                    stream_blockSet.add(blockSet186.getTree());

                    // AST REWRITE
                    // elements: NOT, blockSet
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 818:21: -> ^( NOT[$NOT] blockSet )
                    {
                        // ANTLRParser.g:818:24: ^( NOT[$NOT] blockSet )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new NotAST(NOT, NOT185)
                        , root_1);

                        adaptor.addChild(root_1, stream_blockSet.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "notSet"


    public static class blockSet_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "blockSet"
    // ANTLRParser.g:821:1: blockSet : LPAREN setElement ( OR setElement )* RPAREN -> ^( SET[$LPAREN,\"SET\"] ( setElement )+ ) ;
    public final ANTLRParser.blockSet_return blockSet() throws RecognitionException {
        ANTLRParser.blockSet_return retval = new ANTLRParser.blockSet_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token LPAREN187=null;
        Token OR189=null;
        Token RPAREN191=null;
        ANTLRParser.setElement_return setElement188 =null;

        ANTLRParser.setElement_return setElement190 =null;


        GrammarAST LPAREN187_tree=null;
        GrammarAST OR189_tree=null;
        GrammarAST RPAREN191_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_OR=new RewriteRuleTokenStream(adaptor,"token OR");
        RewriteRuleSubtreeStream stream_setElement=new RewriteRuleSubtreeStream(adaptor,"rule setElement");

        	Token t;
        	boolean ebnf = false;

        try {
            // ANTLRParser.g:826:5: ( LPAREN setElement ( OR setElement )* RPAREN -> ^( SET[$LPAREN,\"SET\"] ( setElement )+ ) )
            // ANTLRParser.g:826:7: LPAREN setElement ( OR setElement )* RPAREN
            {
            LPAREN187=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_blockSet3654);  
            stream_LPAREN.add(LPAREN187);


            pushFollow(FOLLOW_setElement_in_blockSet3656);
            setElement188=setElement();

            state._fsp--;

            stream_setElement.add(setElement188.getTree());

            // ANTLRParser.g:826:25: ( OR setElement )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==OR) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // ANTLRParser.g:826:26: OR setElement
            	    {
            	    OR189=(Token)match(input,OR,FOLLOW_OR_in_blockSet3659);  
            	    stream_OR.add(OR189);


            	    pushFollow(FOLLOW_setElement_in_blockSet3661);
            	    setElement190=setElement();

            	    state._fsp--;

            	    stream_setElement.add(setElement190.getTree());

            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);


            RPAREN191=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_blockSet3665);  
            stream_RPAREN.add(RPAREN191);


            // AST REWRITE
            // elements: setElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 827:3: -> ^( SET[$LPAREN,\"SET\"] ( setElement )+ )
            {
                // ANTLRParser.g:827:6: ^( SET[$LPAREN,\"SET\"] ( setElement )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new SetAST(SET, LPAREN187, "SET")
                , root_1);

                if ( !(stream_setElement.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_setElement.hasNext() ) {
                    adaptor.addChild(root_1, stream_setElement.nextTree());

                }
                stream_setElement.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "blockSet"


    public static class setElement_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "setElement"
    // ANTLRParser.g:830:1: setElement : ( TOKEN_REF | STRING_LITERAL | range | LEXER_CHAR_SET );
    public final ANTLRParser.setElement_return setElement() throws RecognitionException {
        ANTLRParser.setElement_return retval = new ANTLRParser.setElement_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token TOKEN_REF192=null;
        Token STRING_LITERAL193=null;
        Token LEXER_CHAR_SET195=null;
        ANTLRParser.range_return range194 =null;


        GrammarAST TOKEN_REF192_tree=null;
        GrammarAST STRING_LITERAL193_tree=null;
        GrammarAST LEXER_CHAR_SET195_tree=null;

        try {
            // ANTLRParser.g:831:2: ( TOKEN_REF | STRING_LITERAL | range | LEXER_CHAR_SET )
            int alt63=4;
            switch ( input.LA(1) ) {
            case TOKEN_REF:
                {
                alt63=1;
                }
                break;
            case STRING_LITERAL:
                {
                int LA63_2 = input.LA(2);

                if ( (LA63_2==RANGE) ) {
                    alt63=3;
                }
                else if ( (LA63_2==EOF||LA63_2==ACTION||LA63_2==DOT||LA63_2==LEXER_CHAR_SET||LA63_2==LPAREN||LA63_2==NOT||LA63_2==OR||LA63_2==PLUS||LA63_2==POUND||LA63_2==QUESTION||LA63_2==RARROW||(LA63_2 >= RPAREN && LA63_2 <= SEMPRED)||(LA63_2 >= STAR && LA63_2 <= STRING_LITERAL)||LA63_2==TOKEN_REF) ) {
                    alt63=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 63, 2, input);

                    throw nvae;

                }
                }
                break;
            case LEXER_CHAR_SET:
                {
                alt63=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;

            }

            switch (alt63) {
                case 1 :
                    // ANTLRParser.g:831:4: TOKEN_REF
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    TOKEN_REF192=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_setElement3695); 
                    TOKEN_REF192_tree = 
                    new TerminalAST(TOKEN_REF192) 
                    ;
                    adaptor.addChild(root_0, TOKEN_REF192_tree);


                    }
                    break;
                case 2 :
                    // ANTLRParser.g:832:4: STRING_LITERAL
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    STRING_LITERAL193=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement3703); 
                    STRING_LITERAL193_tree = 
                    new TerminalAST(STRING_LITERAL193) 
                    ;
                    adaptor.addChild(root_0, STRING_LITERAL193_tree);


                    }
                    break;
                case 3 :
                    // ANTLRParser.g:833:4: range
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_range_in_setElement3711);
                    range194=range();

                    state._fsp--;

                    adaptor.addChild(root_0, range194.getTree());

                    }
                    break;
                case 4 :
                    // ANTLRParser.g:834:9: LEXER_CHAR_SET
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    LEXER_CHAR_SET195=(Token)match(input,LEXER_CHAR_SET,FOLLOW_LEXER_CHAR_SET_in_setElement3721); 
                    LEXER_CHAR_SET195_tree = 
                    (GrammarAST)adaptor.create(LEXER_CHAR_SET195)
                    ;
                    adaptor.addChild(root_0, LEXER_CHAR_SET195_tree);


                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "setElement"


    public static class block_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // ANTLRParser.g:844:1: block : LPAREN ( ( optionsSpec )? (ra+= ruleAction )* COLON )? altList RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] ( optionsSpec )? ( $ra)* altList ) ;
    public final ANTLRParser.block_return block() throws RecognitionException {
        ANTLRParser.block_return retval = new ANTLRParser.block_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token LPAREN196=null;
        Token COLON198=null;
        Token RPAREN200=null;
        List list_ra=null;
        ANTLRParser.optionsSpec_return optionsSpec197 =null;

        ANTLRParser.altList_return altList199 =null;

        RuleReturnScope ra = null;
        GrammarAST LPAREN196_tree=null;
        GrammarAST COLON198_tree=null;
        GrammarAST RPAREN200_tree=null;
        RewriteRuleTokenStream stream_COLON=new RewriteRuleTokenStream(adaptor,"token COLON");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_optionsSpec=new RewriteRuleSubtreeStream(adaptor,"rule optionsSpec");
        RewriteRuleSubtreeStream stream_altList=new RewriteRuleSubtreeStream(adaptor,"rule altList");
        RewriteRuleSubtreeStream stream_ruleAction=new RewriteRuleSubtreeStream(adaptor,"rule ruleAction");
        try {
            // ANTLRParser.g:851:3: ( LPAREN ( ( optionsSpec )? (ra+= ruleAction )* COLON )? altList RPAREN -> ^( BLOCK[$LPAREN,\"BLOCK\"] ( optionsSpec )? ( $ra)* altList ) )
            // ANTLRParser.g:851:5: LPAREN ( ( optionsSpec )? (ra+= ruleAction )* COLON )? altList RPAREN
            {
            LPAREN196=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_block3745);  
            stream_LPAREN.add(LPAREN196);


            // ANTLRParser.g:852:9: ( ( optionsSpec )? (ra+= ruleAction )* COLON )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==AT||LA66_0==COLON||LA66_0==OPTIONS) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ANTLRParser.g:852:11: ( optionsSpec )? (ra+= ruleAction )* COLON
                    {
                    // ANTLRParser.g:852:11: ( optionsSpec )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==OPTIONS) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // ANTLRParser.g:852:11: optionsSpec
                            {
                            pushFollow(FOLLOW_optionsSpec_in_block3757);
                            optionsSpec197=optionsSpec();

                            state._fsp--;

                            stream_optionsSpec.add(optionsSpec197.getTree());

                            }
                            break;

                    }


                    // ANTLRParser.g:852:26: (ra+= ruleAction )*
                    loop65:
                    do {
                        int alt65=2;
                        int LA65_0 = input.LA(1);

                        if ( (LA65_0==AT) ) {
                            alt65=1;
                        }


                        switch (alt65) {
                    	case 1 :
                    	    // ANTLRParser.g:852:26: ra+= ruleAction
                    	    {
                    	    pushFollow(FOLLOW_ruleAction_in_block3762);
                    	    ra=ruleAction();

                    	    state._fsp--;

                    	    stream_ruleAction.add(ra.getTree());
                    	    if (list_ra==null) list_ra=new ArrayList();
                    	    list_ra.add(ra.getTree());


                    	    }
                    	    break;

                    	default :
                    	    break loop65;
                        }
                    } while (true);


                    COLON198=(Token)match(input,COLON,FOLLOW_COLON_in_block3765);  
                    stream_COLON.add(COLON198);


                    }
                    break;

            }


            pushFollow(FOLLOW_altList_in_block3778);
            altList199=altList();

            state._fsp--;

            stream_altList.add(altList199.getTree());

            RPAREN200=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_block3782);  
            stream_RPAREN.add(RPAREN200);


            // AST REWRITE
            // elements: altList, ra, optionsSpec
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: ra
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_ra=new RewriteRuleSubtreeStream(adaptor,"token ra",list_ra);
            root_0 = (GrammarAST)adaptor.nil();
            // 855:7: -> ^( BLOCK[$LPAREN,\"BLOCK\"] ( optionsSpec )? ( $ra)* altList )
            {
                // ANTLRParser.g:855:10: ^( BLOCK[$LPAREN,\"BLOCK\"] ( optionsSpec )? ( $ra)* altList )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new BlockAST(BLOCK, LPAREN196, "BLOCK")
                , root_1);

                // ANTLRParser.g:855:45: ( optionsSpec )?
                if ( stream_optionsSpec.hasNext() ) {
                    adaptor.addChild(root_1, stream_optionsSpec.nextTree());

                }
                stream_optionsSpec.reset();

                // ANTLRParser.g:855:59: ( $ra)*
                while ( stream_ra.hasNext() ) {
                    adaptor.addChild(root_1, stream_ra.nextTree());

                }
                stream_ra.reset();

                adaptor.addChild(root_1, stream_altList.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            GrammarAST options = (GrammarAST)((GrammarAST)retval.tree).getFirstChildWithType(ANTLRParser.OPTIONS);
            if ( options!=null ) {
            	Grammar.setNodeOptions(((GrammarAST)retval.tree), options);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block"


    public static class ruleref_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleref"
    // ANTLRParser.g:864:1: ruleref : RULE_REF ( ARG_ACTION )? -> ^( RULE_REF ( ARG_ACTION )? ) ;
    public final ANTLRParser.ruleref_return ruleref() throws RecognitionException {
        ANTLRParser.ruleref_return retval = new ANTLRParser.ruleref_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token RULE_REF201=null;
        Token ARG_ACTION202=null;

        GrammarAST RULE_REF201_tree=null;
        GrammarAST ARG_ACTION202_tree=null;
        RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");
        RewriteRuleTokenStream stream_ARG_ACTION=new RewriteRuleTokenStream(adaptor,"token ARG_ACTION");

        try {
            // ANTLRParser.g:865:5: ( RULE_REF ( ARG_ACTION )? -> ^( RULE_REF ( ARG_ACTION )? ) )
            // ANTLRParser.g:865:7: RULE_REF ( ARG_ACTION )?
            {
            RULE_REF201=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_ruleref3831);  
            stream_RULE_REF.add(RULE_REF201);


            // ANTLRParser.g:865:16: ( ARG_ACTION )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==ARG_ACTION) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ANTLRParser.g:865:16: ARG_ACTION
                    {
                    ARG_ACTION202=(Token)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleref3833);  
                    stream_ARG_ACTION.add(ARG_ACTION202);


                    }
                    break;

            }


            // AST REWRITE
            // elements: ARG_ACTION, RULE_REF
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 865:28: -> ^( RULE_REF ( ARG_ACTION )? )
            {
                // ANTLRParser.g:865:31: ^( RULE_REF ( ARG_ACTION )? )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                new RuleRefAST(stream_RULE_REF.nextToken())
                , root_1);

                // ANTLRParser.g:865:54: ( ARG_ACTION )?
                if ( stream_ARG_ACTION.hasNext() ) {
                    adaptor.addChild(root_1, 
                    new ActionAST(stream_ARG_ACTION.nextToken())
                    );

                }
                stream_ARG_ACTION.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
             throw re; 
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleref"


    public static class range_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "range"
    // ANTLRParser.g:878:1: range : STRING_LITERAL RANGE ^ STRING_LITERAL ;
    public final ANTLRParser.range_return range() throws RecognitionException {
        ANTLRParser.range_return retval = new ANTLRParser.range_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token STRING_LITERAL203=null;
        Token RANGE204=null;
        Token STRING_LITERAL205=null;

        GrammarAST STRING_LITERAL203_tree=null;
        GrammarAST RANGE204_tree=null;
        GrammarAST STRING_LITERAL205_tree=null;

        try {
            // ANTLRParser.g:879:5: ( STRING_LITERAL RANGE ^ STRING_LITERAL )
            // ANTLRParser.g:879:7: STRING_LITERAL RANGE ^ STRING_LITERAL
            {
            root_0 = (GrammarAST)adaptor.nil();


            STRING_LITERAL203=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range3886); 
            STRING_LITERAL203_tree = 
            new TerminalAST(STRING_LITERAL203) 
            ;
            adaptor.addChild(root_0, STRING_LITERAL203_tree);


            RANGE204=(Token)match(input,RANGE,FOLLOW_RANGE_in_range3891); 
            RANGE204_tree = 
            new RangeAST(RANGE204) 
            ;
            root_0 = (GrammarAST)adaptor.becomeRoot(RANGE204_tree, root_0);


            STRING_LITERAL205=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range3897); 
            STRING_LITERAL205_tree = 
            new TerminalAST(STRING_LITERAL205) 
            ;
            adaptor.addChild(root_0, STRING_LITERAL205_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "range"


    public static class terminal_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "terminal"
    // ANTLRParser.g:882:1: terminal : ( TOKEN_REF ( elementOptions )? -> ^( TOKEN_REF ( elementOptions )? ) | STRING_LITERAL ( elementOptions )? -> ^( STRING_LITERAL ( elementOptions )? ) );
    public final ANTLRParser.terminal_return terminal() throws RecognitionException {
        ANTLRParser.terminal_return retval = new ANTLRParser.terminal_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token TOKEN_REF206=null;
        Token STRING_LITERAL208=null;
        ANTLRParser.elementOptions_return elementOptions207 =null;

        ANTLRParser.elementOptions_return elementOptions209 =null;


        GrammarAST TOKEN_REF206_tree=null;
        GrammarAST STRING_LITERAL208_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
        RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");
        RewriteRuleSubtreeStream stream_elementOptions=new RewriteRuleSubtreeStream(adaptor,"rule elementOptions");
        try {
            // ANTLRParser.g:889:2: ( TOKEN_REF ( elementOptions )? -> ^( TOKEN_REF ( elementOptions )? ) | STRING_LITERAL ( elementOptions )? -> ^( STRING_LITERAL ( elementOptions )? ) )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==TOKEN_REF) ) {
                alt70=1;
            }
            else if ( (LA70_0==STRING_LITERAL) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;

            }
            switch (alt70) {
                case 1 :
                    // ANTLRParser.g:889:6: TOKEN_REF ( elementOptions )?
                    {
                    TOKEN_REF206=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal3921);  
                    stream_TOKEN_REF.add(TOKEN_REF206);


                    // ANTLRParser.g:889:16: ( elementOptions )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==LT) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ANTLRParser.g:889:16: elementOptions
                            {
                            pushFollow(FOLLOW_elementOptions_in_terminal3923);
                            elementOptions207=elementOptions();

                            state._fsp--;

                            stream_elementOptions.add(elementOptions207.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: elementOptions, TOKEN_REF
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 889:33: -> ^( TOKEN_REF ( elementOptions )? )
                    {
                        // ANTLRParser.g:889:36: ^( TOKEN_REF ( elementOptions )? )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new TerminalAST(stream_TOKEN_REF.nextToken())
                        , root_1);

                        // ANTLRParser.g:889:61: ( elementOptions )?
                        if ( stream_elementOptions.hasNext() ) {
                            adaptor.addChild(root_1, stream_elementOptions.nextTree());

                        }
                        stream_elementOptions.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:890:6: STRING_LITERAL ( elementOptions )?
                    {
                    STRING_LITERAL208=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal3944);  
                    stream_STRING_LITERAL.add(STRING_LITERAL208);


                    // ANTLRParser.g:890:21: ( elementOptions )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==LT) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // ANTLRParser.g:890:21: elementOptions
                            {
                            pushFollow(FOLLOW_elementOptions_in_terminal3946);
                            elementOptions209=elementOptions();

                            state._fsp--;

                            stream_elementOptions.add(elementOptions209.getTree());

                            }
                            break;

                    }


                    // AST REWRITE
                    // elements: STRING_LITERAL, elementOptions
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 890:37: -> ^( STRING_LITERAL ( elementOptions )? )
                    {
                        // ANTLRParser.g:890:40: ^( STRING_LITERAL ( elementOptions )? )
                        {
                        GrammarAST root_1 = (GrammarAST)adaptor.nil();
                        root_1 = (GrammarAST)adaptor.becomeRoot(
                        new TerminalAST(stream_STRING_LITERAL.nextToken())
                        , root_1);

                        // ANTLRParser.g:890:70: ( elementOptions )?
                        if ( stream_elementOptions.hasNext() ) {
                            adaptor.addChild(root_1, stream_elementOptions.nextTree());

                        }
                        stream_elementOptions.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);


            GrammarAST options = (GrammarAST)((GrammarAST)retval.tree).getFirstChildWithType(ANTLRParser.ELEMENT_OPTIONS);
            if ( options!=null ) {
            	Grammar.setNodeOptions(((GrammarAST)retval.tree), options);
            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "terminal"


    public static class elementOptions_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementOptions"
    // ANTLRParser.g:895:1: elementOptions : LT elementOption ( COMMA elementOption )* GT -> ^( ELEMENT_OPTIONS[$LT,\"ELEMENT_OPTIONS\"] ( elementOption )+ ) ;
    public final ANTLRParser.elementOptions_return elementOptions() throws RecognitionException {
        ANTLRParser.elementOptions_return retval = new ANTLRParser.elementOptions_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token LT210=null;
        Token COMMA212=null;
        Token GT214=null;
        ANTLRParser.elementOption_return elementOption211 =null;

        ANTLRParser.elementOption_return elementOption213 =null;


        GrammarAST LT210_tree=null;
        GrammarAST COMMA212_tree=null;
        GrammarAST GT214_tree=null;
        RewriteRuleTokenStream stream_GT=new RewriteRuleTokenStream(adaptor,"token GT");
        RewriteRuleTokenStream stream_LT=new RewriteRuleTokenStream(adaptor,"token LT");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_elementOption=new RewriteRuleSubtreeStream(adaptor,"rule elementOption");
        try {
            // ANTLRParser.g:896:5: ( LT elementOption ( COMMA elementOption )* GT -> ^( ELEMENT_OPTIONS[$LT,\"ELEMENT_OPTIONS\"] ( elementOption )+ ) )
            // ANTLRParser.g:896:7: LT elementOption ( COMMA elementOption )* GT
            {
            LT210=(Token)match(input,LT,FOLLOW_LT_in_elementOptions3975);  
            stream_LT.add(LT210);


            pushFollow(FOLLOW_elementOption_in_elementOptions3977);
            elementOption211=elementOption();

            state._fsp--;

            stream_elementOption.add(elementOption211.getTree());

            // ANTLRParser.g:896:24: ( COMMA elementOption )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==COMMA) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ANTLRParser.g:896:25: COMMA elementOption
            	    {
            	    COMMA212=(Token)match(input,COMMA,FOLLOW_COMMA_in_elementOptions3980);  
            	    stream_COMMA.add(COMMA212);


            	    pushFollow(FOLLOW_elementOption_in_elementOptions3982);
            	    elementOption213=elementOption();

            	    state._fsp--;

            	    stream_elementOption.add(elementOption213.getTree());

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);


            GT214=(Token)match(input,GT,FOLLOW_GT_in_elementOptions3986);  
            stream_GT.add(GT214);


            // AST REWRITE
            // elements: elementOption
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 896:50: -> ^( ELEMENT_OPTIONS[$LT,\"ELEMENT_OPTIONS\"] ( elementOption )+ )
            {
                // ANTLRParser.g:896:53: ^( ELEMENT_OPTIONS[$LT,\"ELEMENT_OPTIONS\"] ( elementOption )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                (GrammarAST)adaptor.create(ELEMENT_OPTIONS, LT210, "ELEMENT_OPTIONS")
                , root_1);

                if ( !(stream_elementOption.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_elementOption.hasNext() ) {
                    adaptor.addChild(root_1, stream_elementOption.nextTree());

                }
                stream_elementOption.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elementOptions"


    public static class elementOption_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementOption"
    // ANTLRParser.g:901:1: elementOption : ( qid | id ASSIGN ^ optionValue );
    public final ANTLRParser.elementOption_return elementOption() throws RecognitionException {
        ANTLRParser.elementOption_return retval = new ANTLRParser.elementOption_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token ASSIGN217=null;
        ANTLRParser.qid_return qid215 =null;

        ANTLRParser.id_return id216 =null;

        ANTLRParser.optionValue_return optionValue218 =null;


        GrammarAST ASSIGN217_tree=null;

        try {
            // ANTLRParser.g:902:5: ( qid | id ASSIGN ^ optionValue )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_REF) ) {
                int LA72_1 = input.LA(2);

                if ( (LA72_1==COMMA||LA72_1==DOT||LA72_1==GT) ) {
                    alt72=1;
                }
                else if ( (LA72_1==ASSIGN) ) {
                    alt72=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA72_0==TOKEN_REF) ) {
                int LA72_2 = input.LA(2);

                if ( (LA72_2==COMMA||LA72_2==DOT||LA72_2==GT) ) {
                    alt72=1;
                }
                else if ( (LA72_2==ASSIGN) ) {
                    alt72=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 72, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;

            }
            switch (alt72) {
                case 1 :
                    // ANTLRParser.g:903:7: qid
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_qid_in_elementOption4022);
                    qid215=qid();

                    state._fsp--;

                    adaptor.addChild(root_0, qid215.getTree());

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:904:7: id ASSIGN ^ optionValue
                    {
                    root_0 = (GrammarAST)adaptor.nil();


                    pushFollow(FOLLOW_id_in_elementOption4030);
                    id216=id();

                    state._fsp--;

                    adaptor.addChild(root_0, id216.getTree());

                    ASSIGN217=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption4032); 
                    ASSIGN217_tree = 
                    (GrammarAST)adaptor.create(ASSIGN217)
                    ;
                    root_0 = (GrammarAST)adaptor.becomeRoot(ASSIGN217_tree, root_0);


                    pushFollow(FOLLOW_optionValue_in_elementOption4035);
                    optionValue218=optionValue();

                    state._fsp--;

                    adaptor.addChild(root_0, optionValue218.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elementOption"


    public static class id_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "id"
    // ANTLRParser.g:911:1: id : ( RULE_REF -> ID[$RULE_REF] | TOKEN_REF -> ID[$TOKEN_REF] );
    public final ANTLRParser.id_return id() throws RecognitionException {
        ANTLRParser.id_return retval = new ANTLRParser.id_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token RULE_REF219=null;
        Token TOKEN_REF220=null;

        GrammarAST RULE_REF219_tree=null;
        GrammarAST TOKEN_REF220_tree=null;
        RewriteRuleTokenStream stream_RULE_REF=new RewriteRuleTokenStream(adaptor,"token RULE_REF");
        RewriteRuleTokenStream stream_TOKEN_REF=new RewriteRuleTokenStream(adaptor,"token TOKEN_REF");

         paraphrases.push("looking for an identifier"); 
        try {
            // ANTLRParser.g:914:5: ( RULE_REF -> ID[$RULE_REF] | TOKEN_REF -> ID[$TOKEN_REF] )
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_REF) ) {
                alt73=1;
            }
            else if ( (LA73_0==TOKEN_REF) ) {
                alt73=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;

            }
            switch (alt73) {
                case 1 :
                    // ANTLRParser.g:914:7: RULE_REF
                    {
                    RULE_REF219=(Token)match(input,RULE_REF,FOLLOW_RULE_REF_in_id4066);  
                    stream_RULE_REF.add(RULE_REF219);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 914:17: -> ID[$RULE_REF]
                    {
                        adaptor.addChild(root_0, 
                        (GrammarAST)adaptor.create(ID, RULE_REF219)
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // ANTLRParser.g:915:7: TOKEN_REF
                    {
                    TOKEN_REF220=(Token)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_id4079);  
                    stream_TOKEN_REF.add(TOKEN_REF220);


                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (GrammarAST)adaptor.nil();
                    // 915:17: -> ID[$TOKEN_REF]
                    {
                        adaptor.addChild(root_0, 
                        (GrammarAST)adaptor.create(ID, TOKEN_REF220)
                        );

                    }


                    retval.tree = root_0;

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

             paraphrases.pop(); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "id"


    public static class qid_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "qid"
    // ANTLRParser.g:918:1: qid : id ( DOT id )* -> ID[$qid.start, $text] ;
    public final ANTLRParser.qid_return qid() throws RecognitionException {
        ANTLRParser.qid_return retval = new ANTLRParser.qid_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token DOT222=null;
        ANTLRParser.id_return id221 =null;

        ANTLRParser.id_return id223 =null;


        GrammarAST DOT222_tree=null;
        RewriteRuleTokenStream stream_DOT=new RewriteRuleTokenStream(adaptor,"token DOT");
        RewriteRuleSubtreeStream stream_id=new RewriteRuleSubtreeStream(adaptor,"rule id");
         paraphrases.push("looking for a qualified identifier"); 
        try {
            // ANTLRParser.g:921:2: ( id ( DOT id )* -> ID[$qid.start, $text] )
            // ANTLRParser.g:921:4: id ( DOT id )*
            {
            pushFollow(FOLLOW_id_in_qid4107);
            id221=id();

            state._fsp--;

            stream_id.add(id221.getTree());

            // ANTLRParser.g:921:7: ( DOT id )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==DOT) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // ANTLRParser.g:921:8: DOT id
            	    {
            	    DOT222=(Token)match(input,DOT,FOLLOW_DOT_in_qid4110);  
            	    stream_DOT.add(DOT222);


            	    pushFollow(FOLLOW_id_in_qid4112);
            	    id223=id();

            	    state._fsp--;

            	    stream_id.add(id223.getTree());

            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 921:17: -> ID[$qid.start, $text]
            {
                adaptor.addChild(root_0, 
                (GrammarAST)adaptor.create(ID, ((Token)retval.start), input.toString(retval.start,input.LT(-1)))
                );

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

             paraphrases.pop(); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "qid"


    public static class alternativeEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "alternativeEntry"
    // ANTLRParser.g:924:1: alternativeEntry : alternative EOF ;
    public final ANTLRParser.alternativeEntry_return alternativeEntry() throws RecognitionException {
        ANTLRParser.alternativeEntry_return retval = new ANTLRParser.alternativeEntry_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token EOF225=null;
        ANTLRParser.alternative_return alternative224 =null;


        GrammarAST EOF225_tree=null;

        try {
            // ANTLRParser.g:924:18: ( alternative EOF )
            // ANTLRParser.g:924:20: alternative EOF
            {
            root_0 = (GrammarAST)adaptor.nil();


            pushFollow(FOLLOW_alternative_in_alternativeEntry4129);
            alternative224=alternative();

            state._fsp--;

            adaptor.addChild(root_0, alternative224.getTree());

            EOF225=(Token)match(input,EOF,FOLLOW_EOF_in_alternativeEntry4131); 
            EOF225_tree = 
            (GrammarAST)adaptor.create(EOF225)
            ;
            adaptor.addChild(root_0, EOF225_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alternativeEntry"


    public static class elementEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "elementEntry"
    // ANTLRParser.g:925:1: elementEntry : element EOF ;
    public final ANTLRParser.elementEntry_return elementEntry() throws RecognitionException {
        ANTLRParser.elementEntry_return retval = new ANTLRParser.elementEntry_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token EOF227=null;
        ANTLRParser.element_return element226 =null;


        GrammarAST EOF227_tree=null;

        try {
            // ANTLRParser.g:925:14: ( element EOF )
            // ANTLRParser.g:925:16: element EOF
            {
            root_0 = (GrammarAST)adaptor.nil();


            pushFollow(FOLLOW_element_in_elementEntry4140);
            element226=element();

            state._fsp--;

            adaptor.addChild(root_0, element226.getTree());

            EOF227=(Token)match(input,EOF,FOLLOW_EOF_in_elementEntry4142); 
            EOF227_tree = 
            (GrammarAST)adaptor.create(EOF227)
            ;
            adaptor.addChild(root_0, EOF227_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elementEntry"


    public static class ruleEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ruleEntry"
    // ANTLRParser.g:926:1: ruleEntry : rule EOF ;
    public final ANTLRParser.ruleEntry_return ruleEntry() throws RecognitionException {
        ANTLRParser.ruleEntry_return retval = new ANTLRParser.ruleEntry_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token EOF229=null;
        ANTLRParser.rule_return rule228 =null;


        GrammarAST EOF229_tree=null;

        try {
            // ANTLRParser.g:926:11: ( rule EOF )
            // ANTLRParser.g:926:13: rule EOF
            {
            root_0 = (GrammarAST)adaptor.nil();


            pushFollow(FOLLOW_rule_in_ruleEntry4150);
            rule228=rule();

            state._fsp--;

            adaptor.addChild(root_0, rule228.getTree());

            EOF229=(Token)match(input,EOF,FOLLOW_EOF_in_ruleEntry4152); 
            EOF229_tree = 
            (GrammarAST)adaptor.create(EOF229)
            ;
            adaptor.addChild(root_0, EOF229_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleEntry"


    public static class blockEntry_return extends ParserRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "blockEntry"
    // ANTLRParser.g:927:1: blockEntry : block EOF ;
    public final ANTLRParser.blockEntry_return blockEntry() throws RecognitionException {
        ANTLRParser.blockEntry_return retval = new ANTLRParser.blockEntry_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        Token EOF231=null;
        ANTLRParser.block_return block230 =null;


        GrammarAST EOF231_tree=null;

        try {
            // ANTLRParser.g:927:12: ( block EOF )
            // ANTLRParser.g:927:14: block EOF
            {
            root_0 = (GrammarAST)adaptor.nil();


            pushFollow(FOLLOW_block_in_blockEntry4160);
            block230=block();

            state._fsp--;

            adaptor.addChild(root_0, block230.getTree());

            EOF231=(Token)match(input,EOF,FOLLOW_EOF_in_blockEntry4162); 
            EOF231_tree = 
            (GrammarAST)adaptor.create(EOF231)
            ;
            adaptor.addChild(root_0, EOF231_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (GrammarAST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "blockEntry"

    // Delegated rules


 

    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec402 = new BitSet(new long[]{0x0000100082000000L});
    public static final BitSet FOLLOW_grammarType_in_grammarSpec433 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_grammarSpec435 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SEMI_in_grammarSpec437 = new BitSet(new long[]{0x0207040021020800L,0x0000000000000003L});
    public static final BitSet FOLLOW_sync_in_grammarSpec475 = new BitSet(new long[]{0x0207040021020800L,0x0000000000000003L});
    public static final BitSet FOLLOW_prequelConstruct_in_grammarSpec479 = new BitSet(new long[]{0x0207040021020800L,0x0000000000000003L});
    public static final BitSet FOLLOW_sync_in_grammarSpec481 = new BitSet(new long[]{0x0207040021020800L,0x0000000000000003L});
    public static final BitSet FOLLOW_rules_in_grammarSpec506 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_modeSpec_in_grammarSpec512 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_EOF_in_grammarSpec550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_in_grammarType740 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARSER_in_grammarType767 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GRAMMAR_in_grammarType792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_optionsSpec_in_prequelConstruct834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delegateGrammars_in_prequelConstruct857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokensSpec_in_prequelConstruct901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_prequelConstruct938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec953 = new BitSet(new long[]{0x0240000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_option_in_optionsSpec956 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SEMI_in_optionsSpec958 = new BitSet(new long[]{0x0240000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RBRACE_in_optionsSpec962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_option991 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ASSIGN_in_option993 = new BitSet(new long[]{0x4200000040000010L,0x0000000000000002L});
    public static final BitSet FOLLOW_optionValue_in_option996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qid_in_optionValue1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_optionValue1047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_optionValue1052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_optionValue1063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars1079 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars1081 = new BitSet(new long[]{0x0400000000008000L});
    public static final BitSet FOLLOW_COMMA_in_delegateGrammars1084 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars1086 = new BitSet(new long[]{0x0400000000008000L});
    public static final BitSet FOLLOW_SEMI_in_delegateGrammars1090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_delegateGrammar1117 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammar1119 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_delegateGrammar1122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_delegateGrammar1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKENS_SPEC_in_tokensSpec1148 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec1150 = new BitSet(new long[]{0x0240000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RBRACE_in_tokensSpec1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_tokenSpec1173 = new BitSet(new long[]{0x0400000000000400L});
    public static final BitSet FOLLOW_ASSIGN_in_tokenSpec1179 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_tokenSpec1181 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SEMI_in_tokenSpec1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_tokenSpec1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_action1238 = new BitSet(new long[]{0x0200100080000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_actionScopeName_in_action1241 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_COLONCOLON_in_action1243 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_action1247 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_action1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_actionScopeName1278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_in_actionScopeName1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PARSER_in_actionScopeName1298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MODE_in_modeSpec1317 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_modeSpec1319 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SEMI_in_modeSpec1321 = new BitSet(new long[]{0x0000000001020000L,0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_modeSpec1323 = new BitSet(new long[]{0x0000000001020000L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerRule_in_modeSpec1326 = new BitSet(new long[]{0x0000000001020000L,0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_modeSpec1328 = new BitSet(new long[]{0x0000000001020002L,0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_rules1359 = new BitSet(new long[]{0x0207000001020002L,0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_rules1362 = new BitSet(new long[]{0x0207000001020000L,0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_rules1364 = new BitSet(new long[]{0x0207000001020002L,0x0000000000000002L});
    public static final BitSet FOLLOW_parserRule_in_rule1426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerRule_in_rule1431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_parserRule1471 = new BitSet(new long[]{0x0207000001000000L});
    public static final BitSet FOLLOW_ruleModifiers_in_parserRule1509 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_RULE_REF_in_parserRule1532 = new BitSet(new long[]{0x8080040200000900L});
    public static final BitSet FOLLOW_ARG_ACTION_in_parserRule1562 = new BitSet(new long[]{0x8080040200000800L});
    public static final BitSet FOLLOW_ruleReturns_in_parserRule1569 = new BitSet(new long[]{0x8000040200000800L});
    public static final BitSet FOLLOW_throwsSpec_in_parserRule1576 = new BitSet(new long[]{0x0000040200000800L});
    public static final BitSet FOLLOW_localsSpec_in_parserRule1583 = new BitSet(new long[]{0x0000040000000800L});
    public static final BitSet FOLLOW_rulePrequels_in_parserRule1621 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_parserRule1630 = new BitSet(new long[]{0x4A00808400080010L,0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBlock_in_parserRule1653 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SEMI_in_parserRule1662 = new BitSet(new long[]{0x0000000000801000L});
    public static final BitSet FOLLOW_exceptionGroup_in_parserRule1671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup1760 = new BitSet(new long[]{0x0000000000801002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup1763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler1780 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler1782 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler1784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause1811 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause1813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_rulePrequels1845 = new BitSet(new long[]{0x0000040000000802L});
    public static final BitSet FOLLOW_rulePrequel_in_rulePrequels1848 = new BitSet(new long[]{0x0000040000000800L});
    public static final BitSet FOLLOW_sync_in_rulePrequels1850 = new BitSet(new long[]{0x0000040000000802L});
    public static final BitSet FOLLOW_optionsSpec_in_rulePrequel1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAction_in_rulePrequel1882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RETURNS_in_ruleReturns1902 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleReturns1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_THROWS_in_throwsSpec1933 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_qid_in_throwsSpec1935 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_COMMA_in_throwsSpec1938 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_qid_in_throwsSpec1940 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_LOCALS_in_localsSpec1965 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ARG_ACTION_in_localsSpec1968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_ruleAction1991 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_ruleAction1993 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_ruleAction1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModifier_in_ruleModifiers2027 = new BitSet(new long[]{0x0007000001000002L});
    public static final BitSet FOLLOW_ruleAltList_in_ruleBlock2112 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labeledAlt_in_ruleAltList2148 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_OR_in_ruleAltList2151 = new BitSet(new long[]{0x4A00808400080010L,0x0000000000000002L});
    public static final BitSet FOLLOW_labeledAlt_in_ruleAltList2153 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_alternative_in_labeledAlt2171 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_POUND_in_labeledAlt2177 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_labeledAlt2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_lexerRule2213 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_FRAGMENT_in_lexerRule2216 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_lexerRule2222 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_COLON_in_lexerRule2224 = new BitSet(new long[]{0x4A00008500080010L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerRuleBlock_in_lexerRule2226 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_SEMI_in_lexerRule2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerAltList_in_lexerRuleBlock2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerAlt_in_lexerAltList2331 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_OR_in_lexerAltList2334 = new BitSet(new long[]{0x4A00008500080010L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerAlt_in_lexerAltList2336 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_lexerElements_in_lexerAlt2354 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_lexerCommands_in_lexerAlt2360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerElement_in_lexerElements2403 = new BitSet(new long[]{0x4A00008500080012L,0x0000000000000002L});
    public static final BitSet FOLLOW_labeledLexerElement_in_lexerElement2440 = new BitSet(new long[]{0x2008200000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_lexerElement2446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerAtom_in_lexerElement2492 = new BitSet(new long[]{0x2008200000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_lexerElement2498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerBlock_in_lexerElement2544 = new BitSet(new long[]{0x2008200000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_lexerElement2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actionElement_in_lexerElement2578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_labeledLexerElement2608 = new BitSet(new long[]{0x0000400000000400L});
    public static final BitSet FOLLOW_ASSIGN_in_labeledLexerElement2613 = new BitSet(new long[]{0x4200008500080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledLexerElement2617 = new BitSet(new long[]{0x4200008500080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerAtom_in_labeledLexerElement2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_labeledLexerElement2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_lexerBlock2670 = new BitSet(new long[]{0x4A00008500080010L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerAltList_in_lexerBlock2672 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lexerBlock2674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RARROW_in_lexerCommands2708 = new BitSet(new long[]{0x0200001000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerCommand_in_lexerCommands2710 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_COMMA_in_lexerCommands2713 = new BitSet(new long[]{0x0200001000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerCommand_in_lexerCommands2715 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_lexerCommandName_in_lexerCommand2733 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_LPAREN_in_lexerCommand2735 = new BitSet(new long[]{0x0200000040000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_lexerCommandExpr_in_lexerCommand2737 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_lexerCommand2739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerCommandName_in_lexerCommand2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_lexerCommandExpr2765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_lexerCommandExpr2770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_lexerCommandName2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MODE_in_lexerCommandName2812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alternative_in_altList2840 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_OR_in_altList2843 = new BitSet(new long[]{0x4A00088400080010L,0x0000000000000002L});
    public static final BitSet FOLLOW_alternative_in_altList2845 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_elements_in_alternative2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_elements2925 = new BitSet(new long[]{0x4A00008400080012L,0x0000000000000002L});
    public static final BitSet FOLLOW_labeledElement_in_element2963 = new BitSet(new long[]{0x2008200000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_element2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element3015 = new BitSet(new long[]{0x2008200000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_element3021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_element3067 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_actionElement_in_element3072 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_actionElement3098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_actionElement3108 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_elementOptions_in_actionElement3110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_actionElement3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_actionElement3138 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_elementOptions_in_actionElement3140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_labeledElement3162 = new BitSet(new long[]{0x0000400000000400L});
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement3167 = new BitSet(new long[]{0x4200008400080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement3171 = new BitSet(new long[]{0x4200008400080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_labeledElement3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_labeledElement3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf3236 = new BitSet(new long[]{0x2008200000000002L});
    public static final BitSet FOLLOW_blockSuffix_in_ebnf3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_blockSuffix3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUESTION_in_ebnfSuffix3325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_ebnfSuffix3340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_ebnfSuffix3358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_lexerAtom3379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_lexerAtom3384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_lexerAtom3394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notSet_in_lexerAtom3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wildcard_in_lexerAtom3413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_lexerAtom3421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom3466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom3473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_atom3483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_notSet_in_atom3491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_wildcard_in_atom3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_wildcard3547 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_elementOptions_in_wildcard3549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notSet3587 = new BitSet(new long[]{0x4000000100000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_setElement_in_notSet3589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_notSet3617 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_blockSet_in_notSet3619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_blockSet3654 = new BitSet(new long[]{0x4000000100000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_setElement_in_blockSet3656 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_OR_in_blockSet3659 = new BitSet(new long[]{0x4000000100000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_setElement_in_blockSet3661 = new BitSet(new long[]{0x0100080000000000L});
    public static final BitSet FOLLOW_RPAREN_in_blockSet3665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement3695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement3703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_setElement3711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_setElement3721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_block3745 = new BitSet(new long[]{0x4A000C8400082810L,0x0000000000000002L});
    public static final BitSet FOLLOW_optionsSpec_in_block3757 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_ruleAction_in_block3762 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_COLON_in_block3765 = new BitSet(new long[]{0x4A00088400080010L,0x0000000000000002L});
    public static final BitSet FOLLOW_altList_in_block3778 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_block3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_ruleref3831 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref3833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range3886 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RANGE_in_range3891 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range3897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal3921 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_elementOptions_in_terminal3923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal3944 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_elementOptions_in_terminal3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LT_in_elementOptions3975 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_elementOption_in_elementOptions3977 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_COMMA_in_elementOptions3980 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_elementOption_in_elementOptions3982 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_GT_in_elementOptions3986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_qid_in_elementOption4022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_elementOption4030 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption4032 = new BitSet(new long[]{0x4200000040000010L,0x0000000000000002L});
    public static final BitSet FOLLOW_optionValue_in_elementOption4035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_id4066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_id4079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_qid4107 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_DOT_in_qid4110 = new BitSet(new long[]{0x0200000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_id_in_qid4112 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_alternative_in_alternativeEntry4129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_alternativeEntry4131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_element_in_elementEntry4140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_elementEntry4142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule_in_ruleEntry4150 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_ruleEntry4152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_blockEntry4160 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_blockEntry4162 = new BitSet(new long[]{0x0000000000000002L});

}
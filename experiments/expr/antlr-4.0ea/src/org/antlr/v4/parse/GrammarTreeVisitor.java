// $ANTLR 3.4 GrammarTreeVisitor.g 2012-04-29 22:33:16

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
import org.antlr.v4.tool.ast.*;
import java.lang.reflect.Method;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/** The definitive ANTLR v3 tree grammar to walk/visit ANTLR v4 grammars.
 *  Parses trees created by ANTLRParser.g.
 *
 *  Rather than have multiple tree grammars, one for each visit, I'm
 *  creating this generic visitor that knows about context. All of the
 *  boilerplate pattern recognition is done here. Then, subclasses can
 *  override the methods they care about. This prevents a lot of the same
 *  context tracking stuff like "set current alternative for current
 *  rule node" that is repeated in lots of tree filters.
 */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class GrammarTreeVisitor extends TreeParser {
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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public GrammarTreeVisitor(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public GrammarTreeVisitor(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return GrammarTreeVisitor.tokenNames; }
    public String getGrammarFileName() { return "GrammarTreeVisitor.g"; }


    public String grammarName;
    public GrammarAST currentRuleAST;
    public String currentModeName = LexerGrammar.DEFAULT_MODE_NAME;
    public String currentRuleName;
    //public GrammarAST currentRuleBlock;
    public GrammarAST currentOuterAltRoot;
    public int currentOuterAltNumber = 1; // 1..n
    public int rewriteEBNFLevel = 0;

    public GrammarTreeVisitor() { this(null); }

    public ErrorManager getErrorManager() { return null; }

    public void visitGrammar(GrammarAST t) { visit(t, "grammarSpec"); }
    public void visit(GrammarAST t, String ruleName) {
    	CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
    	setTreeNodeStream(nodes);
    	try {
    		Method m = getClass().getMethod(ruleName);
    		m.invoke(this);
    	}
    	catch (Exception e) {
    		ErrorManager errMgr = getErrorManager();
    		if ( errMgr==null ) {
    			System.err.println("can't find rule "+ruleName+
    							   " or tree structure error: "+t.toStringTree()
    							   );
    			e.printStackTrace(System.err);
    		}
    		else errMgr.toolError(ErrorType.INTERNAL_ERROR, e);
    	}
    }

    public void discoverGrammar(GrammarRootAST root, GrammarAST ID) { }
    public void finishPrequels(GrammarAST firstPrequel) { }
    public void finishGrammar(GrammarRootAST root, GrammarAST ID) { }

    public void grammarOption(GrammarAST ID, GrammarAST valueAST) { }
    public void ruleOption(GrammarAST ID, GrammarAST valueAST) { }
    public void blockOption(GrammarAST ID, GrammarAST valueAST) { }
    public void tokenAlias(GrammarAST ID, GrammarAST literal) { }
    public void globalNamedAction(GrammarAST scope, GrammarAST ID, ActionAST action) { }
    public void importGrammar(GrammarAST label, GrammarAST ID) { }

    public void modeDef(GrammarAST m, GrammarAST ID) { }

    public void discoverRules(GrammarAST rules) { }
    public void finishRules(GrammarAST rule) { }
    public void discoverRule(RuleAST rule, GrammarAST ID, List<GrammarAST> modifiers,
    						 ActionAST arg, ActionAST returns, GrammarAST thrws,
    						 GrammarAST options, GrammarAST locals,
    						 List<GrammarAST> actions,
    						 GrammarAST block) { }
    public void finishRule(RuleAST rule, GrammarAST ID, GrammarAST block) { }
    public void discoverLexerRule(RuleAST rule, GrammarAST ID, List<GrammarAST> modifiers,
                                  GrammarAST block) { }
    public void finishLexerRule(RuleAST rule, GrammarAST ID, GrammarAST block) { }
    public void ruleCatch(GrammarAST arg, ActionAST action) { }
    public void finallyAction(ActionAST action) { }
    public void discoverOuterAlt(AltAST alt) { }
    public void finishOuterAlt(AltAST alt) { }
    public void discoverAlt(AltAST alt) { }
    public void finishAlt(AltAST alt) { }

    public void ruleRef(GrammarAST ref, ActionAST arg) { }
    public void tokenRef(TerminalAST ref) { }
    public void elementOption(GrammarASTWithOptions t, GrammarAST ID, GrammarAST valueAST) { }
    public void stringRef(TerminalAST ref) { }
    public void wildcardRef(GrammarAST ref) { }
    public void actionInAlt(ActionAST action) { }
    public void sempredInAlt(PredAST pred) { }
    public void label(GrammarAST op, GrammarAST ID, GrammarAST element) { }
    public void lexerCallCommand(int outerAltNumber, GrammarAST ID, GrammarAST arg) { }
    public void lexerCommand(int outerAltNumber, GrammarAST ID) { }

    	public void traceIn(String ruleName, int ruleIndex)  {
    		System.err.println("enter "+ruleName+": "+input.LT(1));
    	}

    	public void traceOut(String ruleName, int ruleIndex)  {
    		System.err.println("exit "+ruleName+": "+input.LT(1));
    	}



    // $ANTLR start "grammarSpec"
    // GrammarTreeVisitor.g:168:1: grammarSpec : ^( GRAMMAR ID ( DOC_COMMENT )? prequelConstructs rules ( mode )* ) ;
    public final void grammarSpec() throws RecognitionException {
        GrammarAST ID1=null;
        GrammarAST GRAMMAR2=null;
        GrammarTreeVisitor.prequelConstructs_return prequelConstructs3 =null;


        try {
            // GrammarTreeVisitor.g:169:5: ( ^( GRAMMAR ID ( DOC_COMMENT )? prequelConstructs rules ( mode )* ) )
            // GrammarTreeVisitor.g:169:9: ^( GRAMMAR ID ( DOC_COMMENT )? prequelConstructs rules ( mode )* )
            {
            GRAMMAR2=(GrammarAST)match(input,GRAMMAR,FOLLOW_GRAMMAR_in_grammarSpec75); 

            match(input, Token.DOWN, null); 
            ID1=(GrammarAST)match(input,ID,FOLLOW_ID_in_grammarSpec77); 

            grammarName=(ID1!=null?ID1.getText():null);

            // GrammarTreeVisitor.g:169:47: ( DOC_COMMENT )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DOC_COMMENT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // GrammarTreeVisitor.g:169:47: DOC_COMMENT
                    {
                    match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_grammarSpec81); 

                    }
                    break;

            }


            discoverGrammar((GrammarRootAST)GRAMMAR2, ID1);

            pushFollow(FOLLOW_prequelConstructs_in_grammarSpec99);
            prequelConstructs3=prequelConstructs();

            state._fsp--;


            finishPrequels((prequelConstructs3!=null?prequelConstructs3.firstOne:null));

            pushFollow(FOLLOW_rules_in_grammarSpec116);
            rules();

            state._fsp--;


            // GrammarTreeVisitor.g:173:14: ( mode )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==MODE) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // GrammarTreeVisitor.g:173:14: mode
            	    {
            	    pushFollow(FOLLOW_mode_in_grammarSpec118);
            	    mode();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            finishGrammar((GrammarRootAST)GRAMMAR2, ID1);

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "grammarSpec"


    public static class prequelConstructs_return extends TreeRuleReturnScope {
        public GrammarAST firstOne=null;
    };


    // $ANTLR start "prequelConstructs"
    // GrammarTreeVisitor.g:178:1: prequelConstructs returns [GrammarAST firstOne=null] : ( ( prequelConstruct )+ |);
    public final GrammarTreeVisitor.prequelConstructs_return prequelConstructs() throws RecognitionException {
        GrammarTreeVisitor.prequelConstructs_return retval = new GrammarTreeVisitor.prequelConstructs_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:179:2: ( ( prequelConstruct )+ |)
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==AT||LA4_0==IMPORT||LA4_0==OPTIONS||LA4_0==TOKENS_SPEC) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULES) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // GrammarTreeVisitor.g:179:4: ( prequelConstruct )+
                    {
                    retval.firstOne =((GrammarAST)retval.start);

                    // GrammarTreeVisitor.g:179:24: ( prequelConstruct )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==AT||LA3_0==IMPORT||LA3_0==OPTIONS||LA3_0==TOKENS_SPEC) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // GrammarTreeVisitor.g:179:24: prequelConstruct
                    	    {
                    	    pushFollow(FOLLOW_prequelConstruct_in_prequelConstructs150);
                    	    prequelConstruct();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:181:2: 
                    {
                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "prequelConstructs"



    // $ANTLR start "prequelConstruct"
    // GrammarTreeVisitor.g:183:1: prequelConstruct : ( optionsSpec | delegateGrammars | tokensSpec | action );
    public final void prequelConstruct() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:184:2: ( optionsSpec | delegateGrammars | tokensSpec | action )
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
                    // GrammarTreeVisitor.g:184:6: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_prequelConstruct167);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:185:9: delegateGrammars
                    {
                    pushFollow(FOLLOW_delegateGrammars_in_prequelConstruct177);
                    delegateGrammars();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:186:9: tokensSpec
                    {
                    pushFollow(FOLLOW_tokensSpec_in_prequelConstruct187);
                    tokensSpec();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:187:9: action
                    {
                    pushFollow(FOLLOW_action_in_prequelConstruct197);
                    action();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prequelConstruct"


    public static class optionsSpec_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "optionsSpec"
    // GrammarTreeVisitor.g:190:1: optionsSpec : ^( OPTIONS ( option )* ) ;
    public final GrammarTreeVisitor.optionsSpec_return optionsSpec() throws RecognitionException {
        GrammarTreeVisitor.optionsSpec_return retval = new GrammarTreeVisitor.optionsSpec_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:191:2: ( ^( OPTIONS ( option )* ) )
            // GrammarTreeVisitor.g:191:4: ^( OPTIONS ( option )* )
            {
            match(input,OPTIONS,FOLLOW_OPTIONS_in_optionsSpec212); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // GrammarTreeVisitor.g:191:14: ( option )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==ASSIGN) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // GrammarTreeVisitor.g:191:14: option
                	    {
                	    pushFollow(FOLLOW_option_in_optionsSpec214);
                	    option();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop6;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "optionsSpec"



    // $ANTLR start "option"
    // GrammarTreeVisitor.g:194:1: option : ^(a= ASSIGN ID v= optionValue ) ;
    public final void option() throws RecognitionException {
        GrammarAST a=null;
        GrammarAST ID4=null;
        GrammarTreeVisitor.optionValue_return v =null;



        boolean rule = inContext("RULE ...");
        boolean block = inContext("BLOCK ...");

        try {
            // GrammarTreeVisitor.g:199:5: ( ^(a= ASSIGN ID v= optionValue ) )
            // GrammarTreeVisitor.g:199:9: ^(a= ASSIGN ID v= optionValue )
            {
            a=(GrammarAST)match(input,ASSIGN,FOLLOW_ASSIGN_in_option243); 

            match(input, Token.DOWN, null); 
            ID4=(GrammarAST)match(input,ID,FOLLOW_ID_in_option245); 

            pushFollow(FOLLOW_optionValue_in_option249);
            v=optionValue();

            state._fsp--;


            match(input, Token.UP, null); 



                	if ( block ) blockOption(ID4, (v!=null?((GrammarAST)v.start):null)); // most specific first
                	else if ( rule ) ruleOption(ID4, (v!=null?((GrammarAST)v.start):null));
                	else grammarOption(ID4, (v!=null?((GrammarAST)v.start):null));
                	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "option"


    public static class optionValue_return extends TreeRuleReturnScope {
        public String v;
    };


    // $ANTLR start "optionValue"
    // GrammarTreeVisitor.g:207:1: optionValue returns [String v] : ( ID | STRING_LITERAL | INT );
    public final GrammarTreeVisitor.optionValue_return optionValue() throws RecognitionException {
        GrammarTreeVisitor.optionValue_return retval = new GrammarTreeVisitor.optionValue_return();
        retval.start = input.LT(1);


        retval.v = ((GrammarAST)retval.start).token.getText();
        try {
            // GrammarTreeVisitor.g:209:5: ( ID | STRING_LITERAL | INT )
            // GrammarTreeVisitor.g:
            {
            if ( input.LA(1)==ID||input.LA(1)==INT||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "optionValue"



    // $ANTLR start "delegateGrammars"
    // GrammarTreeVisitor.g:214:1: delegateGrammars : ^( IMPORT ( delegateGrammar )+ ) ;
    public final void delegateGrammars() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:215:2: ( ^( IMPORT ( delegateGrammar )+ ) )
            // GrammarTreeVisitor.g:215:6: ^( IMPORT ( delegateGrammar )+ )
            {
            match(input,IMPORT,FOLLOW_IMPORT_in_delegateGrammars322); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:215:15: ( delegateGrammar )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==ASSIGN||LA7_0==ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // GrammarTreeVisitor.g:215:15: delegateGrammar
            	    {
            	    pushFollow(FOLLOW_delegateGrammar_in_delegateGrammars324);
            	    delegateGrammar();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "delegateGrammars"



    // $ANTLR start "delegateGrammar"
    // GrammarTreeVisitor.g:218:1: delegateGrammar : ( ^( ASSIGN label= ID id= ID ) |id= ID );
    public final void delegateGrammar() throws RecognitionException {
        GrammarAST label=null;
        GrammarAST id=null;

        try {
            // GrammarTreeVisitor.g:219:5: ( ^( ASSIGN label= ID id= ID ) |id= ID )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==ASSIGN) ) {
                alt8=1;
            }
            else if ( (LA8_0==ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // GrammarTreeVisitor.g:219:9: ^( ASSIGN label= ID id= ID )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_delegateGrammar343); 

                    match(input, Token.DOWN, null); 
                    label=(GrammarAST)match(input,ID,FOLLOW_ID_in_delegateGrammar347); 

                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_delegateGrammar351); 

                    match(input, Token.UP, null); 


                    importGrammar(label, id);

                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:220:9: id= ID
                    {
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_delegateGrammar366); 

                    importGrammar(null, id);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "delegateGrammar"



    // $ANTLR start "tokensSpec"
    // GrammarTreeVisitor.g:223:1: tokensSpec : ^( TOKENS_SPEC ( tokenSpec )+ ) ;
    public final void tokensSpec() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:224:2: ( ^( TOKENS_SPEC ( tokenSpec )+ ) )
            // GrammarTreeVisitor.g:224:6: ^( TOKENS_SPEC ( tokenSpec )+ )
            {
            match(input,TOKENS_SPEC,FOLLOW_TOKENS_SPEC_in_tokensSpec390); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:224:20: ( tokenSpec )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ASSIGN||LA9_0==ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // GrammarTreeVisitor.g:224:20: tokenSpec
            	    {
            	    pushFollow(FOLLOW_tokenSpec_in_tokensSpec392);
            	    tokenSpec();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tokensSpec"



    // $ANTLR start "tokenSpec"
    // GrammarTreeVisitor.g:227:1: tokenSpec : ( ^( ASSIGN ID STRING_LITERAL ) | ID );
    public final void tokenSpec() throws RecognitionException {
        GrammarAST ID5=null;
        GrammarAST STRING_LITERAL6=null;
        GrammarAST ID7=null;

        try {
            // GrammarTreeVisitor.g:228:2: ( ^( ASSIGN ID STRING_LITERAL ) | ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==ASSIGN) ) {
                alt10=1;
            }
            else if ( (LA10_0==ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // GrammarTreeVisitor.g:228:4: ^( ASSIGN ID STRING_LITERAL )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_tokenSpec406); 

                    match(input, Token.DOWN, null); 
                    ID5=(GrammarAST)match(input,ID,FOLLOW_ID_in_tokenSpec408); 

                    STRING_LITERAL6=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_tokenSpec410); 

                    match(input, Token.UP, null); 


                    tokenAlias(ID5, STRING_LITERAL6);

                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:229:4: ID
                    {
                    ID7=(GrammarAST)match(input,ID,FOLLOW_ID_in_tokenSpec418); 

                    tokenAlias(ID7, null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "tokenSpec"



    // $ANTLR start "action"
    // GrammarTreeVisitor.g:232:1: action : ^( AT (sc= ID )? name= ID ACTION ) ;
    public final void action() throws RecognitionException {
        GrammarAST sc=null;
        GrammarAST name=null;
        GrammarAST ACTION8=null;

        try {
            // GrammarTreeVisitor.g:233:2: ( ^( AT (sc= ID )? name= ID ACTION ) )
            // GrammarTreeVisitor.g:233:4: ^( AT (sc= ID )? name= ID ACTION )
            {
            match(input,AT,FOLLOW_AT_in_action438); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:233:11: (sc= ID )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==ID) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // GrammarTreeVisitor.g:233:11: sc= ID
                    {
                    sc=(GrammarAST)match(input,ID,FOLLOW_ID_in_action442); 

                    }
                    break;

            }


            name=(GrammarAST)match(input,ID,FOLLOW_ID_in_action447); 

            ACTION8=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_action449); 

            match(input, Token.UP, null); 


            globalNamedAction(sc, name, (ActionAST)ACTION8);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "action"



    // $ANTLR start "rules"
    // GrammarTreeVisitor.g:236:1: rules : ^( RULES ( rule | lexerRule )* ) ;
    public final void rules() throws RecognitionException {
        GrammarAST RULES9=null;

        try {
            // GrammarTreeVisitor.g:237:5: ( ^( RULES ( rule | lexerRule )* ) )
            // GrammarTreeVisitor.g:237:7: ^( RULES ( rule | lexerRule )* )
            {
            RULES9=(GrammarAST)match(input,RULES,FOLLOW_RULES_in_rules467); 

            discoverRules(RULES9);

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // GrammarTreeVisitor.g:237:40: ( rule | lexerRule )*
                loop12:
                do {
                    int alt12=3;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==RULE) ) {
                        int LA12_2 = input.LA(2);

                        if ( (LA12_2==DOWN) ) {
                            int LA12_3 = input.LA(3);

                            if ( (LA12_3==RULE_REF) ) {
                                alt12=1;
                            }
                            else if ( (LA12_3==TOKEN_REF) ) {
                                alt12=2;
                            }


                        }


                    }


                    switch (alt12) {
                	case 1 :
                	    // GrammarTreeVisitor.g:237:41: rule
                	    {
                	    pushFollow(FOLLOW_rule_in_rules472);
                	    rule();

                	    state._fsp--;


                	    }
                	    break;
                	case 2 :
                	    // GrammarTreeVisitor.g:237:46: lexerRule
                	    {
                	    pushFollow(FOLLOW_lexerRule_in_rules474);
                	    lexerRule();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                finishRules(RULES9);

                match(input, Token.UP, null); 
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "rules"



    // $ANTLR start "mode"
    // GrammarTreeVisitor.g:240:1: mode : ^( MODE ID ( lexerRule )+ ) ;
    public final void mode() throws RecognitionException {
        GrammarAST ID10=null;
        GrammarAST MODE11=null;

        try {
            // GrammarTreeVisitor.g:240:6: ( ^( MODE ID ( lexerRule )+ ) )
            // GrammarTreeVisitor.g:240:8: ^( MODE ID ( lexerRule )+ )
            {
            MODE11=(GrammarAST)match(input,MODE,FOLLOW_MODE_in_mode494); 

            match(input, Token.DOWN, null); 
            ID10=(GrammarAST)match(input,ID,FOLLOW_ID_in_mode496); 

            currentModeName=(ID10!=null?ID10.getText():null); modeDef(MODE11, ID10);

            // GrammarTreeVisitor.g:240:68: ( lexerRule )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // GrammarTreeVisitor.g:240:68: lexerRule
            	    {
            	    pushFollow(FOLLOW_lexerRule_in_mode500);
            	    lexerRule();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "mode"



    // $ANTLR start "lexerRule"
    // GrammarTreeVisitor.g:242:1: lexerRule : ^( RULE TOKEN_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS m= FRAGMENT ) )? lexerRuleBlock ) ;
    public final void lexerRule() throws RecognitionException {
        GrammarAST m=null;
        GrammarAST TOKEN_REF12=null;
        GrammarAST RULE13=null;
        GrammarTreeVisitor.lexerRuleBlock_return lexerRuleBlock14 =null;



        List<GrammarAST> mods = new ArrayList<GrammarAST>();
        currentOuterAltNumber=0;

        try {
            // GrammarTreeVisitor.g:247:2: ( ^( RULE TOKEN_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS m= FRAGMENT ) )? lexerRuleBlock ) )
            // GrammarTreeVisitor.g:247:4: ^( RULE TOKEN_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS m= FRAGMENT ) )? lexerRuleBlock )
            {
            RULE13=(GrammarAST)match(input,RULE,FOLLOW_RULE_in_lexerRule520); 

            match(input, Token.DOWN, null); 
            TOKEN_REF12=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_lexerRule522); 

            currentRuleName=(TOKEN_REF12!=null?TOKEN_REF12.getText():null); currentRuleAST=RULE13;

            // GrammarTreeVisitor.g:249:4: ( DOC_COMMENT )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==DOC_COMMENT) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // GrammarTreeVisitor.g:249:4: DOC_COMMENT
                    {
                    match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_lexerRule532); 

                    }
                    break;

            }


            // GrammarTreeVisitor.g:249:17: ( ^( RULEMODIFIERS m= FRAGMENT ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULEMODIFIERS) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // GrammarTreeVisitor.g:249:18: ^( RULEMODIFIERS m= FRAGMENT )
                    {
                    match(input,RULEMODIFIERS,FOLLOW_RULEMODIFIERS_in_lexerRule537); 

                    match(input, Token.DOWN, null); 
                    m=(GrammarAST)match(input,FRAGMENT,FOLLOW_FRAGMENT_in_lexerRule541); 

                    mods.add(m);

                    match(input, Token.UP, null); 


                    }
                    break;

            }


            discoverLexerRule((RuleAST)RULE13, TOKEN_REF12, mods, (GrammarAST)input.LT(1));

            pushFollow(FOLLOW_lexerRuleBlock_in_lexerRule566);
            lexerRuleBlock14=lexerRuleBlock();

            state._fsp--;



                  		finishLexerRule((RuleAST)RULE13, TOKEN_REF12, (lexerRuleBlock14!=null?((GrammarAST)lexerRuleBlock14.start):null));
                  		currentRuleName=null; currentRuleAST=null;
                  		

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerRule"



    // $ANTLR start "rule"
    // GrammarTreeVisitor.g:259:1: rule : ^( RULE RULE_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS (m= ruleModifier )+ ) )? ( ARG_ACTION )? (ret= ruleReturns )? (thr= throwsSpec )? (loc= locals )? (opts= optionsSpec |a= ruleAction )* ruleBlock exceptionGroup ) ;
    public final void rule() throws RecognitionException {
        GrammarAST RULE_REF15=null;
        GrammarAST RULE16=null;
        GrammarAST ARG_ACTION17=null;
        GrammarTreeVisitor.ruleModifier_return m =null;

        GrammarTreeVisitor.ruleReturns_return ret =null;

        GrammarTreeVisitor.throwsSpec_return thr =null;

        GrammarTreeVisitor.locals_return loc =null;

        GrammarTreeVisitor.optionsSpec_return opts =null;

        GrammarTreeVisitor.ruleAction_return a =null;

        GrammarTreeVisitor.ruleBlock_return ruleBlock18 =null;



        List<GrammarAST> mods = new ArrayList<GrammarAST>();
        List<GrammarAST> actions = new ArrayList<GrammarAST>(); // track roots
        currentOuterAltNumber=0;

        try {
            // GrammarTreeVisitor.g:265:2: ( ^( RULE RULE_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS (m= ruleModifier )+ ) )? ( ARG_ACTION )? (ret= ruleReturns )? (thr= throwsSpec )? (loc= locals )? (opts= optionsSpec |a= ruleAction )* ruleBlock exceptionGroup ) )
            // GrammarTreeVisitor.g:265:6: ^( RULE RULE_REF ( DOC_COMMENT )? ( ^( RULEMODIFIERS (m= ruleModifier )+ ) )? ( ARG_ACTION )? (ret= ruleReturns )? (thr= throwsSpec )? (loc= locals )? (opts= optionsSpec |a= ruleAction )* ruleBlock exceptionGroup )
            {
            RULE16=(GrammarAST)match(input,RULE,FOLLOW_RULE_in_rule606); 

            match(input, Token.DOWN, null); 
            RULE_REF15=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_rule608); 

            currentRuleName=(RULE_REF15!=null?RULE_REF15.getText():null); currentRuleAST=RULE16;

            // GrammarTreeVisitor.g:266:4: ( DOC_COMMENT )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==DOC_COMMENT) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // GrammarTreeVisitor.g:266:4: DOC_COMMENT
                    {
                    match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_rule615); 

                    }
                    break;

            }


            // GrammarTreeVisitor.g:266:17: ( ^( RULEMODIFIERS (m= ruleModifier )+ ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULEMODIFIERS) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // GrammarTreeVisitor.g:266:18: ^( RULEMODIFIERS (m= ruleModifier )+ )
                    {
                    match(input,RULEMODIFIERS,FOLLOW_RULEMODIFIERS_in_rule620); 

                    match(input, Token.DOWN, null); 
                    // GrammarTreeVisitor.g:266:34: (m= ruleModifier )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==FRAGMENT||(LA17_0 >= PRIVATE && LA17_0 <= PUBLIC)) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // GrammarTreeVisitor.g:266:35: m= ruleModifier
                    	    {
                    	    pushFollow(FOLLOW_ruleModifier_in_rule625);
                    	    m=ruleModifier();

                    	    state._fsp--;


                    	    mods.add((m!=null?((GrammarAST)m.start):null));

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    match(input, Token.UP, null); 


                    }
                    break;

            }


            // GrammarTreeVisitor.g:267:4: ( ARG_ACTION )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ARG_ACTION) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // GrammarTreeVisitor.g:267:4: ARG_ACTION
                    {
                    ARG_ACTION17=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rule636); 

                    }
                    break;

            }


            // GrammarTreeVisitor.g:268:12: (ret= ruleReturns )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RETURNS) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // GrammarTreeVisitor.g:268:12: ret= ruleReturns
                    {
                    pushFollow(FOLLOW_ruleReturns_in_rule649);
                    ret=ruleReturns();

                    state._fsp--;


                    }
                    break;

            }


            // GrammarTreeVisitor.g:269:12: (thr= throwsSpec )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==THROWS) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // GrammarTreeVisitor.g:269:12: thr= throwsSpec
                    {
                    pushFollow(FOLLOW_throwsSpec_in_rule662);
                    thr=throwsSpec();

                    state._fsp--;


                    }
                    break;

            }


            // GrammarTreeVisitor.g:270:12: (loc= locals )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LOCALS) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // GrammarTreeVisitor.g:270:12: loc= locals
                    {
                    pushFollow(FOLLOW_locals_in_rule675);
                    loc=locals();

                    state._fsp--;


                    }
                    break;

            }


            // GrammarTreeVisitor.g:271:9: (opts= optionsSpec |a= ruleAction )*
            loop23:
            do {
                int alt23=3;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==OPTIONS) ) {
                    alt23=1;
                }
                else if ( (LA23_0==AT) ) {
                    alt23=2;
                }


                switch (alt23) {
            	case 1 :
            	    // GrammarTreeVisitor.g:271:11: opts= optionsSpec
            	    {
            	    pushFollow(FOLLOW_optionsSpec_in_rule690);
            	    opts=optionsSpec();

            	    state._fsp--;


            	    }
            	    break;
            	case 2 :
            	    // GrammarTreeVisitor.g:272:11: a= ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_rule704);
            	    a=ruleAction();

            	    state._fsp--;


            	    actions.add((a!=null?((GrammarAST)a.start):null));

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            discoverRule((RuleAST)RULE16, RULE_REF15, mods, (ActionAST)ARG_ACTION17,
                  					  (ret!=null?((GrammarAST)ret.start):null)!=null?(ActionAST)(ret!=null?((GrammarAST)ret.start):null).getChild(0):null,
                  					  (thr!=null?((GrammarAST)thr.start):null), (opts!=null?((GrammarAST)opts.start):null),
                  					  (loc!=null?((GrammarAST)loc.start):null)!=null?(ActionAST)(loc!=null?((GrammarAST)loc.start):null).getChild(0):null,
                  					  actions, (GrammarAST)input.LT(1));

            pushFollow(FOLLOW_ruleBlock_in_rule735);
            ruleBlock18=ruleBlock();

            state._fsp--;


            pushFollow(FOLLOW_exceptionGroup_in_rule737);
            exceptionGroup();

            state._fsp--;


            finishRule((RuleAST)RULE16, RULE_REF15, (ruleBlock18!=null?((GrammarAST)ruleBlock18.start):null)); currentRuleName=null; currentRuleAST=null;

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "rule"



    // $ANTLR start "exceptionGroup"
    // GrammarTreeVisitor.g:284:1: exceptionGroup : ( exceptionHandler )* ( finallyClause )? ;
    public final void exceptionGroup() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:285:5: ( ( exceptionHandler )* ( finallyClause )? )
            // GrammarTreeVisitor.g:285:7: ( exceptionHandler )* ( finallyClause )?
            {
            // GrammarTreeVisitor.g:285:7: ( exceptionHandler )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==CATCH) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // GrammarTreeVisitor.g:285:7: exceptionHandler
            	    {
            	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup774);
            	    exceptionHandler();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            // GrammarTreeVisitor.g:285:25: ( finallyClause )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==FINALLY) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // GrammarTreeVisitor.g:285:25: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup777);
                    finallyClause();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exceptionGroup"



    // $ANTLR start "exceptionHandler"
    // GrammarTreeVisitor.g:288:1: exceptionHandler : ^( CATCH ARG_ACTION ACTION ) ;
    public final void exceptionHandler() throws RecognitionException {
        GrammarAST ARG_ACTION19=null;
        GrammarAST ACTION20=null;

        try {
            // GrammarTreeVisitor.g:289:2: ( ^( CATCH ARG_ACTION ACTION ) )
            // GrammarTreeVisitor.g:289:4: ^( CATCH ARG_ACTION ACTION )
            {
            match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler793); 

            match(input, Token.DOWN, null); 
            ARG_ACTION19=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler795); 

            ACTION20=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler797); 

            match(input, Token.UP, null); 


            ruleCatch(ARG_ACTION19, (ActionAST)ACTION20);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exceptionHandler"



    // $ANTLR start "finallyClause"
    // GrammarTreeVisitor.g:292:1: finallyClause : ^( FINALLY ACTION ) ;
    public final void finallyClause() throws RecognitionException {
        GrammarAST ACTION21=null;

        try {
            // GrammarTreeVisitor.g:293:2: ( ^( FINALLY ACTION ) )
            // GrammarTreeVisitor.g:293:4: ^( FINALLY ACTION )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause812); 

            match(input, Token.DOWN, null); 
            ACTION21=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_finallyClause814); 

            match(input, Token.UP, null); 


            finallyAction((ActionAST)ACTION21);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "finallyClause"


    public static class locals_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "locals"
    // GrammarTreeVisitor.g:296:1: locals : ^( LOCALS ARG_ACTION ) ;
    public final GrammarTreeVisitor.locals_return locals() throws RecognitionException {
        GrammarTreeVisitor.locals_return retval = new GrammarTreeVisitor.locals_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:297:2: ( ^( LOCALS ARG_ACTION ) )
            // GrammarTreeVisitor.g:297:4: ^( LOCALS ARG_ACTION )
            {
            match(input,LOCALS,FOLLOW_LOCALS_in_locals832); 

            match(input, Token.DOWN, null); 
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_locals834); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "locals"


    public static class ruleReturns_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "ruleReturns"
    // GrammarTreeVisitor.g:300:1: ruleReturns : ^( RETURNS ARG_ACTION ) ;
    public final GrammarTreeVisitor.ruleReturns_return ruleReturns() throws RecognitionException {
        GrammarTreeVisitor.ruleReturns_return retval = new GrammarTreeVisitor.ruleReturns_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:301:2: ( ^( RETURNS ARG_ACTION ) )
            // GrammarTreeVisitor.g:301:4: ^( RETURNS ARG_ACTION )
            {
            match(input,RETURNS,FOLLOW_RETURNS_in_ruleReturns847); 

            match(input, Token.DOWN, null); 
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleReturns849); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleReturns"


    public static class throwsSpec_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "throwsSpec"
    // GrammarTreeVisitor.g:303:1: throwsSpec : ^( THROWS ( ID )+ ) ;
    public final GrammarTreeVisitor.throwsSpec_return throwsSpec() throws RecognitionException {
        GrammarTreeVisitor.throwsSpec_return retval = new GrammarTreeVisitor.throwsSpec_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:304:5: ( ^( THROWS ( ID )+ ) )
            // GrammarTreeVisitor.g:304:7: ^( THROWS ( ID )+ )
            {
            match(input,THROWS,FOLLOW_THROWS_in_throwsSpec864); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:304:16: ( ID )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==ID) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // GrammarTreeVisitor.g:304:16: ID
            	    {
            	    match(input,ID,FOLLOW_ID_in_throwsSpec866); 

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "throwsSpec"


    public static class ruleAction_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "ruleAction"
    // GrammarTreeVisitor.g:307:1: ruleAction : ^( AT ID ACTION ) ;
    public final GrammarTreeVisitor.ruleAction_return ruleAction() throws RecognitionException {
        GrammarTreeVisitor.ruleAction_return retval = new GrammarTreeVisitor.ruleAction_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:308:2: ( ^( AT ID ACTION ) )
            // GrammarTreeVisitor.g:308:4: ^( AT ID ACTION )
            {
            match(input,AT,FOLLOW_AT_in_ruleAction883); 

            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_ruleAction885); 

            match(input,ACTION,FOLLOW_ACTION_in_ruleAction887); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleAction"


    public static class ruleModifier_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "ruleModifier"
    // GrammarTreeVisitor.g:311:1: ruleModifier : ( PUBLIC | PRIVATE | PROTECTED | FRAGMENT );
    public final GrammarTreeVisitor.ruleModifier_return ruleModifier() throws RecognitionException {
        GrammarTreeVisitor.ruleModifier_return retval = new GrammarTreeVisitor.ruleModifier_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:312:5: ( PUBLIC | PRIVATE | PROTECTED | FRAGMENT )
            // GrammarTreeVisitor.g:
            {
            if ( input.LA(1)==FRAGMENT||(input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleModifier"


    public static class lexerRuleBlock_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "lexerRuleBlock"
    // GrammarTreeVisitor.g:318:1: lexerRuleBlock : ^( BLOCK ( lexerOuterAlternative )+ ) ;
    public final GrammarTreeVisitor.lexerRuleBlock_return lexerRuleBlock() throws RecognitionException {
        GrammarTreeVisitor.lexerRuleBlock_return retval = new GrammarTreeVisitor.lexerRuleBlock_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:319:5: ( ^( BLOCK ( lexerOuterAlternative )+ ) )
            // GrammarTreeVisitor.g:319:7: ^( BLOCK ( lexerOuterAlternative )+ )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_lexerRuleBlock945); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:320:7: ( lexerOuterAlternative )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==ALT||LA27_0==LEXER_ALT_ACTION) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // GrammarTreeVisitor.g:320:9: lexerOuterAlternative
            	    {

            	        			currentOuterAltRoot = (GrammarAST)input.LT(1);
            	    				currentOuterAltNumber++;
            	    				

            	    pushFollow(FOLLOW_lexerOuterAlternative_in_lexerRuleBlock964);
            	    lexerOuterAlternative();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerRuleBlock"


    public static class ruleBlock_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "ruleBlock"
    // GrammarTreeVisitor.g:329:1: ruleBlock : ^( BLOCK ( outerAlternative )+ ) ;
    public final GrammarTreeVisitor.ruleBlock_return ruleBlock() throws RecognitionException {
        GrammarTreeVisitor.ruleBlock_return retval = new GrammarTreeVisitor.ruleBlock_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:330:5: ( ^( BLOCK ( outerAlternative )+ ) )
            // GrammarTreeVisitor.g:330:7: ^( BLOCK ( outerAlternative )+ )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_ruleBlock999); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:331:7: ( outerAlternative )+
            int cnt28=0;
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==ALT) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // GrammarTreeVisitor.g:331:9: outerAlternative
            	    {

            	        			currentOuterAltRoot = (GrammarAST)input.LT(1);
            	    				currentOuterAltNumber++;
            	    				

            	    pushFollow(FOLLOW_outerAlternative_in_ruleBlock1018);
            	    outerAlternative();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt28 >= 1 ) break loop28;
                        EarlyExitException eee =
                            new EarlyExitException(28, input);
                        throw eee;
                }
                cnt28++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleBlock"


    public static class lexerOuterAlternative_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "lexerOuterAlternative"
    // GrammarTreeVisitor.g:340:1: lexerOuterAlternative : lexerAlternative ;
    public final GrammarTreeVisitor.lexerOuterAlternative_return lexerOuterAlternative() throws RecognitionException {
        GrammarTreeVisitor.lexerOuterAlternative_return retval = new GrammarTreeVisitor.lexerOuterAlternative_return();
        retval.start = input.LT(1);



        	discoverOuterAlt((AltAST)((GrammarAST)retval.start));

        try {
            // GrammarTreeVisitor.g:347:2: ( lexerAlternative )
            // GrammarTreeVisitor.g:347:4: lexerAlternative
            {
            pushFollow(FOLLOW_lexerAlternative_in_lexerOuterAlternative1058);
            lexerAlternative();

            state._fsp--;


            }


            	finishOuterAlt((AltAST)((GrammarAST)retval.start));

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerOuterAlternative"


    public static class outerAlternative_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "outerAlternative"
    // GrammarTreeVisitor.g:351:1: outerAlternative : alternative ;
    public final GrammarTreeVisitor.outerAlternative_return outerAlternative() throws RecognitionException {
        GrammarTreeVisitor.outerAlternative_return retval = new GrammarTreeVisitor.outerAlternative_return();
        retval.start = input.LT(1);



        	discoverOuterAlt((AltAST)((GrammarAST)retval.start));

        try {
            // GrammarTreeVisitor.g:358:2: ( alternative )
            // GrammarTreeVisitor.g:358:4: alternative
            {
            pushFollow(FOLLOW_alternative_in_outerAlternative1081);
            alternative();

            state._fsp--;


            }


            	finishOuterAlt((AltAST)((GrammarAST)retval.start));

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outerAlternative"



    // $ANTLR start "lexerAlternative"
    // GrammarTreeVisitor.g:361:1: lexerAlternative : ( ^( LEXER_ALT_ACTION lexerElements ( lexerCommand )+ ) | lexerElements );
    public final void lexerAlternative() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:362:2: ( ^( LEXER_ALT_ACTION lexerElements ( lexerCommand )+ ) | lexerElements )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==LEXER_ALT_ACTION) ) {
                alt30=1;
            }
            else if ( (LA30_0==ALT) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }
            switch (alt30) {
                case 1 :
                    // GrammarTreeVisitor.g:362:4: ^( LEXER_ALT_ACTION lexerElements ( lexerCommand )+ )
                    {
                    match(input,LEXER_ALT_ACTION,FOLLOW_LEXER_ALT_ACTION_in_lexerAlternative1094); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lexerElements_in_lexerAlternative1096);
                    lexerElements();

                    state._fsp--;


                    // GrammarTreeVisitor.g:362:37: ( lexerCommand )+
                    int cnt29=0;
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==ID||LA29_0==LEXER_ACTION_CALL) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // GrammarTreeVisitor.g:362:37: lexerCommand
                    	    {
                    	    pushFollow(FOLLOW_lexerCommand_in_lexerAlternative1098);
                    	    lexerCommand();

                    	    state._fsp--;


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


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:363:9: lexerElements
                    {
                    pushFollow(FOLLOW_lexerElements_in_lexerAlternative1110);
                    lexerElements();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerAlternative"



    // $ANTLR start "lexerElements"
    // GrammarTreeVisitor.g:366:1: lexerElements : ^( ALT ( lexerElement )+ ) ;
    public final void lexerElements() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:367:5: ( ^( ALT ( lexerElement )+ ) )
            // GrammarTreeVisitor.g:367:7: ^( ALT ( lexerElement )+ )
            {
            match(input,ALT,FOLLOW_ALT_in_lexerElements1128); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:367:13: ( lexerElement )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==ACTION||LA31_0==ASSIGN||LA31_0==LEXER_CHAR_SET||LA31_0==NOT||LA31_0==PLUS_ASSIGN||LA31_0==RANGE||LA31_0==SEMPRED||LA31_0==STRING_LITERAL||LA31_0==TOKEN_REF||LA31_0==BLOCK||LA31_0==CLOSURE||(LA31_0 >= OPTIONAL && LA31_0 <= POSITIVE_CLOSURE)||LA31_0==SET||LA31_0==WILDCARD) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // GrammarTreeVisitor.g:367:13: lexerElement
            	    {
            	    pushFollow(FOLLOW_lexerElement_in_lexerElements1130);
            	    lexerElement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerElements"



    // $ANTLR start "lexerElement"
    // GrammarTreeVisitor.g:370:1: lexerElement : ( labeledLexerElement | lexerAtom | lexerSubrule | ACTION | SEMPRED | ^( ACTION elementOptions ) | ^( SEMPRED elementOptions ) );
    public final void lexerElement() throws RecognitionException {
        GrammarAST ACTION22=null;
        GrammarAST SEMPRED23=null;
        GrammarAST ACTION24=null;
        GrammarAST SEMPRED25=null;

        try {
            // GrammarTreeVisitor.g:371:2: ( labeledLexerElement | lexerAtom | lexerSubrule | ACTION | SEMPRED | ^( ACTION elementOptions ) | ^( SEMPRED elementOptions ) )
            int alt32=7;
            switch ( input.LA(1) ) {
            case ASSIGN:
            case PLUS_ASSIGN:
                {
                alt32=1;
                }
                break;
            case LEXER_CHAR_SET:
            case NOT:
            case RANGE:
            case STRING_LITERAL:
            case TOKEN_REF:
            case SET:
            case WILDCARD:
                {
                alt32=2;
                }
                break;
            case BLOCK:
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt32=3;
                }
                break;
            case ACTION:
                {
                int LA32_4 = input.LA(2);

                if ( (LA32_4==DOWN) ) {
                    alt32=6;
                }
                else if ( ((LA32_4 >= UP && LA32_4 <= ACTION)||LA32_4==ASSIGN||LA32_4==LEXER_CHAR_SET||LA32_4==NOT||LA32_4==PLUS_ASSIGN||LA32_4==RANGE||LA32_4==SEMPRED||LA32_4==STRING_LITERAL||LA32_4==TOKEN_REF||LA32_4==BLOCK||LA32_4==CLOSURE||(LA32_4 >= OPTIONAL && LA32_4 <= POSITIVE_CLOSURE)||LA32_4==SET||LA32_4==WILDCARD) ) {
                    alt32=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 4, input);

                    throw nvae;

                }
                }
                break;
            case SEMPRED:
                {
                int LA32_5 = input.LA(2);

                if ( (LA32_5==DOWN) ) {
                    alt32=7;
                }
                else if ( ((LA32_5 >= UP && LA32_5 <= ACTION)||LA32_5==ASSIGN||LA32_5==LEXER_CHAR_SET||LA32_5==NOT||LA32_5==PLUS_ASSIGN||LA32_5==RANGE||LA32_5==SEMPRED||LA32_5==STRING_LITERAL||LA32_5==TOKEN_REF||LA32_5==BLOCK||LA32_5==CLOSURE||(LA32_5 >= OPTIONAL && LA32_5 <= POSITIVE_CLOSURE)||LA32_5==SET||LA32_5==WILDCARD) ) {
                    alt32=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 5, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;

            }

            switch (alt32) {
                case 1 :
                    // GrammarTreeVisitor.g:371:4: labeledLexerElement
                    {
                    pushFollow(FOLLOW_labeledLexerElement_in_lexerElement1146);
                    labeledLexerElement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:372:4: lexerAtom
                    {
                    pushFollow(FOLLOW_lexerAtom_in_lexerElement1151);
                    lexerAtom();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:373:4: lexerSubrule
                    {
                    pushFollow(FOLLOW_lexerSubrule_in_lexerElement1156);
                    lexerSubrule();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:374:6: ACTION
                    {
                    ACTION22=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_lexerElement1163); 

                    actionInAlt((ActionAST)ACTION22);

                    }
                    break;
                case 5 :
                    // GrammarTreeVisitor.g:375:6: SEMPRED
                    {
                    SEMPRED23=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_lexerElement1177); 

                    sempredInAlt((PredAST)SEMPRED23);

                    }
                    break;
                case 6 :
                    // GrammarTreeVisitor.g:376:6: ^( ACTION elementOptions )
                    {
                    ACTION24=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_lexerElement1192); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_lexerElement1194);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    actionInAlt((ActionAST)ACTION24);

                    }
                    break;
                case 7 :
                    // GrammarTreeVisitor.g:377:6: ^( SEMPRED elementOptions )
                    {
                    SEMPRED25=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_lexerElement1205); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_lexerElement1207);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    sempredInAlt((PredAST)SEMPRED25);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerElement"



    // $ANTLR start "labeledLexerElement"
    // GrammarTreeVisitor.g:380:1: labeledLexerElement : ^( ( ASSIGN | PLUS_ASSIGN ) ID ( lexerAtom | block ) ) ;
    public final void labeledLexerElement() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:381:5: ( ^( ( ASSIGN | PLUS_ASSIGN ) ID ( lexerAtom | block ) ) )
            // GrammarTreeVisitor.g:381:9: ^( ( ASSIGN | PLUS_ASSIGN ) ID ( lexerAtom | block ) )
            {
            if ( input.LA(1)==ASSIGN||input.LA(1)==PLUS_ASSIGN ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); 
            match(input,ID,FOLLOW_ID_in_labeledLexerElement1233); 

            // GrammarTreeVisitor.g:381:35: ( lexerAtom | block )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==LEXER_CHAR_SET||LA33_0==NOT||LA33_0==RANGE||LA33_0==STRING_LITERAL||LA33_0==TOKEN_REF||LA33_0==SET||LA33_0==WILDCARD) ) {
                alt33=1;
            }
            else if ( (LA33_0==BLOCK) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // GrammarTreeVisitor.g:381:36: lexerAtom
                    {
                    pushFollow(FOLLOW_lexerAtom_in_labeledLexerElement1236);
                    lexerAtom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:381:46: block
                    {
                    pushFollow(FOLLOW_block_in_labeledLexerElement1238);
                    block();

                    state._fsp--;


                    }
                    break;

            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "labeledLexerElement"



    // $ANTLR start "lexerBlock"
    // GrammarTreeVisitor.g:384:1: lexerBlock : ^( BLOCK ( lexerAlternative )+ ) ;
    public final void lexerBlock() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:385:3: ( ^( BLOCK ( lexerAlternative )+ ) )
            // GrammarTreeVisitor.g:385:5: ^( BLOCK ( lexerAlternative )+ )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_lexerBlock1254); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:385:13: ( lexerAlternative )+
            int cnt34=0;
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==ALT||LA34_0==LEXER_ALT_ACTION) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // GrammarTreeVisitor.g:385:13: lexerAlternative
            	    {
            	    pushFollow(FOLLOW_lexerAlternative_in_lexerBlock1256);
            	    lexerAlternative();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt34 >= 1 ) break loop34;
                        EarlyExitException eee =
                            new EarlyExitException(34, input);
                        throw eee;
                }
                cnt34++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerBlock"



    // $ANTLR start "lexerAtom"
    // GrammarTreeVisitor.g:388:1: lexerAtom : ( terminal | ^( NOT blockSet ) | blockSet | ^( WILDCARD elementOptions ) | WILDCARD | LEXER_CHAR_SET | range );
    public final void lexerAtom() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:389:5: ( terminal | ^( NOT blockSet ) | blockSet | ^( WILDCARD elementOptions ) | WILDCARD | LEXER_CHAR_SET | range )
            int alt35=7;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
            case TOKEN_REF:
                {
                alt35=1;
                }
                break;
            case NOT:
                {
                alt35=2;
                }
                break;
            case SET:
                {
                alt35=3;
                }
                break;
            case WILDCARD:
                {
                int LA35_4 = input.LA(2);

                if ( (LA35_4==DOWN) ) {
                    alt35=4;
                }
                else if ( ((LA35_4 >= UP && LA35_4 <= ACTION)||LA35_4==ASSIGN||LA35_4==LEXER_CHAR_SET||LA35_4==NOT||LA35_4==PLUS_ASSIGN||LA35_4==RANGE||LA35_4==SEMPRED||LA35_4==STRING_LITERAL||LA35_4==TOKEN_REF||LA35_4==BLOCK||LA35_4==CLOSURE||(LA35_4 >= OPTIONAL && LA35_4 <= POSITIVE_CLOSURE)||LA35_4==SET||LA35_4==WILDCARD) ) {
                    alt35=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 4, input);

                    throw nvae;

                }
                }
                break;
            case LEXER_CHAR_SET:
                {
                alt35=6;
                }
                break;
            case RANGE:
                {
                alt35=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }

            switch (alt35) {
                case 1 :
                    // GrammarTreeVisitor.g:389:9: terminal
                    {
                    pushFollow(FOLLOW_terminal_in_lexerAtom1277);
                    terminal();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:390:9: ^( NOT blockSet )
                    {
                    match(input,NOT,FOLLOW_NOT_in_lexerAtom1288); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_blockSet_in_lexerAtom1290);
                    blockSet();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:391:9: blockSet
                    {
                    pushFollow(FOLLOW_blockSet_in_lexerAtom1301);
                    blockSet();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:392:9: ^( WILDCARD elementOptions )
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_lexerAtom1312); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_lexerAtom1314);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 5 :
                    // GrammarTreeVisitor.g:393:9: WILDCARD
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_lexerAtom1325); 

                    }
                    break;
                case 6 :
                    // GrammarTreeVisitor.g:394:7: LEXER_CHAR_SET
                    {
                    match(input,LEXER_CHAR_SET,FOLLOW_LEXER_CHAR_SET_in_lexerAtom1333); 

                    }
                    break;
                case 7 :
                    // GrammarTreeVisitor.g:395:9: range
                    {
                    pushFollow(FOLLOW_range_in_lexerAtom1343);
                    range();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerAtom"



    // $ANTLR start "actionElement"
    // GrammarTreeVisitor.g:398:1: actionElement : ( ACTION | ^( ACTION elementOptions ) | SEMPRED | ^( SEMPRED elementOptions ) );
    public final void actionElement() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:399:2: ( ACTION | ^( ACTION elementOptions ) | SEMPRED | ^( SEMPRED elementOptions ) )
            int alt36=4;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==ACTION) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==DOWN) ) {
                    alt36=2;
                }
                else if ( (LA36_1==EOF) ) {
                    alt36=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA36_0==SEMPRED) ) {
                int LA36_2 = input.LA(2);

                if ( (LA36_2==DOWN) ) {
                    alt36=4;
                }
                else if ( (LA36_2==EOF) ) {
                    alt36=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 36, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;

            }
            switch (alt36) {
                case 1 :
                    // GrammarTreeVisitor.g:399:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_actionElement1357); 

                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:400:6: ^( ACTION elementOptions )
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_actionElement1365); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_actionElement1367);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:401:6: SEMPRED
                    {
                    match(input,SEMPRED,FOLLOW_SEMPRED_in_actionElement1375); 

                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:402:6: ^( SEMPRED elementOptions )
                    {
                    match(input,SEMPRED,FOLLOW_SEMPRED_in_actionElement1383); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_actionElement1385);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "actionElement"


    public static class alternative_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "alternative"
    // GrammarTreeVisitor.g:405:1: alternative : ( ^( ALT ( element )+ ) | ^( ALT EPSILON ) );
    public final GrammarTreeVisitor.alternative_return alternative() throws RecognitionException {
        GrammarTreeVisitor.alternative_return retval = new GrammarTreeVisitor.alternative_return();
        retval.start = input.LT(1);



        	discoverAlt((AltAST)((GrammarAST)retval.start));

        try {
            // GrammarTreeVisitor.g:412:2: ( ^( ALT ( element )+ ) | ^( ALT EPSILON ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==ALT) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==DOWN) ) {
                    int LA38_2 = input.LA(3);

                    if ( (LA38_2==EPSILON) ) {
                        alt38=2;
                    }
                    else if ( (LA38_2==ACTION||LA38_2==ASSIGN||LA38_2==DOT||LA38_2==NOT||LA38_2==PLUS_ASSIGN||LA38_2==RULE_REF||LA38_2==SEMPRED||LA38_2==STRING_LITERAL||LA38_2==TOKEN_REF||LA38_2==BLOCK||LA38_2==CLOSURE||(LA38_2 >= OPTIONAL && LA38_2 <= POSITIVE_CLOSURE)||LA38_2==SET||LA38_2==WILDCARD) ) {
                        alt38=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;

            }
            switch (alt38) {
                case 1 :
                    // GrammarTreeVisitor.g:412:4: ^( ALT ( element )+ )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alternative1412); 

                    match(input, Token.DOWN, null); 
                    // GrammarTreeVisitor.g:412:10: ( element )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==ACTION||LA37_0==ASSIGN||LA37_0==DOT||LA37_0==NOT||LA37_0==PLUS_ASSIGN||LA37_0==RULE_REF||LA37_0==SEMPRED||LA37_0==STRING_LITERAL||LA37_0==TOKEN_REF||LA37_0==BLOCK||LA37_0==CLOSURE||(LA37_0 >= OPTIONAL && LA37_0 <= POSITIVE_CLOSURE)||LA37_0==SET||LA37_0==WILDCARD) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // GrammarTreeVisitor.g:412:10: element
                    	    {
                    	    pushFollow(FOLLOW_element_in_alternative1414);
                    	    element();

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt37 >= 1 ) break loop37;
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:413:4: ^( ALT EPSILON )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alternative1422); 

                    match(input, Token.DOWN, null); 
                    match(input,EPSILON,FOLLOW_EPSILON_in_alternative1424); 

                    match(input, Token.UP, null); 


                    }
                    break;

            }

            	finishAlt((AltAST)((GrammarAST)retval.start));

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "alternative"



    // $ANTLR start "lexerCommand"
    // GrammarTreeVisitor.g:416:1: lexerCommand : ( ^( LEXER_ACTION_CALL ID lexerCommandExpr ) | ID );
    public final void lexerCommand() throws RecognitionException {
        GrammarAST ID26=null;
        GrammarAST ID28=null;
        GrammarTreeVisitor.lexerCommandExpr_return lexerCommandExpr27 =null;


        try {
            // GrammarTreeVisitor.g:417:2: ( ^( LEXER_ACTION_CALL ID lexerCommandExpr ) | ID )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==LEXER_ACTION_CALL) ) {
                alt39=1;
            }
            else if ( (LA39_0==ID) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;

            }
            switch (alt39) {
                case 1 :
                    // GrammarTreeVisitor.g:417:4: ^( LEXER_ACTION_CALL ID lexerCommandExpr )
                    {
                    match(input,LEXER_ACTION_CALL,FOLLOW_LEXER_ACTION_CALL_in_lexerCommand1440); 

                    match(input, Token.DOWN, null); 
                    ID26=(GrammarAST)match(input,ID,FOLLOW_ID_in_lexerCommand1442); 

                    pushFollow(FOLLOW_lexerCommandExpr_in_lexerCommand1444);
                    lexerCommandExpr27=lexerCommandExpr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    lexerCallCommand(currentOuterAltNumber, ID26, (lexerCommandExpr27!=null?((GrammarAST)lexerCommandExpr27.start):null));

                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:419:4: ID
                    {
                    ID28=(GrammarAST)match(input,ID,FOLLOW_ID_in_lexerCommand1460); 

                    lexerCommand(currentOuterAltNumber, ID28);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerCommand"


    public static class lexerCommandExpr_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "lexerCommandExpr"
    // GrammarTreeVisitor.g:423:1: lexerCommandExpr : ( ID | INT );
    public final GrammarTreeVisitor.lexerCommandExpr_return lexerCommandExpr() throws RecognitionException {
        GrammarTreeVisitor.lexerCommandExpr_return retval = new GrammarTreeVisitor.lexerCommandExpr_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:424:2: ( ID | INT )
            // GrammarTreeVisitor.g:
            {
            if ( input.LA(1)==ID||input.LA(1)==INT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "lexerCommandExpr"


    public static class element_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "element"
    // GrammarTreeVisitor.g:428:1: element : ( labeledElement | atom | subrule | ACTION | SEMPRED | ^( ACTION elementOptions ) | ^( SEMPRED elementOptions ) | ^( NOT blockSet ) | ^( NOT block ) );
    public final GrammarTreeVisitor.element_return element() throws RecognitionException {
        GrammarTreeVisitor.element_return retval = new GrammarTreeVisitor.element_return();
        retval.start = input.LT(1);


        GrammarAST ACTION29=null;
        GrammarAST SEMPRED30=null;
        GrammarAST ACTION31=null;
        GrammarAST SEMPRED32=null;

        try {
            // GrammarTreeVisitor.g:429:2: ( labeledElement | atom | subrule | ACTION | SEMPRED | ^( ACTION elementOptions ) | ^( SEMPRED elementOptions ) | ^( NOT blockSet ) | ^( NOT block ) )
            int alt40=9;
            switch ( input.LA(1) ) {
            case ASSIGN:
            case PLUS_ASSIGN:
                {
                alt40=1;
                }
                break;
            case DOT:
            case RULE_REF:
            case STRING_LITERAL:
            case TOKEN_REF:
            case SET:
            case WILDCARD:
                {
                alt40=2;
                }
                break;
            case BLOCK:
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt40=3;
                }
                break;
            case ACTION:
                {
                int LA40_4 = input.LA(2);

                if ( (LA40_4==DOWN) ) {
                    alt40=6;
                }
                else if ( ((LA40_4 >= UP && LA40_4 <= ACTION)||LA40_4==ASSIGN||LA40_4==DOT||LA40_4==NOT||LA40_4==PLUS_ASSIGN||LA40_4==RULE_REF||LA40_4==SEMPRED||LA40_4==STRING_LITERAL||LA40_4==TOKEN_REF||LA40_4==BLOCK||LA40_4==CLOSURE||(LA40_4 >= OPTIONAL && LA40_4 <= POSITIVE_CLOSURE)||LA40_4==SET||LA40_4==WILDCARD) ) {
                    alt40=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 4, input);

                    throw nvae;

                }
                }
                break;
            case SEMPRED:
                {
                int LA40_5 = input.LA(2);

                if ( (LA40_5==DOWN) ) {
                    alt40=7;
                }
                else if ( ((LA40_5 >= UP && LA40_5 <= ACTION)||LA40_5==ASSIGN||LA40_5==DOT||LA40_5==NOT||LA40_5==PLUS_ASSIGN||LA40_5==RULE_REF||LA40_5==SEMPRED||LA40_5==STRING_LITERAL||LA40_5==TOKEN_REF||LA40_5==BLOCK||LA40_5==CLOSURE||(LA40_5 >= OPTIONAL && LA40_5 <= POSITIVE_CLOSURE)||LA40_5==SET||LA40_5==WILDCARD) ) {
                    alt40=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 5, input);

                    throw nvae;

                }
                }
                break;
            case NOT:
                {
                int LA40_6 = input.LA(2);

                if ( (LA40_6==DOWN) ) {
                    int LA40_11 = input.LA(3);

                    if ( (LA40_11==SET) ) {
                        alt40=8;
                    }
                    else if ( (LA40_11==BLOCK) ) {
                        alt40=9;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 11, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 40, 6, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;

            }

            switch (alt40) {
                case 1 :
                    // GrammarTreeVisitor.g:429:4: labeledElement
                    {
                    pushFollow(FOLLOW_labeledElement_in_element1499);
                    labeledElement();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:430:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_element1504);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:431:4: subrule
                    {
                    pushFollow(FOLLOW_subrule_in_element1509);
                    subrule();

                    state._fsp--;


                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:432:6: ACTION
                    {
                    ACTION29=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element1516); 

                    actionInAlt((ActionAST)ACTION29);

                    }
                    break;
                case 5 :
                    // GrammarTreeVisitor.g:433:6: SEMPRED
                    {
                    SEMPRED30=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1530); 

                    sempredInAlt((PredAST)SEMPRED30);

                    }
                    break;
                case 6 :
                    // GrammarTreeVisitor.g:434:6: ^( ACTION elementOptions )
                    {
                    ACTION31=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element1545); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_element1547);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    actionInAlt((ActionAST)ACTION31);

                    }
                    break;
                case 7 :
                    // GrammarTreeVisitor.g:435:6: ^( SEMPRED elementOptions )
                    {
                    SEMPRED32=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element1558); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_element1560);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    sempredInAlt((PredAST)SEMPRED32);

                    }
                    break;
                case 8 :
                    // GrammarTreeVisitor.g:437:4: ^( NOT blockSet )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element1571); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_blockSet_in_element1573);
                    blockSet();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 9 :
                    // GrammarTreeVisitor.g:438:4: ^( NOT block )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element1580); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_element1582);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "element"



    // $ANTLR start "astOperand"
    // GrammarTreeVisitor.g:441:1: astOperand : ( atom | ^( NOT blockSet ) | ^( NOT block ) );
    public final void astOperand() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:442:2: ( atom | ^( NOT blockSet ) | ^( NOT block ) )
            int alt41=3;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==DOT||LA41_0==RULE_REF||LA41_0==STRING_LITERAL||LA41_0==TOKEN_REF||LA41_0==SET||LA41_0==WILDCARD) ) {
                alt41=1;
            }
            else if ( (LA41_0==NOT) ) {
                int LA41_2 = input.LA(2);

                if ( (LA41_2==DOWN) ) {
                    int LA41_3 = input.LA(3);

                    if ( (LA41_3==SET) ) {
                        alt41=2;
                    }
                    else if ( (LA41_3==BLOCK) ) {
                        alt41=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 41, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;

            }
            switch (alt41) {
                case 1 :
                    // GrammarTreeVisitor.g:442:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_astOperand1594);
                    atom();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:443:4: ^( NOT blockSet )
                    {
                    match(input,NOT,FOLLOW_NOT_in_astOperand1600); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_blockSet_in_astOperand1602);
                    blockSet();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:444:4: ^( NOT block )
                    {
                    match(input,NOT,FOLLOW_NOT_in_astOperand1609); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_astOperand1611);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "astOperand"


    public static class labeledElement_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "labeledElement"
    // GrammarTreeVisitor.g:447:1: labeledElement : ^( ( ASSIGN | PLUS_ASSIGN ) ID element ) ;
    public final GrammarTreeVisitor.labeledElement_return labeledElement() throws RecognitionException {
        GrammarTreeVisitor.labeledElement_return retval = new GrammarTreeVisitor.labeledElement_return();
        retval.start = input.LT(1);


        GrammarAST ID33=null;
        GrammarTreeVisitor.element_return element34 =null;


        try {
            // GrammarTreeVisitor.g:448:2: ( ^( ( ASSIGN | PLUS_ASSIGN ) ID element ) )
            // GrammarTreeVisitor.g:448:4: ^( ( ASSIGN | PLUS_ASSIGN ) ID element )
            {
            if ( input.LA(1)==ASSIGN||input.LA(1)==PLUS_ASSIGN ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            match(input, Token.DOWN, null); 
            ID33=(GrammarAST)match(input,ID,FOLLOW_ID_in_labeledElement1630); 

            pushFollow(FOLLOW_element_in_labeledElement1632);
            element34=element();

            state._fsp--;


            match(input, Token.UP, null); 


            label(((GrammarAST)retval.start), ID33, (element34!=null?((GrammarAST)element34.start):null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "labeledElement"



    // $ANTLR start "subrule"
    // GrammarTreeVisitor.g:451:1: subrule : ( ^( blockSuffix block ) | block );
    public final void subrule() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:452:2: ( ^( blockSuffix block ) | block )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==CLOSURE||(LA42_0 >= OPTIONAL && LA42_0 <= POSITIVE_CLOSURE)) ) {
                alt42=1;
            }
            else if ( (LA42_0==BLOCK) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;

            }
            switch (alt42) {
                case 1 :
                    // GrammarTreeVisitor.g:452:4: ^( blockSuffix block )
                    {
                    pushFollow(FOLLOW_blockSuffix_in_subrule1647);
                    blockSuffix();

                    state._fsp--;


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_subrule1649);
                    block();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:453:5: block
                    {
                    pushFollow(FOLLOW_block_in_subrule1656);
                    block();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "subrule"



    // $ANTLR start "lexerSubrule"
    // GrammarTreeVisitor.g:456:1: lexerSubrule : ( ^( blockSuffix lexerBlock ) | lexerBlock );
    public final void lexerSubrule() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:457:2: ( ^( blockSuffix lexerBlock ) | lexerBlock )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==CLOSURE||(LA43_0 >= OPTIONAL && LA43_0 <= POSITIVE_CLOSURE)) ) {
                alt43=1;
            }
            else if ( (LA43_0==BLOCK) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }
            switch (alt43) {
                case 1 :
                    // GrammarTreeVisitor.g:457:4: ^( blockSuffix lexerBlock )
                    {
                    pushFollow(FOLLOW_blockSuffix_in_lexerSubrule1671);
                    blockSuffix();

                    state._fsp--;


                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_lexerBlock_in_lexerSubrule1673);
                    lexerBlock();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:458:5: lexerBlock
                    {
                    pushFollow(FOLLOW_lexerBlock_in_lexerSubrule1680);
                    lexerBlock();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "lexerSubrule"



    // $ANTLR start "blockSuffix"
    // GrammarTreeVisitor.g:461:1: blockSuffix : ebnfSuffix ;
    public final void blockSuffix() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:462:5: ( ebnfSuffix )
            // GrammarTreeVisitor.g:462:7: ebnfSuffix
            {
            pushFollow(FOLLOW_ebnfSuffix_in_blockSuffix1697);
            ebnfSuffix();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "blockSuffix"



    // $ANTLR start "ebnfSuffix"
    // GrammarTreeVisitor.g:465:1: ebnfSuffix : ( OPTIONAL | CLOSURE | POSITIVE_CLOSURE );
    public final void ebnfSuffix() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:466:2: ( OPTIONAL | CLOSURE | POSITIVE_CLOSURE )
            // GrammarTreeVisitor.g:
            {
            if ( input.LA(1)==CLOSURE||(input.LA(1) >= OPTIONAL && input.LA(1) <= POSITIVE_CLOSURE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ebnfSuffix"



    // $ANTLR start "atom"
    // GrammarTreeVisitor.g:471:1: atom : ( ^( DOT ID terminal ) | ^( DOT ID ruleref ) | ^( WILDCARD elementOptions ) | WILDCARD | terminal | blockSet | ruleref );
    public final void atom() throws RecognitionException {
        GrammarAST WILDCARD35=null;
        GrammarAST WILDCARD36=null;

        try {
            // GrammarTreeVisitor.g:471:5: ( ^( DOT ID terminal ) | ^( DOT ID ruleref ) | ^( WILDCARD elementOptions ) | WILDCARD | terminal | blockSet | ruleref )
            int alt44=7;
            switch ( input.LA(1) ) {
            case DOT:
                {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==DOWN) ) {
                    int LA44_6 = input.LA(3);

                    if ( (LA44_6==ID) ) {
                        int LA44_9 = input.LA(4);

                        if ( (LA44_9==STRING_LITERAL||LA44_9==TOKEN_REF) ) {
                            alt44=1;
                        }
                        else if ( (LA44_9==RULE_REF) ) {
                            alt44=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 44, 9, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 44, 6, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;

                }
                }
                break;
            case WILDCARD:
                {
                int LA44_2 = input.LA(2);

                if ( (LA44_2==DOWN) ) {
                    alt44=3;
                }
                else if ( (LA44_2==EOF||(LA44_2 >= UP && LA44_2 <= ACTION)||LA44_2==ASSIGN||LA44_2==DOT||LA44_2==NOT||LA44_2==PLUS_ASSIGN||LA44_2==RULE_REF||LA44_2==SEMPRED||LA44_2==STRING_LITERAL||LA44_2==TOKEN_REF||LA44_2==BLOCK||LA44_2==CLOSURE||(LA44_2 >= OPTIONAL && LA44_2 <= POSITIVE_CLOSURE)||LA44_2==SET||LA44_2==WILDCARD) ) {
                    alt44=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 2, input);

                    throw nvae;

                }
                }
                break;
            case STRING_LITERAL:
            case TOKEN_REF:
                {
                alt44=5;
                }
                break;
            case SET:
                {
                alt44=6;
                }
                break;
            case RULE_REF:
                {
                alt44=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;

            }

            switch (alt44) {
                case 1 :
                    // GrammarTreeVisitor.g:471:7: ^( DOT ID terminal )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1736); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_atom1738); 

                    pushFollow(FOLLOW_terminal_in_atom1740);
                    terminal();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:472:4: ^( DOT ID ruleref )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1747); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_atom1749); 

                    pushFollow(FOLLOW_ruleref_in_atom1751);
                    ruleref();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:473:7: ^( WILDCARD elementOptions )
                    {
                    WILDCARD35=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1761); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_atom1763);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    wildcardRef(WILDCARD35);

                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:474:7: WILDCARD
                    {
                    WILDCARD36=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1774); 

                    wildcardRef(WILDCARD36);

                    }
                    break;
                case 5 :
                    // GrammarTreeVisitor.g:475:9: terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom1790);
                    terminal();

                    state._fsp--;


                    }
                    break;
                case 6 :
                    // GrammarTreeVisitor.g:476:7: blockSet
                    {
                    pushFollow(FOLLOW_blockSet_in_atom1798);
                    blockSet();

                    state._fsp--;


                    }
                    break;
                case 7 :
                    // GrammarTreeVisitor.g:477:9: ruleref
                    {
                    pushFollow(FOLLOW_ruleref_in_atom1808);
                    ruleref();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "atom"



    // $ANTLR start "blockSet"
    // GrammarTreeVisitor.g:480:1: blockSet : ^( SET ( setElement )+ ) ;
    public final void blockSet() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:481:2: ( ^( SET ( setElement )+ ) )
            // GrammarTreeVisitor.g:481:4: ^( SET ( setElement )+ )
            {
            match(input,SET,FOLLOW_SET_in_blockSet1823); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:481:10: ( setElement )+
            int cnt45=0;
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==LEXER_CHAR_SET||LA45_0==RANGE||LA45_0==STRING_LITERAL||LA45_0==TOKEN_REF) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // GrammarTreeVisitor.g:481:10: setElement
            	    {
            	    pushFollow(FOLLOW_setElement_in_blockSet1825);
            	    setElement();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt45 >= 1 ) break loop45;
                        EarlyExitException eee =
                            new EarlyExitException(45, input);
                        throw eee;
                }
                cnt45++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "blockSet"



    // $ANTLR start "setElement"
    // GrammarTreeVisitor.g:484:1: setElement : ( STRING_LITERAL | TOKEN_REF | ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) | LEXER_CHAR_SET );
    public final void setElement() throws RecognitionException {
        GrammarAST a=null;
        GrammarAST b=null;
        GrammarAST STRING_LITERAL37=null;
        GrammarAST TOKEN_REF38=null;

        try {
            // GrammarTreeVisitor.g:485:2: ( STRING_LITERAL | TOKEN_REF | ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) | LEXER_CHAR_SET )
            int alt46=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt46=1;
                }
                break;
            case TOKEN_REF:
                {
                alt46=2;
                }
                break;
            case RANGE:
                {
                alt46=3;
                }
                break;
            case LEXER_CHAR_SET:
                {
                alt46=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;

            }

            switch (alt46) {
                case 1 :
                    // GrammarTreeVisitor.g:485:4: STRING_LITERAL
                    {
                    STRING_LITERAL37=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement1838); 

                    stringRef((TerminalAST)STRING_LITERAL37);

                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:486:4: TOKEN_REF
                    {
                    TOKEN_REF38=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_setElement1845); 

                    tokenRef((TerminalAST)TOKEN_REF38);

                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:487:4: ^( RANGE a= STRING_LITERAL b= STRING_LITERAL )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_setElement1854); 

                    match(input, Token.DOWN, null); 
                    a=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement1858); 

                    b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement1862); 

                    match(input, Token.UP, null); 



                    		stringRef((TerminalAST)a);
                    		stringRef((TerminalAST)b);
                    		

                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:492:17: LEXER_CHAR_SET
                    {
                    match(input,LEXER_CHAR_SET,FOLLOW_LEXER_CHAR_SET_in_setElement1885); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "setElement"



    // $ANTLR start "block"
    // GrammarTreeVisitor.g:495:1: block : ^( BLOCK ( optionsSpec )? ( ruleAction )* ( ACTION )? ( alternative )+ ) ;
    public final void block() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:496:5: ( ^( BLOCK ( optionsSpec )? ( ruleAction )* ( ACTION )? ( alternative )+ ) )
            // GrammarTreeVisitor.g:496:7: ^( BLOCK ( optionsSpec )? ( ruleAction )* ( ACTION )? ( alternative )+ )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block1900); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:496:15: ( optionsSpec )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==OPTIONS) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // GrammarTreeVisitor.g:496:15: optionsSpec
                    {
                    pushFollow(FOLLOW_optionsSpec_in_block1902);
                    optionsSpec();

                    state._fsp--;


                    }
                    break;

            }


            // GrammarTreeVisitor.g:496:28: ( ruleAction )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==AT) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // GrammarTreeVisitor.g:496:28: ruleAction
            	    {
            	    pushFollow(FOLLOW_ruleAction_in_block1905);
            	    ruleAction();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            // GrammarTreeVisitor.g:496:40: ( ACTION )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==ACTION) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // GrammarTreeVisitor.g:496:40: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_block1908); 

                    }
                    break;

            }


            // GrammarTreeVisitor.g:496:48: ( alternative )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==ALT) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // GrammarTreeVisitor.g:496:48: alternative
            	    {
            	    pushFollow(FOLLOW_alternative_in_block1911);
            	    alternative();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "block"



    // $ANTLR start "ruleref"
    // GrammarTreeVisitor.g:499:1: ruleref : ^( RULE_REF (arg= ARG_ACTION )? ) ;
    public final void ruleref() throws RecognitionException {
        GrammarAST arg=null;
        GrammarAST RULE_REF39=null;

        try {
            // GrammarTreeVisitor.g:500:5: ( ^( RULE_REF (arg= ARG_ACTION )? ) )
            // GrammarTreeVisitor.g:500:7: ^( RULE_REF (arg= ARG_ACTION )? )
            {
            RULE_REF39=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_ruleref1931); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // GrammarTreeVisitor.g:500:21: (arg= ARG_ACTION )?
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==ARG_ACTION) ) {
                    alt51=1;
                }
                switch (alt51) {
                    case 1 :
                        // GrammarTreeVisitor.g:500:21: arg= ARG_ACTION
                        {
                        arg=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleref1935); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }



                	ruleRef(RULE_REF39, (ActionAST)arg);
                	if ( arg!=null ) actionInAlt((ActionAST)arg);
                	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ruleref"



    // $ANTLR start "range"
    // GrammarTreeVisitor.g:507:1: range : ^( RANGE STRING_LITERAL STRING_LITERAL ) ;
    public final void range() throws RecognitionException {
        try {
            // GrammarTreeVisitor.g:508:5: ( ^( RANGE STRING_LITERAL STRING_LITERAL ) )
            // GrammarTreeVisitor.g:508:7: ^( RANGE STRING_LITERAL STRING_LITERAL )
            {
            match(input,RANGE,FOLLOW_RANGE_in_range1962); 

            match(input, Token.DOWN, null); 
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range1964); 

            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range1966); 

            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "range"



    // $ANTLR start "terminal"
    // GrammarTreeVisitor.g:511:1: terminal : ( ^( STRING_LITERAL elementOptions ) | STRING_LITERAL | ^( TOKEN_REF elementOptions ) | TOKEN_REF );
    public final void terminal() throws RecognitionException {
        GrammarAST STRING_LITERAL40=null;
        GrammarAST STRING_LITERAL41=null;
        GrammarAST TOKEN_REF42=null;
        GrammarAST TOKEN_REF43=null;

        try {
            // GrammarTreeVisitor.g:512:5: ( ^( STRING_LITERAL elementOptions ) | STRING_LITERAL | ^( TOKEN_REF elementOptions ) | TOKEN_REF )
            int alt52=4;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==STRING_LITERAL) ) {
                int LA52_1 = input.LA(2);

                if ( (LA52_1==DOWN) ) {
                    alt52=1;
                }
                else if ( (LA52_1==EOF||(LA52_1 >= UP && LA52_1 <= ACTION)||LA52_1==ASSIGN||LA52_1==DOT||LA52_1==LEXER_CHAR_SET||LA52_1==NOT||LA52_1==PLUS_ASSIGN||LA52_1==RANGE||LA52_1==RULE_REF||LA52_1==SEMPRED||LA52_1==STRING_LITERAL||LA52_1==TOKEN_REF||LA52_1==BLOCK||LA52_1==CLOSURE||(LA52_1 >= OPTIONAL && LA52_1 <= POSITIVE_CLOSURE)||LA52_1==SET||LA52_1==WILDCARD) ) {
                    alt52=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA52_0==TOKEN_REF) ) {
                int LA52_2 = input.LA(2);

                if ( (LA52_2==DOWN) ) {
                    alt52=3;
                }
                else if ( (LA52_2==EOF||(LA52_2 >= UP && LA52_2 <= ACTION)||LA52_2==ASSIGN||LA52_2==DOT||LA52_2==LEXER_CHAR_SET||LA52_2==NOT||LA52_2==PLUS_ASSIGN||LA52_2==RANGE||LA52_2==RULE_REF||LA52_2==SEMPRED||LA52_2==STRING_LITERAL||LA52_2==TOKEN_REF||LA52_2==BLOCK||LA52_2==CLOSURE||(LA52_2 >= OPTIONAL && LA52_2 <= POSITIVE_CLOSURE)||LA52_2==SET||LA52_2==WILDCARD) ) {
                    alt52=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 52, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;

            }
            switch (alt52) {
                case 1 :
                    // GrammarTreeVisitor.g:512:8: ^( STRING_LITERAL elementOptions )
                    {
                    STRING_LITERAL40=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal1986); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_terminal1988);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    stringRef((TerminalAST)STRING_LITERAL40);

                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:514:7: STRING_LITERAL
                    {
                    STRING_LITERAL41=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal2011); 

                    stringRef((TerminalAST)STRING_LITERAL41);

                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:515:7: ^( TOKEN_REF elementOptions )
                    {
                    TOKEN_REF42=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal2025); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_terminal2027);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    tokenRef((TerminalAST)TOKEN_REF42);

                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:516:7: TOKEN_REF
                    {
                    TOKEN_REF43=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal2038); 

                    tokenRef((TerminalAST)TOKEN_REF43);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "terminal"


    public static class elementOptions_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "elementOptions"
    // GrammarTreeVisitor.g:519:1: elementOptions : ^( ELEMENT_OPTIONS ( elementOption[(GrammarASTWithOptions)$start.getParent()] )+ ) ;
    public final GrammarTreeVisitor.elementOptions_return elementOptions() throws RecognitionException {
        GrammarTreeVisitor.elementOptions_return retval = new GrammarTreeVisitor.elementOptions_return();
        retval.start = input.LT(1);


        try {
            // GrammarTreeVisitor.g:520:5: ( ^( ELEMENT_OPTIONS ( elementOption[(GrammarASTWithOptions)$start.getParent()] )+ ) )
            // GrammarTreeVisitor.g:520:7: ^( ELEMENT_OPTIONS ( elementOption[(GrammarASTWithOptions)$start.getParent()] )+ )
            {
            match(input,ELEMENT_OPTIONS,FOLLOW_ELEMENT_OPTIONS_in_elementOptions2065); 

            match(input, Token.DOWN, null); 
            // GrammarTreeVisitor.g:520:25: ( elementOption[(GrammarASTWithOptions)$start.getParent()] )+
            int cnt53=0;
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==ASSIGN||LA53_0==ID) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // GrammarTreeVisitor.g:520:25: elementOption[(GrammarASTWithOptions)$start.getParent()]
            	    {
            	    pushFollow(FOLLOW_elementOption_in_elementOptions2067);
            	    elementOption((GrammarASTWithOptions)((GrammarAST)retval.start).getParent());

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt53 >= 1 ) break loop53;
                        EarlyExitException eee =
                            new EarlyExitException(53, input);
                        throw eee;
                }
                cnt53++;
            } while (true);


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "elementOptions"



    // $ANTLR start "elementOption"
    // GrammarTreeVisitor.g:523:1: elementOption[GrammarASTWithOptions t] : ( ID | ^( ASSIGN id= ID v= ID ) | ^( ASSIGN ID v= STRING_LITERAL ) | ^( ASSIGN ID v= ACTION ) );
    public final void elementOption(GrammarASTWithOptions t) throws RecognitionException {
        GrammarAST id=null;
        GrammarAST v=null;
        GrammarAST ID44=null;
        GrammarAST ID45=null;
        GrammarAST ID46=null;

        try {
            // GrammarTreeVisitor.g:524:5: ( ID | ^( ASSIGN id= ID v= ID ) | ^( ASSIGN ID v= STRING_LITERAL ) | ^( ASSIGN ID v= ACTION ) )
            int alt54=4;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==ID) ) {
                alt54=1;
            }
            else if ( (LA54_0==ASSIGN) ) {
                int LA54_2 = input.LA(2);

                if ( (LA54_2==DOWN) ) {
                    int LA54_3 = input.LA(3);

                    if ( (LA54_3==ID) ) {
                        switch ( input.LA(4) ) {
                        case ID:
                            {
                            alt54=2;
                            }
                            break;
                        case STRING_LITERAL:
                            {
                            alt54=3;
                            }
                            break;
                        case ACTION:
                            {
                            alt54=4;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 54, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 54, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;

            }
            switch (alt54) {
                case 1 :
                    // GrammarTreeVisitor.g:524:7: ID
                    {
                    ID44=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption2088); 

                    elementOption(t, ID44, null);

                    }
                    break;
                case 2 :
                    // GrammarTreeVisitor.g:525:9: ^( ASSIGN id= ID v= ID )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption2108); 

                    match(input, Token.DOWN, null); 
                    id=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption2112); 

                    v=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption2116); 

                    match(input, Token.UP, null); 


                    elementOption(t, id, v);

                    }
                    break;
                case 3 :
                    // GrammarTreeVisitor.g:526:9: ^( ASSIGN ID v= STRING_LITERAL )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption2132); 

                    match(input, Token.DOWN, null); 
                    ID45=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption2134); 

                    v=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_elementOption2138); 

                    match(input, Token.UP, null); 


                    elementOption(t, ID45, v);

                    }
                    break;
                case 4 :
                    // GrammarTreeVisitor.g:527:9: ^( ASSIGN ID v= ACTION )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption2152); 

                    match(input, Token.DOWN, null); 
                    ID46=(GrammarAST)match(input,ID,FOLLOW_ID_in_elementOption2154); 

                    v=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_elementOption2158); 

                    match(input, Token.UP, null); 


                    elementOption(t, ID46, v);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "elementOption"

    // Delegated rules


 

    public static final BitSet FOLLOW_GRAMMAR_in_grammarSpec75 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_grammarSpec77 = new BitSet(new long[]{0x0000040020020800L,0x0000000020000001L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_grammarSpec81 = new BitSet(new long[]{0x0000040020000800L,0x0000000020000001L});
    public static final BitSet FOLLOW_prequelConstructs_in_grammarSpec99 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_rules_in_grammarSpec116 = new BitSet(new long[]{0x0000001000000008L});
    public static final BitSet FOLLOW_mode_in_grammarSpec118 = new BitSet(new long[]{0x0000001000000008L});
    public static final BitSet FOLLOW_prequelConstruct_in_prequelConstructs150 = new BitSet(new long[]{0x0000040020000802L,0x0000000000000001L});
    public static final BitSet FOLLOW_optionsSpec_in_prequelConstruct167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delegateGrammars_in_prequelConstruct177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_tokensSpec_in_prequelConstruct187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_action_in_prequelConstruct197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONS_in_optionsSpec212 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_option_in_optionsSpec214 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_ASSIGN_in_option243 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_option245 = new BitSet(new long[]{0x4000000050000000L});
    public static final BitSet FOLLOW_optionValue_in_option249 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IMPORT_in_delegateGrammars322 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_delegateGrammar_in_delegateGrammars324 = new BitSet(new long[]{0x0000000010000408L});
    public static final BitSet FOLLOW_ASSIGN_in_delegateGrammar343 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_delegateGrammar347 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ID_in_delegateGrammar351 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_delegateGrammar366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKENS_SPEC_in_tokensSpec390 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_tokenSpec_in_tokensSpec392 = new BitSet(new long[]{0x0000000010000408L});
    public static final BitSet FOLLOW_ASSIGN_in_tokenSpec406 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_tokenSpec408 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_tokenSpec410 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_tokenSpec418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AT_in_action438 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_action442 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ID_in_action447 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_action449 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULES_in_rules467 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_rule_in_rules472 = new BitSet(new long[]{0x0000000000000008L,0x0000000004000000L});
    public static final BitSet FOLLOW_lexerRule_in_rules474 = new BitSet(new long[]{0x0000000000000008L,0x0000000004000000L});
    public static final BitSet FOLLOW_MODE_in_mode494 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_mode496 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_lexerRule_in_mode500 = new BitSet(new long[]{0x0000000000000008L,0x0000000004000000L});
    public static final BitSet FOLLOW_RULE_in_lexerRule520 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_lexerRule522 = new BitSet(new long[]{0x0000000000020000L,0x0000000010000400L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_lexerRule532 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000400L});
    public static final BitSet FOLLOW_RULEMODIFIERS_in_lexerRule537 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_FRAGMENT_in_lexerRule541 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_lexerRuleBlock_in_lexerRule566 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RULE_in_rule606 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_REF_in_rule608 = new BitSet(new long[]{0x8080040200020900L,0x0000000010000400L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_rule615 = new BitSet(new long[]{0x8080040200000900L,0x0000000010000400L});
    public static final BitSet FOLLOW_RULEMODIFIERS_in_rule620 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ruleModifier_in_rule625 = new BitSet(new long[]{0x0007000001000008L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rule636 = new BitSet(new long[]{0x8080040200000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleReturns_in_rule649 = new BitSet(new long[]{0x8000040200000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_throwsSpec_in_rule662 = new BitSet(new long[]{0x0000040200000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_locals_in_rule675 = new BitSet(new long[]{0x0000040000000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_optionsSpec_in_rule690 = new BitSet(new long[]{0x0000040000000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleAction_in_rule704 = new BitSet(new long[]{0x0000040000000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleBlock_in_rule735 = new BitSet(new long[]{0x0000000000801008L});
    public static final BitSet FOLLOW_exceptionGroup_in_rule737 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup774 = new BitSet(new long[]{0x0000000000801002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler793 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler795 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler797 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause812 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause814 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_locals832 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_locals834 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RETURNS_in_ruleReturns847 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleReturns849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_THROWS_in_throwsSpec864 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_throwsSpec866 = new BitSet(new long[]{0x0000000010000008L});
    public static final BitSet FOLLOW_AT_in_ruleAction883 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_ruleAction885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_ruleAction887 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_lexerRuleBlock945 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lexerOuterAlternative_in_lexerRuleBlock964 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080040L});
    public static final BitSet FOLLOW_BLOCK_in_ruleBlock999 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_outerAlternative_in_ruleBlock1018 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});
    public static final BitSet FOLLOW_lexerAlternative_in_lexerOuterAlternative1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alternative_in_outerAlternative1081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_ALT_ACTION_in_lexerAlternative1094 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lexerElements_in_lexerAlternative1096 = new BitSet(new long[]{0x0000000010000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_lexerCommand_in_lexerAlternative1098 = new BitSet(new long[]{0x0000000010000008L,0x0000000000040000L});
    public static final BitSet FOLLOW_lexerElements_in_lexerAlternative1110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_lexerElements1128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lexerElement_in_lexerElements1130 = new BitSet(new long[]{0x4810408100000418L,0x0000000140601402L});
    public static final BitSet FOLLOW_labeledLexerElement_in_lexerElement1146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerAtom_in_lexerElement1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_lexerSubrule_in_lexerElement1156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_lexerElement1163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_lexerElement1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_lexerElement1192 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_lexerElement1194 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEMPRED_in_lexerElement1205 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_lexerElement1207 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_labeledLexerElement1227 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledLexerElement1233 = new BitSet(new long[]{0x4010008100000000L,0x0000000140000402L});
    public static final BitSet FOLLOW_lexerAtom_in_labeledLexerElement1236 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_labeledLexerElement1238 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_lexerBlock1254 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lexerAlternative_in_lexerBlock1256 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080040L});
    public static final BitSet FOLLOW_terminal_in_lexerAtom1277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_lexerAtom1288 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_blockSet_in_lexerAtom1290 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_blockSet_in_lexerAtom1301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WILDCARD_in_lexerAtom1312 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_lexerAtom1314 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WILDCARD_in_lexerAtom1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_lexerAtom1333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_lexerAtom1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_actionElement1357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_actionElement1365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_actionElement1367 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEMPRED_in_actionElement1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_actionElement1383 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_actionElement1385 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative1412 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative1414 = new BitSet(new long[]{0x4A00408000080418L,0x0000000140601402L});
    public static final BitSet FOLLOW_ALT_in_alternative1422 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_alternative1424 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEXER_ACTION_CALL_in_lexerCommand1440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_lexerCommand1442 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_lexerCommandExpr_in_lexerCommand1444 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_lexerCommand1460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labeledElement_in_element1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element1504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrule_in_element1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element1530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element1545 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_element1547 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEMPRED_in_element1558 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_element1560 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_element1571 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_blockSet_in_element1573 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_element1580 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_element1582 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_astOperand1594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_astOperand1600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_blockSet_in_astOperand1602 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NOT_in_astOperand1609 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_astOperand1611 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_labeledElement1624 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledElement1630 = new BitSet(new long[]{0x4A00408000080410L,0x0000000140601402L});
    public static final BitSet FOLLOW_element_in_labeledElement1632 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_blockSuffix_in_subrule1647 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_subrule1649 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_subrule1656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockSuffix_in_lexerSubrule1671 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_lexerBlock_in_lexerSubrule1673 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_lexerBlock_in_lexerSubrule1680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_blockSuffix1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom1736 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1738 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom1740 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_atom1747 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1749 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ruleref_in_atom1751 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1761 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_atom1763 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom1790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockSet_in_atom1798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_atom1808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_blockSet1823 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_setElement_in_blockSet1825 = new BitSet(new long[]{0x4010000100000008L,0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement1845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_setElement1854 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1858 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement1862 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_setElement1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block1900 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_optionsSpec_in_block1902 = new BitSet(new long[]{0x0000000000000810L,0x0000000000000040L});
    public static final BitSet FOLLOW_ruleAction_in_block1905 = new BitSet(new long[]{0x0000000000000810L,0x0000000000000040L});
    public static final BitSet FOLLOW_ACTION_in_block1908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_alternative_in_block1911 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_REF_in_ruleref1931 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref1935 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_range1962 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range1964 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range1966 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal1986 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_terminal1988 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal2011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal2025 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_terminal2027 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal2038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions2065 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOption_in_elementOptions2067 = new BitSet(new long[]{0x0000000010000408L});
    public static final BitSet FOLLOW_ID_in_elementOption2088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2108 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption2112 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ID_in_elementOption2116 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2132 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption2134 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption2138 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption2152 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption2154 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_elementOption2158 = new BitSet(new long[]{0x0000000000000008L});

}
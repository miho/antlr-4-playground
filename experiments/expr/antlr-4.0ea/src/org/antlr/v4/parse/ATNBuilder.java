// $ANTLR 3.4 ATNBuilder.g 2012-04-29 22:33:16

/*
 [The "BSD license"]
 Copyright (c) 2010 Terence Parr
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
import org.antlr.v4.automata.ATNFactory;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ATNBuilder extends TreeParser {
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


    public ATNBuilder(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public ATNBuilder(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ATNBuilder.tokenNames; }
    public String getGrammarFileName() { return "ATNBuilder.g"; }


        ATNFactory factory;
        public ATNBuilder(TreeNodeStream input, ATNFactory factory) {
        	this(input);
        	this.factory = factory;
        }



    // $ANTLR start "dummy"
    // ATNBuilder.g:76:1: dummy : block[null] ;
    public final void dummy() throws RecognitionException {
        try {
            // ATNBuilder.g:76:7: ( block[null] )
            // ATNBuilder.g:76:9: block[null]
            {
            pushFollow(FOLLOW_block_in_dummy63);
            block(null);

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
    // $ANTLR end "dummy"



    // $ANTLR start "ruleBlock"
    // ATNBuilder.g:78:1: ruleBlock[GrammarAST ebnfRoot] returns [ATNFactory.Handle p] : ^( BLOCK ( ^( OPTIONS ( . )+ ) )? (a= alternative )+ ) ;
    public final ATNFactory.Handle ruleBlock(GrammarAST ebnfRoot) throws RecognitionException {
        ATNFactory.Handle p = null;


        GrammarAST BLOCK1=null;
        ATNFactory.Handle a =null;



            List<ATNFactory.Handle> alts = new ArrayList<ATNFactory.Handle>();
            int alt = 1;
            factory.setCurrentOuterAlt(alt);

        try {
            // ATNBuilder.g:84:5: ( ^( BLOCK ( ^( OPTIONS ( . )+ ) )? (a= alternative )+ ) )
            // ATNBuilder.g:84:7: ^( BLOCK ( ^( OPTIONS ( . )+ ) )? (a= alternative )+ )
            {
            BLOCK1=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_ruleBlock89); 

            match(input, Token.DOWN, null); 
            // ATNBuilder.g:85:13: ( ^( OPTIONS ( . )+ ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==OPTIONS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ATNBuilder.g:85:14: ^( OPTIONS ( . )+ )
                    {
                    match(input,OPTIONS,FOLLOW_OPTIONS_in_ruleBlock105); 

                    match(input, Token.DOWN, null); 
                    // ATNBuilder.g:85:24: ( . )+
                    int cnt1=0;
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( ((LA1_0 >= ACTION && LA1_0 <= WILDCARD)) ) {
                            alt1=1;
                        }
                        else if ( (LA1_0==UP) ) {
                            alt1=2;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ATNBuilder.g:85:24: .
                    	    {
                    	    matchAny(input); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt1 >= 1 ) break loop1;
                                EarlyExitException eee =
                                    new EarlyExitException(1, input);
                                throw eee;
                        }
                        cnt1++;
                    } while (true);


                    match(input, Token.UP, null); 


                    }
                    break;

            }


            // ATNBuilder.g:86:13: (a= alternative )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ALT||LA3_0==LEXER_ALT_ACTION) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ATNBuilder.g:86:17: a= alternative
            	    {
            	    pushFollow(FOLLOW_alternative_in_ruleBlock131);
            	    a=alternative();

            	    state._fsp--;


            	    alts.add(a); factory.setCurrentOuterAlt(++alt);

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


            match(input, Token.UP, null); 


            p = factory.block((BlockAST)BLOCK1, ebnfRoot, alts);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return p;
    }
    // $ANTLR end "ruleBlock"



    // $ANTLR start "block"
    // ATNBuilder.g:93:1: block[GrammarAST ebnfRoot] returns [ATNFactory.Handle p] : ^( BLOCK ( ^( OPTIONS ( . )+ ) )? (a= alternative )+ ) ;
    public final ATNFactory.Handle block(GrammarAST ebnfRoot) throws RecognitionException {
        ATNFactory.Handle p = null;


        GrammarAST BLOCK2=null;
        ATNFactory.Handle a =null;


        List<ATNFactory.Handle> alts = new ArrayList<ATNFactory.Handle>();
        try {
            // ATNBuilder.g:95:5: ( ^( BLOCK ( ^( OPTIONS ( . )+ ) )? (a= alternative )+ ) )
            // ATNBuilder.g:95:7: ^( BLOCK ( ^( OPTIONS ( . )+ ) )? (a= alternative )+ )
            {
            BLOCK2=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_block209); 

            match(input, Token.DOWN, null); 
            // ATNBuilder.g:95:15: ( ^( OPTIONS ( . )+ ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==OPTIONS) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ATNBuilder.g:95:16: ^( OPTIONS ( . )+ )
                    {
                    match(input,OPTIONS,FOLLOW_OPTIONS_in_block213); 

                    match(input, Token.DOWN, null); 
                    // ATNBuilder.g:95:26: ( . )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0 >= ACTION && LA4_0 <= WILDCARD)) ) {
                            alt4=1;
                        }
                        else if ( (LA4_0==UP) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ATNBuilder.g:95:26: .
                    	    {
                    	    matchAny(input); 

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt4 >= 1 ) break loop4;
                                EarlyExitException eee =
                                    new EarlyExitException(4, input);
                                throw eee;
                        }
                        cnt4++;
                    } while (true);


                    match(input, Token.UP, null); 


                    }
                    break;

            }


            // ATNBuilder.g:95:32: (a= alternative )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==ALT||LA6_0==LEXER_ALT_ACTION) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ATNBuilder.g:95:33: a= alternative
            	    {
            	    pushFollow(FOLLOW_alternative_in_block224);
            	    a=alternative();

            	    state._fsp--;


            	    alts.add(a);

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            match(input, Token.UP, null); 


            p = factory.block((BlockAST)BLOCK2, ebnfRoot, alts);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return p;
    }
    // $ANTLR end "block"



    // $ANTLR start "alternative"
    // ATNBuilder.g:99:1: alternative returns [ATNFactory.Handle p] : ( ^( LEXER_ALT_ACTION a= alternative lexerCommands ) | ^( ALT EPSILON ) | ^( ALT (e= element )+ ) );
    public final ATNFactory.Handle alternative() throws RecognitionException {
        ATNFactory.Handle p = null;


        GrammarAST EPSILON4=null;
        ATNFactory.Handle a =null;

        ATNBuilder.element_return e =null;

        ATNFactory.Handle lexerCommands3 =null;


        List<ATNFactory.Handle> els = new ArrayList<ATNFactory.Handle>();
        try {
            // ATNBuilder.g:101:5: ( ^( LEXER_ALT_ACTION a= alternative lexerCommands ) | ^( ALT EPSILON ) | ^( ALT (e= element )+ ) )
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==LEXER_ALT_ACTION) ) {
                alt8=1;
            }
            else if ( (LA8_0==ALT) ) {
                int LA8_2 = input.LA(2);

                if ( (LA8_2==DOWN) ) {
                    int LA8_3 = input.LA(3);

                    if ( (LA8_3==EPSILON) ) {
                        alt8=2;
                    }
                    else if ( (LA8_3==ACTION||LA8_3==ASSIGN||LA8_3==DOT||LA8_3==LEXER_CHAR_SET||LA8_3==NOT||LA8_3==PLUS_ASSIGN||LA8_3==RANGE||LA8_3==RULE_REF||LA8_3==SEMPRED||LA8_3==STRING_LITERAL||LA8_3==TOKEN_REF||LA8_3==BLOCK||LA8_3==CLOSURE||(LA8_3 >= OPTIONAL && LA8_3 <= POSITIVE_CLOSURE)||LA8_3==SET||LA8_3==WILDCARD) ) {
                        alt8=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // ATNBuilder.g:101:7: ^( LEXER_ALT_ACTION a= alternative lexerCommands )
                    {
                    match(input,LEXER_ALT_ACTION,FOLLOW_LEXER_ALT_ACTION_in_alternative263); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_alternative_in_alternative267);
                    a=alternative();

                    state._fsp--;


                    pushFollow(FOLLOW_lexerCommands_in_alternative269);
                    lexerCommands3=lexerCommands();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    p = factory.lexerAltCommands(a,lexerCommands3);

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:103:7: ^( ALT EPSILON )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alternative289); 

                    match(input, Token.DOWN, null); 
                    EPSILON4=(GrammarAST)match(input,EPSILON,FOLLOW_EPSILON_in_alternative291); 

                    match(input, Token.UP, null); 


                    p = factory.epsilon(EPSILON4);

                    }
                    break;
                case 3 :
                    // ATNBuilder.g:104:9: ^( ALT (e= element )+ )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alternative311); 

                    match(input, Token.DOWN, null); 
                    // ATNBuilder.g:104:15: (e= element )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==ACTION||LA7_0==ASSIGN||LA7_0==DOT||LA7_0==LEXER_CHAR_SET||LA7_0==NOT||LA7_0==PLUS_ASSIGN||LA7_0==RANGE||LA7_0==RULE_REF||LA7_0==SEMPRED||LA7_0==STRING_LITERAL||LA7_0==TOKEN_REF||LA7_0==BLOCK||LA7_0==CLOSURE||(LA7_0 >= OPTIONAL && LA7_0 <= POSITIVE_CLOSURE)||LA7_0==SET||LA7_0==WILDCARD) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ATNBuilder.g:104:16: e= element
                    	    {
                    	    pushFollow(FOLLOW_element_in_alternative316);
                    	    e=element();

                    	    state._fsp--;


                    	    els.add((e!=null?e.p:null));

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


                    p = factory.alt(els);

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
        return p;
    }
    // $ANTLR end "alternative"



    // $ANTLR start "lexerCommands"
    // ATNBuilder.g:107:1: lexerCommands returns [ATNFactory.Handle p] : (c= lexerCommand )+ ;
    public final ATNFactory.Handle lexerCommands() throws RecognitionException {
        ATNFactory.Handle p = null;


        String c =null;


        StringBuilder cmds = new StringBuilder();
        try {
            // ATNBuilder.g:109:5: ( (c= lexerCommand )+ )
            // ATNBuilder.g:109:9: (c= lexerCommand )+
            {
            // ATNBuilder.g:109:9: (c= lexerCommand )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ID||LA9_0==LEXER_ACTION_CALL) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ATNBuilder.g:109:10: c= lexerCommand
            	    {
            	    pushFollow(FOLLOW_lexerCommand_in_lexerCommands354);
            	    c=lexerCommand();

            	    state._fsp--;


            	    cmds.append(c+" ");

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



                    p = factory.action(cmds.toString());
                    

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return p;
    }
    // $ANTLR end "lexerCommands"



    // $ANTLR start "lexerCommand"
    // ATNBuilder.g:115:1: lexerCommand returns [String cmd] : ( ^( LEXER_ACTION_CALL ID lexerCommandExpr ) | ID );
    public final String lexerCommand() throws RecognitionException {
        String cmd = null;


        GrammarAST ID5=null;
        GrammarAST ID7=null;
        ATNBuilder.lexerCommandExpr_return lexerCommandExpr6 =null;


        try {
            // ATNBuilder.g:116:2: ( ^( LEXER_ACTION_CALL ID lexerCommandExpr ) | ID )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LEXER_ACTION_CALL) ) {
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
                    // ATNBuilder.g:116:4: ^( LEXER_ACTION_CALL ID lexerCommandExpr )
                    {
                    match(input,LEXER_ACTION_CALL,FOLLOW_LEXER_ACTION_CALL_in_lexerCommand387); 

                    match(input, Token.DOWN, null); 
                    ID5=(GrammarAST)match(input,ID,FOLLOW_ID_in_lexerCommand389); 

                    pushFollow(FOLLOW_lexerCommandExpr_in_lexerCommand391);
                    lexerCommandExpr6=lexerCommandExpr();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    cmd = factory.lexerCallCommand(ID5, (lexerCommandExpr6!=null?((GrammarAST)lexerCommandExpr6.start):null));

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:118:4: ID
                    {
                    ID7=(GrammarAST)match(input,ID,FOLLOW_ID_in_lexerCommand407); 

                    cmd = factory.lexerCommand(ID7);

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
        return cmd;
    }
    // $ANTLR end "lexerCommand"


    public static class lexerCommandExpr_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "lexerCommandExpr"
    // ATNBuilder.g:122:1: lexerCommandExpr : ( ID | INT );
    public final ATNBuilder.lexerCommandExpr_return lexerCommandExpr() throws RecognitionException {
        ATNBuilder.lexerCommandExpr_return retval = new ATNBuilder.lexerCommandExpr_return();
        retval.start = input.LT(1);


        try {
            // ATNBuilder.g:123:2: ( ID | INT )
            // ATNBuilder.g:
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
        public ATNFactory.Handle p;
    };


    // $ANTLR start "element"
    // ATNBuilder.g:127:1: element returns [ATNFactory.Handle p] : ( labeledElement | atom | subrule | ACTION | SEMPRED | ^( ACTION . ) | ^( SEMPRED . ) | ^( NOT b= blockSet[true] ) | LEXER_CHAR_SET );
    public final ATNBuilder.element_return element() throws RecognitionException {
        ATNBuilder.element_return retval = new ATNBuilder.element_return();
        retval.start = input.LT(1);


        GrammarAST ACTION11=null;
        GrammarAST SEMPRED12=null;
        GrammarAST ACTION13=null;
        GrammarAST SEMPRED14=null;
        ATNBuilder.blockSet_return b =null;

        ATNFactory.Handle labeledElement8 =null;

        ATNBuilder.atom_return atom9 =null;

        ATNBuilder.subrule_return subrule10 =null;


        try {
            // ATNBuilder.g:128:2: ( labeledElement | atom | subrule | ACTION | SEMPRED | ^( ACTION . ) | ^( SEMPRED . ) | ^( NOT b= blockSet[true] ) | LEXER_CHAR_SET )
            int alt11=9;
            switch ( input.LA(1) ) {
            case ASSIGN:
            case PLUS_ASSIGN:
                {
                alt11=1;
                }
                break;
            case DOT:
            case RANGE:
            case RULE_REF:
            case STRING_LITERAL:
            case TOKEN_REF:
            case SET:
            case WILDCARD:
                {
                alt11=2;
                }
                break;
            case BLOCK:
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt11=3;
                }
                break;
            case ACTION:
                {
                int LA11_4 = input.LA(2);

                if ( (LA11_4==DOWN) ) {
                    alt11=6;
                }
                else if ( ((LA11_4 >= UP && LA11_4 <= ACTION)||LA11_4==ASSIGN||LA11_4==DOT||LA11_4==LEXER_CHAR_SET||LA11_4==NOT||LA11_4==PLUS_ASSIGN||LA11_4==RANGE||LA11_4==RULE_REF||LA11_4==SEMPRED||LA11_4==STRING_LITERAL||LA11_4==TOKEN_REF||LA11_4==BLOCK||LA11_4==CLOSURE||(LA11_4 >= OPTIONAL && LA11_4 <= POSITIVE_CLOSURE)||LA11_4==SET||LA11_4==WILDCARD) ) {
                    alt11=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;

                }
                }
                break;
            case SEMPRED:
                {
                int LA11_5 = input.LA(2);

                if ( (LA11_5==DOWN) ) {
                    alt11=7;
                }
                else if ( ((LA11_5 >= UP && LA11_5 <= ACTION)||LA11_5==ASSIGN||LA11_5==DOT||LA11_5==LEXER_CHAR_SET||LA11_5==NOT||LA11_5==PLUS_ASSIGN||LA11_5==RANGE||LA11_5==RULE_REF||LA11_5==SEMPRED||LA11_5==STRING_LITERAL||LA11_5==TOKEN_REF||LA11_5==BLOCK||LA11_5==CLOSURE||(LA11_5 >= OPTIONAL && LA11_5 <= POSITIVE_CLOSURE)||LA11_5==SET||LA11_5==WILDCARD) ) {
                    alt11=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 5, input);

                    throw nvae;

                }
                }
                break;
            case NOT:
                {
                alt11=8;
                }
                break;
            case LEXER_CHAR_SET:
                {
                alt11=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // ATNBuilder.g:128:4: labeledElement
                    {
                    pushFollow(FOLLOW_labeledElement_in_element448);
                    labeledElement8=labeledElement();

                    state._fsp--;


                    retval.p = labeledElement8;

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:129:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_element458);
                    atom9=atom();

                    state._fsp--;


                    retval.p = (atom9!=null?atom9.p:null);

                    }
                    break;
                case 3 :
                    // ATNBuilder.g:130:4: subrule
                    {
                    pushFollow(FOLLOW_subrule_in_element470);
                    subrule10=subrule();

                    state._fsp--;


                    retval.p = (subrule10!=null?subrule10.p:null);

                    }
                    break;
                case 4 :
                    // ATNBuilder.g:131:6: ACTION
                    {
                    ACTION11=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element484); 

                    retval.p = factory.action((ActionAST)ACTION11);

                    }
                    break;
                case 5 :
                    // ATNBuilder.g:132:6: SEMPRED
                    {
                    SEMPRED12=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element498); 

                    retval.p = factory.sempred((PredAST)SEMPRED12);

                    }
                    break;
                case 6 :
                    // ATNBuilder.g:133:6: ^( ACTION . )
                    {
                    ACTION13=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element513); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    retval.p = factory.action((ActionAST)ACTION13);

                    }
                    break;
                case 7 :
                    // ATNBuilder.g:134:6: ^( SEMPRED . )
                    {
                    SEMPRED14=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element530); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    retval.p = factory.sempred((PredAST)SEMPRED14);

                    }
                    break;
                case 8 :
                    // ATNBuilder.g:135:7: ^( NOT b= blockSet[true] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element547); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_blockSet_in_element551);
                    b=blockSet(true);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    retval.p = (b!=null?b.p:null);

                    }
                    break;
                case 9 :
                    // ATNBuilder.g:136:7: LEXER_CHAR_SET
                    {
                    match(input,LEXER_CHAR_SET,FOLLOW_LEXER_CHAR_SET_in_element564); 

                    retval.p = factory.charSetLiteral(((GrammarAST)retval.start));

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
    // ATNBuilder.g:139:1: astOperand returns [ATNFactory.Handle p] : ( atom | ^( NOT blockSet[true] ) );
    public final ATNFactory.Handle astOperand() throws RecognitionException {
        ATNFactory.Handle p = null;


        ATNBuilder.atom_return atom15 =null;

        ATNBuilder.blockSet_return blockSet16 =null;


        try {
            // ATNBuilder.g:140:2: ( atom | ^( NOT blockSet[true] ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==DOT||LA12_0==RANGE||LA12_0==RULE_REF||LA12_0==STRING_LITERAL||LA12_0==TOKEN_REF||LA12_0==SET||LA12_0==WILDCARD) ) {
                alt12=1;
            }
            else if ( (LA12_0==NOT) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // ATNBuilder.g:140:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_astOperand585);
                    atom15=atom();

                    state._fsp--;


                    p = (atom15!=null?atom15.p:null);

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:141:4: ^( NOT blockSet[true] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_astOperand598); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_blockSet_in_astOperand600);
                    blockSet16=blockSet(true);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    p = (blockSet16!=null?blockSet16.p:null);

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
        return p;
    }
    // $ANTLR end "astOperand"



    // $ANTLR start "labeledElement"
    // ATNBuilder.g:144:1: labeledElement returns [ATNFactory.Handle p] : ( ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) );
    public final ATNFactory.Handle labeledElement() throws RecognitionException {
        ATNFactory.Handle p = null;


        ATNBuilder.element_return element17 =null;

        ATNBuilder.element_return element18 =null;


        try {
            // ATNBuilder.g:145:2: ( ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==ASSIGN) ) {
                alt13=1;
            }
            else if ( (LA13_0==PLUS_ASSIGN) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // ATNBuilder.g:145:4: ^( ASSIGN ID element )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_labeledElement621); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_labeledElement623); 

                    pushFollow(FOLLOW_element_in_labeledElement625);
                    element17=element();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    p = factory.label((element17!=null?element17.p:null));

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:146:4: ^( PLUS_ASSIGN ID element )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_labeledElement638); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_labeledElement640); 

                    pushFollow(FOLLOW_element_in_labeledElement642);
                    element18=element();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    p = factory.listLabel((element18!=null?element18.p:null));

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
        return p;
    }
    // $ANTLR end "labeledElement"


    public static class subrule_return extends TreeRuleReturnScope {
        public ATNFactory.Handle p;
    };


    // $ANTLR start "subrule"
    // ATNBuilder.g:149:1: subrule returns [ATNFactory.Handle p] : ( ^( OPTIONAL block[$start] ) | ^( CLOSURE block[$start] ) | ^( POSITIVE_CLOSURE block[$start] ) | block[null] );
    public final ATNBuilder.subrule_return subrule() throws RecognitionException {
        ATNBuilder.subrule_return retval = new ATNBuilder.subrule_return();
        retval.start = input.LT(1);


        ATNFactory.Handle block19 =null;

        ATNFactory.Handle block20 =null;

        ATNFactory.Handle block21 =null;

        ATNFactory.Handle block22 =null;


        try {
            // ATNBuilder.g:150:2: ( ^( OPTIONAL block[$start] ) | ^( CLOSURE block[$start] ) | ^( POSITIVE_CLOSURE block[$start] ) | block[null] )
            int alt14=4;
            switch ( input.LA(1) ) {
            case OPTIONAL:
                {
                alt14=1;
                }
                break;
            case CLOSURE:
                {
                alt14=2;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt14=3;
                }
                break;
            case BLOCK:
                {
                alt14=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // ATNBuilder.g:150:4: ^( OPTIONAL block[$start] )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_subrule663); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_subrule665);
                    block19=block(((GrammarAST)retval.start));

                    state._fsp--;


                    match(input, Token.UP, null); 


                    retval.p = block19;

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:151:4: ^( CLOSURE block[$start] )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_subrule677); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_subrule679);
                    block20=block(((GrammarAST)retval.start));

                    state._fsp--;


                    match(input, Token.UP, null); 


                    retval.p = block20;

                    }
                    break;
                case 3 :
                    // ATNBuilder.g:152:4: ^( POSITIVE_CLOSURE block[$start] )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_subrule691); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_subrule693);
                    block21=block(((GrammarAST)retval.start));

                    state._fsp--;


                    match(input, Token.UP, null); 


                    retval.p = block21;

                    }
                    break;
                case 4 :
                    // ATNBuilder.g:153:5: block[null]
                    {
                    pushFollow(FOLLOW_block_in_subrule703);
                    block22=block(null);

                    state._fsp--;


                    retval.p = block22;

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
    // $ANTLR end "subrule"


    public static class blockSet_return extends TreeRuleReturnScope {
        public ATNFactory.Handle p;
    };


    // $ANTLR start "blockSet"
    // ATNBuilder.g:156:1: blockSet[boolean invert] returns [ATNFactory.Handle p] : ^( SET ( setElement )+ ) ;
    public final ATNBuilder.blockSet_return blockSet(boolean invert) throws RecognitionException {
        ATNBuilder.blockSet_return retval = new ATNBuilder.blockSet_return();
        retval.start = input.LT(1);


        ATNBuilder.setElement_return setElement23 =null;


        List<GrammarAST> alts = new ArrayList<GrammarAST>();
        try {
            // ATNBuilder.g:158:2: ( ^( SET ( setElement )+ ) )
            // ATNBuilder.g:158:4: ^( SET ( setElement )+ )
            {
            match(input,SET,FOLLOW_SET_in_blockSet737); 

            match(input, Token.DOWN, null); 
            // ATNBuilder.g:158:10: ( setElement )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==LEXER_CHAR_SET||LA15_0==RANGE||LA15_0==STRING_LITERAL||LA15_0==TOKEN_REF) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ATNBuilder.g:158:11: setElement
            	    {
            	    pushFollow(FOLLOW_setElement_in_blockSet740);
            	    setElement23=setElement();

            	    state._fsp--;


            	    alts.add((setElement23!=null?((GrammarAST)setElement23.start):null));

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


            match(input, Token.UP, null); 


            retval.p = factory.set(((GrammarAST)retval.start), alts, invert);

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
    // $ANTLR end "blockSet"


    public static class setElement_return extends TreeRuleReturnScope {
    };


    // $ANTLR start "setElement"
    // ATNBuilder.g:162:1: setElement : ( STRING_LITERAL | TOKEN_REF | ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) | LEXER_CHAR_SET );
    public final ATNBuilder.setElement_return setElement() throws RecognitionException {
        ATNBuilder.setElement_return retval = new ATNBuilder.setElement_return();
        retval.start = input.LT(1);


        GrammarAST a=null;
        GrammarAST b=null;

        try {
            // ATNBuilder.g:163:2: ( STRING_LITERAL | TOKEN_REF | ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) | LEXER_CHAR_SET )
            int alt16=4;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt16=1;
                }
                break;
            case TOKEN_REF:
                {
                alt16=2;
                }
                break;
            case RANGE:
                {
                alt16=3;
                }
                break;
            case LEXER_CHAR_SET:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // ATNBuilder.g:163:4: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement760); 

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:164:4: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_setElement765); 

                    }
                    break;
                case 3 :
                    // ATNBuilder.g:165:4: ^( RANGE a= STRING_LITERAL b= STRING_LITERAL )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_setElement771); 

                    match(input, Token.DOWN, null); 
                    a=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement775); 

                    b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement779); 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 4 :
                    // ATNBuilder.g:166:9: LEXER_CHAR_SET
                    {
                    match(input,LEXER_CHAR_SET,FOLLOW_LEXER_CHAR_SET_in_setElement790); 

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
    // $ANTLR end "setElement"


    public static class atom_return extends TreeRuleReturnScope {
        public ATNFactory.Handle p;
    };


    // $ANTLR start "atom"
    // ATNBuilder.g:169:1: atom returns [ATNFactory.Handle p] : ( range | ^( DOT ID terminal ) | ^( DOT ID ruleref ) | ^( WILDCARD . ) | WILDCARD | blockSet[false] | terminal | ruleref );
    public final ATNBuilder.atom_return atom() throws RecognitionException {
        ATNBuilder.atom_return retval = new ATNBuilder.atom_return();
        retval.start = input.LT(1);


        ATNFactory.Handle range24 =null;

        ATNBuilder.terminal_return terminal25 =null;

        ATNFactory.Handle ruleref26 =null;

        ATNBuilder.blockSet_return blockSet27 =null;

        ATNBuilder.terminal_return terminal28 =null;

        ATNFactory.Handle ruleref29 =null;


        try {
            // ATNBuilder.g:170:2: ( range | ^( DOT ID terminal ) | ^( DOT ID ruleref ) | ^( WILDCARD . ) | WILDCARD | blockSet[false] | terminal | ruleref )
            int alt17=8;
            switch ( input.LA(1) ) {
            case RANGE:
                {
                alt17=1;
                }
                break;
            case DOT:
                {
                int LA17_2 = input.LA(2);

                if ( (LA17_2==DOWN) ) {
                    int LA17_7 = input.LA(3);

                    if ( (LA17_7==ID) ) {
                        int LA17_10 = input.LA(4);

                        if ( (LA17_10==STRING_LITERAL||LA17_10==TOKEN_REF) ) {
                            alt17=2;
                        }
                        else if ( (LA17_10==RULE_REF) ) {
                            alt17=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 17, 10, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 7, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 2, input);

                    throw nvae;

                }
                }
                break;
            case WILDCARD:
                {
                int LA17_3 = input.LA(2);

                if ( (LA17_3==DOWN) ) {
                    alt17=4;
                }
                else if ( (LA17_3==EOF||(LA17_3 >= UP && LA17_3 <= ACTION)||LA17_3==ASSIGN||LA17_3==DOT||LA17_3==LEXER_CHAR_SET||LA17_3==NOT||LA17_3==PLUS_ASSIGN||LA17_3==RANGE||LA17_3==RULE_REF||LA17_3==SEMPRED||LA17_3==STRING_LITERAL||LA17_3==TOKEN_REF||LA17_3==BLOCK||LA17_3==CLOSURE||(LA17_3 >= OPTIONAL && LA17_3 <= POSITIVE_CLOSURE)||LA17_3==SET||LA17_3==WILDCARD) ) {
                    alt17=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 3, input);

                    throw nvae;

                }
                }
                break;
            case SET:
                {
                alt17=6;
                }
                break;
            case STRING_LITERAL:
            case TOKEN_REF:
                {
                alt17=7;
                }
                break;
            case RULE_REF:
                {
                alt17=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // ATNBuilder.g:170:4: range
                    {
                    pushFollow(FOLLOW_range_in_atom805);
                    range24=range();

                    state._fsp--;


                    retval.p = range24;

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:171:4: ^( DOT ID terminal )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom817); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_atom819); 

                    pushFollow(FOLLOW_terminal_in_atom821);
                    terminal25=terminal();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    retval.p = (terminal25!=null?terminal25.p:null);

                    }
                    break;
                case 3 :
                    // ATNBuilder.g:172:4: ^( DOT ID ruleref )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom831); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_atom833); 

                    pushFollow(FOLLOW_ruleref_in_atom835);
                    ruleref26=ruleref();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    retval.p = ruleref26;

                    }
                    break;
                case 4 :
                    // ATNBuilder.g:173:7: ^( WILDCARD . )
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_atom848); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    retval.p = factory.wildcard(((GrammarAST)retval.start));

                    }
                    break;
                case 5 :
                    // ATNBuilder.g:174:7: WILDCARD
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_atom863); 

                    retval.p = factory.wildcard(((GrammarAST)retval.start));

                    }
                    break;
                case 6 :
                    // ATNBuilder.g:175:7: blockSet[false]
                    {
                    pushFollow(FOLLOW_blockSet_in_atom876);
                    blockSet27=blockSet(false);

                    state._fsp--;


                    retval.p = (blockSet27!=null?blockSet27.p:null);

                    }
                    break;
                case 7 :
                    // ATNBuilder.g:176:9: terminal
                    {
                    pushFollow(FOLLOW_terminal_in_atom891);
                    terminal28=terminal();

                    state._fsp--;


                    retval.p = (terminal28!=null?terminal28.p:null);

                    }
                    break;
                case 8 :
                    // ATNBuilder.g:177:9: ruleref
                    {
                    pushFollow(FOLLOW_ruleref_in_atom906);
                    ruleref29=ruleref();

                    state._fsp--;


                    retval.p = ruleref29;

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
    // $ANTLR end "atom"



    // $ANTLR start "ruleref"
    // ATNBuilder.g:180:1: ruleref returns [ATNFactory.Handle p] : ^( RULE_REF ( ARG_ACTION )? ) ;
    public final ATNFactory.Handle ruleref() throws RecognitionException {
        ATNFactory.Handle p = null;


        GrammarAST RULE_REF30=null;

        try {
            // ATNBuilder.g:181:5: ( ^( RULE_REF ( ARG_ACTION )? ) )
            // ATNBuilder.g:181:7: ^( RULE_REF ( ARG_ACTION )? )
            {
            RULE_REF30=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_ruleref934); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // ATNBuilder.g:181:18: ( ARG_ACTION )?
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==ARG_ACTION) ) {
                    alt18=1;
                }
                switch (alt18) {
                    case 1 :
                        // ATNBuilder.g:181:18: ARG_ACTION
                        {
                        match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleref936); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            p = factory.ruleRef(RULE_REF30);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return p;
    }
    // $ANTLR end "ruleref"



    // $ANTLR start "range"
    // ATNBuilder.g:184:1: range returns [ATNFactory.Handle p] : ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) ;
    public final ATNFactory.Handle range() throws RecognitionException {
        ATNFactory.Handle p = null;


        GrammarAST a=null;
        GrammarAST b=null;

        try {
            // ATNBuilder.g:185:5: ( ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) )
            // ATNBuilder.g:185:7: ^( RANGE a= STRING_LITERAL b= STRING_LITERAL )
            {
            match(input,RANGE,FOLLOW_RANGE_in_range964); 

            match(input, Token.DOWN, null); 
            a=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range968); 

            b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range972); 

            match(input, Token.UP, null); 


            p = factory.range(a,b);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return p;
    }
    // $ANTLR end "range"


    public static class terminal_return extends TreeRuleReturnScope {
        public ATNFactory.Handle p;
    };


    // $ANTLR start "terminal"
    // ATNBuilder.g:188:1: terminal returns [ATNFactory.Handle p] : ( ^( STRING_LITERAL . ) | STRING_LITERAL | ^( TOKEN_REF ARG_ACTION . ) | ^( TOKEN_REF . ) | TOKEN_REF );
    public final ATNBuilder.terminal_return terminal() throws RecognitionException {
        ATNBuilder.terminal_return retval = new ATNBuilder.terminal_return();
        retval.start = input.LT(1);


        try {
            // ATNBuilder.g:189:5: ( ^( STRING_LITERAL . ) | STRING_LITERAL | ^( TOKEN_REF ARG_ACTION . ) | ^( TOKEN_REF . ) | TOKEN_REF )
            int alt19=5;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==STRING_LITERAL) ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1==DOWN) ) {
                    alt19=1;
                }
                else if ( (LA19_1==EOF||(LA19_1 >= UP && LA19_1 <= ACTION)||LA19_1==ASSIGN||LA19_1==DOT||LA19_1==LEXER_CHAR_SET||LA19_1==NOT||LA19_1==PLUS_ASSIGN||LA19_1==RANGE||LA19_1==RULE_REF||LA19_1==SEMPRED||LA19_1==STRING_LITERAL||LA19_1==TOKEN_REF||LA19_1==BLOCK||LA19_1==CLOSURE||(LA19_1 >= OPTIONAL && LA19_1 <= POSITIVE_CLOSURE)||LA19_1==SET||LA19_1==WILDCARD) ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA19_0==TOKEN_REF) ) {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==DOWN) ) {
                    int LA19_5 = input.LA(3);

                    if ( (LA19_5==ARG_ACTION) ) {
                        int LA19_7 = input.LA(4);

                        if ( ((LA19_7 >= ACTION && LA19_7 <= WILDCARD)) ) {
                            alt19=3;
                        }
                        else if ( ((LA19_7 >= DOWN && LA19_7 <= UP)) ) {
                            alt19=4;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 19, 7, input);

                            throw nvae;

                        }
                    }
                    else if ( ((LA19_5 >= ACTION && LA19_5 <= ACTION_STRING_LITERAL)||(LA19_5 >= ARG_OR_CHARSET && LA19_5 <= WILDCARD)) ) {
                        alt19=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 5, input);

                        throw nvae;

                    }
                }
                else if ( (LA19_2==EOF||(LA19_2 >= UP && LA19_2 <= ACTION)||LA19_2==ASSIGN||LA19_2==DOT||LA19_2==LEXER_CHAR_SET||LA19_2==NOT||LA19_2==PLUS_ASSIGN||LA19_2==RANGE||LA19_2==RULE_REF||LA19_2==SEMPRED||LA19_2==STRING_LITERAL||LA19_2==TOKEN_REF||LA19_2==BLOCK||LA19_2==CLOSURE||(LA19_2 >= OPTIONAL && LA19_2 <= POSITIVE_CLOSURE)||LA19_2==SET||LA19_2==WILDCARD) ) {
                    alt19=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // ATNBuilder.g:189:8: ^( STRING_LITERAL . )
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal998); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    retval.p = factory.stringLiteral((TerminalAST)((GrammarAST)retval.start));

                    }
                    break;
                case 2 :
                    // ATNBuilder.g:190:7: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal1013); 

                    retval.p = factory.stringLiteral((TerminalAST)((GrammarAST)retval.start));

                    }
                    break;
                case 3 :
                    // ATNBuilder.g:191:7: ^( TOKEN_REF ARG_ACTION . )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal1027); 

                    match(input, Token.DOWN, null); 
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_terminal1029); 

                    matchAny(input); 

                    match(input, Token.UP, null); 


                    retval.p = factory.tokenRef((TerminalAST)((GrammarAST)retval.start));

                    }
                    break;
                case 4 :
                    // ATNBuilder.g:192:7: ^( TOKEN_REF . )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal1043); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    retval.p = factory.tokenRef((TerminalAST)((GrammarAST)retval.start));

                    }
                    break;
                case 5 :
                    // ATNBuilder.g:193:7: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal1059); 

                    retval.p = factory.tokenRef((TerminalAST)((GrammarAST)retval.start));

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
    // $ANTLR end "terminal"

    // Delegated rules


 

    public static final BitSet FOLLOW_block_in_dummy63 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_ruleBlock89 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPTIONS_in_ruleBlock105 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alternative_in_ruleBlock131 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080040L});
    public static final BitSet FOLLOW_BLOCK_in_block209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPTIONS_in_block213 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alternative_in_block224 = new BitSet(new long[]{0x0000000000000008L,0x0000000000080040L});
    public static final BitSet FOLLOW_LEXER_ALT_ACTION_in_alternative263 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alternative_in_alternative267 = new BitSet(new long[]{0x0000000010000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_lexerCommands_in_alternative269 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative289 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_alternative291 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_alternative311 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative316 = new BitSet(new long[]{0x4A10408100080418L,0x0000000140601402L});
    public static final BitSet FOLLOW_lexerCommand_in_lexerCommands354 = new BitSet(new long[]{0x0000000010000002L,0x0000000000040000L});
    public static final BitSet FOLLOW_LEXER_ACTION_CALL_in_lexerCommand387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_lexerCommand389 = new BitSet(new long[]{0x0000000050000000L});
    public static final BitSet FOLLOW_lexerCommandExpr_in_lexerCommand391 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ID_in_lexerCommand407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_labeledElement_in_element448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrule_in_element470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element513 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SEMPRED_in_element530 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_NOT_in_element547 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_blockSet_in_element551 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_element564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_astOperand585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_astOperand598 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_blockSet_in_astOperand600 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledElement623 = new BitSet(new long[]{0x4A10408100080410L,0x0000000140601402L});
    public static final BitSet FOLLOW_element_in_labeledElement625 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement638 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledElement640 = new BitSet(new long[]{0x4A10408100080410L,0x0000000140601402L});
    public static final BitSet FOLLOW_element_in_labeledElement642 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONAL_in_subrule663 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_subrule665 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_subrule677 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_subrule679 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_subrule691 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_subrule693 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_subrule703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_blockSet737 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_setElement_in_blockSet740 = new BitSet(new long[]{0x4010000100000008L,0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_setElement771 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement775 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement779 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LEXER_CHAR_SET_in_setElement790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_range_in_atom805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom817 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom819 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom821 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_atom831 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom833 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ruleref_in_atom835 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WILDCARD_in_atom848 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WILDCARD_in_atom863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockSet_in_atom876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_atom906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_ruleref934 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref936 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_range964 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range968 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range972 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal998 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal1027 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_terminal1029 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000001FFFFFFFFL});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal1043 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal1059 = new BitSet(new long[]{0x0000000000000002L});

}
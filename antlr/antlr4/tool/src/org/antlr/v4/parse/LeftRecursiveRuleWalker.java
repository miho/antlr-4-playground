// $ANTLR 3.4 LeftRecursiveRuleWalker.g 2012-04-29 22:33:16

package org.antlr.v4.parse;

import org.antlr.v4.misc.*;
import org.antlr.v4.tool.*;
import org.antlr.v4.tool.ast.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/** Find left-recursive rules */
@SuppressWarnings({"all", "warnings", "unchecked"})
public class LeftRecursiveRuleWalker extends TreeParser {
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


    public LeftRecursiveRuleWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public LeftRecursiveRuleWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return LeftRecursiveRuleWalker.tokenNames; }
    public String getGrammarFileName() { return "LeftRecursiveRuleWalker.g"; }


    private String ruleName;
    private int currentOuterAltNumber; // which outer alt of rule?
    public int numAlts;  // how many alts for this rule total?

    public void setTokenPrec(GrammarAST t, int alt) {}
    public void binaryAlt(AltAST altTree, int alt) {}
    public void ternaryAlt(AltAST altTree, int alt) {}
    public void prefixAlt(AltAST altTree, int alt) {}
    public void suffixAlt(AltAST altTree, int alt) {}
    public void otherAlt(AltAST altTree, int alt) {}
    public void setReturnValues(GrammarAST t) {}



    // $ANTLR start "rec_rule"
    // LeftRecursiveRuleWalker.g:67:1: public rec_rule returns [boolean isLeftRec] : ^(r= RULE id= RULE_REF ( DOC_COMMENT )? ( ruleModifier )? ( ^( RETURNS a= ARG_ACTION ) )? ( ^( LOCALS ARG_ACTION ) )? ( ^( OPTIONS ( . )* ) | ^( AT ID ACTION ) )* ruleBlock exceptionGroup ) ;
    public final boolean rec_rule() throws RecognitionException {
        boolean isLeftRec = false;


        GrammarAST r=null;
        GrammarAST id=null;
        GrammarAST a=null;
        LeftRecursiveRuleWalker.ruleBlock_return ruleBlock1 =null;



        	currentOuterAltNumber = 1;

        try {
            // LeftRecursiveRuleWalker.g:72:2: ( ^(r= RULE id= RULE_REF ( DOC_COMMENT )? ( ruleModifier )? ( ^( RETURNS a= ARG_ACTION ) )? ( ^( LOCALS ARG_ACTION ) )? ( ^( OPTIONS ( . )* ) | ^( AT ID ACTION ) )* ruleBlock exceptionGroup ) )
            // LeftRecursiveRuleWalker.g:72:4: ^(r= RULE id= RULE_REF ( DOC_COMMENT )? ( ruleModifier )? ( ^( RETURNS a= ARG_ACTION ) )? ( ^( LOCALS ARG_ACTION ) )? ( ^( OPTIONS ( . )* ) | ^( AT ID ACTION ) )* ruleBlock exceptionGroup )
            {
            r=(GrammarAST)match(input,RULE,FOLLOW_RULE_in_rec_rule72); if (state.failed) return isLeftRec;

            match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
            id=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_rec_rule76); if (state.failed) return isLeftRec;

            if ( state.backtracking==0 ) {ruleName=id.getText();}

            // LeftRecursiveRuleWalker.g:73:4: ( DOC_COMMENT )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==DOC_COMMENT) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:73:4: DOC_COMMENT
                    {
                    match(input,DOC_COMMENT,FOLLOW_DOC_COMMENT_in_rec_rule83); if (state.failed) return isLeftRec;

                    }
                    break;

            }


            // LeftRecursiveRuleWalker.g:73:17: ( ruleModifier )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0 >= PRIVATE && LA2_0 <= PUBLIC)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:73:17: ruleModifier
                    {
                    pushFollow(FOLLOW_ruleModifier_in_rec_rule86);
                    ruleModifier();

                    state._fsp--;
                    if (state.failed) return isLeftRec;

                    }
                    break;

            }


            // LeftRecursiveRuleWalker.g:75:4: ( ^( RETURNS a= ARG_ACTION ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RETURNS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:75:5: ^( RETURNS a= ARG_ACTION )
                    {
                    match(input,RETURNS,FOLLOW_RETURNS_in_rec_rule95); if (state.failed) return isLeftRec;

                    match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
                    a=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rec_rule99); if (state.failed) return isLeftRec;

                    if ( state.backtracking==0 ) {setReturnValues(a);}

                    match(input, Token.UP, null); if (state.failed) return isLeftRec;


                    }
                    break;

            }


            // LeftRecursiveRuleWalker.g:77:9: ( ^( LOCALS ARG_ACTION ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==LOCALS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:77:11: ^( LOCALS ARG_ACTION )
                    {
                    match(input,LOCALS,FOLLOW_LOCALS_in_rec_rule118); if (state.failed) return isLeftRec;

                    match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
                    match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_rec_rule120); if (state.failed) return isLeftRec;

                    match(input, Token.UP, null); if (state.failed) return isLeftRec;


                    }
                    break;

            }


            // LeftRecursiveRuleWalker.g:78:9: ( ^( OPTIONS ( . )* ) | ^( AT ID ACTION ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==OPTIONS) ) {
                    alt6=1;
                }
                else if ( (LA6_0==AT) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:78:11: ^( OPTIONS ( . )* )
            	    {
            	    match(input,OPTIONS,FOLLOW_OPTIONS_in_rec_rule138); if (state.failed) return isLeftRec;

            	    if ( input.LA(1)==Token.DOWN ) {
            	        match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
            	        // LeftRecursiveRuleWalker.g:78:21: ( . )*
            	        loop5:
            	        do {
            	            int alt5=2;
            	            int LA5_0 = input.LA(1);

            	            if ( ((LA5_0 >= ACTION && LA5_0 <= WILDCARD)) ) {
            	                alt5=1;
            	            }
            	            else if ( (LA5_0==UP) ) {
            	                alt5=2;
            	            }


            	            switch (alt5) {
            	        	case 1 :
            	        	    // LeftRecursiveRuleWalker.g:78:21: .
            	        	    {
            	        	    matchAny(input); if (state.failed) return isLeftRec;

            	        	    }
            	        	    break;

            	        	default :
            	        	    break loop5;
            	            }
            	        } while (true);


            	        match(input, Token.UP, null); if (state.failed) return isLeftRec;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // LeftRecursiveRuleWalker.g:79:11: ^( AT ID ACTION )
            	    {
            	    match(input,AT,FOLLOW_AT_in_rec_rule155); if (state.failed) return isLeftRec;

            	    match(input, Token.DOWN, null); if (state.failed) return isLeftRec;
            	    match(input,ID,FOLLOW_ID_in_rec_rule157); if (state.failed) return isLeftRec;

            	    match(input,ACTION,FOLLOW_ACTION_in_rec_rule159); if (state.failed) return isLeftRec;

            	    match(input, Token.UP, null); if (state.failed) return isLeftRec;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            pushFollow(FOLLOW_ruleBlock_in_rec_rule175);
            ruleBlock1=ruleBlock();

            state._fsp--;
            if (state.failed) return isLeftRec;

            if ( state.backtracking==0 ) {isLeftRec = (ruleBlock1!=null?ruleBlock1.isLeftRec:false);}

            pushFollow(FOLLOW_exceptionGroup_in_rec_rule182);
            exceptionGroup();

            state._fsp--;
            if (state.failed) return isLeftRec;

            match(input, Token.UP, null); if (state.failed) return isLeftRec;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return isLeftRec;
    }
    // $ANTLR end "rec_rule"



    // $ANTLR start "exceptionGroup"
    // LeftRecursiveRuleWalker.g:86:1: exceptionGroup : ( exceptionHandler )* ( finallyClause )? ;
    public final void exceptionGroup() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:87:5: ( ( exceptionHandler )* ( finallyClause )? )
            // LeftRecursiveRuleWalker.g:87:7: ( exceptionHandler )* ( finallyClause )?
            {
            // LeftRecursiveRuleWalker.g:87:7: ( exceptionHandler )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==CATCH) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:87:7: exceptionHandler
            	    {
            	    pushFollow(FOLLOW_exceptionHandler_in_exceptionGroup200);
            	    exceptionHandler();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            // LeftRecursiveRuleWalker.g:87:25: ( finallyClause )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==FINALLY) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:87:25: finallyClause
                    {
                    pushFollow(FOLLOW_finallyClause_in_exceptionGroup203);
                    finallyClause();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exceptionGroup"



    // $ANTLR start "exceptionHandler"
    // LeftRecursiveRuleWalker.g:90:1: exceptionHandler : ^( CATCH ARG_ACTION ACTION ) ;
    public final void exceptionHandler() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:91:2: ( ^( CATCH ARG_ACTION ACTION ) )
            // LeftRecursiveRuleWalker.g:91:4: ^( CATCH ARG_ACTION ACTION )
            {
            match(input,CATCH,FOLLOW_CATCH_in_exceptionHandler219); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_exceptionHandler221); if (state.failed) return ;

            match(input,ACTION,FOLLOW_ACTION_in_exceptionHandler223); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "exceptionHandler"



    // $ANTLR start "finallyClause"
    // LeftRecursiveRuleWalker.g:94:1: finallyClause : ^( FINALLY ACTION ) ;
    public final void finallyClause() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:95:2: ( ^( FINALLY ACTION ) )
            // LeftRecursiveRuleWalker.g:95:4: ^( FINALLY ACTION )
            {
            match(input,FINALLY,FOLLOW_FINALLY_in_finallyClause236); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            match(input,ACTION,FOLLOW_ACTION_in_finallyClause238); if (state.failed) return ;

            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "finallyClause"



    // $ANTLR start "ruleModifier"
    // LeftRecursiveRuleWalker.g:98:1: ruleModifier : ( PUBLIC | PRIVATE | PROTECTED );
    public final void ruleModifier() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:99:5: ( PUBLIC | PRIVATE | PROTECTED )
            // LeftRecursiveRuleWalker.g:
            {
            if ( (input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ruleModifier"


    public static class ruleBlock_return extends TreeRuleReturnScope {
        public boolean isLeftRec;
    };


    // $ANTLR start "ruleBlock"
    // LeftRecursiveRuleWalker.g:104:1: ruleBlock returns [boolean isLeftRec] : ^( BLOCK (o= outerAlternative )+ ) ;
    public final LeftRecursiveRuleWalker.ruleBlock_return ruleBlock() throws RecognitionException {
        LeftRecursiveRuleWalker.ruleBlock_return retval = new LeftRecursiveRuleWalker.ruleBlock_return();
        retval.start = input.LT(1);


        LeftRecursiveRuleWalker.outerAlternative_return o =null;


        boolean lr=false; this.numAlts = ((GrammarAST)retval.start).getChildCount();
        try {
            // LeftRecursiveRuleWalker.g:106:2: ( ^( BLOCK (o= outerAlternative )+ ) )
            // LeftRecursiveRuleWalker.g:106:4: ^( BLOCK (o= outerAlternative )+ )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_ruleBlock293); if (state.failed) return retval;

            match(input, Token.DOWN, null); if (state.failed) return retval;
            // LeftRecursiveRuleWalker.g:107:4: (o= outerAlternative )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==ALT) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:108:5: o= outerAlternative
            	    {
            	    pushFollow(FOLLOW_outerAlternative_in_ruleBlock306);
            	    o=outerAlternative();

            	    state._fsp--;
            	    if (state.failed) return retval;

            	    if ( state.backtracking==0 ) {if ((o!=null?o.isLeftRec:false)) retval.isLeftRec = true;}

            	    if ( state.backtracking==0 ) {currentOuterAltNumber++;}

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "ruleBlock"


    public static class outerAlternative_return extends TreeRuleReturnScope {
        public boolean isLeftRec;
    };


    // $ANTLR start "outerAlternative"
    // LeftRecursiveRuleWalker.g:116:1: outerAlternative returns [boolean isLeftRec] : ( ( binaryMultipleOp )=> binaryMultipleOp | ( binary )=> binary | ( ternary )=> ternary | ( prefix )=> prefix | ( suffix )=> suffix | ^( ALT ( element )+ ) );
    public final LeftRecursiveRuleWalker.outerAlternative_return outerAlternative() throws RecognitionException {
        LeftRecursiveRuleWalker.outerAlternative_return retval = new LeftRecursiveRuleWalker.outerAlternative_return();
        retval.start = input.LT(1);


        try {
            // LeftRecursiveRuleWalker.g:117:5: ( ( binaryMultipleOp )=> binaryMultipleOp | ( binary )=> binary | ( ternary )=> ternary | ( prefix )=> prefix | ( suffix )=> suffix | ^( ALT ( element )+ ) )
            int alt11=6;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==ALT) ) {
                int LA11_1 = input.LA(2);

                if ( (synpred1_LeftRecursiveRuleWalker()) ) {
                    alt11=1;
                }
                else if ( (synpred2_LeftRecursiveRuleWalker()) ) {
                    alt11=2;
                }
                else if ( (synpred3_LeftRecursiveRuleWalker()) ) {
                    alt11=3;
                }
                else if ( (synpred4_LeftRecursiveRuleWalker()) ) {
                    alt11=4;
                }
                else if ( (synpred5_LeftRecursiveRuleWalker()) ) {
                    alt11=5;
                }
                else if ( (true) ) {
                    alt11=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:117:9: ( binaryMultipleOp )=> binaryMultipleOp
                    {
                    pushFollow(FOLLOW_binaryMultipleOp_in_outerAlternative355);
                    binaryMultipleOp();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {binaryAlt((AltAST)((GrammarAST)retval.start), currentOuterAltNumber); retval.isLeftRec =true;}

                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:119:9: ( binary )=> binary
                    {
                    pushFollow(FOLLOW_binary_in_outerAlternative411);
                    binary();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {binaryAlt((AltAST)((GrammarAST)retval.start), currentOuterAltNumber); retval.isLeftRec =true;}

                    }
                    break;
                case 3 :
                    // LeftRecursiveRuleWalker.g:121:9: ( ternary )=> ternary
                    {
                    pushFollow(FOLLOW_ternary_in_outerAlternative466);
                    ternary();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {ternaryAlt((AltAST)((GrammarAST)retval.start), currentOuterAltNumber); retval.isLeftRec =true;}

                    }
                    break;
                case 4 :
                    // LeftRecursiveRuleWalker.g:123:9: ( prefix )=> prefix
                    {
                    pushFollow(FOLLOW_prefix_in_outerAlternative522);
                    prefix();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {prefixAlt((AltAST)((GrammarAST)retval.start), currentOuterAltNumber);}

                    }
                    break;
                case 5 :
                    // LeftRecursiveRuleWalker.g:125:9: ( suffix )=> suffix
                    {
                    pushFollow(FOLLOW_suffix_in_outerAlternative578);
                    suffix();

                    state._fsp--;
                    if (state.failed) return retval;

                    if ( state.backtracking==0 ) {suffixAlt((AltAST)((GrammarAST)retval.start), currentOuterAltNumber); retval.isLeftRec =true;}

                    }
                    break;
                case 6 :
                    // LeftRecursiveRuleWalker.g:127:9: ^( ALT ( element )+ )
                    {
                    match(input,ALT,FOLLOW_ALT_in_outerAlternative620); if (state.failed) return retval;

                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // LeftRecursiveRuleWalker.g:127:15: ( element )+
                    int cnt10=0;
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==ACTION||LA10_0==ASSIGN||LA10_0==DOT||LA10_0==NOT||LA10_0==PLUS_ASSIGN||LA10_0==RANGE||LA10_0==RULE_REF||LA10_0==SEMPRED||LA10_0==STRING_LITERAL||LA10_0==TOKEN_REF||LA10_0==BLOCK||LA10_0==CLOSURE||LA10_0==EPSILON||(LA10_0 >= OPTIONAL && LA10_0 <= POSITIVE_CLOSURE)||LA10_0==SET||LA10_0==WILDCARD) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // LeftRecursiveRuleWalker.g:127:15: element
                    	    {
                    	    pushFollow(FOLLOW_element_in_outerAlternative622);
                    	    element();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt10 >= 1 ) break loop10;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(10, input);
                                throw eee;
                        }
                        cnt10++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;


                    if ( state.backtracking==0 ) {otherAlt((AltAST)((GrammarAST)retval.start), currentOuterAltNumber);}

                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "outerAlternative"



    // $ANTLR start "binaryMultipleOp"
    // LeftRecursiveRuleWalker.g:132:1: binaryMultipleOp : ^( ALT recurse bops recurse ( ACTION )? ) ;
    public final void binaryMultipleOp() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:133:2: ( ^( ALT recurse bops recurse ( ACTION )? ) )
            // LeftRecursiveRuleWalker.g:133:4: ^( ALT recurse bops recurse ( ACTION )? )
            {
            match(input,ALT,FOLLOW_ALT_in_binaryMultipleOp673); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_recurse_in_binaryMultipleOp675);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_bops_in_binaryMultipleOp677);
            bops();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_recurse_in_binaryMultipleOp679);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            // LeftRecursiveRuleWalker.g:133:32: ( ACTION )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ACTION) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:133:32: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_binaryMultipleOp681); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "binaryMultipleOp"



    // $ANTLR start "bops"
    // LeftRecursiveRuleWalker.g:136:1: bops : ( ^( ASSIGN ID bops ) | ^( BLOCK ( ^( ALT (op= token )+ ) )+ ) | ^( SET (op= token )+ ) );
    public final void bops() throws RecognitionException {
        GrammarAST op =null;


        try {
            // LeftRecursiveRuleWalker.g:136:5: ( ^( ASSIGN ID bops ) | ^( BLOCK ( ^( ALT (op= token )+ ) )+ ) | ^( SET (op= token )+ ) )
            int alt16=3;
            switch ( input.LA(1) ) {
            case ASSIGN:
                {
                alt16=1;
                }
                break;
            case BLOCK:
                {
                alt16=2;
                }
                break;
            case SET:
                {
                alt16=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;

            }

            switch (alt16) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:136:9: ^( ASSIGN ID bops )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_bops696); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_bops698); if (state.failed) return ;

                    pushFollow(FOLLOW_bops_in_bops700);
                    bops();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:137:4: ^( BLOCK ( ^( ALT (op= token )+ ) )+ )
                    {
                    match(input,BLOCK,FOLLOW_BLOCK_in_bops708); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // LeftRecursiveRuleWalker.g:137:13: ( ^( ALT (op= token )+ ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==ALT) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // LeftRecursiveRuleWalker.g:137:15: ^( ALT (op= token )+ )
                    	    {
                    	    match(input,ALT,FOLLOW_ALT_in_bops714); if (state.failed) return ;

                    	    match(input, Token.DOWN, null); if (state.failed) return ;
                    	    // LeftRecursiveRuleWalker.g:137:22: (op= token )+
                    	    int cnt13=0;
                    	    loop13:
                    	    do {
                    	        int alt13=2;
                    	        int LA13_0 = input.LA(1);

                    	        if ( (LA13_0==ASSIGN||LA13_0==PLUS_ASSIGN||LA13_0==STRING_LITERAL||LA13_0==TOKEN_REF) ) {
                    	            alt13=1;
                    	        }


                    	        switch (alt13) {
                    	    	case 1 :
                    	    	    // LeftRecursiveRuleWalker.g:137:23: op= token
                    	    	    {
                    	    	    pushFollow(FOLLOW_token_in_bops719);
                    	    	    op=token();

                    	    	    state._fsp--;
                    	    	    if (state.failed) return ;

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    if ( cnt13 >= 1 ) break loop13;
                    	    	    if (state.backtracking>0) {state.failed=true; return ;}
                    	                EarlyExitException eee =
                    	                    new EarlyExitException(13, input);
                    	                throw eee;
                    	        }
                    	        cnt13++;
                    	    } while (true);


                    	    if ( state.backtracking==0 ) {setTokenPrec(op, currentOuterAltNumber);}

                    	    match(input, Token.UP, null); if (state.failed) return ;


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // LeftRecursiveRuleWalker.g:138:9: ^( SET (op= token )+ )
                    {
                    match(input,SET,FOLLOW_SET_in_bops741); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // LeftRecursiveRuleWalker.g:138:15: (op= token )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==ASSIGN||LA15_0==PLUS_ASSIGN||LA15_0==STRING_LITERAL||LA15_0==TOKEN_REF) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // LeftRecursiveRuleWalker.g:138:16: op= token
                    	    {
                    	    pushFollow(FOLLOW_token_in_bops746);
                    	    op=token();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    if ( state.backtracking==0 ) {setTokenPrec(op, currentOuterAltNumber);}

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "bops"



    // $ANTLR start "binary"
    // LeftRecursiveRuleWalker.g:141:1: binary : ^( ALT recurse (op= token )+ recurse ( ACTION )? ) ;
    public final void binary() throws RecognitionException {
        GrammarAST op =null;


        try {
            // LeftRecursiveRuleWalker.g:142:2: ( ^( ALT recurse (op= token )+ recurse ( ACTION )? ) )
            // LeftRecursiveRuleWalker.g:142:4: ^( ALT recurse (op= token )+ recurse ( ACTION )? )
            {
            match(input,ALT,FOLLOW_ALT_in_binary767); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_recurse_in_binary769);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            // LeftRecursiveRuleWalker.g:142:19: (op= token )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==ASSIGN) ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1==DOWN) ) {
                        int LA17_4 = input.LA(3);

                        if ( (LA17_4==ID) ) {
                            int LA17_5 = input.LA(4);

                            if ( (LA17_5==ASSIGN||LA17_5==PLUS_ASSIGN||LA17_5==STRING_LITERAL||LA17_5==TOKEN_REF) ) {
                                alt17=1;
                            }


                        }


                    }


                }
                else if ( (LA17_0==PLUS_ASSIGN||LA17_0==STRING_LITERAL||LA17_0==TOKEN_REF) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:142:20: op= token
            	    {
            	    pushFollow(FOLLOW_token_in_binary774);
            	    op=token();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt17 >= 1 ) break loop17;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
            } while (true);


            if ( state.backtracking==0 ) {setTokenPrec(op, currentOuterAltNumber);}

            pushFollow(FOLLOW_recurse_in_binary780);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            // LeftRecursiveRuleWalker.g:142:85: ( ACTION )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==ACTION) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:142:85: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_binary782); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "binary"



    // $ANTLR start "ternary"
    // LeftRecursiveRuleWalker.g:145:1: ternary : ^( ALT recurse op= token recurse token recurse ( ACTION )? ) ;
    public final void ternary() throws RecognitionException {
        GrammarAST op =null;


        try {
            // LeftRecursiveRuleWalker.g:146:2: ( ^( ALT recurse op= token recurse token recurse ( ACTION )? ) )
            // LeftRecursiveRuleWalker.g:146:4: ^( ALT recurse op= token recurse token recurse ( ACTION )? )
            {
            match(input,ALT,FOLLOW_ALT_in_ternary798); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_recurse_in_ternary800);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_token_in_ternary804);
            op=token();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_recurse_in_ternary806);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_token_in_ternary808);
            token();

            state._fsp--;
            if (state.failed) return ;

            pushFollow(FOLLOW_recurse_in_ternary810);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            // LeftRecursiveRuleWalker.g:146:50: ( ACTION )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==ACTION) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:146:50: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_ternary812); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;


            if ( state.backtracking==0 ) {setTokenPrec(op, currentOuterAltNumber);}

            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ternary"



    // $ANTLR start "prefix"
    // LeftRecursiveRuleWalker.g:149:1: prefix : ^( ALT ({...}? element )+ recurse ( ACTION )? ) ;
    public final void prefix() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:150:2: ( ^( ALT ({...}? element )+ recurse ( ACTION )? ) )
            // LeftRecursiveRuleWalker.g:150:4: ^( ALT ({...}? element )+ recurse ( ACTION )? )
            {
            match(input,ALT,FOLLOW_ALT_in_prefix830); if (state.failed) return ;

            if ( state.backtracking==0 ) {setTokenPrec((GrammarAST)input.LT(1), currentOuterAltNumber);}

            match(input, Token.DOWN, null); if (state.failed) return ;
            // LeftRecursiveRuleWalker.g:151:4: ({...}? element )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case ASSIGN:
                    {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==DOWN) ) {
                        int LA20_4 = input.LA(3);

                        if ( (LA20_4==ID) ) {
                            int LA20_7 = input.LA(4);

                            if ( (LA20_7==RULE_REF) ) {
                                int LA20_8 = input.LA(5);

                                if ( (LA20_8==DOWN) ) {
                                    alt20=1;
                                }
                                else if ( (LA20_8==UP) ) {
                                    int LA20_9 = input.LA(6);

                                    if ( (LA20_9==ACTION) ) {
                                        int LA20_10 = input.LA(7);

                                        if ( (LA20_10==ACTION||LA20_10==ASSIGN||LA20_10==DOT||LA20_10==NOT||LA20_10==PLUS_ASSIGN||LA20_10==RANGE||LA20_10==RULE_REF||LA20_10==SEMPRED||LA20_10==STRING_LITERAL||LA20_10==TOKEN_REF||LA20_10==BLOCK||LA20_10==CLOSURE||LA20_10==EPSILON||(LA20_10 >= OPTIONAL && LA20_10 <= POSITIVE_CLOSURE)||LA20_10==SET||LA20_10==WILDCARD) ) {
                                            alt20=1;
                                        }


                                    }
                                    else if ( (LA20_9==ASSIGN||LA20_9==DOT||LA20_9==NOT||LA20_9==PLUS_ASSIGN||LA20_9==RANGE||LA20_9==RULE_REF||LA20_9==SEMPRED||LA20_9==STRING_LITERAL||LA20_9==TOKEN_REF||LA20_9==BLOCK||LA20_9==CLOSURE||LA20_9==EPSILON||(LA20_9 >= OPTIONAL && LA20_9 <= POSITIVE_CLOSURE)||LA20_9==SET||LA20_9==WILDCARD) ) {
                                        alt20=1;
                                    }


                                }


                            }
                            else if ( (LA20_7==ACTION||LA20_7==ASSIGN||LA20_7==DOT||LA20_7==NOT||LA20_7==PLUS_ASSIGN||LA20_7==RANGE||LA20_7==SEMPRED||LA20_7==STRING_LITERAL||LA20_7==TOKEN_REF||LA20_7==BLOCK||LA20_7==CLOSURE||LA20_7==EPSILON||(LA20_7 >= OPTIONAL && LA20_7 <= POSITIVE_CLOSURE)||LA20_7==SET||LA20_7==WILDCARD) ) {
                                alt20=1;
                            }


                        }


                    }


                    }
                    break;
                case RULE_REF:
                    {
                    int LA20_2 = input.LA(2);

                    if ( (LA20_2==DOWN||LA20_2==ASSIGN||LA20_2==DOT||LA20_2==NOT||LA20_2==PLUS_ASSIGN||LA20_2==RANGE||LA20_2==RULE_REF||LA20_2==SEMPRED||LA20_2==STRING_LITERAL||LA20_2==TOKEN_REF||LA20_2==BLOCK||LA20_2==CLOSURE||LA20_2==EPSILON||(LA20_2 >= OPTIONAL && LA20_2 <= POSITIVE_CLOSURE)||LA20_2==SET||LA20_2==WILDCARD) ) {
                        alt20=1;
                    }
                    else if ( (LA20_2==ACTION) ) {
                        int LA20_5 = input.LA(3);

                        if ( (LA20_5==ACTION||LA20_5==ASSIGN||LA20_5==DOT||LA20_5==NOT||LA20_5==PLUS_ASSIGN||LA20_5==RANGE||LA20_5==RULE_REF||LA20_5==SEMPRED||LA20_5==STRING_LITERAL||LA20_5==TOKEN_REF||LA20_5==BLOCK||LA20_5==CLOSURE||LA20_5==EPSILON||(LA20_5 >= OPTIONAL && LA20_5 <= POSITIVE_CLOSURE)||LA20_5==SET||LA20_5==WILDCARD) ) {
                            alt20=1;
                        }


                    }


                    }
                    break;
                case ACTION:
                case DOT:
                case NOT:
                case PLUS_ASSIGN:
                case RANGE:
                case SEMPRED:
                case STRING_LITERAL:
                case TOKEN_REF:
                case BLOCK:
                case CLOSURE:
                case EPSILON:
                case OPTIONAL:
                case POSITIVE_CLOSURE:
                case SET:
                case WILDCARD:
                    {
                    alt20=1;
                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:151:5: {...}? element
            	    {
            	    if ( !((!((CommonTree)input.LT(1)).getText().equals(ruleName))) ) {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        throw new FailedPredicateException(input, "prefix", "!((CommonTree)input.LT(1)).getText().equals(ruleName)");
            	    }

            	    pushFollow(FOLLOW_element_in_prefix840);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

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


            pushFollow(FOLLOW_recurse_in_prefix847);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            // LeftRecursiveRuleWalker.g:152:12: ( ACTION )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==ACTION) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:152:12: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_prefix849); if (state.failed) return ;

                    }
                    break;

            }


            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "prefix"



    // $ANTLR start "suffix"
    // LeftRecursiveRuleWalker.g:156:1: suffix : ^( ALT recurse ( element )+ ) ;
    public final void suffix() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:156:8: ( ^( ALT recurse ( element )+ ) )
            // LeftRecursiveRuleWalker.g:156:10: ^( ALT recurse ( element )+ )
            {
            match(input,ALT,FOLLOW_ALT_in_suffix867); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            pushFollow(FOLLOW_recurse_in_suffix869);
            recurse();

            state._fsp--;
            if (state.failed) return ;

            if ( state.backtracking==0 ) {setTokenPrec((GrammarAST)input.LT(1), currentOuterAltNumber);}

            // LeftRecursiveRuleWalker.g:156:89: ( element )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==ACTION||LA22_0==ASSIGN||LA22_0==DOT||LA22_0==NOT||LA22_0==PLUS_ASSIGN||LA22_0==RANGE||LA22_0==RULE_REF||LA22_0==SEMPRED||LA22_0==STRING_LITERAL||LA22_0==TOKEN_REF||LA22_0==BLOCK||LA22_0==CLOSURE||LA22_0==EPSILON||(LA22_0 >= OPTIONAL && LA22_0 <= POSITIVE_CLOSURE)||LA22_0==SET||LA22_0==WILDCARD) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:156:89: element
            	    {
            	    pushFollow(FOLLOW_element_in_suffix873);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "suffix"



    // $ANTLR start "recurse"
    // LeftRecursiveRuleWalker.g:158:1: recurse : ( ^( ASSIGN ID recurseNoLabel ) | recurseNoLabel );
    public final void recurse() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:159:2: ( ^( ASSIGN ID recurseNoLabel ) | recurseNoLabel )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==ASSIGN) ) {
                alt23=1;
            }
            else if ( (LA23_0==RULE_REF) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;

            }
            switch (alt23) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:159:4: ^( ASSIGN ID recurseNoLabel )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_recurse888); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_recurse890); if (state.failed) return ;

                    pushFollow(FOLLOW_recurseNoLabel_in_recurse892);
                    recurseNoLabel();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:160:4: recurseNoLabel
                    {
                    pushFollow(FOLLOW_recurseNoLabel_in_recurse898);
                    recurseNoLabel();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "recurse"



    // $ANTLR start "recurseNoLabel"
    // LeftRecursiveRuleWalker.g:163:1: recurseNoLabel :{...}? RULE_REF ;
    public final void recurseNoLabel() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:163:16: ({...}? RULE_REF )
            // LeftRecursiveRuleWalker.g:163:18: {...}? RULE_REF
            {
            if ( !((((CommonTree)input.LT(1)).getText().equals(ruleName))) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "recurseNoLabel", "((CommonTree)input.LT(1)).getText().equals(ruleName)");
            }

            match(input,RULE_REF,FOLLOW_RULE_REF_in_recurseNoLabel910); if (state.failed) return ;

            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "recurseNoLabel"



    // $ANTLR start "token"
    // LeftRecursiveRuleWalker.g:165:1: token returns [GrammarAST t=null] : ( ^( ASSIGN ID s= token ) | ^( PLUS_ASSIGN ID s= token ) |b= STRING_LITERAL | ^(b= STRING_LITERAL elementOptions ) | ^(c= TOKEN_REF elementOptions ) |c= TOKEN_REF );
    public final GrammarAST token() throws RecognitionException {
        GrammarAST t = null;


        GrammarAST b=null;
        GrammarAST c=null;
        GrammarAST s =null;


        try {
            // LeftRecursiveRuleWalker.g:166:2: ( ^( ASSIGN ID s= token ) | ^( PLUS_ASSIGN ID s= token ) |b= STRING_LITERAL | ^(b= STRING_LITERAL elementOptions ) | ^(c= TOKEN_REF elementOptions ) |c= TOKEN_REF )
            int alt24=6;
            switch ( input.LA(1) ) {
            case ASSIGN:
                {
                alt24=1;
                }
                break;
            case PLUS_ASSIGN:
                {
                alt24=2;
                }
                break;
            case STRING_LITERAL:
                {
                int LA24_3 = input.LA(2);

                if ( (LA24_3==DOWN) ) {
                    alt24=4;
                }
                else if ( (LA24_3==UP||LA24_3==ASSIGN||LA24_3==PLUS_ASSIGN||LA24_3==RULE_REF||LA24_3==STRING_LITERAL||LA24_3==TOKEN_REF) ) {
                    alt24=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return t;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 3, input);

                    throw nvae;

                }
                }
                break;
            case TOKEN_REF:
                {
                int LA24_4 = input.LA(2);

                if ( (LA24_4==DOWN) ) {
                    alt24=5;
                }
                else if ( (LA24_4==UP||LA24_4==ASSIGN||LA24_4==PLUS_ASSIGN||LA24_4==RULE_REF||LA24_4==STRING_LITERAL||LA24_4==TOKEN_REF) ) {
                    alt24=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return t;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 4, input);

                    throw nvae;

                }
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return t;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:166:4: ^( ASSIGN ID s= token )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_token924); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    match(input,ID,FOLLOW_ID_in_token926); if (state.failed) return t;

                    pushFollow(FOLLOW_token_in_token930);
                    s=token();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = s;}

                    match(input, Token.UP, null); if (state.failed) return t;


                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:167:4: ^( PLUS_ASSIGN ID s= token )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_token939); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    match(input,ID,FOLLOW_ID_in_token941); if (state.failed) return t;

                    pushFollow(FOLLOW_token_in_token945);
                    s=token();

                    state._fsp--;
                    if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = s;}

                    match(input, Token.UP, null); if (state.failed) return t;


                    }
                    break;
                case 3 :
                    // LeftRecursiveRuleWalker.g:168:4: b= STRING_LITERAL
                    {
                    b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_token955); if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = b;}

                    }
                    break;
                case 4 :
                    // LeftRecursiveRuleWalker.g:169:7: ^(b= STRING_LITERAL elementOptions )
                    {
                    b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_token976); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    pushFollow(FOLLOW_elementOptions_in_token978);
                    elementOptions();

                    state._fsp--;
                    if (state.failed) return t;

                    match(input, Token.UP, null); if (state.failed) return t;


                    if ( state.backtracking==0 ) {t = b;}

                    }
                    break;
                case 5 :
                    // LeftRecursiveRuleWalker.g:170:7: ^(c= TOKEN_REF elementOptions )
                    {
                    c=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_token993); if (state.failed) return t;

                    match(input, Token.DOWN, null); if (state.failed) return t;
                    pushFollow(FOLLOW_elementOptions_in_token995);
                    elementOptions();

                    state._fsp--;
                    if (state.failed) return t;

                    match(input, Token.UP, null); if (state.failed) return t;


                    if ( state.backtracking==0 ) {t = c;}

                    }
                    break;
                case 6 :
                    // LeftRecursiveRuleWalker.g:171:4: c= TOKEN_REF
                    {
                    c=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_token1007); if (state.failed) return t;

                    if ( state.backtracking==0 ) {t = c;}

                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return t;
    }
    // $ANTLR end "token"



    // $ANTLR start "elementOptions"
    // LeftRecursiveRuleWalker.g:174:1: elementOptions : ^( ELEMENT_OPTIONS ( elementOption )+ ) ;
    public final void elementOptions() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:175:5: ( ^( ELEMENT_OPTIONS ( elementOption )+ ) )
            // LeftRecursiveRuleWalker.g:175:7: ^( ELEMENT_OPTIONS ( elementOption )+ )
            {
            match(input,ELEMENT_OPTIONS,FOLLOW_ELEMENT_OPTIONS_in_elementOptions1037); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // LeftRecursiveRuleWalker.g:175:25: ( elementOption )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==ASSIGN||LA25_0==ID) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:175:25: elementOption
            	    {
            	    pushFollow(FOLLOW_elementOption_in_elementOptions1039);
            	    elementOption();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "elementOptions"



    // $ANTLR start "elementOption"
    // LeftRecursiveRuleWalker.g:178:1: elementOption : ( ID | ^( ASSIGN ID ID ) | ^( ASSIGN ID STRING_LITERAL ) );
    public final void elementOption() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:179:5: ( ID | ^( ASSIGN ID ID ) | ^( ASSIGN ID STRING_LITERAL ) )
            int alt26=3;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==ASSIGN) ) {
                int LA26_2 = input.LA(2);

                if ( (LA26_2==DOWN) ) {
                    int LA26_3 = input.LA(3);

                    if ( (LA26_3==ID) ) {
                        int LA26_4 = input.LA(4);

                        if ( (LA26_4==ID) ) {
                            alt26=2;
                        }
                        else if ( (LA26_4==STRING_LITERAL) ) {
                            alt26=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return ;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 26, 4, input);

                            throw nvae;

                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return ;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 3, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 26, 2, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:179:7: ID
                    {
                    match(input,ID,FOLLOW_ID_in_elementOption1058); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:180:9: ^( ASSIGN ID ID )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption1069); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_elementOption1071); if (state.failed) return ;

                    match(input,ID,FOLLOW_ID_in_elementOption1073); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // LeftRecursiveRuleWalker.g:181:9: ^( ASSIGN ID STRING_LITERAL )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption1085); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_elementOption1087); if (state.failed) return ;

                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_elementOption1089); if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "elementOption"



    // $ANTLR start "element"
    // LeftRecursiveRuleWalker.g:184:1: element : ( atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ^( SET ( setElement )+ ) | RULE_REF | ebnf | ACTION | SEMPRED | EPSILON );
    public final void element() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:185:2: ( atom | ^( NOT element ) | ^( RANGE atom atom ) | ^( ASSIGN ID element ) | ^( PLUS_ASSIGN ID element ) | ^( SET ( setElement )+ ) | RULE_REF | ebnf | ACTION | SEMPRED | EPSILON )
            int alt28=11;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==DOWN) ) {
                    alt28=1;
                }
                else if ( ((LA28_1 >= UP && LA28_1 <= ACTION)||LA28_1==ASSIGN||LA28_1==DOT||LA28_1==NOT||LA28_1==PLUS_ASSIGN||LA28_1==RANGE||LA28_1==RULE_REF||LA28_1==SEMPRED||LA28_1==STRING_LITERAL||LA28_1==TOKEN_REF||LA28_1==BLOCK||LA28_1==CLOSURE||LA28_1==EPSILON||(LA28_1 >= OPTIONAL && LA28_1 <= POSITIVE_CLOSURE)||LA28_1==SET||LA28_1==WILDCARD) ) {
                    alt28=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 28, 1, input);

                    throw nvae;

                }
                }
                break;
            case DOT:
            case STRING_LITERAL:
            case TOKEN_REF:
            case WILDCARD:
                {
                alt28=1;
                }
                break;
            case NOT:
                {
                alt28=2;
                }
                break;
            case RANGE:
                {
                alt28=3;
                }
                break;
            case ASSIGN:
                {
                alt28=4;
                }
                break;
            case PLUS_ASSIGN:
                {
                alt28=5;
                }
                break;
            case SET:
                {
                alt28=6;
                }
                break;
            case BLOCK:
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt28=8;
                }
                break;
            case ACTION:
                {
                alt28=9;
                }
                break;
            case SEMPRED:
                {
                alt28=10;
                }
                break;
            case EPSILON:
                {
                alt28=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;

            }

            switch (alt28) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:185:4: atom
                    {
                    pushFollow(FOLLOW_atom_in_element1104);
                    atom();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:186:4: ^( NOT element )
                    {
                    match(input,NOT,FOLLOW_NOT_in_element1110); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_element_in_element1112);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // LeftRecursiveRuleWalker.g:187:4: ^( RANGE atom atom )
                    {
                    match(input,RANGE,FOLLOW_RANGE_in_element1119); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_atom_in_element1121);
                    atom();

                    state._fsp--;
                    if (state.failed) return ;

                    pushFollow(FOLLOW_atom_in_element1123);
                    atom();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 4 :
                    // LeftRecursiveRuleWalker.g:188:4: ^( ASSIGN ID element )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_element1130); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_element1132); if (state.failed) return ;

                    pushFollow(FOLLOW_element_in_element1134);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 5 :
                    // LeftRecursiveRuleWalker.g:189:4: ^( PLUS_ASSIGN ID element )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_element1141); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_element1143); if (state.failed) return ;

                    pushFollow(FOLLOW_element_in_element1145);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 6 :
                    // LeftRecursiveRuleWalker.g:190:7: ^( SET ( setElement )+ )
                    {
                    match(input,SET,FOLLOW_SET_in_element1155); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    // LeftRecursiveRuleWalker.g:190:13: ( setElement )+
                    int cnt27=0;
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==STRING_LITERAL||LA27_0==TOKEN_REF) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // LeftRecursiveRuleWalker.g:190:13: setElement
                    	    {
                    	    pushFollow(FOLLOW_setElement_in_element1157);
                    	    setElement();

                    	    state._fsp--;
                    	    if (state.failed) return ;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt27 >= 1 ) break loop27;
                    	    if (state.backtracking>0) {state.failed=true; return ;}
                                EarlyExitException eee =
                                    new EarlyExitException(27, input);
                                throw eee;
                        }
                        cnt27++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 7 :
                    // LeftRecursiveRuleWalker.g:191:9: RULE_REF
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_element1169); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // LeftRecursiveRuleWalker.g:192:4: ebnf
                    {
                    pushFollow(FOLLOW_ebnf_in_element1174);
                    ebnf();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 9 :
                    // LeftRecursiveRuleWalker.g:193:4: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_element1179); if (state.failed) return ;

                    }
                    break;
                case 10 :
                    // LeftRecursiveRuleWalker.g:194:4: SEMPRED
                    {
                    match(input,SEMPRED,FOLLOW_SEMPRED_in_element1184); if (state.failed) return ;

                    }
                    break;
                case 11 :
                    // LeftRecursiveRuleWalker.g:195:4: EPSILON
                    {
                    match(input,EPSILON,FOLLOW_EPSILON_in_element1189); if (state.failed) return ;

                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "element"



    // $ANTLR start "setElement"
    // LeftRecursiveRuleWalker.g:198:1: setElement : ( STRING_LITERAL | TOKEN_REF );
    public final void setElement() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:199:2: ( STRING_LITERAL | TOKEN_REF )
            // LeftRecursiveRuleWalker.g:
            {
            if ( input.LA(1)==STRING_LITERAL||input.LA(1)==TOKEN_REF ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "setElement"



    // $ANTLR start "ebnf"
    // LeftRecursiveRuleWalker.g:203:1: ebnf : ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) );
    public final void ebnf() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:203:5: ( block | ^( OPTIONAL block ) | ^( CLOSURE block ) | ^( POSITIVE_CLOSURE block ) )
            int alt29=4;
            switch ( input.LA(1) ) {
            case BLOCK:
                {
                alt29=1;
                }
                break;
            case OPTIONAL:
                {
                alt29=2;
                }
                break;
            case CLOSURE:
                {
                alt29=3;
                }
                break;
            case POSITIVE_CLOSURE:
                {
                alt29=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:203:9: block
                    {
                    pushFollow(FOLLOW_block_in_ebnf1216);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:204:9: ^( OPTIONAL block )
                    {
                    match(input,OPTIONAL,FOLLOW_OPTIONAL_in_ebnf1228); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1230);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // LeftRecursiveRuleWalker.g:205:9: ^( CLOSURE block )
                    {
                    match(input,CLOSURE,FOLLOW_CLOSURE_in_ebnf1244); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1246);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 4 :
                    // LeftRecursiveRuleWalker.g:206:9: ^( POSITIVE_CLOSURE block )
                    {
                    match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_ebnf1260); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_block_in_ebnf1262);
                    block();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "ebnf"



    // $ANTLR start "block"
    // LeftRecursiveRuleWalker.g:209:1: block : ^( BLOCK ( ACTION )? ( alternative )+ ) ;
    public final void block() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:210:5: ( ^( BLOCK ( ACTION )? ( alternative )+ ) )
            // LeftRecursiveRuleWalker.g:210:7: ^( BLOCK ( ACTION )? ( alternative )+ )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block1282); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // LeftRecursiveRuleWalker.g:210:15: ( ACTION )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==ACTION) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:210:15: ACTION
                    {
                    match(input,ACTION,FOLLOW_ACTION_in_block1284); if (state.failed) return ;

                    }
                    break;

            }


            // LeftRecursiveRuleWalker.g:210:23: ( alternative )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==ALT) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:210:23: alternative
            	    {
            	    pushFollow(FOLLOW_alternative_in_block1287);
            	    alternative();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "block"



    // $ANTLR start "alternative"
    // LeftRecursiveRuleWalker.g:213:1: alternative : ^( ALT ( element )+ ) ;
    public final void alternative() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:214:2: ( ^( ALT ( element )+ ) )
            // LeftRecursiveRuleWalker.g:214:4: ^( ALT ( element )+ )
            {
            match(input,ALT,FOLLOW_ALT_in_alternative1304); if (state.failed) return ;

            match(input, Token.DOWN, null); if (state.failed) return ;
            // LeftRecursiveRuleWalker.g:214:10: ( element )+
            int cnt32=0;
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==ACTION||LA32_0==ASSIGN||LA32_0==DOT||LA32_0==NOT||LA32_0==PLUS_ASSIGN||LA32_0==RANGE||LA32_0==RULE_REF||LA32_0==SEMPRED||LA32_0==STRING_LITERAL||LA32_0==TOKEN_REF||LA32_0==BLOCK||LA32_0==CLOSURE||LA32_0==EPSILON||(LA32_0 >= OPTIONAL && LA32_0 <= POSITIVE_CLOSURE)||LA32_0==SET||LA32_0==WILDCARD) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // LeftRecursiveRuleWalker.g:214:10: element
            	    {
            	    pushFollow(FOLLOW_element_in_alternative1306);
            	    element();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt32 >= 1 ) break loop32;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(32, input);
                        throw eee;
                }
                cnt32++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return ;


            }

        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "alternative"



    // $ANTLR start "atom"
    // LeftRecursiveRuleWalker.g:217:1: atom : ( ^( RULE_REF ( ARG_ACTION )? ) | ^( STRING_LITERAL elementOptions ) | STRING_LITERAL | ^( TOKEN_REF elementOptions ) | TOKEN_REF | ^( WILDCARD elementOptions ) | WILDCARD | ^( DOT ID element ) );
    public final void atom() throws RecognitionException {
        try {
            // LeftRecursiveRuleWalker.g:218:2: ( ^( RULE_REF ( ARG_ACTION )? ) | ^( STRING_LITERAL elementOptions ) | STRING_LITERAL | ^( TOKEN_REF elementOptions ) | TOKEN_REF | ^( WILDCARD elementOptions ) | WILDCARD | ^( DOT ID element ) )
            int alt34=8;
            switch ( input.LA(1) ) {
            case RULE_REF:
                {
                alt34=1;
                }
                break;
            case STRING_LITERAL:
                {
                int LA34_2 = input.LA(2);

                if ( (LA34_2==DOWN) ) {
                    alt34=2;
                }
                else if ( ((LA34_2 >= UP && LA34_2 <= ACTION)||LA34_2==ASSIGN||LA34_2==DOT||LA34_2==NOT||LA34_2==PLUS_ASSIGN||LA34_2==RANGE||LA34_2==RULE_REF||LA34_2==SEMPRED||LA34_2==STRING_LITERAL||LA34_2==TOKEN_REF||LA34_2==BLOCK||LA34_2==CLOSURE||LA34_2==EPSILON||(LA34_2 >= OPTIONAL && LA34_2 <= POSITIVE_CLOSURE)||LA34_2==SET||LA34_2==WILDCARD) ) {
                    alt34=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 2, input);

                    throw nvae;

                }
                }
                break;
            case TOKEN_REF:
                {
                int LA34_3 = input.LA(2);

                if ( (LA34_3==DOWN) ) {
                    alt34=4;
                }
                else if ( ((LA34_3 >= UP && LA34_3 <= ACTION)||LA34_3==ASSIGN||LA34_3==DOT||LA34_3==NOT||LA34_3==PLUS_ASSIGN||LA34_3==RANGE||LA34_3==RULE_REF||LA34_3==SEMPRED||LA34_3==STRING_LITERAL||LA34_3==TOKEN_REF||LA34_3==BLOCK||LA34_3==CLOSURE||LA34_3==EPSILON||(LA34_3 >= OPTIONAL && LA34_3 <= POSITIVE_CLOSURE)||LA34_3==SET||LA34_3==WILDCARD) ) {
                    alt34=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 3, input);

                    throw nvae;

                }
                }
                break;
            case WILDCARD:
                {
                int LA34_4 = input.LA(2);

                if ( (LA34_4==DOWN) ) {
                    alt34=6;
                }
                else if ( ((LA34_4 >= UP && LA34_4 <= ACTION)||LA34_4==ASSIGN||LA34_4==DOT||LA34_4==NOT||LA34_4==PLUS_ASSIGN||LA34_4==RANGE||LA34_4==RULE_REF||LA34_4==SEMPRED||LA34_4==STRING_LITERAL||LA34_4==TOKEN_REF||LA34_4==BLOCK||LA34_4==CLOSURE||LA34_4==EPSILON||(LA34_4 >= OPTIONAL && LA34_4 <= POSITIVE_CLOSURE)||LA34_4==SET||LA34_4==WILDCARD) ) {
                    alt34=7;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 34, 4, input);

                    throw nvae;

                }
                }
                break;
            case DOT:
                {
                alt34=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;

            }

            switch (alt34) {
                case 1 :
                    // LeftRecursiveRuleWalker.g:218:4: ^( RULE_REF ( ARG_ACTION )? )
                    {
                    match(input,RULE_REF,FOLLOW_RULE_REF_in_atom1323); if (state.failed) return ;

                    if ( input.LA(1)==Token.DOWN ) {
                        match(input, Token.DOWN, null); if (state.failed) return ;
                        // LeftRecursiveRuleWalker.g:218:15: ( ARG_ACTION )?
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==ARG_ACTION) ) {
                            alt33=1;
                        }
                        switch (alt33) {
                            case 1 :
                                // LeftRecursiveRuleWalker.g:218:15: ARG_ACTION
                                {
                                match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_atom1325); if (state.failed) return ;

                                }
                                break;

                        }


                        match(input, Token.UP, null); if (state.failed) return ;
                    }


                    }
                    break;
                case 2 :
                    // LeftRecursiveRuleWalker.g:219:8: ^( STRING_LITERAL elementOptions )
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1337); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_elementOptions_in_atom1339);
                    elementOptions();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 3 :
                    // LeftRecursiveRuleWalker.g:220:4: STRING_LITERAL
                    {
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_atom1345); if (state.failed) return ;

                    }
                    break;
                case 4 :
                    // LeftRecursiveRuleWalker.g:221:7: ^( TOKEN_REF elementOptions )
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1354); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_elementOptions_in_atom1356);
                    elementOptions();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 5 :
                    // LeftRecursiveRuleWalker.g:222:4: TOKEN_REF
                    {
                    match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_atom1362); if (state.failed) return ;

                    }
                    break;
                case 6 :
                    // LeftRecursiveRuleWalker.g:223:7: ^( WILDCARD elementOptions )
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1371); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    pushFollow(FOLLOW_elementOptions_in_atom1373);
                    elementOptions();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;
                case 7 :
                    // LeftRecursiveRuleWalker.g:224:4: WILDCARD
                    {
                    match(input,WILDCARD,FOLLOW_WILDCARD_in_atom1379); if (state.failed) return ;

                    }
                    break;
                case 8 :
                    // LeftRecursiveRuleWalker.g:225:4: ^( DOT ID element )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom1385); if (state.failed) return ;

                    match(input, Token.DOWN, null); if (state.failed) return ;
                    match(input,ID,FOLLOW_ID_in_atom1387); if (state.failed) return ;

                    pushFollow(FOLLOW_element_in_atom1389);
                    element();

                    state._fsp--;
                    if (state.failed) return ;

                    match(input, Token.UP, null); if (state.failed) return ;


                    }
                    break;

            }
        }
         
        finally {
        	// do for sure before leaving
        }
        return ;
    }
    // $ANTLR end "atom"

    // $ANTLR start synpred1_LeftRecursiveRuleWalker
    public final void synpred1_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // LeftRecursiveRuleWalker.g:117:9: ( binaryMultipleOp )
        // LeftRecursiveRuleWalker.g:117:10: binaryMultipleOp
        {
        pushFollow(FOLLOW_binaryMultipleOp_in_synpred1_LeftRecursiveRuleWalker351);
        binaryMultipleOp();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred1_LeftRecursiveRuleWalker

    // $ANTLR start synpred2_LeftRecursiveRuleWalker
    public final void synpred2_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // LeftRecursiveRuleWalker.g:119:9: ( binary )
        // LeftRecursiveRuleWalker.g:119:10: binary
        {
        pushFollow(FOLLOW_binary_in_synpred2_LeftRecursiveRuleWalker397);
        binary();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred2_LeftRecursiveRuleWalker

    // $ANTLR start synpred3_LeftRecursiveRuleWalker
    public final void synpred3_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // LeftRecursiveRuleWalker.g:121:9: ( ternary )
        // LeftRecursiveRuleWalker.g:121:10: ternary
        {
        pushFollow(FOLLOW_ternary_in_synpred3_LeftRecursiveRuleWalker453);
        ternary();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred3_LeftRecursiveRuleWalker

    // $ANTLR start synpred4_LeftRecursiveRuleWalker
    public final void synpred4_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // LeftRecursiveRuleWalker.g:123:9: ( prefix )
        // LeftRecursiveRuleWalker.g:123:10: prefix
        {
        pushFollow(FOLLOW_prefix_in_synpred4_LeftRecursiveRuleWalker508);
        prefix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred4_LeftRecursiveRuleWalker

    // $ANTLR start synpred5_LeftRecursiveRuleWalker
    public final void synpred5_LeftRecursiveRuleWalker_fragment() throws RecognitionException {
        // LeftRecursiveRuleWalker.g:125:9: ( suffix )
        // LeftRecursiveRuleWalker.g:125:10: suffix
        {
        pushFollow(FOLLOW_suffix_in_synpred5_LeftRecursiveRuleWalker564);
        suffix();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred5_LeftRecursiveRuleWalker

    // Delegated rules

    public final boolean synpred5_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_LeftRecursiveRuleWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_LeftRecursiveRuleWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_RULE_in_rec_rule72 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_RULE_REF_in_rec_rule76 = new BitSet(new long[]{0x0087040200020800L,0x0000000000000400L});
    public static final BitSet FOLLOW_DOC_COMMENT_in_rec_rule83 = new BitSet(new long[]{0x0087040200000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_ruleModifier_in_rec_rule86 = new BitSet(new long[]{0x0080040200000800L,0x0000000000000400L});
    public static final BitSet FOLLOW_RETURNS_in_rec_rule95 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule99 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_LOCALS_in_rec_rule118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_rec_rule120 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONS_in_rec_rule138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_AT_in_rec_rule155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_rec_rule157 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_rec_rule159 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ruleBlock_in_rec_rule175 = new BitSet(new long[]{0x0000000000801008L});
    public static final BitSet FOLLOW_exceptionGroup_in_rec_rule182 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_exceptionHandler_in_exceptionGroup200 = new BitSet(new long[]{0x0000000000801002L});
    public static final BitSet FOLLOW_finallyClause_in_exceptionGroup203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CATCH_in_exceptionHandler219 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_exceptionHandler221 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_exceptionHandler223 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FINALLY_in_finallyClause236 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_finallyClause238 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_ruleBlock293 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_outerAlternative_in_ruleBlock306 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});
    public static final BitSet FOLLOW_binaryMultipleOp_in_outerAlternative355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_in_outerAlternative411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_outerAlternative466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prefix_in_outerAlternative522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_suffix_in_outerAlternative578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_outerAlternative620 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_outerAlternative622 = new BitSet(new long[]{0x4A10408000080418L,0x0000000140609402L});
    public static final BitSet FOLLOW_ALT_in_binaryMultipleOp673 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurse_in_binaryMultipleOp675 = new BitSet(new long[]{0x0000000000000400L,0x0000000040000400L});
    public static final BitSet FOLLOW_bops_in_binaryMultipleOp677 = new BitSet(new long[]{0x0200000000000400L});
    public static final BitSet FOLLOW_recurse_in_binaryMultipleOp679 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_ACTION_in_binaryMultipleOp681 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_bops696 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_bops698 = new BitSet(new long[]{0x0000000000000400L,0x0000000040000400L});
    public static final BitSet FOLLOW_bops_in_bops700 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_bops708 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALT_in_bops714 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_bops719 = new BitSet(new long[]{0x4000400000000408L,0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_bops741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_token_in_bops746 = new BitSet(new long[]{0x4000400000000408L,0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_binary767 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurse_in_binary769 = new BitSet(new long[]{0x4000400000000400L,0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_binary774 = new BitSet(new long[]{0x4200400000000400L,0x0000000000000002L});
    public static final BitSet FOLLOW_recurse_in_binary780 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_ACTION_in_binary782 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_ternary798 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurse_in_ternary800 = new BitSet(new long[]{0x4000400000000400L,0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_ternary804 = new BitSet(new long[]{0x0200000000000400L});
    public static final BitSet FOLLOW_recurse_in_ternary806 = new BitSet(new long[]{0x4000400000000400L,0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_ternary808 = new BitSet(new long[]{0x0200000000000400L});
    public static final BitSet FOLLOW_recurse_in_ternary810 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_ACTION_in_ternary812 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_prefix830 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_prefix840 = new BitSet(new long[]{0x4A10408000080410L,0x0000000140609402L});
    public static final BitSet FOLLOW_recurse_in_prefix847 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_ACTION_in_prefix849 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_suffix867 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_recurse_in_suffix869 = new BitSet(new long[]{0x4A10408000080410L,0x0000000140609402L});
    public static final BitSet FOLLOW_element_in_suffix873 = new BitSet(new long[]{0x4A10408000080418L,0x0000000140609402L});
    public static final BitSet FOLLOW_ASSIGN_in_recurse888 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_recurse890 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse892 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_recurseNoLabel_in_recurse898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_recurseNoLabel910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_token924 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_token926 = new BitSet(new long[]{0x4000400000000400L,0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_token930 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_token939 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_token941 = new BitSet(new long[]{0x4000400000000400L,0x0000000000000002L});
    public static final BitSet FOLLOW_token_in_token945 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_token955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_token976 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_token978 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_token993 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_token995 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_token1007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions1037 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOption_in_elementOptions1039 = new BitSet(new long[]{0x0000000010000408L});
    public static final BitSet FOLLOW_ID_in_elementOption1058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption1069 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption1071 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ID_in_elementOption1073 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption1085 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption1087 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption1089 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_atom_in_element1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_element1110 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_element1112 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_element1119 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_element1121 = new BitSet(new long[]{0x4200000000080000L,0x0000000100000002L});
    public static final BitSet FOLLOW_atom_in_element1123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_element1130 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1132 = new BitSet(new long[]{0x4A10408000080410L,0x0000000140609402L});
    public static final BitSet FOLLOW_element_in_element1134 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_element1141 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_element1143 = new BitSet(new long[]{0x4A10408000080410L,0x0000000140609402L});
    public static final BitSet FOLLOW_element_in_element1145 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SET_in_element1155 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_setElement_in_element1157 = new BitSet(new long[]{0x4000000000000008L,0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_element1169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnf_in_element1174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element1179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element1184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPSILON_in_element1189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_ebnf1216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OPTIONAL_in_ebnf1228 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1230 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_ebnf1244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1246 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_ebnf1260 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_ebnf1262 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_block1282 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ACTION_in_block1284 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_alternative_in_block1287 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});
    public static final BitSet FOLLOW_ALT_in_alternative1304 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alternative1306 = new BitSet(new long[]{0x4A10408000080418L,0x0000000140609402L});
    public static final BitSet FOLLOW_RULE_REF_in_atom1323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_atom1325 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1337 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_atom1339 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_atom1345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1354 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_atom1356 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_TOKEN_REF_in_atom1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1371 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_atom1373 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WILDCARD_in_atom1379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom1385 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom1387 = new BitSet(new long[]{0x4A10408000080410L,0x0000000140609402L});
    public static final BitSet FOLLOW_element_in_atom1389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_binaryMultipleOp_in_synpred1_LeftRecursiveRuleWalker351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_binary_in_synpred2_LeftRecursiveRuleWalker397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ternary_in_synpred3_LeftRecursiveRuleWalker453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_prefix_in_synpred4_LeftRecursiveRuleWalker508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_suffix_in_synpred5_LeftRecursiveRuleWalker564 = new BitSet(new long[]{0x0000000000000002L});

}
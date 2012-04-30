// $ANTLR 3.4 SourceGenTriggers.g 2012-04-29 22:33:18

package org.antlr.v4.codegen;
import org.antlr.v4.misc.Utils;
import org.antlr.v4.codegen.model.*;
import org.antlr.v4.codegen.model.decl.*;
import org.antlr.v4.tool.*;
import org.antlr.v4.tool.ast.*;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class SourceGenTriggers extends TreeParser {
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


    public SourceGenTriggers(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public SourceGenTriggers(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return SourceGenTriggers.tokenNames; }
    public String getGrammarFileName() { return "SourceGenTriggers.g"; }


    	public OutputModelController controller;
        public boolean hasLookaheadBlock;
        public SourceGenTriggers(TreeNodeStream input, OutputModelController controller) {
        	this(input);
        	this.controller = controller;
        }



    // $ANTLR start "dummy"
    // SourceGenTriggers.g:57:1: dummy : block[null, null] ;
    public final void dummy() throws RecognitionException {
        try {
            // SourceGenTriggers.g:57:7: ( block[null, null] )
            // SourceGenTriggers.g:57:9: block[null, null]
            {
            pushFollow(FOLLOW_block_in_dummy60);
            block(null, null);

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



    // $ANTLR start "block"
    // SourceGenTriggers.g:59:1: block[GrammarAST label, GrammarAST ebnfRoot] returns [List<? extends SrcOp> omos] : ^(blk= BLOCK ( ^( OPTIONS ( . )+ ) )? ( alternative )+ ) ;
    public final List<? extends SrcOp> block(GrammarAST label, GrammarAST ebnfRoot) throws RecognitionException {
        List<? extends SrcOp> omos = null;


        GrammarAST blk=null;
        SourceGenTriggers.alternative_return alternative1 =null;


        try {
            // SourceGenTriggers.g:60:5: ( ^(blk= BLOCK ( ^( OPTIONS ( . )+ ) )? ( alternative )+ ) )
            // SourceGenTriggers.g:60:7: ^(blk= BLOCK ( ^( OPTIONS ( . )+ ) )? ( alternative )+ )
            {
            blk=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_block83); 

            match(input, Token.DOWN, null); 
            // SourceGenTriggers.g:60:20: ( ^( OPTIONS ( . )+ ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==OPTIONS) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // SourceGenTriggers.g:60:21: ^( OPTIONS ( . )+ )
                    {
                    match(input,OPTIONS,FOLLOW_OPTIONS_in_block87); 

                    match(input, Token.DOWN, null); 
                    // SourceGenTriggers.g:60:31: ( . )+
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
                    	    // SourceGenTriggers.g:60:31: .
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


            List<CodeBlockForAlt> alts = new ArrayList<CodeBlockForAlt>();

            // SourceGenTriggers.g:62:7: ( alternative )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==ALT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // SourceGenTriggers.g:62:9: alternative
            	    {
            	    pushFollow(FOLLOW_alternative_in_block108);
            	    alternative1=alternative();

            	    state._fsp--;


            	    alts.add((alternative1!=null?alternative1.altCodeBlock:null));

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



                	if ( alts.size()==1 && ebnfRoot==null) return alts;
                	if ( ebnfRoot==null ) {
                	    omos = DefaultOutputModelFactory.list(controller.getChoiceBlock((BlockAST)blk, alts, label));
                	}
                	else {
                        Choice choice = controller.getEBNFBlock(ebnfRoot, alts);
                        hasLookaheadBlock |= choice instanceof PlusBlock || choice instanceof StarBlock;
                	    omos = DefaultOutputModelFactory.list(choice);
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
        return omos;
    }
    // $ANTLR end "block"


    public static class alternative_return extends TreeRuleReturnScope {
        public CodeBlockForAlt altCodeBlock;
        public List<SrcOp> ops;
    };


    // $ANTLR start "alternative"
    // SourceGenTriggers.g:77:1: alternative returns [CodeBlockForAlt altCodeBlock, List<SrcOp> ops] : a= alt[outerMost] ;
    public final SourceGenTriggers.alternative_return alternative() throws RecognitionException {
        SourceGenTriggers.alternative_return retval = new SourceGenTriggers.alternative_return();
        retval.start = input.LT(1);


        SourceGenTriggers.alt_return a =null;



           	boolean outerMost = inContext("RULE BLOCK");

        try {
            // SourceGenTriggers.g:84:5: (a= alt[outerMost] )
            // SourceGenTriggers.g:84:7: a= alt[outerMost]
            {
            pushFollow(FOLLOW_alt_in_alternative160);
            a=alt(outerMost);

            state._fsp--;


            retval.altCodeBlock =(a!=null?a.altCodeBlock:null); retval.ops =(a!=null?a.ops:null);

            }


               	controller.finishAlternative(retval.altCodeBlock, retval.ops, outerMost);

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


    public static class alt_return extends TreeRuleReturnScope {
        public CodeBlockForAlt altCodeBlock;
        public List<SrcOp> ops;
    };


    // $ANTLR start "alt"
    // SourceGenTriggers.g:87:1: alt[boolean outerMost] returns [CodeBlockForAlt altCodeBlock, List<SrcOp> ops] : ( ^( ALT ( element )+ ) | ^( ALT EPSILON ) );
    public final SourceGenTriggers.alt_return alt(boolean outerMost) throws RecognitionException {
        SourceGenTriggers.alt_return retval = new SourceGenTriggers.alt_return();
        retval.start = input.LT(1);


        List<? extends SrcOp> element2 =null;



        	// set alt if outer ALT only (the only ones with alt field set to Alternative object)
        	AltAST altAST = (AltAST)retval.start;
        	if ( outerMost ) controller.setCurrentOuterMostAlt(altAST.alt);

        try {
            // SourceGenTriggers.g:93:2: ( ^( ALT ( element )+ ) | ^( ALT EPSILON ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==ALT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==DOWN) ) {
                    int LA5_2 = input.LA(3);

                    if ( (LA5_2==EPSILON) ) {
                        alt5=2;
                    }
                    else if ( (LA5_2==ACTION||LA5_2==ASSIGN||LA5_2==DOT||LA5_2==NOT||LA5_2==PLUS_ASSIGN||LA5_2==RANGE||LA5_2==RULE_REF||LA5_2==SEMPRED||LA5_2==STRING_LITERAL||LA5_2==TOKEN_REF||LA5_2==BLOCK||LA5_2==CLOSURE||(LA5_2 >= OPTIONAL && LA5_2 <= POSITIVE_CLOSURE)||LA5_2==SET||LA5_2==WILDCARD) ) {
                        alt5=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 2, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // SourceGenTriggers.g:93:4: ^( ALT ( element )+ )
                    {

                    		List<SrcOp> elems = new ArrayList<SrcOp>();
                    		// TODO: shouldn't we pass ((GrammarAST)retval.start) to controller.alternative()?
                    		retval.altCodeBlock = controller.alternative(controller.getCurrentOuterMostAlt(), outerMost);
                    		retval.altCodeBlock.ops = retval.ops = elems;
                    		controller.setCurrentBlock(retval.altCodeBlock);
                    		

                    match(input,ALT,FOLLOW_ALT_in_alt190); 

                    match(input, Token.DOWN, null); 
                    // SourceGenTriggers.g:100:10: ( element )+
                    int cnt4=0;
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==ACTION||LA4_0==ASSIGN||LA4_0==DOT||LA4_0==NOT||LA4_0==PLUS_ASSIGN||LA4_0==RANGE||LA4_0==RULE_REF||LA4_0==SEMPRED||LA4_0==STRING_LITERAL||LA4_0==TOKEN_REF||LA4_0==BLOCK||LA4_0==CLOSURE||(LA4_0 >= OPTIONAL && LA4_0 <= POSITIVE_CLOSURE)||LA4_0==SET||LA4_0==WILDCARD) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // SourceGenTriggers.g:100:12: element
                    	    {
                    	    pushFollow(FOLLOW_element_in_alt194);
                    	    element2=element();

                    	    state._fsp--;


                    	    if (element2!=null) elems.addAll(element2);

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
                case 2 :
                    // SourceGenTriggers.g:102:4: ^( ALT EPSILON )
                    {
                    match(input,ALT,FOLLOW_ALT_in_alt208); 

                    match(input, Token.DOWN, null); 
                    match(input,EPSILON,FOLLOW_EPSILON_in_alt210); 

                    match(input, Token.UP, null); 


                    retval.altCodeBlock = controller.epsilon(controller.getCurrentOuterMostAlt(), outerMost);

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
    // $ANTLR end "alt"



    // $ANTLR start "element"
    // SourceGenTriggers.g:106:1: element returns [List<? extends SrcOp> omos] : ( labeledElement | atom[null,false] | subrule | ACTION | SEMPRED | ^( ACTION elementOptions ) | ^( SEMPRED elementOptions ) );
    public final List<? extends SrcOp> element() throws RecognitionException {
        List<? extends SrcOp> omos = null;


        GrammarAST ACTION6=null;
        GrammarAST SEMPRED7=null;
        GrammarAST ACTION8=null;
        GrammarAST SEMPRED9=null;
        List<? extends SrcOp> labeledElement3 =null;

        List<SrcOp> atom4 =null;

        List<? extends SrcOp> subrule5 =null;


        try {
            // SourceGenTriggers.g:107:2: ( labeledElement | atom[null,false] | subrule | ACTION | SEMPRED | ^( ACTION elementOptions ) | ^( SEMPRED elementOptions ) )
            int alt6=7;
            switch ( input.LA(1) ) {
            case ASSIGN:
            case PLUS_ASSIGN:
                {
                alt6=1;
                }
                break;
            case DOT:
            case NOT:
            case RANGE:
            case RULE_REF:
            case STRING_LITERAL:
            case TOKEN_REF:
            case SET:
            case WILDCARD:
                {
                alt6=2;
                }
                break;
            case BLOCK:
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt6=3;
                }
                break;
            case ACTION:
                {
                int LA6_4 = input.LA(2);

                if ( (LA6_4==DOWN) ) {
                    alt6=6;
                }
                else if ( ((LA6_4 >= UP && LA6_4 <= ACTION)||LA6_4==ASSIGN||LA6_4==DOT||LA6_4==NOT||LA6_4==PLUS_ASSIGN||LA6_4==RANGE||LA6_4==RULE_REF||LA6_4==SEMPRED||LA6_4==STRING_LITERAL||LA6_4==TOKEN_REF||LA6_4==BLOCK||LA6_4==CLOSURE||(LA6_4 >= OPTIONAL && LA6_4 <= POSITIVE_CLOSURE)||LA6_4==SET||LA6_4==WILDCARD) ) {
                    alt6=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 4, input);

                    throw nvae;

                }
                }
                break;
            case SEMPRED:
                {
                int LA6_5 = input.LA(2);

                if ( (LA6_5==DOWN) ) {
                    alt6=7;
                }
                else if ( ((LA6_5 >= UP && LA6_5 <= ACTION)||LA6_5==ASSIGN||LA6_5==DOT||LA6_5==NOT||LA6_5==PLUS_ASSIGN||LA6_5==RANGE||LA6_5==RULE_REF||LA6_5==SEMPRED||LA6_5==STRING_LITERAL||LA6_5==TOKEN_REF||LA6_5==BLOCK||LA6_5==CLOSURE||(LA6_5 >= OPTIONAL && LA6_5 <= POSITIVE_CLOSURE)||LA6_5==SET||LA6_5==WILDCARD) ) {
                    alt6=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 5, input);

                    throw nvae;

                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }

            switch (alt6) {
                case 1 :
                    // SourceGenTriggers.g:107:4: labeledElement
                    {
                    pushFollow(FOLLOW_labeledElement_in_element239);
                    labeledElement3=labeledElement();

                    state._fsp--;


                    omos = labeledElement3;

                    }
                    break;
                case 2 :
                    // SourceGenTriggers.g:108:4: atom[null,false]
                    {
                    pushFollow(FOLLOW_atom_in_element250);
                    atom4=atom(null, false);

                    state._fsp--;


                    omos = atom4;

                    }
                    break;
                case 3 :
                    // SourceGenTriggers.g:109:4: subrule
                    {
                    pushFollow(FOLLOW_subrule_in_element260);
                    subrule5=subrule();

                    state._fsp--;


                    omos = subrule5;

                    }
                    break;
                case 4 :
                    // SourceGenTriggers.g:110:6: ACTION
                    {
                    ACTION6=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element275); 

                    omos = controller.action(ACTION6);

                    }
                    break;
                case 5 :
                    // SourceGenTriggers.g:111:6: SEMPRED
                    {
                    SEMPRED7=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element290); 

                    omos = controller.sempred(SEMPRED7);

                    }
                    break;
                case 6 :
                    // SourceGenTriggers.g:112:4: ^( ACTION elementOptions )
                    {
                    ACTION8=(GrammarAST)match(input,ACTION,FOLLOW_ACTION_in_element304); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_element306);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    omos = controller.action(ACTION8);

                    }
                    break;
                case 7 :
                    // SourceGenTriggers.g:113:6: ^( SEMPRED elementOptions )
                    {
                    SEMPRED9=(GrammarAST)match(input,SEMPRED,FOLLOW_SEMPRED_in_element318); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_elementOptions_in_element320);
                    elementOptions();

                    state._fsp--;


                    match(input, Token.UP, null); 


                    omos = controller.sempred(SEMPRED9);

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
        return omos;
    }
    // $ANTLR end "element"



    // $ANTLR start "labeledElement"
    // SourceGenTriggers.g:116:1: labeledElement returns [List<? extends SrcOp> omos] : ( ^( ASSIGN ID atom[$ID,false] ) | ^( PLUS_ASSIGN ID atom[$ID,false] ) | ^( ASSIGN ID block[$ID,null] ) | ^( PLUS_ASSIGN ID block[$ID,null] ) );
    public final List<? extends SrcOp> labeledElement() throws RecognitionException {
        List<? extends SrcOp> omos = null;


        GrammarAST ID10=null;
        GrammarAST ID12=null;
        GrammarAST ID14=null;
        GrammarAST ID16=null;
        List<SrcOp> atom11 =null;

        List<SrcOp> atom13 =null;

        List<? extends SrcOp> block15 =null;

        List<? extends SrcOp> block17 =null;


        try {
            // SourceGenTriggers.g:117:2: ( ^( ASSIGN ID atom[$ID,false] ) | ^( PLUS_ASSIGN ID atom[$ID,false] ) | ^( ASSIGN ID block[$ID,null] ) | ^( PLUS_ASSIGN ID block[$ID,null] ) )
            int alt7=4;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==ASSIGN) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==DOWN) ) {
                    int LA7_3 = input.LA(3);

                    if ( (LA7_3==ID) ) {
                        int LA7_5 = input.LA(4);

                        if ( (LA7_5==DOT||LA7_5==NOT||LA7_5==RANGE||LA7_5==RULE_REF||LA7_5==STRING_LITERAL||LA7_5==TOKEN_REF||LA7_5==SET||LA7_5==WILDCARD) ) {
                            alt7=1;
                        }
                        else if ( (LA7_5==BLOCK) ) {
                            alt7=3;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA7_0==PLUS_ASSIGN) ) {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==DOWN) ) {
                    int LA7_4 = input.LA(3);

                    if ( (LA7_4==ID) ) {
                        int LA7_6 = input.LA(4);

                        if ( (LA7_6==DOT||LA7_6==NOT||LA7_6==RANGE||LA7_6==RULE_REF||LA7_6==STRING_LITERAL||LA7_6==TOKEN_REF||LA7_6==SET||LA7_6==WILDCARD) ) {
                            alt7=2;
                        }
                        else if ( (LA7_6==BLOCK) ) {
                            alt7=4;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 7, 6, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 7, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // SourceGenTriggers.g:117:4: ^( ASSIGN ID atom[$ID,false] )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_labeledElement340); 

                    match(input, Token.DOWN, null); 
                    ID10=(GrammarAST)match(input,ID,FOLLOW_ID_in_labeledElement342); 

                    pushFollow(FOLLOW_atom_in_labeledElement344);
                    atom11=atom(ID10, false);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    omos = atom11;

                    }
                    break;
                case 2 :
                    // SourceGenTriggers.g:118:4: ^( PLUS_ASSIGN ID atom[$ID,false] )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_labeledElement357); 

                    match(input, Token.DOWN, null); 
                    ID12=(GrammarAST)match(input,ID,FOLLOW_ID_in_labeledElement359); 

                    pushFollow(FOLLOW_atom_in_labeledElement361);
                    atom13=atom(ID12, false);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    omos = atom13;

                    }
                    break;
                case 3 :
                    // SourceGenTriggers.g:119:4: ^( ASSIGN ID block[$ID,null] )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_labeledElement372); 

                    match(input, Token.DOWN, null); 
                    ID14=(GrammarAST)match(input,ID,FOLLOW_ID_in_labeledElement374); 

                    pushFollow(FOLLOW_block_in_labeledElement376);
                    block15=block(ID14, null);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    omos = block15;

                    }
                    break;
                case 4 :
                    // SourceGenTriggers.g:120:4: ^( PLUS_ASSIGN ID block[$ID,null] )
                    {
                    match(input,PLUS_ASSIGN,FOLLOW_PLUS_ASSIGN_in_labeledElement389); 

                    match(input, Token.DOWN, null); 
                    ID16=(GrammarAST)match(input,ID,FOLLOW_ID_in_labeledElement391); 

                    pushFollow(FOLLOW_block_in_labeledElement393);
                    block17=block(ID16, null);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    omos = block17;

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
        return omos;
    }
    // $ANTLR end "labeledElement"



    // $ANTLR start "subrule"
    // SourceGenTriggers.g:123:1: subrule returns [List<? extends SrcOp> omos] : ( ^( OPTIONAL b= block[null,$OPTIONAL] ) | ( ^(op= CLOSURE b= block[null,null] ) | ^(op= POSITIVE_CLOSURE b= block[null,null] ) ) | block[null, null] );
    public final List<? extends SrcOp> subrule() throws RecognitionException {
        List<? extends SrcOp> omos = null;


        GrammarAST op=null;
        GrammarAST OPTIONAL18=null;
        List<? extends SrcOp> b =null;

        List<? extends SrcOp> block19 =null;


        try {
            // SourceGenTriggers.g:124:2: ( ^( OPTIONAL b= block[null,$OPTIONAL] ) | ( ^(op= CLOSURE b= block[null,null] ) | ^(op= POSITIVE_CLOSURE b= block[null,null] ) ) | block[null, null] )
            int alt9=3;
            switch ( input.LA(1) ) {
            case OPTIONAL:
                {
                alt9=1;
                }
                break;
            case CLOSURE:
            case POSITIVE_CLOSURE:
                {
                alt9=2;
                }
                break;
            case BLOCK:
                {
                alt9=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }

            switch (alt9) {
                case 1 :
                    // SourceGenTriggers.g:124:4: ^( OPTIONAL b= block[null,$OPTIONAL] )
                    {
                    OPTIONAL18=(GrammarAST)match(input,OPTIONAL,FOLLOW_OPTIONAL_in_subrule414); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_block_in_subrule418);
                    b=block(null, OPTIONAL18);

                    state._fsp--;


                    match(input, Token.UP, null); 



                    		omos = b;
                    		

                    }
                    break;
                case 2 :
                    // SourceGenTriggers.g:128:4: ( ^(op= CLOSURE b= block[null,null] ) | ^(op= POSITIVE_CLOSURE b= block[null,null] ) )
                    {
                    // SourceGenTriggers.g:128:4: ( ^(op= CLOSURE b= block[null,null] ) | ^(op= POSITIVE_CLOSURE b= block[null,null] ) )
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==CLOSURE) ) {
                        alt8=1;
                    }
                    else if ( (LA8_0==POSITIVE_CLOSURE) ) {
                        alt8=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 0, input);

                        throw nvae;

                    }
                    switch (alt8) {
                        case 1 :
                            // SourceGenTriggers.g:128:6: ^(op= CLOSURE b= block[null,null] )
                            {
                            op=(GrammarAST)match(input,CLOSURE,FOLLOW_CLOSURE_in_subrule434); 

                            match(input, Token.DOWN, null); 
                            pushFollow(FOLLOW_block_in_subrule438);
                            b=block(null, null);

                            state._fsp--;


                            match(input, Token.UP, null); 


                            }
                            break;
                        case 2 :
                            // SourceGenTriggers.g:129:5: ^(op= POSITIVE_CLOSURE b= block[null,null] )
                            {
                            op=(GrammarAST)match(input,POSITIVE_CLOSURE,FOLLOW_POSITIVE_CLOSURE_in_subrule449); 

                            match(input, Token.DOWN, null); 
                            pushFollow(FOLLOW_block_in_subrule453);
                            b=block(null, null);

                            state._fsp--;


                            match(input, Token.UP, null); 


                            }
                            break;

                    }



                    		List<CodeBlockForAlt> alts = new ArrayList<CodeBlockForAlt>();
                    		SrcOp blk = b.get(0);
                    		CodeBlockForAlt alt = new CodeBlockForAlt(controller.delegate);
                    		alt.addOp(blk);
                    		alts.add(alt);
                    		SrcOp loop = controller.getEBNFBlock(op, alts); // "star it"
                            hasLookaheadBlock |= loop instanceof PlusBlock || loop instanceof StarBlock;
                       	    omos = DefaultOutputModelFactory.list(loop);
                    		

                    }
                    break;
                case 3 :
                    // SourceGenTriggers.g:141:5: block[null, null]
                    {
                    pushFollow(FOLLOW_block_in_subrule469);
                    block19=block(null, null);

                    state._fsp--;


                    omos = block19;

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
        return omos;
    }
    // $ANTLR end "subrule"



    // $ANTLR start "blockSet"
    // SourceGenTriggers.g:144:1: blockSet[GrammarAST label, boolean invert] returns [List<SrcOp> omos] : ^( SET ( atom[label,invert] )+ ) ;
    public final List<SrcOp> blockSet(GrammarAST label, boolean invert) throws RecognitionException {
        List<SrcOp> omos = null;


        GrammarAST SET20=null;

        try {
            // SourceGenTriggers.g:145:5: ( ^( SET ( atom[label,invert] )+ ) )
            // SourceGenTriggers.g:145:7: ^( SET ( atom[label,invert] )+ )
            {
            SET20=(GrammarAST)match(input,SET,FOLLOW_SET_in_blockSet499); 

            match(input, Token.DOWN, null); 
            // SourceGenTriggers.g:145:13: ( atom[label,invert] )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==DOT||LA10_0==NOT||LA10_0==RANGE||LA10_0==RULE_REF||LA10_0==STRING_LITERAL||LA10_0==TOKEN_REF||LA10_0==SET||LA10_0==WILDCARD) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // SourceGenTriggers.g:145:13: atom[label,invert]
            	    {
            	    pushFollow(FOLLOW_atom_in_blockSet501);
            	    atom(label, invert);

            	    state._fsp--;


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


            match(input, Token.UP, null); 


            omos = controller.set(SET20, label, invert);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return omos;
    }
    // $ANTLR end "blockSet"



    // $ANTLR start "atom"
    // SourceGenTriggers.g:158:1: atom[GrammarAST label, boolean invert] returns [List<SrcOp> omos] : ( ^( NOT a= atom[$label, true] ) | range[label] | ^( DOT ID terminal[$label] ) | ^( DOT ID ruleref[$label] ) | ^( WILDCARD . ) | WILDCARD | terminal[label] | ruleref[label] | blockSet[$label, invert] );
    public final List<SrcOp> atom(GrammarAST label, boolean invert) throws RecognitionException {
        List<SrcOp> omos = null;


        GrammarAST WILDCARD22=null;
        GrammarAST WILDCARD23=null;
        List<SrcOp> a =null;

        List<SrcOp> range21 =null;

        List<SrcOp> terminal24 =null;

        List<SrcOp> ruleref25 =null;

        List<SrcOp> blockSet26 =null;


        try {
            // SourceGenTriggers.g:159:2: ( ^( NOT a= atom[$label, true] ) | range[label] | ^( DOT ID terminal[$label] ) | ^( DOT ID ruleref[$label] ) | ^( WILDCARD . ) | WILDCARD | terminal[label] | ruleref[label] | blockSet[$label, invert] )
            int alt11=9;
            switch ( input.LA(1) ) {
            case NOT:
                {
                alt11=1;
                }
                break;
            case RANGE:
                {
                alt11=2;
                }
                break;
            case DOT:
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3==DOWN) ) {
                    int LA11_8 = input.LA(3);

                    if ( (LA11_8==ID) ) {
                        int LA11_11 = input.LA(4);

                        if ( (LA11_11==STRING_LITERAL||LA11_11==TOKEN_REF) ) {
                            alt11=3;
                        }
                        else if ( (LA11_11==RULE_REF) ) {
                            alt11=4;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 11, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 8, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;

                }
                }
                break;
            case WILDCARD:
                {
                int LA11_4 = input.LA(2);

                if ( (LA11_4==DOWN) ) {
                    alt11=5;
                }
                else if ( ((LA11_4 >= UP && LA11_4 <= ACTION)||LA11_4==ASSIGN||LA11_4==DOT||LA11_4==NOT||LA11_4==PLUS_ASSIGN||LA11_4==RANGE||LA11_4==RULE_REF||LA11_4==SEMPRED||LA11_4==STRING_LITERAL||LA11_4==TOKEN_REF||LA11_4==BLOCK||LA11_4==CLOSURE||(LA11_4 >= OPTIONAL && LA11_4 <= POSITIVE_CLOSURE)||LA11_4==SET||LA11_4==WILDCARD) ) {
                    alt11=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 4, input);

                    throw nvae;

                }
                }
                break;
            case STRING_LITERAL:
            case TOKEN_REF:
                {
                alt11=7;
                }
                break;
            case RULE_REF:
                {
                alt11=8;
                }
                break;
            case SET:
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
                    // SourceGenTriggers.g:159:4: ^( NOT a= atom[$label, true] )
                    {
                    match(input,NOT,FOLLOW_NOT_in_atom531); 

                    match(input, Token.DOWN, null); 
                    pushFollow(FOLLOW_atom_in_atom535);
                    a=atom(label, true);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    omos = a;

                    }
                    break;
                case 2 :
                    // SourceGenTriggers.g:160:4: range[label]
                    {
                    pushFollow(FOLLOW_range_in_atom545);
                    range21=range(label);

                    state._fsp--;


                    omos = range21;

                    }
                    break;
                case 3 :
                    // SourceGenTriggers.g:161:4: ^( DOT ID terminal[$label] )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom560); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_atom562); 

                    pushFollow(FOLLOW_terminal_in_atom564);
                    terminal(label);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 4 :
                    // SourceGenTriggers.g:162:4: ^( DOT ID ruleref[$label] )
                    {
                    match(input,DOT,FOLLOW_DOT_in_atom572); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_atom574); 

                    pushFollow(FOLLOW_ruleref_in_atom576);
                    ruleref(label);

                    state._fsp--;


                    match(input, Token.UP, null); 


                    }
                    break;
                case 5 :
                    // SourceGenTriggers.g:163:7: ^( WILDCARD . )
                    {
                    WILDCARD22=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom587); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    omos = controller.wildcard(WILDCARD22, label);

                    }
                    break;
                case 6 :
                    // SourceGenTriggers.g:164:7: WILDCARD
                    {
                    WILDCARD23=(GrammarAST)match(input,WILDCARD,FOLLOW_WILDCARD_in_atom606); 

                    omos = controller.wildcard(WILDCARD23, label);

                    }
                    break;
                case 7 :
                    // SourceGenTriggers.g:165:9: terminal[label]
                    {
                    pushFollow(FOLLOW_terminal_in_atom625);
                    terminal24=terminal(label);

                    state._fsp--;


                    omos = terminal24;

                    }
                    break;
                case 8 :
                    // SourceGenTriggers.g:166:9: ruleref[label]
                    {
                    pushFollow(FOLLOW_ruleref_in_atom642);
                    ruleref25=ruleref(label);

                    state._fsp--;


                    omos = ruleref25;

                    }
                    break;
                case 9 :
                    // SourceGenTriggers.g:167:4: blockSet[$label, invert]
                    {
                    pushFollow(FOLLOW_blockSet_in_atom654);
                    blockSet26=blockSet(label, invert);

                    state._fsp--;


                    omos = blockSet26;

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
        return omos;
    }
    // $ANTLR end "atom"



    // $ANTLR start "ruleref"
    // SourceGenTriggers.g:170:1: ruleref[GrammarAST label] returns [List<SrcOp> omos] : ^( RULE_REF ( ARG_ACTION )? ) ;
    public final List<SrcOp> ruleref(GrammarAST label) throws RecognitionException {
        List<SrcOp> omos = null;


        GrammarAST RULE_REF27=null;
        GrammarAST ARG_ACTION28=null;

        try {
            // SourceGenTriggers.g:171:5: ( ^( RULE_REF ( ARG_ACTION )? ) )
            // SourceGenTriggers.g:171:7: ^( RULE_REF ( ARG_ACTION )? )
            {
            RULE_REF27=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_ruleref678); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // SourceGenTriggers.g:171:18: ( ARG_ACTION )?
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==ARG_ACTION) ) {
                    alt12=1;
                }
                switch (alt12) {
                    case 1 :
                        // SourceGenTriggers.g:171:18: ARG_ACTION
                        {
                        ARG_ACTION28=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_ruleref680); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            omos = controller.ruleRef(RULE_REF27, label, ARG_ACTION28);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return omos;
    }
    // $ANTLR end "ruleref"



    // $ANTLR start "range"
    // SourceGenTriggers.g:174:1: range[GrammarAST label] returns [List<SrcOp> omos] : ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) ;
    public final List<SrcOp> range(GrammarAST label) throws RecognitionException {
        List<SrcOp> omos = null;


        GrammarAST a=null;
        GrammarAST b=null;

        try {
            // SourceGenTriggers.g:175:5: ( ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) )
            // SourceGenTriggers.g:175:7: ^( RANGE a= STRING_LITERAL b= STRING_LITERAL )
            {
            match(input,RANGE,FOLLOW_RANGE_in_range708); 

            match(input, Token.DOWN, null); 
            a=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range712); 

            b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_range716); 

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
        return omos;
    }
    // $ANTLR end "range"



    // $ANTLR start "terminal"
    // SourceGenTriggers.g:178:1: terminal[GrammarAST label] returns [List<SrcOp> omos] : ( ^( STRING_LITERAL . ) | STRING_LITERAL | ^( TOKEN_REF ARG_ACTION . ) | ^( TOKEN_REF . ) | TOKEN_REF );
    public final List<SrcOp> terminal(GrammarAST label) throws RecognitionException {
        List<SrcOp> omos = null;


        GrammarAST STRING_LITERAL29=null;
        GrammarAST STRING_LITERAL30=null;
        GrammarAST TOKEN_REF31=null;
        GrammarAST ARG_ACTION32=null;
        GrammarAST TOKEN_REF33=null;
        GrammarAST TOKEN_REF34=null;

        try {
            // SourceGenTriggers.g:179:5: ( ^( STRING_LITERAL . ) | STRING_LITERAL | ^( TOKEN_REF ARG_ACTION . ) | ^( TOKEN_REF . ) | TOKEN_REF )
            int alt13=5;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==STRING_LITERAL) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==DOWN) ) {
                    alt13=1;
                }
                else if ( ((LA13_1 >= UP && LA13_1 <= ACTION)||LA13_1==ASSIGN||LA13_1==DOT||LA13_1==NOT||LA13_1==PLUS_ASSIGN||LA13_1==RANGE||LA13_1==RULE_REF||LA13_1==SEMPRED||LA13_1==STRING_LITERAL||LA13_1==TOKEN_REF||LA13_1==BLOCK||LA13_1==CLOSURE||(LA13_1 >= OPTIONAL && LA13_1 <= POSITIVE_CLOSURE)||LA13_1==SET||LA13_1==WILDCARD) ) {
                    alt13=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;

                }
            }
            else if ( (LA13_0==TOKEN_REF) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==DOWN) ) {
                    int LA13_5 = input.LA(3);

                    if ( (LA13_5==ARG_ACTION) ) {
                        int LA13_7 = input.LA(4);

                        if ( ((LA13_7 >= ACTION && LA13_7 <= WILDCARD)) ) {
                            alt13=3;
                        }
                        else if ( ((LA13_7 >= DOWN && LA13_7 <= UP)) ) {
                            alt13=4;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 7, input);

                            throw nvae;

                        }
                    }
                    else if ( ((LA13_5 >= ACTION && LA13_5 <= ACTION_STRING_LITERAL)||(LA13_5 >= ARG_OR_CHARSET && LA13_5 <= WILDCARD)) ) {
                        alt13=4;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 5, input);

                        throw nvae;

                    }
                }
                else if ( ((LA13_2 >= UP && LA13_2 <= ACTION)||LA13_2==ASSIGN||LA13_2==DOT||LA13_2==NOT||LA13_2==PLUS_ASSIGN||LA13_2==RANGE||LA13_2==RULE_REF||LA13_2==SEMPRED||LA13_2==STRING_LITERAL||LA13_2==TOKEN_REF||LA13_2==BLOCK||LA13_2==CLOSURE||(LA13_2 >= OPTIONAL && LA13_2 <= POSITIVE_CLOSURE)||LA13_2==SET||LA13_2==WILDCARD) ) {
                    alt13=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // SourceGenTriggers.g:179:8: ^( STRING_LITERAL . )
                    {
                    STRING_LITERAL29=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal741); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    omos = controller.stringRef(STRING_LITERAL29, label);

                    }
                    break;
                case 2 :
                    // SourceGenTriggers.g:180:7: STRING_LITERAL
                    {
                    STRING_LITERAL30=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_terminal756); 

                    omos = controller.stringRef(STRING_LITERAL30, label);

                    }
                    break;
                case 3 :
                    // SourceGenTriggers.g:181:7: ^( TOKEN_REF ARG_ACTION . )
                    {
                    TOKEN_REF31=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal770); 

                    match(input, Token.DOWN, null); 
                    ARG_ACTION32=(GrammarAST)match(input,ARG_ACTION,FOLLOW_ARG_ACTION_in_terminal772); 

                    matchAny(input); 

                    match(input, Token.UP, null); 


                    omos = controller.tokenRef(TOKEN_REF31, label, ARG_ACTION32);

                    }
                    break;
                case 4 :
                    // SourceGenTriggers.g:182:7: ^( TOKEN_REF . )
                    {
                    TOKEN_REF33=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal786); 

                    match(input, Token.DOWN, null); 
                    matchAny(input); 

                    match(input, Token.UP, null); 


                    omos = controller.tokenRef(TOKEN_REF33, label, null);

                    }
                    break;
                case 5 :
                    // SourceGenTriggers.g:183:7: TOKEN_REF
                    {
                    TOKEN_REF34=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_terminal802); 

                    omos = controller.tokenRef(TOKEN_REF34, label, null);

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
        return omos;
    }
    // $ANTLR end "terminal"



    // $ANTLR start "elementOptions"
    // SourceGenTriggers.g:186:1: elementOptions : ^( ELEMENT_OPTIONS ( elementOption )+ ) ;
    public final void elementOptions() throws RecognitionException {
        try {
            // SourceGenTriggers.g:187:5: ( ^( ELEMENT_OPTIONS ( elementOption )+ ) )
            // SourceGenTriggers.g:187:7: ^( ELEMENT_OPTIONS ( elementOption )+ )
            {
            match(input,ELEMENT_OPTIONS,FOLLOW_ELEMENT_OPTIONS_in_elementOptions826); 

            match(input, Token.DOWN, null); 
            // SourceGenTriggers.g:187:25: ( elementOption )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==ASSIGN||LA14_0==ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // SourceGenTriggers.g:187:25: elementOption
            	    {
            	    pushFollow(FOLLOW_elementOption_in_elementOptions828);
            	    elementOption();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
    // $ANTLR end "elementOptions"



    // $ANTLR start "elementOption"
    // SourceGenTriggers.g:190:1: elementOption : ( ID | ^( ASSIGN ID ID ) | ^( ASSIGN ID STRING_LITERAL ) | ^( ASSIGN ID ACTION ) );
    public final void elementOption() throws RecognitionException {
        try {
            // SourceGenTriggers.g:191:5: ( ID | ^( ASSIGN ID ID ) | ^( ASSIGN ID STRING_LITERAL ) | ^( ASSIGN ID ACTION ) )
            int alt15=4;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==ID) ) {
                alt15=1;
            }
            else if ( (LA15_0==ASSIGN) ) {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==DOWN) ) {
                    int LA15_3 = input.LA(3);

                    if ( (LA15_3==ID) ) {
                        switch ( input.LA(4) ) {
                        case ID:
                            {
                            alt15=2;
                            }
                            break;
                        case STRING_LITERAL:
                            {
                            alt15=3;
                            }
                            break;
                        case ACTION:
                            {
                            alt15=4;
                            }
                            break;
                        default:
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 4, input);

                            throw nvae;

                        }

                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }
            switch (alt15) {
                case 1 :
                    // SourceGenTriggers.g:191:7: ID
                    {
                    match(input,ID,FOLLOW_ID_in_elementOption847); 

                    }
                    break;
                case 2 :
                    // SourceGenTriggers.g:192:9: ^( ASSIGN ID ID )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption858); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_elementOption860); 

                    match(input,ID,FOLLOW_ID_in_elementOption862); 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // SourceGenTriggers.g:193:9: ^( ASSIGN ID STRING_LITERAL )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption874); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_elementOption876); 

                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_elementOption878); 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 4 :
                    // SourceGenTriggers.g:194:9: ^( ASSIGN ID ACTION )
                    {
                    match(input,ASSIGN,FOLLOW_ASSIGN_in_elementOption890); 

                    match(input, Token.DOWN, null); 
                    match(input,ID,FOLLOW_ID_in_elementOption892); 

                    match(input,ACTION,FOLLOW_ACTION_in_elementOption894); 

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
    // $ANTLR end "elementOption"

    // Delegated rules


 

    public static final BitSet FOLLOW_block_in_dummy60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BLOCK_in_block83 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OPTIONS_in_block87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_alternative_in_block108 = new BitSet(new long[]{0x0000000000000008L,0x0000000000000040L});
    public static final BitSet FOLLOW_alt_in_alternative160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_alt190 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_element_in_alt194 = new BitSet(new long[]{0x4A10408000080418L,0x0000000140601402L});
    public static final BitSet FOLLOW_ALT_in_alt208 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_EPSILON_in_alt210 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_labeledElement_in_element239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_element250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_subrule_in_element260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMPRED_in_element290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ACTION_in_element304 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_element306 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_SEMPRED_in_element318 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOptions_in_element320 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement340 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledElement342 = new BitSet(new long[]{0x4210008000080000L,0x0000000140000002L});
    public static final BitSet FOLLOW_atom_in_labeledElement344 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement357 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledElement359 = new BitSet(new long[]{0x4210008000080000L,0x0000000140000002L});
    public static final BitSet FOLLOW_atom_in_labeledElement361 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_labeledElement372 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledElement374 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_block_in_labeledElement376 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_PLUS_ASSIGN_in_labeledElement389 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_labeledElement391 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_block_in_labeledElement393 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_OPTIONAL_in_subrule414 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_subrule418 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_CLOSURE_in_subrule434 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_subrule438 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_POSITIVE_CLOSURE_in_subrule449 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_subrule453 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_block_in_subrule469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_blockSet499 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_blockSet501 = new BitSet(new long[]{0x4210008000080008L,0x0000000140000002L});
    public static final BitSet FOLLOW_NOT_in_atom531 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_atom_in_atom535 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_range_in_atom545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DOT_in_atom560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom562 = new BitSet(new long[]{0x4000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom564 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOT_in_atom572 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_atom574 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_ruleref_in_atom576 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_WILDCARD_in_atom587 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_WILDCARD_in_atom606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_terminal_in_atom625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleref_in_atom642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockSet_in_atom654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_REF_in_ruleref678 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_ruleref680 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RANGE_in_range708 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range712 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_range716 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal741 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_terminal756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal770 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ARG_ACTION_in_terminal772 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000001FFFFFFFFL});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal786 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_terminal802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELEMENT_OPTIONS_in_elementOptions826 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_elementOption_in_elementOptions828 = new BitSet(new long[]{0x0000000010000408L});
    public static final BitSet FOLLOW_ID_in_elementOption847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption858 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption860 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_ID_in_elementOption862 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption874 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption876 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_elementOption878 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ASSIGN_in_elementOption890 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ID_in_elementOption892 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ACTION_in_elementOption894 = new BitSet(new long[]{0x0000000000000008L});

}
// $ANTLR 3.4 BlockSetTransformer.g 2012-04-29 22:33:16

package org.antlr.v4.parse;
import org.antlr.v4.misc.Utils;
import org.antlr.v4.misc.*;
import org.antlr.v4.tool.*;
import org.antlr.v4.tool.ast.*;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import org.antlr.v4.runtime.misc.IntervalSet;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class BlockSetTransformer extends TreeRewriter {
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
    public TreeRewriter[] getDelegates() {
        return new TreeRewriter[] {};
    }

    // delegators


    public BlockSetTransformer(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public BlockSetTransformer(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return BlockSetTransformer.tokenNames; }
    public String getGrammarFileName() { return "BlockSetTransformer.g"; }


    public String currentRuleName;
    public GrammarAST currentAlt;
    public Set<String> rewriteElems = new HashSet<String>();
    public Grammar g;
    public BlockSetTransformer(TreeNodeStream input, Grammar g) {
        this(input, new RecognizerSharedState());
        this.g = g;
    }


    public static class topdown_return extends TreeRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "topdown"
    // BlockSetTransformer.g:34:1: topdown : ( ^( RULE (id= TOKEN_REF |id= RULE_REF ) ( . )+ ) | setAlt | ebnfBlockSet | blockSet );
    public final BlockSetTransformer.topdown_return topdown() throws RecognitionException {
        BlockSetTransformer.topdown_return retval = new BlockSetTransformer.topdown_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        GrammarAST _first_0 = null;
        GrammarAST _last = null;

        GrammarAST id=null;
        GrammarAST RULE1=null;
        GrammarAST wildcard2=null;
        BlockSetTransformer.setAlt_return setAlt3 =null;

        BlockSetTransformer.ebnfBlockSet_return ebnfBlockSet4 =null;

        BlockSetTransformer.blockSet_return blockSet5 =null;


        GrammarAST id_tree=null;
        GrammarAST RULE1_tree=null;
        GrammarAST wildcard2_tree=null;

        try {
            // BlockSetTransformer.g:35:5: ( ^( RULE (id= TOKEN_REF |id= RULE_REF ) ( . )+ ) | setAlt | ebnfBlockSet | blockSet )
            int alt3=4;
            switch ( input.LA(1) ) {
            case RULE:
                {
                alt3=1;
                }
                break;
            case ALT:
                {
                alt3=2;
                }
                break;
            case CLOSURE:
            case OPTIONAL:
            case POSITIVE_CLOSURE:
                {
                alt3=3;
                }
                break;
            case BLOCK:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // BlockSetTransformer.g:35:7: ^( RULE (id= TOKEN_REF |id= RULE_REF ) ( . )+ )
                    {
                    _last = (GrammarAST)input.LT(1);
                    {
                    GrammarAST _save_last_1 = _last;
                    GrammarAST _first_1 = null;
                    _last = (GrammarAST)input.LT(1);
                    RULE1=(GrammarAST)match(input,RULE,FOLLOW_RULE_in_topdown83); if (state.failed) return retval;


                    if ( state.backtracking==1 )
                    if ( _first_0==null ) _first_0 = RULE1;
                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    // BlockSetTransformer.g:35:14: (id= TOKEN_REF |id= RULE_REF )
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==TOKEN_REF) ) {
                        alt1=1;
                    }
                    else if ( (LA1_0==RULE_REF) ) {
                        alt1=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 0, input);

                        throw nvae;

                    }
                    switch (alt1) {
                        case 1 :
                            // BlockSetTransformer.g:35:15: id= TOKEN_REF
                            {
                            _last = (GrammarAST)input.LT(1);
                            id=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_topdown88); if (state.failed) return retval;
                             
                            if ( state.backtracking==1 )
                            if ( _first_1==null ) _first_1 = id;


                            if ( state.backtracking==1 ) {
                            retval.tree = (GrammarAST)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                            }
                            }
                            break;
                        case 2 :
                            // BlockSetTransformer.g:35:28: id= RULE_REF
                            {
                            _last = (GrammarAST)input.LT(1);
                            id=(GrammarAST)match(input,RULE_REF,FOLLOW_RULE_REF_in_topdown92); if (state.failed) return retval;
                             
                            if ( state.backtracking==1 )
                            if ( _first_1==null ) _first_1 = id;


                            if ( state.backtracking==1 ) {
                            retval.tree = (GrammarAST)_first_0;
                            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                                retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                            }
                            }
                            break;

                    }


                    if ( state.backtracking==1 ) {currentRuleName=(id!=null?id.getText():null);}

                    // BlockSetTransformer.g:35:69: ( . )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= ACTION && LA2_0 <= WILDCARD)) ) {
                            alt2=1;
                        }
                        else if ( (LA2_0==UP) ) {
                            alt2=2;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // BlockSetTransformer.g:35:69: .
                    	    {
                    	    _last = (GrammarAST)input.LT(1);
                    	    wildcard2=(GrammarAST)input.LT(1);

                    	    matchAny(input); if (state.failed) return retval;
                    	     
                    	    if ( state.backtracking==1 )
                    	    if ( _first_1==null ) _first_1 = wildcard2;


                    	    if ( state.backtracking==1 ) {
                    	    retval.tree = (GrammarAST)_first_0;
                    	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                    	        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    	    }
                    	    }
                    	    break;

                    	default :
                    	    if ( cnt2 >= 1 ) break loop2;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(2, input);
                                throw eee;
                        }
                        cnt2++;
                    } while (true);


                    match(input, Token.UP, null); if (state.failed) return retval;
                    _last = _save_last_1;
                    }


                    if ( state.backtracking==1 ) {
                    retval.tree = (GrammarAST)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    }
                    }
                    break;
                case 2 :
                    // BlockSetTransformer.g:36:7: setAlt
                    {
                    _last = (GrammarAST)input.LT(1);
                    pushFollow(FOLLOW_setAlt_in_topdown107);
                    setAlt3=setAlt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) 
                     
                    if ( _first_0==null ) _first_0 = setAlt3.tree;


                    if ( state.backtracking==1 ) {
                    retval.tree = (GrammarAST)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    }
                    }
                    break;
                case 3 :
                    // BlockSetTransformer.g:37:7: ebnfBlockSet
                    {
                    _last = (GrammarAST)input.LT(1);
                    pushFollow(FOLLOW_ebnfBlockSet_in_topdown115);
                    ebnfBlockSet4=ebnfBlockSet();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) 
                     
                    if ( _first_0==null ) _first_0 = ebnfBlockSet4.tree;


                    if ( state.backtracking==1 ) {
                    retval.tree = (GrammarAST)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    }
                    }
                    break;
                case 4 :
                    // BlockSetTransformer.g:38:7: blockSet
                    {
                    _last = (GrammarAST)input.LT(1);
                    pushFollow(FOLLOW_blockSet_in_topdown123);
                    blockSet5=blockSet();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==1 ) 
                     
                    if ( _first_0==null ) _first_0 = blockSet5.tree;


                    if ( state.backtracking==1 ) {
                    retval.tree = (GrammarAST)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    }
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
    // $ANTLR end "topdown"


    public static class setAlt_return extends TreeRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "setAlt"
    // BlockSetTransformer.g:41:1: setAlt :{...}? ALT ;
    public final BlockSetTransformer.setAlt_return setAlt() throws RecognitionException {
        BlockSetTransformer.setAlt_return retval = new BlockSetTransformer.setAlt_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        GrammarAST _first_0 = null;
        GrammarAST _last = null;

        GrammarAST ALT6=null;

        GrammarAST ALT6_tree=null;

        try {
            // BlockSetTransformer.g:42:2: ({...}? ALT )
            // BlockSetTransformer.g:42:4: {...}? ALT
            {
            if ( !((inContext("RULE BLOCK"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "setAlt", "inContext(\"RULE BLOCK\")");
            }

            _last = (GrammarAST)input.LT(1);
            ALT6=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_setAlt138); if (state.failed) return retval;
             
            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = ALT6;


            if ( state.backtracking==1 ) {currentAlt = ((GrammarAST)retval.start); rewriteElems.clear();}

            if ( state.backtracking==1 ) {
            retval.tree = (GrammarAST)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
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
    // $ANTLR end "setAlt"


    public static class ebnfBlockSet_return extends TreeRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ebnfBlockSet"
    // BlockSetTransformer.g:47:1: ebnfBlockSet : ^( ebnfSuffix blockSet ) -> ^( ebnfSuffix ^( BLOCK ^( ALT blockSet ) ) ) ;
    public final BlockSetTransformer.ebnfBlockSet_return ebnfBlockSet() throws RecognitionException {
        BlockSetTransformer.ebnfBlockSet_return retval = new BlockSetTransformer.ebnfBlockSet_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        GrammarAST _first_0 = null;
        GrammarAST _last = null;

        BlockSetTransformer.ebnfSuffix_return ebnfSuffix7 =null;

        BlockSetTransformer.blockSet_return blockSet8 =null;


        RewriteRuleSubtreeStream stream_ebnfSuffix=new RewriteRuleSubtreeStream(adaptor,"rule ebnfSuffix");
        RewriteRuleSubtreeStream stream_blockSet=new RewriteRuleSubtreeStream(adaptor,"rule blockSet");
        try {
            // BlockSetTransformer.g:51:2: ( ^( ebnfSuffix blockSet ) -> ^( ebnfSuffix ^( BLOCK ^( ALT blockSet ) ) ) )
            // BlockSetTransformer.g:51:4: ^( ebnfSuffix blockSet )
            {
            _last = (GrammarAST)input.LT(1);
            {
            GrammarAST _save_last_1 = _last;
            GrammarAST _first_1 = null;
            _last = (GrammarAST)input.LT(1);
            pushFollow(FOLLOW_ebnfSuffix_in_ebnfBlockSet158);
            ebnfSuffix7=ebnfSuffix();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==1 ) stream_ebnfSuffix.add(ebnfSuffix7.getTree());

            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = ebnfSuffix7.tree;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (GrammarAST)input.LT(1);
            pushFollow(FOLLOW_blockSet_in_ebnfBlockSet160);
            blockSet8=blockSet();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==1 ) stream_blockSet.add(blockSet8.getTree());

            match(input, Token.UP, null); if (state.failed) return retval;
            _last = _save_last_1;
            }


            // AST REWRITE
            // elements: ebnfSuffix, blockSet
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==1 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 51:27: -> ^( ebnfSuffix ^( BLOCK ^( ALT blockSet ) ) )
            {
                // BlockSetTransformer.g:51:30: ^( ebnfSuffix ^( BLOCK ^( ALT blockSet ) ) )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(stream_ebnfSuffix.nextNode(), root_1);

                // BlockSetTransformer.g:51:43: ^( BLOCK ^( ALT blockSet ) )
                {
                GrammarAST root_2 = (GrammarAST)adaptor.nil();
                root_2 = (GrammarAST)adaptor.becomeRoot(
                new BlockAST(BLOCK)
                , root_2);

                // BlockSetTransformer.g:51:61: ^( ALT blockSet )
                {
                GrammarAST root_3 = (GrammarAST)adaptor.nil();
                root_3 = (GrammarAST)adaptor.becomeRoot(
                new AltAST(ALT)
                , root_3);

                adaptor.addChild(root_3, stream_blockSet.nextTree());

                adaptor.addChild(root_2, root_3);
                }

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            input.replaceChildren(adaptor.getParent(retval.start),
                                  adaptor.getChildIndex(retval.start),
                                  adaptor.getChildIndex(_last),
                                  retval.tree);
            }

            }

            if ( state.backtracking==1 ) {
            	GrammarTransformPipeline.setGrammarPtr(g, ((GrammarAST)retval.tree));
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
    // $ANTLR end "ebnfBlockSet"


    public static class ebnfSuffix_return extends TreeRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ebnfSuffix"
    // BlockSetTransformer.g:54:1: ebnfSuffix : ( OPTIONAL | CLOSURE | POSITIVE_CLOSURE );
    public final BlockSetTransformer.ebnfSuffix_return ebnfSuffix() throws RecognitionException {
        BlockSetTransformer.ebnfSuffix_return retval = new BlockSetTransformer.ebnfSuffix_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        GrammarAST _first_0 = null;
        GrammarAST _last = null;

        GrammarAST set9=null;

        GrammarAST set9_tree=null;

        try {
            // BlockSetTransformer.g:56:2: ( OPTIONAL | CLOSURE | POSITIVE_CLOSURE )
            // BlockSetTransformer.g:
            {
            _last = (GrammarAST)input.LT(1);
            set9=(GrammarAST)input.LT(1);

            if ( input.LA(1)==CLOSURE||(input.LA(1) >= OPTIONAL && input.LA(1) <= POSITIVE_CLOSURE) ) {
                input.consume();
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            if ( state.backtracking==1 ) {
            retval.tree = (GrammarAST)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
            } 

            }

            if ( state.backtracking==1 ) {retval.tree = (GrammarAST)adaptor.dupNode(((GrammarAST)retval.start));}
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
    // $ANTLR end "ebnfSuffix"


    public static class blockSet_return extends TreeRuleReturnScope {
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "blockSet"
    // BlockSetTransformer.g:61:1: blockSet :{...}? ^( BLOCK ^( ALT setElement[inLexer] ) ( ^( ALT setElement[inLexer] ) )+ ) -> ^( SET[$BLOCK.token, \"SET\"] ( setElement )+ ) ;
    public final BlockSetTransformer.blockSet_return blockSet() throws RecognitionException {
        BlockSetTransformer.blockSet_return retval = new BlockSetTransformer.blockSet_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        GrammarAST _first_0 = null;
        GrammarAST _last = null;

        GrammarAST BLOCK10=null;
        GrammarAST ALT11=null;
        GrammarAST ALT13=null;
        BlockSetTransformer.setElement_return setElement12 =null;

        BlockSetTransformer.setElement_return setElement14 =null;


        GrammarAST BLOCK10_tree=null;
        GrammarAST ALT11_tree=null;
        GrammarAST ALT13_tree=null;
        RewriteRuleNodeStream stream_ALT=new RewriteRuleNodeStream(adaptor,"token ALT");
        RewriteRuleNodeStream stream_BLOCK=new RewriteRuleNodeStream(adaptor,"token BLOCK");
        RewriteRuleSubtreeStream stream_setElement=new RewriteRuleSubtreeStream(adaptor,"rule setElement");

        boolean inLexer = Character.isUpperCase(currentRuleName.charAt(0));

        try {
            // BlockSetTransformer.g:68:2: ({...}? ^( BLOCK ^( ALT setElement[inLexer] ) ( ^( ALT setElement[inLexer] ) )+ ) -> ^( SET[$BLOCK.token, \"SET\"] ( setElement )+ ) )
            // BlockSetTransformer.g:68:4: {...}? ^( BLOCK ^( ALT setElement[inLexer] ) ( ^( ALT setElement[inLexer] ) )+ )
            {
            if ( !((!inContext("RULE"))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "blockSet", "!inContext(\"RULE\")");
            }

            _last = (GrammarAST)input.LT(1);
            {
            GrammarAST _save_last_1 = _last;
            GrammarAST _first_1 = null;
            _last = (GrammarAST)input.LT(1);
            BLOCK10=(GrammarAST)match(input,BLOCK,FOLLOW_BLOCK_in_blockSet241); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_BLOCK.add(BLOCK10);


            if ( state.backtracking==1 )
            if ( _first_0==null ) _first_0 = BLOCK10;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (GrammarAST)input.LT(1);
            {
            GrammarAST _save_last_2 = _last;
            GrammarAST _first_2 = null;
            _last = (GrammarAST)input.LT(1);
            ALT11=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_blockSet244); if (state.failed) return retval; 
            if ( state.backtracking==1 ) stream_ALT.add(ALT11);


            if ( state.backtracking==1 )
            if ( _first_1==null ) _first_1 = ALT11;
            match(input, Token.DOWN, null); if (state.failed) return retval;
            _last = (GrammarAST)input.LT(1);
            pushFollow(FOLLOW_setElement_in_blockSet246);
            setElement12=setElement(inLexer);

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==1 ) stream_setElement.add(setElement12.getTree());

            match(input, Token.UP, null); if (state.failed) return retval;
            _last = _save_last_2;
            }


            // BlockSetTransformer.g:69:38: ( ^( ALT setElement[inLexer] ) )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==ALT) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // BlockSetTransformer.g:69:40: ^( ALT setElement[inLexer] )
            	    {
            	    _last = (GrammarAST)input.LT(1);
            	    {
            	    GrammarAST _save_last_2 = _last;
            	    GrammarAST _first_2 = null;
            	    _last = (GrammarAST)input.LT(1);
            	    ALT13=(GrammarAST)match(input,ALT,FOLLOW_ALT_in_blockSet253); if (state.failed) return retval; 
            	    if ( state.backtracking==1 ) stream_ALT.add(ALT13);


            	    if ( state.backtracking==1 )
            	    if ( _first_1==null ) _first_1 = ALT13;
            	    match(input, Token.DOWN, null); if (state.failed) return retval;
            	    _last = (GrammarAST)input.LT(1);
            	    pushFollow(FOLLOW_setElement_in_blockSet255);
            	    setElement14=setElement(inLexer);

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==1 ) stream_setElement.add(setElement14.getTree());

            	    match(input, Token.UP, null); if (state.failed) return retval;
            	    _last = _save_last_2;
            	    }


            	    if ( state.backtracking==1 ) {
            	    retval.tree = (GrammarAST)_first_0;
            	    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
            	        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
            	    }
            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input, Token.UP, null); if (state.failed) return retval;
            _last = _save_last_1;
            }


            // AST REWRITE
            // elements: setElement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==1 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (GrammarAST)adaptor.nil();
            // 70:3: -> ^( SET[$BLOCK.token, \"SET\"] ( setElement )+ )
            {
                // BlockSetTransformer.g:70:6: ^( SET[$BLOCK.token, \"SET\"] ( setElement )+ )
                {
                GrammarAST root_1 = (GrammarAST)adaptor.nil();
                root_1 = (GrammarAST)adaptor.becomeRoot(
                (GrammarAST)adaptor.create(SET, BLOCK10.token, "SET")
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


            retval.tree = (GrammarAST)adaptor.rulePostProcessing(root_0);
            input.replaceChildren(adaptor.getParent(retval.start),
                                  adaptor.getChildIndex(retval.start),
                                  adaptor.getChildIndex(_last),
                                  retval.tree);
            }

            }

            if ( state.backtracking==1 ) {
            	GrammarTransformPipeline.setGrammarPtr(g, ((GrammarAST)retval.tree));
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
        GrammarAST tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "setElement"
    // BlockSetTransformer.g:73:1: setElement[boolean inLexer] :{...}? (a= STRING_LITERAL {...}?|{...}? => TOKEN_REF |{...}? => ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) {...}?) ;
    public final BlockSetTransformer.setElement_return setElement(boolean inLexer) throws RecognitionException {
        BlockSetTransformer.setElement_return retval = new BlockSetTransformer.setElement_return();
        retval.start = input.LT(1);


        GrammarAST root_0 = null;

        GrammarAST _first_0 = null;
        GrammarAST _last = null;

        GrammarAST a=null;
        GrammarAST b=null;
        GrammarAST TOKEN_REF15=null;
        GrammarAST RANGE16=null;

        GrammarAST a_tree=null;
        GrammarAST b_tree=null;
        GrammarAST TOKEN_REF15_tree=null;
        GrammarAST RANGE16_tree=null;

        try {
            // BlockSetTransformer.g:77:2: ({...}? (a= STRING_LITERAL {...}?|{...}? => TOKEN_REF |{...}? => ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) {...}?) )
            // BlockSetTransformer.g:77:4: {...}? (a= STRING_LITERAL {...}?|{...}? => TOKEN_REF |{...}? => ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) {...}?)
            {
            if ( !((!rewriteElems.contains(((GrammarAST)retval.start).getText()))) ) {
                if (state.backtracking>0) {state.failed=true; return retval;}
                throw new FailedPredicateException(input, "setElement", "!rewriteElems.contains($start.getText())");
            }

            // BlockSetTransformer.g:78:3: (a= STRING_LITERAL {...}?|{...}? => TOKEN_REF |{...}? => ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) {...}?)
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==STRING_LITERAL) ) {
                alt5=1;
            }
            else if ( (LA5_0==TOKEN_REF) && ((!inLexer))) {
                alt5=2;
            }
            else if ( (LA5_0==RANGE) && ((inLexer))) {
                alt5=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // BlockSetTransformer.g:78:5: a= STRING_LITERAL {...}?
                    {
                    _last = (GrammarAST)input.LT(1);
                    a=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement298); if (state.failed) return retval;
                     
                    if ( state.backtracking==1 )
                    if ( _first_0==null ) _first_0 = a;


                    if ( !((!inLexer || CharSupport.getCharValueFromGrammarCharLiteral(a.getText())!=-1)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "setElement", "!inLexer || CharSupport.getCharValueFromGrammarCharLiteral($a.getText())!=-1");
                    }

                    if ( state.backtracking==1 ) {
                    retval.tree = (GrammarAST)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    }
                    }
                    break;
                case 2 :
                    // BlockSetTransformer.g:79:5: {...}? => TOKEN_REF
                    {
                    if ( !((!inLexer)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "setElement", "!inLexer");
                    }

                    _last = (GrammarAST)input.LT(1);
                    TOKEN_REF15=(GrammarAST)match(input,TOKEN_REF,FOLLOW_TOKEN_REF_in_setElement309); if (state.failed) return retval;
                     
                    if ( state.backtracking==1 )
                    if ( _first_0==null ) _first_0 = TOKEN_REF15;


                    if ( state.backtracking==1 ) {
                    retval.tree = (GrammarAST)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    }
                    }
                    break;
                case 3 :
                    // BlockSetTransformer.g:80:5: {...}? => ^( RANGE a= STRING_LITERAL b= STRING_LITERAL ) {...}?
                    {
                    if ( !((inLexer)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "setElement", "inLexer");
                    }

                    _last = (GrammarAST)input.LT(1);
                    {
                    GrammarAST _save_last_1 = _last;
                    GrammarAST _first_1 = null;
                    _last = (GrammarAST)input.LT(1);
                    RANGE16=(GrammarAST)match(input,RANGE,FOLLOW_RANGE_in_setElement320); if (state.failed) return retval;


                    if ( state.backtracking==1 )
                    if ( _first_0==null ) _first_0 = RANGE16;
                    match(input, Token.DOWN, null); if (state.failed) return retval;
                    _last = (GrammarAST)input.LT(1);
                    a=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement324); if (state.failed) return retval;
                     
                    if ( state.backtracking==1 )
                    if ( _first_1==null ) _first_1 = a;


                    _last = (GrammarAST)input.LT(1);
                    b=(GrammarAST)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_setElement328); if (state.failed) return retval;
                     
                    if ( state.backtracking==1 )
                    if ( _first_1==null ) _first_1 = b;


                    match(input, Token.UP, null); if (state.failed) return retval;
                    _last = _save_last_1;
                    }


                    if ( !((CharSupport.getCharValueFromGrammarCharLiteral(a.getText())!=-1 &&
                    			 CharSupport.getCharValueFromGrammarCharLiteral(b.getText())!=-1)) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "setElement", "CharSupport.getCharValueFromGrammarCharLiteral($a.getText())!=-1 &&\n\t\t\t CharSupport.getCharValueFromGrammarCharLiteral($b.getText())!=-1");
                    }

                    if ( state.backtracking==1 ) {
                    retval.tree = (GrammarAST)_first_0;
                    if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                        retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
                    }
                    }
                    break;

            }


            if ( state.backtracking==1 ) {
            retval.tree = (GrammarAST)_first_0;
            if ( adaptor.getParent(retval.tree)!=null && adaptor.isNil( adaptor.getParent(retval.tree) ) )
                retval.tree = (GrammarAST)adaptor.getParent(retval.tree);
            }
            }

            if ( state.backtracking==1 ) {
            	GrammarTransformPipeline.setGrammarPtr(g, ((GrammarAST)retval.tree));
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

    // Delegated rules


 

    public static final BitSet FOLLOW_RULE_in_topdown83 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_TOKEN_REF_in_topdown88 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000001FFFFFFFFL});
    public static final BitSet FOLLOW_RULE_REF_in_topdown92 = new BitSet(new long[]{0xFFFFFFFFFFFFFFF0L,0x00000001FFFFFFFFL});
    public static final BitSet FOLLOW_setAlt_in_topdown107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnfBlockSet_in_topdown115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_blockSet_in_topdown123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ALT_in_setAlt138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ebnfSuffix_in_ebnfBlockSet158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_blockSet_in_ebnfBlockSet160 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_BLOCK_in_blockSet241 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ALT_in_blockSet244 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_setElement_in_blockSet246 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ALT_in_blockSet253 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_setElement_in_blockSet255 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TOKEN_REF_in_setElement309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RANGE_in_setElement320 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement324 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_setElement328 = new BitSet(new long[]{0x0000000000000008L});

}
// $ANTLR 3.4 ActionSplitter.g 2012-04-29 22:33:16

package org.antlr.v4.parse;
import org.antlr.v4.tool.*;
import org.antlr.v4.tool.ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ActionSplitter extends Lexer {
    public static final int EOF=-1;
    public static final int ACTION=4;
    public static final int ARG=5;
    public static final int ATTR=6;
    public static final int ATTR_VALUE_EXPR=7;
    public static final int COMMENT=8;
    public static final int ID=9;
    public static final int LINE_COMMENT=10;
    public static final int NONLOCAL_ATTR=11;
    public static final int QUALIFIED_ATTR=12;
    public static final int SCOPE_INDEX_EXPR=13;
    public static final int SET_ATTR=14;
    public static final int SET_NONLOCAL_ATTR=15;
    public static final int SET_QUALIFIED_ATTR=16;
    public static final int TEXT=17;
    public static final int WS=18;

    ActionSplitterListener delegate;

    public ActionSplitter(CharStream input, ActionSplitterListener delegate) {
        this(input, new RecognizerSharedState());
        this.delegate = delegate;
    }

    public void emit(Token token) {
    	super.emit(token);

    }

    /** force filtering (and return tokens). triggers all above actions. */
    public List<Token> getActionTokens() {
        List<Token> chunks = new ArrayList<Token>();
        Token t = nextToken();
        while ( t.getType()!=Token.EOF ) {
            chunks.add(t);
            t = nextToken();
        }
        return chunks;
    }


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ActionSplitter() {} 
    public ActionSplitter(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ActionSplitter(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "ActionSplitter.g"; }

    public Token nextToken() {
        while (true) {
            if ( input.LA(1)==CharStream.EOF ) {
                Token eof = new CommonToken((CharStream)input,Token.EOF,
                                            Token.DEFAULT_CHANNEL,
                                            input.index(),input.index());
                eof.setLine(getLine());
                eof.setCharPositionInLine(getCharPositionInLine());
                return eof;
            }
            state.token = null;
    	state.channel = Token.DEFAULT_CHANNEL;
            state.tokenStartCharIndex = input.index();
            state.tokenStartCharPositionInLine = input.getCharPositionInLine();
            state.tokenStartLine = input.getLine();
    	state.text = null;
            try {
                int m = input.mark();
                state.backtracking=1; 
                state.failed=false;
                mTokens();
                state.backtracking=0;
                if ( state.failed ) {
                    input.rewind(m);
                    input.consume(); 
                }
                else {
                    emit();
                    return state.token;
                }
            }
            catch (RecognitionException re) {
                // shouldn't happen in backtracking mode, but...
                reportError(re);
                recover(re);
            }
        }
    }

    public void memoize(IntStream input,
    		int ruleIndex,
    		int ruleStartIndex)
    {
    if ( state.backtracking>1 ) super.memoize(input, ruleIndex, ruleStartIndex);
    }

    public boolean alreadyParsedRule(IntStream input, int ruleIndex) {
    if ( state.backtracking>1 ) return super.alreadyParsedRule(input, ruleIndex);
    return false;
    }
    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ActionSplitter.g:39:5: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ActionSplitter.g:39:9: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); if (state.failed) return ;



            // ActionSplitter.g:39:14: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1=='/') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '.')||(LA1_1 >= '0' && LA1_1 <= '\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ActionSplitter.g:39:42: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match("*/"); if (state.failed) return ;



            if ( state.backtracking==1 ) {delegate.text(getText());}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ActionSplitter.g:43:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' )
            // ActionSplitter.g:43:7: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
            {
            match("//"); if (state.failed) return ;



            // ActionSplitter.g:43:12: (~ ( '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ActionSplitter.g:
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
            	    break loop2;
                }
            } while (true);


            // ActionSplitter.g:43:26: ( '\\r' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ActionSplitter.g:43:26: '\\r'
                    {
                    match('\r'); if (state.failed) return ;

                    }
                    break;

            }


            match('\n'); if (state.failed) return ;

            if ( state.backtracking==1 ) {delegate.text(getText());}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINE_COMMENT"

    // $ANTLR start "SET_NONLOCAL_ATTR"
    public final void mSET_NONLOCAL_ATTR() throws RecognitionException {
        try {
            int _type = SET_NONLOCAL_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;
            CommonToken expr=null;

            // ActionSplitter.g:47:2: ( '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
            // ActionSplitter.g:47:4: '$' x= ID '::' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
            {
            match('$'); if (state.failed) return ;

            int xStart112 = getCharIndex();
            int xStartLine112 = getLine();
            int xStartCharPos112 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart112, getCharIndex()-1);
            x.setLine(xStartLine112);
            x.setCharPositionInLine(xStartCharPos112);


            match("::"); if (state.failed) return ;



            int yStart118 = getCharIndex();
            int yStartLine118 = getLine();
            int yStartCharPos118 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart118, getCharIndex()-1);
            y.setLine(yStartLine118);
            y.setCharPositionInLine(yStartCharPos118);


            // ActionSplitter.g:47:23: ( WS )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0 >= '\t' && LA4_0 <= '\n')||LA4_0=='\r'||LA4_0==' ') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ActionSplitter.g:47:23: WS
                    {
                    mWS(); if (state.failed) return ;


                    }
                    break;

            }


            match('='); if (state.failed) return ;

            int exprStart127 = getCharIndex();
            int exprStartLine127 = getLine();
            int exprStartCharPos127 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart127, getCharIndex()-1);
            expr.setLine(exprStartLine127);
            expr.setCharPositionInLine(exprStartCharPos127);


            match(';'); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            		delegate.setNonLocalAttr(getText(), x, y, expr);
            		}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SET_NONLOCAL_ATTR"

    // $ANTLR start "NONLOCAL_ATTR"
    public final void mNONLOCAL_ATTR() throws RecognitionException {
        try {
            int _type = NONLOCAL_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionSplitter.g:54:2: ( '$' x= ID '::' y= ID )
            // ActionSplitter.g:54:4: '$' x= ID '::' y= ID
            {
            match('$'); if (state.failed) return ;

            int xStart148 = getCharIndex();
            int xStartLine148 = getLine();
            int xStartCharPos148 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart148, getCharIndex()-1);
            x.setLine(xStartLine148);
            x.setCharPositionInLine(xStartCharPos148);


            match("::"); if (state.failed) return ;



            int yStart154 = getCharIndex();
            int yStartLine154 = getLine();
            int yStartCharPos154 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart154, getCharIndex()-1);
            y.setLine(yStartLine154);
            y.setCharPositionInLine(yStartCharPos154);


            if ( state.backtracking==1 ) {delegate.nonLocalAttr(getText(), x, y);}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NONLOCAL_ATTR"

    // $ANTLR start "SET_QUALIFIED_ATTR"
    public final void mSET_QUALIFIED_ATTR() throws RecognitionException {
        try {
            int _type = SET_QUALIFIED_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;
            CommonToken expr=null;

            // ActionSplitter.g:58:2: ( '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
            // ActionSplitter.g:58:4: '$' x= ID '.' y= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
            {
            match('$'); if (state.failed) return ;

            int xStart171 = getCharIndex();
            int xStartLine171 = getLine();
            int xStartCharPos171 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart171, getCharIndex()-1);
            x.setLine(xStartLine171);
            x.setCharPositionInLine(xStartCharPos171);


            match('.'); if (state.failed) return ;

            int yStart177 = getCharIndex();
            int yStartLine177 = getLine();
            int yStartCharPos177 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart177, getCharIndex()-1);
            y.setLine(yStartLine177);
            y.setCharPositionInLine(yStartCharPos177);


            // ActionSplitter.g:58:22: ( WS )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( ((LA5_0 >= '\t' && LA5_0 <= '\n')||LA5_0=='\r'||LA5_0==' ') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ActionSplitter.g:58:22: WS
                    {
                    mWS(); if (state.failed) return ;


                    }
                    break;

            }


            match('='); if (state.failed) return ;

            int exprStart186 = getCharIndex();
            int exprStartLine186 = getLine();
            int exprStartCharPos186 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart186, getCharIndex()-1);
            expr.setLine(exprStartLine186);
            expr.setCharPositionInLine(exprStartCharPos186);


            match(';'); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            		delegate.setQualifiedAttr(getText(), x, y, expr);
            		}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SET_QUALIFIED_ATTR"

    // $ANTLR start "QUALIFIED_ATTR"
    public final void mQUALIFIED_ATTR() throws RecognitionException {
        try {
            int _type = QUALIFIED_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken y=null;

            // ActionSplitter.g:65:2: ( '$' x= ID '.' y= ID {...}?)
            // ActionSplitter.g:65:4: '$' x= ID '.' y= ID {...}?
            {
            match('$'); if (state.failed) return ;

            int xStart207 = getCharIndex();
            int xStartLine207 = getLine();
            int xStartCharPos207 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart207, getCharIndex()-1);
            x.setLine(xStartLine207);
            x.setCharPositionInLine(xStartCharPos207);


            match('.'); if (state.failed) return ;

            int yStart213 = getCharIndex();
            int yStartLine213 = getLine();
            int yStartCharPos213 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            y = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, yStart213, getCharIndex()-1);
            y.setLine(yStartLine213);
            y.setCharPositionInLine(yStartCharPos213);


            if ( !((input.LA(1)!='(')) ) {
                if (state.backtracking>0) {state.failed=true; return ;}
                throw new FailedPredicateException(input, "QUALIFIED_ATTR", "input.LA(1)!='('");
            }

            if ( state.backtracking==1 ) {delegate.qualifiedAttr(getText(), x, y);}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUALIFIED_ATTR"

    // $ANTLR start "SET_ATTR"
    public final void mSET_ATTR() throws RecognitionException {
        try {
            int _type = SET_ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;
            CommonToken expr=null;

            // ActionSplitter.g:69:2: ( '$' x= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';' )
            // ActionSplitter.g:69:4: '$' x= ID ( WS )? '=' expr= ATTR_VALUE_EXPR ';'
            {
            match('$'); if (state.failed) return ;

            int xStart232 = getCharIndex();
            int xStartLine232 = getLine();
            int xStartCharPos232 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart232, getCharIndex()-1);
            x.setLine(xStartLine232);
            x.setCharPositionInLine(xStartCharPos232);


            // ActionSplitter.g:69:13: ( WS )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||LA6_0=='\r'||LA6_0==' ') ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ActionSplitter.g:69:13: WS
                    {
                    mWS(); if (state.failed) return ;


                    }
                    break;

            }


            match('='); if (state.failed) return ;

            int exprStart241 = getCharIndex();
            int exprStartLine241 = getLine();
            int exprStartCharPos241 = getCharPositionInLine();
            mATTR_VALUE_EXPR(); if (state.failed) return ;
            expr = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, exprStart241, getCharIndex()-1);
            expr.setLine(exprStartLine241);
            expr.setCharPositionInLine(exprStartCharPos241);


            match(';'); if (state.failed) return ;

            if ( state.backtracking==1 ) {
            		delegate.setAttr(getText(), x, expr);
            		}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SET_ATTR"

    // $ANTLR start "ATTR"
    public final void mATTR() throws RecognitionException {
        try {
            int _type = ATTR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken x=null;

            // ActionSplitter.g:76:2: ( '$' x= ID )
            // ActionSplitter.g:76:4: '$' x= ID
            {
            match('$'); if (state.failed) return ;

            int xStart262 = getCharIndex();
            int xStartLine262 = getLine();
            int xStartCharPos262 = getCharPositionInLine();
            mID(); if (state.failed) return ;
            x = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, xStart262, getCharIndex()-1);
            x.setLine(xStartLine262);
            x.setCharPositionInLine(xStartCharPos262);


            if ( state.backtracking==1 ) {delegate.attr(getText(), x);}

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ATTR"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            StringBuilder buf = new StringBuilder();
            // ActionSplitter.g:83:2: ( (c=~ ( '\\\\' | '$' ) | '\\\\$' | '\\\\' c=~ ( '$' ) )+ )
            // ActionSplitter.g:83:4: (c=~ ( '\\\\' | '$' ) | '\\\\$' | '\\\\' c=~ ( '$' ) )+
            {
            // ActionSplitter.g:83:4: (c=~ ( '\\\\' | '$' ) | '\\\\$' | '\\\\' c=~ ( '$' ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=4;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\u0000' && LA7_0 <= '#')||(LA7_0 >= '%' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {
                    alt7=1;
                }
                else if ( (LA7_0=='\\') ) {
                    int LA7_3 = input.LA(2);

                    if ( (LA7_3=='$') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_3 >= '\u0000' && LA7_3 <= '#')||(LA7_3 >= '%' && LA7_3 <= '\uFFFF')) ) {
                        alt7=3;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // ActionSplitter.g:83:6: c=~ ( '\\\\' | '$' )
            	    {
            	    c= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '#')||(input.LA(1) >= '%' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( state.backtracking==1 ) {buf.append((char)c);}

            	    }
            	    break;
            	case 2 :
            	    // ActionSplitter.g:84:5: '\\\\$'
            	    {
            	    match("\\$"); if (state.failed) return ;



            	    if ( state.backtracking==1 ) {buf.append("$");}

            	    }
            	    break;
            	case 3 :
            	    // ActionSplitter.g:85:5: '\\\\' c=~ ( '$' )
            	    {
            	    match('\\'); if (state.failed) return ;

            	    c= input.LA(1);

            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '#')||(input.LA(1) >= '%' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    if ( state.backtracking==1 ) {buf.append("\\"+(char)c);}

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
            if ( state.backtracking==1 ) {delegate.text(buf.toString());}
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "ACTION"
    public final void mACTION() throws RecognitionException {
        try {
            // ActionSplitter.g:91:2: ( '{' ( '\\\\}' |~ '}' )* '}' )
            // ActionSplitter.g:91:4: '{' ( '\\\\}' |~ '}' )* '}'
            {
            match('{'); if (state.failed) return ;

            // ActionSplitter.g:91:8: ( '\\\\}' |~ '}' )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='\\') ) {
                    int LA8_2 = input.LA(2);

                    if ( (LA8_2=='}') ) {
                        int LA8_4 = input.LA(3);

                        if ( ((LA8_4 >= '\u0000' && LA8_4 <= '\uFFFF')) ) {
                            alt8=1;
                        }

                        else {
                            alt8=2;
                        }


                    }
                    else if ( ((LA8_2 >= '\u0000' && LA8_2 <= '|')||(LA8_2 >= '~' && LA8_2 <= '\uFFFF')) ) {
                        alt8=2;
                    }


                }
                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '[')||(LA8_0 >= ']' && LA8_0 <= '|')||(LA8_0 >= '~' && LA8_0 <= '\uFFFF')) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // ActionSplitter.g:91:9: '\\\\}'
            	    {
            	    match("\\}"); if (state.failed) return ;



            	    }
            	    break;
            	case 2 :
            	    // ActionSplitter.g:91:15: ~ '}'
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '|')||(input.LA(1) >= '~' && input.LA(1) <= '\uFFFF') ) {
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


            match('}'); if (state.failed) return ;

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ACTION"

    // $ANTLR start "ARG"
    public final void mARG() throws RecognitionException {
        try {
            // ActionSplitter.g:95:5: ( ID '=' ACTION )
            // ActionSplitter.g:95:7: ID '=' ACTION
            {
            mID(); if (state.failed) return ;


            match('='); if (state.failed) return ;

            mACTION(); if (state.failed) return ;


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ARG"

    // $ANTLR start "ID"
    public final void mID() throws RecognitionException {
        try {
            // ActionSplitter.g:99:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // ActionSplitter.g:99:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // ActionSplitter.g:99:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ActionSplitter.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
            	    break loop9;
                }
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ID"

    // $ANTLR start "ATTR_VALUE_EXPR"
    public final void mATTR_VALUE_EXPR() throws RecognitionException {
        try {
            // ActionSplitter.g:105:2: (~ '=' (~ ';' )* )
            // ActionSplitter.g:105:4: ~ '=' (~ ';' )*
            {
            if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '<')||(input.LA(1) >= '>' && input.LA(1) <= '\uFFFF') ) {
                input.consume();
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // ActionSplitter.g:105:9: (~ ';' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= ':')||(LA10_0 >= '<' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ActionSplitter.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= '\uFFFF') ) {
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
            	    break loop10;
                }
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ATTR_VALUE_EXPR"

    // $ANTLR start "SCOPE_INDEX_EXPR"
    public final void mSCOPE_INDEX_EXPR() throws RecognitionException {
        try {
            // ActionSplitter.g:110:2: ( ( '\\\\]' |~ ']' )+ )
            // ActionSplitter.g:110:4: ( '\\\\]' |~ ']' )+
            {
            // ActionSplitter.g:110:4: ( '\\\\]' |~ ']' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\\') ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2==']') ) {
                        alt11=1;
                    }

                    else {
                        alt11=2;
                    }


                }
                else if ( ((LA11_0 >= '\u0000' && LA11_0 <= '[')||(LA11_0 >= '^' && LA11_0 <= '\uFFFF')) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // ActionSplitter.g:110:5: '\\\\]'
            	    {
            	    match("\\]"); if (state.failed) return ;



            	    }
            	    break;
            	case 2 :
            	    // ActionSplitter.g:110:11: ~ ']'
            	    {
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

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SCOPE_INDEX_EXPR"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            // ActionSplitter.g:114:4: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // ActionSplitter.g:114:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // ActionSplitter.g:114:6: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '\t' && LA12_0 <= '\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ActionSplitter.g:
            	    {
            	    if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
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
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // ActionSplitter.g:1:39: ( COMMENT | LINE_COMMENT | SET_NONLOCAL_ATTR | NONLOCAL_ATTR | SET_QUALIFIED_ATTR | QUALIFIED_ATTR | SET_ATTR | ATTR | TEXT )
        int alt13=9;
        int LA13_0 = input.LA(1);

        if ( (LA13_0=='/') ) {
            int LA13_1 = input.LA(2);

            if ( (synpred1_ActionSplitter()) ) {
                alt13=1;
            }
            else if ( (synpred2_ActionSplitter()) ) {
                alt13=2;
            }
            else if ( (true) ) {
                alt13=9;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 1, input);

                throw nvae;

            }
        }
        else if ( (LA13_0=='$') ) {
            int LA13_5 = input.LA(2);

            if ( (synpred3_ActionSplitter()) ) {
                alt13=3;
            }
            else if ( (synpred4_ActionSplitter()) ) {
                alt13=4;
            }
            else if ( (synpred5_ActionSplitter()) ) {
                alt13=5;
            }
            else if ( (synpred6_ActionSplitter()) ) {
                alt13=6;
            }
            else if ( (synpred7_ActionSplitter()) ) {
                alt13=7;
            }
            else if ( (synpred8_ActionSplitter()) ) {
                alt13=8;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 5, input);

                throw nvae;

            }
        }
        else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '#')||(LA13_0 >= '%' && LA13_0 <= '.')||(LA13_0 >= '0' && LA13_0 <= '\uFFFF')) ) {
            alt13=9;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 13, 0, input);

            throw nvae;

        }
        switch (alt13) {
            case 1 :
                // ActionSplitter.g:1:41: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;


                }
                break;
            case 2 :
                // ActionSplitter.g:1:49: LINE_COMMENT
                {
                mLINE_COMMENT(); if (state.failed) return ;


                }
                break;
            case 3 :
                // ActionSplitter.g:1:62: SET_NONLOCAL_ATTR
                {
                mSET_NONLOCAL_ATTR(); if (state.failed) return ;


                }
                break;
            case 4 :
                // ActionSplitter.g:1:80: NONLOCAL_ATTR
                {
                mNONLOCAL_ATTR(); if (state.failed) return ;


                }
                break;
            case 5 :
                // ActionSplitter.g:1:94: SET_QUALIFIED_ATTR
                {
                mSET_QUALIFIED_ATTR(); if (state.failed) return ;


                }
                break;
            case 6 :
                // ActionSplitter.g:1:113: QUALIFIED_ATTR
                {
                mQUALIFIED_ATTR(); if (state.failed) return ;


                }
                break;
            case 7 :
                // ActionSplitter.g:1:128: SET_ATTR
                {
                mSET_ATTR(); if (state.failed) return ;


                }
                break;
            case 8 :
                // ActionSplitter.g:1:137: ATTR
                {
                mATTR(); if (state.failed) return ;


                }
                break;
            case 9 :
                // ActionSplitter.g:1:142: TEXT
                {
                mTEXT(); if (state.failed) return ;


                }
                break;

        }

    }

    // $ANTLR start synpred1_ActionSplitter
    public final void synpred1_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:41: ( COMMENT )
        // ActionSplitter.g:1:41: COMMENT
        {
        mCOMMENT(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred1_ActionSplitter

    // $ANTLR start synpred2_ActionSplitter
    public final void synpred2_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:49: ( LINE_COMMENT )
        // ActionSplitter.g:1:49: LINE_COMMENT
        {
        mLINE_COMMENT(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred2_ActionSplitter

    // $ANTLR start synpred3_ActionSplitter
    public final void synpred3_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:62: ( SET_NONLOCAL_ATTR )
        // ActionSplitter.g:1:62: SET_NONLOCAL_ATTR
        {
        mSET_NONLOCAL_ATTR(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred3_ActionSplitter

    // $ANTLR start synpred4_ActionSplitter
    public final void synpred4_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:80: ( NONLOCAL_ATTR )
        // ActionSplitter.g:1:80: NONLOCAL_ATTR
        {
        mNONLOCAL_ATTR(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred4_ActionSplitter

    // $ANTLR start synpred5_ActionSplitter
    public final void synpred5_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:94: ( SET_QUALIFIED_ATTR )
        // ActionSplitter.g:1:94: SET_QUALIFIED_ATTR
        {
        mSET_QUALIFIED_ATTR(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred5_ActionSplitter

    // $ANTLR start synpred6_ActionSplitter
    public final void synpred6_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:113: ( QUALIFIED_ATTR )
        // ActionSplitter.g:1:113: QUALIFIED_ATTR
        {
        mQUALIFIED_ATTR(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred6_ActionSplitter

    // $ANTLR start synpred7_ActionSplitter
    public final void synpred7_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:128: ( SET_ATTR )
        // ActionSplitter.g:1:128: SET_ATTR
        {
        mSET_ATTR(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred7_ActionSplitter

    // $ANTLR start synpred8_ActionSplitter
    public final void synpred8_ActionSplitter_fragment() throws RecognitionException {
        // ActionSplitter.g:1:137: ( ATTR )
        // ActionSplitter.g:1:137: ATTR
        {
        mATTR(); if (state.failed) return ;


        }

    }
    // $ANTLR end synpred8_ActionSplitter

    public final boolean synpred4_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_ActionSplitter() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_ActionSplitter_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

}
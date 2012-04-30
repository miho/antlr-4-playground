// $ANTLR ANTLRVersion> ExprParser.java generatedTimestamp>
package eu.mihosoft.antlr.experiments;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprParser extends Parser {
	public static final int
		T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, LPAR=9, RPAR=10, INT=11, 
		NUMBER=12, VAR=13, WS=14;
	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'+'", "'*'", "'-'", "'/'", "'='", "';'", "'('", "')'", "INT", "NUMBER", 
		"VAR", "WS"
	};
	public static final int
		RULE_s = 0, RULE_e = 1;
	public static final String[] ruleNames = {
		"s", "e"
	};

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator<Token>(this,_ATN);
	}
	public static class SContext extends ParserRuleContext<Token> {
		public EContext e() {
		    return getRuleContext(EContext.class,0);
		}
		public SContext(ParserRuleContext<Token> parent, int state) {
			super(parent, state);
		}
		@Override public int getRuleIndex() { return RULE_s; }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterS(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitS(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitS(this);
			else return null;
		}
	}

	public final SContext s() throws RecognitionException {
		SContext _localctx = new SContext(_ctx, 0);
		enterRule(_localctx, RULE_s);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ( _la==LPAR || _la==INT || _la==NUMBER || _la==VAR ) {
				{
				{
				setState(4); e(0);
				}
				}
				setState(10);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EContext extends ParserRuleContext<Token> {
		public int _p;
		public EContext(ParserRuleContext<Token> parent, int state) { super(parent, state); }
		public EContext(ParserRuleContext<Token> parent, int state, int _p) {
			super(parent, state);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_e; }
	 
		public EContext() { }
		public void copyFrom(EContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class MultContext extends EContext {
		public List<? extends EContext> e() {
		    return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
		    return getRuleContext(EContext.class,i);
		}
		public MultContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterMult(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitMult(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitMult(this);
			else return null;
		}
	}
	public static class AssignContext extends EContext {
		public EContext e() {
		    return getRuleContext(EContext.class,0);
		}
		public TerminalNode<Token> VAR() { return getToken(ExprParser.VAR, 0); }
		public AssignContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitAssign(this);
			else return null;
		}
	}
	public static class NumberContext extends EContext {
		public TerminalNode<Token> NUMBER() { return getToken(ExprParser.NUMBER, 0); }
		public NumberContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitNumber(this);
			else return null;
		}
	}
	public static class AddContext extends EContext {
		public List<? extends EContext> e() {
		    return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
		    return getRuleContext(EContext.class,i);
		}
		public AddContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitAdd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitAdd(this);
			else return null;
		}
	}
	public static class ParContext extends EContext {
		public TerminalNode<Token> RPAR() { return getToken(ExprParser.RPAR, 0); }
		public EContext e() {
		    return getRuleContext(EContext.class,0);
		}
		public TerminalNode<Token> LPAR() { return getToken(ExprParser.LPAR, 0); }
		public ParContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterPar(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitPar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitPar(this);
			else return null;
		}
	}
	public static class SubContext extends EContext {
		public List<? extends EContext> e() {
		    return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
		    return getRuleContext(EContext.class,i);
		}
		public SubContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterSub(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitSub(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitSub(this);
			else return null;
		}
	}
	public static class IntContext extends EContext {
		public TerminalNode<Token> INT() { return getToken(ExprParser.INT, 0); }
		public IntContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitInt(this);
			else return null;
		}
	}
	public static class VarContext extends EContext {
		public TerminalNode<Token> VAR() { return getToken(ExprParser.VAR, 0); }
		public VarContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitVar(this);
			else return null;
		}
	}
	public static class DivContext extends EContext {
		public List<? extends EContext> e() {
		    return getRuleContexts(EContext.class);
		}
		public EContext e(int i) {
		    return getRuleContext(EContext.class,i);
		}
		public DivContext(EContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).enterDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener<Token> listener) {
			if ( listener instanceof ExprListener ) ((ExprListener)listener).exitDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<T>)visitor).visitDiv(this);
			else return null;
		}
	}

	public final EContext e(int _p) throws RecognitionException {
		ParserRuleContext<Token> _parentctx = _ctx;
		EContext _localctx = new EContext(_ctx, 2, _p);
		EContext _prevctx = _localctx;
		int _startState = 2;
		pushNewRecursionContext(_localctx, RULE_e);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			//_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					_localctx = new NumberContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;

					setState(13); match(NUMBER);
					}
					break;
				case 2:
					{
					_localctx = new IntContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(15); match(INT);
					}
					break;
				case 3:
					{
					_localctx = new VarContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(17); match(VAR);
					}
					break;
				case 4:
					{
					_localctx = new ParContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(19); match(LPAR);
					setState(21); e(0);
					setState(23); match(RPAR);
					}
					break;
				case 5:
					{
					_localctx = new AssignContext(_localctx);
					_ctx = _localctx;
					_prevctx = _localctx;
					setState(25); match(VAR);
					setState(27); match(7);
					setState(29); e(0);
					setState(31); match(8);
					}
					break;
			}
			_ctx.stop = _input.LT(-1);
			setState(61);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					_prevctx.stop = _input.LT(-1);
					{
					setState(59);
					//_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
						case 1:
							{
							_localctx = new MultContext(new EContext(_parentctx, _startState, _p));
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_e);
							_localctx.start = _prevctx.start;
							setState(35);
							if (!(9 >= _localctx._p)) throw new FailedPredicateException(this, "9 >= $_p");
							setState(37); match(4);
							setState(39); e(10);
							}
							break;
						case 2:
							{
							_localctx = new AddContext(new EContext(_parentctx, _startState, _p));
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_e);
							_localctx.start = _prevctx.start;
							setState(41);
							if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
							setState(43); match(3);
							setState(45); e(9);
							}
							break;
						case 3:
							{
							_localctx = new SubContext(new EContext(_parentctx, _startState, _p));
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_e);
							_localctx.start = _prevctx.start;
							setState(47);
							if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
							setState(49); match(5);
							setState(51); e(8);
							}
							break;
						case 4:
							{
							_localctx = new DivContext(new EContext(_parentctx, _startState, _p));
							_localctx.addChild(_prevctx);
							pushNewRecursionContext(_localctx, RULE_e);
							_localctx.start = _prevctx.start;
							setState(53);
							if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
							setState(55); match(6);
							setState(57); e(7);
							}
							break;
					}
					} 
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch ( ruleIndex ) {
				case 1 : return e_sempred((EContext)_localctx, predIndex);
		}
		return true;
	}
	public boolean e_sempred(EContext _localctx, int predIndex) {
		switch ( predIndex ) {
			case 0 : return 9 >= _localctx._p;
			case 1 : return 8 >= _localctx._p;
			case 2 : return 7 >= _localctx._p;
			case 3 : return 6 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\16A\2\0\7\0\2\1\7\1\1\0\0\5\0\b\0\n\0\f\0\n\t\0\1\1\0\1\1\0\1\1\0\1"+
		"\1\0\1\1\0\1\1\0\1\1\1\1\1\1\0\1\1\0\1\1\0\1\1\1\1\3\1\b\1\1\1\0\1\1\0"+
		"\1\1\0\1\1\0\1\1\0\1\1\0\1\1\0\1\1\0\1\1\0\1\1\0\1\1\0\1\1\0\5\1\b\1\n"+
		"\1\f\1?\t\1\1\1\2\0\2\0\09\0\b\1\0\0\0\1@\5\uffff\0\0\2!\1\0\0\0\3\7\1"+
		"\0\0\0\3\27\1\0\0\0\3\37\1\0\0\0\3<\1\0\0\0\3<\1\0\0\0\3<\1\0\0\0\3<\1"+
		"\0\0\0\4\7\3\2\1\0\6\4\1\0\0\0\7\n\1\0\0\0\b\6\1\0\0\0\b\t\1\0\0\0\t\1"+
		"\1\0\0\0\n\b\1\0\0\0\13\r\6\1\uffff\0\r\"\5\f\0\0\17\"\5\13\0\0\21\"\5"+
		"\r\0\0\23\25\5\t\0\0\25\27\3\2\1\0\27\30\5\n\0\0\30\"\1\0\0\0\31\33\5"+
		"\r\0\0\33\35\5\7\0\0\35\37\3\2\1\0\37 \5\b\0\0 \"\1\0\0\0!\13\1\0\0\0"+
		"!\17\1\0\0\0!\21\1\0\0\0!\23\1\0\0\0!\31\1\0\0\0\"=\1\0\0\0#%\4\1\0\1"+
		"%\'\5\4\0\0\'<\3\2\1\0)+\4\1\1\1+-\5\3\0\0-<\3\2\1\0/\61\4\1\2\1\61\63"+
		"\5\5\0\0\63<\3\2\1\0\65\67\4\1\3\1\679\5\6\0\09<\3\2\1\0;#\1\0\0\0;)\1"+
		"\0\0\0;/\1\0\0\0;\65\1\0\0\0<?\1\0\0\0=;\1\0\0\0=>\1\0\0\0>\3\1\0\0\0"+
		"?=\1\0\0\0\4\b\1!\1;\1=\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}
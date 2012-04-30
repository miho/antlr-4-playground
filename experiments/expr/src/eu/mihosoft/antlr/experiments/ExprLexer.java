// $ANTLR ANTLRVersion> ExprLexer.java generatedTimestamp>
package eu.mihosoft.antlr.experiments;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ExprLexer extends Lexer {
	public static final int
		T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, LPAR=9, RPAR=10, INT=11, 
		NUMBER=12, VAR=13, WS=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>", "<INVALID>", "<INVALID>",
		"'+'", "'*'", "'-'", "'/'", "'='", "';'", "'('", "')'", "INT", "NUMBER", 
		"VAR", "WS"
	};
	public static final String[] ruleNames = {
		"T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "LPAR", "RPAR", "INT", 
		"NUMBER", "VAR", "WS"
	};


	public ExprLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN);
	}

	@Override
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }


	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch ( ruleIndex ) {
			case 0 : T__5_action((RuleContext)_localctx, actionIndex); break;
			case 1 : T__4_action((RuleContext)_localctx, actionIndex); break;
			case 2 : T__3_action((RuleContext)_localctx, actionIndex); break;
			case 3 : T__2_action((RuleContext)_localctx, actionIndex); break;
			case 4 : T__1_action((RuleContext)_localctx, actionIndex); break;
			case 5 : T__0_action((RuleContext)_localctx, actionIndex); break;
			case 6 : LPAR_action((RuleContext)_localctx, actionIndex); break;
			case 7 : RPAR_action((RuleContext)_localctx, actionIndex); break;
			case 8 : INT_action((RuleContext)_localctx, actionIndex); break;
			case 9 : NUMBER_action((RuleContext)_localctx, actionIndex); break;
			case 10 : VAR_action((RuleContext)_localctx, actionIndex); break;
			case 11 : WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	public void RPAR_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void WS_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
			case 0 : skip();  break;
		}
	}
	public void VAR_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void INT_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void LPAR_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__1_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__0_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__3_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__5_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void NUMBER_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__2_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}
	public void T__4_action(RuleContext _localctx, int actionIndex) {
		switch ( actionIndex ) {
		}
	}

	public static final String _serializedATN =
		"\2\16H\6\uffff\2\0\7\0\2\1\7\1\2\2\7\2\2\3\7\3\2\4\7\4\2\5\7\5\2\6\7\6"+
		"\2\7\7\7\2\b\7\b\2\t\7\t\2\n\7\n\2\13\7\13\1\0\1\0\1\1\1\1\1\2\1\2\1\3"+
		"\1\3\1\4\1\4\1\5\1\5\1\6\1\6\1\7\1\7\1\b\0\4\b\b\b\13\b\f\b-\1\t\0\1\t"+
		"\0\1\t\0\5\t\b\t\n\t\f\t9\t\t\1\n\0\4\n\b\n\13\n\f\n>\1\13\0\4\13\b\13"+
		"\13\13\f\13D\1\13\1\13\f\1\3\uffff\3\4\uffff\5\5\uffff\7\6\uffff\t\7\uffff"+
		"\13\b\uffff\r\t\uffff\17\n\uffff\21\13\uffff\23\f\uffff\25\r\uffff\27"+
		"\16\0\1\0\4\1\609\1\609\1az\2\t\n  E\0\1\1\0\0\0\0\3\1\0\0\0\0\5\1\0\0"+
		"\0\0\7\1\0\0\0\0\t\1\0\0\0\0\13\1\0\0\0\0\r\1\0\0\0\0\17\1\0\0\0\0\21"+
		"\1\0\0\0\0\23\1\0\0\0\0\25\1\0\0\0\0\27\1\0\0\0\1\31\1\0\0\0\3\33\1\0"+
		"\0\0\5\35\1\0\0\0\7\37\1\0\0\0\t!\1\0\0\0\13#\1\0\0\0\r%\1\0\0\0\17\'"+
		"\1\0\0\0\21+\1\0\0\0\23/\1\0\0\0\25<\1\0\0\0\27B\1\0\0\0\31\32\5+\0\0"+
		"\32\2\1\0\0\0\33\34\5*\0\0\34\4\1\0\0\0\35\36\5-\0\0\36\6\1\0\0\0\37 "+
		"\5/\0\0 \b\1\0\0\0!\"\5=\0\0\"\n\1\0\0\0#$\5;\0\0$\f\1\0\0\0%&\5(\0\0"+
		"&\16\1\0\0\0\'(\5)\0\0(\20\1\0\0\0),\7\0\0\0+)\1\0\0\0,-\1\0\0\0-+\1\0"+
		"\0\0-.\1\0\0\0.\22\1\0\0\0/\61\3\21\b\0\61\67\5.\0\0\63\66\7\1\0\0\65"+
		"\63\1\0\0\0\669\1\0\0\0\67\65\1\0\0\0\678\1\0\0\08\24\1\0\0\09\67\1\0"+
		"\0\0:=\7\2\0\0<:\1\0\0\0=>\1\0\0\0><\1\0\0\0>?\1\0\0\0?\26\1\0\0\0@C\7"+
		"\3\0\0B@\1\0\0\0CD\1\0\0\0DB\1\0\0\0DE\1\0\0\0EF\1\0\0\0FG\6\13\0\0G\30"+
		"\1\0\0\0\5\0\1-\1\67\1>\1D\1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		//org.antlr.v4.tool.DOTGenerator dot = new org.antlr.v4.tool.DOTGenerator(null);
		//System.out.println(dot.getDOT(_ATN.decisionToState.get(0), ruleNames, false));
		//System.out.println(dot.getDOT(_ATN.ruleToStartState[2], ruleNames, false));
	}
}
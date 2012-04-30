package org.antlr.v4.test;

import org.antlr.v4.automata.ParserATNFactory;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNState;
import org.antlr.v4.runtime.atn.BlockStartState;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.tool.DOTGenerator;
import org.antlr.v4.tool.Grammar;
import org.antlr.v4.tool.LexerGrammar;
import org.antlr.v4.tool.Rule;
import org.antlr.v4.tool.interp.ParserInterpreter;
import org.junit.Test;

import java.util.List;


	// NOTICE: TOKENS IN LEXER, PARSER MUST BE SAME OR TOKEN TYPE MISMATCH
	// NOTICE: TOKENS IN LEXER, PARSER MUST BE SAME OR TOKEN TYPE MISMATCH
	// NOTICE: TOKENS IN LEXER, PARSER MUST BE SAME OR TOKEN TYPE MISMATCH

public class TestATNInterpreter extends BaseTest {
	@Test public void testSimpleNoBlock() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A B ;");
		checkMatchedAlt(lg, g, "ab", 1);
	}

	@Test public void testSet() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"tokens {A; B; C;}\n" +
			"a : ~A ;");
		checkMatchedAlt(lg, g, "b", 1);
	}

	@Test public void testPEGAchillesHeel() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A | A B ;");
		checkMatchedAlt(lg, g, "a", 1);
		checkMatchedAlt(lg, g, "ab", 2);
		checkMatchedAlt(lg, g, "abc", 2);
	}

	@Test public void testMustTrackPreviousGoodAlt() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A | A B ;");
		int errorIndex = 0;
		int errorTokenType = 0;
		try {
			checkMatchedAlt(lg, g, "ac", 1);
		}
		catch (NoViableAltException re) {
			errorIndex = re.getOffendingToken().getTokenIndex();
			errorTokenType = re.getOffendingToken().getType();
		}
		assertEquals(1, errorIndex);
		assertEquals(errorTokenType, 5);
	}

	@Test public void testMustTrackPreviousGoodAlt2() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"D : 'd' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A | A B | A B C ;");
		checkMatchedAlt(lg, g, "a", 1	);
		checkMatchedAlt(lg, g, "ab", 2);
		checkMatchedAlt(lg, g, "abc", 3);
		int errorIndex = 0;
		int errorTokenType = 0;
		try {
			checkMatchedAlt(lg, g, "abd", 1);
		}
		catch (NoViableAltException re) {
			errorIndex = re.getOffendingToken().getTokenIndex();
			errorTokenType = re.getOffendingToken().getType();
		}
		assertEquals(2, errorIndex);
		assertEquals(errorTokenType, 6);
	}

	@Test public void testMustTrackPreviousGoodAlt3() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"D : 'd' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A B | A | A B C ;");
		int errorIndex = 0;
		int errorTokenType = 0;
		try {
			checkMatchedAlt(lg, g, "abd", 1);
		}
		catch (NoViableAltException re) {
			errorIndex = re.getOffendingToken().getTokenIndex();
			errorTokenType = re.getOffendingToken().getType();
		}
		assertEquals(2, errorIndex);
		assertEquals(errorTokenType, 6);
	}

	@Test public void testAmbigAltChooseFirst() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"D : 'd' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A B | A B ;"); // first alt
		checkMatchedAlt(lg, g, "ab", 1);
		checkMatchedAlt(lg, g, "abc", 1);
	}

	@Test public void testAmbigAltChooseFirstWithFollowingToken() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"D : 'd' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : (A B | A B) C ;"); // first alt
		checkMatchedAlt(lg, g, "abc", 1);
		checkMatchedAlt(lg, g, "abcd", 1);
	}

	@Test public void testAmbigAltChooseFirstWithFollowingToken2() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"D : 'd' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : (A B | A B | C) D ;");
		checkMatchedAlt(lg, g, "abd", 1);
		checkMatchedAlt(lg, g, "abdc", 1);
		checkMatchedAlt(lg, g, "cd", 3);
	}

	@Test public void testAmbigAltChooseFirst2() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"D : 'd' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A B | A B | A B C ;");
		checkMatchedAlt(lg, g, "ab", 1);
		checkMatchedAlt(lg, g, "abc", 3);

		int errorIndex = 0;
		int errorTokenType = 0;
		try {
			checkMatchedAlt(lg, g, "abd", 1);
		}
		catch (NoViableAltException re) {
			errorIndex = re.getOffendingToken().getTokenIndex();
			errorTokenType = re.getOffendingToken().getType();
		}
		assertEquals(2, errorIndex);
		assertEquals(6, errorTokenType);

		checkMatchedAlt(lg, g, "abcd", 3); // ignores d on end
	}

	@Test public void testSimpleLoop() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"D : 'd' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A+ B ;");
		checkMatchedAlt(lg, g, "ab", 1);
		checkMatchedAlt(lg, g, "aab", 1);
		checkMatchedAlt(lg, g, "aaaaaab", 1);
		checkMatchedAlt(lg, g, "aabd", 1);
	}

	@Test public void testCommonLeftPrefix() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A B | A C ;");
		checkMatchedAlt(lg, g, "ab", 1);
		checkMatchedAlt(lg, g, "ac", 2);
	}

	@Test public void testArbitraryLeftPrefix() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n");
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"a : A+ B | A+ C ;");
		checkMatchedAlt(lg, g, "aac", 2);
	}

	@Test public void testRecursiveLeftPrefix() throws Exception {
		LexerGrammar lg = new LexerGrammar(
			"lexer grammar L;\n" +
			"A : 'a' ;\n" +
			"B : 'b' ;\n" +
			"C : 'c' ;\n" +
			"LP : '(' ;\n" +
			"RP : ')' ;\n" +
			"INT : '0'..'9'+ ;\n"
		);
		Grammar g = new Grammar(
			"parser grammar T;\n"+
			"tokens {A;B;C;LP;RP;INT;}\n" +
			"a : e B | e C ;\n" +
			"e : LP e RP\n" +
			"  | INT\n" +
			"  ;");
		checkMatchedAlt(lg, g, "34b", 1);
		checkMatchedAlt(lg, g, "34c", 2);
		checkMatchedAlt(lg, g, "(34)b", 1);
		checkMatchedAlt(lg, g, "(34)c", 2);
		checkMatchedAlt(lg, g, "((34))b", 1);
		checkMatchedAlt(lg, g, "((34))c", 2);
	}

	public void checkMatchedAlt(LexerGrammar lg, final Grammar g,
								String inputString,
								int expected)
	{
		ATN lexatn = createATN(lg);
		LexerATNSimulator lexInterp = new LexerATNSimulator(lexatn);
		List<Integer> types = getTokenTypesViaATN(inputString, lexInterp);
		System.out.println(types);

		semanticProcess(lg);
		g.importVocab(lg);
		semanticProcess(g);

		ParserATNFactory f = new ParserATNFactory(g);
		ATN atn = f.createATN();

		TokenStream input = new IntTokenStream(types);
		ParserInterpreter interp = new ParserInterpreter(g, input);
		ATNState startState = atn.ruleToStartState[g.getRule("a").index];
		if ( startState.transition(0).target instanceof BlockStartState ) {
			startState = startState.transition(0).target;
		}

		DOTGenerator dot = new DOTGenerator(g);
		System.out.println(dot.getDOT(atn.ruleToStartState[g.getRule("a").index]));
		Rule r = g.getRule("e");
		if ( r!=null ) System.out.println(dot.getDOT(atn.ruleToStartState[r.index]));

		int result = interp.matchATN(input, startState);
		assertEquals(expected, result);
	}
}

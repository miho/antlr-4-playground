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

package org.antlr.v4.runtime;

import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNSimulator;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Recognizer<Symbol, ATNInterpreter extends ATNSimulator> {
	public static final int EOF=-1;

	@NotNull
	private List<ANTLRErrorListener<? super Symbol>> _listeners =
		new CopyOnWriteArrayList<ANTLRErrorListener<? super Symbol>>() {{ add(ConsoleErrorListener.INSTANCE); }};

	protected ATNInterpreter _interp;

	/** Used to print out token names like ID during debugging and
	 *  error reporting.  The generated parsers implement a method
	 *  that overrides this to point to their String[] tokenNames.
	 */
	public abstract String[] getTokenNames();

	public abstract String[] getRuleNames();

	/** For debugging and other purposes, might want the grammar name.
	 *  Have ANTLR generate an implementation for this method.
	 */
	public abstract String getGrammarFileName();

	public abstract ATN getATN();

	public ATNInterpreter getInterpreter() { return _interp; }

	/** What is the error header, normally line/character position information? */
	public String getErrorHeader(RecognitionException e) {
		int line = e.offendingToken.getLine();
		int charPositionInLine = e.offendingToken.getCharPositionInLine();
		return "line "+line+":"+charPositionInLine;
	}

	/** How should a token be displayed in an error message? The default
	 *  is to display just the text, but during development you might
	 *  want to have a lot of information spit out.  Override in that case
	 *  to use t.toString() (which, for CommonToken, dumps everything about
	 *  the token). This is better than forcing you to override a method in
	 *  your token objects because you don't have to go modify your lexer
	 *  so that it creates a new Java type.
	 */
	public String getTokenErrorDisplay(Token t) {
		if ( t==null ) return "<no token>";
		String s = t.getText();
		if ( s==null ) {
			if ( t.getType()==Token.EOF ) {
				s = "<EOF>";
			}
			else {
				s = "<"+t.getType()+">";
			}
		}
		s = s.replaceAll("\n","\\\\n");
		s = s.replaceAll("\r","\\\\r");
		s = s.replaceAll("\t","\\\\t");
		return "'"+s+"'";
	}

	/**
	 * @throws NullPointerException if {@code listener} is {@code null}.
	 */
	public void addErrorListener(@NotNull ANTLRErrorListener<? super Symbol> listener) {
		if (listener == null) {
			throw new NullPointerException("listener cannot be null.");
		}

		_listeners.add(listener);
	}

	public void removeErrorListener(@NotNull ANTLRErrorListener<? super Symbol> listener) {
		_listeners.remove(listener);
	}

	public void removeErrorListeners() {
		_listeners.clear();
	}

	@NotNull
	public List<? extends ANTLRErrorListener<? super Symbol>> getErrorListeners() {
		return new ArrayList<ANTLRErrorListener<? super Symbol>>(_listeners);
	}

	public ANTLRErrorListener<? super Symbol> getErrorListenerDispatch() {
		return new ProxyErrorListener<Symbol>(getErrorListeners());
	}

	// subclass needs to override these if there are sempreds or actions
	// that the ATN interp needs to execute
	public boolean sempred(@Nullable RuleContext _localctx, int ruleIndex, int actionIndex) {
		return true;
	}

	public void action(@Nullable RuleContext _localctx, int ruleIndex, int actionIndex) {
	}

	public abstract IntStream getInputStream();

	public abstract void setInputStream(IntStream input);

	public abstract void setTokenFactory(TokenFactory<?> input);
}

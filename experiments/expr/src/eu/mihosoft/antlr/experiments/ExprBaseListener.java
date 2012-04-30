package eu.mihosoft.antlr.experiments;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

public class ExprBaseListener implements ExprListener {
	@Override public void enterMult(ExprParser.MultContext ctx) { }
	@Override public void exitMult(ExprParser.MultContext ctx) { }
	@Override public void enterAssign(ExprParser.AssignContext ctx) { }
	@Override public void exitAssign(ExprParser.AssignContext ctx) { }
	@Override public void enterS(ExprParser.SContext ctx) { }
	@Override public void exitS(ExprParser.SContext ctx) { }
	@Override public void enterNumber(ExprParser.NumberContext ctx) { }
	@Override public void exitNumber(ExprParser.NumberContext ctx) { }
	@Override public void enterAdd(ExprParser.AddContext ctx) { }
	@Override public void exitAdd(ExprParser.AddContext ctx) { }
	@Override public void enterPar(ExprParser.ParContext ctx) { }
	@Override public void exitPar(ExprParser.ParContext ctx) { }
	@Override public void enterSub(ExprParser.SubContext ctx) { }
	@Override public void exitSub(ExprParser.SubContext ctx) { }
	@Override public void enterVar(ExprParser.VarContext ctx) { }
	@Override public void exitVar(ExprParser.VarContext ctx) { }
	@Override public void enterInt(ExprParser.IntContext ctx) { }
	@Override public void exitInt(ExprParser.IntContext ctx) { }
	@Override public void enterDiv(ExprParser.DivContext ctx) { }
	@Override public void exitDiv(ExprParser.DivContext ctx) { }

	@Override public void enterEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void exitEveryRule(ParserRuleContext<Token> ctx) { }
	@Override public void visitTerminal(ParseTree.TerminalNode<Token> node) { }
	@Override public void visitErrorNode(ParseTree.ErrorNode<Token> node) { }
}
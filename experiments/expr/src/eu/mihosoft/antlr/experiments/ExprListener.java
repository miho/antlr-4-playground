package eu.mihosoft.antlr.experiments;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprListener extends ParseTreeListener<Token> {
	void enterMult(ExprParser.MultContext ctx);
	void exitMult(ExprParser.MultContext ctx);
	void enterAssign(ExprParser.AssignContext ctx);
	void exitAssign(ExprParser.AssignContext ctx);
	void enterS(ExprParser.SContext ctx);
	void exitS(ExprParser.SContext ctx);
	void enterNumber(ExprParser.NumberContext ctx);
	void exitNumber(ExprParser.NumberContext ctx);
	void enterAdd(ExprParser.AddContext ctx);
	void exitAdd(ExprParser.AddContext ctx);
	void enterPar(ExprParser.ParContext ctx);
	void exitPar(ExprParser.ParContext ctx);
	void enterSub(ExprParser.SubContext ctx);
	void exitSub(ExprParser.SubContext ctx);
	void enterVar(ExprParser.VarContext ctx);
	void exitVar(ExprParser.VarContext ctx);
	void enterInt(ExprParser.IntContext ctx);
	void exitInt(ExprParser.IntContext ctx);
	void enterDiv(ExprParser.DivContext ctx);
	void exitDiv(ExprParser.DivContext ctx);
}
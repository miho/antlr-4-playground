package eu.mihosoft.antlr.experiments;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface ExprVisitor<T> {
	T visitMult(ExprParser.MultContext ctx);
	T visitAssign(ExprParser.AssignContext ctx);
	T visitS(ExprParser.SContext ctx);
	T visitNumber(ExprParser.NumberContext ctx);
	T visitAdd(ExprParser.AddContext ctx);
	T visitPar(ExprParser.ParContext ctx);
	T visitSub(ExprParser.SubContext ctx);
	T visitVar(ExprParser.VarContext ctx);
	T visitInt(ExprParser.IntContext ctx);
	T visitDiv(ExprParser.DivContext ctx);
}
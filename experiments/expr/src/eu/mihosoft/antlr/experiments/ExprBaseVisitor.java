package eu.mihosoft.antlr.experiments;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;

public class ExprBaseVisitor<T> extends ParseTreeVisitor<T> implements ExprVisitor<T> {
	@Override public T visitMult(ExprParser.MultContext ctx) { return visitChildren(ctx); }
	@Override public T visitAssign(ExprParser.AssignContext ctx) { return visitChildren(ctx); }
	@Override public T visitS(ExprParser.SContext ctx) { return visitChildren(ctx); }
	@Override public T visitNumber(ExprParser.NumberContext ctx) { return visitChildren(ctx); }
	@Override public T visitAdd(ExprParser.AddContext ctx) { return visitChildren(ctx); }
	@Override public T visitPar(ExprParser.ParContext ctx) { return visitChildren(ctx); }
	@Override public T visitSub(ExprParser.SubContext ctx) { return visitChildren(ctx); }
	@Override public T visitVar(ExprParser.VarContext ctx) { return visitChildren(ctx); }
	@Override public T visitInt(ExprParser.IntContext ctx) { return visitChildren(ctx); }
	@Override public T visitDiv(ExprParser.DivContext ctx) { return visitChildren(ctx); }
}
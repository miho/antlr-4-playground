package eu.mihosoft.antlr.experiments;


import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class Main {

    public static void main(String[] args) {
        String inputText = "a=(2.+0.0)-3.0*4.0; c = 2+4+a;";

        ANTLRInputStream input = new ANTLRInputStream(inputText);

        ExprLexer lexer = new ExprLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);

        ExprParser parser = new ExprParser(tokens);

        parser.setBuildParseTree(true);  // tell ANTLR to build a parse tree

        ParserRuleContext tree = parser.s();

//        System.out.println(tree.toStringTree(parser));

        FirstExprVisitor visitor = new FirstExprVisitor();

        double result = visitor.visit(tree);
        
//        visitor.visit(tree);

        System.out.println("Result: " + result);

//        walker.walk(visitor, tree);



    }
}

class FirstExprVisitor extends ExprBaseVisitor<Double> {
    
    Map<String, Double> vars = new HashMap<String, Double>();
    
    @Override
    public Double visitMult(ExprParser.MultContext ctx) {

        System.out.println("MULT: " + ctx.getText());
        
        System.out.println("CTX.e0: " + ctx.e(0).getText());
        System.out.println("CTX.e1: " + ctx.e(1).getText());
        
//        return visitChildren(ctx); 
        
        return visit(ctx.e(0))*visit(ctx.e(1));
    }
    
    @Override
    public Double visitDiv(ExprParser.DivContext ctx) {
        
        System.out.println("DIV: " + ctx.getText());
        
//        return visitChildren(ctx); 
        
        return visit(ctx.e(0))/visit(ctx.e(1));
    }
    
    @Override
    public Double visitAdd(ExprParser.AddContext ctx) {
        
        System.out.println("ADD: " + ctx.getText());
        
//        return visitChildren(ctx); 
        
        return visit(ctx.e(0))+visit(ctx.e(1));
    }
    
    @Override
    public Double visitSub(ExprParser.SubContext ctx) {
        
        System.out.println("SUB: " + ctx.getText());
        
//        return visitChildren(ctx); 
        
        return visit(ctx.e(0))-visit(ctx.e(1));
    }
    
    @Override
    public Double visitNumber(ExprParser.NumberContext ctx) {
        
        System.out.println("NUMBER: " + ctx.getText());
        
//        return visitChildren(ctx); 
        
        return Double.valueOf(ctx.getText());
    }
    
    @Override
    public Double visitInt(ExprParser.IntContext ctx) {
        
        System.out.println("INT: " + ctx.getText());
        
//        return visitChildren(ctx); 
        
        return Double.valueOf(ctx.getText());
    }
    
    @Override
    public Double visitPar(ExprParser.ParContext ctx) {
        
        System.out.println("PAR: " + ctx.getText());
        
        return visit(ctx.e());

    }
    
    @Override
    public Double visitVar(ExprParser.VarContext ctx) {
        System.out.println("VAR: " + ctx.getText());
        
        if (!vars.containsKey(ctx.getText())) {
            System.err.println(
                    "ERROR: variable " + ctx.getText() + " is not defined!");
            System.exit(1);
        }
        
        return vars.get(ctx.getText());
    }
    
    @Override
    public Double visitAssign(ExprParser.AssignContext ctx) {
        System.out.println("VAR: " + ctx.getText());
        
        Double value = visit(ctx.e());
        
        vars.put(ctx.VAR().getText(), value);
        
        System.out.println(" --> " + ctx.VAR().getText() + " = " + value);
        
        return value;
    }

}

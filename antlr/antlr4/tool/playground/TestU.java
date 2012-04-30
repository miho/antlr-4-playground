import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

public class TestU {
	public static void main(String[] args) throws Exception {
		ULexer t = new ULexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(t);
		UParser p = new UParser(tokens);
		p.setBuildParseTree(true);
		ParserRuleContext r = p.s();
		System.out.println(r.toStringTree(p));
	}
}

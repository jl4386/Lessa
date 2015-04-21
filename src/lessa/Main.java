package lessa;


import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) throws Exception {
        ExprLexer lexer = new ExprLexer(new ANTLRFileStream("?"));
        ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
        //ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor();
        //visitor.visit(tree);
    }
}
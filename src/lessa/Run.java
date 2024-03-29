package lessa;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class Run {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        if (args.length > 0) 
        	inputFile = args[0];
        System.out.println(inputFile);
        InputStream is = System.in;
        if ( inputFile!=null ) 
        	is = new FileInputStream(inputFile);

        ANTLRInputStream input = new ANTLRInputStream(is);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog(); // parse

        //EvalVisitor eval = new EvalVisitor();
        //eval.visit(tree);
    }
}

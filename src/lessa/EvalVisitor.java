package lessa;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

import envir.Gen;


public class EvalVisitor extends ExprBaseVisitor<Integer> {
		Map<String, Integer> memory = new HashMap<String, Integer>();

		public EvalVisitor() throws FileNotFoundException, UnsupportedEncodingException {
			//writer = new PrintWriter("out.py", "UTF-8");
		}


		/** print_stmt: PRINT STRING ;*/
		@Override 
		public Integer visitPrint_stmt(ExprParser.Print_stmtContext ctx) {
				String print = ctx.PRINT().getText();
				String value = ctx.STRING().getText();
				
				try {
					Writer w = new FileWriter(Gen.exeFileName, false);
					w.write(print);
					w.write(value);
					System.out.println(print+value);
					w.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return 0;
		}

}

		

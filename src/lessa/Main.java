package lessa;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



//import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.python.core.PyException;
import org.python.util.PythonInterpreter;

import envir.Envir;
import envir.Gen;
import envir.MidiLis;
import envir.MidiPlay;
import envir.SenmanticError;
import envir.SemanErrorDic;
import envir.SymbolError;
import envir.SyntaxError;

public class Main {
	private static Scanner sc;
	private static PythonInterpreter interpreter;
	public boolean playflag = false; 
	
	private static List<String> readFile(String file) throws Exception {
		String line = null;
		List<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null) {
			lines.add(line);
			// System.out.println(line);
		}
		br.close();
		return lines;
	}

	private static int isComplete(String input, int count, Pattern pre,
			Pattern pos) {
		if (input.endsWith(";") && count == 0) {
			// System.out.println(strseen.toString())
			return count;
		}

		Matcher prematcher = pre.matcher(input);
		Matcher posmatcher = pos.matcher(input);

		while (prematcher.find())
			count++;
		while (posmatcher.find())
			count--;
		// System.out.println(""+count);

		if (input.endsWith("}") && count == 0) {
			// System.out.println("finish");

			return count;
		}
		return count;
	}

	private static void parse(String s, boolean repl) {
		InputStream stream = new ByteArrayInputStream(
				s.getBytes(StandardCharsets.UTF_8));
		ANTLRInputStream input;
		// parse the statement
		try {
			input = new ANTLRInputStream(stream);
			ExprLexer lexer = new ExprLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(TokenErrorListener.INSTANCE);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ExprParser parser = new ExprParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
			ParseTree tree = parser.prog(); // parse

			EvalVisitor eval = new EvalVisitor(repl);
			eval.visit(tree);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SyntaxError se) {
			// se.printStackTrace();
			System.err.println(se.getMessage());
		} catch (SymbolError sbe) {
			System.err.println(sbe.getMessage());
		}

	}

	private static void exec(boolean repl) throws InterruptedException {
		// run the statement
		interpreter = new PythonInterpreter();
		InputStream filepy;
		try {

			if (repl) {
				filepy = new FileInputStream(Envir.dir
						+ Envir.exeFileName);
				// execute a statement
	            
                if(Envir.playflag){
                  System.out.println("Song is going to play, waiting...");
                  MidiPlay player = new MidiPlay();
                  player.run();
                  MidiLis listener = new MidiLis(player.sequencer);
                  player.sequencer.addMetaEventListener(listener);
                  Envir.playflag =false;
                }else{
                  // execute a statement
                  interpreter.execfile(filepy);
                }
			} else {
			    
				filepy= new FileInputStream(Envir.dir
						+ Envir.compileFileName);
				
				interpreter.execfile(filepy);
			}
			
			

			// refresh variables
			Gen.refreshDirty(interpreter);

			filepy.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PyException se) {
			// se.printStackTrace();

			// TODO
			System.out.println("Debug helper output:" + se.type);
			SenmanticError le = SemanErrorDic.Exceptions.get(se.type);
			StringBuffer sb = new StringBuffer("Error Number:");
			sb.append(" ").append(le.codeNO).append("  Type:").append(le.type);
			sb.append("\nDescription: ").append(se.value);
			System.err.println(sb);
			System.out.println(se.traceback.dumpStack());

			// remove error variables
			Gen.removeErrorVariables();

		}
	}

	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		boolean repl = true;
		List<String> lines = new ArrayList<String>();
		if (args.length == 1) {
			lines = readFile(args[0]);
			repl = false;
		}

		// initialization
		Gen.initShell(repl);
		String input = null;
		Pattern pre = Pattern.compile("\\{");
		Pattern pos = Pattern.compile("\\}");

		StringBuffer strseen = new StringBuffer();
		int count = 0; // count the number of parenthesis
		if (repl) {
			System.out.println("Welcome to Lessa world!");
			System.out.println("Lessa 1.0");
			System.out.println("-------------------------------");
			while (!(input = sc.nextLine()).equals("exit()")) {
				strseen.append(input + "\n");
				if ((count = isComplete(input, count, pre, pos)) != 0)
					continue;

				parse(strseen.toString(), repl);
				exec(repl);
				strseen.delete(0, strseen.length());
			}
		} else {
			int index = 0;
			while (index < lines.size()) {
				input = lines.get(index);
				strseen.append(input + "\n");
				index++;
				if ((count = isComplete(input, count, pre, pos)) != 0)
					continue;
				parse(strseen.toString(), repl);
				strseen.delete(0, strseen.length());
			}
			exec(repl);
		}

		//Gen.closeShell();

		// ExprLexer lexer = new ExprLexer(new ANTLRFileStream("?"));
		// ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
		// //ParseTree tree = parser.parse();
		// EvalVisitor visitor = new EvalVisitor();
		// //visitor.visit(tree);
	}
}

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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import envir.Envir;
import envir.Gen;
import envir.Variable;

public class Main {
	private static Scanner sc;
	private static PythonInterpreter interpreter;

	private static void parse(String s) {
		InputStream stream = new ByteArrayInputStream(
				s.getBytes(StandardCharsets.UTF_8));
		ANTLRInputStream input;
		// parse the statement
		try {
			input = new ANTLRInputStream(stream);
			ExprLexer lexer = new ExprLexer(input);
			lexer.removeErrorListeners();
			lexer.addErrorListener(DescriptiveErrorListener.INSTANCE);
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ExprParser parser = new ExprParser(tokens);
			parser.removeErrorListeners();
			parser.addErrorListener(DescriptiveErrorListener.INSTANCE);
			ParseTree tree = parser.prog(); // parse

			EvalVisitor eval = new EvalVisitor();
			eval.visit(tree);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void exec() {
		// run the statement
		interpreter = new PythonInterpreter();
		try {

			InputStream filepy = new FileInputStream(Envir.dir
					+ Envir.exeFileName);
			interpreter.execfile(filepy);
			Iterator<Entry<String, Variable>> it = Envir.varTable.entrySet()
					.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Variable> pair = it.next();
				if (pair.getValue().dirty) {
					PyObject value = interpreter.get(pair.getKey());
					pair.getValue().value = value.toString();
				}
			}

			filepy.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static List<String> readFile(String file) throws Exception {
		String line = null;
		List<String> lines = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((line = br.readLine()) != null)
			lines.add(line);
		br.close();
		return lines;
	}

	private static boolean isComplete(String input, Pattern pre, Pattern pos) {
		int count = 0; // count the number of parenthesis
		if (input.endsWith(";") && count == 0) {
			// System.out.println(strseen.toString())
			return true;
		}

		Matcher prematcher = pre.matcher(input);
		Matcher posmatcher = pos.matcher(input);

		while (prematcher.find())
			count++;
		while (posmatcher.find())
			count--;

		if (input.endsWith("}") && count == 0) {
			// System.out.println(strseen.toString());
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		sc = new Scanner(System.in);
		int repl = 1;
		List<String> lines = new ArrayList<String>();
		if (args.length == 1) {
			lines = readFile(args[0]);
			repl = lines.size();
		}

		// initialization
		Gen.initShell();
		String input = null;
		Pattern pre = Pattern.compile("\\{");
		Pattern pos = Pattern.compile("\\}");

		StringBuffer strseen = new StringBuffer();

		if (args.length == 0) {
			System.out.println("Welcome to Lessa world!");
			System.out.println("Lessa 1.0");
			System.out.println("-------------------------------");
		}
		while (!(input = sc.nextLine()).equals("exit()")) {
			strseen.append(input + "\n");
			if (!isComplete(input, pre, pos))
				continue;
			parse(strseen.toString());
			// exec();
			strseen.delete(0, strseen.length());
		}

		Gen.closeShell();

		// ExprLexer lexer = new ExprLexer(new ANTLRFileStream("?"));
		// ExprParser parser = new ExprParser(new CommonTokenStream(lexer));
		// //ParseTree tree = parser.parse();
		// EvalVisitor visitor = new EvalVisitor();
		// //visitor.visit(tree);
	}
}
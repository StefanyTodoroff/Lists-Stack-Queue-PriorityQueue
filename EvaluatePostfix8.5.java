package stefy;


import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostfix5 {
	public static void main(String[] args) {
		System.out.println("Enter an expression with reverse polish notation: ");
		Scanner sc = new Scanner(System.in);
		String expression = sc.nextLine();
		sc.close();
		try {
			System.out.println(evaluateExpression(expression));
		} catch (Exception ex) {
			System.out.println("Wrong expression: " + args[0]);
		}

	}

	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<Integer>();
		expression = insertBlanks(expression);
		//Extract operands and operators
		String[] tokens = expression.split(" ");
		//Phase 1: Scan tokens
		for (String token : tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' || token.charAt(0) == '-' ||  token.charAt(0) == '*' 
					|| token.charAt(0) == '/' ||  token.charAt(0) == '^') {
					processAnOperator(operandStack, token.charAt(0));
			} else { // An operand scanned
				//Push an operand to the stack
				operandStack.push(Integer.valueOf(token));
			}
		}
		//Return the result
		return operandStack.pop();

	}
	
	static void processAnOperator(Stack<Integer> operandStack, int op) {
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+')
			operandStack.push(op2 + op1);
		else if (op == '-')
			operandStack.push(op2 - op1);
		else if (op == '*')
			operandStack.push(op2 * op1);
		else if (op == '/')
			operandStack.push(op2 / op1);
		else if (op == '^')
			operandStack.push((int) Math.pow(op2, op1));
	}

	public static String insertBlanks(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '+' || s.charAt(i) == '-'
					|| s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '^')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}
		return result;
	}
}

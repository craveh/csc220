package lab07;

import java.util.*;

//Extension of Chapter 14.4 Case Study: Expression Evaluator

public class Postfixer {


	/**
	*  Determines if the first operator has same or greater
    *  precedence than the second
	*
	* @param op1 the first operator
	* @param op2 the second operator
	* @return the boolean result
	*/
	private static boolean hasPrecedence(String op1, String op2) {
		if(opToPrcd(op1)!= -1 && opToPrcd(op2) != 0) {
			if(opToPrcd(op1)<=opToPrcd(op2)) {
				return true;
			}else {
				return false;
			}
			
		}else {
			return false;
		}
	}


	/**
	* Converts an operator to its precedence priority
	*
	* We expect you to be able to handle +, -, *, /, ^, and (
	* (why don't you need ")" as well? see algorithm in part 4)
	*
	* The order of these is as follows:
	*    ^, * and /, + and -, (
	*
	* @param op a string representing an operator, e.g. "+" or "-"
	* @return an integer value reflecting its precedence
	*/
	private static int opToPrcd(String op) {
		if(isOperator(op)) {
			if(op.equals("^")) {
		    	return 0;
		    }else if(op.equals("*")||op.equals("/")) {
		    	return 1;
		    }else if(op.equals("+")||op.equals("-")) {
		    	return 2;
		    }else {
		    	return 3;
		    }
		}else {
			return -1;
		}
	    
	}

	/**
	* determines if the input token is an operator
	*
	* @param token the string token to check
	* @return a boolean reflecting the result
	*/
	private static boolean isOperator(String token) {
		if(token.equals("+")||token.equals("-")||token.equals("/")||token.equals("*")||token.equals("(")||token.equals("^")) {
			return true;
		}else{
			return false; 
		}
		
	}

	/**
    * Evaluates an expression
    *
    * NOTE Beware the order of pop and evaluation when receiving operand1
    * and operand2 as input.
    *
    * @param operand1 the first operand
    * @param operator the operator to apply
    * @param operand2 the second operand
    * @return a double expressing the result
    * @throws IllegalArgumentException if operator passed is not one of
    *  "+", "-", "*", "/", or "^"
    *
	*/
	private static double evaluate(double operand1, String operator, double operand2){
		double eval = 0.0; 
		
		
			switch(operator){
			case "+":
				eval = operand1 + operand2;
				break;
				
			case "-":
				eval = operand1 - operand2;
				break;
			case "*":
				eval = operand1 * operand2;
				break;
			case "/":
				eval = operand1 / operand2;
				break;
			case "^":
				eval = Math.pow(operand1, operand2);
				break;
			default:
				throw new IllegalArgumentException();
			}			
			return eval;
			
	}
	
	/**
	*Checks if the String passed in not a number by checking 
	*if it is an operator (includes ")" which is not included above
	*returns true if it is an operator
	*
	*@param String that is an operator or operand
	*@return Boolean if it is any operator
	*/
	public static boolean notNum(String data) {
		if(data.equals("+")||data.equals("-")||data.equals("/")||data.equals("*")||data.equals("(")||data.equals("^")||data.equals(")")) {
			return true;
		}else{
			return false; 
		}
		
	}
	
	
	
	/**
	 *pops operator from operator stack, and pops 2 operands
	 *from operand stack and evaluates
	 *@param stack of operators
	 *@param stack of operands
	 *@return the result of the evaluation
	 */
	private static void startEval(Stack<String> operators, Stack<Double> operands) {
		//System.out.println(operators.peek());
		String operator = operators.pop();
		double num2 = operands.pop();
		double num1 = operands.pop();
		double result = evaluate(num1, operator, num2);
		operands.push(result);
				
	}


	/**
	* Evaluates an infix algebraic expression, uses the StringSplitter
	* class, as well as 2 Stacks
	* @param Expression to evaluate
	* @return result of the evaluation
	*/
	public static double infixEvaluator(String line){
		StringSplitter info = new StringSplitter(line);
		Stack<String> operators = new Stack<String>();
		Stack<Double> operands = new Stack<Double>();
		String data;
		
		while(info.hasNext()) {
			data = info.next();
			if(!notNum(data)) {
				operands.push(Double.parseDouble(data));
			}else if(data.equals("(")) {
				operators.push(data);
			}else if(data.equals(")")) {
				
				while(!operators.peek().equals("(")) {
					
					//System.out.println("run" + operators.peek());
					startEval(operators, operands);
				}
				//System.out.println(operators.peek());
				operators.pop();
				
			}else{
				while(!operators.empty()&& hasPrecedence(operators.peek(), data)) {
					startEval(operators, operands);
				}
				operators.push(data);
			}
		}
		
		while(!operators.empty()) {
			startEval(operators, operands);
		}
		
		
		
		
		return operands.pop(); // placeholder

	}

	/**
	* Converts from an mathematical expression in infix notation to 
	* to postfix notation
	* @param Expression in infix notation
	* @return Expression in postfix notation
	*/
	public static String toPostfix(String line){
		StringSplitter expression = new StringSplitter(line);
		Stack<String> operators = new Stack<String>();
		String postfix = "";
		String data;
		while(expression.hasNext()) {
			data = expression.next();
			if(!notNum(data)) {
				postfix += data;
			}else if(data.equals("(")) {
				operators.push(data);
			}else if(data.equals(")")) {
				while(!operators.peek().equals("(")) {
					postfix += operators.pop();
				}
				operators.pop();
			}else {
				while(!operators.peek().equals("(") && hasPrecedence(operators.peek(), data)) {
					postfix += operators.pop();
				}
				operators.push(data);
			}
		}
		return postfix; 
	}


	public static void main(String[] args){
		//System.out.println(12.0 == 12);
		//Test hasPrecedence
		//System.out.println(hasPrecedence("(", "/"));
		//Test opToPrcd
		int preced = opToPrcd("(");
		//System.out.println(preced);
		//Test isOperator
		//System.out.println(isOperator("6"));
		
		//Test evaluate()
		double result = evaluate(2.0, "^", 4.0);
		//System.out.println(result);
		
		//System.out.println(infixEvaluator("(2 + 10)"));
		
		//System.out.println(infixEvaluator("10 + 2"));
		//System.out.println(infixEvaluator("10 - 2 * 2 + 1"));
		//System.out.println(infixEvaluator("(10 + 2)"));
		

        if (infixEvaluator("10 + 2") != 12)
            System.err.println("test0 failed --> your answer should have been 12");

        if (infixEvaluator("10 - 2 * 2 + 1") != 7)
            System.err.println("test1 failed --> your answer should have been 12");

        if (infixEvaluator("100 * 2 + 12") != 212)
            System.err.println("test2 failed --> your answer should have been 212");

        if (infixEvaluator("100 * ( 2 + 12 )") != 1400)
            System.err.println("test3 failed --> your answer should have been 1400");

        if (infixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
            System.err.println("test4 failed --> your answer should have been 100");


        System.out.println("Lab Testing Done!!!");

        /* uncomment the below lines for assignmemt */
		if (!toPostfix(new String("(4+5)")).equals("45+"))
		     System.err.println("test1 failed --> should have been 45+");

		 if (!toPostfix(new String("((4+5)*6)")).equals("45+6*"))
		    System.err.println("test2 failed --> should have been 45+6*");

		 if (!toPostfix(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
		     System.err.println("test3 failed --> should have been 456*7/+8-");

		 if (!toPostfix(new String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
		     System.err.println("test4 failed --> should have been 4567-*+8/");

		 if (!toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
		     System.err.println("test5 failed --> should have been 987*654^/3*-2*+");


         System.out.println(toPostfix("(4+5)"));
		 System.out.println("Assignment Testing Done!!!");


	}

}

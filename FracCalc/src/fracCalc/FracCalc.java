package fracCalc;

import java.util.Scanner;

public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner scanner = new Scanner(System.in);
    	System.out.print("Input: ");
    	String userInput = scanner.nextLine();
    	while (!userInput.equals("quit")) {
        	System.out.println(produceAnswer(userInput));
        	System.out.print("Input: ");
        	userInput = scanner.nextLine();
    	}
    	scanner.close();
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input) { 
        // TODO: Implement this function to produce the solution to the input
        String[] array = input.split(" ");
        int[] first = toImproperFrac(parse3(array[0]));
        String operator = array[1];
        int[] second = toImproperFrac(parse3(array[2]));
        if (operator.equals("+")) {
        	int common = makeDenominatorsEqual(first[2], second[2]);
        	first[1] *= common / first[2];
        	second[1] *= common / second[2];
        	return (first[0] * first[1]) + (second[0] * second[1]) + "/" + common;
        } else if (operator.equals("-")) {
        	int common = makeDenominatorsEqual(first[2], second[2]);
        	first[1] *= common / first[2];
        	second[1] *= common / second[2];
        	return (first[0] * first[1]) - (second[0] * second[1]) + "/" + common;
        } else if (operator.equals("*")) {
        	return ((first[0] * second[0]) * (first[1] * second[1])) + "/" + (first[2] * second[2]);
        } else if (operator.equals("/")) {
           	return ((first[0] * second[0]) * (first[1] * second[2])) + "/" + (first[2] * second[1]);
        }
        return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String[] parse3 (String operand) {
    	String whole;
    	String numerator;
    	String denominator;
    	String sign;
    	if (operand.contains("_")) {
    		// if operand is a mixed fraction
    		String[] parsedOnce = operand.split("_");
    		String[] parsedTwice = parsedOnce[1].split("/");
    		whole = parsedOnce[0];
    		numerator = parsedTwice[0];
    		denominator = parsedTwice[1];
    	} else if (operand.contains("/")) {
    		// if operand is an improper fraction
    		String[] parsedOperand = operand.split("/");
    		whole = "0";
    		numerator = parsedOperand[0];
    		denominator = parsedOperand[1];
    	} else {
    		// if operand is an integer
    		whole = operand;
    		numerator = "0";
    		denominator = "1";
    	}
    	if (whole.contains("-")) {
    		sign = "-1";
    		String[] withoutNegative = whole.split("-");
    		whole = withoutNegative[1];
    	} else {
    		sign = "1";
    	}
    	String[] result = {sign, whole, numerator, denominator};
    	return result;
    }
    public static int[] toImproperFrac (String[] input) {
    	int[] result = new int[3];
    	result[0] = Integer.parseInt(input[0]);
    	result[1] = Integer.parseInt(input[1]) * Integer.parseInt(input[3]) + Integer.parseInt(input[2]);
    	result[2] = Integer.parseInt(input[3]);
    	return result;
    }
    public static int makeDenominatorsEqual (int x, int y) {
    	if (x == y) {
    		return x;
    	} else {
    		int large;
    		int small;
    		if (x < y) {
    			large = y;
    			small = x;
    		} else {
    			large = x;
    			small = y;
    		}
    		int num1 = small;
    		while (large % num1 != 0) {
    			num1++;
    		}
    		int num2 = large * small;
    		if (num1 <= num2) {
    			return num2;
    		} else {
    			return num1;
    		}
    	}
    }
}

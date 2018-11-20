package fracCalc;

import java.util.Arrays;
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
        parse3(array[0]);
        return parse3(array[2]);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    public static String parse3 (String operand) {
    	String whole;
    	String numerator;
    	String denominator;
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
    	return "whole:" + whole + " numerator:" + numerator + " denominator:" + denominator;
    }
}

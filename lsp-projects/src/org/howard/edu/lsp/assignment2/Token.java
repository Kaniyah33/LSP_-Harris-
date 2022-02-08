package org.howard.edu.lsp.assignment2;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * This program provides the sum and product of tokens input by the user.
 * @author Kaniyah Harris. 
 *
 */
public class Token {
	// Main driver method
	/**
	   *
	   * The method asks for user input tokens and displays the tokens, their sum, and their product in the console until the user types "Goodbye".
	   * @param args, array of string arguments
	   *
	*/
	public static void main(String[] args)
	{
		//while the user input is not "Goodbye"
		while (true) {
			//takes in the user input and assigns it to variable tok
			Scanner myObj = new Scanner(System.in);
			System.out.println("enter token");
			String tok = myObj.nextLine();
			
			//checks if the user input is "Goodbye"
			if (tok.contains("Goodbye")){
				System.out.println("The End");
				myObj.close();
				System.exit(0);
			}
			
			//Splits the string up by spacing
			String[] splitStr = tok.split("\\s+");
			System.out.println("Tokens:");
			
			//Converts string array to integer array and displays the value of integers
			List<String> list = Arrays.asList(splitStr);
	        List<Integer> newList = new ArrayList<>();
	        for (String s : list) {
	            newList.add(Integer.parseInt(s));
	            System.out.println(s);
	        }
	        
	        //establishes the base values for total and the product
	        int total = 0;
			int prod = 1;
			
			//calculates the total and product based on the tokens
			for (int i = 0; i < newList.size(); i++) {
				total += newList.get(i);
				prod *= newList.get(i);
			}
			
			//prints the value of the total and product
			System.out.println("Sum: " + total);
			System.out.println("Product: " + prod);
	
		}
	}
}

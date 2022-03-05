package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

public class Driver {
	public static void main(String[] args) throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		System.out.println(set1);
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("The length of set1 is:" + set1.length());
		System.out.println("Smallest value in Set1 is:" + set1.smallest());
		System.out.println("Largest value in Set1 is:" + set1.largest());
		
		System.out.println("---------");
		
		System.out.println("This is me trying to add the same number (1) to the set to see if it duplicates");
		set1.add(1);
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("---------");
		
		IntegerSet set2 = new IntegerSet();
		set2.add(4);
		set2.add(5);
		
		System.out.println("Is set1 equal to set2?: " + set1.equals(set2));
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		
		System.out.println("---------");
		 
		System.out.println("Union of Set1 and Set2");
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		
		set1.union(set2);	// union of set1 and set2
		System.out.println("Result of union of Set1 and Set2");
		System.out.println(set1.toString());	// result of union of set1 and set2
		
		System.out.println("---------");
		
		//checking to see if set1 contains an element in set2
		
		System.out.println("Does set 1 contain an element in set2?: " + set1.contains(4));
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		
		System.out.println("---------");
		
		System.out.println("Value of Set1 is:" + set1.toString());
		set1.remove(5);
		System.out.println("Removing a set2 element from set1");
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());
		
		System.out.println("---------");
		
		System.out.println("Intersection of Set1 and Set2");
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());

		set1.intersect(set2);	// intersection of set1 and set2
		System.out.println("Result of union of Set1 and Set2");
		System.out.println(set1.toString());
		
		System.out.println("---------");
		
		System.out.println("Difference of Set1 and Set2");
		System.out.println("Value of Set1 is:" + set1.toString());
		System.out.println("Value of Set2 is:" + set2.toString());

		set2.diff(set1);	// difference of set1 and set2
		System.out.println("Result of difference of Set1 and Set2");
		System.out.println(set2.toString());
		
		System.out.println("---------");
		
		System.out.println("Check if sets are empty"); //checking if sets are empty
		System.out.println("length of set1 is " + set1.length() + ", Set1: " + set1.toString());
		System.out.println("Is set1 empty?: " + set1.isEmpty());
		
		System.out.println("length of set2 is " + set2.length() + ", Set2: " + set2.toString());
		System.out.println("Is set2 empty?: " + set2.isEmpty());
		
		System.out.println("---------");
		set1.clear();
		System.out.println("Set1 has been cleared. The length of set1 is " + set1.length());
		System.out.println("Is set1 empty?: " + set1.isEmpty());
		
	
		
		

	}
}

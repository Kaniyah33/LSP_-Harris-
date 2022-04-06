package org.howard.edu.lsp.assignment6.implementation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Kaniyah Harris
 * March 4, 2022
 * The program compares the values of IntegerSets
 *
 */

public class IntegerSet  {
	// Main driver method
		/**
		   *
		   * The method checks if an integer set is empty, its length, the maximum and minimum values, if it contains a certain element, as well as compares it to another integer set
		   * The method also allows for you to add or remove elements from the set, and display which elements are in the set.
		   *
		*/
	
	// Hint: probably best to use an array list.  You will need to do a little research
	private ArrayList<Integer> set = new ArrayList<Integer>();

	public ArrayList<Integer> getSet() {return set;}
	
	/**
	 * Default Constructor
	 */
	public IntegerSet() {
	}

	/**
	 *  Clears the internal representation of the set
	 */
	public void clear() {
		set.clear();
	};
	
	/**
	 *  
	 * @return the length of the set
	 */
	
	public int length() {
		return set.size();
	}; // returns the length
	
	/**
	 * @return true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	*/
	public boolean equals(IntegerSet b) {
		ArrayList<Integer> Listb = b.getSet();
	
		if (set.size() == Listb.size()){
			return true;
		}
		else {
			return false;
		}
	}; 
	/**
	 * 
	 * @param value is an integer
	 * @return true if the set contains the value, otherwise false
	 */
	
	public boolean contains(int value) {
		if (set.contains(value)) {
			return true;
		}
		else {
			return false;
		}
	};    
	/**
	 * 
	 * @return maximum value in set
	 * @throws IntegerSetException if list is empty
	 */
	
	public int largest() throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("list is empty");
		}
		return Collections.max(set);
	}; 
	
	/**
	 * 
	 * @return minimum value in set
	 * @throws IntegerSetException if the list is empty
	 */
	
	public int smallest() throws IntegerSetException {
		//try {
			//return Collections.min(set);
		//}
		//catch (java.util.NoSuchElementException i){
			//System.out.println("list is empty");
			//System.out.println(i.getMessage());
		//}
		//System.out.println("program complete");
		//return 0;
		if (set.size() == 0) {
			throw new IntegerSetException("list is empty");
		}
		else{
			return Collections.min(set);
		}
	}; 
	
	/**
	 * Adds a specific element from IntegerSet or does nothing if this element is already there.
	 * @param item is an integer
	 */
	
	public void add(int item) {
		if (set.contains(item)) {
		}
		else {
			set.add(item);
		}
	}; // adds item to the set or does nothing if it is in set
	
	/**
	 * Removes a specific element from IntegerSet or does nothing if this element is not there.
	 * an IntegerSetException if the list is empty.
	 * @param item is an integer
	 * @throws IntegerSetException 
	 */
	
	public void remove(int item) throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("list is empty");
		}
		else{
			int index = set.indexOf(item);
			set.remove(index);
		}
	};  //Throws a IntegerSetException of the set is empty
	
	/**
	 * This performs a union between the two sets.
	 * An IntegerSetException if the list is empty
	 * @param intSetb Instance of IntegerSet
	 * @throws IntegerSetException 
	 */
	public void union(IntegerSet intSetb) throws IntegerSetException {
		if (set.isEmpty() || intSetb.getSet().isEmpty()) {
			throw new IntegerSetException("list is empty");
		}
		ArrayList<Integer> intListb = intSetb.getSet();
		for (int i=0; i < intListb.size(); i++) {
			add(intListb.get(i));
		}

	};
	
	/**
	 * This performs an intersection between the two sets.
	 * An IntegerSetException if the list is empty.
	 * @param intSetb Instance of IntegerSet
	 * @throws IntegerSetException 
	 */
	public void intersect(IntegerSet intSetb) throws IntegerSetException {
		if (set.isEmpty() || intSetb.getSet().isEmpty()) {
			throw new IntegerSetException("list is empty");
		}
		ArrayList<Integer> intListb = intSetb.getSet();
		set.retainAll(intListb);
		}; 
	
	/**
	 * This performs the difference between the two sets.
	 * An IntegerSetException if the list is empty.
	 * @param intSetb Instance of IntegerSet
	 * @throws IntegerSetException 
	 */
	
	public void diff(IntegerSet intSetb) throws IntegerSetException {
		if (set.isEmpty() || intSetb.getSet().isEmpty()) {
			throw new IntegerSetException("list is empty");
		}
		ArrayList<Integer> intListb = intSetb.getSet();
		set.removeAll(intListb);
	}; // set difference, i.e. s1 - s2
	
	/**
	 * This checks if the set is empty.
	 * @return true if the set is empty, false otherwise
	 */
	
	public boolean isEmpty() {
		if (set.size() == 0) {
			return true;
		}
		else {
			return false;
		}
	}; 
	
	/**
	 * Turns the set into a string that can be displayed.
	 * @return String representation of the set.

	 */

	public String toString() {
		String word = "[";
		for (int i=0; i < set.size(); i++) {
			word += set.get(i);
			word += ", ";

		}
		word = word.substring(0, word.length() -1);
		word = word.substring(0, word.length() -1);
		word += "]";
		return(word);
	};	}


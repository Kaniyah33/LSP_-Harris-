package org.howard.edu.lsp.assignment6.junit;

import org.howard.edu.lsp.assignment6.implementation.IntegerSet;
import org.howard.edu.lsp.assignment6.implementation.IntegerSetException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
	@Test
    @DisplayName("Test case for empty")
    public void testIsEmpty() {
       IntegerSet set1 = new IntegerSet();
       //test that set 1 is empty when it is empty
       assertTrue(set1.isEmpty());
       //test that set 1 is empty when it is not empty
       set1.add(1);
       assertFalse(set1.isEmpty());
       }
	
	@Test
	@DisplayName("Test case for length")
	public void testLength() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		//test that the length of set 1 is equal to 3
		assertEquals(3, set1.length());
		assertEquals("[1, 2, 3]", set1.toString());
	}
	
	@Test
	@DisplayName("Test case for equal integer sets")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		IntegerSet set2 = new IntegerSet();
		set2.add(1);
		set2.add(2);
		set2.add(3);
		//Test for sets that are equal
		boolean value = set1.equals(set2);
		assertEquals(true, value);
		//Test for unequal sets
		set1.add(4);
		value = set1.equals(set2);
		assertEquals(false, value);
	}
	
	@Test
	@DisplayName("Test case for containing an integer in a set")
	public void testContains() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		//test for an integer (1) that is in the integer set
		boolean value = set1.contains(1);
		assertEquals(true, value);
		//Test for an integer (5) that is not in the integer set
		value = set1.contains(5);
		assertEquals(false, value);
	}
	
	@Test
	@DisplayName("Test for largest integer in integer set")
	public void testLargest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		//test if 3 is the largest in an integer set in which 3 is the largest 
		assertEquals(3, set1.largest());
		//test if 2 is the largest in an integer set where 3 is the largest
		assertFalse(set1.largest() == 2);
	}
	
	@Test
	@DisplayName("Test cases for largest throws exception")
	public void testLargest_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.largest();
		});
		String expectedMessage = "list is empty";
		String actualMessage = exception.getMessage();
		//test that the integer set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("Test cases for smallest")
	public void testSmallest() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.smallest();
		//test if 1 is the smallest in an integer set in which 1 is the smallest 
		assertEquals(1, set1.smallest());
		//test if 3 is the smallest in an integer set in which 1 is the smallest 
		assertFalse(set1.smallest() == 3);
		
	}
	
	@Test
	@DisplayName("Test cases for smallest throws exception")
	public void testSmallest_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.smallest();
		});
		String expectedMessage = "list is empty";
		String actualMessage = exception.getMessage();
		//test that the integer set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("Test cases for add")
	public void testAdd() {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		IntegerSet value = set1;
		IntegerSet expected = new IntegerSet();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		//Test if 1,2, and 3 are added to the Integer Set without being duplicated
		assertTrue(expected.equals(value));
		//Test that set1 contains 1, 2, and 3
		assertEquals("[1, 2, 3]", set1.toString());
		assertTrue(set1.contains(1));
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
		//Test that set1 does not contain the integer 4 when it only contains 1, 2, and 3
		assertFalse(set1.contains(4));
	}
	
	@Test
	@DisplayName("Test cases for remove")
	public void testRemove() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.remove(4);
		IntegerSet expected = new IntegerSet();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		//test that set 1 no longer contains the integer 4
		assertFalse(set1.contains(4));
		//test that the output of set1 after 4 is removed, is equal to the output of set 2
		assertTrue(set1.equals(expected));
		
	}
	
	@Test
	@DisplayName("Test cases for remove throws exception")
	public void testRemove_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.remove(4);
		});
		String expectedMessage = "list is empty";
		String actualMessage = exception.getMessage();
		//test that the integer set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("Test cases for union")
	public void testUnion() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		IntegerSet set2 = new IntegerSet();
		set2.add(3);
		set1.union(set2);
		//test that when set1 forms a union, that it is formed in the correct order
		assertEquals("[1, 2, 3]", set1.toString());
		assertNotEquals("[3, 2, 1]", set1.toString());
	}
	
	@Test
	@DisplayName("Test cases for union throws exception")
	public void testUnion_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.union(set2);
		});
		String expectedMessage = "list is empty";
		String actualMessage = exception.getMessage();
		//test that the integer set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("Test cases for intersect")
	public void testIntersect() throws IntegerSetException{
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(3);
		set1.intersect(set2);
		//test that 2, and 3 are the only shared integers between set1 and set2
		assertEquals("[2, 3]", set1.toString());
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
		assertFalse(set2.contains(4));
	}
	
	@Test
	@DisplayName("Test cases for intersect throws exception")
	public void testIntersect_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.intersect(set2);
		});
		String expectedMessage = "list is empty";
		String actualMessage = exception.getMessage();
		//test that the integer set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("Test cases for difference")
	public void testDifference() throws IntegerSetException{
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		IntegerSet set2 = new IntegerSet();
		set2.add(2);
		set2.add(3);
		set1.diff(set2);
		//Test that the integers 1, and 4 are not shared between the sets
		assertEquals("[1, 4]", set1.toString());
		//test that 2, and 3 WERE the only shared integers between set1 and set2
		assertFalse(set1.contains(2));
		assertFalse(set1.contains(3));
	}
	
	@Test
	@DisplayName("Test cases for difference throws exception")
	public void testDifference_THROWS_EXCEPTION() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			set1.diff(set2);
		});
		String expectedMessage = "list is empty";
		String actualMessage = exception.getMessage();
		//test that the integer set is empty
		assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@Test
	@DisplayName("Test cases for toString")
	public void testToString() throws IntegerSetException {
		IntegerSet set1 = new IntegerSet();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.toString();
		//test that the integer set displays correctly when printed
		assertEquals("[1, 2, 3]", set1.toString());
		assertNotEquals("[3, 2, 1]", set1.toString());
	}
}


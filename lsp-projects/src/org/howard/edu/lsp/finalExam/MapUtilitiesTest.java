package org.howard.edu.lsp.finalExam;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MapUtilitiesTest {
	@Test
    @DisplayName("Test case for empty hashmaps")
    public void testIsEmpty() throws NullMapException {
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		//test that map 1 and map 2 have no common key,value pairs when they have no key,value pairs in them
		assertEquals(0,MapUtilities.commonKeyValuePairs(map1,map2));
		assertEquals(0, map1.size());
		assertTrue(map1.isEmpty());
		assertEquals(0, map2.size());
		assertTrue(map2.isEmpty());
        //test that map1 is not empty when it contains a key, value pair
		map1.put("Alice", "Happy");
		assertFalse(map1.isEmpty());
		//test that map2 is still empty and would return 0 key,value pairs in common
		assertTrue(map2.isEmpty());
		assertEquals(0,MapUtilities.commonKeyValuePairs(map1,map2));
	}
	
	@Test
    @DisplayName("Test case for null hashmaps")
    public void testIsNull_THROWS_EXCEPTION() throws NullMapException {
		HashMap<String, String> map1 = null;
		HashMap<String, String> map2 = new HashMap<String, String>();
		Exception exception = assertThrows(NullMapException.class, () ->{
			MapUtilities.commonKeyValuePairs(map1,map2);
		});
		
		String expectedMessage = "one or both maps are null!";
		String actualMessage = exception.getMessage();
		//test that one HashMap is null and will return a message that it is null
		assertEquals(expectedMessage, actualMessage);
		
		//********************************************//
		
		map2.put("Kaniyah", "Stressed");
		Exception exception2 = assertThrows(NullMapException.class, () ->{
			MapUtilities.commonKeyValuePairs(map1,map2);
		});
		
		String expectedMessage2 = "one or both maps are null!";
		String actualMessage2 = exception2.getMessage();
		//test that one HashMap is still null and will return a message that it is null even though a key, value pair has been added to the other HashMap
		assertEquals(expectedMessage2, actualMessage2);
		
		//********************************************//
		
		HashMap<String, String> map3 = null;
		Exception exception3 = assertThrows(NullMapException.class, () ->{
			MapUtilities.commonKeyValuePairs(map1,map3);
		});
		
		String expectedMessage3 = "one or both maps are null!";
		String actualMessage3 = exception3.getMessage();
		//test that both HashMaps are null and will return a message that it is null
		assertEquals(expectedMessage3, actualMessage3);
	}
	
	@Test
    @DisplayName("Test case for similar kay,value pairs in hashmaps")
    public void testEquals() throws NullMapException {
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		map1.put("Alice","Healthy");
		map2.put("Mike","Sad");
		//test that map1 and map2 have no key,value pairs in common and the maps are not empty
		assertEquals(0,MapUtilities.commonKeyValuePairs(map1,map2));
		
		map1.put("Mary","Ecastic");
		map1.put("Bob","Happy");
		map1.put("Chuck","Fine");
		map1.put("Felix","Sick");
		
		map2.put("Mary","Ecastic");
		map2.put("Bob","Happy");
		map2.put("Tam","Fine");
		map2.put("Felix","Healthy");
		map2.put("Ricardo","Subperb");
	
		//test that map 1 and map 2 have 2 common key, value pairs
		assertEquals(2,MapUtilities.commonKeyValuePairs(map1,map2));
		
		map2.put("Alice", "Healthy");
		map2.put("Chuck", "Fine");
		//test that map 1 and map 2 have 4 common key, value pairs after adding two more pairs to map2
		assertEquals(4,MapUtilities.commonKeyValuePairs(map1,map2)); 
	}
	
}

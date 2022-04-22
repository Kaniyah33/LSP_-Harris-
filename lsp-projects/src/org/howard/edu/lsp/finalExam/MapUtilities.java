package org.howard.edu.lsp.finalExam;

import java.util.HashMap;
import java.util.Map;
//import org.howard.edu.lsp.finalExam.NullMapException;

public class MapUtilities {
    public static int commonKeyValuePairs(
        HashMap<String, String> map1,
        HashMap<String, String> map2)throws NullMapException {
    	

    	if (map1 == null || map2 == null) {
    		throw new NullMapException("one or both maps are null!"); 
    	}

    	if (map1.isEmpty() || map2.isEmpty()){
    		return 0;
		}
    	
    	
    	int num = 0;
    	for (Map.Entry<String, String> mapElement : map1.entrySet()) {
    		String key = mapElement.getKey();
    		String value = mapElement.getValue();
    		if (map2.containsKey(key)) {
        		if (map2.get(key).equals(value)) {
        			num++;
        		}
    		}
    	}
    	return num;
    }
}


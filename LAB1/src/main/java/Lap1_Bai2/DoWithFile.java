/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author PC
 */
public class DoWithFile {
    HashMap<String, Integer> data;
    public DoWithFile(){
        data = new HashMap<>();
    }
    
    public void tagValue(String tag){
        if(!data.containsKey(tag)){
            data.put(tag, 1);
        } else{
            data.put(tag, data.get(tag) + 1);
        }
    }
    /**
     * Hàm dùng để nhận đầu vào là thẻ và đặt nó vào hashMap
     * @param tag
     */
    
    public void output(String csvFile) throws IOException {
	FileWriter fw = null;
	try {
	    fw = new FileWriter(csvFile);
	    //sort the map in descending order
	    Map<String, Integer> result = data.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		    .collect(Collectors.toMap(
			    Map.Entry::getKey,
			    Map.Entry::getValue,
			    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
	    fw.append("Tag, Frequency\n");
	    for (Map.Entry<String, Integer> entry : result.entrySet()) {
		String line = String.format("%s, %d\n", entry.getKey(), entry.getValue());
		fw.append(line);
	    }
	} catch (IOException e) {
	    System.out.println("Can't write to file now!!");
	} finally {
	    if (fw != null) {
		fw.close();
	    }
	}
    }
    /**
     * Hàm dùng để ghi map vào file
     * @param csvFile
     * @throws IOException
     */
}
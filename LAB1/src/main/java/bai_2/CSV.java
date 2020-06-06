/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Linh
 */
public class CSV {
    //Map stores data as key and value pairs
    //Keys are HTML tags
    //Value is frequency appearance of this tag
    Map<String, Integer> csv; 

    public CSV() {
        csv = new HashMap<>(); //Create hashmap
    }
    
    /**
     * Counting frequence appearance of the HTML tag
     * @param tag 
     */
    public void countingFrequenceAppearance(String tag) {
  
        if(csv.containsKey(tag) == false) {
            csv.put(tag, 1);
        }
        else {
            csv.put(tag, csv.get(tag) + 1);
        }
    }
    
    //Print to screen for testing
    public void print() {
        
        System.out.println("Before sorting by frequence:");
        for (Map.Entry<String, Integer> entry : csv.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("tag: " + key + " - frequences: " + value);
        }
    }
    
    public void sortAndWriteToFile(String fileName) throws FileNotFoundException {
        
        //This will sort by value in descending order
        Map<String, Integer> sortedByFrequences = csv.entrySet().stream()
            .sorted((Map.Entry.<String, Integer> comparingByValue().reversed()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        //Print out the map after sorting
        System.out.println("\nAfter sorting by frequence:");
        for (Map.Entry<String, Integer> entry : sortedByFrequences.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("tag: " + key + " - frequences: " + value);
        }
        
        //Write result to file with format "tagName,Frequences"
        File f = new File(fileName);
        PrintWriter pw = new PrintWriter(f);
        pw.println("Tag,Frequences\n");
        for (Map.Entry<String, Integer> entry : sortedByFrequences.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                pw.println(key + "," + value); 
        }
        
        pw.close();
    }
}

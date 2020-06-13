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
 * @author Dell
 */
public class SortandWritetoFile {
   Map<String, Integer> map= new HashMap<>();    
    /**
     * This method is used to count the number of tags
     * Input data is tag
     * Output data is list of tag has been counted
     * @param tag 
     */
    public void countTag(String tag) {
  
        if(map.containsKey(tag) == false) {
            map.put(tag, 1);
        }
       else {
            map.put(tag, map.get(tag) + 1);
        }
    }
    /**
     * This method below here is used to sort and write the data has been search to file csv. Then store at linkedHashmap
     * Input data is fileName
     * Output is a list of tag 
     * @param fileName
     * @throws FileNotFoundException 
     */
     public void sortAndWriteToFile(String fileName) throws FileNotFoundException {
        
       try{
           Map<String, Integer> sortedByFrequences = map.entrySet().stream()
            .sorted((Map.Entry.<String, Integer> comparingByValue().reversed()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        
        //Print out the map after sorting
        System.out.println("\nList tag:");
        for (Map.Entry<String, Integer> entry : sortedByFrequences.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Tag:" + key +"\t\t"+ " Count: " + value);
        }
        File f = new File(fileName);  //Write the file
        PrintWriter pw = new PrintWriter(f);
        pw.println("Tag,Count\n");
        for (Map.Entry<String, Integer> entry : sortedTag.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                pw.println(key + "," + value); 
        }
        pw.close();
       }
        catch(Exception e){
                e.printStackTrace();
                }
        
}
}

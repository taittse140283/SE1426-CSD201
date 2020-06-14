/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Thuan Le
 */
public class WrieToFile {
    /**
     * Sort and write to file
     * @param hashMap
     * @param fileName
     * @throws FileNotFoundException 
     */
    public void writeToFile(HashMap<String, Integer> hashMap, String fileName)throws FileNotFoundException{
        Map<String, Integer> sort = hashMap.entrySet().stream()
                .sorted((Map.Entry.<String, Integer> comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("After sorted");
        
        for(Map.Entry<String, Integer> entry : sort.entrySet()){
            String key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println("Tag: " + key + " Frequency: " + val);
        }
        
        File f = new File(fileName);
        PrintWriter pw = new PrintWriter(f);
        pw.println("Tag, Frequency\n");
        
        for (Map.Entry<String, Integer> entry: sort.entrySet()) {
            String key = entry.getKey();
            Integer val = entry.getValue();
            pw.println(key + ", " + val);
        }
        pw.close();
    }
}

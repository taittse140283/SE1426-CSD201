/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountTagHTML;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Loi Lam
 */
public class FileCSV {

    Map<String, Integer> csv;

    public FileCSV() {
        csv = new HashMap<>();
    }

    //count tag appear
    //param tag
    public void countTag(String tag) {
        if (csv.containsKey(tag) == false) {
            csv.put(tag, 1);
        } else {
            csv.put(tag, csv.get(tag) + 1);
        }
    }

    //print out tag and frequency
    public void print() {
        for (Map.Entry<String, Integer> entry : csv.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
//            System.out.println("Tag: " + key + " - Frequences: " + value);
        }
    }

    //sort output
    public void sortAndPrint(String fileName) throws FileNotFoundException{
        Map<String, Integer> sortFre = csv.entrySet().stream()
                .sorted((Map.Entry.<String, Integer> comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap:: new));
        
        //print out after sort
        System.out.println("Sorting done.");
        for(Map.Entry<String, Integer> entry : sortFre.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();
//            System.out.println("Tag: " + key + " - frequence: " + value);
        }
        
        //write result to output.csv
        File f = new File(fileName);
        PrintWriter pw = new PrintWriter(f);
        pw.println("Tag, Frequence\n");
        for (Map.Entry<String, Integer> entry : sortFre.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            pw.println(key + ", " + value);
        }
        pw.close();
    }
}

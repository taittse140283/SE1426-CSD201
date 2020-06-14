/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author hiep
 */
public class WriteFile {

    public void WriteFile(HashMap<String, Integer> hs, String fileName) throws FileNotFoundException {
        Map<String, Integer> sort = hs.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("After sort by value:");
        for (Map.Entry<String, Integer> entry : sort.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Tag:" + key + "Value:" + value);
        }
        File f = new File(fileName);
        PrintWriter pw = new PrintWriter(f);
        pw.println("Tag,Value\n");
        for (Map.Entry<String, Integer> entry : sort.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            pw.println(key + "," + value);
        }
        pw.close();
    }
}

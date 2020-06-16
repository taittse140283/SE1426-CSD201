/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author ZunPeter
 */
public class CreateFile {
   public void CreateFile(HashMap<String, Integer> hashmap,String fileName)throws FileNotFoundException{
      Map<String, Integer> sort = hashmap.entrySet().stream().sorted((Map.Entry.<String, Integer> comparingByValue().reversed()))
          .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
       System.out.println("\n After sort :");
       for (Map.Entry<String, Integer> entry : sort.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Tag: " + key + " Value: " + value);
        }
       File f = new File(fileName);
       PrintWriter print = new PrintWriter(f);
       print.println("\n Tag,Value ");
       for (Map.Entry<String, Integer> entry : sort.entrySet()) {
           String key = entry.getKey();
           Integer value = entry.getValue();
           print.println(key +" "+ value);
       }
       print.close();
   } 
}

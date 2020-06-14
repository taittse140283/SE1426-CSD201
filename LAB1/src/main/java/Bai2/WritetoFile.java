/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Asus
 */
public class WritetoFile {
   Map<String, Integer> map= new HashMap<>();    
    public void countTag(String tag) {
  
        if(map.containsKey(tag) == false) {
            map.put(tag, 1);
        }
       else {
            map.put(tag, map.get(tag) + 1);
        }
    }
    public void WriteToFile(String fileName) throws FileNotFoundException {
    }           
}


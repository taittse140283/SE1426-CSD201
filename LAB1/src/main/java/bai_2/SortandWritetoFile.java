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
}
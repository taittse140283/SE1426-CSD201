/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

import java.util.HashMap;
import java.util.Map;

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
        //If csv
        if(csv.containsKey(tag) == false) {
            csv.put(tag, 1);
        }
        else {
            csv.put(tag, csv.get(tag) + 1);
        }
    }
}

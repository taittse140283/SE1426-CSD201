/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountTagHTML;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Loi Lam
 */
public class FileCSV {

    Map<String, Integer> csv;

    public FileCSV(){
    csv = new HashMap<>();
    }
    
    //count tag appear
    //param tag
    public void countTag(String tag){
        if(csv.containsKey(tag) == false){
            csv.put(tag, 1);
        }
        else {
            csv.put(tag, csv.get(tag) + 1);
        }
    }
}

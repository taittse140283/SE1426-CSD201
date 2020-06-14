/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

import java.util.HashMap;

/**
 *
 * @author hiep
 */
public class Manager {

    HashMap<String, Integer> hs = new HashMap<>();
    Stack s = new Stack();
    getURL get = new getURL();
    WriteFile w = new WriteFile();

    public void count(String tag) {
        if (hs.containsKey(tag) == false) {
            hs.put(tag, 1);
        } else {
            hs.put(tag, hs.get(tag)+1);
        }
    }


}

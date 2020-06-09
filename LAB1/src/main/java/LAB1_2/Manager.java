/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

import java.util.HashMap;

/**
 *
 * @author TAN
 */
public class Manager {
    HashMap<String,Integer> hashmap = new HashMap<>(); //tao hashmap
    Stack stack = new Stack();
    // kiem tra tagHTML
    public void analyzeTag(String s){
        String tag="";
        boolean check = false;
        // chay vong lap cho chuoi
        for(int i = 0;i < s.length(); i++){
            // kiem tra cho phai the HTML hay khong
            if(s.charAt(i) == '<'){
                tag = "<";
                check = true;
            }
            // kiem tra co phai the comment 
            else if(check = true && s.charAt(i) == '-'){
                tag = tag + "-";
                check = false;
            }
            // bo qua noi dung trong the HTML
            else if(check = true && s.charAt(i) != '>'){
                tag = tag + s.charAt(i);
            }
            // kiem tra cac the con lai
            else if(check == true && s.charAt(i) == '>'){
                tag = tag + ">";
                check = false;
            }
        }
    }
    // dem cac tag trong the HTML
    public void count(String tag){
         if(hashmap.containsKey(tag) == false) {
            hashmap.put(tag, 1);
        }
        else {
            hashmap.put(tag, hashmap.get(tag) + 1);
        }
    }
    public void processTag(String tag){
        if(tag.contains("</") == false) {
            stack.push(tag);
            stack.print(); 
            System.out.println();
        }
        else if(stack.Top().equalsIgnoreCase(tag.replace("/", "")) == true) {
            stack.pop(); 
            count(tag);
            stack.print();
            System.out.println();
        }
    }
}

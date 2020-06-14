/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class Manager {
     HashMap<String,Integer> hashmap = new HashMap<>(); 
    Stack stack = new Stack();
    GetURl get = new GetURl();
    
    
    /**this method will check co phai cac loai tagHTML? base on character "<", ">" "-"
     * @param is the content of URL
     */
    public void analyzeTag(String content){
        String tag="";
        boolean check = false;
        
        for(int i = 0;i < content.length(); i++){
            // check the charater is a tag or not base on '<' mo dau cho moi tag
            if(content.charAt(i) == '<'){
                tag = "<";
                check = true; //(*)
            }
            // check the tag comment base on the tag have checked before (*)and the character (-)
            else if(content.charAt(i) == '-' && check == true) {
                tag = tag + "-";
                processTag(tag);
                check = false;
            }
            // ignore the content of tag
            else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true) {
                tag = tag + content.charAt(i);
            }
            //check the special tag
            else if(((content.charAt(i) == '>') || (content.charAt(i) == ' ')) && check == true) {
                tag = tag + ">";
                check = false;
                processTag(tag);
            }
        }
    }
    /** this method will count how many the tag appear in the HTML
     * @param tag of HTML. 
     */
    public void count(String tag){
         if(hashmap.containsKey(tag) == false) {
            hashmap.put(tag, 1);
        }
        else {
            hashmap.put(tag, hashmap.get(tag) + 1);
        }
    }
}

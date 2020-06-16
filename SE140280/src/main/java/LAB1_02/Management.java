/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_02;

import java.util.HashMap;

/**
 *
 * @author ZunPeter
 */
public class Management {
   HashMap<String, Integer> hashmap = new HashMap<>();
   GetURL get = new GetURL();
   Stack stack = new Stack();
   CreateFile cre = new CreateFile();
   
   /** Check all tags in the HTML base on  '<','>' 
    * @param content  
    */
   public void readTag(String content){
       String tag = " ";
       boolean check = false;
        for(int i = 0;i < content.length(); i++){
            if(content.charAt(i) == '<'){
                tag = "<";
                check = true; //(*)
            }else if(content.charAt(i) == '-' && check == true) {
                tag = tag + "-";
                
                check = false;
            }else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true) {
                tag = tag + content.charAt(i);
            }else if(((content.charAt(i) == '>') || (content.charAt(i) == ' ')) && check == true) {
                tag = tag + ">";
                check = false;
                
            }
        }
    }
   public void count(String tag){
       if(hashmap.containsKey(tag) == false) {
            hashmap.put(tag, 1);
        }
        else {
            hashmap.put(tag, hashmap.get(tag) + 1);
        }
   }
   
   public void Manager(String url , String fileName){
        String content;
        try {
            content = get.readContent(url);
            readTag(content);
            cre.CreateFile(hashmap,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

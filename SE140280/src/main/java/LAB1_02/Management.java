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
   
   public void processTag(String tag) {
        
        if (tag.equalsIgnoreCase("<area>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<!DOCTYPE>")) {
            count(tag); 
        } else if (tag.equalsIgnoreCase("<input>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<link>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<base>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<br>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<command>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<track>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<wbr>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<embeb>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<hr>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<!-")) {
            count("<!--comment-->");
        } else if (tag.equalsIgnoreCase("<img>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<meta>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<param>")) {
            count(tag);
        } else {
            
            if (tag.contains("</") == false) {
                stack.push(tag);   
                count(tag);
                stack.print();
                System.out.println();
            } 
            else if (stack.top().equalsIgnoreCase(tag.replace("/", "")) == true) {
                stack.pop();
                stack.print();
                System.out.println();
            }
        }
}
   
   /** Check all tags in the HTML base on  '<','>' and '-'
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

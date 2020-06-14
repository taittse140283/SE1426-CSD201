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
    WriteFile wr = new WriteFile();
    
    
    /**this method will check  tagHTML? base on character "<", ">" "-"
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
    
    /**this method to check kind of special tag exactly for each case 
     * @param the tag will check
     */
    public void processTag(String tag) {
        // check special tag 
        if (tag.equalsIgnoreCase("<area>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<base>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<br>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<command>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<!DOCTYPE>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<!-")) {
            count("<!--comment-->");
        } else if (tag.equalsIgnoreCase("<embeb>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<hr>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<img>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<input>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<link>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<meta>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<param>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<track>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<wbr>")) {
            count(tag);
        } else {
            
            if (tag.contains("</") == false) {
                stack.push(tag);   
                count(tag);
                stack.print();
                System.out.println();
            } 
            else if (stack.Top().equalsIgnoreCase(tag.replace("/", "")) == true) {
                stack.pop();
                stack.print();
                System.out.println();
            }
        }
}
    /**
     * this method will do the job instead of main(like read content url,check tag, then write tag to file)
     * @param a url of the web want do check
     * @param a file name want to write to
     */
    public void Manager(String url , String fileName){
        String content;
        try {
            content = get.readContent(url);
            analyzeTag(content);
            wr.WriteFile(hashmap,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

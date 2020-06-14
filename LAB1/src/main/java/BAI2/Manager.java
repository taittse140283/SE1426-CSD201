/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
/**
 *
 * @author Thuan Le
 */
public class Manager {  
    HashMap<String, Integer> hashMap = new HashMap<>();
    Stack stack = new Stack();
    ReadURL read = new ReadURL();
    WrieToFile wr = new WrieToFile();
    
    
    
    /**
     * Count tags in the html
     */
    
    public void countTag(String tag){
        if(hashMap.containsKey(tag) == false){
            hashMap.put(tag, 1);
        } else{
            hashMap.put(tag, hashMap.get(tag) + 1);
        }
    }
    
    /**
     * After check tags of html then add all tags were chosen 
     * @param tag 
     */
    public void addTag(String tag){
//        if(tag.equalsIgnoreCase("<area>") || tag.equalsIgnoreCase("<base>") || tag.equalsIgnoreCase("<br>")
//            || tag.equalsIgnoreCase("<strong>") || tag.equalsIgnoreCase("<!DOCTYPE>") || tag.equalsIgnoreCase("<embed>")
//            || tag.equalsIgnoreCase("<hr>") || tag.equalsIgnoreCase("<img>") || tag.equalsIgnoreCase("<input>")
//            || tag.equalsIgnoreCase("<link>") || tag.equalsIgnoreCase("<meta>") || tag.equalsIgnoreCase("<param>")
//            || tag.equalsIgnoreCase("<track>") || tag.equalsIgnoreCase("<wbr>") || tag.equalsIgnoreCase("<col>")
//            || tag.equalsIgnoreCase("<command>") || tag.equalsIgnoreCase("<keygen>") || tag.equalsIgnoreCase("<source>")
//            || tag.equalsIgnoreCase("<pre>") || tag.equalsIgnoreCase("<em>") || tag.equalsIgnoreCase("<small>") 
//            || tag.equalsIgnoreCase("<ins>") || tag.equalsIgnoreCase("<sub>") ) {
//            countTag(tag);
//        }
        if(tag.equalsIgnoreCase("<area>")){
            countTag(tag);
        } else if(tag.equalsIgnoreCase("<section>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<br>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<strong>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<!DOCTYPE>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<embed>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<hr>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<img>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<input>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<link>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<meta>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<param>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<svg>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<div>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<span>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<command>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<use>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<source>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<video>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<audio>")) {
            countTag(tag);
        }else if(tag.equalsIgnoreCase("<script>")) {
            countTag(tag);
        }
        
        else{
            if(tag.contains("</") == false){
                stack.push(tag);
                System.out.print("\n");
            } else if(stack.getTop().equalsIgnoreCase(tag.replace("/", "")) == true){
                stack.pop();
                countTag(tag.replace("/", ""));
                System.out.print("\n");
            }
        }
            
    }
    /**
     * Check and selective tags in html
     * @param content 
     */
    public void analyzeTagHTML(String content){
        String tag ="";
        boolean check = false;
        
        for (int i = 0; i < content.length(); i++) {
            if(content.charAt(i) == '<'){
                tag ="<";
                check = true;
            } 
            else if(content.charAt(i) == '-' && check ==  true){
                tag += "-";
                check = false;
            }else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true){
                tag += content.charAt(i);
            }else if(((content.charAt(i) == '>' || content.charAt(i) ==' ' )) && check == true){
                tag += ">";
                check = false;
                addTag(tag);
            }
        }
    }
    
    public void runLab2(String url, String fileName){
        
        try {
            String content = null;
            content = read.readHTML(url);
            analyzeTagHTML(content);
            wr.writeToFile(hashMap, fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

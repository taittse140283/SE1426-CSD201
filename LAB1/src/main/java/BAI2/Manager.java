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
    /**
     * Input a URL then read line by line
     * Output its contents
     * @param urlString
     * @return
     * @throws Exception 
     */
    public static String readHTML(String urlString) throws Exception{
        String content = "";        
        BufferedReader br = null;
        
        try {
            URL url = new URL(urlString);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;          
            while((line = br.readLine()) != null){
                content += line + "\n";
            }
            
        } catch (IOException e){
            e.printStackTrace();
        }finally {
            try {                
                if(br != null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }
    /**
     * Sort and write to file
     * @param hashMap
     * @param fileName
     * @throws FileNotFoundException 
     */
    public static void writeToFile(HashMap<String, Integer> hashMap, String fileName) throws FileNotFoundException{
        Map<String, Integer> sort = hashMap.entrySet().stream()
                .sorted((Map.Entry.<String, Integer> comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("\n After sorted: ");
        
        for(Map.Entry<String, Integer> entry : sort.entrySet()){
            String key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println("Tag: " + key + " value: " + val);
        }
        
        File f = new File(fileName);
        PrintWriter pw = new PrintWriter(f);
        pw.println("Tag-Value\n");
        for(Map.Entry<String, Integer> entry : sort.entrySet()){
            String key = entry.getKey();
            Integer val = entry.getValue();
            pw.println(key + ", " + val );
        }
        pw.close();
    }
    
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
        if(tag.equalsIgnoreCase("<area>") || tag.equalsIgnoreCase("<base>") || tag.equalsIgnoreCase("<br>")
            || tag.equalsIgnoreCase("<strong>") || tag.equalsIgnoreCase("<!DOCTYPE>") || tag.equalsIgnoreCase("<embed>")
            || tag.equalsIgnoreCase("<hr>") || tag.equalsIgnoreCase("<img>") || tag.equalsIgnoreCase("<input>")
            || tag.equalsIgnoreCase("<link>") || tag.equalsIgnoreCase("<meta>") || tag.equalsIgnoreCase("<param>")
            || tag.equalsIgnoreCase("<track>") || tag.equalsIgnoreCase("<wbr>") || tag.equalsIgnoreCase("<col>")
            || tag.equalsIgnoreCase("<command>") || tag.equalsIgnoreCase("<keygen>") || tag.equalsIgnoreCase("<source>")
            || tag.equalsIgnoreCase("<script>") || tag.equalsIgnoreCase("<pre>") || tag.equalsIgnoreCase("<em>")
            || tag.equalsIgnoreCase("<small>") || tag.equalsIgnoreCase("<ins>") || tag.equalsIgnoreCase("<sub>") ) {
            countTag(tag);
        }
        else{
            if(tag.contains("</") == false){
                stack.push(tag);
                countTag(tag);
                stack.print();
                System.out.print("\n");
            } else if(stack.getTop().equalsIgnoreCase(tag.replace("/", "")) == true){
                stack.pop();
                stack.print();
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
                addTag(tag);
                check = false;
            }else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true){
                tag += content.charAt(i);
            }else if((content.charAt(i) == '>' || content.charAt(i) ==' ' ) && check == true){
                tag += ">";
                check = false;
                addTag(tag);
            }
        }
    }
}

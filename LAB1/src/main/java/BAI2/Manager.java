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
}

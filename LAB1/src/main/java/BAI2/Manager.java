/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;


/**
 *
 * @author ZunPeter
 */
public class GetURL {
    /**
    * Read input and read its content
    * @param urlString
    * 
    */
    String content="";
    String n;
    
    public String readContent(String urlString) throws Exception{
        URL url = new URL(urlString);
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
        while ((n = bf.readLine())!= null) {
           content += n + "\n";
            
        }
        bf.close();
        return content;
        }
    public void printout(){
        System.out.println(content);
        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Admin
 */
import java.io.BufferedReader;
import java.io.FileReader;

import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
public class GetURl {
    String content="";
    String line;
    /** Clone the content of the website with using URL*/
   private String readContent(String urlString) throws Exception{
        
        URL url = new URL(urlString);
        BufferedReader br= new BufferedReader(new InputStreamReader(url.openStream()));
        
        while ((line= br.readLine()) !=null){ // read the text in to there are no line
            content += line +"\n";            // after every one loop, the String have been added, it look like a file text.
        }
        br.close();
        return content;
        
        
    }
   /** print the content to the display */
    public void print(){
        System.out.println(content);
    }
}


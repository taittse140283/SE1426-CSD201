/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Get a content from the website
 * @author Linh
 */
public class GetContentFromWebsite {
    public String readContent(String urlWeb) throws Exception{
        String content = "";
        String line;
        int n = 0;
        
        //Create an URL object with string urlWeb
        URL url = new URL(urlWeb); 
        
        //Open a connection to this URL and return an InputStream for reading the content from that connection
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        
        //Read a content from the url line by line and insert this content to "content" variable
        while((line = br.readLine()) != null) {
            content += line + "\n";
        }
        br.close();
        return content;
    }
}

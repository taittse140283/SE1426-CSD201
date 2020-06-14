/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountTagHTML;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Loi Lam
 */
public class ReadLine {
    
    //
    public String readLine(String urlWeb) throws MalformedURLException, IOException{
        String content = "";
        String line;
        int n =  0;
        
        //create URL with string web
        URL url = new URL(urlWeb);
        
        //read content in each line from after open a connection to this URL
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
    
        //read content from each line
        while((line = br.readLine()) != null){
            content += line + "\n";
        }
        br.close();
        return content;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;

/**
 *
 * @author Dell
 */
/**
* This is constructor. It will be read content from the page on website. 
* Below constructor is method readContent. This method is use to read the content
*Input data of method is urlString
*Output data is content
*/
public class webContent {
   static String readContent(String urlString) throws Exception{
        BufferedReader br=null;
        String content="";
        try{
            
            URL url= new URL(urlString);
            br= new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while((line=br.readLine())!= null){
                content += line +"\n";
            }
            br.close();
           
        } catch(Exception e){
            System.out.println("Error");
        } finally{
            try{
                if(br!=null){
                    br.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return content;
    }
}

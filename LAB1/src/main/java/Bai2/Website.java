/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Asus
 */
public class Website {
    String content="";
    String line;
    public String readContent(String urlWeb) throws Exception{
        BufferedReader br=null;
        try{
            URL url= new URL(urlWeb);
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




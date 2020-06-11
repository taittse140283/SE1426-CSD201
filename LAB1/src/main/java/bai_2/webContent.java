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
public class webContent {
    private static String readContent(String urlString) throws Exception{
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
    public static boolean countTag(String content){
        Stack<String> buffer= new ArrayStack<>();
        int j=content.indexOf('<'); //tìm kí tư '<' dau tien
        while(j!=-1){
            int k=content.indexOf('>', j+1); //tim ki tu '>' tiep theo
            if(k==-1){
                System.out.println("Error! Invalid tag");
            }
            String tag= content.substring(j+1,k);
            if(!tag.startsWith("/")){
                buffer.push(tag);
            }
            else{
                if(buffer.isEmpty()){
                    return false;
                }
                if(!tag.substring(1).equals(buffer.pop())){
                    return false;
                }
            }
            j=content.indexOf('<',k+1);
            
        }
      return buffer.isEmpty();
    }
}

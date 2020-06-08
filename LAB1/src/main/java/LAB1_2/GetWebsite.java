/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author TAN
 */
public class GetWebsite {
    String content="";
    String S;
    // lay URL trang web
    public String readContent(String urlWeb) throws Exception{
        URL url = new URL(urlWeb); 
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
        while(( S = bf.readLine() ) != null){ 
        content += S+ "\n";
        }
        bf.close();
        return content;
    }
    // demo in ra URL webside
    public void print(){
        System.out.print("" + content);
    }
    
}

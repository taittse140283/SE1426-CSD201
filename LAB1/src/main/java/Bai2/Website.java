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
    String S;
    public String readContent(String urlWeb) throws Exception{
        URL url = new URL(urlWeb); 
        BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
        while(( S = bf.readLine() ) != null){ 
        content += S+ "\n";
        }
        bf.close();
        return content;
    }
}


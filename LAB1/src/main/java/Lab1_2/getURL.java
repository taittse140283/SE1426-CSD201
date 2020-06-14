/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author hiep
 */
public class getURL {
    String content;
    String s;
    //l
    private String readContent(String urlString)throws Exception{
        URL url=new URL(urlString);
        BufferedReader bf=new BufferedReader(new InputStreamReader(url.openStream()));
        while((s=bf.readLine())!=null){
            content+=s+"\n";
        }
        bf.close();
        return content;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 *
 * @author PC
 */
public class WedHTML {
    HashMap<String, Integer> htmlTag = new HashMap<>();
    
    public static String readWed(String fileData){
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            fr = new FileReader(fileData);
            br = new BufferedReader(fr);
            sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
        } catch (Exception e) {
            System.err.println("File not founded!!!");
        } finally{
            try {
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    /**
     * 
     */
}

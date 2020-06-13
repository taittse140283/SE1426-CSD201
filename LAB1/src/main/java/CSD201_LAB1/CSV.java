/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 *
 * @author truong
 */
public class CSV {
    /**
     * Read data from CSV
     *
     * @ read data from user.csv
     * check EOF
     * @fileReader
     * @BufferedReader
     */
public static String readFile(String csvFileName){
    FileReader fr=null;
    BufferedReader br=null;
    String s="";
    try {
        fr=new FileReader(csvFileName);
        br=new BufferedReader(fr);
        while(fr.ready()){
            s=s+br.readLine();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        try {
            if(fr!=null)
                fr.close();
            if(br!=null)
                br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return s;
}
/**
 * Write file 
 * @printWrite
 */
public static void writeFile(String outputCSVFile,String s){
    PrintWriter w=null;
    if(s.isEmpty())//check string if string equal"" return
        return;
    try {
        w=new PrintWriter("D:\\CSD\\SE1426-CSD201\\LAB1\\ouputCSV");
        w.println(s);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

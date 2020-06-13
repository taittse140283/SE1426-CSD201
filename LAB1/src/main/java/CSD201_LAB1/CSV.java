/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import org.w3c.dom.Node;

/**
 *
 * @author truong
 */
public class CSV {
    
    /**
     * Read data from CSV
     * check EOF
     * @param csvFileName
     * @return 
     */
public static String readFile(String csvFileName){
    FileReader f=null;
    BufferedReader r=null;
    String s="";
    try {
         f=new FileReader(csvFileName);
         r=new BufferedReader(f);
        while(r.ready()){
            try {
                s=r.readLine();
                String []arr=s.split(",");
                String email=arr[0];
                String point=arr[1];
                
                
            } catch (Exception e) {
            }
            
        }
    } catch (Exception e) {
        e.printStackTrace();
    }finally{
        try {
            if(f!=null)
            f.close();
            if(r!=null)
                r.close();
        } catch (Exception e) {
        }
    }
    return s;
}
/**
 * write file
 * @param outputCSVFile
 * @param s 
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

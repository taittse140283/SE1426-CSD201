/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author truong
 */
public class CSVagain {
    
    public static void readFile(PriorityQueue queue,String csvPath)throws IOException{
        BufferedReader br=null;
        String line="";
        try {
            br=new BufferedReader(new FileReader(csvPath));
            while((line=br.readLine())!=null){
                try {
                    String[]rowData=line.split(",");
                    String email=rowData[0];
                    String uonparsedPoint=rowData[1];
                    queue.add(email, 0);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            br.close();
        }
    }
    public static void WritequeueInToCSV(PriorityQueue queue,String path)throws IOException{
        queue.exportCSV(path);
    }
    
}

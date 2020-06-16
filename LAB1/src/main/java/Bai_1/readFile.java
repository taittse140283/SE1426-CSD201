/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Dell
 */
public class readFile {
    /**
     * This method below here is used to read each line from file
     Input data is file
     * @param file
     * @return 
     */
    public static PriorityQueue readFromFile(String file) {
    
        FileReader fr = null;
        BufferedReader br = null;
        PriorityQueue queue = new PriorityQueue();
        try {
       
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while ((s=br.readLine())!=null) {
                StringTokenizer stk = new StringTokenizer(s, ", ");
                String email=stk.nextToken();
                long point = Long.parseLong(stk.nextToken());
                Infor player = new Infor(email, point);
                queue.add(player);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return queue;
    }
    /**
     * This method below here is used to write data to file
     * Input data is queue and file
     * @param queue
     * @param file
     * @throws IOException 
     */
    public void writeToFile(PriorityQueue queue, String file) throws IOException {
        File f=null;
        FileWriter fw=null;
        PrintWriter pw= null;
            try{
                f= new File(file);
                fw= new FileWriter(f);
                pw= new PrintWriter(fw);
                pw.println("Email,Point");
                DoublyLinkedList.Node<Infor> step= queue.getList().getHeader();
                do{
                    pw.println(step.getElement().toString());
                    step= step.getNext();
                } while (step!=null);
            } catch (Exception e){
                e.printStackTrace();
            } finally{
                try{
                    if(pw!=null){
                    pw.close();
                    }
                    if(fw!=null){
                    fw.close();
                    }
               } catch(Exception e){
                    e.printStackTrace();
            }
}
    }
    

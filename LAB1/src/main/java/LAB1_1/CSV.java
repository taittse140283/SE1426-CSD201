/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class CSV {
    
    public static PriorityQueue readFile (String fileName) throws IOException{
        FileReader fr = null;
        BufferedReader br = null;
        PriorityQueue queue = new PriorityQueue();
        try {
            fr = new FileReader(fileName);
            br=new BufferedReader(fr);
            String s = br.readLine();
            while (br.ready()) {
                s = br.readLine();
                StringTokenizer stk = new StringTokenizer(s, ", ");
                String email = stk.nextToken();
                int point = Integer.parseInt(stk.nextToken());
                
                Player player = new Player(email, point);
                queue.addPlayer(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close();
            }
            if(fr !=null){
                fr.close();
            }
        }
        return queue;
    }
    
    public static void saveFile(PriorityQueue queue, String fileName) throws IOException{
        File f =null;
        FileWriter fw =null;
        PrintWriter pw = null;
        try {
            f= new File(fileName);
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if (pw != null){
                pw.close();
            }
            if(fw != null){
                fw.close();
            }
        }
    }
}

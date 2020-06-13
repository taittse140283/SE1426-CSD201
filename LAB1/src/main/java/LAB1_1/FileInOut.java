/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;
import java.io.*;
/**
 *
 * @author TAN
 */
public class FileInOut {
    PriorityQueue queue = new PriorityQueue();
    public void getFile(String fileName){
        FileReader fr=null;
        BufferedReader br=null;
        String line = "";
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr); 
            while((line = br.readLine()) != null) { 
                if(line.contains("Email")) 
                    continue;
            String[] info = line.split(", "); 
                Player p = new Player();
                p.setEmail(info[0]);
                p.setPoint(Integer.parseInt(info[1]));
                Node<Player> node =new Node();
                node.setInfo(p);
                queue.add(node);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

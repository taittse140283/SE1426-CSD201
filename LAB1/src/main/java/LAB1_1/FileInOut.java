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
     public static PriorityQueue getFile(String fileName){
        PriorityQueue queue = new PriorityQueue();
        FileReader fr=null;
        BufferedReader br=null;
         try {
            fr=new FileReader(fileName);
            br=new BufferedReader(fr);
            String s ;
            s = br.readLine();
            while(br.ready())
            {
                s=br.readLine();
                String[] arr=s.split(", ");
                if(arr.length==2){
                    Player player=new Player();
                    player.setEmail(arr[0]);
                    player.setPoint(Integer.parseInt(arr[1]));
                    Node<Player> newNode=new Node();
                    newNode.setInfo(player);
                    queue.add(newNode);
                }
            }
        br.close();
        fr.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
        return queue;

    }
    public static void writeFile(String fileName , PriorityQueue queue) {
        File f = null;
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            f = new File(fileName);
            fw = new FileWriter(f);
            pw = new PrintWriter(fw);
            pw.println("Email, point");
            Node<Player> cur = queue.getList().getHead();
            while (cur.getNext() != null){
            pw.println(cur.getInfo().toString());
            cur = cur.getNext();
            }
        fw.close();
        pw.close();
        } catch (Exception e) {
                e.printStackTrace();
        }
    }  
}

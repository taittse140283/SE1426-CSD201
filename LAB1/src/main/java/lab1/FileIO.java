/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */
import java.io.*;
public class FileIO {
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
                    Entry entry=new Entry();
                    entry.setEmail(arr[0]);
                    entry.setPoint(Integer.parseInt(arr[1]));
                    Node<Entry> newNode=new Node();
                    newNode.setElement(entry);
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
}

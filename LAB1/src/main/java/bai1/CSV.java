/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Admin
 */
public class CSV {
    public static SortedPriorityQueue readFile(String csvFilename)
    {
        SortedPriorityQueue queue = new SortedPriorityQueue();
        FileReader fr=null;
        BufferedReader br=null;
        try {
            fr=new FileReader(csvFilename);
            br=new BufferedReader(fr);
            String s=br.readLine();//First line is Email, Point-->pass this line
            while(br.ready())//check EOF
            {
                s=br.readLine();
                String[] arr=s.split(", ");
                if(arr.length==2){
                Player player=new Player();//create new player
                player.setEmail(arr[0]);
                player.setPoint(Integer.parseInt(arr[1]));
                DLLNode<Player> newNode=new DLLNode();//create node to add into list
                newNode.setInfo(player);
                queue.add(newNode);
                }
                else throw new Exception("Not compatible");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                if(br!=null) br.close();
                if(fr!=null) fr.close();
            } catch (Exception e) {
            }
        }
        return queue;
    }
    
}

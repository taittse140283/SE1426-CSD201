/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class CSV {
    /**
     * Read data from file csv
     * @param csvFilename
     * @return sorted list of Player
     */
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
    /**
     * Write data into csv file
     * @param csvFileName
     * @param queue 
     */
    public static void writeFile(String csvFileName, SortedPriorityQueue queue)
    {
        File f=new File(csvFileName);//create new file
        PrintWriter pw=null;
        try {
            pw=new PrintWriter(f);
            pw.println("Email, Point");
            DLLNode<Player> temp=queue.getList().getHeader();//get the header of the list
            while(temp!=null)//traverse the list
            {
                pw.println(temp.getInfo().toString());//write into file
                temp=temp.getNext();//go to next node
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                if(pw!=null) pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Linh
 */
public class Program {
    SortedPriorityQueue s;
    ArrayList<Player> list;

    public Program() {
        s = new SortedPriorityQueue();
        list = new ArrayList<>();
    }
    
    /**
     * Read file and add players into the queue and sort them into the suitable position
     * @param fileName 
     */
    public void GetPlayerFromFile(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        String line = "";
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while((line = br.readLine()) != null) { //read file line-by-line
                if(line.contains("Email")) //Ignore the header line
                    continue;
                String[] info = line.split(", "); 
                String email = info[0];
                int point = Integer.parseInt(info[1]);
                s.addNewPlayer(email, point); //Add a player into the queue
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Not found the input file");
        }
        s.print(); //Print to the screen for tesing 
    }
    
    /**
     * Print all players to file
     * @param fileName 
     */
    public void printToFile(String fileName) {
        File f;
        PrintWriter pw;
        try {
            f = new File(fileName);
            pw = new PrintWriter(f);
            s.addToList(list);
            pw.println("Email, Point");
            for(int i = 0; i < list.size(); i++)
                pw.println(list.get(i).getEmail() + ", " + list.get(i).getPoint());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

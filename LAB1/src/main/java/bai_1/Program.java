/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author Linh
 */
public class Program {
    SortedPriorityQueue s;

    public Program() {
        s = new SortedPriorityQueue();
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
        } catch (Exception e) {
            System.out.println("Not found the input file");
        }
        s.print(); //Print to the screen for tesing 
    }
}

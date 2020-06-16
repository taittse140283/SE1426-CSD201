/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class CSV {
    
    public static PriorityQueue readFile(String fileName){
        PriorityQueue queue = new PriorityQueue();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while (true) {                
                String [] arr;
                do {                        
                    if(!br.ready()){// check EOF
                        return null;
                    }
                    String s =br.readLine();
                    arr = s.split(", ");
                } while (arr[0].equalsIgnoreCase("Email") && arr[1].equalsIgnoreCase("Point"));
                Player data = new Player(arr[0], Long.parseLong(arr[1]));
                queue.insert(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not founded!");
        } catch (IOException e) {
            System.out.println("Error: An error occurred while reading the file!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(br == null)
                    br.close();
                if(fr == null)
                    fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return queue;
    }
}

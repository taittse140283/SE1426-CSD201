/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

import LAB1_1.DoublyLinkedList.Node;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
    
    public static void writeFile(PriorityQueue queue, String fileName) {
        if (queue.isEmpty()) {
            System.out.println("Error: Queue empty!");
        } else {
            File f = null;
            FileWriter fw = null;
            PrintWriter pw = null;
            try {
                f = new File(fileName);
                fw = new FileWriter(f);
                pw = new PrintWriter(fw);
                pw.println("Email, point");
                DoublyLinkedList.Node<Player> current = queue.
                while (current.getNext() != null) {
                    pw.println(current.getElement().toString());
                    current = current.getNext();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (pw != null) {
                        pw.close();
                    }
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

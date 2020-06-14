/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class FileCSV {

    public static PriorityQueue readFile(String fileName) {
        PriorityQueue queue = new PriorityQueue();
        try {
            File file=new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String s = "";
            while ((s=br.readLine())!= null) {
                StringTokenizer stk = new StringTokenizer(s, ", ");
                String email = stk.nextToken();
                long point = Long.parseLong(stk.nextToken());

                Gamer gamer = new Gamer(email, point);
                queue.addAndSort(gamer);
            }
             br.close(); fr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        return queue;
    }

//    void writeToFile(PriorityQueue queue,String fileName) {
//        if (queue.getList().getSize() == 0) {
//            System.out.println("Error: List empty");
//        } else {
//            try {
//                File file = new File(fileName);
//                FileWriter fw = new FileWriter(file);
//                PrintWriter pw = new PrintWriter(fw);
//                pw.println("Email, point");
//                DoublyLinkedList.Node<Gamer> current = queue.getList().getHeader();
//                while (current.getNext() != null) {
//                    pw.println(current.getElement().toString());
//                    current = current.getNext();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            } 
//        }
//    }
}

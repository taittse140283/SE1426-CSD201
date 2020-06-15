/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import Bai1.DoublyLinkedList.Node;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.File;

/**
 *
 * @author lehie
 */
public class CSVFile {
    public static PriorityQueue readFile(String file) {
        FileReader fr = null;
        BufferedReader br = null;
        PriorityQueue queue = new PriorityQueue();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while (br.ready()) {
                s = br.readLine();
                StringTokenizer stk = new StringTokenizer(s, ", ");
                String email = stk.nextToken();
                int point = Integer.parseInt(stk.nextToken());
                Player player = new Player(email, point);
                queue.addAndSort(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return queue;
    }
    
    public static void writeFile(PriorityQueue queue, String file) {
        if (queue.getList().getSize() == 0) {
            System.out.println("Error: List empty");
        } else {
            File f = null;
            FileWriter fw = null;
            PrintWriter pw = null;
            try {
                f = new File(file);
                fw = new FileWriter(f);
                pw = new PrintWriter(fw);
                pw.println("Email, point");
                Node<Player> current = queue.getList().getHeader();
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

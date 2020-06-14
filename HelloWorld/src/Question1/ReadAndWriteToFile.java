/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Thong
 */


public class ReadAndWriteToFile {

    public static PriorityQueue readFile(String file) {
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;
        PriorityQueue q = new PriorityQueue();
        try {
            f = new File(file);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while (br.ready()) {
                s = br.readLine();
                StringTokenizer stk = new StringTokenizer(s, ", ");
                String email = stk.nextToken();
                int point = Integer.parseInt(stk.nextToken());
                Gamer gamer = new Gamer(email, point);
                q.AddAndSort(gamer);
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
        return q;
    }
    
    public static void writeFile(PriorityQueue q, String file) {
        if (q.getList().getSize() == 0) {
            System.out.println("List empty!");
        } else {
            File f = null;
            FileWriter fw = null;
            PrintWriter pw = null;
            try {
                f = new File(file);
                fw = new FileWriter(f);
                pw = new PrintWriter(fw);
                pw.println("Email, point");
                LinkedList.Node<Gamer> current = q.getList().getHeader();
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
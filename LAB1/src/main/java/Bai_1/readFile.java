/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Dell
 */
public class readFile {
    public static PriorytiQueue readFromFile(String file) {
        File f= null;
        FileReader fr = null;
        BufferedReader br = null;
        PriorytiQueue queue = new PriorytiQueue();
        try {
            f = new File(file);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String s = null;
            while ((s=br.readLine())!=null) {
                //StringTokenizer stk = new StringTokenizer(s, ", ");
                //String email = stk.nextToken();
                String[] stk= s.split(",");
                String[] email=stk.nextToken();
                int point = Integer.parseInt(stk.nextToken());

                Infor player = new Infor(email, point);
                queue.addAndSort(player);
            }
        } catch (Exception e) {
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

    public void writeToFile(PriorytiQueue queue, String file) {
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
                DoublyLinkedList.Node<Player> current = queue.getList().getHeader();// lay gia tri dau tien cua hang doi
                while(current.getNext() != null) {// duyet danh sach cho den phan tu cuoi cung
                    pw.println(current.getElement().toString());
                    current = current.getNext();// buoc nhay
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if(pw != null) {
                        pw.close();
                    }
                    if(fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
public long get(String email) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                return ((Infor)this.list.get(i)).getPoint();
            }
        }

        return -1L;
    }
     public void remove(String email) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                this.list.remove(i);
            }
        }

    }

    public void update(String email, int point) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                Infor info = (Infor)this.list.remove(i);
                info.setPoint(point);
                this.add(info);
            }
        }

    }

    public Infor removeMin() {
        return (Infor)this.list.remove(0);
    }

    public Infor min() {
        return (Infor)this.list.get(0);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        String result = "";

        Infor info;
        for(Iterator var2 = this.list.iterator(); var2.hasNext(); result = result + info.toString() + "\n") {
            info = (Infor)var2.next();
        }

        return result;
    }

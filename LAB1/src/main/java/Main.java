/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tieuminh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    if(args[0].equals("-h")){
        System.out.println("Help: \n" +
                "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data structure into csv file\n" +
                "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data structure and save to new csv file\n" +
                "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data structure and save to new csv file\n" +
                "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data structure and save to new csv file\n" +
                "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data structure and save to new csv file\n" +
                "./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data structure\n" +
                "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure");
    }










        Entry A = new Entry(1, "A");
        Entry B = new Entry(9, "B");
        Entry C = new Entry(7, "C");
        Entry D = new Entry(7, "D");
        Entry E = new Entry(6, "E");
        Entry F = new Entry(1, "F");
        Entry G = new Entry(8, "G");
        Entry H = new Entry(1, "H");
        SortList sl = new SortList();
        sl.insert(A);
        sl.insert(B);
        sl.insert(C);
        sl.insert(D);
        sl.insert(E);
        sl.insert(F);
        sl.insert(G);
        sl.insert(H);
        sl.print();
        System.out.println("\n");
        sl.update("E");
        sl.print();

//        DoubleLinkedList<Entry> dll = new DoubleLinkedList();
//        dll.addFirst(A);
//        dll.addFirst(B);
//        dll.insert(C, dll.getNode(1), dll.getNode(2));
//        dll.addLast(D);
//        dll.print();

    }
    
}

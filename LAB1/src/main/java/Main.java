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
        Entry A = new Entry(1, "A");
        Entry B = new Entry(1, "B");
        Entry C = new Entry(1, "C");
        Entry D = new Entry(1, "D");
        Entry E = new Entry(1, "E");
        Entry F = new Entry(1, "F");
        Entry G = new Entry(1, "H");
        Entry H = new Entry(1, "K");
        SortList sl = new SortList();
        sl.insert(A);
        sl.insert(B);
        sl.insert(C);
//        sl.insert(D);
//        sl.insert(E);
//        sl.insert(F);
//        sl.insert(G);
//        sl.insert(H);
        sl.print();

//        DoubleLinkedList<Entry> dll = new DoubleLinkedList();
//        dll.addFirst(A);
//        dll.addFirst(B);
//        dll.insert(C, dll.getNode(1), dll.getNode(2));
//        dll.addLast(D);
//        dll.print();

    }
    
}

package com.company;

public class Main {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insert(4);
        tree.insert(7);
        tree.insert(2);
        tree.insert(9);
        tree.insert(8);
        tree.insert(6);
        tree.insert(5);
        tree.delete(7);
        tree.print();

//        Heap h = new Heap(1000);
//        h.insert(5);
//        h.insert(7);
//        h.insert(2);
//        h.insert(9);
//        h.insert(3);
//        h.insert(1);
//        h.insert(10);
//        h.remove();
//        h.print();
//        h.remove();
//        h.print();
    }
}

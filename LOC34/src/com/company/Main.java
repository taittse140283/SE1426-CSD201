package com.company;

public class Main {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.insert(6);
        tree.insert(7);
        tree.insert(2);
        tree.insert(9);
        tree.insert(2);
        tree.print();
    }
}

package com.company;

public class BSTree {
    private class Node {
        private int info;
        private Node left, right;
        public  Node(int info) {
            this.info = info;
            left = right =  null;
        }
    }
    Node root;
    BSTree() { root = null; }
    void visit(Node p) {
        System.out.print(p.info + " ");
    }
    void insert(int value) {
        root = insertNode(value, root);
//        if(root == null) root = new Node(value);
    }
    private Node insertNode(int value, Node p) {
        if( p == null ) p = new Node(value);
        if(value > p.info) {
            p.right = insertNode(value, p.right);
        } else if(value < p.info) {
            p.left = insertNode(value, p.left);
        }
        return p;
    }
    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    void print() {
        inOrder(root);
        System.out.print("\n");
    }
}

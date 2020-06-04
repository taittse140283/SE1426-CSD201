package com.company;

public class BSTree {
    private class Node {
        int info;
        Node left, right;
        Node(int value) {
            info = value;
            left = right = null;
        }
    }
    Node root;
    BSTree() {
        root = null;
    }
    void visit(Node p) {
        System.out.print(p.info + " ");
    }
    void insert(int value) {
        root = insertNode(value, root);
    }
    Node searchNode(int value, Node p) {
        if(p == null) return null;
        if(value > p.info) return searchNode(value, p.right);
        else if(value < p.info) return searchNode(value, p.left);
        return p;
    }
    void search(int value) {
        Node p = searchNode(value, root);
        if(p == null) System.out.print("Not Found\n");
        else System.out.print("Found in Tree\n");
    }
    Node insertNode(int value, Node p ) {
        if(p == null) return new Node(value);
        if(value > p.info)
            p.right = insertNode(value, p.right);
        else if(value < p.info)
            p.left = insertNode(value, p.left);
        return p;
    }
    void inOrder(Node p) {
        if(p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    void preOrder(Node p) {
        if(p == null) return;
        visit(p);
        inOrder(p.left);
        inOrder(p.right);
    }
    void postOrder(Node p) {
        if(p == null) return;
        inOrder(p.left);
        inOrder(p.right);
        visit(p);
    }
    void print() {
        inOrder(root);
        System.out.print("\n");
    }
}


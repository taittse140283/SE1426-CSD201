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
    private Node search(int value, Node p) {
        if(p == null) return null;
        if(value > p.info)
            return search(value, p.right);
        else if(value < p.info)
            return search(value, p.left);
        else
            return p;
    }
    private Node getParent(Node tree, Node n) {
        if(tree == null) return null;
        if(tree.left == n || tree.right == n) return tree;
        else if(n.info > tree.info) return getParent(tree.right , n);
        else return getParent(tree.left , n);
    }
    private Node getRight(Node p) {
        if(p.right == null) return p;
        return getRight(p.right);
    }
    
    public void delete(int value) {
        Node n = search(value, root);
        Node p = getParent(root, n);
        if(n.left == n.right && n.right == null)
            if(p.right == n) p.right = null;
            else p.left = null;
        else if(n.left == null)
            if(p.left == n) p.left = n.right;
            else p.right = n.right;
        else if(n.right == null)
            if(p.left == n) p.left = n.left;
            else p.right = n.left;
        else {
            Node r = getRight(n.left);
            r.right = n.right;
            if(p == null) root = r;
            else if(p.right == n) p.right = r;
            else p.left = r;
        }
        n.left = n.right = null;
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

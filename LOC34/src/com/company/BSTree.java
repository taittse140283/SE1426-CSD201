package com.company;

public class BSTree {
    private class Node {
        private int info;
        private Node left, right;
        public Node(int info) {
            this.info = info;
            left = right =  null;
        }
        public String toString() {
            String result = "";
            result += info;
            return result;
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
    private Node search(int value,  Node tree) {
        if(tree == null) return null;
        if(value < tree.info ) return search(value, tree.left);
        else if (value > tree.info ) return search(value, tree.right);
        else return tree;
    }

    private Node parent(Node n, Node tree) {
        if(tree == null) return null;
        if(n == tree.left || n == tree.right) return tree;
        else if(n.info > tree.info) return parent(n, tree.right);
        else if(n.info < tree.info) return parent(n, tree.left);
        else return null;
    }
    private Node right(Node tree) {
        if(tree.right == null) return tree;
        else return right(tree.right);
    }
    public void delete(int value) {
        Node n = search(value, root);
        Node p = parent(n, root);
        if(n.left == n.right && n.right == null) {
            if(p.right == n) p.right = null;
            else p.left = null;
        } else if(n.left == null || n.right == null) {
            if(n.right != null)
                if(p.right == n) p.right = n.right;
                else p.left = n.right;
            else
                if(p.right == n) p.right = n.left;
                else p.left = n.left;
        } else {
            Node r = right(n.left);
        }

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

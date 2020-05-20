package com.company;

public class SinglyLinkedList {
    private class Node {
        public int info;
        public Node next;
        public Node(int info, Node n) {
            this.info = info;
            this.next = n;
        }
    }
    private Node head;
    private Node tail;
    private Node getTailNode() {
        for(Node n = head; n != null; n=n.next)
            if(n.next == null) return n;
        return null;
    }
    public int getTail() {
//        Node tail = getTailNode();
        return tail.info;
    }
    public SinglyLinkedList() {
        head = null;
        tail = null;
    }
    public void addFirst(int info) {
        Node new_node = new Node(info, head);
        head = new_node;
        tail = head.next != null ? tail : head;
    }
    public void addLast(int info) {
        //Node tail = getTailNode();
        Node new_node = new Node(info, null);
        tail.next = new_node;
    }
    public int removeFirst() {
        if(head != null) {
            int value = head.info;
            head = head.next;
            tail = head != null ? tail : null;
            return value;
        }
        return Integer.MIN_VALUE;
    }
    public void print() {
        for(Node n = head; n != null; n=n.next)
            System.out.print(n.info + " ");
        System.out.print("\r\n");
    }
}

package com.company;

public class SinglyLinkedList<E> {
    private class Node {
        public E info;
        public Node next;
        public Node(E info, Node n) {
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
    public boolean isEmpty() {
        return head == null;
    }
    public int getSize() {
        int result = 0;
        for(Node n = head; n != null; n=n.next)
            result++;
        return result;
    }
    public E getHead() {
//        Node tail = getTailNode();
        return head.info;
    }
    public E getTail() {
//        Node tail = getTailNode();
        return tail.info;
    }
    public SinglyLinkedList() {
        head = null;
        tail = null;
    }
    public void addFirst(E info) {
        Node new_node = new Node(info, head);
        head = new_node;
        tail = head.next != null ? tail : head;
    }
    public void addLast(E info) {
        //Node tail = getTailNode();
        Node new_node = new Node(info, null);
        if(tail == null) {
            tail = new_node;
            head = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }


    }
    public E removeFirst() {
        if(head != null) {
            E value = head.info;
            head = head.next;
            tail = head != null ? tail : null;
            return value;
        }
        return null;
    }
    public String toString() {
        String result = "";
        for(Node n = head; n != null; n=n.next)
            result += n.info.toString() + " ";
        result += "\n";
        return result;
    }
}

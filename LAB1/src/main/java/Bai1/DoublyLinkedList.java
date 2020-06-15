package Bai1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lehie
 */
public class DoublyLinkedList<Player> {
    public static class Node<Player> {
        private Player value;
        private Node<Player> next;
        private Node<Player> prev;
        
        public Node(Player value){
            this.value=value;
        }
        
        public Node (Player value, Node<Player> next, Node<Player> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        
        //return data of node
        public Player getElement(){
            return value;
        }
        
        public void setValue(Player value){
            this.value = value;
        }
        
        //return node is behind of it
        public Node<Player> getNext() {
            return next;
        }
        
        //create next node with param is specific node
        public void setNext(Node<Player> n) {
            next = n;
        }
        
        //return node is in front of it
        public Node<Player> getPrev() {
            return prev;
        }
        
        //creat prev node with paran is specific node
        public void setPrev(Node<Player> p) {
            prev = p;
        }
        
    }
    
    //creat inner class Node for doublylinkedlist
    private Node<Player> header;
    private Node<Player> trailer;
    public int size = 0;
    
    //constructor
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header, null);
        header.setNext(trailer);
        size = 0;
    }
    
    //create getter and setter for Node hearder, trailer and size
    public Node<Player> getHeader() {
        return header;
    }

    public void setHeader(Node<Player> header) {
        this.header = header;
    }

    public Node<Player> getTrailer() {
        return trailer;
    }

    public void setTrailer(Node<Player> trailer) {
        this.trailer = trailer;  
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return size ==0;
    }
    
    //return node to at beginning of list
    public Player getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }
    
    //return node at the end of list
    public Player getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }
    
    //add new Node between two given nodes
    public void addBetween(Player v, Node<Player> p, Node<Player> s) {
        Node<Player> newNode = new Node<>(v, p, s); 
        p.setNext(newNode);  
        s.setPrev(newNode); 
        size++; 
    }
    
    //insert player to the beginning of list
    public void addFirst(Player v) {
        addBetween(v, header, header.getNext());
    }
    
    //insert player to the end of list
    public void addLast(Player v) {
        addBetween(v, trailer.getPrev(), trailer);
    }
    
    //remove the given node from the list and returns its value
    private Player remove(Node<Player> n) {
        Node<Player> p = n.getPrev();
        Node<Player> s = n.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return n.getElement();
    }
    
    //delete node at the beginning of list
    public Player removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }
    
    
    //delete node at the end of the list
    public Player removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }
    
    
    //delete node at a position
    public void removeAtPosition(int n) {
        if (size == 0 || n < 0) {
            return;
        }
        Node current = header.getNext(); 
        for (int i = 0; (current != null) && (i < n); i++) { 
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        remove(current);
    }
    
    //return value of node at specific position
    public Player get(int index) {
        if (size != 0) {
            Node<Player> current = header.getNext();
            for (int i = 0; (current != null) && (i < index); i++) {
                current = current.getNext();
            }
            if (current != null) {
                return current.getElement();
            }
        }
        return null;
    }
}
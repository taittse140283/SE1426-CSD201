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
        
        public Node (Player value, Node<Player> next, Node<Player> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        
        public Player getValue(){
            return value;
        }
        
        public void setValue(Player value){
            this.value = value;
        }

        public Node<Player> getNext() {
            return next;
        }

        public void setNext(Node<Player> next) {
            this.next = next;
        }

        public Node<Player> getPrev() {
            return prev;
        }

        public void setPrev(Node<Player> prev) {
            this.prev = prev;
        }
        
    }
    
    private Node<Player> header;
    private Node<Player> trailer;
    public int size = 0;
    
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header, null);
        header.setNext(trailer);
        size = 0;
    }

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
    
    public Player getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getValue();
    }

    public Player getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getValue();
    }
    
    public void addBetween(Player v, Node<Player> p, Node<Player> s) {
        Node<Player> newNode = new Node<>(v, p, s); 
        p.setNext(newNode);  
        s.setPrev(newNode); 
        size++; 
    }
        
    public void addFirst(Player v) {
        addBetween(v, header, header.getNext());
    }
    
    public void addLast(Player v) {
        addBetween(v, trailer.getPrev(), trailer);
    }
    
    private Player remove(Node<Player> n) {
        Node<Player> p = n.getPrev();
        Node<Player> s = n.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return n.getValue();
    }
    
    public Player removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }
    
    public Player removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }
    
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

    public Player get(int index) {
        if (size != 0) {
            Node<Player> current = header.getNext();
            for (int i = 0; (current != null) && (i < index); i++) {
                current = current.getNext();
            }
            if (current != null) {
                return current.getValue();
            }
        }
        return null;
    }
}
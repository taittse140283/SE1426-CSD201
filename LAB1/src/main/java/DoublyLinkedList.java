/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lehie
 */
public class DoublyLinkedList<P> {
    private class Node<P> {
        private P value;
        private Node<P> next;
        private Node<P> prev;
        
        public Node (P value, Node<P> next, Node<P> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        
        public P getValue(){
            return value;
        }
        
        public void setValue(P value){
            this.value = value;
        }

        public Node<P> getNext() {
            return next;
        }

        public void setNext(Node<P> next) {
            this.next = next;
        }

        public Node<P> getPrev() {
            return prev;
        }

        public void setPrev(Node<P> prev) {
            this.prev = prev;
        }
        
    }
    
    private Node<P> header;
    private Node<P> trailer;
    public int size = 0;
    
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header, null);
        header.setNext(trailer);
        size = 0;
    }

    public Node<P> getHeader() {
        return header;
    }

    public void setHeader(Node<P> header) {
        this.header = header;
    }

    public Node<P> getTrailer() {
        return trailer;
    }

    public void setTrailer(Node<P> trailer) {
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
    
    public P getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getValue();
    }

    public P getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getValue();
    }
    
    public void addBetween(P v, Node<P> p, Node<P> s) {
        Node<P> newNode = new Node<>(v, p, s); 
        p.setNext(newNode);  
        s.setPrev(newNode); 
        size++; 
    }
        
    public void addFirst(P v) {
        addBetween(v, header, header.getNext());
    }
    
    public void addLast(P v) {
        addBetween(v, trailer.getPrev(), trailer);
    }
    
    private P remove(Node<P> n) {
        Node<P> p = n.getPrev();
        Node<P> s = n.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return n.getValue();
    }
    
    public P removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }
    
    public P removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }
}
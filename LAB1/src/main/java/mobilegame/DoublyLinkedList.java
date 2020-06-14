/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList<E> {
   
    public static class Node<E> {

        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        
        public E getElement() {
            return data;
        }

      
        public Node<E> getPrev() {
            return prev;
        }

       
        public Node<E> getNext() {
            return next;
        }

      
        public void setPrev(Node<E> p) {
            prev = p;
        }

        
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header; 
    private Node<E> trailer; 
    public int size = 0; 

  
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

   
    public Node<E> getHeader() {
        return header.getNext();
    }

    public void setHeader(Node<E> header) {
        this.header = header;
    }

    public Node<E> getTrailer() {
        return trailer.getPrev();
    }

    public void setTrailer(Node<E> trailer) {
        this.trailer = trailer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    
    public void addBetween(E e, Node<E> p, Node<E> s) {
        Node<E> newNode = new Node<>(e, p, s); 
        p.setNext(newNode);  
        s.setPrev(newNode); 
        size++; 
    }

 
    private E remove(Node<E> node) {
        Node<E> p = node.getPrev();
        Node<E> s = node.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return node.getElement();
    }

   
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

  
    public E removeLast() {
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

    
    public E get(int index) {
        if (size != 0) {
            Node<E> current = header.getNext();
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

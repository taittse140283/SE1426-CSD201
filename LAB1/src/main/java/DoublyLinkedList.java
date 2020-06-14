/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author TrinhAnhTai
 */

/*
 * Create class doublyLinkedList to save Player   
 */
public class DoublyLinkedList<E> {
    /**
     * Create inner class Node for doublyLinkedList
     *
     * @param <E>
     */  
    private Node<E> header; 
    private Node<E> trailer; 
    public int size = 0; 

    /*
        Constructor default
        Create Node header, trailer
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }
    
    /*
     *Create method for Setter and Getter for Node header and trailer
     */
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
    
    /*
     *getFirst: return Node on the top of list
     */
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }
    /*
     *getLast: return Node in last of list
     */
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }
    
    /*
    * addbetween: add new Node between two given nodes
    */
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

    /*
     *insertFirst: insert Player in top of list
     *input: value of object
     */
    public void insertFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /*
     *insertLast: insert Player in last of list
     *input: value of object
     */
    public void insertLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }
    
    /*
    *removeFirst: delete Node on the top of list
    */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }
    
    /*
    *removeLast:  delete Node in last of list
    */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    /*
     *removeAtPos: delete Node at any position
     */
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

    /*
     * get: return value of node at specific position
     * input: position of node
     * output: value of node
     */   
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

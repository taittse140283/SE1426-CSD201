/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author User
 */
public class DoublyLinkedList<E> {

    /**
     * Create inner class Node for doublyLinkedList
     *
     * @param <E>
     */
    private class Node<E> {

        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        /*
            Return data of Node
         */
        public E getElement() {
            return data;
        }

        /*
            Return Node is in front of it
         */
        public Node<E> getPrev() {
            return prev;
        }

        /*
            Return Node is behind it
         */
        public Node<E> getNext() {
            return next;
        }

        /*
            Create previous Node with param is specific Node
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /*
            Create next Node with param is specific Node
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header; // Khai bao node header
    private Node<E> trailer; // khai bao node trailer
    public int size = 0; // khoi tao kich thuoc cua danh sach

    /*
        Constructor default
        Create Node header, trailer
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    /*
        Return size fo list
    */
    public int size() {
        return size;
    }
    /*
        Return true if size = 0
    */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /*
        Return element in top of list
    */
    public E getFirst() {
        if(isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }
    
    /*
        Return element in last of list
    */
    public E getLast() {
        if(isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }
    /*
        Add new Node at between two given Node
    */
    private void addBetween(E e, Node<E> p, Node<E> s) {
        Node<E> newNode = new Node<>(e, p, s); // create new node
        p.setNext(newNode);  // set address for pointer
        s.setPrev(newNode); // ""
        size++; // tang kich thuoc danh sach len 1
    }

}

package LAB1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZunPeter
 */

public class DoublyLinkedList {

    private static class E {

        public E() {
        }
    }
    /*nest Node class */
    private class Node<E>{
        private E element;
        
        private Node<E> next;
        private Node<E> prev;
        public Node (E element, Node next_node, Node prev_node){
            element = element;
            this.next = next_node;
            this.prev = prev_node;
        }  
        /*Getter and Setter*/
        public E getElement(){
            return element;
        }
        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        } 
    }
    /*Instance variable */
    private Node header;
    private Node trailer;
    private int size = 0;
    /*contructor a new empty list*/
    public DoublyLinkedList(){
        header = new Node(Integer.MIN_VALUE, null, null);
        trailer = new Node(Integer.MAX_VALUE, header, null);
        header.next = trailer;
    }
    /*return number of elements in the linked list*/
    public int size(){
        return size;
    }  
    /*test if the linked list is empty
    @return true*/
    public boolean isEmpty(){
        return size == 0;
    }
    /*Return first elemet of the linked list*/    
    public Player first(){
        if(isEmpty()) return null;
        return (Player) header.getNext().getElement();
    }
    /*Return last element of the linked list*/
    public Player last(){
        if(isEmpty()) return null;
        return (Player) trailer.getPrev().getElement();
    }
    /*Add first element infornt of the list*/
    public void addFirst(E e){
        addBetween(e, header, header.getNext());
    }
     /*Add last element infornt of the list*/
    public void addLast(E e){
        addBetween(e, trailer.getPrev(), trailer);
    }
    
    /*Add element e between given node*/
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
       Node<E> newest = new Node<>(e, predecessor, successor);
       predecessor.setNext(newest);
       successor.setPrev(newest);
       size++;
    }
}


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
    /*nest Node class */
    private class Node{
        private int value;
        private Node next;
        private Node prev;
        public Node (int value, Node next_node, Node prev_node){
            this.value = value;
            this.next = next_node;
            this.prev = prev_node;
        }  

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
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
    /*make a new empty list*/
    public DoublyLinkedList(){
        header = new Node(Integer.MIN_VALUE, null, null);
        trailer = new Node(Integer.MAX_VALUE, header, null);
        header.next = trailer;
    }
    /*return number of elements in the linked list*/
    public int size(){
        return size;
    }  
    /*test if the linked list is empty*/
    public boolean isEmpty(){
        return size == 0;
    }
    
}


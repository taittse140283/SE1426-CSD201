/*
 * To change this license head, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.util.NoSuchElementException;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList {
    private class Node{
        Player data;
        Node next;
        Node prev;

        /**
         * Constructor
         * @param data
         * @param next
         * @param prev 
         */
        public Node(Player data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        //Getter & Setter
        public Player getData() {
            return data;
        }

        public void setData(Player data) {
            this.data = data;
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
    /**
     * head node 
     * tail node
     * A variable for tracking size
     */
    private Node head = null;
    private Node tail = null;
    private int size;

    
    public DoublyLinkedList(){
        head = new Node(null, null, null);
        tail = new Node(null, null, head);
        head.setNext(tail);
    }
    /**
     * return whether the list is empty or not
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * returns the size of the linked list
     * @return
     */
    public int size(){
        return size;
    }
    
    /**
     * adds element at the starting of the linked list
     * @param element
     */
    public void addFirst(Player data) {
        Node newNode = new Node(data, head, null);
        if(head != null ) {
            head.prev = newNode;
        }
        head = newNode;
        if(tail == null) {
            tail = newNode;
        }
        size++;
    }
    
    /**
     * adds element at the end of the linked list
     * @param element
     */
    public void addLast(Player data) {
         
        Node newNode = new Node(data, null, tail);
        if(tail != null) {tail.next = newNode;}
        tail = newNode;
        if(head == null) { head = newNode;}
        size++;
    }
    
    private Player remove(Node n){
        if(n != head && n != tail){
            Node front = n.getNext();
            Node back = n.getPrev();
            front.setNext(back);
            back.setPrev(front);
            size--;
        }
        return n.getData();
    }
    /**
     * this method removes element from the start of the linked list
     * @return
     */
    public Player removeFirst() {
        if (isEmpty()){
            return null;
        }
        return remove(head.getNext());
    }
    
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public Player removeLast() {
        if (isEmpty()){
            return null;
        }
        return remove(tail.getPrev());
    }
    
    /**
     * Return Player at the top of list
     * @return data Of Player
     */
    public Player getFirst(){
        if(isEmpty()){     //Case, if the list is empty, it will return null
            return null;
        }
        return head.getNext().getData();
    }
    
    /**
     * Return Player at the last of list
     * @return data Of Player
     */
    public Player getLast(){
        if(isEmpty()){      //Case, if the list is empty, it will return null       
            return null;
        }
        return tail.getPrev().getData();
    }
    
    /**
     * add a new player into the data structure
     * If if the list is empty, addFirst
     * @param data 
     */
    public void add(Player data){
        if(isEmpty()){
            addFirst(data);
        }
    }
    
    /**
     * remove a new player into the data structure
     * case, if the list is empty , show message
     * Search the location the player wants to delete
     * case If search fails, the player does not exist in the list.
     * @param data 
     */
    public void delete(Player data){
        if(isEmpty()){
            System.err.println("Empty List!");
        }else{
            //1.search player 
            
            if(searchPlayer = null){
                System.err.println("The player doesn't exist.");
            }else{
                remove(searchPlayer);
            }
        }
    }
}

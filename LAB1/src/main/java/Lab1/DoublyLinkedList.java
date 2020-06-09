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
public class DoublyLinkedList<Player> {
    /**
     * head node 
     * tail node
     * A variable for tracking size
     */
    private Node<Player> head;
    private Node<Player> tail;
    private int size;

    /**
     * Constructor empty list
     */
    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
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
        Node newnode = new Node(data, head, null);
        if(head != null ) {head.previous = newnode;}
        head = newnode;
        if(tail == null) { tail = newnode;}
        size++;
    }
    
    /**
     * adds element at the end of the linked list
     * @param element
     */
    public void addLast(Player data) {
         
        Node newnode = new Node(data, null, tail);
        if(tail != null) {tail.next = newnode;}
        tail = newnode;
        if(head == null) { head = newnode;}
        size++;
    }
    
    /**
     * this method removes element from the start of the linked list
     * @return
     */
    public Player removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node<Player> deleteNode = head;
        head = head.next;
        head.previous = null;
        size--;
        return deleteNode.data;
    }
    
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public Player removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node<Player> deleteNode = tail;
        tail = tail.previous;
        tail.next = null;
        size--;
        return deleteNode.data;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 * Using doubly linked list to implement stack
 * @author Linh
 */
public class Stack {
    TagHTML head, tail;
    
    //Constructor
    public Stack() {
        head = tail = null;
    }
    
    /**
     * Create a new node and add it behind the tail and move tail to new node
     * @param tag 
     */
    public void push(String tag) {
        TagHTML t = new TagHTML(tag, head, tail);
        
        //If nothing in stack, new node is both a head and a tail
        if(head == null) {
            head = t;
            head.prev = null;
            tail = t;
            tail.next = null;
            return;
        }
        
        //Add new node behind the tail and move tail to new node
        t.prev = tail;
        tail.next = t;
        tail = t;
        tail.next = null;
    }
    
    /**
     * Remove the tail out of the stack
     */
    public void pop() {
        
        if(head == null)
            return;
        
        //If only 1 node in stack, assign head and tail to null
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        
        //Assign the tail to its previous node
        tail = tail.prev;
        tail.next = null;
    }
    
    /**
     * Get the top tag of stack
     * @return tail.tag
     */
    public String getTop() {
        return tail.getTag();
    }
    
    /**
     * Print all node in stack to screen
     */
    public void print() {
        for(TagHTML t = head; t != null; t = t.next)
            System.out.print(t.getTag() + "   ");
    }
}

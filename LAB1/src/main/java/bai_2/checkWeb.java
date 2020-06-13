/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;



/**
 *
 * @author Dell
 */
public class checkWeb{
    /**
     * Creat class Stack to store data 
     */
   public class Stack {
      InfoTagWeb head, tail;
    
    //Constructor
    public Stack() {
        head = tail = null;
    }
    
    
    public void push(String tag) {
        InfoTagWeb t = new InfoTagWeb(tag, head, tail);
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
    
    
    public String getTop() {
        return tail.getTag();
    }
    
   
    public void print() {
        for(InfoTagWeb t = head; t != null; t = t.next)
            System.out.print(t.getTag() + "   ");
    }
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *this class will store the tag and have some method: isEmtym push,pop,top. 
 * @author Admin
 */
public class Stack {
     NodeHTML head,tail;
    
    public Stack(){
        head=tail=null;
    }
    public boolean isEmpty() {
        return tail == null;
    }
    /**
     * this method will add a node to the stack. If stack is empty, the node is a head,
     * if there is a node before, add first in to stack
     */
    public void push(String tagHTML){
        NodeHTML tag =  new NodeHTML(tagHTML , head , tail);
        // check the list is empty?
        
        if(isEmpty()){
            head = tag;
            tail = head;
            tail.next = null;
            head.prev = tail.next = null;
            return;
        }
        //if have, add in first position
        tag.next = head;
        head.prev = tag;
        head = tag;
        head.prev = null;        
    }
    /**
     * this method will remove a node in the stack
     * @param no parametter
     */
    public void pop(){
        //check the stack is empty?
        
        if(isEmpty()){
            System.out.println("empty stack");
        }
        //remove when the stack just have only one node
        else if(head == tail) {
            head = tail = null;
            //after remove, print it.
            System.out.println("list is empty");
            return;
        }else{
        head = head.next;
        head.prev = null;}
    }
    /**
     * this method will get the top of the stack 
     * @param no parametter
     */
    public String Top() {
        return head.getTagHTML();
    }
    /**
     * this method will to print
     */
    public void print() {
        for(NodeHTML tag = tail; tag != null; tag = tag.prev)
            System.out.print(tag.tag + " ");
    }
}

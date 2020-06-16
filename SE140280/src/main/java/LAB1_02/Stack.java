/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_02;

/**
 *
 * @author ZunPeter
 */
public class Stack {
   NodeHTML head;
   NodeHTML tail;

    public Stack() {
    head = null;
    tail = null;
    }
    /**
    * return the number of elements in the stack
    * @return number of element in stack
    */
    private int size = 0;
    int size(){
      return size;
    }
    /**
    * Check if stack is Empty
    * @return true if the stack is empty 
    */
    public boolean isEmpty(){
       return size == 0; 
    }
    /**
    * Insert element in top of the stack
    * @return top element in the stack or null if empty
    */
    public void push(String tagHTML){
        NodeHTML tag= new NodeHTML(tagHTML, head, tail);
        /*check if stack is empty*/
        if(isEmpty()){
        head.prev = tail.next = null;
        return;
        }
        tag.next = head;
        head.prev =  tag;
        head = tag;
        head.prev = null;
    }
    /*Remove a node in the stack*/
    public void pop(){
        /*Check if the tag is empty*/
        if(isEmpty()){
            System.out.println("Stack is empty!!");
        } else if(head == tail){
            head = tail = null; 
            System.out.println("List is empty");
            return;
        }else {
            head = head.next;
            head.prev = null;
        }
      
    }
    /*get first node in the list*/
    public String top(){
        return head.getTag();
    }
    
    public void print(){
        for(NodeHTML tag = tail; tag != null; tag = tag.prev)
            System.out.println(tag.tag+"");
    }
}
 

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
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountTagHTML;

/**
 *
 * @author Loi Lam
 */
public class Stack {

    TagHTML head, tail;

    //Constructor
    public Stack() {
        head = tail = null;
    }
    
    public void push (String tag){
        TagHTML th = new TagHTML(tag, head, tail);
        //new node head and tail when stack null
        if(head == null){
            head = th;
            head.prev = null;
            tail = th;
            tail.next = null;
            return;
        }
        //add new node
        th.prev = tail;
        tail.next = th;
        tail = th;
        tail.next = null;
    }
    
    //remove tail of stack
    public void pop(){
        if(head == null){
            return;
        }
        //set head and tail to null when stack have 1 node
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        //set tail to prev node
        tail = tail.prev;
        tail.next = null;
    }
    
    //display all node in stack to screen
    public void print(){
        for(TagHTML th = head; th != null; th = th.next){
            System.out.println(th.getTag() + "\t");
        }
    }
}

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
}

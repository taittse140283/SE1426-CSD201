/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author W10
 * Build Stack structure to store Web tag
 */
public class WebStack {
    WebsiteInfo head,tail;//tao pointer 

    public WebStack() {
        head = tail = null;
    }
    public boolean isEmpty(){
        return tail == null;
    }
    
    /**
     * Them node vao , neu rong thi node la head
     * @param tag 
     */
    public void push(String tag) {
        WebsiteInfo web_tag = new WebsiteInfo(tag, head, tail);
        if(isEmpty()) {
            head = web_tag;
            head.pre = null;
            tail = web_tag;
            tail.next = null;
            return;
        }
        web_tag.pre = tail;
        tail.next = web_tag;
        tail = web_tag;
        tail.next = null;
    }
    
    /**
     * Xoa node trong stack
     */
    public void pop() {
        if (isEmpty()) {
            System.err.print("Stack rong");
        }
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.pre;
        tail.next = null;
    }
}

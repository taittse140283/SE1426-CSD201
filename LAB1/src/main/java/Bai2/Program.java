/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.HashMap;

/**
 *
 * @author Asus
 */
public class Program{
   public class Stack {
      TgHTML head, tail;
    public Stack() {
        head = tail = null;
    }
    public void push(String tag) {
        TgHTML t = new TgHTML(tag, head, tail);
        if(head == null) {
            head = t;
            head.prev = null;
            tail = t;
            tail.NEXT = null;
            return;
        }
        t.prev = tail;
        tail.NEXT = t;
        tail = t;
        tail.NEXT = null;
    }
    public void pop() {
        if(head == null)
            return;
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.NEXT = null;
    }
    public String getTop() {
        return tail.getTagHTML();
    }
}
}
    
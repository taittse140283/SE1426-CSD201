/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author Asus
 */
public class Stack {
    TgHTML head,tail;
    public void Stack(){
        head=tail=null;
    }
    public void push(String tagHTML){
        TgHTML tg= new TgHTML(tagHTML,head,tail);
        if(head==null){
            head=tail=tg;
            head.prev=tail.prev=null;
            return;
        }
        tg.NEXT= head;
        head.prev= head=tg;
        head.prev = null;
    }
}

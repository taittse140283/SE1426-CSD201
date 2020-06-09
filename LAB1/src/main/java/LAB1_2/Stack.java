/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

/**
 *
 * @author TAN
 */
public class Stack {
    NodeHTML head,tail;
    
    public Stack(){
        head=tail=null;
    }
    public boolean isEmpty() {
        return tail == null;
    }
    public void push(String tagHTML){
        NodeHTML tag =  new NodeHTML(tagHTML , head , tail);
        // kiem tra liststack co rong hay khong 
        if(isEmpty()){
            head = tag;
            tail = head;
            tail.next = null;
            head.prev = tail.next = null;
            return;
        }
        //neu da co 1 phan tu tro len thi them phan tu (addFirst)
        tag.next = head;
        head.prev = tag;
        head = tag;
        head.prev = null;        
    }
    // xoa phan tu (removefirst)
    public void pop(){
        //Kiem tra stack co rong 
        if(isEmpty()){
            System.out.println("Stack rong");
        }
        //Neu xoa khi chi con 1 phan 
        else if(head == tail) {
            head = tail = null;
            System.out.println("Danh sach trong");
            return;
        }else{
        head = head.next;
        head.prev = null;}
    }
    // lay the tren cung trong stack
    public String Top() {
        return head.getTagHTML();
    }
    public void print() {
        for(NodeHTML tag = tail; tag != null; tag = tag.prev)
            System.out.print(tag.tagHTML + " ");
    }
}

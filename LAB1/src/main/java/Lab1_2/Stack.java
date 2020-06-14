/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

/**
 *
 * @author hiep
 */
public class Stack {

    Node head, tail;

    public Stack() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    public void push(String tagHTML) {
        Node tag = new Node(head, tail, tagHTML);
        // check list rongg
        if (isEmpty()) {
            head = tag;
            tail = head;
            tail.next = null;
            head.prev = tail.next = null;
            return;
        }
        //if not null->(addFirst)
        tag.next = head;
        head.prev = tag;
        head = tag;
        head.prev = null;
    }
    //xoa phan tu (remove first) 
        public void pop(){
        //check stack rong
        
        if(isEmpty()){
            System.out.println("Stack empty");
        }
        //xoa khi chi con 1 node
        else if(head == tail) {
            head = tail = null;
            //after remove, print it.
            System.out.println("list is empty");
            return;
        }else{
        head = head.next;
        head.prev = null;}
    }
    //lay tag tren cung cua stack
        public String Top(){
            return head.getTag();
        }
        public void print(){
            for(Node tag=tail;tag!=null;tag=tag.prev){
                System.out.println(tag.tag+"");
            }
        }
}

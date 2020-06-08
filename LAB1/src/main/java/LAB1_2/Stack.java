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
            head.prev = tail.prev = null;
            return;
        }
        //neu da co 1 phan tu tro len thi them phan tu (addFirst)
        tag.next = head;
        head.prev = tag;
        head = tag;
        head.prev = null;        
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */
public class Node<Entry> {
   
         Entry element;
         Node<Entry> next;
         Node<Entry> back;
        public Node(Entry element, Node next_Node, Node back_Node){
            element= element;
            this.next=next_Node;
            this.back= back_Node;
        }
        public Node(){
            element=null;
            back=next=null;
        }
    
        
    
    
    //getters and setters
    public Entry getElement(){ return element;}
    public void setElement(Entry element){this.element=element;}
    public Node<Entry> getBack(){ return back;}
    public Node<Entry> getNext(){ return next;}
    public void setBack(Node<Entry>  b){back=b;}
    public void setNext(Node<Entry>  n){next=n;}
}

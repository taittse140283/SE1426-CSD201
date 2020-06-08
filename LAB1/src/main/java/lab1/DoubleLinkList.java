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
public class DoubleLinkList {

   
    private class Node<>{
        private int point;
        private Node next;
        private Node back;
        public Node(int point, Node next_Node, Node back_Node){
            this.point= point;
            this.next=next_Node;
            this.back= back_Node;
        }
    
    
    //getters and setters
    public Node<> getBack(){ return back;}
    public Node<> getNext(){ return next;}
    public void setBack(Node <> b){back=b;}
    public void setNext(Node <> n){next=n;}
    }
    private Node header;
    private Node tailer;
    private int size=0;
    
    //constructor n new empty list
    public DoubleLinkList(){
        header= new Node(null,null,null);
        tailer=new Node(null,null,null);
        header.setNext(tailer);
    }
    /** Return the number of elements in the linked list. */
    public int size(){ return size;}
    /** tests whether the linkded list is empty */
    public boolean isEmpty(){return size==0;}
    /** Returns the first element of the list */
    public Node first(){
        if(isEmpty()) return null;
        return header.getNext().getPoint();
    }
    private void addBetween(int point, Node infontof, Node back){
        /** Create and link a node */
        Node new_Node= new Node(point, infontof, back);
        infontof.setNext(new_Node);
        back.setBack(new_Node);
        size++;
        
    }
    
    
}

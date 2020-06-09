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
public class DoubleLinkList<Entry> {

   
    private class Node<Entry>{
        private Entry element;
        private Node<Entry> next;
        private Node<Entry> back;
        public Node(Entry element, Node next_Node, Node back_Node){
            element= element;
            this.next=next_Node;
            this.back= back_Node;
        }
        
    
    
    //getters and setters
    public Entry getElement(){ return element;}
    public Node<Entry> getBack(){ return back;}
    public Node<Entry> getNext(){ return next;}
    public void setBack(Node<Entry>  b){back=b;}
    public void setNext(Node<Entry>  n){next=n;}
    }
    private Node<Entry> header;
    private Node<Entry> tailer;
    private int size=0;
    
    //constructor n new empty list
    public DoubleLinkList(){
        header= new Node(null,null,null);
        tailer=new Node(null,null,null);
        header.setNext(tailer);
    }
    /** Return the number of elements in the linked list. */
    public int size(){ return size;}
    /** tests whether the linked list is empty */
    public boolean isEmpty(){return size==0;}
    /** Returns the first element of the list */
    public Entry first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    //** add element to the linked list int the between the given nodes  */
    private void addBetween(Entry Element, Node<Entry> infontof, Node<Entry> back){
        /** Create and link a node */
        Node<Entry> new_Node= new Node<>(Element, infontof, back);
        infontof.setNext(new_Node);
        back.setBack(new_Node);
        size++;
        
    } 
    /** 
    * this method remove a node in linkedList
    * @param node
    * no output
    
    */
    private Entry remove(Node <Entry> node){
        Node<Entry> infontof= node.getBack();
        Node<Entry> back=node.getNext();
        infontof.setNext(back);
        back.setBack(infontof);
        size--;
        return node.getElement();
    }
    
    

    
    
    
}

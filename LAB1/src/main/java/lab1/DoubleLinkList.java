/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 *
 * @author Admin
 */
public class DoubleLinkList<Entry> {

   
    public class Node<Entry>{
        private Entry element;
        private Node<Entry> next;
        private Node<Entry> back;
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

    
    
    private Node<Entry> header;
    private Node<Entry> tailer;
    public Node<Entry> getHeader() {
        return header;
    }

    public void setHeader(Node<Entry> header) {
        this.header = header;
    }

    public Node<Entry> getTailer() {
        return tailer;
    }

    public void setTailer(Node<Entry> tailer) {
        this.tailer = tailer;
    }
    private int size=0;
    
    //constructor  new empty list
    public DoubleLinkList(Node<Entry> header, Node<Entry> tailer) {
        this.header = header;
        this.tailer = tailer;
    }
    public DoubleLinkList(){
        header = tailer = null;
    }
    /** Return the number of elements in the linked list. */
    public int size(){ return size;}
    /** tests whether the linked list is empty */
    public boolean isEmpty(){return size==0;}
    /** Returns the first element of the list */
     public Entry getHeadElemnt(){
        return header.getElement();
    }
    public Entry first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    /** return the last element of the list*/
    public Entry last(){
        if(isEmpty()) return null;
        return tailer.getBack().getElement();
    }
    
     
    /** add element to the front of the list
     *@param new Node
     */
    public void addFirst(Node<Entry> newNode){
        newNode.setNext(header);
        header.setBack(newNode);
        header = newNode;
        size++;
    }
    /** add element to the last the list
     *@param new Node
     */
     public void addLast(Node<Entry> newNode){
        newNode.setBack(tailer);
        tailer.setNext(newNode);
        tailer = newNode;
        size++;
    }
    /** Removes and returns the first element of the list. */
    public Entry removeFirst(){
        if(isEmpty()){
            System.out.println("Empty List!!!");
        }
        
        else{
            Entry value = header.getElement();
            header = header.getNext();
            header.setBack(null);
            size--;
            if(header == tailer){
            header = tailer = null;
            }
        }
        return null;
    }
    /** Removes and returns the last element of the list. */
    public Entry removeLast(){
        if(isEmpty()){
            System.out.println("Empty list");
        }
       
        else{
            Entry value = tailer.getElement();
            tailer = tailer.getBack();
            tailer.setNext(null);
            size--;
            if(header == tailer){
            header = tailer = null;
            }
        }
        return null;
    }
    
    
    /** 
    * this method remove a node in linkedList
    * @param node
    * no output
    
    */
    public Entry remove(Node <Entry> node){
        if (isEmpty()) {
            System.out.println("Empty List");
        } else {
            Entry value = node.getElement();
            node.getBack().setNext(node.getNext());
            node.getNext().setBack(node.getBack());
            size--;
            if (header == tailer){
                header = tailer = null;
            }
        }
        return null;
    }
    /**
     * this method to take the node with the position user need, anywhere in the list
     * @param position whew  user want to get  
     * @return the node in the needed position
     */
    public Node<Entry> getNode(int position){
        Node<Entry> node= header.next;
        for(int i=0;i<position;i++){
            node=node.next;
        }
        return node;
    }
    /**
     * this method to get the point of the node in the list
     * @param the position of node
     */
    public Entry getElementNode(int post) {
        return getNode(post).getElement();
    }
}

    
     
    
   

    

    
    
    

    
    
    


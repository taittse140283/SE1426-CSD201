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
    
    //constructor  new empty list
    public DoubleLinkList(){
        header= new Node(null,null,null);
        tailer=new Node(null,header,null);
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
    /** return the last element of the list*/
    public Entry last(){
        if(isEmpty()) return null;
        return tailer.getBack().getElement();
    }
    //** add element to the linked list int the between the given nodes  */
    private void addBetween(Entry Element, Node<Entry> infontof, Node<Entry> back){
        /** Create and link a node */
        Node<Entry> new_Node= new Node<>(Element, infontof, back);
        infontof.setNext(new_Node);
        back.setBack(new_Node);
        size++;
        
    } 
    /** add element to the front of the list
     *@param e
     */
    public void addFirst(Entry e){
        addBetween(e,header,header.next); 
    }
    /** add element to the last the list
     *@param e
     */
    public void addLast(Entry e){
        addBetween(e,tailer.back, tailer);
    }
    /** Removes and returns the first element of the list. */
    public Entry removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    /** Removes and returns the last element of the list. */
    public Entry removeLast(){
        if(isEmpty()) return null;
        return remove(tailer.getBack());
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
     * this method print the Node(include email and point) to the file with address in desktop(in file have header is: Email, Point)
     * @param input is a file
     * @return  no return
    */
     public void printtoFile(String file) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\");
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeBytes("Email, Point\n");
        for (Node<Entry> n =  header.next; n != tailer; n = n.next) {
            dos.writeBytes(n.getElement() + "\n");
        }
        fos.close();
        dos.close();
    }
     
    
    public void print(){
        for(Node<Entry> n=header; n!=tailer;n=n.next){
            System.out.println(n.getElement() + " ");
        }
    }
}
    

    
    
    

    
    
    

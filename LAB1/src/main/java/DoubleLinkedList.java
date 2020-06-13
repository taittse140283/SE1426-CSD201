/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiep
 */
public class DoubleLinkedList {
    public static class Node<Entry>{
        private Entry element;  //reference to the element stored at this node
        private Node<Entry> prev;//reference to the previous node in the list
        private Node<Entry> next;//reference to the subsequent node in the list
        public Node(Entry e,Node<Entry> p,Node<Entry> n){
            element =e;
            prev=p;
            next=n;
        }
        public Entry getElement(){
            return element;
        }
        public Node<Entry> getPrev(){
            return prev;
        }
        public Node<Entry> getNext(){
            return next;
        }
        public void setPrev(Node<Entry> p){
            prev=p;
        }
        public void setNext(Node<Entry> n){
            next=n;
        }
    }
    // instance variables of the DoubleLinkedList
    private Node<Entry> header; //header sentinel
    private Node<Entry> trailer;// trailer sentinel
    private int size=0;     // number of the elements in the list
    //Constructs a new empty list
    public DoubleLinkedList(){
        header=new Node<>(null,null,null); //create header
        trailer=new Node<>(null,header,null);//trailer is preceded by header
        header.setNext(trailer);//header is followed by trailer
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    //return but not remove the fist element of the list
    public Entry first(){
        if(isEmpty()) return null ;
        return header.getNext().getElement();
    }
    //return but do not remove the last element of the list
    public Entry last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    //public update method
    // add element to the front of the list
    public void addFrist(Entry e){
        addBetween(e,header,header.getNext());
    }
    //add element e to the end of the list
    public void addLast(Entry e){
        addBetween(e,trailer.getPrev(),trailer);
    }
    //remove and returns the fisrt element of the list
    public Entry removeFirst(){
        if(isEmpty()) return null; //nothing to remove
        return remove(header.getNext()); //first element is before header
    }
    public Entry removeLast(){
        if(isEmpty()) return null;//nothing to remove
        return remove(trailer.getPrev());//last element is before trailer
    }
    //add element e to the linked list in between the given nodes
    private void addBetween(Entry e,Node<Entry> predecessor,Node<Entry> successor){
        Node<Entry> newest=new Node<>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    //Remove the given node from the list and returns its element
    private Entry remove(Node<Entry> node){
        Node<Entry> predecessor=node.getPrev();
        Node<Entry> successor=node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}

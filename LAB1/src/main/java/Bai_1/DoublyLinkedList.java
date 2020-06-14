/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

/**
 *
 * @author Dell
 */
public class DoublyLinkedList<Infor> {
    private static class Node<Infor>{
        private Infor element;
        private Node<Infor> prev;
        private Node<Infor> next;
        public Node(Infor i, Node<Infor> p, Node<Infor> n){
            element=i;
            prev=p;
            next=n;
        }
        public Infor getElement(){
            return element;
        }
        public Node<Infor> getPrev(){
            return prev;
        }
        public void setPrev(Node<Infor> p){
            prev=p;
        }
        public Node<Infor> getNext(){
            return next;
        }
        public void setNext(Node<Infor> n){
            next=n;
        }
    }
    private Node<Infor> header;
    private Node<Infor> trailer;
    private int size=0;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Node<Infor> getHeader() {
        return header;
    }

    public void setHead(Node<Infor> header) {
        this.header = header;
    }

    public Node<Infor> getTrailer() {
        return trailer;
    }

    public void setTail(Node<Infor> tail) {
        this.trailer = trailer;
    }

    public DoublyLinkedList(Node<Infor> head, Node<Infor> tail) {
        this.header = header;
        this.trailer = trailer;
    }
    public DoublyLinkedList(){
        header = trailer = null;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public Infor first(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }
    public Infor last(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }
    
    private void addBetween(Infor newNode, Node<Infor> predecessor, Node<Infor> successor){
        Node<Infor> newest= new Node<>(newNode,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private Infor delete(Node<Infor> node){
        Node<Infor> predecessor= node.getPrev();
        Node<Infor> successor= node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public void addFirst(Infor newNode){
        addBetween(newNode,header,header.getNext());
    }
    public void addLast(Infor newNode){
        addBetween(e,trailer.getPrev(),trailer);
    }
    public Infor deleteFirst(){
        if(isEmpty()){
            Syste.out.println("Empty");
        }
        return delete(header.getNext());
    }
    public Infor deleteLast(){
        if(isEmpty()){
            System.out.println("Empty");
        }
        return delete(trailer.getPrev());
    }
}

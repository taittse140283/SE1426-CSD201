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
public class DoublyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E element, Node<E> prev, Node<Infor> n){
            element=i;
            prev=p;
            next=n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getPrev(){
            return prev;
        }
        public void setPrev(Node<E> p){
            prev=p;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n){
            next=n;
        }
    }
    private Node<E> header;
    private Node<E> trailer;
    private int size=0;
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public Node<E> getHeader() {
        return header.getNext();
    }

    public void setHeader(Node<E> header) {
        this.header = header;
    }

    public Node<E> getTrailer() {
        return trailer.getPrev();
    }

    public void setTrailer(Node<E> trailer) {
        this.trailer = trailer;
    }

    public DoublyLinkedList(){
        header = new Node<>(null,null,null);
        trailer= new Node<>(null, header, null);
        header.setNext(trailer);
        size=0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E getFirst(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }
    public E getLast(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getElement();
    }
    
    private void addBetween(E e, Node<E> predecessor, Node<E> successor){
        Node<E> newest= new Node<>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private E delete(Node<E> node){
        Node<E> predecessor= node.getPrev();
        Node<E> successor= node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }
    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }
    public E deleteFirst(){
        if(isEmpty()){
            Syste.out.println("Empty");
        }
        return delete(header.getNext());
    }
    public E deleteLast(){
        if(isEmpty()){
            System.out.println("Empty");
        }
        return delete(trailer.getPrev());
    }
    public E get(int index){
       if(size==0){
           System.out.println("Empty");
       } else{
           Node<E> step = header.getNext();
            for (int i = 0; ((step) != null) && (i < index); i++) {
                step = step.getNext();
            }
            if (step != null) {
                return step.getElement();
            }
       }
        return null;
}
   public void removePos(int n) {
        if(size == 0 || n<0){
                System.out.println("Error: No element in list or error index");
            }
        Node<E> step = header.getNext(); 
        for (int i = 0; (step != null) && (i < n); i++) { 
            step = step.getNext();
        }
        if (step == null) {
            return;
        }
        remove(step);
}

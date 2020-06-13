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
        public Node(E e, Node<E> p, Node<E> n){
            element=e;
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
    public DoublyLinkedList(){
        header= new Node<>(null,null,null);
        trailer= new Node<>(null,header,null);
        header.setNext(trailer);
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E first(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getElement();
    }
    public E last(){
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
            return null;
        }
        return delete(header.getNext());
    }
    public E deleteLast(){
        if(isEmpty()){
            return null;
        }
        return delete(trailer.getPrev());
    }
}
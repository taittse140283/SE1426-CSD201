/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thuan Le
 */
public class DoublyLinkedList<E> {
    private static class Node<E>{
        private E element;
        private Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }
        
    }
    
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;
    
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    public int size(){ return size;}
    
    public boolean isEmpty(){ return size ==0;}
    
    
    public E first(){
        if(isEmpty())   return null;
        return header.getNext().getElement();
    }
    
    public E last(){
        if(isEmpty()) return null;
        return trailer.getNext().getElement();
    }
    private void addBetween(E element, Node<E> predecessor, Node<E> successor){
        Node<E> newest = new Node<>(element, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    public void addFirst(E element){
        addBetween(element, header, header.getNext());
    }
    
    public void addLast(E element){
        addBetween(element, trailer.getPrev(), trailer);
    }
    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    
    public E removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    
    public E removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}

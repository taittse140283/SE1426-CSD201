/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList<E> {

    // khai báo class Node
    private static class Node<E> {

        private E element; // tham chiếu giá trị lưu trữ trong nodde
        private Node<E> next; // tham chiếu giá trị tiếp theo
        private Node<E> prev; // tham chiếu giá trị sau đó

        public Node(E e, Node<E> n, Node<E> p) {
            this.element = e;
            this.next = n;
            this.prev = p;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoublyLinkedList() {
        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.setNext(trailer);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getElement();
    }
    public E last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }
    private void addBetween(E e, Node<E>  predecessor, Node<E> successor){
        Node<E> newest = new Node<>(e,predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    
    public void addFirst(E e){
        addBetween(e,header,header.getNext());
    }
    public void addLast(E e){
        addBetween(e,trailer.getPrev(),trailer);
    }
}

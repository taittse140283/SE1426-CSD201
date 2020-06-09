/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author Asus
 */
public class DBLinkedList {
    private static class Node<E>{
        private Node<E> prev;
        private Node<E> next;
        private E e;
        public Node(Node<E> prev, Node<E> next, E e) {
            this.prev = prev;
            this.next = next;
            this.e = e;
        }

        public Node() {
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }
    }
    private Node header;
    private Node trailer;
    private int size = 0;

    public DBLinkedList() {
        header= new Node(null,null,null);
        trailer=new Node(null,null,null);
        header.setNext(trailer);
    }
    
}

package Bai1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrinhAnhTai
 */
public class Node<E>  {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        /*
            Return data of Node
         */
        public E getElement() {
            return data;
        }

        /*
            Return Node is in front of it
         */
        public Node<E> getPrev() {
            return prev;
        }

        /*
            Return Node is behind it
         */
        public Node<E> getNext() {
            return next;
        }

        /*
            Create previous Node with param is specific Node
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /*
            Create next Node with param is specific Node
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 *
 * @author W10
 * This class is implemented as double link list to display Player
 * @param <E>
 */
public class DoublyLinkedList <E> {
    /**
     * Tao class Node, Phan tu (element) de mapping Player
     * 
     */
    private class Node<E> {
        private E elemt;//tao phan tu
        private Node<E> next;
        private Node<E> previous;
        
        //constructor
        public Node(E elemt, Node<E> next, Node<E> previous) {
            this.elemt = elemt;
            this.next = next;
            this.previous = previous;
        }

        //getter,setter
        public E getElemt() {
            return elemt;
        }

        public void setElemt(E elemt) {
            this.elemt = elemt;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
        
    }
    private Node<E> head;
    private Node<E> trail;
    private int size = 0;

    /*
        Create pointer
    */
    public DoublyLinkedList() {
        head = new Node<>(null,null,null);
        trail = new Node<>(null,head,null);
        head.setNext(trail);
    }

    /*
        Getter setter of pointer
    */
    public Node<E> getHead() {
        return head.getNext();
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTrail() {
        return trail.getPrevious();
    }

    public void setTrail(Node<E> trail) {
        this.trail = trail;
    }
    
    /*
        Return 0 if the list is empty
    */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /*
        Display first element of list
    */
    public E getFirst(){
        if (isEmpty()) {
            return null;
        }
        return head.getNext().getElemt();
    }
    
    /*
        Display last element of list
    */
    public E getLast(){
        if (isEmpty()) {
            return null;
        }
        return trail.getPrevious().getElemt();
    }
    
    /*
        Add element between Node in link list
    */
    public void addBetween(E Element, Node<E> truoc, Node<E> sau){
      
        Node<E> newNode= new Node<>(Element,truoc,sau);
        truoc.setNext(newNode);
        sau.setPrevious(newNode);
        size++;
        
    } 
    
    /**
     * Delete node of link list
     * @param node
     * @return 
     */
    private E remove(Node<E> node) {
        Node<E> sau = node.getNext();
        Node<E> truoc = node.getPrevious();
        truoc.setNext(sau);
        sau.setPrevious(truoc);
        size--;
        return node.getElemt();
    }
    
    /**
     * Them phan tu dau danh sach
     * @param e 
     */
    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }

    /**
     * Them phan tu cuoi danh sach
     * @param e 
     */
    public void addLast(E e) {
        addBetween(e, trail.getPrevious(), trail);
    }

    /**
     * Xoa phan tu dau tien cua danh sach
     * @return 
     */
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(head.getNext());
    }

    /**
     * Xoa phan tu cuoi cua danh sach
     * @return 
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trail.getPrevious());
    }
}

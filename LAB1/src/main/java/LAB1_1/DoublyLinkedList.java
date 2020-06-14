/*
 * To change this license head, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;


/**
 *
 * @author Admin
 */
public class DoublyLinkedList<E> extends MyAbstractList<E>{
    
    /**
     * Create Class Node
     * @param <E> 
     */
    public static class Node<E> {
        E element;
        Node<E> next;
        public Node(E element) {
            this.element = element;
        }
    }
    private Node<E> head;
    private Node<E> tail;
    
    /**
     * Returns top element in the list
     * @return 
     */
    public E getFirst(){
        if(size ==0){
            return null;
        } else {
            return head.element;
        }
    }
    
    /**
     * Returns last element in the list
     * @return 
     */
    public E getLast(){
        if(size ==0){
            return null;
        } else {
            return tail.element;
        }
    }
    
    /**
     * Add an element to the beginning of the list
     * @param index
     * @param e 
     */
    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node<E>(e); //Create a newNode
        newNode.next = head; // Attach newNode with head
        head = newNode; // head point to the newNode
        size++; // Icrease size
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object set(int index, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
    


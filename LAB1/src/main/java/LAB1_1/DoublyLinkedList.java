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
     * @param e element
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<E>(e); //Create a newNode
        newNode.next = head; // Attach newNode with head
        head = newNode; // head point to the newNode
        size++; // Icrease size
        if(tail == null){ // the newNode is the only node in list
            tail = head; 
        }
    }
    
    /**
     * Add an element to the end of the list 
     * @param e element
     */
    public void addLast(E e){
        Node<E> newNode = new Node<E>(e); //Create a newNode
        tail.next = newNode; // Attach newNode with head
        tail = tail.next; // tail point to the last node
        size++; // Icrease size
    }
    
    /**
     * Add a new element at the specified index in this list
     * @param index  index of the head element is 0
     * @param e element
     */
    @Override
    public void add (int index, E e){
        if(index == 0){
            addFirst(e);
        } else if (index >= size){
            addLast(e);
        } else {
            Node<E> current =head;
            for (int i=1 ; i< index; i++){
                current = current.next;
            }
        }
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
    


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
public class DoublyLinkedList<E>{
    
    /**
     * Create Class Node
     * @param <E> 
     */
    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        public Node(E element) {
            this.element = element;
        }

        public Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
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
    private Node<E> head;
    private Node<E> tail;
    public int size;
    
    /**
     * Create a default list
     */
    public DoublyLinkedList() {
        this.head = new Node<E>(null, null, null);
        this.tail = new Node<E>(null, null, this.head);
        this.head.setNext(this.tail);
    }

    
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
    
    /**
     * Remove the head node and 
     * @return  return the object that is contained in the removed node
     */
    public E removeFirst() {
        if (size == 0) {  // if list is empty, return null
            return null;
        } else {
            Node<E> temp = head;
            head = head.next;
            size--;
            if (head == null) {
            tail = null;
            }
            return temp.element;
        }
    }
    /**
     * Remove the last node and
     * @return return the object that is contained in the removed node.
     */
    public E removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            Node<E> temp = head;
            head = tail = null;
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;
            for (int i = 0; i < size - 2; i++) {
            current = current.next;
            }
            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }
    
    /**
     * Remove the element at the specified position in this list.
     * @param index
     * @return Return the element that was removed from the list. 
     */
    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;
            for (int i = 1; i < index; i++) {
            previous = previous.next;
            }
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }
    
    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public boolean contains(E e) {
        return this.indexOf(e)>=0;
    }

    @Override
    public E get(int index) {
        if(size == 0){
            return null;
        }
        if(index >=this.size){
            index = this.size -1;
        }
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.element;
    }

    @Override
    public int indexOf(E e) {
        Node current = this.head;
        for (int i = 0; i < this.size; i++) {
            if(current.element.equals(e)){
                return i;
            }
            current = current.next;
        }
        return -1;
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
    public Object set(int index, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override 
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null) {
            result.append(", "); // Separate two elements with a comma
            } else {
            result.append("]"); // Insert the closing ] in the string
            }
        }
        return result.toString();
    }
}
    


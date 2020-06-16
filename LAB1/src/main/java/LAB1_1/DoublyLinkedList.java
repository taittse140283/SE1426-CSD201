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

    
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){
        return this.size ==0;
    }
    /**
     * Returns top element in the list
     * @return 
     */
    public E getFirst(){
        if(isEmpty()){
            return null;
        } else {
            return this.head.getNext().getElement();
        }
    }
    
    /**
     * Returns last element in the list
     * @return 
     */
    public E getLast(){
        if(isEmpty()){
            return null;
        } else {
            return this.tail.getPrev().getElement();
        }
    }
    
    private void add(E e, Node<E> forward, Node<E> back){
        Node<E> newNode = new Node<E>(e, forward, back); //Create a newNode
        forward.setPrev(back);// Set prev of forward is new node
        back.setNext(forward);// Set next of back is new node
        size++; //Increase size
    }
    /**
     * Add an element to the beginning of the list
     * @param e element
     */
    public void addFirst(E e) {
        this.add(e, this.head.getNext(), this.tail);
    }
    
    /**
     * Add an element to the end of the list 
     * @param e element
     */
    public void addLast(E e){
        this.add(e, this.head, this.tail.getPrev());
    }
    
    /**
     * Add a new element at the specified index in this list
     * @param index  index of the head element is 0
     * @param e element
     */
    public void addIndex (int index, E e){
        if(index == 0){
            addFirst(e);
        } else if (index >= this.size){
            addLast(e);
        } else {
            Node<E> current = this.head;
            for (int i=1 ; i< index; i++){
                current = current.getNext();
            }
        }
    }
    
    /**
     * Remove the head node and 
     * @return  return the object that is contained in the removed node
     */
    public E removeFirst() {
        if (isEmpty()) {  // if list is empty, return null
            return null;
        } else {
            Node<E> temp =  this.head;
            this.head = this.head.getNext();
            size--;
            if (head == null) {
            tail = null;
            }
            return temp.getElement();
        }
    }
    /**
     * Remove the last node and
     * @return return the object that is contained in the removed node.
     */
    public E removeLast() {
        if (isEmpty()) {
            return null;
        } else if (size == 1) {
            Node<E> temp = this.head;
            clear();
            size = 0;
            return temp.getElement();
        } else {
            Node<E> current = this.head;
            for (int i = 0; i < this.size - 2; i++) {
            current = current.getNext();
            }
            Node<E> temp = this.tail;
            this.tail = current;
            this.tail.next = null;
            size--;
            return temp.getElement();
        }
    }
    
    /**
     * Remove the element at the specified position in this list.
     * @param index
     * @return Return the element that was removed from the list. 
     */
    public E removeIndex(int index) {
        if (index < 0 || index >= this.size) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == this.size - 1) {
            return removeLast();
        } else {
            Node<E> previous = this.head;
            for (int i = 1; i < index; i++) {
            previous = previous.getNext();
            }
            Node<E> current = previous.getNext();
            previous = current;
            size--;
            return current.element;
        }
    }
    
    public void clear() {
        this.head = this.tail = null;
    }

    public boolean contains(E e) {
        return this.indexOf(e)>=0;
    }

    public E get(int index) {
        if(size == 0){
            return null;
        }
        if(index >=this.size){
            index = this.size -1;
        }
        Node<E> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return (E) current.getElement();
    }

    public int indexOf(E e) {
        Node<E> current = this.head;
        for (int i = 0; i < this.size; i++) {
            if(current.getElement().equals(e)){
                return i;
            }
            current = current.getNext();
        }
        return -1;
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
    


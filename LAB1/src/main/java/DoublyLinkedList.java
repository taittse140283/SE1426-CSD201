/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thuan Le
 */
public class DoublyLinkedList<User> {
    /**
     * Nested Node class
     * Reference to the element stored at this node
     * Reference to the previous node in the list
     * Reference to the subsequent node in the list
     * @param <User> 
     */
    private static class Node<User>{
        private User element;
        private Node<User> next;
        private Node<User> prev;

        public Node(User element, Node<User> prev, Node<User> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public User getElement() {
            return element;
        }

        public void setElement(User element) {
            this.element = element;
        }

        public Node<User> getNext() {
            return next;
        }

        public void setNext(Node<User> next) {
            this.next = next;
        }

        public Node<User> getPrev() {
            return prev;
        }

        public void setPrev(Node<User> prev) {
            this.prev = prev;
        }
        
    }
    /**
     * Instance variables of the DoublyLinkedList
     * Header sentinel
     * Trailer sentinel
     * Size is number of elements in the list
     */
    private Node<User> header;
    private Node<User> trailer;
    private int size = 0;
    
    /**
     * Constructs a new empty list
     * Create header
     * Trailer is preceded by header
     * Header is followed by trailer
     */
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    /**
     * 
     * @return the number of elements in the linked list
     */
    public int size(){ return size;}
    
    /**
     * Test whether the linked list is empty
     * @return 
     */
    public boolean isEmpty(){ return size ==0;}
    
    /**
     * 
     * @return (not remove) the first element of list
     */
    public User first(){
        if(isEmpty())   return null;
        return header.getNext().getElement();
    }
    /**
     * 
     * @return (not remove) the last element of list
     */
    public User last(){
        if(isEmpty()) return null;
        return trailer.getNext().getElement();
    }
    
    /**
     * Adds element to the linked list in the between the given nodes
     * @param element
     * @param predecessor
     * @param successor 
     */
    private void addBetween(User element, Node<User> predecessor, Node<User> successor){
        Node<User> newest = new Node<>(element, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    /**
     * Add element to the front of the list
     * @param element 
     */
    public void addFirst(User element){
        addBetween(element, header, header.getNext());
    }
    
    /**
     * Add element to the end of the list
     * @param element 
     */
    public void addLast(User element){
        addBetween(element, trailer.getPrev(), trailer);
    }
    
    /**
     * Removes the given node from the list and returns its element
     * @param node
     * @return 
     */
    private User remove(Node<User> node){
        Node<User> predecessor = node.getPrev();
        Node<User> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    /**
     * Removes and returns the first element of the list
     * @return 
     */
    public User removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    
    /**
     * Removes and returns the last element of the list
     * @return 
     */
    public User removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}

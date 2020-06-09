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
    
    private Node<User> header;
    private Node<User> trailer;
    private int size = 0;
    
    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    
    public int size(){ return size;}
    
    public boolean isEmpty(){ return size ==0;}
    
    
    public User first(){
        if(isEmpty())   return null;
        return header.getNext().getElement();
    }
    
    public User last(){
        if(isEmpty()) return null;
        return trailer.getNext().getElement();
    }
    private void addBetween(User element, Node<User> predecessor, Node<User> successor){
        Node<User> newest = new Node<>(element, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    public void addFirst(User element){
        addBetween(element, header, header.getNext());
    }
    
    public void addLast(User element){
        addBetween(element, trailer.getPrev(), trailer);
    }
    private User remove(Node<User> node){
        Node<User> predecessor = node.getPrev();
        Node<User> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
    
    public User removeFirst(){
        if(isEmpty()) return null;
        return remove(header.getNext());
    }
    
    public User removeLast(){
        if(isEmpty()) return null;
        return remove(trailer.getPrev());
    }
}

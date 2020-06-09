/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lehie
 */
public class SinglyLinkedList<E> {
    private class Node {
        private E value;
        private Node next;
        
        //Constructor 
        public Node (E value, Node node) {
            this.value = value;
            this.next = node;
        }
    }
    
    private Node head = null;
    private Node tail = null;
    public SinglyLinkedList() {}

    private Node getLastNode() {
        Node result = null;
        for(Node n = head; n != null; n=n.next) result = n;
        return result;
    }
}

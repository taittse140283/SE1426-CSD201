/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 *
 * @author TrinhAnhTai
 * 
 */
public class DoublyLinkedList {
    //* This is a nested class*/
    private class Node {
        private int value;
        private Node next;
        private Node prev;
        //* Constructor of class Node */
        public Node (int value, Node next_node, Node prev_node) {
            this.value = value;
            this.next = next_node;
            this.prev = prev_node;
        }
    }   
    private Node header;
    private Node trailer;
    //* Constructor of class DoublyLinkedList */
    public DoublyLinkedList() {
        header = new Node(Integer.MIN_VALUE, null, null); //
        trailer = new Node(Integer.MIN_VALUE,null, header);
        header.next = trailer;
    }
}

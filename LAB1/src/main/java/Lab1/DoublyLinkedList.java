/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList {
    Node head;
    /*Double Linked List Node*/
    class Node{
        int data;
        Node next;
        Node previous;
        /* Constructor để tạo node */
        public Node(int data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
        
    }
}

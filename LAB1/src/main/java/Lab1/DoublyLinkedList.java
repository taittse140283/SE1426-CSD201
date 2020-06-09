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
    Node tail;

    public DoublyLinkedList(){
        head = tail = null;
    }
    public boolean isEmpty(){
        return head == null;
    }
}

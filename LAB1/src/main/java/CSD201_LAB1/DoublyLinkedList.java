/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

/**
 *
 * @author truong
 */
public class DoublyLinkedList {
    private class Node{
        private double point;
        private Node next;
        private Node prev;
        public Node(double point, Node next_node,Node prev_mode){
            this.point=point;
            this.next=next_node;
            this.prev=prev_mode;
        }
    }
    private Node header;
    private Node trailer;
    
    
    
}

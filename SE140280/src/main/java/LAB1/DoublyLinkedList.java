package LAB1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZunPeter
 */
public class DoublyLinkedList {
    private class Node{
        private int value;
        private Node next;
        private Node prev;
        public Node (int value, Node next_node, Node prev_node){
            this.value = value;
            this.next = next_node;
            this.prev = prev_node;
        }  
    }
    private Node header;
    private Node trailer;
    public DoublyLinkedList(){
        header = new Node(Integer.MIN_VALUE, null, null);
        trailer = new Node(Integer.MAX_VALUE, header, null);
        header.next = trailer;
    }
    
}


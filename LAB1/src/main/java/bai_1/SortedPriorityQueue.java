/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 *
 * @author Linh
 */
public class SortedPriorityQueue {
    Node head, tail;

    public SortedPriorityQueue() {
        head = tail = null;
    }
    
    //Using method addLast of DoublyLinkedList
    public void addLast(String email, int point) {
        Player p = new Player(email, point); //Create a new player
        Node newNode = new Node(p, head, tail); //Create new node stores player info
        
        //This code will execute if nothing in queue
        if(head == null) {
            head = newNode;
            tail = newNode;
            head.setPrev(null);
            tail.setNext(null);
            return;
        }
        //Oppositely, this code will add new node at the of last queue
        else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
            tail.setNext(null);
        }
    }
    
    //Print to the screen for testing
    public void print() {
        for(Node n = head; n != null; n = n.getNext())
            System.out.println(n.getInfo().getEmail() + " - " + n.getInfo().getPoint());
    }
}

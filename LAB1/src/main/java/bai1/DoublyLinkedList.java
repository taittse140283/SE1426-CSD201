/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author Admin
 */
/**
 * Doubly Linked List implementation
 */
public class DoublyLinkedList {
    private DLLNode<Player> header;//reference to the first node of the list
    private DLLNode<Player> trailer;//reference to the last node of the list
    //contructor
    public DoublyLinkedList() {
        header= new DLLNode<>(null,null,null);
        trailer=new DLLNode<>(null, header, null);
        header.setNext(trailer);
    }
    /**
     * Insert new Node into list(any position)
     * @param info
     * @param prev
     * @param next 
     */
    private void addBetween(Player info, DLLNode front, DLLNode back)
    {
        DLLNode<Player> newest=new DLLNode<Player>(info, front, back);//create a new node
        front.setNext(newest);//set Node next of front reference to newest Node
        back.setPrev(newest);//set Node prev of back reference to newest Node
    }
    
}

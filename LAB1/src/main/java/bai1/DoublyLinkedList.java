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
    private int size=0;
    //contructor
    public DoublyLinkedList() {
        header= new DLLNode<>(null,null,null);
        trailer=new DLLNode<>(null, header, null);
        header.setNext(trailer);
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    
    private void addFirst(Player info)
    {
        DLLNode newest=new DLLNode();//create new node
        newest.setInfo(info);//set info
        newest.setNext(header);//set next of newest reference to header
        if(size==0)//if list is empty
            header=trailer=newest;//set header and trailer are newest
        else
        {
            header.setPrev(newest);//set previous of header reference to newest 
            header=newest;//newest become the header
        }
        size++;//increasing size of the list
    }
    
}

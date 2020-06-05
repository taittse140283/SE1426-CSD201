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
    //change to default(be used to this way =))))))))
    public DoublyLinkedList() {
        header = trailer = null;
        size = 0;
    }
    public boolean isEmpty()
    {
        return size==0;
    }
    /**
     * Get information of header node
     * @return information of header node
     */
    public Player getHeaderInfo()
    {
        return header.getInfo();
    }
    /**
     * Insert new node into list at first position
     * @param info 
     */
    public void addFirst(Player info)
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
    /**
     * Insert new node into list at last position
     * @param info 
     */
    public void addLast(Player info)
    {
        DLLNode newest=new DLLNode();//create new node
        newest.setInfo(info);//set info 
        newest.setPrev(trailer);//set prev of newest reference to trailer
        newest.setNext(null);//set next of newest refernce to null(next of trailer reference to null )
        if(size==0)//if list is empty
        {
            header=trailer=newest;//set header and trailer are newest
        }
        else
        {
            trailer.setNext(newest);//set next of trailer reference to newest
            trailer=newest;//set newest become trailer
        }
        size++;//increading size of the list
    }
    /**
     * Remove first node in the list
     * @return info of the node be removed
     */
    public Player removeFirst() 
    {
        if (isEmpty()) {//is list is empty
            System.out.println("Error:Empty list");//print error
        }
        else
        {
            Player value=header.getInfo();//get info of the node be removed
            header=header.getNext();//set header reference to next of header
            size--;//decrease size of the list
            if(size==0)//if clear all node
            {
                header=trailer=null;//set header and trailer to be null(cause there's no more node)
            }
            return value;//return info of the node be removed
        }
        return null;
    }
    
    
}

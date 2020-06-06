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
public class DoublyLinkedList<Player> {
    private DLLNode<Player> header;//reference to the first node of the list
    private DLLNode<Player> trailer;//reference to the last node of the list
    private int size=0;
    
    //contructor
    //change to default(be used to this way =))))))))
    public DoublyLinkedList() {
        header = trailer = null;
        size = 0;
    }

    public DLLNode<Player> getHeader() {
        return header;
    }

    public void setHeader(DLLNode<Player> header) {
        this.header = header;
    }

    public DLLNode<Player> getTrailer() {
        return trailer;
    }

    public void setTrailer(DLLNode<Player> trailer) {
        this.trailer = trailer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty()
    {
        return size==0;
    }
    /**
     * Get information of header
     * @return information of header
     */
    public Player getHeaderInfo()
    {
        return header.getInfo();
    }
    
    /**
     * Insert new node into list at first position
     * @param newest 
     */
    public void addFirst(DLLNode<Player> newest)
    {
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
    public void addLast(DLLNode<Player> newest)
    {
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
     * Remove first node from list
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
    /**
     * Remove a node
     * @param deleteNode
     * @return info of the node be removed
     */
    public Player remove(DLLNode<Player> deleteNode)
    {
        if (isEmpty()) {//is list is empty
            System.out.println("Error:Empty list");//print error
        }
        else
        {
            Player value=deleteNode.getInfo();//get info odd the node be removed
            //link 2 node that the removed node places between
            deleteNode.getPrev().setNext(deleteNode.getNext());
            deleteNode.getNext().setPrev(deleteNode.getPrev());
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

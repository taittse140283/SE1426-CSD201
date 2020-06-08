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
 * Fields of DoublyLinkedList: DLLNode<Player> header, DLLNode<Player> trailer, int size
 */
public class DoublyLinkedList<Player> {

    private DLLNode<Player> header;//reference to the first node of the list
    private DLLNode<Player> trailer;//reference to the last node of the list
    private int size = 0;

    //contructor
    //change to default(be used to this way =))))))))

    /**
     * Default Constructor of DoublyLinkedList with header, trailer are null and size =0
     */
    public DoublyLinkedList() {
        header = trailer = null;
        size = 0;
    }

    /**
     *Getter, setter of DoublyLinkedList fields
     */
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

    /**
     * Check if the list is empty
     * @return true if size=0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * This method gets information of header
     * @return Player of DLLNode<Player> header
     */
    public Player getHeaderInfo() {
        return header.getInfo();
    }

    /**
     * This method inserts new node into list at first position
     *
     * @param newest This is DLLNode will be added at first position
     * @return nothing
     */
    public void addFirst(DLLNode<Player> newest) {
        newest.setNext(header);//set next of newest reference to header
        header.setPrev(newest);//set previous of header reference to newest 
        header = newest;//newest become the header
        size++;//increasing size of the list
    }

    /**
     *This methods inserts new node into list at last position
     *
     * @param newest This is DLLNode will be added at last position
     */
    public void addLast(DLLNode<Player> newest) {
        newest.setPrev(trailer);//set prev of newest reference to trailer
        newest.setNext(null);//set next of newest refernce to null(next of trailer reference to null )
        if (size == 0)//if list is empty
        {
            header = trailer = newest;//set header and trailer are newest
        } else {
            trailer.setNext(newest);//set next of trailer reference to newest
            trailer = newest;//set newest become trailer
        }
        size++;//increading size of the list
    }

    /**
     * This method removes first node from list
     *
     * @return Player of the node be removed
     */
    public Player removeFirst() {
        if (isEmpty()) {//is list is empty
            System.out.println("Error:Empty list");//print error
        } else {
            Player value = header.getInfo();//get info of the node be removed
            header = header.getNext();//set header reference to next of header
            size--;//decrease size of the list
            if (size == 0)//if clear all node
            {
                header = trailer = null;//set header and trailer to be null(cause there's no more node)
            }
            return value;//return info of the node be removed
        }
        return null;
    }

    /**
     * This methods removes a DLLNode
     *
     * @param deleteNode DLLNode<Player> will be removed
     * @return Player of the node be removed
     */
    public Player remove(DLLNode<Player> deleteNode) {
        if (isEmpty()) {//is list is empty
            System.out.println("Error:Empty list");//print error
        } else {
            Player value = deleteNode.getInfo();//get info odd the node be removed
            //link 2 node that the removed node places between
            deleteNode.getPrev().setNext(deleteNode.getNext());
            deleteNode.getNext().setPrev(deleteNode.getPrev());
            size--;//decrease size of the list
            if (size == 0)//if clear all node
            {
                header = trailer = null;//set header and trailer to be null(cause there's no more node)
            }
            return value;//return info of the node be removed
        }
        return null;
    }

}

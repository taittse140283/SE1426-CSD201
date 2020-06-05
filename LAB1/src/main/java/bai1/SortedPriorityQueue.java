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
public class SortedPriorityQueue {
    private DoublyLinkedList<Player> list=new DoublyLinkedList();
    /**
     * Add new node into queue which sort by point of Player
     * @param newest 
     */
    public void add(DLLNode<Player> newest)
    {
        //The header has the greatest point of Player 
        if(newest.getInfo().getPoint()>list.getHeader().getInfo().getPoint())//compare with header, 
            //if point of Player in newest Node greater than point of Player in header Node
            //then add it at first position of the list
        {
            list.addFirst(newest);
        }
        //The trailer has the lowest point of Player
        else if(newest.getInfo().getPoint()<list.getTrailer().getInfo().getPoint())//compare with trailer
            //if point of Player in newest Node lower than point of Player in trailer Node
            //then add it at last position of the list
        {
            list.addLast(newest);
        }
        else
        {
            DLLNode<Player> temp=list.getHeader();
            //find the position can insert new node
            while(temp.getInfo().getPoint()>newest.getInfo().getPoint())
            {
                temp=temp.getNext();
            }
            //new node is inserted in front of temp  
            (temp.getPrev()).setNext(newest);
            newest.setPrev(temp.getPrev());
            temp.setPrev(newest);
            newest.setNext(temp);
            list.setSize(list.getSize()+1);
        }
    }
    /**
     * Remove Player has highest point in the list
     * @return Player be removed
     */
    public Player removeMax()
    {
        return list.removeFirst();
    }
    /**
     * Get Player has highest point in the list
     * @return Player has highest point in the list
     */
    public Player getMax()
    {
        return list.getHeaderInfo();
    }
    
}

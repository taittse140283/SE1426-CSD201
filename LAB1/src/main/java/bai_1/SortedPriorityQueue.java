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
    
    //Add new node into the queue and sort it
    public void addNewPlayer(String email, int point) {
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
        
        sortPlayerBasedOnPoint(newNode);
    }
    
    /**
     * Sort a new player into suitable position in order descending
     * I use the point of each player as their rank, the higher the point, the higher the rank
     * @param newNode 
     */
    public void sortPlayerBasedOnPoint(Node newNode) {
        //I use the point of player as rank of them
        //Based on their rank, i can sort the position of them in the queue
        int rank = newNode.getInfo().getPoint();
        
        //if the rank of newest player higher than the biggest point
        //I add new node to the first of queue
        if(rank > getMaxPoint()) {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
            head.setPrev(null);
        }
        else {
            //I use loop to find the position for new node player
            for(Node n  = tail; n != null; n = n.getPrev()) {
                
                //If the newest point is smaller or equal than the smallest point
                //I add new node to the last of queue
                if(rank <= getMinPoint()) {
                    tail.setNext(newNode);
                    newNode.setPrev(tail);
                    tail = newNode;
                    tail.setNext(null);
                    return;
                }
                
                //In other case, I add new node into one suitable position
                //Behind the node has higher point and in front of the node has smaller point
                else if(rank <= n.getInfo().getPoint()) {
                    Node nodeAfter = n.getNext();
                    nodeAfter.setPrev(newNode);
                    newNode.setNext(nodeAfter);
                    newNode.setPrev(n);
                    n.setNext(newNode);
                    return;
                }
            }
        }
    }
    
    /**
     * @return the biggest point
     */
    public int getMaxPoint() {
        return head.getInfo().getPoint();
    }
    
    /**
     * @return the smallest point
     */
    public int getMinPoint() {
        return  tail.getInfo().getPoint();
    }
    
    //Remove the player has the biggest point
    public void removePlayerHasBiggestPoint() {
        head = head.getNext();
        head.setPrev(null);
    }
    
    /**
     * Find the node stores info of player based on email
     * @param email
     * If email exist in queue
     * @return n
     * If email is not exist in queue
     * @return null
     */
    public Node search(String email) {
        for(Node n = head; n != null; n = n.getNext())
            if(n.getInfo().getEmail().equalsIgnoreCase(email)){
                return n;
            }
        return null;
    }
    
    //Print to the screen for testing
    public void print() {
        for(Node n = head; n != null; n = n.getNext())
            System.out.println(n.getInfo().getEmail() + " - " + n.getInfo().getPoint());
    }
}

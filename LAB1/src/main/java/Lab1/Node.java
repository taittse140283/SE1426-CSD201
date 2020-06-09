/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author Admin
 */
public class Node<Player> {
    Player data;
    Node<Player> next;
    Node<Player> previous;
    
    /**
     * next and previous variables are set to null
     * @param data 
     */
    public Node(Player data){
        this(data, null, null);
    }
    
    /**
     * Constructor
     * @param data
     * @param next
     * @param previous 
     */
    
    public Node(Player data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public Player getData() {
        return data;
    }

    public void setData(Player data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    
}

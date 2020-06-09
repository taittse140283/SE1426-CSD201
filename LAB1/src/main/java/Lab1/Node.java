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

    /**
     * Getter, setter
     * @return 
     */
    public Player getData() {
        return data;
    }

    public void setData(Player data) {
        this.data = data;
    }

    public Node<Player> getNext() {
        return next;
    }

    public void setNext(Node<Player> next) {
        this.next = next;
    }

    public Node<Player> getPrevious() {
        return previous;
    }

    public void setPrevious(Node<Player> previous) {
        this.previous = previous;
    }
    
}

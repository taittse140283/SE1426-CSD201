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

//Each node stores 1 info of one player
public class Node {
    private Player info;
    private Node next, prev;
    
    //Constructor
    public Node(Player info, Node next, Node prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    //Getters and setters
    public Player getInfo() {
        return info;
    }

    public void setInfo(Player info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

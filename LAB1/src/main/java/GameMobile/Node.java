/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMobile;

/**
 *
 * @author Loi Lam
 */
public class Node {

    private Player info;
    private Node next, prev;

    //Constructor no parameters
    public Node() {
    }

    //Constructor have parameters
    public Node(Player info, Node next, Node prev) {
        this.info = info;
        this.next = next;
        this.prev = prev;
    }

    // getter and setter
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

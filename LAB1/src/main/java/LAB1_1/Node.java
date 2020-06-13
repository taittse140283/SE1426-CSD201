/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author TAN
 */
public class Node<Player> {

    private Player info;
    private Node<Player> prev;
    private Node<Player> next;

    public Node() {
    }
    
    public Node(Player info, Node<Player> prev, Node<Player> next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public Player getInfo() {
        return info;
    }

    public void setInfo(Player info) {
        this.info = info;
    }

    public Node<Player> getPrev() {
        return prev;
    }

    public void setPrev(Node<Player> prev) {
        this.prev = prev;
    }

    public Node<Player> getNext() {
        return next;
    }

    public void setNext(Node<Player> next) {
        this.next = next;
    }
}

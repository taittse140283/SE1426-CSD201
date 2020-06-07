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
/** Class Doubly LinkedList Node*/
public class DLLNode<Player> implements Cloneable{

    private Player info;//contains information of player include email and point
    private DLLNode<Player> prev;//reference to previous node
    private DLLNode<Player> next;//reference to next node
    //constructor, getter, setter 

    public DLLNode() {
        info=null;
        prev=next=null;
    }
    @Override
    public DLLNode<Player> clone() throws CloneNotSupportedException {
        return (DLLNode<Player>) super.clone();
    }
    public DLLNode(Player info, DLLNode prev, DLLNode next) {
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

    public DLLNode<Player> getPrev() {
        return prev;
    }

    public void setPrev(DLLNode<Player> prev) {
        this.prev = prev;
    }

    public DLLNode<Player> getNext() {
        return next;
    }

    public void setNext(DLLNode<Player> next) {
        this.next = next;
    }

    

}
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
public class DLLNode<Player> {

    private Player info;//chua thong tin cua nguoi choi bao gom email va point
    private DLLNode<Player> prev;//tro toi node dang truoc 
    private DLLNode<Player> next;//tro toi node ke tiep
    //constructor, getter, setter 
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

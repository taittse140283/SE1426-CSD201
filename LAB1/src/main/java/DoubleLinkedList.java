/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class DoubleLinkedList {

    Gamer head;
    Gamer tail;

    public DoubleLinkedList() {
        head = tail = null;
    }
    //check empty

    public boolean isEmpty() {
        return head == null;
    }

    public Gamer ceiling(Comparable point) {
        Gamer t = head;
        while (t != null && t.getPoint().compareTo(point) < 0) {
            t = t.next;
        }
        return t;
    }

    public Gamer search(Comparable point) {
        Gamer result = ceiling(point);
        if (result == null) {
            return null;
        }
        return (result.getPoint().compareTo(point) == 0) ? result : null;
    }

}

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
     public Gamer add(Gamer x) {
        Gamer newEle = x;
        Gamer after = ceiling(x.point);
        if (head == null) {
            head = tail = newEle;
        } else if (after == null) {
            newEle.next = null;
            newEle.previous = tail;
            tail.next = newEle;
            tail = newEle;
        } else if (after == head) {
            newEle.previous = null;
            newEle.next = head;
            head.previous = newEle;
            head = newEle;
        } else {
            Gamer before = after.previous;
            newEle.next = after;
            newEle.previous = before;
            after.previous = newEle;
            before.next = newEle;
        }
        return newEle;
    }

}

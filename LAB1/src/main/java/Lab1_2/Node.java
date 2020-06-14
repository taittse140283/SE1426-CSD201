/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

/**
 *
 * @author hiep
 */
public class Node {
    String tag;
    Node next,prev;
  
    public Node(String tag,Node next, Node prev) {
        this.tag = tag;
        this.next = next;
        this.prev = prev;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

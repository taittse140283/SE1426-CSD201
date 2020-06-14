/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Admin
 */
public class NodeHTML {
    String tag;
    NodeHTML next,prev;
    
    
    public NodeHTML(String tagHTML, NodeHTML next, NodeHTML prev) {
        this.tag = tagHTML;
        this.next = next;
        this.prev = prev;
    }

    public String getTagHTML() {
        return tag;
    }

    public void setTagHTML(String tagHTML) {
        this.tag = tagHTML;
    }

    public NodeHTML getNext() {
        return next;
    }

    public void setNext(NodeHTML next) {
        this.next = next;
    }

    public NodeHTML getPrev() {
        return prev;
    }

    public void setPrev(NodeHTML prev) {
        this.prev = prev;
    }
    
}

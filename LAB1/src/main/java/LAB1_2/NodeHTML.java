/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

/**
 *
 * @author TAN
 */
public class NodeHTML {
    String tagHTLM;
    NodeHTML next,prev;
    
    public NodeHTML(String tagHTLM, NodeHTML next, NodeHTML prev) {
        this.tagHTLM = tagHTLM;
        this.next = next;
        this.prev = prev;
    }

    public String getTagHTLM() {
        return tagHTLM;
    }

    public void setTagHTLM(String tagHTLM) {
        this.tagHTLM = tagHTLM;
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

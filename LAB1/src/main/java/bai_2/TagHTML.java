/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author Linh
 */


/**
 * Each node stores one tag and 2 info of its next node and previous node
 */
public class TagHTML {
    private String tag;
    TagHTML next, prev;

    //Constructor 
    public TagHTML(String tag, TagHTML next, TagHTML prev) {
        this.tag = tag;
        this.next = next;
        this.prev = prev;
    }
    
    //Getter va setter
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public TagHTML getNext() {
        return next;
    }

    public void setNext(TagHTML next) {
        this.next = next;
    }

    public TagHTML getPrev() {
        return prev;
    }

    public void setPrev(TagHTML prev) {
        this.prev = prev;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI2;

/**
 *
 * @author Thuan Le
 */
public class TagOfHTML {
    private String tagHtml;
    TagOfHTML next, prev;

    /**
     * Constructor
     * @param tagHtml
     * @param next
     * @param prev 
     */
    public TagOfHTML(String tagHtml, TagOfHTML next, TagOfHTML prev) {
        this.tagHtml = tagHtml;
        this.next = next;
        this.prev = prev;
    }

    public String getTagHtml() {
        return tagHtml;
    }

    public void setTagHtml(String tagHtml) {
        this.tagHtml = tagHtml;
    }

    public TagOfHTML getNext() {
        return next;
    }

    public void setNext(TagOfHTML next) {
        this.next = next;
    }

    public TagOfHTML getPrev() {
        return prev;
    }

    public void setPrev(TagOfHTML prev) {
        this.prev = prev;
    }
    
}

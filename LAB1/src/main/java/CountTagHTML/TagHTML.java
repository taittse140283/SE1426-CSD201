/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountTagHTML;

/**
 *
 * @author Loi Lam
 */
public class TagHTML {

    private String tag;
    TagHTML next, prev;

    //Constructor no parameters
    public TagHTML() {
    }

    //Constructor have parameters
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

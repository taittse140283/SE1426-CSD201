/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author Dell
 */
public class InfoTagWeb {
   private String tag;
    InfoTagWeb next, prev;

    /**
     * This is constructor with parameter(tag, next and prev)
     * @param t
     * @param n
     * @param p 
     */
    public InfoTagWeb(String t, InfoTagWeb n, InfoTagWeb p) {
        this.tag = t;
        this.next = n;
        this.prev = p;
    }
    /**
     * All method below here is used to access to private modify(read and write)
     * Input: with set, the data input is tag, NodeHTML next, NodeHTML prev. With get, no input
     * Output: with get, the data output is next, prev, tag. With set, no data output
     * @return 
     */
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public InfoTagWeb getNext() {
        return next;
    }

    public void setNext(InfoTagWeb next) {
        this.next = next;
    }

    public InfoTagWeb getPrev() {
        return prev;
    }

    public void setPrev(InfoTagWeb prev) {
        this.prev = prev;
    }
}

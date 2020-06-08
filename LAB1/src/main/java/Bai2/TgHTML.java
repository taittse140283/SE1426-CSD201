/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author Asus
 */
public class TgHTML {
    String tagHTML;
    TgHTML NEXT,prev;

    public TgHTML() {
    }

    public TgHTML(String tagHTML, TgHTML NEXT, TgHTML prev) {
        this.tagHTML = tagHTML;
        this.NEXT = NEXT;
        this.prev = prev;
    }

    public String getTagHTML() {
        return tagHTML;
    }

    public void setTagHTML(String tagHTML) {
        this.tagHTML = tagHTML;
    }

    public TgHTML getNEXT() {
        return NEXT;
    }

    public void setNEXT(TgHTML NEXT) {
        this.NEXT = NEXT;
    }

    public TgHTML getPrev() {
        return prev;
    }

    public void setPrev(TgHTML prev) {
        this.prev = prev;
    }
    
}

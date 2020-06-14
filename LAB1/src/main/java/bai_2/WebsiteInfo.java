/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author W10
 * This class contains basic information of input's HTML web
 */
public class WebsiteInfo {
    private String tag;
    WebsiteInfo next,pre;//tao pointer cua chinh no

    /*
        construtor,getter,setter of html node
    */
    public WebsiteInfo(String tag, WebsiteInfo next, WebsiteInfo pre) {
        this.tag = tag;
        this.next = next;
        this.pre = pre;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public WebsiteInfo getNext() {
        return next;
    }

    public void setNext(WebsiteInfo next) {
        this.next = next;
    }

    public WebsiteInfo getPre() {
        return pre;
    }

    public void setPre(WebsiteInfo pre) {
        this.pre = pre;
    }
    
    
}

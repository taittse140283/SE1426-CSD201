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
}

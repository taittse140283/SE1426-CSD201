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
public class Stack {
   TagOfHTML header, trailer;

    /**
     * Constructor
     */
    public Stack() {
        header = trailer = null;
    }
    
    /**
     * Create new node
     * @param tag 
     */
    public void  push(String tag){
        TagOfHTML th = new TagOfHTML(tag, header, trailer);
        if(header  == null){
            header = th;
            header.prev = null;
            trailer = th;
            trailer.next = null;
            return;
        }
    }
   
}

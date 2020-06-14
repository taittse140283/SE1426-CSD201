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
     * Add element to the top
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
        th.prev = trailer;
        trailer.next = th;
        trailer = th;
        trailer.next = null;
        
    }
    /**
     * Remove a node
     */
    public void pop(){
        if(header == null){ return;}
        if(header == trailer){ 
            header = null; 
            trailer = null;
            return;
        } 
        trailer = trailer.prev;
        trailer.next = null;
    }
    /**
     * Get the element at the top
     * @return 
     */
    public String getTop(){
        return trailer.getTagHtml();
    }
    
    public void print(){
        for (TagOfHTML tag = header; tag != null; tag = tag.next) {
            System.out.println(tag.getTagHtml() + " ");
        }
    }
}    

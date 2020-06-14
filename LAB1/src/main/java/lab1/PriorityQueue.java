/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.IOException;

/**
 *
 * @author Admin
 */

public class PriorityQueue {
 
    private DoubleLinkList<Entry> list = new DoubleLinkList<Entry>();
    public DoubleLinkList<Entry> getList() {
        return list;
    }
    public void setList(DoubleLinkList<Entry> list) {
        this.list = list;
    }
  
    public void add(Node<Entry> Entry){
         int rank = Entry.getElement().getPoint();
        if(list.getSize() == 0) {
            list.setHeader(Entry);
            list.setTailer(Entry);
            list.setSize(list.getSize() + 1);
        }
        else{
            // add in the first if the entry add have more point than the first entry in the queue
            if (rank > list.getHeader().getElement().getPoint())
                list.addFirst(Entry);
            //add in the last if the entry add have less point than the tailer in the quue
            else if (rank <= list.getTailer().getElement().getPoint())
                list.addLast(Entry);
            else {
                Node<Entry> current  = list.getHeader();
                /**find the suitable position in the queue to add!
                 * i choose the header for the current, then compare the current with the entry point
                 * using while to find the position when the entry point > the current then stop
                 * that is the position needed!!!
                
                */
                while (current.getElement().getPoint() >= Entry.getElement().getPoint()) {
                    current = current.getNext();
                }
                //Them nguoi choi moi vay chuoi
                Entry.setNext(current);
                Entry.setBack(current.getBack());
                current.getBack().setNext(Entry);
                current.setBack(Entry);
                list.setSize(list.getSize() + 1);
            }
        }       
    }
    /**
     * this method will find the entry 
     * @param is a email
     */
    public Node<Entry> getNode(String email) {
        Node<Entry> current = list.getHeader();
        while (!current.getElement().getEmail().equals(email)){
            current = current.getNext();
        }
        return current;
    }
    
    /**
      * this method will update the person's Point base on the email you enter.
      * if the email is a header or tailer, first remove it, then add the new entry with the email and new Point you entered!!
      * @param the email and new Point you want to update
      * 
      */
    public void updateNewPoint(String email, int newPoint) {
        Node<Entry> updatedNode = getNode(email);
        
        if(updatedNode == null) {
            System.out.println("Email does not exit.");
        }
        else{
            if(updatedNode == list.getHeader()){ 
              
                  removePlayerMax();
            }
            else if (updatedNode == list.getTailer()){ 
     
                removePlayerMin();
            }else{
                updatedNode.getElement().setPoint(newPoint); 
                updatedNode.getBack().setNext(updatedNode.getNext());
                updatedNode.getNext().setBack(updatedNode.getBack());
            }
//            add(updatedNode);
            Entry p = new Entry(email, newPoint);
            Node<Entry> n = new Node<>(p, list.getHeader(), list.getTailer());
            add(n);
            list.setSize(list.getSize()-1);
            System.out.println("Update " + email + " success.");
        }
    }
    
     /**
      * this method to remove a person base on the email of them
      * @param The email 
      * 
      */
    public void deletePlayer(String email) {
        Node<Entry> entry = getNode(email);
        if (entry == null) { 
            System.out.println("Not found email");
        } else {
            if(entry == list.getHeader()){
                list.removeFirst();
            }
            else if(entry == list.getTailer()){
                list.removeLast();
            }
            else {
                list.remove(entry);
            }
        }
    }
    //xoa nguoi choi dau danh sach O(1)
    public Entry removePlayerMax(){
        return list.removeFirst();
    }
    //xoa nguoi choi cuoi danh sach
    public Entry removePlayerMin(){
        return list.removeLast();
    }
    //tim kiem nguoi choi dau danh sach O(1)
    public Entry getPlayerMax(){
        return list.getHeadElement();
    }
    
     
    
  
     
     /**
      * this method will find a entry person base on the email of them, if find, return them, or not, print the person doesn't exit.
      *@param the entry email of the person want to find
      * @return the person you finded.
      */
   
     
    
      
      
     

    
   
    
   
 }
     
                        
                   


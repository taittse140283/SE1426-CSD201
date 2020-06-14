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
    public  void findMax(){
         list.first();
    }
    
     
     /**
      * this method to remove a person base on the email of them
      * @param The email 
      * @return if remove success, return immediately out of the list
      */
     public void remove(String email) {
        int size = list.getSize();
        for (int i = 0; i < size; i++) {
            if (email.equals(list.getElementNode(i).getEmail())) {
                list.remove(list.getNode(i));
                return;
            }
        }
        System.out.println("The Entry person doesn't exit!!!!");
    }
     
     /**
      * this method will find a entry person base on the email of them, if find, return them, or not, print the person doesn't exit.
      *@param the entry email of the person want to find
      * @return the person you finded.
      */
     public void find(String mail) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (mail.equals(list.getElementNode(i).getEmail())) {
                System.out.println("Email:\n" + list.getElementNode(i));
                return;
            }
        }
        System.out.println("The person you entered does not exist");
    }
     /**
      * this method will update the person's Point base on the email you enter.
      * @param the email and new Point you want to update
      * @return new Point of the email you entered
      * 
      */
      public void update(String mail, int new_point) {
        String new_email;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (mail.equals(list.getElementNode(i).getEmail())) {
                list.getElementNode(i).setPoint(new_point);
                System.out.println("Successfully!");
                return;
            }
        }
        System.out.println("he person you entered does not exist");
    }
      /** print the list
       */
      public void print() {
        list.print();
    }
      
      /**
      *print the list to file 
      * @param a file name you want to write
      */
      public void printtoFile(String Filename) throws IOException {
        list.printtoFile(Filename);
    }
      public String toString(){
          
          return list.toString();
      }

    
   
    
   
 }
     
                        
                   


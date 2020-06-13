/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */

public class PriorityQueue {
 
    private DoubleLinkList<Entry> _list = new DoubleLinkList<Entry>();
    
    public void enqueue(Entry e){
        _list.addFirst(e);
    }
    public Entry dequeue(){
        return _list.removeFirst();
    }
    public  Entry findMax(){
        return _list.first();
    }
    /**
     * this method to add the entry node to the queue base on the Point of them
     * @param The Node entry
     * 
     */
     public void insert(Entry e) {
        int point = e.getPoint();
        int size = _list.size();
        if (size == 0) {
            _list.addFirst(e);
        } else {
            if (point > _list.first().getPoint()) {
                _list.addFirst(e);
            } else if (point <= _list.last().getPoint()) {
                _list.addLast(e);
            } else {
                for (int i = 0; i < size; i++) {
                    if (point <= _list.getNode(i).getElement().getPoint()) {
                        _list.addBetween(e, _list.getNode(i + 1), _list.getNode(i));
                        return;
                    }
                }
            }

        }
    }
     
     /**
      * this method to remove a person base on the email of them
      * @param The email 
      * @return if remove success, return immediately out of the list
      */
     public void remove(String email) {
        int size = _list.size();
        for (int i = 0; i < size; i++) {
            if (email.equals(_list.getElementNode(i).getEmail())) {
                _list.remove(_list.getNode(i));
                return;
            }
        }
        System.out.println("The Entry person doesn't exit!!!!");
    }
     
     /**
      * this method will find a entry person base on the email of them, if find, return them, or not, print the person doesn't exit.
      *
      */
     public void find(String mail) {
        int size = _list.size();
        for (int i = 0; i < size; i++) {
            if (mail.equals(_list.getElementNode(i).getEmail())) {
                System.out.println("Email:\n" + _list.getElementNode(i));
                return;
            }
        }
        System.out.println("The person you entered does not exist");
    }
     
   
    
   
 }
     
                        
                   


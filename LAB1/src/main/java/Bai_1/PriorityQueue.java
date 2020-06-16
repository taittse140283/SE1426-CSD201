/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;
/**
 *
 * @author Dell
 */
public class PriorityQueue {
    DoublyLinkedList<Infor> list= new DoublyLinkedList<>();
    public DoublyLinkedList<Infor> getList() {
        return list;
    }

   /**
    * This method below here is used to information of player
    * @param the list of player 
    */
    public void addAndSort(Infor player) {
        if (list.isEmpty()) {
            list.addFirst(player);
        } else if (player.getPoint() >= list.getHeader().getElement().getPoint()) {
            if (player.getPoint() > list.getHeader().getElement().getPoint()) {
                list.addFirst(player);
            } else {
                DoublyLinkedList.Node<Infor> step = list.getHeader();
                list.addBetween(player, step, step.getNext());
            }
        } else if (player.getPoint() <= list.getTrailer().getElement().getPoint()) {
            list.addLast(player);
        } else {
            DoublyLinkedList.Node<Infor> step = list.getHeader();
            while (step.getElement().getPoint() > player.getPoint()) {
                step = step.getNext();
            }
            list.addBetween(player, step.getPrev(), step);
        }
    }

    /**
     * This method below here is used to find the pos of player base on email entered by user
     * @param email
     * @return 
     */
    public int findPos(String email) {
        for (int i = 0; i < list.size; i++) {
            if (list.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * This method below here is used to remove player has max point
     * No @param
     */
    public void removePlayerHasMaxPoint() {
        list.removeFirst();
    }
    
    /**
     * This method below here is used to get play has max point from list
     * @return the player has max point
     */
    public long getPlayerHasMaxPoint() {
        return list.getHeader().getElement().getPoint();
    }
    
    /**
     * This method below here is used to delete the email entered from user
     * If <0 :empty list
     * If pos<0: not found
     * If pos>0: found
     * @param email 
     */
    public void delete(String email) {
        int pos = findPos(email); 
        if(pos < 0) {
            System.out.println("No information found");
        } else {
            list.removePos(pos);
        }
    }
    
    /**
     * This method below here is used to get random point of the user from list
     * @param email
     * @return 
     */
    public long  getNodePlayerPoint(String email) {
        DoublyLinkedList.Node<Infor> step = list.getTrailer();
        while(!step.getElement().getEmail().equals(email)) { 
            step = step.getNext();
        }
        return step.getElement().getPoint();
    }
}

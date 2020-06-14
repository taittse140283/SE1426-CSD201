/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Dell
 */
public class PriorityQueue {
    public ArrayList<Infor> list= new ArrayList<>();

    /**
     * This is constructor with no parameter
     */
    public PriorityQueue() {
    }
    /**
     * This method below here is used to add each member to a list
     * Input data is infor
     * Output data is the list of infor
     * @param infor 
     */
    public void add(Infor infor){
    int size = this.size();
        for(int i = 0; i < size; ++i) {
            int index = size - i - 1;
            if (infor.getPoint() <= ((Infor)this.list.get(index)).getPoint()) {
                this.list.add(index + 1, infor);
                return;
            }
        }

        this.list.add(0, infor);
    }
    /**
     * This method below here is used to get the email and point from player
     * Input data is email
     * @param email
     * @return 
     */
    public long get(String email) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                return ((Infor)this.list.get(i)).getPoint();
            }
        }

        return -1;
    }
    /**
     * This method below here is used to delete the player by use input email
     * Input data is email
     * @param email 
     */
     public void remove(String email) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                this.list.remove(i);
            }
        }

    }
     /**
      * This method below here is used to update the email and point of player and update the list
      * Input data is email and point
      * @param email
      * @param point 
      */
    public void update(String email, int point) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                Infor info = (Infor)this.list.remove(i);
                info.setPoint(point);
                this.add(info);
            }
        }

    }
   
}

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

    
   
}

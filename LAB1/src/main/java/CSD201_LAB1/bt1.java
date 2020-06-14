/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

/**
 *
 * @author truong
 */
public class bt1 {
    PriorityQueue queue;
    public void inserNewData(String email,String point){
        queue.add(email, 0);
    }
    public void deleteEmail(String email){
        queue.delete(email);
    }
    public void getPointUser(String email){
        int point=queue.getPoint(email);
        if(point==0){
            System.err.println("can't find"+email+"tray agin");
        }else{
            System.out.println(point);
        }
    }
    
}

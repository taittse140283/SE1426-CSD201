/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;

/**
 *
 * @author PC
 */
public class PriorityQueue extends DoublyLinkedList{
    public PriorityQueue(){
        
    }
    public void addPlayer(Information data){
        addNode(data);
    }
    
    public void deletePlayer(String email){
        deletePlayer(email);
    }
    
    public void updatePlayer(String email, int point){
        updatePlayer(email, point);
    }
    
    public void findPlayer(String email){
        DisplayPoint(email);
    }
    
    public void getTop(){
        displayPointTop();
    }
    
    public void removeTop(){
        if(isEmpty()){
            System.out.println("The list is empty!!!");
        } else{
            removeFirst();
        }
    }
    
    public void writePlayer(String fileName){
        writeData(this, fileName);
    }
}

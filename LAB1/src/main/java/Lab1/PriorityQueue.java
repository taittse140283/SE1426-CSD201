/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author Admin
 */
public class PriorityQueue extends DoublyLinkedList{

    public PriorityQueue() {
    }
    
    public void addPlayer(Player data){
        add(data);
    }
    
    public void deletePlayer(String email){
        delete(email);
    }
    
    public void updatePlayer(String email, int point){
        update(email, point);
    }
    
    public void searchPlayer(String email){
        searchPlayerByEmail(email);
    }
    
    public void getTopPlayer(){
        displayTop();
    }
    
    public void removeTopPlayer(){
        removeTop();
    }
    
}

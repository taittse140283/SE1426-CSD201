/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;


/**
 *
 * @author Admin
 */
public class PriorityQueue{
    private DoublyLinkedList<Player> list = new DoublyLinkedList<>();
    
    public PriorityQueue(){
        
    }
    
    public void addPlayer(Player data){
        for (int i = 0; i < list.size(); i++) {
            int index = list.size() - i -1 ;
            if (data.getPoint()<= this.list.get(index).getPoint()){
                this.list.add(index+1, data);
                return;
            }
        }
    }
    
    public void deletePlayer(String email){
        for (int i = 0; i < list.size(); i++) {
            if(this.list.get(i).getEmail().equals(email)){
                this.list.remove(i);
            }
        }
    }
}

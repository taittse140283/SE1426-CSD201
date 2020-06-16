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
public class PriorityQueue extends DoublyLinkedList<Player>{
    private DoublyLinkedList<Player> list = new DoublyLinkedList<Player>();
    
    public DoublyLinkedList<Player> getList() {
        return list;
    }
    
    public PriorityQueue(){
        
    }
    
    public void insert(Player data){
        int index;
        for (int i = 0; i < this.size() ; ++i) {
            index = this.list.size - i -1 ;
            if (data.getPoint()<= this.list.get(index).getPoint()){
                this.list.addIndex(index+1, data);
                return;
            }
        }
    }
    
    public void remove(String email){
        for (int i = 0; i < this.size(); ++i) {
            if(this.list.get(i).getEmail().equals(email)){
                this.list.removeIndex(i);
            }
        }
    }
    
    public void update(String email, long point){
        for (int i = 0; i < this.size(); ++i) {
            if(this.list.get(i).getEmail().equals(email)){
                Player data = list.removeIndex(i);
                data.setPoint(point);
                insert(data);
            }
        }
    }
    
    public long get(String email){
        for (int i = 0; i < this.size(); ++i) {
            if(this.list.get(i).getEmail().equals(email)){
                return list.get(i).getPoint();
            }
        }
        return -1L;
    }
    
    public Player max(){
        return (Player)this.list.getFirst();
    }
    
    public Player removeMax(){
        return (Player)this.list.removeFirst();
    }
}

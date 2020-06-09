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
    public  Entry first(){
        for(int i=0; i<_list.size(); i++){
            
        }
        return _list.first();
    }
    public boolean isEmpty(){
        return _list.isEmpty();
    }
    public int size(){
        return _list.size();
    }
    public String toString(){
        return _list.toString();
    }
                        
                   
}

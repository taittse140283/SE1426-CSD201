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
public  class LinkedStack<Entry> implements Stack<Entry>{
    private DoubleLinkList<Entry> list= new DoubleLinkList<Entry>();
     @Override
     public void add(Entry e){
         list.addFirst(e);
     };
     @Override
     public Entry remove(){
         return list.removeFirst();
     }
     @Override
     public int size(){
         return list.size();
     }
     @Override
     public Entry top(){
        return list.first();
     }
     @Override
     public boolean isEmpty(){
         return list.isEmpty();
         
     }
     @Override
     public String toString(){
        return  list.toString();
         
     }

    

    
}

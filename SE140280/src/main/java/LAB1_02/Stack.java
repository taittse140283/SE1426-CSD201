/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_02;

/**
 *
 * @author ZunPeter
 */
public class Stack {
   NodeHTML head;
   NodeHTML tail;

    public Stack() {
    head = null;
    tail = null;
    }
    /*return the number of elements in the stack
    @return number of element in stack*/
    private int size = 0;
    int size(){
      return size;
    }
    /*Check if stack is Empty
    @return true if the stack is empty */
    public boolean isEmpty(){
       return size == 0; 
    }
   
    public void push(String tagHTML){
        NodeHTML tag= new NodeHTML(tagHTML, head, tail);
        
        if(isEmpty()){
            
        }
    }
   
}

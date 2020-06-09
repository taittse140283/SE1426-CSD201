/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author Dell
 */
public interface Stack<E> {
    /**
     * Returns the number of element in the stack
     * @return number of elements in the stack
     */
    int size();
    
    /**
     * Test the stack is empty or not
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * Insert an element at the top of the stack
     * @param e the element to be insert
     */
    void push(E e);
    
    /**
     * Return but does not remove, the element at the top of the stack
     * @return top element in the stack(or null if empty)
     */
    E top();
    
    /**
     * Removes and return the top element from the stack
     * @return element removed (or null if empty)
     */
    E pop();
 
}

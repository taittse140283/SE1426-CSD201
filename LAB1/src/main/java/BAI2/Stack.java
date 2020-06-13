/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI2;

/**
 *
 * @author Thuan Le
 */
public interface Stack<E> {
    /**
     * Return the number of elements in the stack
     * @return number of elements in the stack
     */
    int size();
    
    /**
     * Test whether the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();
    
    /**
     * Insert an element at the top of the stack
     * @param element   the element to be inserted
     */
    void push(E element);
    
    /**
     * Returns, but doesn't remove, the element at the top of the stack
     * @return top element in the stack ( or null if stack is empty)
     */
    E top();
    
    /**
     * Removes and return the top element from the stack
     * @return element removed (or null if stack is empty)
     */
    E pop();
    
    /**
     * Display info of stack
     */
    void print();
}

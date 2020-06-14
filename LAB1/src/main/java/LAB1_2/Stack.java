/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

/**
 *
 * @author Admin
 */
public interface Stack<E> {

    /**
     * Return the number of elements in the stack.
     * @return 
     */
    public int size();

    /**
     * Return whether the list is empty.
     * @return
     */
    public boolean isEmpty();

    /**
     * Check the element at the top of the stack.
     * @return
     */
    public E top();

    /**
     * Add an element at the beginning of the stack.
     * @param e
     */
    public void push(E e);
    
    /**
     * Remove the top element from the stack.
     * @return 
     */
    public E pop();
}

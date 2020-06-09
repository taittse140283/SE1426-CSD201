/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author User
 */
public class ArrayStack<E> implements Stack<E> {

    /**
     * Default array capacity
     * Generic array used to implement the stack
     * index for the top of the stack
     */
    public static final int CAPACITY = 5000; 
    private E data[]; 
    private int top = -1; 

    /**
     * Constructor default
     */
    public ArrayStack() {
        this(CAPACITY); 
    }

    /**
     * Constructor with parameter capacity
     * compiler may give warning
     * @param capacity 
     */
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity]; 
    }

    
    @Override
    public int size() {
        return (top + 1);
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E top() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void push(E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

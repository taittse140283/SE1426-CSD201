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
public abstract class MyAbstractList<E> implements Stack<E>{
    public int size = 0;
    
    /**
     * Create Constructor
     * A default list
     */
    public MyAbstractList() {
    }
    
    /**
     * Add a new element at the end of this list
     * @param e 
     */
    @Override
    public void add(E e) {
        add(size, e);
    }
    
    /**
     * Return true if this list contains no elements
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * Return the number of elements in this list
     * @return 
     */
    @Override
    public int size() {
        return size;
    }
}

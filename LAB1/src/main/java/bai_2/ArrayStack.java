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
public class ArrayStack<E> implements Stack<E>{
    public static final int CAPACITY=1000; // default array capacity 
    private E[] data; // used to store tags
    private int t=-1;

    /**
     * This method is constructor with default capacity
     * No input data
     * No output data
     */
    public ArrayStack() {
        this(CAPACITY);
    }
    
    /**
     * This method is constructor with given capacity
     * Input data is capacity
     */
    public ArrayStack(int capacity){
        data=(E[]) new Object[capacity];
    }
    
    /**
     * This method to increase size of the element in stack
     * No input data
     * Output data : the number of element in the stack
     */
    @Override
    public int size() {
        return (t+1);
    }

    /**
     * This method to check the stack is empty or not
     * No input data
     * Output data: true or false when t equal to -1
     */
    @Override
    public boolean isEmpty() {
        return (t==-1);
    }

    /**
     * This method is insert an element at the top of the stack
     * 
     * @param e
     * @throws IllegalStateException 
     */
    @Override
    public void push(E e) throws IllegalStateException {
        if(size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t]=e;
    }

    @Override
    public E top() {
       if(isEmpty()){
           return null;
       }
       return data[t];
    }

    @Override
    public E pop() {
       if(isEmpty()){
           return null;
       }
       E answer= data[t];
       data[t]=null;
       t--;
       return answer;
    }
}

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
public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY =1000;
    private E[] data;
    private int top = -1;

    public ArrayStack() {
        this(CAPACITY);
    }
    
    public ArrayStack(int capacity){
        data = (E[]) new Object[capacity];
    }
    
    @Override
    public int size(){  return(top + 1);}
    
    @Override
    public boolean isEmpty(){ return (top == -1);}
    
    @Override
    public void push(E element) throws IllegalStateException{
        if(size() == data.length) throw new  IllegalStateException("Full Stack!");
        data[++top] = element;
    }
    
    @Override
    public E top(){
        if(isEmpty()) return null;
        return data[top];
    }
    
    @Override
    public E pop(){
        if(isEmpty()) return null;
        E answer = data[top];
        data[top] = null;
        top--;
        return answer;
    }
    public void print(){
        for (int i = top; i >= 0; i--) {
            System.out.println(data[i] + "\n");
        }
    }
}

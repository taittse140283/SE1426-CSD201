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
public class ArrayStack implements Stack{
    public static final int CAPACITY = 5000;
    private int top;
    private String[] storage;

    public ArrayStack(int CAPACITY) {
        this.storage = new String[CAPACITY];
        this.top = -1;
    }
    
    @Override
    public int size() {
        return this.top + 1;
    }

    @Override
    public boolean isEmpty() {
        if (this.top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public String top() {
        if (this.top == -1) {
            return null;
        }
        return this.storage[this.top];
    }

    @Override
    public void push(String tag) {
        if (this.top == this.storage.length){
            System.out.println("Stack Overflow");
        } else {
            this.top++;
            this.storage[this.top] = tag;
        }
    }

    @Override
    public String pop() {
        if (isEmpty()) {
            return null;
        } else {
            String tag = this.storage[this.top];
            this.storage[this.top] = null;
            this.top--;
            return tag;
        }
    }
    
}

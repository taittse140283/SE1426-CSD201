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
        storage = new String[CAPACITY];
        top = -1;
    }
    
    @Override
    public int size() {
        return this.top +1;
    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

    @Override
    public String top() {
        if (top == -1) {
            return null;
        }
        return this.storage[this.top];
    }

    @Override
    public void push(String tag) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pop() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

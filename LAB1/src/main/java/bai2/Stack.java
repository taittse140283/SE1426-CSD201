/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Admin
 */
public interface Stack<E> {
    public void push(E info);
    public E pop();
    public E top();
    public boolean isEmpty();
    public int size();
    public void print();
}

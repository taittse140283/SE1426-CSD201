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
public interface Stack<E> {
    
    public int size();
    public boolean isEmpty();
    public E top();
    public void push(E element);
    public E pop();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author Asus
 */
public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY=1000;
    private E[ ] data;
    private int t=-1;
    public ArrayStack( ) { this(CAPACITY); } 
    public ArrayStack(int capacity) {
        data = (E[ ]) new Object[capacity];
    }
}    
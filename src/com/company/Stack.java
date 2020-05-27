package com.company;

public interface Stack<E> {
    public void push(E info);
    public E pop();
    public int size();
    public E top();
    public boolean isEmpty();
    public void print();
}

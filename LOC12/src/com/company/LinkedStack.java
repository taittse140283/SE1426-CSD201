package com.company;

public class LinkedStack<E> implements Stack<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<E>();
    @Override
    public void push(E info) {
        list.addFirst(info);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public E top() {
        return list.getHead();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void print() {
        //list.print();
    }
}

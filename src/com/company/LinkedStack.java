package com.company;

public class LinkedStack implements Stack {
    private SinglyLinkedList list = new SinglyLinkedList();
    @Override
    public void push(int info) {
        list.addFirst(info);
    }

    @Override
    public int pop() {
        return list.removeFirst();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public int top() {
        return list.getHead();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void print() {
        list.print();;
    }
}

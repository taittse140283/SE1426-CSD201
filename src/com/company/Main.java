package com.company;

public class Main {

    public static void main(String[] args) {
        // [9, 5, 6, 8, 3, 12]
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst(3);
        list.addFirst(8);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(9);
        list.addLast(12);
        list.print();
        list.removeFirst();
        list.print();
        //System.out.print(list.getTail());
	    // write your code here
    }
}

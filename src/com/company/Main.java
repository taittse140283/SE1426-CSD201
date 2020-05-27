package com.company;

public class Main {

    public static void main(String[] args) {
        Entry a = new Entry(2,"A");
        Entry b = new Entry(1,"B");
        Entry c = new Entry(0,"C");

        PriorityQueue queue = new PriorityQueue();
        queue.enqueue(a);
        queue.enqueue(b);
        queue.enqueue(c);

//        Entry first = queue.dequeue();
//        first.setRank(5);
        System.out.print(queue.toString());

    }
}

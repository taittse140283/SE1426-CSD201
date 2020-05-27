package com.company;
import com.company.Entry;
import java.util.ArrayList;



public class PriorityQueue {
//    private SinglyLinkedList<Entry> _list = new SinglyLinkedList<Entry>();
    private ArrayList<Entry> _list = new ArrayList<Entry>();
    public void enqueue(Entry entry) {
        _list.add(_list.size(), entry);
        //_list.addLast(entry);
    }

    public Entry dequeue() {
        return _list.remove(0);
//        return _list.removeFirst();
    }

    public Entry first() {

        for(int i = 0; i < _list.size(); i++) {

        }
        return _list.get(0);
    }

    public boolean isEmpty() {
        return _list.isEmpty();
    }

    public int size() {
        return _list.size();
    }
    public String toString() {
        return _list.toString();
    }
}

package com.company;

public class Heap {
    private int[] _array;
    private int _n;
    public Heap(int max) {
        _array = new int[max];
        _n = 0;
    }
    private int parent(int i) {
        return (i - 1)/2;
    }
    private int left(int i) {
        return 2*i + 1;
    }
    private int right(int i) {
        return 2*i + 2;
    }
    private void swap(int ia, int ib) {
        int tmp = _array[ia];
        _array[ia] = _array[ib];
        _array[ib] = tmp;
    }
    private void heapUp(int i) {
        if(i == 0) return;
        if(_array[i] < _array[parent(i)]) swap(i, parent(i));
        heapUp(parent(i));
    }
    private void heapDown(int i) {
        if(2*i >= _n) return;
        if(_array[i] > _array[left(i)]) {
            swap(i, left(i));
            heapDown(left(i));
        } else if(_array[i] > _array[right(i)]) {
            swap(i, right(i));
            heapDown(right(i));
        }
    }
    public void insert(int value) {
        _array[_n] = value;
        heapUp(_n);
        _n++;
    }
    public int remove() {
        int result = _array[0];
        _array[0] = _array[_n-1];
        _n--;
        heapDown(0);
        return result;
    }
    public void print() {
        System.out.println(toString());
    }
    public String toString() {
        String result = "";
        for(int i = 0; i < _n; i++)
            result += _array[i] + " ";
        return result;
    }

}

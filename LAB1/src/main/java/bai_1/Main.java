/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 *
 * @author Linh
 */
public class Main {
    public static void main(String[] args) {
        
        //Test addLast method
        SortedPriorityQueue s = new SortedPriorityQueue();
        s.addLast("aaaaaaa@aaaaaa", 100);
        s.addLast("bbbb@bbb", 15);
        s.addLast("ccccccc@ccccccc", 5148);
        s.addLast("dddddddddd@dddddddd", 155);
        s.print();
    }
}

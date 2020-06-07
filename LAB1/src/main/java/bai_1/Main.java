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
        
        //Test addAndSort method
        SortedPriorityQueue s = new SortedPriorityQueue();
        s.addAndSort("aaaaaaa@aaaaaa", 100);
        s.addAndSort("bbbb@bbb", 15);
        s.addAndSort("ccccccc@ccccccc", 5148);
        s.addAndSort("dddddddddd@dddddddd", 155);
        s.print();
        s.removePlayerHasBiggestPoint();
        s.print();
    }
}

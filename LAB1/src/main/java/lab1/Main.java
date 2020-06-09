/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        Entry a= new Entry("luonghb24@gmail.com", 100);
        Entry b= new Entry("luonghb4@gmail.com", 120);
        Entry c= new Entry("luonghb44@gmail.com", 130);
        Entry d= new Entry("luonghb34@gmail.com", 10);
       Entry e= new Entry("luonghb443@gmail.com", 5000);
        
       PriorityQueue queue= new PriorityQueue();
       queue.enqueue(a);
       queue.enqueue(b);
       queue.enqueue(c);
       queue.enqueue(d);
       queue.enqueue(e);
        System.out.println(queue.toString());
        
    }
}

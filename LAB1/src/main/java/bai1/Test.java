/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author Admin
 */
public class Test {
    public static void main(String[] args) {
        SortedPriorityQueue queue=CSV.readFile("user.csv");
        queue.print();
        DLLNode<Player> newest=new DLLNode<>();
        Player x=new Player();
        x.setEmail("njsdfnjdnjn@gmail.com");
        x.setPoint(30000);
        newest.setInfo(x);
        queue.add(newest);
        CSV.writeFile("user.csv", queue);
    }
}

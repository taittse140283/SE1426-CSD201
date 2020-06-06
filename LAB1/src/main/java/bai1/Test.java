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
        queue.add(newest);//add
        queue.updatePlayer("ocirlbtqze@gmail.com");//update
        queue.deletePlayer("ikokn@gmail.com");//delete
        System.out.println(queue.getPlayer("gzovr@gmail.com").getPoint());//get point
        System.out.println(queue.getMax().getPoint());//get top point
        System.out.println(queue.removeMax().toString());
        
        CSV.writeFile("new.csv", queue);
    }
}

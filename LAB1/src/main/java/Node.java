/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tri
 */
public class Node {
    private Gamer gamer;
    public Node next;

    public Node(Gamer gamer) {
        this.gamer = gamer;
        this.next = null;
    }
    public void printData(){
        gamer.printInfo();
    }
    
}

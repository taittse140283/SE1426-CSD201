/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tieuminh
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List list = new List();
        list.insert(new Node(new Gamer("A", 10)), 0);
        list.insert(new Node(new Gamer("B", 10)), 10);
        list.insert(new Node(new Gamer("C", 10)), 5);
        list.insert(new Node(new Gamer("D", 10)), 3);
    }
    
}

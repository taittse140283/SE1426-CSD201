/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class PlayerList extends LinkedList<Player>{
    Scanner sc = new Scanner(System.in);

    PlayerList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    PlayerList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    PlayerList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addPlayer(){
        Player p=new Player();
        p.input();
        if (this.add(p)==true)
            System.out.println("Add successfully");
        else 
            System.out.println("Add failed");
    }
    //Funtion: Search a player by email
    private int search (String email){
        return this.indexOf(new Player(email));
    }
    //Funtion : Remove a player by email
    public void removePlayer(){
        String email;
        System.out.print("Input player email want to remove: ");
        email = sc.nextLine();
        int pos = search(email);
        if (pos<0)System.out.println("Not found");
        else {
            this.remove(pos);
            System.out.println("Player email" + email + "was delateed");
        }
    }
    //Funtion: Update a player by email
    public void updatePlayer(){
        String email;
        System.out.println("Input player email want to update: ");
        email = sc.nextLine();
        int pos = search(email);
        if (pos<0)System.out.println("Not found");
        else {
            this.get(pos).input();
            System.out.println("Player email" + email + "was updated");
        }
    }
    public void print(){
        for (Player p: this) System.out.println(p);
    }
}

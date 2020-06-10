/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Player {
    String email="";
    int point=0;

    public Player() {
    }

    Player(int point) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Player(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        return email;
    }

    public int getPoint() {
        return point;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Player{" + "email=" + email + ", point=" + point + '}';
    }
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert player email: ");
        email = sc.nextLine();
        System.out.println("Insert player point: ");
        point = sc.nextInt();
        System.out.println("Email: " + email + ". Player point: " + point);
        sc.close();
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Infor {
    private String email;
    private int point;

    public Infor() {
    }

    public Infor(String email, int point) {
        this.email = email;
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Email:");
        email= sc.nextLine();
        System.out.println("Point:");
        point= Integer.parseInt(sc.nextLine());
    }
    public void output(){
        System.out.println("Emai:" + email + "|" + "Point:" + point);
    }
}

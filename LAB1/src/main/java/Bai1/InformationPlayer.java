/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class InformationPlayer {
    private double point;
    private String email;
    public InformationPlayer() {
    }

    public InformationPlayer(double point, String email) {
        this.point = point;
        this.email = email;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Email:");
        email= sc.nextLine();
        System.out.println("Point:");
        point= Integer.parseInt(sc.nextLine());
    }
    @Override
    public String toString() {
        return "InformationPlayer{" + "point=" + point + ", email=" + email + '}';
    }
    
}

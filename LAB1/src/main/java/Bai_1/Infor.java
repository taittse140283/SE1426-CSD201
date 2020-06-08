/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Infor {
     private String email;
    private int point;

    public Infor() { //khai bao constructor khong tham so
    }

    public Infor(String email, int point) { //khai bao constructor co tham so là email và point
        this.email = email;
        this.point = point;
    }
    /**
     * Create getter and setter to accces private variables
     */
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
    /**
     * This is a method for user to input email and point
     * There is no input data
     * No data output
     */
    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.println("Email:");
        email= sc.nextLine();
        System.out.println("Point:");
        point= Integer.parseInt(sc.nextLine());
    }
    /**
     * This is a method to output the data
     * No input data
     * Return email and point of user
     */
    public void output(){
        System.out.println("Emai:" + email + "|" + "Point:" + point);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameMobile;

import java.util.Scanner;

/**
 *
 * @author Loi Lam
 */
public class Player {

    private String name;
    private int point;

    //Constructor không tham số
    public Player() {
    }
//Constructor có tham số

    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }
//Tạo getter và setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Player: " + name + ".\t" + "Point: " + point + ".";
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input email: ");
        name = sc.nextLine();
        System.out.println("Input point: ");
        point = sc.nextInt();
        System.out.println("Added.");
        System.out.println("Email: " + name + "Point: " + point);
    }

}

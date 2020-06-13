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

    //Constructor no parameters
    public Player() {
    }
    //Constructor have parameters
    public Player(String name, int point) {
        this.name = name;
        this.point = point;
    }
    
    // getter and setter
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

}

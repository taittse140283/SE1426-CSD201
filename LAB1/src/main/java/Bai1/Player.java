/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author User
 */
public class Player implements Comparable<Player>{
    
    private String email;
    private int point;

    public Player() {
    }

    public Player(String email, int point) {
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

    @Override
    public String toString() {
        return this.getEmail() + "," + this.getPoint();
    }

    @Override
    public int compareTo(Player o) {
        return this.getPoint() < o.getPoint() ? 1 : this.getPoint() > o.getPoint() ? -1 : 0;
    }
    
    
}

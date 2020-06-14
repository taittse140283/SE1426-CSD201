package Bai1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrinhAnhTai
 */

/*
  * Create class Player to save information of player. 
  * Two properties: email and point
  * Getter,setter for email and point
*/
public class Player {
    private String email;
    private int point;

    public Player() {}

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

    /*
     * Export information
     */
    @Override
    public String toString() {
        return this.getEmail() + "," + this.getPoint();
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 *
 * @author W10
 */

/*khoi tao object player*/
public class Player {

    private String email;//dang chuoi
    private Double point;//dang so thuc

    /*constructer ko tham so*/
    public Player() {
    }

    /*constructer co tham so*/
    public Player(String email, Double point) {
        this.email = email;
        this.point = point;
    }

    /*getter,setter*/
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return email + "||" + point;
    }


}

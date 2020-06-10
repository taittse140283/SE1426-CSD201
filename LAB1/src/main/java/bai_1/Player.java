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
/**
 * Player class to setup information of player 
 * 
 */
public class Player {

    //Contain non param and param constructor getter setter and toString to output result
    //fields: email and point
    private String email;
    private Double point;

    public Player() {
    }

    public Player(String email, Double point) {
        this.email = email;
        this.point = point;
    }

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

    /**
     * 
     * @return (email)||(point)
     */
    @Override
    public String toString() {
        return email + "||" + point;
    }

}

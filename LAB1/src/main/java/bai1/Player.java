/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author Admin
 */
/**
  Class stores information of player include email and point
 */
public class Player {
    //Contain constructor, getter, setter and override toString()methods to get output be like: email,point;
    private String email;
    private int point;

    public Player() {
        email="";
        point=0;
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
        return email+","+point;
    }
    
    
}

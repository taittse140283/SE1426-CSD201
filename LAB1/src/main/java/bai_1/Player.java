/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 * This class is used to get and set information of every player
 * @author Linh
 */
public class Player {
    private String email;
    private int point;
    
    //Constructor
    public Player(String email, int point) {
        this.email = email;
        this.point = point;
    }
    
    //Getters and setters
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
    
    
}

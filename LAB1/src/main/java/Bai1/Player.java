package Bai1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lehie
 */
public class Player {
    private String email;
    private int point;
    
    //constructor default and co tham so
    public Player(){
    }
    
    public Player(String email, int point){
        this.email=email;
        this.point=point;
    }
    
    
    //create setter and getter for email, point
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
    public String toString(){
        return email + ", " + point;
    }   
}

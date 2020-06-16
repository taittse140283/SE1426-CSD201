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
     private long point;
     /**
     *This is constructor with no parameter
     *No @param
     *No @return
     */
    public Infor() { 
    }
     /**
     *This is constructor with parameter
     *@param email
     *@param point
     *No return 
     */
    public Infor(String email, long point) { 
        this.email = email;
        this.point = point;
    }
    /**
     * Create getter and setter to accces private variables
     *@param email and point
     *@return email and point
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }
    /**
     * This is a method to output the data. 
     * No input data
     * @Return email and point of user as a String
     */
    public String toString(){
        return this.getEmail() + "," + this.getPoint();
    }
}

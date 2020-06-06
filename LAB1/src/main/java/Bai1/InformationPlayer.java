/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author Asus
 */
public class InformationPlayer {
    private double point;
    private String email;
    public InformationPlayer() {
    }

    public InformationPlayer(double point, String email) {
        this.point = point;
        this.email = email;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void print(){
        System.out.println("Email: "+email);
        System.out.println("Point: "+point);
    }
    @Override
    public String toString() {
        return "InformationPlayer{" + "point=" + point + ", email=" + email + '}';
    }
    
}

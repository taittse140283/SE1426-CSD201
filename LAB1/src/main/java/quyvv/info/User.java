/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quyvv.info;

/**
 *
 * 
 * @author Quy
 */
public class User {
    private String Email;
    private int Point;

    public User() {
    }

    public User(String Email, int Point) {
        this.Email = Email;
        this.Point = Point;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int Point) {
        this.Point = Point;
    }
    
    
}

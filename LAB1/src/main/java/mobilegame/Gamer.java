/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

/**
 *
 * @author Admin
 * 
 */

public class Gamer {
    //info of gamer
    private String email;
    private long point;

    public Gamer() {
    }
/**
 * 
 * @param email
 * @param point 
 */
    public Gamer(String email, long point) {
        this.email = email;
        this.point = point;
    }
    public static Gamer add(String email, long point) {
       return new Gamer(email,point);
    }

    public String getEmail() {
        return email;
    }

    public long getPoint() {
        return point;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoint(long point) {
        this.point = point;
    }
/**
 * 
 * @return info of gamer 
 */
    @Override
    public String toString() {
        return "Gamer{" + "email=" + email + ", point=" + point + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tri
 */
public class Gamer {
    private String email;
    private int point;

    public Gamer(String email, int point) {
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

    public void printInfo(){
        System.out.printf("%s|%d\n",this.email,this.point);
    }
    
    
}

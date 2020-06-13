/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author Admin
 */
public class Player {
    private String email;
    private int point;

    public Player() {
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
    
    public void print(){
        System.out.println("Email"+"\t\t"+"Point");
        System.out.println(email+"\t\t"+point);
    }
}

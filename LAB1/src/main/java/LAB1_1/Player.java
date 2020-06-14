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

    private Player(String email, int point) {
        this.email = email;
        this.point = point;
    }

    public static Player Create(String email, int point) {
        return new Player(email, point);
    }

    public long getPoint() {
        return this.point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return this.email + ", " + this.point;
    }
}

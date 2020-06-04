/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Player implements Comparable<Player> {

    private String userName;
    private String email;
    private long point;

    public Player() {
    }

    public Player(String userName, String email, int point) {
        this.userName = userName;
        this.email = email;
        this.point = point;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    //sap xep giam dan theo so diem nguoi choi dat duoc
    @Override
    public int compareTo(Player o) {
        return this.getPoint() < o.getPoint() ? 1 : this.getPoint() > o.getPoint() ? -1 : 0;
    }

}

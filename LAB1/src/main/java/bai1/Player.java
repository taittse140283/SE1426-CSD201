/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author Admin
 */
public class Player {
    //Class luu tru thong tin nguoi choi bao gom email va diem
    //Chua constructor, cac ham getter, setter va override toString() de output chuan dang: email,point;
    //Chua nghien cuu cach ghi comment chuan nen cu ghi nhu nay truoc da
    private String email;
    private int point;
    

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

    @Override
    public String toString() {
        return email+","+point;
    }
    
    
}

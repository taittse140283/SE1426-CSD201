/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;
/**
 *
 * @author PC
 */
public class Information {
    private String email;
    private int point;
    
    public Information(){}
    //contructor không tham số
    
    public Information(String email, int point){
        this.email = email;
        this.point = point;
    }
    //contructor có tham số

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
    //tạo seter, getter để nhận giá trị
    
    public String toString(){
        return "Email: " + email + "| Point: " + point;
    }
    //In ra email và điểm của người chơi;
}

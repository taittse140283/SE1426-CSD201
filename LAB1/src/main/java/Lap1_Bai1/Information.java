/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;
import java.util.Scanner;
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
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        email = sc.nextLine();
        System.out.println("Enter your point: ");
        point = sc.nextInt();
    }
    //giá trị nhập vào thông tin email, điểm của người chơi; không giá trị trả về
    
    public void output(){
        System.out.println("The player " + email + " have " + point + "point");
    }
    //trả về giá trị email và điểm của người chơi; không giá trị nhập vào
}

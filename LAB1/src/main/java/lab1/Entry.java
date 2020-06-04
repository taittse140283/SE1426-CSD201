/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */
import java.util.Scanner;
public class Entry {
    Scanner sc= new Scanner(System.in);
    private String _email; // entry variable
    private int _point;    // entry variable
    public Entry(String email, int point){ //constructor have parametter;
        _email=email;
        _point=point;
    }
    public Entry(){}//constructor have no parametters

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public int getPoint() {
        return _point;
    }

    public void setPoint(int _point) {
        this._point = _point;
    }
    
    // Enter input information of player include email and point;
    public void input(){
        System.out.println("Please enter the email:");
        _email=sc.nextLine();
        System.out.println("Enter the your point:");
        _point=sc.nextInt();
        
    }
    //method to print the display
     public String toString(){
        return "(" +_email + "," +_point +")" ;
    }
    
    
     
}

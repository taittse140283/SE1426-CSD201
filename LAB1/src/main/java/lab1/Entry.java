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

public class Entry {
    
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
    //this method print to the display
   public voi ouput(){
        System.out.print("email: " + _email +",Point: " + _point);
}
   
    //method to print the display
    //return the value of information you entered
     public String toString(){
        return "(" +_email + "," +_point +")" ;
    }
    
    
     
}

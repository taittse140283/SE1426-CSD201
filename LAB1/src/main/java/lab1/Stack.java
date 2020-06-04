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
public interface Stack {
    public void add(String new_email);
    public void delete(String email);
    public void update(String email);
    public void get(String email);
    public void getMax(String email);
    public void deleteMax(String email);
    public String toString();
    
}

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
public interface Stack<Entry> {
    public void add(Entry infor);
    public Entry remove();
    public  int size();
    public Entry top();
    public boolean isEmpty();
    public String toString();

    
}

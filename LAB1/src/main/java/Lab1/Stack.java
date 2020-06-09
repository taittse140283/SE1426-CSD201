/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author Admin
 */
public interface Stack<Player> {
    public void add(Player data);
    public Player remove();
    public int size();
    public boolean isEmpty();
    public void print();
}

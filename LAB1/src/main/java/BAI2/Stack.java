/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI2;

/**
 *
 * @author Thuan Le
 */
public interface Stack<E> {
    int size();
    boolean isEmpty();
    void push(E element);
    E top();
    E pop();
}

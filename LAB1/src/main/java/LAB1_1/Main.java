/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author TAN
 */
public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = FileInOut.getFile("user.csv");
        FileInOut.writeFile("outputPlayer.csv",queue);
    }
}

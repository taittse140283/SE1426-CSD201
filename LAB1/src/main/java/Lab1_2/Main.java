/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

/**
 *
 * @author hiep
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        String url = "https://vnexpress.net/";
        String file = "output1.csv";
        manager.Manager(url,file);
    }
}

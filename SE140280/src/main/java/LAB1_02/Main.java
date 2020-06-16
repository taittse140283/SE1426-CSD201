/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_02;

/**
 *
 * @author ZunPeter
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Management manager = new Management();
        String url = "https://www.vietnamworks.com/";
        String file = "output.csv";
        manager.Manager(url, file);
        
    }
}

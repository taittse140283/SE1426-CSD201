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
public class MainLAB1_2 { 
    public static void main(String[] args) {
        String url = "https://hamtruyen.com/";
        String file = "outputlab2.csv";
        Manager run = new Manager();
        run.runLab2(url, file);
    }
            
}

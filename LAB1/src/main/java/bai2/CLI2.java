/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Admin
 */
import java.util.HashMap;
public class CLI2 {
     Manager manager = new Manager();
    public void parsingArguments(String[] args){
        if(args.length==2){
            manager.Manager(args[0],args[1]);
            System.out.println("Xong ~!");
        }
        else{
            System.out.println("Error");
        }
    }
}

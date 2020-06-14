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
public class Argument2 {
    Manager obj = new Manager();
    public void parsingArgument(String[] args){
        if(args.length == 2){
            obj.runLab2(args[0], args[1]);
            System.out.println("Finished.");
        }else{
            System.out.println("Error");
        }
    }
}

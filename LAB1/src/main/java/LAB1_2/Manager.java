/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

/**
 *
 * @author TAN
 */
public class Manager {
    public void analyzeTag(String s){
        String tag="";
        boolean check = false;
        for(int i = 0;i < s.length(); i++){
            if(s.charAt(i) == '<'){
                tag = "<";
                check = true;
            }
            else if(check = true && s.charAt(i) == '-'){
                tag = tag + "-";
                check = false;
            }
            else if(check = true && s.charAt(i) != '>'){
                tag = tag + s.charAt(i);
            }
            else if(check == true && s.charAt(i) == '>'){
                tag = tag + ">";
                check = false;
            }
        }
    }
}

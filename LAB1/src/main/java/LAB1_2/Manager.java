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
    // kiem tra tagHTML
    public void analyzeTag(String s){
        String tag="";
        boolean check = false;
        // chay vong lap cho chuoi
        for(int i = 0;i < s.length(); i++){
            // kiem tra cho phai the HTML hay khong
            if(s.charAt(i) == '<'){
                tag = "<";
                check = true;
            }
            // kiem tra co phai the comment 
            else if(check = true && s.charAt(i) == '-'){
                tag = tag + "-";
                check = false;
            }
            // bo qua noi dung trong the HTML
            else if(check = true && s.charAt(i) != '>'){
                tag = tag + s.charAt(i);
            }
            // kiem tra cac the con lai
            else if(check == true && s.charAt(i) == '>'){
                tag = tag + ">";
                check = false;
            }
        }
    }
}

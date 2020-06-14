/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class Manager {
     HashMap<String,Integer> hashmap = new HashMap<>(); 
    Stack stack = new Stack();
    GetURl get = new GetURl();
    
    
    /**this method will check co phai cac loai tagHTML? base on character "<", ">" "-"
     * @param is the content of URL
     */
    public void analyzeTag(String content){
        String tag="";
        boolean check = false;
        
        for(int i = 0;i < content.length(); i++){
            // kiem tra cho phai the HTML hay khong
            if(content.charAt(i) == '<'){
                tag = "<";
                check = true;
            }
            // kiem tra co phai the comment 
            else if(content.charAt(i) == '-' && check == true) {
                tag = tag + "-";
                processTag(tag);
                check = false;
            }
            // bo qua noi dung trong the HTML
            else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true) {
                tag = tag + content.charAt(i);
            }
            // kiem tra cac the con lai va cac the dac biet (ex : <link href ... >)
            else if(((content.charAt(i) == '>') || (content.charAt(i) == ' ')) && check == true) {
                tag = tag + ">";
                check = false;
                processTag(tag);
            }
        }
    }
}

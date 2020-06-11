/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

import java.util.HashMap;

/**
 *
 * @author TAN
 */
public class Manager {
    HashMap<String,Integer> hashmap = new HashMap<>(); //tao hashmap
    Stack stack = new Stack();
    GetWebsite get = new GetWebsite();
    WriteToFile wr = new WriteToFile();
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
            else if(check = true && s.charAt(i) != '>' && s.charAt(i) != ' '){
                tag = tag + s.charAt(i);
            }
            // kiem tra cac the con lai va cac the dac biet (ex : <link href ... >)
            else if(check == true && (s.charAt(i) == '>' || s.charAt(i) != ' ')){
                tag = tag + ">";
                check = false;
            }
        }
    }
    // dem cac tag trong the HTML
    public void count(String tag){
         if(hashmap.containsKey(tag) == false) {
            hashmap.put(tag, 1);
        }
        else {
            hashmap.put(tag, hashmap.get(tag) + 1);
        }
    }
    public void processTag(String tag){
        //kiem tra cac the co the dong trong HTML
        if(tag.contains("</") == false) {
            stack.push(tag);   // neu khong co the dong thi push tag vao stack
            stack.print(); 
            System.out.println("\n");
        }
        //kiem tra the dong voi the mo trong HTML
        else if(stack.Top().equalsIgnoreCase(tag.replace("/", "")) == true) {
            stack.pop(); 
            count(tag);
            stack.print();
            System.out.println("\n");
        }
        // kiem tra cac the dac biet
        else{
            if(tag.equalsIgnoreCase("area"))
                count(tag);
            else if(tag.equalsIgnoreCase("base"))
                count(tag);
            else if(tag.equalsIgnoreCase("br"))
                count(tag);
            else if(tag.equalsIgnoreCase("command"))
                count(tag);
            else if(tag.equalsIgnoreCase("embeb"))
                count(tag);
            else if(tag.equalsIgnoreCase("hr"))
                count(tag);
            else if(tag.equalsIgnoreCase("img"))
                count(tag);
            else if(tag.equalsIgnoreCase("input"))
                count(tag);
            else if(tag.equalsIgnoreCase("<!DOCTYPE>"))
                count(tag);
            else if(tag.equalsIgnoreCase("<![endif]-->"))
                count("<![endif]-->");
            else if(tag.equalsIgnoreCase("meta"))
                count(tag);
            else if(tag.equalsIgnoreCase("param"))
                count(tag);
            else if(tag.equalsIgnoreCase("track"))
                count(tag);
            else if(tag.equalsIgnoreCase("wbr"))
                count(tag);
        }
    }
    public void Manager(){
        
    }
}

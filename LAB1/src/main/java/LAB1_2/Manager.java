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
    public void analyzeTag(String content){
        String tag="";
        boolean check = false;
        // chay vong lap cho chuoi
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
    // dem cac tag trong the HTML
    public void count(String tag){
         if(hashmap.containsKey(tag) == false) {
            hashmap.put(tag, 1);
        }
        else {
            hashmap.put(tag, hashmap.get(tag) + 1);
        }
    }
    public void processTag(String tag) {
        // kiem tra cac the dac biet
        if (tag.equalsIgnoreCase("<area>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<base>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<br>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<command>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<!DOCTYPE>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<!-")) {
            count("<!--comment-->");
        } else if (tag.equalsIgnoreCase("<embeb>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<hr>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<img>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<input>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<link>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<meta>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<param>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<track>")) {
            count(tag);
        } else if (tag.equalsIgnoreCase("<wbr>")) {
            count(tag);
        } else {
            //kiem tra cac the co the dong trong HTML
            if (tag.contains("</") == false) {
                stack.push(tag);   // neu khong co the dong thi push tag vao stack
                count(tag);
                stack.print();
                System.out.println();
            } //kiem tra the dong voi the mo trong HTML
            else if (stack.Top().equalsIgnoreCase(tag.replace("/", "")) == true) {
                stack.pop();
                stack.print();
                System.out.println();
            }
        }
    }
    public void Manager(String url , String fileName){
        String content;
        try {
            content = get.readContent(url);
            analyzeTag(content);
            wr.WriteToFile(hashmap,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

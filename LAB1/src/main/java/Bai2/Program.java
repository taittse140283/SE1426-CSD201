/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Asus
 */
public class Program{
   public class Stack {
      TgHTML head, tail;
    public Stack() {
        head = tail = null;
    }
    public void push(String tag) {
        TgHTML t = new TgHTML(tag, head, tail);
        if(head == null) {
            head = t;
            head.prev = null;
            tail = t;
            tail.NEXT = null;
            return;
        }
        t.prev = tail;
        tail.NEXT = t;
        tail = t;
        tail.NEXT = null;
    }
    public void pop() {
        if(head == null)
            return;
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.NEXT = null;
    }
    public String getTop() {
        return tail.getTagHTML();
    }
    public void print() {
        for(TgHTML t = head; t != null; t = t.NEXT)
            System.out.print(t.getTagHTML() + "   ");
    }
}
    Website g = new Website();
    WritetoFile csv = new WritetoFile();
    Stack s = new Stack();
    Map<String, Integer> map= new HashMap<>();
    public Program(String urlWeb, String fileName) {
        try {
            String content = g.readContent(urlWeb);
            System.out.println("The processing is running:");
            analyzeHTMLTag(content);
            csv.WritetoFile(fileName);
            
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    public void analyzeHTMLTag(String content) {
        String tag = "";
        boolean check = false;
        
        for(int i = 0; i < content.length(); i++) {
            if(content.charAt(i) == '<') {
                tag = "<";
                check = true;
            }
            else if(content.charAt(i) == '-' && check == true) {
                tag = "";
                check = false;   
            }
            else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true) {
                tag += content.charAt(i);
            }
            else if(((content.charAt(i) == '>') || (content.charAt(i) == ' ')) && check == true) {
                tag += ">";
                check = false;
                HTMLTag(tag);
            }
        }
    }
    public void HTMLTag(String tag) {
}
}

    
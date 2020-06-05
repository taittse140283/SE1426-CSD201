/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author Linh
 */
public class Main {
    public static void main(String[] args) throws Exception {
        
        //Kiem tra cac function cua stack
//        Stack s = new Stack();
//        s.push("<html>");
//        s.push("<a>");
//        s.push("<body>");
//        s.push("<img>");
//        s.push("<style>");
//        s.print();
//        System.out.println();
//        s.pop();
//        s.pop();
//        s.pop();
//        s.print();

        //Testing GetContentFromWebsite
        String url = "https://vnexpress.net/";
        String s = null;
        GetContentFromWebsite g = new GetContentFromWebsite();
        s = g.readContent(url);
        for(int i = 0; i < s.length(); i++)
            System.out.print(s.charAt(i));
       
    }
}

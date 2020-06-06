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
      
        //Testing analyzeHTMLTag
        String url = "http://example.com/";
        String s = null;
        GetContentFromWebsite g = new GetContentFromWebsite();
        s = g.readContent(url);
//        for(int i = 0; i < s.length(); i++)
//            System.out.print(s.charAt(i));
       Program p = new Program(url);
       p.analyzeHTMLTag(s);
    }
}

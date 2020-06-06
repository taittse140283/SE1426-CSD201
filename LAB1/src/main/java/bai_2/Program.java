/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 * Analysis and processing the HTML tag
 * @author Linh
 */
public class Program {
    GetContentFromWebsite g = new GetContentFromWebsite();
    CSV csv = new CSV();
    Stack s = new Stack();

    public Program(String urlWeb) {
        try {
            String content = g.readContent(urlWeb);
            analyzeHTMLTag(content);
            csv.print(); //Testing count function
            
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    //Find a HTML tag from the content
    public void analyzeHTMLTag(String content) {
        String tag = "";
        boolean check = false;
        
        //Checking each character with loop
        for(int i = 0; i < content.length(); i++) {
            
            // '<' is begin of every tag
            if(content.charAt(i) == '<') {
                tag = "<";
                check = true;
            }
            
            // Only comment tag has '-' character => <!--comment-->
            else if(content.charAt(i) == '-' && check == true) {
                tag += "-";
                processingHTMLTag(tag);
                check = false;
                
            }
            
            //Normal character => write append this character to tag
            else if(content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true) {
                tag += content.charAt(i);
            }
            
            // '>' is a end character of every tag
            // We can determined some special tag with white space
            else if(((content.charAt(i) == '>') || (content.charAt(i) == ' ')) && check == true) {
                tag += ">";
                check = false;
                processingHTMLTag(tag);
            }
        }
    }
    
    //Counting and compare close tag and top of stack tag
    public void processingHTMLTag(String tag) {
        
        //There are very many special tags
        //I only can list some of them
        //such as: !DOCTYPE, comment, meta, link, img...
        if(tag.equalsIgnoreCase("<!DOCTYPE>"))
            csv.countingFrequenceAppearance(tag);
        else if(tag.equalsIgnoreCase("<!-"))
            csv.countingFrequenceAppearance("<!--comment-->");
        else if(tag.equalsIgnoreCase("<meta>"))
            csv.countingFrequenceAppearance(tag);
        else if(tag.equalsIgnoreCase("<link>"))
            csv.countingFrequenceAppearance(tag);
        else if(tag.equalsIgnoreCase("<img>"))
            csv.countingFrequenceAppearance(tag);
        else if(tag.equalsIgnoreCase("<br>"))
            csv.countingFrequenceAppearance(tag);
        else if(tag.equalsIgnoreCase("<hr>"))
            csv.countingFrequenceAppearance(tag);
        else if(tag.equalsIgnoreCase("<input>"))
            csv.countingFrequenceAppearance(tag);
        else if(tag.equalsIgnoreCase("<![endif]-")) //This is not a comment
            csv.countingFrequenceAppearance("<![endif]-->");
        
        //Compare close tag and top of stack tag
        else {
            if(tag.contains("</") == false) {
                s.push(tag); //If it is not a close tag => push this to stack
                s.print(); //print to screen for testing
                System.out.println();
            }
            //If is a close tag and it equals top of stack tag => pop it out off of stack
            else if(s.getTop().equalsIgnoreCase(tag.replace("/", "")) == true) {
                s.pop(); 
                s.print(); //print to screen for testing
                System.out.println();
            }
        } 
    }
}

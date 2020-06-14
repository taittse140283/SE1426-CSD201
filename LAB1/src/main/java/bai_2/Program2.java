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
public class Program2 {
    GetContentFromWebsite g = new GetContentFromWebsite();
    CSV csv = new CSV();
    Stack s = new Stack();

    /**
     * Solve Problem 2
     * @param urlWeb
     * @param fileName 
     */
    public Program2(String urlWeb, String fileName) {
        try {
            if(!urlWeb.contains("https://"))
                urlWeb = "https://" + urlWeb;
            
            String content = g.readContent(urlWeb);
            System.out.println("The processing push và pop the tag in stack:");
            analyzeHTMLTag(content);
            csv.print(); //Testing count function
            csv.sortAndWriteToFile(fileName);
            
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    
    /**
     * Find a HTML tag from the content
     * @param content
     */
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
            
            // Only comment tag has '-' character => ignore it and keep checking another tag
            else if(content.charAt(i) == '-' && check == true) {
                tag = "";
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
    
    /**
     * Processing and count tag
     * Too many single tag in HTML, i only can list some of them below
     * To compare the open tag with the close tag,
     *      if the tag not contain '/' => it is a open tag, then i push it into stack
     *      if the tag has '/', i remove it and compare it with the top tag of stack
     *           if them similar, i pop the top tag of stack out off the stack and count
     * @param tag  
     */
    public void processingHTMLTag(String tag) {
        
        //There are very many special tags
        //such as: !DOCTYPE, comment, meta, link, img...
        if(tag.equalsIgnoreCase("<!DOCTYPE>"))
            csv.countingFrequenceAppearance(tag);
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
        
        //Compare close tag with top of stack tag
        else {
            if(tag.contains("</") == false) {
                s.push(tag);//If it is not a close tag => push this to stack
                s.print(); //print to screen for testing
                System.out.println();
            }
            //If is a close tag and it equals top of stack tag => pop it out off of stack
            else if(s.getTop().equalsIgnoreCase(tag.replace("/","")) == true) {
                s.pop(); 
                csv.countingFrequenceAppearance(tag.replace("/",""));
                s.print(); //print to screen for testing
                System.out.println();
            }
        } 
    }
}

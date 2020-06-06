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

    public Program(String urlWeb) {
        try {
            String content = g.readContent(urlWeb);
            analyzeHTMLTag(content);
            
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
    
    public void processingHTMLTag(String tag) {
        
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
        else{
            
        }
    }
}

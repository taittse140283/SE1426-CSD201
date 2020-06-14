/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author W10
 * Build Stack structure to store Web tag
 */
public class WebStack {
    WebsiteInfo head,tail;//tao pointer 

    public WebStack() {
        head = tail = null;
    }
    public boolean isEmpty(){
        return tail == null;
    }
    
    /**
     * Them node vao , neu rong thi node la head
     * @param tag 
     */
    public void push(String tag) {
        WebsiteInfo web_tag = new WebsiteInfo(tag, head, tail);
        if(isEmpty()) {
            head = web_tag;
            head.pre = null;
            tail = web_tag;
            tail.next = null;
            return;
        }
        web_tag.pre = tail;
        tail.next = web_tag;
        tail = web_tag;
        tail.next = null;
    }
    
    /**
     * Xoa node trong stack
     */
    public void pop() {
        if (isEmpty()) {
            System.err.print("Stack rong");
        }
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.pre;
        tail.next = null;
    }
    
    public String getTop() {
        return tail.getTag();
    }
    
   /**
    * In so tag trong web
    */
    public void print() {
        for(WebsiteInfo web = head; web != null; web = web.next)
            System.out.print(web.getTag() + "   ");
    }
}
    webContent g = new webContent();
    SortandWritetoFile csv = new SortandWritetoFile();
    Stack s = new Stack();
    Map<String, Integer> map= new HashMap<>();
    /**
     * This is constructor with parameter 
     * @param urlWeb
     * @param fileName 
     */
    public checkWeb(String urlWeb, String fileName) {
        try {
            String content = g.readContent(urlWeb);
            System.out.println("The processing is running:");
            analyzeHTMLTag(content);
            csv.sortAndWriteToFile(fileName);
            
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    /**
     *This method below here is used to find the tag of websites by checking the first and ending characters(<),(>)
     * Input data: each line in file html (content)
     * Output data: no
     * @param content
     */
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
                processingHTMLTag(tag);
            }
        }
    }
    /**
     * This method below here is used to count special tag and compared to the end character of the tag(compare open and close tag)
     * with "/" it means it the close tag. Without "/", it means it the open tag
     * Input data is tag
     * Output no
     */
    public void processingHTMLTag(String tag) {
        if(tag.equalsIgnoreCase("<!DOCTYPE>"))
            csv.countTag(tag);
        else if(tag.equalsIgnoreCase("<meta>"))
            csv.countTag(tag);
        else if(tag.equalsIgnoreCase("<link>"))
            csv.countTag(tag);
        else if(tag.equalsIgnoreCase("<img>"))
            csv.countTag(tag);
        else if(tag.equalsIgnoreCase("<br>"))
            csv.countTag(tag);
        else if(tag.equalsIgnoreCase("<hr>")){
            csv.countTag(tag);
        }
        else if(tag.equalsIgnoreCase("<input>")){
            csv.countTag(tag);
        }          
        else if(tag.equalsIgnoreCase("<audio>")){
            csv.countTag(tag);
        }
        else if(tag.equalsIgnoreCase("<video>")){
            csv.countTag(tag);
        }
        else {
            if(tag.contains("</") == false) {
                s.push(tag);
                s.print(); 
                System.out.println();
            }
            else if(s.getTop().equalsIgnoreCase(tag.replace("/","")) == true) {
                s.pop(); 
                csv.countTag(tag.replace("/",""));
                s.print();
                System.out.println();
            }
        } 
    }
}

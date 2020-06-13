/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;



/**
 *
 * @author Dell
 */
public class checkWeb{
    /**
     * Creat class Stack to store data 
     */
   public class Stack {
      InfoTagWeb head, tail;
    
    /**
    *This is constructor with no parameter
    */
    public Stack() {
        head = tail = null;
    }
    
    /**
     * This method below here is used to add new node behind the tail and move tail to new node
     * Input data is tag
     * Output data: no
     * @param tag 
     */
    public void push(String tag) {
        InfoTagWeb t = new InfoTagWeb(tag, head, tail);
        if(head == null) {
            head = t;
            head.prev = null;
            tail = t;
            tail.next = null;
            return;
        }
        t.prev = tail;
        tail.next = t;
        tail = t;
        tail.next = null;
    }
    
    /**
     * This method below here is used to check head and tail of node. If only 1 node in stack, head and tail is null
     * Input data: no
     */
    public void pop() {
        if(head == null)
            return;
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    
    /**
     * This method below here is used to return tail
     * Input data: no
     * Output data: no
     * @return 
     */
    public String getTop() {
        return tail.getTag();
    }
    
   /**
    * This method below here is used to print the data in stack
    * Input data: no
    * Output data: tag,head,tail
    */
    public void print() {
        for(InfoTagWeb t = head; t != null; t = t.next)
            System.out.print(t.getTag() + "   ");
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
}

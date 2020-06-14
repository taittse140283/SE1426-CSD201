/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

import java.util.HashMap;

/**
 *
 * @author hiep
 */
public class Manager {

    HashMap<String, Integer> hs = new HashMap<>();
    Stack s = new Stack();
    getURL get = new getURL();
    WriteFile w = new WriteFile();

    /**
     * this method count the tag in the URL
     *
     * @param is tag
     */
    public void count(String tag) {
        if (hs.containsKey(tag) == false) {
            hs.put(tag, 1);
        } else {
            hs.put(tag, hs.get(tag) + 1);
        }
    }

    /**
     * this method check kind of tag and count
     *
     * @param is tag
     */
    public void checkTag(String tag) {
        // check special tag 
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

            if (tag.contains("</") == false) {
                s.push(tag);
                count(tag);
                s.print();
                System.out.println();
            } else if (s.Top().equalsIgnoreCase(tag.replace("/", "")) == true) {
                s.pop();
                s.print();
                System.out.println();
            }
        }
    }

    /**
     * this method check tag with "<", ">" "-"
     *
     * @param is content of URL
     */
    public void solveTag(String content) {
        String tag = "";
        boolean check = false;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == '<') {
                tag = "<";
                check = true;
            } else if (content.charAt(i) == '-' && check == true) {
                tag = tag + "-";
                checkTag(tag);
                check = false;
            } else if (content.charAt(i) != '>' && content.charAt(i) != ' ' && check == true) {
                tag = tag + content.charAt(i);
            } else if (((content.charAt(i) == '>') || (content.charAt(i) == ' ')) && check == true) {
                tag = tag + ">";
                check = false;
                checkTag(tag);
            }
        }
    }
        /**
     * this method read content and write to file after check tag
     * @param a url and file name
     */
    public void Manager(String url , String fileName){
        String content;
        try {
            content = get.readContent(url);
            checkTag(content);
            w.WriteFile(hs,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

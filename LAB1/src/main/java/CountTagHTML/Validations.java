/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountTagHTML;


/**
 *
 * @author Loi Lam
 */
public class Validations {

    ReadLine rl = new ReadLine();
    FileCSV csv = new FileCSV();
    Stack s = new Stack();

    //read line of urlWeb, sort and write to file
    public Validations(String urlWeb, String fileName){
        try {
            String content = rl.readLine(urlWeb);
            System.out.println("Processing push and pop the tag in stack");
            splitTagHTML(content);
            csv.print();
            csv.sortAndPrint(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //check tag html in content
    public void splitTagHTML(String content){
        String tag = "";
        boolean check = false;
        
        //check each character with loop
        for(int i = 0; i < content.length(); i++){
            //'<' is begin of every tag
            if(content.charAt(i) == '<'){
                tag = "<";
                check = true;
            }
            //ignore comment tag '-' and keep checking another tag
            else if(content.charAt(i) == '-' && check == true){
                tag = "";
                check = false;
            }
            //write append normal character to tag
            else if(content.charAt(i) != '>' && content.charAt(i) == ' ' && check == true){
                tag += content.charAt(i);
            }
            //'>' is end of every tag
            else if(((content.charAt(i) =='>') || (content.charAt(i) == ' ')) && check == true){
                tag += ">";
                check = false;
                defineTagHTML(tag);
            }
        }
    }
    
    //define and ignore some tag
    public void defineTagHTML(String tag){
        //some tag need ignore
        //
        if(tag.equalsIgnoreCase("<!DOCTYPE>")){
            csv.countTag(tag);
        }else if(tag.equalsIgnoreCase("<meta>")){
            csv.countTag(tag);
        }else if(tag.equalsIgnoreCase("<link>")){
            csv.countTag(tag);
        }else if(tag.equalsIgnoreCase("<img>")){
            csv.countTag(tag);
        }else if(tag.equalsIgnoreCase("<hr>")){
            csv.countTag(tag);
        }else if(tag.equalsIgnoreCase("<input>")){
            csv.countTag(tag);
        }
        //compare close tag with top of stack tag
        else {
            if(tag.contains("</") == false){
                s.pop();
                csv.countTag(tag.replace("/", ""));
                s.print();
                System.out.println();
            }
            //pop tag out off of stack if it is a close tag and it equals top of stack tag
            else if(s.getTop().equalsIgnoreCase(tag.replace("/", "")) == true){
                s.pop();
                csv.countTag(tag.replace("/", ""));
                s.print();
                System.out.println();
            }
        }
    }
    
    
}

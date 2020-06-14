/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CountTagHTML;

import java.io.IOException;

/**
 *
 * @author Loi Lam
 */
public class Validations {

    ReadLine rl = new ReadLine();
    FileCSV csv = new FileCSV();
    Stack s = new Stack();

    //read line of urlWeb, sort and write to file
    public Validations(String urlWeb, String fileName) throws IOException {
        try {
            String content = rl.readLine(urlWeb);
            System.out.println("Processing push and pop the tag in stack");
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
                
            }
        }
    }
    
    //define and ignore some tag
    public void defineTagHTML(String tag){
        
    }
}

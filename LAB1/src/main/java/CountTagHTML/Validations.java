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
    
    //read line of urlWeb, print and sort
    public Validations(String urlWeb, String fileName) throws IOException{
        String content = rl.readLine(urlWeb);
        System.out.println("Processing push and pop the tag in stack");
        csv.print();
        csv.sortAndPrint(fileName);
    }
}

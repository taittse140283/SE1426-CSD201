/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLI;

import BAI2.Argument2;
import BAI1.Argument;
import java.util.Arrays;
/**
 *
 * @author Thuan Le
 */
public class Main {
    public static void main(String[] args) {
        Argument lab1 = new Argument();
        Argument2 lab2 = new Argument2();
        String help = "Help: \n"  +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file"+
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file"+
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file"+
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file"+
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre"+
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre"+
                "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file";
        
        
        try {
            if(args.length == 0){
                System.out.println(help);
            }else if(args.length > 0){
                String[] nextArgument = Arrays.copyOfRange(args, 1, args.length);
                if(args[0].equals("1")){
                    lab1.parsingArgument(nextArgument);                    
                }else if(args[0].equals("2")){
                    lab2.parsingArgument(nextArgument);
                }else if(args[0].equals("-h")){
                    System.out.println(help);
                }else{
                    System.out.println("Nhap sai cu phap, xin nhap lai");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  
}

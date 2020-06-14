/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bai_1.Program1;
import bai_2.Program2;
import java.util.Arrays;
/**
 *
 * @author tieuminh
 */
public class Main {

    /**
     * Help
     */
    static String help = ("Help: \n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n" +
        "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Program1 p1 = new Program1();
        Program2 p2;
        
        try{
            if(args.length <= 0)
                System.out.println(help);
            else if(args.length > 0) {
                if(args[0].equals("-h"))
                    System.out.println(help);
                else if(args[0].equals("1")) {
                    String[] arguments = Arrays.copyOfRange(args, 1, args.length);
                    p1.parsingArgs(arguments);
                }
                else if(args[0].equals("2")) {
                    if(args.length == 3)
                        p2 = new Program2(args[1], args[2]);
                    else
                        System.out.println("Not valid argument!");
                }
                else
                    System.out.println("Not valid argument!");
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}

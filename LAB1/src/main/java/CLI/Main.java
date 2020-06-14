package CLI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tieuminh
 */
import LAB1_1.MainPlayer;
import LAB1_2.MainHTMLTag;

import java.util.Arrays;
public class Main {
    //CLI LAB1
    public static void main(String[] args) {
        MainPlayer LAB1_1=new MainPlayer();
        MainHTMLTag LAB1_2=new MainHTMLTag();
        String helps="Help: \n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n" +
                "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file";
        try {
            if (args.length == 0) {
                System.out.println(helps);
            } else if (args.length > 0) {
                String[] nextArguments = Arrays.copyOfRange(args, 1, args.length);
                if (args[0].equals("1")) {
                    LAB1_1.parsingArguments(nextArguments);
                } else if (args[0].equals("2")) {
                    LAB1_2.parsingArguments(nextArguments);
                } else if (args[0].equals("-h")) {
                    System.out.println(helps);
                } else {
                    System.out.println("SAI CU PHAP!");
                }
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
    


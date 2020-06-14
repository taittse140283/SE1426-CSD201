/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author truong
 */
public class Testter {

    static String tutorials
            = "java -jar LAB1.jar -h\r\n"
            + "Help: \r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\r\n"
            + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\r\n"
            + "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file";

    public static void main(String[] args) throws IOException {
        bt1 bt = new bt1();
        if (args.length > 0) {
            final String[] parametersRemovedProblemID = Arrays.copyOfRange(args, 1, args.length);
            //remove the problemID from parameter, leave the rest

            switch (args[0]) {
                case "1":
                    bt.PRGS(args);
                    break;

                case "-h":
                    System.out.println(tutorials);
                    break;
                default:
                    System.out.println("Not valid arguments, please see tutorial\n" + tutorials);
                    break;
            }
        }
    }
}

    


import CountTagHTML.Validations;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Loi Lam
 */
public class CLI {

    static String help = ("\n"
            + "Help: \n"
            + "java -jar DemoLab1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n"
            + "java -jar DemoLab1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n"
            + "java -jar DemoLab1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n"
            + "java -jar DemoLab1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n"
            + "java -jar DemoLab1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n"
            + "java -jar DemoLab1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n"
            + "java -jar DemoLab1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n"
            + "java -jar DemoLab1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
    //test run

    public static void main(String[] args) throws Exception, MalformedURLException {
        String url = null;
        String file = null;
        if (args[0].equals("-h")) {
            System.out.println(help);
        } else {
            url = args[1];
            file = args[2];
            Validations p = new Validations(url, file);
        }
    }
}

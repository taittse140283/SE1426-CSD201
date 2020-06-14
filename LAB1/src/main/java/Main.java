/**
 *
 * @author SE140834
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import problem1.*;
import problem2.*;

public class Main {
    final String HELP = "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n" +
        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n" +
        "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file\n";
    private int find(String[] a, String st) {
        int result = -1;
        for (int i = 0; i < a.length; i++)
            if (a[i].equals(st)) { result = i; break; }
        return result;
    }
    private String checkFormat(String[] args) {
        String result = "";
        String problem = args[0];
        if (args.length == 0 || problem.equals("-h")) result = HELP;
        else if (problem.equals("1")) {
            if (find(args, "-r") == -1) result = "Please enter input file option!";
            else if (find(args, "-1") + 1 >= args.length) result = "File name not found!";
        } else if (problem.equals("2")) {
            if (args.length < 3) result = "Incorrect format!";
        } else result = "Cannot find the problem!";
        return result;
    }
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public void main(String[] args) throws FileNotFoundException, IOException {
        String msg = checkFormat(args);
        if (msg.equals("") && args[0].equals("1")) {
           try {
               Problem1 problem1 = new Problem1();
               problem1.readFile(args[find(args, "-r") + 1]);
               if ()
           } 
           catch (FileNotFoundException e) {
               e.printStackTrace();
           }
           catch (IOException e) {
               e.printStackTrace();
           }
        } else if (msg.equals("") && args[0].equals("2")) {
            
        } else System.out.print(msg);
    }
}
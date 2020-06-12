import bai1.PlayerManager;
import bai2.HTMLTagManager;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PlayerManager prb1lab1=new PlayerManager();
        HTMLTagManager prb2lab1=new HTMLTagManager();
        String helps="java -jar LAB1.jar -h\n" +
                "Help: \n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n" +
                "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n" +
                "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file";
        String[] nextArguments= Arrays.copyOfRange(args,1,args.length);
        if(args.length==0)
        {
            System.out.println(helps);
        }
        else if(args.length>0) {
            if (args[0].equals("1")) {
                prb1lab1.parsingArguments(nextArguments);
            } else if (args[0].equals("2"))
            {
                prb2lab1.parsingArguments(nextArguments);
            }
            else if(args[0].equals("-h"))
            {
                System.out.println(helps);
            }
            else
            {
                System.out.println("Error: The problem name is not correct!");
            }
        }

    }
}

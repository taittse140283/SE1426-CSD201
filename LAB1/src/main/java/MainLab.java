
import Lap1_Bai1.Manager;
import Lap1_Bai2.HTMLCount;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author PC
 */
public class MainLab {
    private static int contains(String[] arr, String value) {
	int result = -1;

	for (int i = 0; i < arr.length; i++) {
	    if (arr[i].equals(value)) {
		result = i;
	    }
	}
	return result;
    }

    private static String CLIcheck(String[] args) {
	String result = "";
	if (args.length != 0 && !args[0].equals("-h")) {
	    if (!args[0].equals("1") && !args[0].equals("2")) {
		result = result + "Error: The problem name is not correct !";
	    } else if (args[0].equals("1") && contains(args, "-r") == -1) {
		result = result + "Error: No user input file !";
	    } else if (args[0].equals("1") && contains(args, "-r") != -1 && contains(args, "-r") + 1 >= args.length) {
		result = result + "Error: No input filename !";
	    } else if (args[0].equals("2") && args.length < 3) {
		result = result + "Error: Your CLI format is not correct !";
	    }
	} else {
	    result += "Help:\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data structure into csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data structure and save to new csv file\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data structure\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
	    result += "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
	    result += "./lab1 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file\n";
	}

	return result;
    }

    public static void main(String[] args) {
	Manager e1 = new Manager();
	HTMLCount e2 = new HTMLCount();
	String msg = CLIcheck(args);
	if (msg.equals("") && args[0].equals("1")) {
	    try {
		e1.inputCLI(args);
	    } catch (IOException e) {
		System.out.println("Can't save file!!");
	    } catch (Exception e) {
		System.out.println("Can't find the input file");
	    }
	} else if (msg.equals("") && args[0].equals("2")) {
	    try {
		e2.inputCLI(args[1], args[2]);
	    } catch (IOException e) {
		System.out.println("Can't read the URL");
	    }
	} else {
	    System.out.println(msg);
	}
    }
}

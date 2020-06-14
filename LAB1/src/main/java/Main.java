
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import mobilegame.Gamer;
import mobilegame.PriorityQueue;
import mobilegame.FileCSV;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tieuminh
 */
public class Main {

 

//    private static void saveFile(String filename, PriorityQueue queue, String lab_number) throws IOException {
//        FileWriter file = new FileWriter(filename);
//        if (lab_number.equals("1")) {
//            file.write("Email, Point\n");
//        } else if (lab_number.equals("2")) {
//            file.write("Tag, Frequency\n");
//        }
//
//        file.write(queue.toString());
//        file.close();
//    }

    private static int contains(String[] arr, String targetValue) {
        int result = -1;

        for(int i = 0; i < arr.length; ++i) {
            if (arr[i].equals(targetValue)) {
                result = i;
                break;
            }
        }

        return result;
    }

    private static String CLIChecker(String[] args) {
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
            result = result + "Help:\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data structure into csv file\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data structure and save to new csv file\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data structure and save to new csv file\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data structure and save to new csv file\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data structure and save to new csv file\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data structure\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
            result = result + "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure\n";
            result = result + "./lab1 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file\n";
        }

        return result;
    }

    public static void main(String[] args) {
        String msg = CLIChecker(args);
        if (msg.equals("") && args[0].equals("1")) {
            try {
                PriorityQueue queue = FileCSV.readFile(args[contains(args, "-r") + 1]);
                long point;
                if (contains(args, "-g") != -1) {
                    point = queue.searchPoint(args[contains(args, "-g") + 1]);
                    if (point == -1L) {
                        System.out.println("Error: Cannot find the input email");
                    } else {
                        System.out.println(point);
                    }
                } else if (contains(args, "-t") != -1) {
                    point = queue.searchMaxPoint();
                    System.out.println(point);
                } else {
                    String email;
                    if (contains(args, "-a") != -1) {
                        point = Long.parseLong(args[contains(args, "-a") + 2]);
                        email = args[contains(args, "-a") + 1].trim();
                        queue.insert(Gamer.add(email, point));
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else if (contains(args, "-d") != -1) {
                        queue.remove(args[contains(args, "-d") + 1]);
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else if (contains(args, "-u") != -1) {
                        point = Long.parseLong(args[contains(args, "-u") + 2]);
                        email = args[contains(args, "-u") + 1].trim();
                        queue.update(email, point);
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else if (contains(args, "-dt") != -1) {
                        queue.removeMin();
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else {
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    }
                }
            } catch (FileNotFoundException var7) {
                System.out.println("Error: Cannot find input filename !");
            } catch (IOException var8) {
                System.out.println("Error: Cannot save the output file !");
            }
        } else if (msg.equals("") && args[0].equals("2")) {
            try {
                saveFile(args[2], readURL(args[1]), args[0]);
            } catch (IOException var6) {
                System.out.println("Error: Cannot access the url !");
            }
        } else {
            System.out.println(msg);
        }

    }
    
}

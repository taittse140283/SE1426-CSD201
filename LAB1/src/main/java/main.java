/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLI;

import Bai_1.IOFile;
import Bai_1.Infor;
import Bai_1.PriorityQueue;
import bai_2.SortandWritetoFile;
import bai_2.checkWeb;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Dell
 */
public class main {
     public static void main(String[] args) throws MalformedURLException  {

        commandLine(args);

    }

    public static void commandLine(String[] cmdStrings) throws MalformedURLException {

        if (cmdStrings.length == 0 || cmdStrings.length > 8) {
            System.out.println("Enter java -jar LAB1.jar -h to be helped.");
            return;
        }

        // luu danh sach argument 
        String[] cmd = new String[10];
        for (int i = 0; i < cmdStrings.length; i++) {
            cmd[i] = cmdStrings[i];
        }

        if (cmd[0].equals("-h")) {
            help(); // show huong dan
            return;
        }

        if (cmd[0].equals("1")) {
           lab1(cmd);
            return;
        }

        if (cmd[0].equals("2")) {
            lab2(cmd);
        }

    }

    public static void help() {
        System.out.println("Help: \n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n"
                + "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
    }

    public static void lab1(String[] cmd) {
        String option1, file1, option2, file2, option3, file3, file4;

        //option1
        option1 = cmd[1];
        file1 = cmd[2];
        if (option1 == null || !option1.equals("-r") || file1 == null) {
            return;
        }

        // doc file
        PriorityQueue queue = IOFile.readFile(file1);

        // option2
        option2 = cmd[3];
        file2 = cmd[4];
        if (option2 == null || (option2.equals("-g") && file2 == null)) {
            return;
        }

        switch (option2) {
            case "-s":
                IOFile.writeToFile(queue, file2);
                break;
            case "-g":
                System.out.println(getPointPlayer(queue, file2));
                break;
            case "-t":
                System.out.println(getPointPlayerOnTop(queue));
                break;
        }

        //option3
        option3 = cmd[5];
        file3 = cmd[6];
        file4 = cmd[7];
        if (option3 == null
                || ((option3.equals("-u") || option3.equals("-a")) && (file3 == null || file4 == null))
                || ((option3.equals("-d")) && file3 == null)) {
            return;
        }

        switch (option3) {
            case "-a":
                addNewPlayer(queue, file3, file4);
                IOFile.writeToFile(queue, file2);
                IOFile.writeToFile(queue, file1); 
                break;
            case "-d":
                deletePlayer(queue, file3);
                IOFile.writeToFile(queue, file2);
                IOFile.writeToFile(queue, file1); 
                break;
            case "-u":
             
                IOFile.writeToFile(queue, file2);
                IOFile.writeToFile(queue, file1); 
                break;
            case "-dt":
                deletePlayerOnTop(queue);
                IOFile.writeToFile(queue, file2);
                IOFile.writeToFile(queue, file1); 
                break;
        }

    }

    public static void lab2(String[] cmd) throws MalformedURLException {
        
        String url, file;
        url = cmd[1];
        file = cmd[2];
        checkWeb(url,file);
    }

    /**
     * All of the methods below are the ones declared in the previous classes. And here just call back to use it
     * @param queue
     * @param email
     * @param point 
     */
    public static void addNewPlayer(PriorityQueue queue, String email, String point) {
        Infor player = new Infor(email, Long.parseLong(point));
        queue.addAndSort(player);
    }

    public static void deletePlayer(PriorityQueue queue, String email) {
        queue.delete(email);
    }
    public static void deletePlayerOnTop(PriorityQueue queue) {
        queue.removePlayerHasMaxPoint();
    }

    public static long getPointPlayerOnTop(PriorityQueue queue) {
        return queue.getPlayerHasMaxPoint();
    }

    public static long getPointPlayer(PriorityQueue queue, String email) {
        return queue.getNodePlayerPoint(email);
    }
    public static void checkWeb(String url, String file){
        checkWeb(url,file);
    }
}
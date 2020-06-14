/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLI;

import Bai1.CSVFile;
import Bai1.Player;
import Bai1.PriorityQueue;
import java.net.MalformedURLException;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) throws MalformedURLException {
        commandLine(args);
    }

    public static void commandLine(String[] cmdStrings) throws MalformedURLException {

        if (cmdStrings.length == 0 || cmdStrings.length > 8) {
            System.out.println("Help: \n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n"
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
            return;
        }
   
    // save list argument
        String[] cmd = new String[10];
        for (int i = 0; i < cmdStrings.length; i++) {
            cmd[i] = cmdStrings[i];
        }

        if (cmd[0].equals("-h")) {
            help(); 
            return;
        }

        if (cmd[0].equals("1")) {
            laB1(cmd);
            return;
        }

        if (cmd[0].equals("2")) {
            System.out.println("Not found!");
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
                + "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n");
    }
    
public static void laB1(String[] cmd) {
        String luachon1, tep1, luachon2, tep2, luachon3, tep3, tep4;

        // lựa chọn 1
        luachon1 = cmd[1];
        tep1 = cmd[2];
        if (luachon1 == null || !luachon1.equals("-r") || tep1 == null) {
            return;
        }

        // read file
        PriorityQueue queue = CSVFile.readFile(tep1);

        // lựa chọn 2
        luachon2 = cmd[3];
        tep2 = cmd[4];
        if (luachon2 == null || (luachon2.equals("-g") && tep2 == null)) {
            return;
        }

        switch (luachon2) {
            case "-s":
                CSVFile.writeFile(queue, tep2);
                break;
            case "-g":
                System.out.println(getPointPlayer(queue, tep2));
                break;
            case "-t":
                System.out.println(getPointPlayerOnTop(queue));
                break;
        }

        // lựa chọn 3
        luachon3 = cmd[5];
        tep3 = cmd[6];
        tep4 = cmd[7];
        if (luachon3 == null
            || ((luachon3.equals("-u") || luachon3.equals("-a")) && (tep3 == null || tep4 == null))
            || ((luachon3.equals("-d")) && tep3 == null)) {
            return;
        }

        switch (luachon3) {
            case "-a":
                addPlayer(queue, tep3, tep4);
                CSVFile.writeFile(queue, tep2);
                CSVFile.writeFile(queue, tep1);
                break;
            case "-d":
                deletePlayer(queue, tep3);
                CSVFile.writeFile(queue, tep2);
                CSVFile.writeFile(queue, tep1); 
                break;
            case "-u":
                updatePlayer(queue, tep3, tep4);
                CSVFile.writeFile(queue, tep2);
                CSVFile.writeFile(queue, tep1);
                break;
            case "-dt":
                deletePlayerOnTop(queue);
                CSVFile.writeFile(queue, tep2);
                CSVFile.writeFile(queue, tep1); 
                break;
        }
    }

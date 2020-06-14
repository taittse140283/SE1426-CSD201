package Bai1;

import java.net.MalformedURLException;

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

        luachon1 = cmd[1];
        tep1 = cmd[2];
        if (luachon1 == null || !luachon1.equals("-r") || tep1 == null) {
            return;
        }

        PriorityQueue queue = CSVFile.readFile(tep1);

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

    public static void addPlayer(PriorityQueue queue, String email, String point) {
        Player player = new Player(email, Integer.parseInt(point));
        queue.addAndSort(player);
    }

    public static void deletePlayer(PriorityQueue queue, String email) {
        queue.delete(email);
    }

    public static void updatePlayer(PriorityQueue queue, String email, String point) {
        queue.update(email, Integer.parseInt(point));
    }

    public static void deletePlayerOnTop(PriorityQueue queue) {
        queue.removePlayerHasMaxPoint();
    }

    public static int getPointPlayerOnTop(PriorityQueue queue) {
        return queue.getPlayerHasMaxPoint();
    }

    public static int getPointPlayer(PriorityQueue queue, String email) {
        return queue.getNodePlayerPoint(email);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.Scanner;

/**
 * @author tieuminh
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException {
        SortList sl = new SortList();

        String fileInput;
        String fileOutput;
        String email;
        int point;

        String Error = "Invalid Input";
        try {
            if (args[0].equals("-h")) {
                System.out.println("Help: \n" +
                        "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data structure into csv file\n" +
                        "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data structure and save to new csv file\n" +
                        "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data structure and save to new csv file\n" +
                        "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data structure and save to new csv file\n" +
                        "./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data structure and save to new csv file\n" +
                        "./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data structure\n" +
                        "./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data structure");
            } else if (args[0].equals("1") && args.length >= 5) {
                if (args[1].equals("-r")) {
                    if (!args[2].trim().isEmpty()) {
                        fileInput = args[2];
                        if (args[3].equals("-s")) {
                            if (!args[4].trim().isEmpty()) {
                                fileOutput = args[4];
                                copyFile(fileInput, fileOutput);
                                System.out.println("Copy file succes");
                                if (args[5].equals("-a") ){
                                    System.out.println("add success 5");
                                    if (!args[6].trim().isEmpty()) {
                                        email = args[6];
                                        System.out.println("add 6");
                                        if (!args[7].trim().isEmpty()) {
                                            point = Integer.parseInt(args[7]);
                                            sl.insert(new Entry(point, email));
                                            sl.printtoFile(fileOutput);
                                            System.out.println("add new user");
                                        } else {
                                            System.out.println(Error);
                                        }
                                    } else {
                                        System.out.println(Error);
                                    }
                                } else if (args[5].equals("-d")) {
                                    if (!args[6].trim().isEmpty()) {
                                        email = args[6];
                                    }
                                } else if (args[5].equals("-u")) {
                                    if (!args[6].trim().isEmpty()) {
                                        email = args[6];
                                    }
                                } else if (args[5].equals("-dt")) {

                                } else {
                                    System.out.println(Error);
                                }
                            } else {
                                System.out.println(Error);
                            }
                        } else if (args[3].equals("-g")) {

                        } else {
                            System.out.println(Error);
                        }
                    } else {
                        System.out.println(Error);
                    }


                } else {
                    System.out.println(Error);
                }
            } else if (args[0].equals("2")) {

            } else {
                System.out.println(Error);
            }

            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }


            String notMatches = "<h1> fkjasjdf </h1>";

        } catch (Exception e) {
            System.out.println(e);
        }

//
//        try {
//            Entry A = new Entry(1, "A");
//            Entry B = new Entry(9, "B");
//            Entry C = new Entry(7, "C");
//            Entry D = new Entry(7, "D");
//            Entry E = new Entry(6, "E");
//            Entry F = new Entry(1, "F");
//            Entry G = new Entry(8, "G");
//            Entry H = new Entry(1, "H");
//            SortList sl = new SortList();
//            sl.insert(A);
//            sl.insert(B);
//            sl.insert(C);
//            sl.insert(D);
//            sl.insert(E);
//            sl.insert(F);
//            sl.insert(G);
//            sl.insert(H);
//            sl.print();
//            System.out.println("\n");
//
//            //dos.writeBytes(String.valueOf(A));
//            sl.printtoFile("hoang.txt");
//
//        } catch (Exception e) {
//            System.out.println("Error");
//        }


//        dll.addFirst(A);
//        dll.addFirst(B);
//        dll.insert(C, dll.getNode(1), dll.getNode(2));
//        dll.addLast(D);
//        dll.print();


    }


    public static boolean checkMatches(String html) {
        Stack<String> buffer = new ArrayStack<>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) return false;
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                if (buffer.isEmpty())
                    return false;
                if (!tag.substring(1).equals(buffer.pop()))
                    return false;
            }
            j = html.indexOf('<', k + 1);
        }
        return buffer.isEmpty();
    }

    public static void copyFile(String input, String output) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\".concat(input));
            DataInputStream dis = new DataInputStream(fis);
            FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\".concat(output));
            DataOutputStream dos = new DataOutputStream(fos);
            int Data;

            while ((Data = fis.read()) != -1) {
                fos.write(Data);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}

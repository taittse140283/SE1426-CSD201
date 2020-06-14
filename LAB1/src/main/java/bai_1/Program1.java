/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Linh
 */
public class Program1 {
    SortedPriorityQueue s;
    ArrayList<Player> list;

    public Program1() {
        s = new SortedPriorityQueue();
        list = new ArrayList<>();
    }
    
    /**
     * Read file and add players into the queue and sort them into the suitable position
     * @param fileName 
     */
    public void getPlayerFromFile(String fileName) {
        FileReader fr = null;
        BufferedReader br = null;
        String line = "";
        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while((line = br.readLine()) != null) { //read file line-by-line
                if(line.contains("Email")) //Ignore the header line
                    continue;
                String[] info = line.split(", "); 
                String email = info[0];
                int point = Integer.parseInt(info[1]);
                s.addNewPlayer(email, point); //Add a player into the queue
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("Not found the input file");
        }
    }
    
    /**
     * Print all players to file
     * @param fileName 
     */
    public void printToFile(String fileName) {
        File f;
        PrintWriter pw;
        try {
            f = new File(fileName);
            pw = new PrintWriter(f);
            s.addToList(list);
            pw.println("Email, Point");
            for(int i = 0; i < list.size(); i++)
                pw.println(list.get(i).getEmail() + ", " + list.get(i).getPoint());
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Parsing the arguments and solve it
     * @param args 
     */
    public void parsingArgs(String[] args) {
        try{
            if(args.length == 3) {
                if(args[0].equals("-r") && args[2].equals("-t")) {
                    getPlayerFromFile(args[1]);
                    System.out.println("The point of the top user: " + s.getMaxPoint());
                }
                else
                    System.out.println("Not valid argument!");
            }
            else if(args.length == 4) {
                if(args[0].equals("-r") && args[2].equals("-s")) {
                    getPlayerFromFile(args[1]);
                    printToFile(args[3]);
                    System.out.println("Save successful!");
                }
                else if(args[0].equals("-r") && args[2].equals("-g")) {
                    boolean valid = args[3].matches("\\w+@+\\w+.+\\w+(.\\w)?");
                    if(valid == true) {
                        getPlayerFromFile(args[1]);
                        s.getPointOfPlayer(args[3]);
                    }
                    else
                        System.out.println("Wrong email format. Its must be <account name>@<domain>");
                }
                else
                    System.out.println("Not valid argument!");
            }
            else if(args.length == 5) {
                if(args[0].equals("-r") && args[2].equals("-s") && args[4].equals("-dt")) {
                    getPlayerFromFile(args[1]);
                    s.removePlayerHasBiggestPoint();
                    printToFile(args[3]);
                    System.out.println("Delete and save to file successful!");
                }
                else
                    System.out.println("Not valid argument!");
            }
            else if(args.length == 6) {
                if(args[0].equals("-r") && args[2].equals("-s") && args[4].equals("-d")) {
                    boolean valid = args[5].matches("\\w+@+\\w+.+\\w+(.\\w)?");
                    if(valid == true) {
                        getPlayerFromFile(args[1]);
                        s.removePlayer(args[5]);
                        printToFile(args[3]);
                        System.out.println("Delete and save to file successful!");
                    }
                    else
                        System.out.println("Wrong email format. Its must be <account name>@<domain>");
                }
                else
                    System.out.println("Not valid argument!");
            }
            else if(args.length == 7) {
                if(args[0].equals("-r") && args[2].equals("-s") && args[4].equals("-a")) {
                    if(Integer.parseInt(args[6]) >= 0) {
                        boolean valid = args[5].matches("\\w+@+\\w+.+\\w+(.\\w)?");
                        if(valid == true) {
                            getPlayerFromFile(args[1]);
                            s.addNewPlayer(args[5], Integer.parseInt(args[6]));
                            printToFile(args[3]);
                            System.out.println("Add and save to file successful!");
                        }
                        else
                            System.out.println("Wrong email format. Its must be <account name>@<domain>");
                    }
                    else
                        System.out.println("The point must be a positive integer");
                }
                else if(args[0].equals("-r") && args[2].equals("-s") && args[4].equals("-u")) {
                    if(Integer.parseInt(args[6]) >= 0) {
                        boolean valid = args[5].matches("\\w+@+\\w+.+\\w+(.\\w)?");
                        if(valid == true) {
                            getPlayerFromFile(args[1]);
                            boolean exist = s.updateNewPoint(args[5], Integer.parseInt(args[6]));
                            if(exist == true) {
                                printToFile(args[3]);
                                System.out.println("Update and and save to file successful!");
                            }
                        }
                        else
                            System.out.println("Wrong email format. Its must be <account name>@<domain>");
                    }
                    else
                        System.out.println("The point must be a positive integer");
                }
                else
                    System.out.println("Not valid argument!");
            }
            else
                System.out.println("Not valid argument!");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

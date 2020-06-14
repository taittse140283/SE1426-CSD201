/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template fw, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Hashtable;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class Main {
    public Main() {
    }

    private static PriorityQueue readFile(String fileName) throws FileNotFoundException {
        PriorityQueue queue = new PriorityQueue();
        File f = new File(fileName);
        Scanner sc = new Scanner(f);
        String[] s;
        s = sc.nextLine().split(",");

        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] rows = line.split(",");
            queue.addPlayer(Player.Create(rows[0].trim(), Integer.parseInt(rows[1].trim())));
        }

        return queue;
    }

    private static PriorityQueue readURL(String urlString) throws IOException {
        Hashtable<String, Integer> tags = new Hashtable();
        URL url = new URL(urlString);
        InputStreamReader isr = null;
        BufferedReader br = null;
        isr = new InputStreamReader(url.openStream());
        br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        
        String content = sb.toString();

        for(int i = content.indexOf("</", 0); i != -1; i = content.indexOf("</", i + 1)) {
            String key = content.substring(i, content.indexOf(">", i) + 1);
            if (tags.containsKey(key)) {
                tags.put(key, (Integer)tags.get(key) + 1);
            } else {
                tags.put(key, 1);
            }
        }
        StringBuilder sbd = new StringBuilder(content.toString());
        String rcont = sbd.reverse().toString();

        for(int i = rcont.indexOf(">/", 0); i != -1; i = rcont.indexOf(">/", i + 1)) {
            int j = rcont.indexOf("<", i);
            String full_tag = (new StringBuilder(rcont.substring(i, j + 1))).reverse().toString();
            String key = full_tag.substring(0, full_tag.indexOf(" ", 0)) + ">";
            if (tags.containsKey(key)) {
                tags.put(key, (Integer)tags.get(key) + 1);
            } else {
                tags.put(key, 1);
            }
        }

        PriorityQueue queue = new PriorityQueue();
        tags.forEach((tag, keyx) -> {
            queue.addPlayer(Player.Create(tag.replace("/", ""), (int)keyx));
        });
        return queue;
    }

    private static void saveFile(String fileName, PriorityQueue queue, String numberOfLab) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            if (numberOfLab.equals("1")) {
            fw.write("Email, Point\n");
            } else if (numberOfLab.equals("2")) {
            fw.write("Tag, Frequency\n");
            }
            fw.write(queue.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fw != null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

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

    private static String CLI(String[] args) {
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
        String msg = CLI(args);
        if (msg.equals("") && args[0].equals("1")) {
            try {
                PriorityQueue queue = readFile(args[contains(args, "-r") + 1]);
                long point;
                if (contains(args, "-g") != -1) {
                    point = queue.get(args[contains(args, "-g") + 1]);
                    if (point == -1L) {
                        System.out.println("Error: Cannot find the input email");
                    } else {
                        System.out.println(point);
                    }
                } else if (contains(args, "-t") != -1) {
                    point = queue.topPlayer().getPoint();
                    System.out.println(point);
                } else {
                    String email;
                    if (contains(args, "-a") != -1) {
                        point = Integer.parseInt(args[contains(args, "-a") + 2]);
                        email = args[contains(args, "-a") + 1].trim();
                        queue.addPlayer(Player.Create(email, (int) point));
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else if (contains(args, "-d") != -1) {
                        queue.deletePlayer(args[contains(args, "-d") + 1]);
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else if (contains(args, "-u") != -1) {
                        point = Integer.parseInt(args[contains(args, "-u") + 2]);
                        email = args[contains(args, "-u") + 1].trim();
                        queue.update(email, (int) point);
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else if (contains(args, "-dt") != -1) {
                        queue.deteleTop();
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    } else {
                        saveFile(args[contains(args, "-s") + 1].trim(), queue, args[0]);
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error: Cannot find input filename !");
            } catch (IOException e) {
                System.out.println("Error: Cannot save the output file !");
            }
        } else if (msg.equals("") && args[0].equals("2")) {
            try {
                saveFile(args[2], readURL(args[1]), args[0]);
            } catch (IOException e) {
                System.out.println("Error: Cannot access the url !");
            }
        } else {
            System.out.println(msg);
        }

    }
}

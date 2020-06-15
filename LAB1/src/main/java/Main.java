/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <h1>Main</h1>
 * The Main program store main method
 *
 * @author Bach Duy Hoang
 * @since 2020/6/1
 */
public class Main {

    /**
     * This is main method which makes uses of CLI and some methods
     * to manages info players, crawler data html tag
     * <b>Note:</b>File just read file that live in Desktop and save
     * output file on Desktop
     *
     * @param args the command line arguments
     * @throws IOException on input error, ...
     * @see IOException, ArrayIndexOutOfBoundsException, ...
     */

    public static void main(String[] args) throws IOException {
        SortList sl = new SortList();

        String fileInput;
        String fileOutput;
        String email;
        long point;
        long new_point;

        String Error = "Invalid Input";
        try {
            if (args[0].equals("-h")) {
                System.out.println("Help:" + "\n" +
                        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data strucutre into csv file\n" +
                        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file\n" +
                        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file\n" +
                        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file\n" +
                        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file\n" +
                        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre\n" +
                        "java -jar LAB1.jar 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre\n" +
                        "java -jar LAB1.jar 2 <<URL-of-website>> <<output-CSV-file>>: Problem 2, read html info from a URL, save all tag information into the CSV output file");
            } else if (args[0].equals("1") && args.length >= 4) {
                if (args[1].equals("-r")) {
                    if (!args[2].trim().isEmpty()) {
                        fileInput = args[2];
                        if (args[3].equals("-s")) {
                            if (!args[4].trim().isEmpty() && args.length == 5) {
                                fileOutput = args[4];
                                getData(fileInput, sl);
                                sl.printtoFile(fileOutput);
                            } else if (args.length > 5){
                                if (args[5].equals("-a")) {
                                    fileOutput = args[4];
                                    if (!args[6].trim().isEmpty()) {
                                        email = args[6];
                                        if (!args[7].trim().isEmpty()) {
                                            point = Long.parseLong(args[7]);
                                            getData(fileInput, sl);
                                            sl.insert(new Entry(point, email));
                                            sl.printtoFile(fileOutput);
                                        } else {
                                            System.out.println(Error);
                                        }
                                    } else {
                                        System.out.println(Error);
                                    }
                                } else if (args[5].equals("-d")) {
                                    if (!args[6].trim().isEmpty()) {
                                        fileOutput = args[4];
                                        email = args[6];
                                        getData(fileInput, sl);
                                        sl.remove(email);
                                        sl.printtoFile(fileOutput);
                                    }
                                } else if (args[5].equals("-u")) {
                                    if (!args[6].trim().isEmpty()) {
                                        email = args[6];
                                        if (!args[7].trim().isEmpty()) {
                                            fileOutput = args[4];
                                            new_point = Long.parseLong(args[7]);
                                            getData(fileInput, sl);
                                            sl.update(email, new_point);
                                            sl.printtoFile(fileOutput);
                                        }
                                    }
                                } else if (args[5].equals("-dt")) {
                                    fileOutput = args[4];
                                    getData(fileInput, sl);
                                    sl.removeMax();
                                    sl.printtoFile(fileOutput);
                                } else {
                                    System.out.println(Error);
                                }




                            }
                        } else if (args[3].equals("-g")) {
                            if (!args[4].trim().isEmpty()) {
                                email = args[4];
                                getData(fileInput, sl);
                                sl.find(email);
                            }
                        } else if (args[3].equals("-t")) {
                            getData(fileInput, sl);
                            sl.findMax();
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
                if (!args[1].trim().isEmpty()) {
                    String url = args[1];
                    if (!args[2].trim().isEmpty()) {
                        String filenameoutput = args[2];
                        crawWeb(url, filenameoutput);
                    }
                }
            } else {
                System.out.println(Error);
            }

        } catch (Exception e) {
            System.out.println("OK hoac Loi");
        }

    }


    /**
     * This method is used to copy data of file to another file
     *
     * @param input  Name of file input
     * @param output Name of file output
     * @throws IOException,..
     * @see Exception
     */
    public static void copyFile(String input, String output) {
        try {
            FileInputStream fis = new FileInputStream(input);
            FileOutputStream fos = new FileOutputStream(output);

            int Data;

            byte[] b = new byte[10000];
            while ((Data = fis.read(b)) >= 0) {
                fos.write(b, 0, Data);
            }
            fos.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This method is used to get html of web
     *
     * @param web url of website
     * @return String This is html of web
     * @throws IOException
     */

    public static String getStringfromweb(String web) throws IOException {
        String result = "";
        URL url = new URL(web);
        BufferedReader readr = new BufferedReader(new InputStreamReader(url.openStream()));
        String line;
        while ((line = readr.readLine()) != null) {
            result += line + "\n";
        }
        readr.close();
        return result;
    }

    /**
     * getData from fileInput and add to list.
     *
     * @param fileInput file to getData
     * @param sl        List to add data
     * @throws IOException
     * @see Exception
     */
    public static void getData(String fileInput, SortList sl) throws IOException {

        String email;
        int point;
        try {
            Scanner sc = new Scanner(new File(fileInput));
            sc.nextLine();
            while (sc.hasNext()) {
                email = sc.next();
                email = email.substring(0, email.length() - 1);
                point = Integer.parseInt(sc.next());
                sl.insert(new Entry(point, email));
            }
            sc.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method used to craw data from web
     *
     * @param url         This is url of web
     * @param filenameout Name of file when finished processing
     * @throws IOException
     */


    public static void crawWeb(String url, String filenameout) throws IOException {
        SortList sl1 = new SortList();
        HashMap<String, Integer> hm = new HashMap<>();

        String html = getStringfromweb(url);
        countTag(html, hm);

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            sl1.insert(new Entry(value, key));
        }
        sl1.printoFilehtml(filenameout);

    }

    /**
     * This method used to count tags in html
     *
     * @param s  html covert to string
     * @param hm hashmap to save data
     */
    public static void countTag(String s, HashMap<String, Integer> hm) {
        ArrayStack<String> buffer = new ArrayStack<>();
        int i = s.indexOf("<");
        while (i != -1) {
            int k = s.indexOf(">", i + 1);
            String tagName = s.substring(i + 1, k);
            String[] n = tagName.split(" ");
            tagName = n[0];
            int count = 0;
            if (tagName.equalsIgnoreCase("area") || tagName.equalsIgnoreCase("base") || tagName.equalsIgnoreCase("br")
                    || tagName.equalsIgnoreCase("col") || tagName.equalsIgnoreCase("!DOCTYPE") || tagName.equalsIgnoreCase("command")
                    || tagName.equalsIgnoreCase("embed") || tagName.equalsIgnoreCase("hr") || tagName.equalsIgnoreCase("img")
                    || tagName.equalsIgnoreCase("input") || tagName.equalsIgnoreCase("keygen") || tagName.equalsIgnoreCase("source")
                    || tagName.equalsIgnoreCase("link") || tagName.equalsIgnoreCase("meta") || tagName.equalsIgnoreCase("param")
                    || tagName.equalsIgnoreCase("track") || tagName.equalsIgnoreCase("wbr")) {
                if (hm.containsKey(tagName)) {
                    count = hm.get(tagName);
                }
                hm.put(tagName, count + 1);
            } else {
                if (!tagName.startsWith("/") && !tagName.startsWith("!")) {
                    buffer.push(tagName);
                    if (hm.containsKey(tagName)) {
                        count = hm.get(tagName);
                    }
                    hm.put(tagName, count + 1);
                } else if (tagName.startsWith("!")) {

                } else {
                    if (buffer.top().equalsIgnoreCase(tagName.substring(1))) {
                        buffer.pop();
                    }

                }
            }
            i = s.indexOf("<", k + 1);
        }
    }
}

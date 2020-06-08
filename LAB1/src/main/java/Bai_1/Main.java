/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

/**
 *
 * @author Dell
 */
public class Main {
    public static void main(String[] args) {
        try{
            if(args[0].equals("-h")){
                System.out.println("Help: ");
                System.out.println("./lab1 1 -r <<User_CSV_file>> -s <<new_user_CSV_file>>: Problem 1, read the user csv file and save the data structure into csv file");
                System.out.println("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -a <<email>> <<point>>: Problem 1, add a new user into the data strucutre and save to new csv file");
                System.out.println("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -d <<email>>: Problem 1, delete a user in the data strucutre and save to new csv file");
                System.out.println("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -u <<email>> <<new_point>>: Problem 1, update new point for user in the data strucutre and save to new csv file");
                System.out.println("./lab1 1 -r <<user_CSV_file>> -s <<new_user_CSV_file>> -dt: Problem 1, delete the top user from the data strucutre and save to new csv file");
                System.out.println("./lab1 1 -r <<user_CSV_file>> -g <<email>>: Problem 1, get the point of user from the data strucutre");
                System.out.println("./lab1 1 -r <<user_CSV_file>> -t: Problem 1, get the point of the top user from the data strucutre");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

package Bai1;


import Bai1.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 *Main class for test file
*/
public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = CSVFile.readFile("user.csv");
        queue.printPlayerList();
        CSVFile.writeFile(queue, "outputPlayer.csv");
    }
}

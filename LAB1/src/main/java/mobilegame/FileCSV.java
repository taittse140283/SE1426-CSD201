/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FileCSV {

    String fileName = "user.csv";

    
        try {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
    }
    catch(Exceptione e){
        e.printStackTrace();
    }

    private static PriorityQueue readFile(String filename) throws FileNotFoundException {
        PriorityQueue queue = new PriorityQueue();
        Scanner scanner = new Scanner(new File(filename));
        String[] var3 = scanner.nextLine().split(",");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] rows = line.split(",");
            queue.insert(Gamer.add(rows[0].trim(), Integer.parseInt(rows[1].trim())));
        }
        return queue;
    }
}

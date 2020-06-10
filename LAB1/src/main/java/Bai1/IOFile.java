/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author User
 */
public class IOFile {

    public static PriorytiQueue readFromFile(String file) {
        File f = null;
        FileReader fr = null;
        BufferedReader br = null;
        PriorytiQueue queue = new PriorytiQueue();
        try {
            f = new File(file);
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String s = br.readLine();
            while (br.ready()) {
                s = br.readLine();
                StringTokenizer stk = new StringTokenizer(s, ", ");
                String email = stk.nextToken();
                int point = Integer.parseInt(stk.nextToken());

                Player player = new Player(email, point);
                queue.addAndSort(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
                if(fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return queue;
    }

}

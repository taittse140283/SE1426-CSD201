/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author Admin
 */
public class CSV {
    
    public static PriorityQueue readFile (String file) throws IOException{
        FileReader fr = null;
        BufferedReader br = null;
        PriorityQueue queue = new PriorityQueue();
        try {
            fr = new FileReader(file);
            br=new BufferedReader(fr);
            String s = br.readLine();
            while (br.ready()) {
                s = br.readLine();
                StringTokenizer stk = new StringTokenizer(s, ", ");
                String email = stk.nextToken();
                int point = Integer.parseInt(stk.nextToken());
                
                Player player = new Player(email, point);
                queue.addPlayer(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(br != null){
                br.close();
            }
            if(fr !=null){
                fr.close();
            }
        }
        return queue;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author hiep
 */
public class getURL {

    String content;
    String s;

    //l
    public String readContent(String urlString) throws Exception {
        BufferedReader bf = null;
        try {

            URL url = new URL(urlString);
            bf = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((s = bf.readLine()) != null) {
                content += s + "\n";
            }
            bf.close();
        } catch (Exception e) {
        } finally {
            try {
                if (bf != null) {
                    bf.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    //in ra url wed
    public void print() {
        System.out.println("" + content);
    }
}

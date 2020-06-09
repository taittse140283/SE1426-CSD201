/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author User
 */
public class Manager {

    /**
     * Read content from website
     * Use BufferedReader to read more effectively 
     * Use URL to download content
     * Catch exception if it occurs
     * @param urlWeb
     * @return 
     */
    public static String readHtlmFromWeb(String urlWeb) {

        String html = ""; // tao chuoi voi gia tri rong de luu noi dung tu web
        String line; // luu noi dung tung dong tu web size
        BufferedReader br = null;
        try {
            URL url = new URL(urlWeb);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            while ((line = br.readLine()) != null) { // readline
                html += line + "\n";
            }
        } catch (IOException e) {
            System.out.println("Got an exception: " + e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Got an exception: " + e.getMessage());
            }
        }
        return html;
    }
}

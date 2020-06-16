/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 *
 * @author Admin
 */
public class CSV {
    HashMap<String, Integer> tags;
    public CSV() {
        tags = new HashMap<>();
    }
    public static String readURL (String url_string) {
        URL url = null;
        HttpURLConnection huc = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            url = new URL(url_string);
            huc = (HttpURLConnection) url.openConnection();
            huc.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.97 Safari/537.36");
            InputStream is = huc.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (MalformedURLException e) {
            System.out.println("Error: URL is invalid!");
        } catch (IOException e){
            System.out.println("Error: An error occurred while reading url!");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    class HTMLTag implements Comparable<CSV.HTMLTag> {
        private String tag;
        private int count;

        public HTMLTag() {
            this.tag = "";
            this.count = 0;
        }

        public HTMLTag(String tag, int count) {
            this.tag = tag;
            this.count = count;
        }

        public String getTag() {
            return this.tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getCount() {
            return this.count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public int compareTo(CSV.HTMLTag tag) {
            if (this.count > tag.getCount()) {
                return -1;
            } else {
                return this.count == tag.getCount() ? 0 : 1;
            }
        }
        
        @Override
        public String toString() {
            return this.tag + ", " + this.count;
        }

    }
}

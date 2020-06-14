/**
 *
 * @author SE140834
 */
package problem2;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Problem2 {
    HashMap<String, Integer> map = new HashMap<>();
    String data;
    public Problem2() {
    }
     /**
     * @Argument String _url
     * @function read a whole html file of _url
     * @return a whole string of the website
     */     
    public String loadURL(String _url) throws MalformedURLException, IOException {
        String str;
        URL url = new URL(_url);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder builder = new StringBuilder();
        while ((str = reader.readLine()) != null) {
            builder.append(str);
            builder.append("\n");
        }
        return builder.toString();
    }
     /**
     * @function countNormalTags and save to HashMap
     */     
    public void countNormalTags() {
        int i = data.indexOf("</", 0);
        while (i != -1) {
            String key = data.substring(i, data.indexOf(">", i) + 1);
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
            i = data.indexOf("</", i + 1);
        }
    }
     /**
     * @function countSelfClosingTags and save to HashMap
     */     
    public void countSelfClosingTags() {
        String reverse = new StringBuilder(data).reverse().toString();
        int i = reverse.indexOf(">/", 0);
        while (i != -1) {
            int j = reverse.indexOf("<", i);
            String tag = new StringBuilder(reverse.substring(i, j + 1)).reverse().toString();
            String key = tag.substring(0, tag.indexOf(" ", 0)) + ">";
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
            i = reverse.indexOf(">/", i + 1);
        }
    }
    /**
     * @argument String filename
     * @function sort and write all data to file Name
     */   
    public void writeFile(String filename) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (FileWriter f = new FileWriter(filename)) {
            f.write("Tag, Frequency\n");
            ArrayList<Tag> arr = new ArrayList();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                arr.add(new Tag(entry.getKey(), entry.getValue()));
            }
            Collections.sort(arr);
            for (Tag tag : arr) {
                String name = tag.getName();
                name = name.replace("/", "").replace("<", "").replace(">", "");
                long frequency = tag.getFrequency();
                builder.append(name);
                builder.append(", ");
                builder.append(frequency);
                builder.append("\n");
            }
            f.write(builder.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * @function process Problem2
     */   
    public void process(String _url, String filename) throws MalformedURLException, IOException {
        data = loadURL(_url);
        countNormalTags();
        countSelfClosingTags();
        writeFile(filename);
    }
}

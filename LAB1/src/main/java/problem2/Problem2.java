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
import java.util.HashMap;

public class Problem2 {
    HashMap<String, Integer> map = new HashMap<>();
    String data;
    public Problem2() {
    }
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
    public void countNormalTags() {
        int i = data.indexOf("</", 0);
        while (i != -1) {
            String key = data.substring(i, data.indexOf(">", i) + 1);
            if (map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);
            i = data.indexOf("</", i + 1);
        }
    }
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
    public void writeFile(String filename) throws IOException {
        try (FileWriter f = new FileWriter(filename)) {
            f.write("Tag, Frequency\n");
            StringBuilder builder = new StringBuilder();
            map.entrySet().forEach((entry) -> {
                String key = entry.getKey();
                key = key.replace("/", "");
                key = key.replace("<", "");
                key = key.replace(">", "");
                Integer value = entry.getValue();
                builder.append(key);
                builder.append(", ");
                builder.append(value);
                builder.append("\n");
            });
            f.write(builder.toString());
        }
    }
    public void process(String _url, String filename) throws MalformedURLException, IOException {
        data = loadURL(_url);
        countNormalTags();
        countSelfClosingTags();
        writeFile(filename);
    }
}

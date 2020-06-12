import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class crawlerweb {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Admin\\Desktop\\MyFile.txt");
        File newfile = new File("C:\\Users\\Admin\\Desktop\\MyFilenew.txt");
        HashMap<String, Integer> hm = new HashMap<>();
        FileWriter fw = new FileWriter(newfile);
        PrintWriter pw = new PrintWriter(fw);

        ArrayStack<String> as = new ArrayStack<>();
        String html = FiletoString("C:\\Users\\Admin\\Desktop\\html1.txt");
        countTag(html,hm);
//        TreeSet ss = new TreeSet<(hm.entrySet(), hm.values());

        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "\t" + value);

        }
//        for (Object s1 : hm) {
//            System.out.println(s1);
//        }
    }

    //    public static String getHtml(String link, String nameFile) throws IOException {
////        URL url = new URL(link);
////        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
////        BufferedReader br = new BufferedReader(new InputStreamReader("C:\\Users\\Admin\\Desktop\\html.txt"));
//        FileInputStream fis = new FileInputStream("C:\\Users\\Admin\\Desktop\\html1.txt");
//        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\".concat(nameFile)));
//        String inputLine;
//        String result = "";
//        while ((inputLine = fis.r) != null) {
//            bw.write(inputLine + "\n");
//            result += inputLine + "\n";
//        }
//        br.close();
//        bw.close();
//        return result;
//    }
    public static String FiletoString(String fileName) throws IOException {
        InputStream is = new FileInputStream(fileName);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }

        return sb.toString();
    }

    public static void countTag(String s, HashMap<String, Integer> hm) {
        Stack<String> buffer = new ArrayStack<>();
        int i = s.indexOf("<");
        while (i != -1) {
            int k = s.indexOf(">", i + 1);
            String tagName = s.substring(i + 1, k);
            String[] n = tagName.split(" ");
            tagName = n[0];
            int count = 0;
            if (tagName.equalsIgnoreCase("area") || tagName.equalsIgnoreCase("base") || tagName.equalsIgnoreCase("br")
                    || tagName.equalsIgnoreCase("col") || tagName.equalsIgnoreCase("!DOCTYPE") || tagName.equalsIgnoreCase("command")
                    || tagName.equalsIgnoreCase("embed") || tagName.equalsIgnoreCase("hr") || tagName.equalsIgnoreCase("img")
                    || tagName.equalsIgnoreCase("input") || tagName.equalsIgnoreCase("keygen") || tagName.equalsIgnoreCase("source")
                    || tagName.equalsIgnoreCase("link") || tagName.equalsIgnoreCase("meta") || tagName.equalsIgnoreCase("param")
                    || tagName.equalsIgnoreCase("track") || tagName.equalsIgnoreCase("wbr")) {
                if (hm.containsKey(tagName)) {
                    count = hm.get(tagName);
                }
                hm.put(tagName, count + 1);
            } else {
                if (!tagName.contains("/") && !tagName.contains("!")) {
                    buffer.push(tagName);
                    if (hm.containsKey(tagName)) {
                        count = hm.get(tagName);
                    }
                    hm.put(tagName, count + 1);
                } else if (tagName.startsWith("!")) {
                    System.out.println("Ignore tags have '!' ");
                } else {
                    if (buffer.top().equalsIgnoreCase(tagName)) {
                        buffer.pop();
                    }
                }
            }
//
//            System.out.println(tagName);

            i = s.indexOf("<", k + 1);
        }


    }


}

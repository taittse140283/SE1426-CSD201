import java.io.*;
import java.net.URL;

public class crawlerweb {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Admin\\Desktop\\MyFile.txt");
        File newfile = new File("C:\\Users\\Admin\\Desktop\\MyFilenew.txt");

        FileWriter fw = new FileWriter(newfile);
        PrintWriter pw = new PrintWriter(fw);

        ArrayStack<String> as = new ArrayStack<>();
        as.push("1");
        as.push("2");
        as.push("4");;
        as.push("3");
        as.pop();
        as.print();
        as.push("9");
        as.pop();
        as.print();
        System.out.println(as.size());
        getHtml("https://docs.oracle.com/javase/tutorial/networking/urls/readingURL.html","html.txt");
    }

    public static String getHtml(String link, String nameFile) throws IOException {
        URL url = new URL(link);
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Admin\\Desktop\\".concat(nameFile)));
        String inputLine;
        String result= "";
        while ((inputLine = in.readLine()) != null){
            bw.write(inputLine + "\n");
            result += inputLine + "\n";
        }
        in.close();
        bw.close();
        return result;
    }

    public static boolean checkMatches(String html) {
        Stack<String> buffer = new ArrayStack<>();
        int j = html.indexOf('<');
        while (j != -1) {
            int k = html.indexOf('>', j + 1);
            if (k == -1) return false;
            String tag = html.substring(j + 1, k);
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                if (buffer.isEmpty())
                    return false;
                if (!tag.substring(1).equals(buffer.pop()))
                    return false;
            }
            j = html.indexOf('<', k + 1);
        }
        return buffer.isEmpty();
    }




    
}

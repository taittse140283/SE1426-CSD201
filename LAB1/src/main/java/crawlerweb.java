import java.io.*;

public class crawlerweb {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Admin\\Desktop\\MyFile.txt");
        File newfile = new File("C:\\Users\\Admin\\Desktop\\MyFilenew.txt");

        FileWriter fw = new FileWriter(newfile);
        PrintWriter pw = new PrintWriter(fw);

        ArrayStack<String> as = new ArrayStack<>();
        as.push("1");
        as.push("2");
        as.push("3");
        as.push("4");
        as.pop();
        as.print();
        as.push("9");
        as.pop();
        as.print();
        System.out.println(as.size());
    }
}

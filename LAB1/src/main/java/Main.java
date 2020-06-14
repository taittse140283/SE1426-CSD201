/**
 *
 * @author SE140834
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import problem1.*;
import problem2.*;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Problem1 problem1 = new Problem1();
        problem1.readFile("user.csv");
        problem1.writeFile("output.csv");
    }
}
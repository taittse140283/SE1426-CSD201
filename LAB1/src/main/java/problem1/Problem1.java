/**
 *
 * @author SE140834
 */
package problem1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Problem1 {
    private static SortedPriorityQueue data = new SortedPriorityQueue();

    public Problem1() {}

    public void readFile(String filename) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(filename));
        String[] temp = sc.nextLine().split(",");
        while (sc.hasNextLine()) {
            String[] rows = sc.nextLine().split(",");
            data.insert(rows[0].trim(), Long.parseLong(rows[1].trim()));
        }
        sc.close();
    }

    public void writeFile(String filename) throws IOException {
        FileWriter f = new FileWriter(filename);
        f.write("Email, Point\n");
        f.write(data.toString());
        f.close();
    }

    public void getPoint(String email) {
        if (data.isContains(email)) {
            long point = data.get(email);
            System.out.println(point);
        } else {
            System.out.println("Cannot find the input email");
        }
    }

    public void getMin() {
        System.out.println(data.getMin());
    }

    public void insert(String email, long point) {
        data.insert(email, point);
    }

    public void remove(String email) {
        if (data.isContains(email)) {
            data.remove(email);
        } else {
            System.out.println("Cannot find the input email");
        }
    }

    public void update(String email, long point) {
        if (data.isContains(email)) {
            data.remove(email);
            data.insert(email, point);
        } else {
            System.out.println("Cannot find the input email");
        }
    }

    public void removeMin() {
        data.removeMin();
    }
    
    
}

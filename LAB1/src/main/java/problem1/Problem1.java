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
    private static final SortedPriorityQueue data = new SortedPriorityQueue();
     /**
     * @Constructor
     */
    public Problem1() {}
     /**
     * @Read a specific file to data
     */
    public void readFile(String filename) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(filename))) {
            String[] temp = sc.nextLine().split(",");
            while (sc.hasNextLine()) {
                String[] rows = sc.nextLine().split(",");
                data.insert(rows[0].trim(), Long.parseLong(rows[1].trim()));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }
     /**
     * @Write the data to specific file
     */
    public void writeFile(String filename) throws IOException {
        try (FileWriter f = new FileWriter(filename)) {
            f.write("Email, Point\n");
            f.write(data.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    /**
     * @argument String email
     * @return Point of specific email
     */
    public void getPoint(String email) {
        if (data.isContains(email)) {
            long point = data.get(email);
            System.out.println(point);
        } else {
            System.out.println("Cannot find the input email");
        }
    }
    /**
     * @argument void
     * @return The first element of data
     */
    public void getMin() {
        System.out.println(data.getMin());
    }
    /**
     * @argument String email, long point
     * @function insert new pair of email and point
     */
    public void insert(String email, long point) {
        data.insert(email, point);
    }
    /**
     * @argument email
     * @function remove a pair by email
     */
    public void remove(String email) {
        if (data.isContains(email)) {
            data.remove(email);
        } else {
            System.out.println("Cannot find the input email");
        }
    }
    /**
     * @argument String email, long point
     * @function update point by email
     */
    public void update(String email, long point) {
        if (data.isContains(email)) {
            data.remove(email);
            data.insert(email, point);
        } else {
            System.out.println("Cannot find the input email");
        }
    }
    /**
     * @function remove the first element of data
     */
    public void removeMin() {
        data.removeMin();
    }
}

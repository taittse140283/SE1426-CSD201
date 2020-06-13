package bai2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

/**
 * Class CSV contains method that write Frequency of Tag into csv file
 */
public class CSV {
    /**
     * Write data into file csv
     * @param csvFileName path of file
     * @param frequencyOfTag This is HashMap has key are tags and value is frequency of this key tag
     */
    public static void writeFile(String csvFileName, HashMap<String, Integer> frequencyOfTag) {
        if (frequencyOfTag.isEmpty()) {
            System.out.println("Error: Your information is empty");
        } else {
            File f = new File(csvFileName);//create new file
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(f);
                pw.println("Tag, Frequency");
                Set<String> tag=frequencyOfTag.keySet();
                for (String tagName:tag) {
                    String s=tagName+", "+frequencyOfTag.get(tagName);
                    pw.println(s);
                }

            }
            catch(IOException e)
            {
                System.out.printf("Error: Something's wrong in file processing");
            }
            catch (Exception e) {
                System.out.println("Error: Something's wrong");
            } finally {
                try {
                    if (pw != null) pw.close();
                } catch (Exception e) {
                    System.out.println("Error:Something's wrong");
                }
            }

        }
    }
}

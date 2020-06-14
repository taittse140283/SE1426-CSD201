/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

import java.io.IOException;

/**
 *
 * @author truong
 */
public class bt1 {

    PriorityQueue queue;

    public void inserNewData(String email, String point) {
        queue.add(email, 0);
    }

    public void deleteEmail(String email) {
        queue.delete(email);
    }

    public void getPointUser(String email) {
        int point = queue.getPoint(email);
        if (point == 0) {
            System.err.println("can't find" + email + "tray agin");
        } else {
            System.out.println(point);
        }
    }

    public void updateUser(String email, String point) {
        queue.update(email, 0);
    }

    public void getTop() {
        queue.getTop();
    }

    public void saveCsv(String path) throws IOException {
        CSVagain.WritequeueInToCSV(queue, path);
    }

    public void PRGS(String[] args) throws IOException {
        boolean saveData = false;
        String savePath = null;
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-r":
                    queue = new PriorityQueue();
                    CSVagain.readFile(queue, args[i + 1]);
                    break;
                case "-a":
                    queue.add(args[i + 1], Integer.parseInt(args[i + 2]));
                    break;
                case "d":
                    deleteEmail(args[i + 1]);
                    break;
                case "u":
                    updateUser(args[i + 1], args[i + 2]);
                    break;
                case "-dt":
                    deleteEmail(args[i + 1]);
                    break;
                case "-g":
                    getPointUser(args[i + 1]);
                    break;
                case "-t":
                    getPointUser(savePath);
                    break;
                case "s":
                    saveData = true;
                    savePath = args[i + 1];
                    break;
                default:
                    break;

            }

        }

    }

}

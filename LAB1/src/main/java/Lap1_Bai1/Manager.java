/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;

import java.io.IOException;

/**
 *
 * @author PC
 */
public class Manager {
    public static PriorityQueue queue;

    
    public void insertNewGamer(String email, String point) {
	try {
	    int checkPoint = Integer.parseInt(point.trim());
	    queue.push(new Information(email, checkPoint));
	} catch (NumberFormatException e) {
	    System.out.println("Point must be integer!!");
	}
    }
    /**
     * Dùng để thêm người chơi vào hàng đợi
     *
     * @param email
     * @param point
     */

    public void findPlayer(String email) {
	Information data = queue. findPlayer(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Email: " + email + ", Point: " + data.getPoint());
	}
    }
    /**
     * Dùng để tim kiếm điểm của người chơi bằng việc nhập email từ người dùng
     * @param email
     */
    
    
    public void deletePlayer(String email) {
	Information data = queue.deletePlayer(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    System.out.println("Remove " + email + " successful!");
	}
    }
    /**
     * Dùng để xóa người chơi bằng việc nhập email từ người dùng
     * @param email
     */
    
    
    public void updatePlayer(String email, String point) {
	try {
	    int newPoint = Integer.parseInt(point.trim());
	    queue.updatePlayer(email, newPoint);
	} catch (NumberFormatException e) {
	    System.out.println("Point must be Integer!!");
	}
    }
    /**
     * Dùng đề cập nhật lại điểm của người chơi bangwg việc nhập email từ người dùng
     * @param email
     * @param point
     */
    
    public void getTopPlayer() {
	Information data = queue.getTop();
	System.out.println("Top 1 Gamer:");
	System.out.println("Email: " + data.getEmail() + ", Point: " + data.getPoint());
    }
    /**
     * Dùng để lấy người ở top 1 và in thông tin lên màn hình
     */
    
    public void deleteTopPlayer() {
	queue.deleteTop();
	System.out.println("Remove top successful!!");
    }
    /**
     * Dùng để xóa người chơi top 1
     */
    
    public void saveToFile(String fileName) throws IOException {
	queue.writeFile(fileName);
    }
    /**
     * Dùng để ghi tất cả người chơi vào hàng đợi
     * @param fileName
     * @throws java.io.IOException
     */
    
    public void printQueue() {
	queue.printQueue();
    }

    public void inputCLI(String[] args) throws IOException {
	Manager ex = new Manager();
	String inputFile = "";
	String outputFile = "";
	try {
	    for (int i = 0; i < args.length; i++) {
		switch (args[i]) {
		    case "-r": 
			queue = new PriorityQueue();
			inputFile = args[i + 1];
			queue.ReadFile(queue, inputFile);
			break;
		    case "-s": 
			outputFile = args[i + 1];
			ex.saveToFile(outputFile);
			break;
		    case "-a": 
			ex.insertNewGamer(args[i + 1], args[i + 2]);
			ex.saveToFile(outputFile);
			break;
		    case "-d":
			ex.deletePlayer(args[i + 1]);
			ex.saveToFile(outputFile);
			break;
		    case "-u":
			ex.updatePlayer(args[i + 1], args[i + 2]);
			ex.saveToFile(outputFile);
			break;
		    case "-dt": 
			ex.deleteTopPlayer();
			ex.saveToFile(outputFile);
			break;
		    case "-g": 
			ex.findPlayer(args[i + 1]);
			break;
		    case "-t": 
			ex.getTopPlayer();
			break;
		}
	    }
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.out.println("Can't find argument to excecute!");
	}
    }
}

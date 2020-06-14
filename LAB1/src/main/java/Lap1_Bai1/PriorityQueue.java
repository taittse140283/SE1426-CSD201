/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class PriorityQueue{
    private DoublyLinkedList list = new DoublyLinkedList();

    public void push(Information data){
	list.addBetween(data);
	System.out.println("push Gamer data successful!!");
    }
    /**
     * Dùng để thêm người chơi vào hàng đợi
     * @param data user
     */
    
    public Information getTop(){
	return list.getFirst();
    }
    /**
     * Dùng để lấy người chơi ở top trong list dựa vào điểm
     * @return top Gamer
     */
    
    public void deleteTop() {
	list.removeFirst();
    }
    /**
     * Dùng để xóa người chơi ở top trong danh sách 
     */
    
    public Information deletePlayer(String email){
	Information data = list.removeNode(email);
	return data;
    }
    /**
     * Dùng để xóa người chơi dựa vào email do người dùng nhập vào
     * @param email
     * @return Gamer
     */
    
    public Information findPlayer(String email){
	Information data = list.findPlayerByEmail(email);
	return data;
    }
    /**
     * Dùng để tìm người chơi dựa vào email do người dùng nhập vào
     * @param email
     * @return Gamer
     */
    
    public void updatePlayer(String email, int point) {
	Information data = list.findPlayerByEmail(email);
	if (data == null) {
	    System.out.println("Not found!!");
	} else {
	    data.setPoint(point);
	    list.removeNode(email);
	    list.addBetween(data);
	    System.out.println("Update point successfull");
	    System.out.println("Email: " + email + ", New point: " + data.getPoint());
	}
    }
    /**
     * Dùng để cập nhật điểm của người chơi bằng cách nhận email từ người dùng  
     * @param email
     * @param point
     */
    
    public void ReadFile(PriorityQueue queue, String fileName) {
	FileReader fr = null;
	BufferedReader bf = null;
	try {
	    fr = new FileReader(fileName);
	    bf = new BufferedReader(fr);
	    while (bf.ready()) {
		String s = bf.readLine();
		String[] arr = s.split(", ");
		if (!(arr[1].equalsIgnoreCase("point"))) {
		    queue.push(new Information(arr[0], Integer.valueOf(arr[1])));
		}
	    }
	} catch (IOException e) {
	    System.out.println("File not exist!!");
	} finally {
	    try {
		if (fr != null) {
		    fr.close();
		}
		if (bf != null) {
		    bf.close();
		}
	    } catch (IOException e) {
		System.out.println("Something wrong with Reading file");
	    }
	}
    }
    /**
     * Dùng để đọc file và đưa dữ liệu người chơi vào hàng đợi
     * @param queue
     * @param fileName
     */

    public void writeFile(String fileName) throws IOException {
	list.writeToCSVfile(fileName);
    }

    public void printQueue() {
	list.printList();
    }
}

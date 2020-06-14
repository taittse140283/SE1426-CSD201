/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class DoublyLinkedList {
    public class DLLNode {
    public Information data;
    public DLLNode left = null;
    public DLLNode right = null;
    
    public DLLNode(Information data, DLLNode next, DLLNode Prev){
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    public DLLNode(Information data){
        this.data = data;
    }
    
    public Information getData() {
        return data;
    }

    public void setData(Information data) {
        this.data = data;
    }

    public DLLNode getLeft() {
        return left;
    }

    public void setLeft(DLLNode left) {
        this.left = left;
    }

    public DLLNode getRight() {
        return right;
    }

    public void setRight(DLLNode Right) {
        this.right = right;
    }
    //getter, setter

        void setPoint(int point) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    public DLLNode header;
    public DLLNode trailer;
    public int listSize = 0;
    
    public DoublyLinkedList(){
        header = new DLLNode(null, null, null);
        trailer = new DLLNode(null, null, header);
        header.right = trailer;
    }
    
    public boolean isEmpty(){
        return listSize == 0;
    }
    //kiểm tra danh sách có trống hay không
    
    public Information getFirst(){
        if(isEmpty()){
            return null;
        }
        return header.getRight().getData();
    }
    /**
     * Hàm để lấy thông tin của người chơi đầu tiên của danh sách
     * @return Information
     */
 
    public int listSize(){
        return listSize;
    }
    /**
     * Hàm để lấy độ dài của danh sách
     * @return listSize
     */
    private Information remove(DLLNode node){
        DLLNode left = node.left;
        DLLNode right = node.right;
        left.setRight(right);
        right.setLeft(left);
        listSize--;
        return node.getData();
    }
    /**
     * Xóa 1 node từ danh sách. Không cần biết vị trị của node
     * @param node
     * @return dữ liệu của người chơi bị xóa
     */
    
    public Information removeFirst(){
        if(isEmpty()){
            System.err.println("The list is empty!!!");
        }
        return remove(header.getRight());
    }
    /**
     * Hàm xóa người chơi đầu tiên của danh sách 
     * @param data
     * @return dữ liệu của người chơi đầu tiên bị xóa  
     */
    
    public Information removeLast(){
        if(isEmpty()){
            System.err.println("The list is empty!!!");
        }
        return remove(trailer.getLeft());
    }
    /**
     * Hàm xóa người chơi cuối của danh sách 
     * @param data
     * @return dữ liệu của người chơi cuối sẽ bị xóa 
     */
    
    public DLLNode findPlayerByEmail(String email){
        for (DLLNode n = header.right; n != trailer; n = n.right) {
	    if (n.getData().getEmail().equalsIgnoreCase(email)) {
		return n.getRight();
	    }
	}
	return null;
    }
    /**
     * Tìm người chơi có email giống với email cần tìm kiếm
     * @param email 
     * @return có thì lấy dữ liệu(point), không thì trả về null
     */
    
    public void add(Information data, DLLNode rightNode, DLLNode leftNode){
        DLLNode newNode = new DLLNode(data, rightNode, leftNode);
        rightNode.setLeft(newNode);
        leftNode.setRight(newNode);
        listSize++;
    }
    /**
     * Thêm vào một người chơi mới(node)
     * @param data 
     * @param rightNode
     * @param leftNode 
     */
    
    public void addFirst(DLLNode newNode){
        header.right.left = newNode;
	newNode.right = header.right;
	newNode.left = header;
	header.right = newNode;;
    }
    /**
     * Thêm dữ liệu của người chơi vào ở đầu danh sách
     * @param data
     * @param trailer
     * @return 
     */
    
    public void addLast(DLLNode newNode){
        trailer.left.right = newNode;
	newNode.left = trailer.left;
	newNode.right = trailer;
	trailer.left = newNode;
    }
    /**
     * Thêm một người chơi vào cuối danh sách
     * @param data
     */
    
    public void addBetween(Information data){
        DLLNode newbie = new DLLNode(data, trailer, header);
	int point = data.getPoint();
	//if list is empty
	if(isEmpty()){
	    header.right = newbie;
	    newbie.left = header;
	    newbie.right = trailer;
	    trailer.left = newbie;
	} else{
	    int pointOfHeader = header.right.getData().getPoint();
	    int pointOfTrailer = trailer.left.getData().getPoint();
	    //if input point < point of trailer, add new trailer
	    if (point < pointOfTrailer) {
		addLast(newbie);
	    } //if input point > point of header, add new header
	    else if (point > pointOfHeader) {
		addFirst(newbie);
	    } //normal case, go through the list and compare every node until get right position
	    else{
		DLLNode currentNode = trailer.left;
		while (currentNode.getData().getPoint() < newbie.getData().getPoint()){
		    currentNode = currentNode.left;
		}
		currentNode.right.left = newbie;
		newbie.left = currentNode;
		newbie.right = currentNode.right;
		currentNode.right = newbie;
	    }
	}
	listSize++;
    }
    /**
     * Thêm 1 người chơi mới vào giữa 2 người chơi trong hàng ưu tiên
     * @param data
     * @param rightNode
     */
    
    public void printList() {
	//begin in the first node after header
	DLLNode currentNode = header.getRight();
	//this loop will scan every node and it will stop until meet the trailer
	while(currentNode != trailer){
	    System.out.println(currentNode.getData() + "\n");
	    currentNode = currentNode.getRight();
	}
    }
    /**
     * Dùng để in ra tất cả các người chơi trong list 
     */
    
    public DLLNode findPlayerDelete(String email){
	for(DLLNode n = trailer.left; n != header; n = n.left){
	    if(n.getData().getEmail().equalsIgnoreCase(email)){
		return n;
	    }
	}
	return null;
    }
    /**
     * Dùng để tìm email của người chơi do người dùng nhập 
     * @param email
     * @return DLLNode
     */
    
    public Information removeNode(String email){
	DLLNode delNode = findPlayerDelete(email);
	if(delNode != null){
	    return remove(delNode);
	}
	return null;
    }
    /**
     * Dùng để xóa node của người chơi có email được nhập vào
     * @param email
     * @return người chơi bị xóa
     */
    
    public void writeToCSVfile(String fileName) throws IOException{
	FileWriter fr = null;
	try {
	    fr = new FileWriter(fileName);
	    fr.append("Email, Point\n");
	    for (DLLNode n = header.right; n != trailer; n = n.right){
		String data = String.format("%s, %d\n", n.getData().getEmail(), n.getData().getPoint());
		fr.append(data);
	    }
	} catch (IOException e) {
	    System.out.println("Something wrong with writing to file!!");
	} finally{
	    try {
		if(fr != null) {
		    fr.close();
		}
	    } catch (IOException e) {
		System.out.println("File not exist!!");
	    }
	}
    }
    /**
     * Dùng để lấy danh sách vào ghi tất cả thông tin của người chơi 
     * @param fileName
     * @throws IOException
     */
}
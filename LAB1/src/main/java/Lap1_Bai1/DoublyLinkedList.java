/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;

import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class DoublyLinkedList {
    private DLLNode header;
    private DLLNode trailer;
    private int listSize = 0;
    
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
    
    public Information getLast(){
        if(isEmpty()){
            return null;
        }
        return trailer.getLeft().getData();
    }
    /**
     * Trả về người chơi ở cuối danh sách
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
            return null;
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
            return null;
        }
        return remove(trailer.getLeft());
    }
    /**
     * Hàm xóa người chơi cuối của danh sách 
     * @param data
     * @return dữ liệu của người chơi cuối sẽ bị xóa 
     */
    
    public DLLNode findPlayerByEmail(String email){
        if(isEmpty()){
            System.out.println("The list is empty!!!");
        } else{
            DLLNode rightNode = header.getRight();
            do{
                if(rightNode.getData().getEmail().equalsIgnoreCase(email)){
                    return rightNode;
                } else{
                    rightNode = rightNode.getRight();
                }
            }
            while(rightNode != trailer);
        }
        return null;
    }
    /**
     * Tìm người chơi có email giống với email cần tìm kiếm
     * @param email 
     * @return có thì lấy dữ liệu(point), không thì trả về null
     */
    
    public void deletedPlayer(String email){
        if(isEmpty()){
            System.out.println("The list is empty!!!");
        } else{
            DLLNode findPlayer = findPlayerByEmail(email);
            if(findPlayer == null){
                System.out.println("Player doesn't exit!!!");
            } else{
                int point = findPlayer.getData().getPoint();
                System.out.println("Email: " + email + " | Point: " + point);
            }
        }
    }
    /**
     * Xóa người chơi thông qua emial nhập vào thực hiện trong hàng đợi ưu tiên
     * @param email
     */
    
    private void add(Information data, DLLNode rightNode, DLLNode leftNode){
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
    
    private void addFirst(Information data){
        add(data, header.getRight(), header);
    }
    /**
     * Thêm dữ liệu của người chơi vào ở đầu danh sách
     * @param data
     * @param trailer
     * @return 
     */
    
    private void addLast(Information data){
        add(data, trailer, trailer.getLeft());
    }
    /**
     * Thêm một người chơi vào cuối danh sách
     * @param data
     */
    
    private void addBetween(Information data, DLLNode rightNode){
        if(rightNode == null){
            addLast(data);
        } else{
            DLLNode nodeLeft = rightNode.getLeft();
            DLLNode nodeRight = new DLLNode(data, rightNode, nodeLeft);
            rightNode.setLeft(nodeRight);
            nodeLeft.setRight(rightNode);
            listSize++;
        }
    }
    /**
     * Thêm 1 người chơi mới vào giữa 2 người chơi trong hàng ưu tiên
     * @param data
     * @param rightNode
     */
    
    public DLLNode findNode(int point){
        DLLNode rightNode = header.getRight();
        do{
            if(rightNode.getData().getPoint() > point){
                return rightNode;
            } else{
                rightNode = rightNode.getRight();
            }
        } while(rightNode != trailer);
        return null;
    }
    /**
     * Tìm kiếm vị trí node để chèn trong hàng đợi ưu tiên
     * @param data 
     */
    
    public void addNode(Information data){
        int point = data.getPoint();
        if(isEmpty()){
            addFirst(data);
        } else{
            if(point < header.getRight().getData().getPoint()){
                addFirst(data);
            } else if(point > trailer.getLeft().getData().getPoint()){
                addLast(data);
            } else{
                DLLNode nodeFind = findNode(point);
                addBetween(data, nodeFind);
            }
        }
    }
    /**
     * Thêm 1 node vào hàng đợi ưu tiên
     * @param data
     */
    
    public void DisplayPoint(String email){
        if(isEmpty()){
            System.out.println("The list is empty!!!");
        } else{
            DLLNode findPlayer = findPlayerByEmail(email);
            if(findPlayer == null){
                System.out.println("Player doesn't exit!!!");
            } else{
                int point = findPlayer.getData().getPoint();
                System.out.println("Email: " + email + " | Point: " + point);
            }
        }
    }
    /**
     * In ra màn hình điểm của người chơi được tiềm kiếm trong hàm đợi ưu tiên
     * @param email
     */
    
    public void displayPointTop(){
        if(getLast() == null){
            System.out.println("The list is empty!!!");
        } else{
            Information pointTopPlayer = getLast();
            String email = pointTopPlayer.getEmail();
            int point = pointTopPlayer.getPoint();
            System.out.println("Email: " + email + " | Point: " + point);
        }
    }
    /**
     * In ra màn hình người chơi có đứng đầu trong danh sách ưu tiên
     */
    
    public void updateUser(String email, int point){
        if(isEmpty()){
            System.out.println("The list is empty!!!");
        } else{
            DLLNode nodeUser = findPlayerByEmail(email);
            if(nodeUser == null){
                System.out.println("Player doesn't exit!!!");
            } else{
                nodeUser.getData().setEmail(email);
                nodeUser.getData().setPoint(point);
                checkUpdate(nodeUser);
            }
        }
    }
    /**
     * Cập nhật lại diểm của người chơi bằng cách sử dụng email trong hàng đợi ưu tiên
     * @param email
     * @param point
     */
    
    public void checkUpdate(DLLNode player){
        DLLNode checkUpdate = findNode(player.getData().getPoint());
        if(checkUpdate == null){
            remove(player);
            addLast(player.getData());
        } else{
            remove(player);
            addBetween(player.getData(), checkUpdate);
        }
    }
    /**
     * Cập nhật lại vị trí của người chơi sau khi cập nhật điểm, cấu trúc hàng đợi ưu tiên
     * @param player
     */
    
    public void writeData(DoublyLinkedList list, String fileName){
        if(list == null || list.isEmpty()){
            return;
        }
        PrintWriter writeFile = null;
        try {
            writeFile = new PrintWriter(fileName);
            DLLNode node = header.getRight();
            while(node != trailer){
                writeFile.println(node.getData().toString());
                node = node.right;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(writeFile != null){
                    writeFile.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Hàm để ghi file
     * @param list
     * @param fileName
     */
    
    public void printList(DoublyLinkedList list){
        DLLNode node = header.getRight();
        while(node != trailer){
            String email = node.getData().getEmail();
            int point = node.getData().getPoint();
            System.out.println("Email: " + email + " | Point: " + point);
            node = node.right;
        }
    }
    /**
     * Hàm để in ra màn hình
     * @param list
     */
}

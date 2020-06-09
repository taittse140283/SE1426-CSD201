/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai1;

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
    
    private Information getFirst(){
        if(isEmpty()){
            return null;
        }
        return header.getRight().getData();
    }
    /**
     * Hàm để lấy thông tin của người chơi đầu tiên của danh sách
     * @param node
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
     * Xóa 1 node từ danh sách.
     * @param node
     * @return dữ liệu của người chơi bị xóa
     */
    
    private Information removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(header.getRight());
    }
    /**
     * Hàm xóa người chơi đầu tiên của danh sách 
     * @param 
     * @return dữ liệu của người chơi đầu tiên bị xóa  
     */
    
    private Information removeLast(){
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
}

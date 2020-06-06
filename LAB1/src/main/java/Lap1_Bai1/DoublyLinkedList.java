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
     * hàm để lấy độ dài của danh sách
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
     * xóa 1 node từ danh sách.
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
     * @return dữ liệu của người chơi đầu tiên bị xóa  
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
        add(data, trailer, trailer.getLeft());
    }
    /**
     * Thêm vào ở đầu danh sách
     */
}

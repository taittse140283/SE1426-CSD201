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
public class DLLNode {
    Information data;
    DLLNode left;
    DLLNode right;
    
    public DLLNode(Information data, DLLNode next, DLLNode Prev){
        this.data = data;
        this.left = null;
        this.right = null;
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
}

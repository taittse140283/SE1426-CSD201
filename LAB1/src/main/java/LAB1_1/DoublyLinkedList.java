/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author TAN
 */
public class DoublyLinkedList {
    
    Node<Player> head,tail;
    
    public Node<Player> getHead() {
        return head;
    }

    public void setHead(Node<Player> head) {
        this.head = head;
    }

    public Node<Player> getTail() {
        return tail;
    }

    public void setTail(Node<Player> tail) {
        this.tail = tail;
    }

    public DoublyLinkedList(Node<Player> head, Node<Player> tail) {
        this.head = head;
        this.tail = tail;
    }
    public DoublyLinkedList(){
        head = tail = null;
    }
    public boolean isEmpty(){
        return tail == null;
    }
    //them phan tu vao list
    public void add(Node<Player> newNode){
        newNode.setNext(head);
        head.setPrev(newNode);
        head = newNode;
    }
    //xoa phan tu vao list
    public void remove(){
        if(isEmpty()){
            System.out.println("Stack rong");
        }
        //Neu xoa khi chi con 1 phan 
        else if(head == tail) {
            head = tail = null;
            System.out.println("Danh sach trong");
            return;
        }
    }
}

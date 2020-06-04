/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

/**
 *
 * @author truong
 */
public class DoublyLinkedList {
    private class Node{
        private double point;
        private Node next;
        private Node prev;
        public Node(double point, Node next_node,Node prev_mode){
            this.point=point;
            this.next=next_node;
            this.prev=prev_mode;
        }
    }
    private Node header;
    private Node trailer;
    public DoublyLinkedList(){
        header =new Node(Double.MIN_VALUE,null,null);
        trailer=new Node(Double.MAX_VALUE,null,header);
        header.next=trailer;
    }
    private void insert(double point, Node font,Node back){
        Node new_node=new Node(point,back,font);
        font.next=new_node;
        back.prev=new_node;
        
    }
    public void addFirst(double point){
        insert(point,header,header.next);
    }
    public void addLast(double point){
        insert(point,trailer.prev,trailer);
    }
    private Node remove(Node n){
        if(n!=header && n!=trailer){
            Node font=n.prev;
            Node back=n.next;
            font.next=back;
            back.prev=font;
        }
        return n;
    }
    public double removeFirst(){
        return remove(header.prev).point;
    }
    public double removeLast(){
        return remove(trailer.prev).point;
    }
    public void print(){
        for(Node n=header.next;n!=trailer;n=n.next)
            System.out.println(n.point+"");
    }
    
    
    
}

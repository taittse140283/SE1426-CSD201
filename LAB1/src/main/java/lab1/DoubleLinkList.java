/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author Admin
 */
public class DoubleLinkList {
    private class Node{
        private int point;
        private Node next;
        private Node back;
        public Node(int point, Node next_Node, Node back_Node){
            this.point= point;
            this.next=next_Node;
            this.back= back_Node;
        }
    }
    private Node header;
    private Node tailer;
    
    public DoubleLinkList(){
        header= new Node(Integer.MIN_VALUE,null,null);
        tailer=new Node(Integer.MAX_VALUE,null,null);
        header.next=tailer;
    }
    private void add(int point, Node infontof, Node back){
        Node new_Node= new Node(point, infontof, back);
        infontof.next=new_Node;
        infontof.back=new_Node;
        
    }
    
}

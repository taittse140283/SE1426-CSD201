/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tri
 */
public class List {

    private int size;
    private Node head;
    private Node tail;

    public List() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return size;
    }
    //use func checkExist, if true, return we found gamer
    public Node search(String gamerMail) {
        Node searchNode = this.head;
        while (searchNode!=null) {            
            if (searchNode.checkExist(gamerMail)) {
                return searchNode;
            }
            searchNode = searchNode.next;
        }
        return null;
    }

    //insert
    public void insert(Node node, int position) {
        //if insert in the head, mean node.next = head so head = node, size +1
        if (position < 1 || this.size ==0) {
            node.next = this.head;
            this.head = node;
            //but if the list is empty, mean tail = head = node
            if (tail == null) {
                this.tail = node;
            }
            this.size++;
            return;
        }
        //if insert in the tail, tail.next = node so tail = node, size+1
        if (position >= this.size) {
            if (tail != null) {
                this.tail.next = node;
            }
            this.tail = node;
            //if the head is empty, so head = node
            if (head == null) {
                this.head = node;
            }
            this.size++;
            return;
        }
        Node prevNode = null;
        Node currentNode = this.head;
        int count = 0;
        while (count<position) {            
            count++;
            prevNode=currentNode;
            currentNode=currentNode.next;
        }
        node.next=currentNode;
        prevNode.next=node;
        this.size++;

    }
    
    public void remove(String email){
        Node preNode=null;
        Node currentNode = this.head;
        int count =0;
        while (currentNode!=null) {            
            if (currentNode.checkExist(email)) {
                //remove first
                if (count==0) {
                    this.head=this.head.next;
                    if (this.head==null) {
                        this.tail=null;
                    }
                //remove last    
                }else if(count==this.size-1){
                    preNode.next=null;
                    this.tail = preNode;
                //remove midle    
                }else{
                    preNode.next=currentNode.next;
                }
                this.size--;
                return; 
            }
            count++;
            currentNode=currentNode.next;
        }
    }
    public void printList() {
        System.out.println("-List-");
        Node currentNode = head;
        while (currentNode != null) {
            currentNode.printData();
            currentNode = currentNode.next;
        }
    }
}

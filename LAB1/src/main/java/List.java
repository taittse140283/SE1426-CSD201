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

    public Node search(String gamerMail) {
        return null;
    }

    //insert
    public void insert(Node node, int position) {
        //if insert in the head, mean node.next = head so head = node, size +1
        if (position < 1) {
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
        if (position >= size) {
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

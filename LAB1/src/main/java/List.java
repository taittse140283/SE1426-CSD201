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

    public void insert(Node node, int position) {
        //
    }
    
    public void printList(){
        System.out.println("-List-");
        Node currentNode = head;
        while(currentNode.next!=null){
            currentNode = printData();
            currentNode = currentNode.next;
        }
    }
}

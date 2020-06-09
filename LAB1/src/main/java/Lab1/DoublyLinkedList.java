/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList<Player> {
    /**
     * head node 
     * tail node
     * A variable for tracking size
     */
    private Player data;
    private Node<Player> header;
    private Node<Player> tailer;
    private int size;

    /**
     * Constructor empty list
     */
    public DoublyLinkedList(){
        header = new Node<Player>(null, null, null);
        tailer = new Node<Player>(null, null, header);
        header.next = tailer;
    }
    /**
     * check if list is empty
     * @return true if size is 0; otherwise, it is false.
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size(){
        return size;
    }
    
    public void insert(Player data, Node front, Node back){
        Node<Player> newnode = new Node<Player>(data, back, front);
        front.next = newnode;
        back.previous = newnode;
    }
    /**
     * Adding a node to the first of the list.
     * @param newbie value to add
     */
    public void addFirst(Player newbie){
        insert(newbie, header, header.next);
        size++;
    }
    
    /**
     * Insert a node to the last of the list.
     * @param newbie to add
     */
    public void addLast(Player newbie){
        insert(newbie, tailer.previous, tailer);
        size++;
    }
    public Node remove(Node n){
        Node front = n.previous;
        Node back = n.next;
        front.next = back;
        back.previous = front;
        return n;
        
    }
}

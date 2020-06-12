/*
 * To change this license head, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab1;


/**
 *
 * @author Admin
 */
public class DoublyLinkedList {
    private class Node{
        Player data;
        Node next;
        Node prev;

        /**
         * Constructor
         * @param data
         * @param next
         * @param prev 
         */
        public Node(Player data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
        //Getter & Setter
        public Player getData() {
            return data;
        }

        public void setData(Player data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
        
    }
    /**
     * head node 
     * tail node
     * A variable for tracking size
     */
    private Node head = null;
    private Node tail = null;
    private int size;

    
    public DoublyLinkedList(){
        head = new Node(null, null, null);
        tail = new Node(null, null, head);
        head.setNext(tail);
    }
    /**
     * return whether the list is empty or not
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * returns the size of the linked list
     * @return
     */
    public int size(){
        return size;
    }
    
    private void insert(Player data, Node front, Node back){
        Node newNode = new Node(data, front, back);
        front.setPrev(newNode);
        back.setNext(newNode);
        size++;
    }
    /**
     * adds element at the start of the list
     * @param data
     */
    public void addFirst(Player data) {
        insert(data, head, head.getNext());
    }
    
    /**
     * adds element at the end of the list
     * @param data
     */
    public void addLast(Player data) {
        insert(data, tail.getPrev(), tail);
    }
    
    public void addBetween(Player data, Node nodeNext){
        if(nodeNext == null){
            addLast(data);
        }else{
            Node back = nodeNext.getPrev();
            Node newNode = new Node(data, nodeNext, back);
            nodeNext.setPrev(newNode);
            back.setNext(newNode);
            size++;
        }
        
    }
    
    private Player remove(Node n){
        if(n != head && n != tail){
            Node front = n.getNext();
            Node back = n.getPrev();
            front.setNext(back);
            back.setPrev(front);
            size--;
        }
        return n.getData();
    }
    /**
     * this method removes element from the start of the linked list
     * @return
     */
    public Player removeFirst() {
        if (isEmpty()){
            return null;
        }
        return remove(head.getNext());
    }
    
    /**
     * this method removes element from the end of the linked list
     * @return
     */
    public Player removeLast() {
        if (isEmpty()){
            return null;
        }
        return remove(tail.getPrev());
    }
    
    /**
     * Return Player at the top of list
     * @return data Of Player
     */
    public Player getFirst(){
        if(isEmpty()){     //Case, if the list is empty, it will return null
            return null;
        }
        return head.getNext().getData();
    }
    
    /**
     * Return Player at the last of list
     * @return data Of Player
     */
    public Player getLast(){
        if(isEmpty()){      //Case, if the list is empty, it will return null       
            return null;
        }
        return tail.getPrev().getData();
    }
    
    /**
     * Because the request to remove players by email
     * 
     * @param email
     * @return 
     */
    public Node searchPlayerByEmail(String email){
        if(isEmpty()){
            return null;
        }else{
            Node nodeNext = head.getNext(); //get node
            while(nodeNext != tail){

                if(nodeNext.getData().getEmail().equals(email)){
                    return nodeNext;
                }else{ //if not found, continue
                    nodeNext = nodeNext.getNext();
                }
            }
        }
        return null; // return null if no found
    }
    
    public Node searchPositionOfPlayer(int point){
        if(isEmpty()){
            return null;
        }else{
            Node nodeNext = head.getNext(); //get node
            while(nodeNext != tail){
                if(point > nodeNext.getData().getPoint()){
                    return nodeNext;
                }else{ //if not found, continue
                    nodeNext = nodeNext.getNext();
                }
            }
        }
        return null; // return null if no found
    }
    /**
     * add a new player into the data structure
     * If if the list is empty, addFirst
     * @param data 
     */
    public void add(Player data){
        if(isEmpty()){
            addFirst(data);
        }
    }
    
    /**
     * remove a new player into the data structure
 case, if the list is empty , show message
 Search the location the player wants to delete
 case If nodeNext fails, the player does not exist in the list.
     * @param data 
     */
    public void delete(String email){
        if(isEmpty()){
            System.err.println("Empty List!");
        }else{
            //1.nodeNext player 
            Node deletePlayer = searchPlayerByEmail(email);
            //2.
            if(deletePlayer == null){
                System.err.println("The player doesn't exist.");
            }else{
                remove(deletePlayer);
            }
        }
    }
    
    public void update(String email, int point){
        if(isEmpty()){
            System.err.println("Empty List!");
        }else{
            Node updatePlayer = searchPlayerByEmail(email);
            if(updatePlayer == null){
                System.err.println("The player doesn't exist.");
            }else{
                updatePlayer.getData().setEmail(email);
                updatePlayer.getData().setPoint(point);
            }
        }
    }
    
    public void checkPlayerAfterUpdate(Node player){
        Node checkNode = searchPositionOfPlayer(player.getData().getPoint());
        if(checkNode == null){
            remove(player);
            addLast(player.getData());
        }else{
            remove(player);
            addBetween(player.getData(), checkNode);
        }
    }
}

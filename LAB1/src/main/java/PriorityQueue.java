/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;

/**
 *
 * @author TrinhAnhTai
 */

/*
 * Its class will be get list of doublyLinkedList to process
 * Create class priorityQueue contains main method:
 */
public class PriorityQueue extends DoublyLinkedList<Player> {

    /*
     * get list of doublyLinkedList to process
     */
    public PriorityQueue() {
        super();
    }
    
    public PriorityQueue getList(){
        return this;
    }

    /*
     *addAndSort: Add new player into list and sort its point
     *input: player information
     */
    public void addAndSort(Player player) {
        if (this.isEmpty()) {
            this.insertFirst(player);
        } else if (player.getPoint() >= this.getHeader().getElement().getPoint()) {
            if (player.getPoint() > this.getHeader().getElement().getPoint()) {
                this.insertFirst(player);
            } else {
                Node<Player> current = this.getHeader();

                this.addBetween(player, current, current.getNext());
            }
        } else if (player.getPoint() <= this.getTrailer().getElement().getPoint()) {
            this.insertLast(player);
        } else {
            Node<Player> current = this.getHeader();
            while (current.getElement().getPoint() > player.getPoint()) {
                current = current.getNext();
            }

            // them node moi vao truoc node current
            this.addBetween(player, current.getPrev(), current);
        }
    }

    /*
     *input: email of player
     *output: return node position
     */
    private int getNodePosition(String email) {
        for (int i = 0; i < this.size; i++) {
            if (this.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    /*
     * update: Change information of player
     * Input: player's email and point
     */
    public void update(String email, int point) {
        if (this.isEmpty()) { //list empty
            System.out.println("List empty");
            return;
        }

        int pos = getNodePosition(email);
        if (pos < 0) { // can;t find player
            System.out.println("Error: No information found.");
        } else { // can find pkayer
            this.get(pos).setPoint(point); // update new point for player
            String updateEmail = this.get(pos).getEmail(); // update email for new Node
            int updatePoint = this.get(pos).getPoint(); // update Point for new Node
            delete(this.get(pos).getEmail()); // delete current node and update new node
            Player player = new Player(updateEmail, updatePoint);
            addAndSort(player);// update list
        }
    }

    /*
     *removePlayerHasMaxPoint with O(1)
     */
    public void removePlayerHasMaxPoint() {
        this.removeFirst();
    }

    /*
     *GetPlayerHasMaxPoint with O(1)
     *Get the highest point of player
     */
    public int getPlayerHasMaxPoint() {
        return this.getHeader().getElement().getPoint();
    }

    /*
     * delete any player with specific email of player
     */
    public void delete(String email) {
        if (this.isEmpty()) { 
            System.out.println("Error: List empty");
            return;
        }

        int pos = getNodePosition(email); //position of email
        if (pos < 0) { //can't find
            System.out.println("No information found");
        } else { //delete player
            this.removeAtPosition(pos);
        }
    }

    /*
     *Get node player point
     *Input: email of player
     *Output: get back player's point
     */
    public int getNodePlayerPoint(String email) {
        Node<Player> current = this.getHeader();
        while (!current.getElement().getEmail().equals(email)) { //find player's email
            current = current.getNext();
        }
        return current.getElement().getPoint();//return player's point
    }
    
    /*
     *Print player list 
     */
    public void printPlayerList(){
        Node<Player> current = this.getHeader();
        while(current!=null){
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }
}

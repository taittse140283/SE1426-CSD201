package Bai1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lehie
 */

public class PriorityQueue extends DoublyLinkedList<Player> {
    
    //get list of doublylinkedlist to process
    public PriorityQueue() {
        super();
    }
    
    public PriorityQueue getList(){
        return this;
    }
    
    //add new player into list and sort its point
    public void addAndSort(Player player) {
        if (this.isEmpty()) {
            this.addFirst(player);
        } else if (player.getPoint() >= this.getHeader().getElement().getPoint()) {
            if (player.getPoint() > this.getHeader().getElement().getPoint()) {
                this.addFirst(player);
            } else {
                Node<Player> current = this.getHeader();

                this.addBetween(player, current, current.getNext());
            }
        } else if (player.getPoint() <= this.getTrailer().getElement().getPoint()) {
            this.addLast(player);
        } else {
            Node<Player> current = this.getHeader();
            while (current.getElement().getPoint() > player.getPoint()) {
                current = current.getNext();
            }

            this.addBetween(player, current.getPrev(), current);
        }
    }
    
    //return node position
    private int getNodePosition(String email) {
        for (int i = 0; i < this.size; i++) {
            if (this.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }
    
    //change infor of player
    public void update(String email, int point) {
        if (this.isEmpty()) { //list empty
            System.out.println("List empty");
            return;
        }
        
        int pos = getNodePosition(email);
        if (pos < 0) { 
            System.out.println("Error: No information found.");
        } else {
            this.get(pos).setPoint(point); 
            String updateEmail = this.get(pos).getEmail(); 
            int updatePoint = this.get(pos).getPoint();
            delete(this.get(pos).getEmail()); 
            Player player = new Player(updateEmail, updatePoint);
            addAndSort(player);
        }
    }

    public void removePlayerHasMaxPoint() {
        this.removeFirst();
    }
    
    //get the highest point of player
    public int getPlayerHasMaxPoint() {
        return this.getHeader().getElement().getPoint();
    }
    
    //delete any player with specific email of player
    public void delete(String email) {
        if (this.isEmpty()) { 
            System.out.println("Error: List empty");
            return;
        }

        int pos = getNodePosition(email); 
        if (pos < 0) { 
            System.out.println("No information found");
        } else { 
            this.removeAtPosition(pos);
        }
    }

    //Get node player point
    public int getNodePlayerPoint(String email) {
        Node<Player> current = this.getHeader();
        while (!current.getElement().getEmail().equals(email)) {
            current = current.getNext();
        }
        return current.getElement().getPoint();
    }
    
    //Print player list
    public void printPlayerList(){
        Node<Player> current = this.getHeader();
        while(current!=null){
            System.out.println(current.getElement());
            current = current.getNext();
        }
    }
}

 
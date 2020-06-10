/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

import java.util.Scanner;

/**
 *
 * @author User
 */

/*
  * Its class will be get list of doublyLinkedList to process
  * Create class priorityQueue contains main method:
   - addAndSort: Add new player into list and sort its point
   - update: Edit information of player
   - removePlayerHasMaxPoint with O(1)
   - getPlayerHasMaxPoint with O(1)
   - delete any player with specific email of player
 */
public class PriorytiQueue {

    DoublyLinkedList<Player> list = new DoublyLinkedList<>();

    /*
        * get list of doublyLinkedList to process
     */
    public DoublyLinkedList<Player> getList() {
        return list;
    }

    /*
        *input: player information
     */
    public void addAndSort(Player player) {
        if (list.isEmpty()) {
            list.insertFirst(player);
        } else if (player.getPoint() >= list.getHeader().getElement().getPoint()) {
            if (player.getPoint() > list.getFirst().getPoint()) {
                list.insertFirst(player);
            } else {
                DoublyLinkedList.Node<Player> current = list.getHeader();
                list.addBetween(player, current, current.getNext());
            }
        } else if (player.getPoint() <= list.getLast().getPoint()) {
            list.insertLast(player);
        } else {
            DoublyLinkedList.Node<Player> current = list.getHeader();
            while (current.getElement().getPoint() > player.getPoint()) {
                current = current.getNext();
            }

            // them node moi vao truoc node current
            list.addBetween(player, current.getPrev(), current);
        }
    }

    /*
        *input: email of player
        *output: return node position
     */
    private int getNodePosition(String email) {
        for (int i = 0; i < list.size; i++) {
            if (list.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }
    
    public void update(String email) {
        if(list.isEmpty()) {
            System.out.println("List empty");
            return;
        }
        
        int pos = getNodePosition(email);
        if(pos < 0) {
            System.out.println("Error: No information found.");
        } else {
            Scanner scanner = new Scanner(System.in);
            String newEmail = scanner.nextLine();
            int point;
            try {
                point = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Got an exception");
                return;
            }
            
            list.get(pos).setEmail(newEmail);
            list.get(pos).setPoint(point);
        }
    }
    
    public void removePlayerHasMaxPoint() {
        list.removeFirst();
    }
    
    public void getPlayerHasMaxPoint() {
        list.getHeader();
    }
    
    public void delete(String email) {
        if(list.isEmpty()) {
            System.out.println("Error: List empty");
            return;
        }
        
        int pos = getNodePosition(email);
        if(pos < 0) {
            System.out.println("No information found");
        } else {
            list.removeAtPosition(pos);
        }
    }
}

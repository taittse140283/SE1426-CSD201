/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

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
}

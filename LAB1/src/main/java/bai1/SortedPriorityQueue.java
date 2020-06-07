/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class SortedPriorityQueue {

    private DoublyLinkedList<Player> list = new DoublyLinkedList();

    public DoublyLinkedList<Player> getList() {
        return list;
    }

    public void setList(DoublyLinkedList<Player> list) {
        this.list = list;
    }

    /**
     * Add new node into queue which sort by point of Player
     *
     * @param newest
     */
    public void add(DLLNode<Player> newest) {
        if (list.getSize() == 0) {
            list.setHeader(newest);
            list.setTrailer(newest);
            list.setSize(list.getSize() + 1);
        } else {
            //The header has the greatest point of Player 
            if (newest.getInfo().getPoint() > list.getHeader().getInfo().getPoint())//compare with header, 
            //if point of Player in newest Node greater than point of Player in header Node
            //then add it at first position of the list
            {
                list.addFirst(newest);
            } //The trailer has the lowest point of Player
            else if (newest.getInfo().getPoint() < list.getTrailer().getInfo().getPoint())//compare with trailer
            //if point of Player in newest Node lower than point of Player in trailer Node
            //then add it at last position of the list
            {
                list.addLast(newest);
            } else {
                DLLNode<Player> temp = list.getHeader();
                //find the position can insert new node
                while (temp.getInfo().getPoint() > newest.getInfo().getPoint()) {
                    temp = temp.getNext();
                }
                //new node is inserted in front of temp  
                (temp.getPrev()).setNext(newest);
                newest.setPrev(temp.getPrev());
                temp.setPrev(newest);
                newest.setNext(temp);
                list.setSize(list.getSize() + 1);
            }
        }
    }

    /**
     * Remove Player has highest point in the list
     *
     * @return Player be removed
     */
    public Player removeMax() {
        return list.removeFirst();
    }

    /**
     * Get Player has highest point in the list
     *
     * @return Player has highest point in the list
     */
    public Player getMax() {
        return list.getHeaderInfo();
    }

    /**
     * Search for player in the list has the same email with the Player has
     * email need to find
     *
     * @param email
     * @return Player has the same email with the Player has email need to find,
     * if can't find, return null
     */
    public Player getPlayer(String email) {
        DLLNode<Player> temp = list.getHeader();//get header
        while (!temp.getInfo().getEmail().equals(email) && temp != null)//traverse the list to find Player has the same email
        {
            temp = temp.getNext();
        }
        return temp.getInfo();
    }

    /**
     * Get the node in the list has the same email with parameter email
     *
     * @param email
     * @return node in the list has the same email with parameter email, if
     * can't find, return null
     */
    public DLLNode<Player> getNode(String email) {
        DLLNode<Player> temp = list.getHeader();//get header
        while (!temp.getInfo().getEmail().equals(email) && temp != null)//traverse the list to find Node has the same email
        {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * Update player has the same email with parameter email
     *
     * @param email
     */
    public void updatePlayer(String email, String point) {
        DLLNode<Player> updatePlayer = getNode(email);//get player has the same email
        if (updatePlayer != null) {//if found
            //Update point of found player
            try {
                if (Integer.parseInt(point) < 0) {
                    throw new Exception("Error:Must>0");
                }
                updatePlayer.getInfo().setPoint(Integer.parseInt(point));

            } catch (NumberFormatException e) {
                System.out.println("Error:Must be integer");
                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            //clone update node
            DLLNode<Player> tempUpdate = null;
            try {
                tempUpdate = updatePlayer.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println(e);
            }
            //delete update node in old position
            updatePlayer.getPrev().setNext(updatePlayer.getNext());
            updatePlayer.getNext().setPrev(updatePlayer.getPrev());
            //Link clone update node with right position
            this.add(tempUpdate);
            list.setSize(list.getSize()-1);//no need to increasing size, cause it like replace the node 

            //print to check updated
            System.out.println("Updated player:" + updatePlayer.toString());
        } else {
            System.out.println("Error:Not found player");
        }
    }

    /**
     * Delete player has the same email with parameter email
     *
     * @param email
     */
    public void deletePlayer(String email) {
        DLLNode<Player> deletePlayer = getNode(email);
        if (deletePlayer != null) {
            System.out.println("Deleted player:" + list.remove(deletePlayer).toString());
        } else {
            System.out.println("Error:Not found player");
        }
    }

    public void print() {
        DLLNode<Player> temp = list.getHeader();
        while (temp != null) {
            System.out.println(temp.getInfo().toString());
            temp = temp.getNext();
        }
    }

}

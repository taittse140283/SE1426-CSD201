/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_1;

/**
 *
 * @author W10
 * Lay double link list de xep danh sach nguoi choi theo hang doi uutien
 */
public class PriorityQueue {
    DoublyLinkedList<Player> ls = new DoublyLinkedList<>();

    public DoublyLinkedList<Player> getLs() {
        return ls;
    }

    public void setLs(DoublyLinkedList<Player> ls) {
        this.ls = ls;
    }
    
    
}

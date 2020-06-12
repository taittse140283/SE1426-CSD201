/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_1;

/**
 *
 * @author TAN
 */
public class PriorityQueue {
    private DoublyLinkedList<Player> list = new DoublyLinkedList();

    public DoublyLinkedList<Player> getList() {
        return list;
    }

    public void setList(DoublyLinkedList<Player> list) {
        this.list = list;
    }
    
    public void add(Node<Player> player){
        int rank = player.getInfo().getPoint();
        if(list.isEmpty()){
            list.addFirst(player);
        }
        else{
            if (rank >= list.getHead().getInfo().getPoint())
                list.addFirst(player);
            else if (rank <= list.getTail().getInfo().getPoint())
                list.addLast(player);
            else {
                Node<Player> current  = list.getHead();
                //find the position can insert new node
                while (current.getInfo().getPoint() > player.getInfo().getPoint()) {
                    current = current.getNext();
                }
                //new node is inserted in front of temp  
                (current.getPrev()).setNext(player);
                player.setPrev(current.getPrev());
                current.setPrev(player);
                player.setNext(current);
                list.setSize(list.getSize() + 1);
            }
        }       
    }
    private int getNode(String email) {
        for (int i = 0; i < list.getSize(); i++) {
            if (list.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }

    public void deletePlayer(String email) {
        int check = getNode(email);
        if(list.isEmpty()){
            System.out.println("Danh sach trong");
        }
        if (check < 0) {
            System.out.println("Khong tim thay player");
        }else{
            list.removePos(check);
        }
    }
}

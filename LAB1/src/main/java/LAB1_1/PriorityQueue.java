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
    public Node<Player> getNode(String email) {
        Node<Player> current = list.getHead();
        while (!current.getInfo().getEmail().equals(email)){
            current = current.getNext();
        }
        return current;
    }
    public void updateNewPoint(String email, int newPoint) {
        Node<Player> updatedNode = getNode(email);
        
        if(updatedNode == null) {
            System.out.println("Email khong ton tai.");
        }
        else{
            updatedNode.getInfo().setPoint(newPoint); 
            updatedNode.getPrev().setNext(updatedNode.getNext());
            updatedNode.getNext().setPrev(updatedNode.getPrev());
            add(updatedNode);
            list.setSize(list.getSize()-1);
            System.out.println("Update" + email + "thanh cong");
        }
    }
    public void deletePlayer(String email) {
        Node<Player> player = getNode(email);
        if (player == null) {
            System.out.println("Khong tim thay player");
        } else {
            if(player == list.getHead()){
                list.removeFirst();
            }
            else if(player == list.getTail()){
                list.removeLast();
            }
            else {
                list.remove(player);
            }
        }
    }
    public void removePlayerMax(){
        list.removeFirst();
    }
    public Player getPlayerMax(){
        return list.getHeadInfo();
    }
}

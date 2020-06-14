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
        if(list.getSize() == 0) {
            list.setHead(player);
            list.setTail(player);
            list.setSize(list.getSize() + 1);
        }
        else{
            //Neu nguoi choi lon hon nguoi dau tien danh sach thi them vao dau danh sach
            if (rank > list.getHead().getInfo().getPoint())
                list.addFirst(player);
            //Neu nguoi choi nho hon nguoi cuoi danh sach thi them vao cuoi danh sach
            else if (rank <= list.getTail().getInfo().getPoint())
                list.addLast(player);
            else {
                Node<Player> current  = list.getHead();
                //Tim vi tri de chen player moi
                while (current.getInfo().getPoint() >= player.getInfo().getPoint()) {
                    current = current.getNext();
                }
                //Them nguoi choi moi vay chuoi
                player.setNext(current);
                player.setPrev(current.getPrev());
                current.getPrev().setNext(player);
                current.setPrev(player);
                list.setSize(list.getSize() + 1);
            }
        }       
    }
    // Tim kiem nguoi choi tu dau danh sach 
    public Node<Player> getNode(String email) {
        Node<Player> current = list.getHead();
        while (!current.getInfo().getEmail().equals(email)){
            current = current.getNext();
        }
        return current;
    }
    public void updateNewPoint(String email, String newPoint) {
        Node<Player> updatedNode = getNode(email);
        
        if(updatedNode == null) {
            System.out.println("Email khong ton tai.");
        }
        else{
            updatedNode.getInfo().setPoint(Integer.parseInt(newPoint)); 
            updatedNode.getPrev().setNext(updatedNode.getNext());
            updatedNode.getNext().setPrev(updatedNode.getPrev());
            add(updatedNode);
            list.setSize(list.getSize()-1);
            System.out.println("Update " + email + " thanh cong");
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
    public Player removePlayerMax(){
        return list.removeFirst();
    }
    public Player getPlayerMax(){
        return list.getHeadInfo();
    }
}

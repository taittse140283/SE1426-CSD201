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
    // input : thong tin cua nguoi choi
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
    // Input : so diem va email cua nguoi choi can cap nhat
    public void updateNewPoint(String email, int newPoint) {
        Node<Player> updatedNode = getNode(email);
        
        if(updatedNode == null) {
            System.out.println("Email khong ton tai.");
        }
        else{
            if(updatedNode == list.getHead()){ // truong hop update nguoi choi dau danh sach
//                updatedNode.getInfo().setPoint(Integer.parseInt(newPoint)); 
//                updatedNode.getPrev().setNext(updatedNode.getNext());
                  removePlayerMax();
            }
            else if (updatedNode == list.getTail()){ // truong hop update nguoi choi cuoi danh sach
//              updatedNode.getInfo().setPoint(Integer.parseInt(newPoint)); 
//              updatedNode.getNext().setPrev(updatedNode.getPrev());
                removePlayerMin();
            }else{
                updatedNode.getInfo().setPoint(newPoint); 
                updatedNode.getPrev().setNext(updatedNode.getNext());
                updatedNode.getNext().setPrev(updatedNode.getPrev());
            }
//            add(updatedNode);
            Player p = new Player(email, newPoint);
            Node<Player> n = new Node<>(p, list.getHead(), list.getTail());
            add(n);
            list.setSize(list.getSize()-1);
            System.out.println("Update " + email + " thanh cong");
        }
    }
    // Input : so diem va email cua nguoi choi can xoa
    public void deletePlayer(String email) {
        Node<Player> player = getNode(email);
        if (player == null) { 
            System.out.println("Khong tim thay player");
        } else {
            if(player == list.getHead()){ // truong hop delete nguoi choi dau danh sach
                list.removeFirst();
            }
            else if(player == list.getTail()){// truong hop delete nguoi choi cuoi danh sach
                list.removeLast();
            }
            else {
                list.remove(player);
            }
        }
    }
    //xoa nguoi choi dau danh sach O(1)
    public Player removePlayerMax(){
        return list.removeFirst();
    }
    //xoa nguoi choi cuoi danh sach
    public Player removePlayerMin(){
        return list.removeLast();
    }
    //tim kiem nguoi choi dau danh sach O(1)
    public Player getPlayerMax(){
        return list.getHeadInfo();
    }
}

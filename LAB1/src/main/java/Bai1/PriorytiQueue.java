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
            if (player.getPoint() > list.getHeader().getElement().getPoint()) {
                list.insertFirst(player);
            } else {
                DoublyLinkedList.Node<Player> current = list.getHeader();
                list.addBetween(player, current, current.getNext());
            }
        } else if (player.getPoint() <= list.getTrailer().getElement().getPoint()) {
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
    
    /*
        * Y tuong: Tim dc vi tri cua node can update, sau do gan gia tri moi cho mot node moi va xoa node cu
        * Input: la dia chi email cua nguoi choi va so diem can cap nhat
    */
    public void update(String email, long point) {
        if(list.isEmpty()) { // truong hop danh sach chua co nguoi choi
            System.out.println("List empty");
            return;
        }
        
        int pos = getNodePosition(email);
        if(pos < 0) { // khong tim thay email cua nguoi choi do trong danh sach
            System.out.println("Error: No information found.");
        } else { // truong hop tim thay nguoi choi
            list.get(pos).setPoint(point); // set up diem moi cho nguoi choi do
            String updateEmail = list.get(pos).getEmail(); // gan email cho mot node moi 
            long updatePoint = list.get(pos).getPoint(); // gan so diem moi cho node moi
            delete(list.get(pos).getEmail()); // xoa node hien tai de cap nhat node moi voi du lieu moi
            Player player = new Player(updateEmail, updatePoint);
            addAndSort(player);// cap nhat vao danh sach
        }
    }
    
    public void removePlayerHasMaxPoint() {
        list.removeFirst();
    }
    
    /*
        lay diem so nguoi choi co diem so cao nhat
        Kieu tra ve la so nguyen vi la diem so
    */
    public long getPlayerHasMaxPoint() {
        return list.getHeader().getElement().getPoint();
    }
    
    public void delete(String email) {
        if(list.isEmpty()) { // truong hop danh sach trong ko the xoa dc
            System.out.println("Error: List empty");
            return;
        }
        
        int pos = getNodePosition(email); // tim vi tri email can xoa trong danh sach
        if(pos < 0) {// truong hop ko tim thay
            System.out.println("No information found");
        } else {// xoa nguoi choi tai vi tri nay
            list.removeAtPosition(pos);
        }
    }
    
    /*
        *Lay diem so cua nguoi choi bat ky trong danh sach
        * Input: dia chi email cua nguoi choi
        *Output: tra lai so diem cua nguoi choi do
    */
    public long  getNodePlayerPoint(String email) {
        DoublyLinkedList.Node<Player> current = list.getHeader();
        while(!current.getElement().getEmail().equals(email)) { // tim email cua nguoi choi do trong danh sach
            current = current.getNext();
        }
        return current.getElement().getPoint();// tra ve diem cua nguoi choi
    }
}

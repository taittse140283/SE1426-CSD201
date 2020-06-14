/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

/**
 *
 * @author Admin
 */
public class PriorityQueue {

    DoublyLinkedList<Gamer> list = new DoublyLinkedList<>();

    public DoublyLinkedList<Gamer> getList() {
        return list;
    }

    public void addAndSort(Gamer gamer) {
        int size=this.size();
        if (list.isEmpty()) {
            list.addFirst(gamer);
        } else {
            for (int i = 0; i < size; ++i) {
                int index = size - i - 1;
                if (gamer.getPoint() >= ((Gamer) this.list.get(index)).getPoint()) {
                    if (gamer.getPoint() > ((Gamer) this.list.get(index)).getPoint()) {
                        this.list.addFirst(gamer);
                        return;
                    } else {
                        DoublyLinkedList.Node<Gamer> current = list.getHeader();
                        list.addBetween(gamer, current, current.getNext());
                    }
                } else if (gamer.getPoint() < ((Gamer) this.list.get(index)).getPoint()) {
                    list.addLast(gamer);
                } else {
                    DoublyLinkedList.Node<Gamer> current = list.getHeader();
                    while (current.getElement().getPoint() > gamer.getPoint()) {
                        current = current.getNext();
                    }
                    list.addBetween(gamer, current.getPrev(), current);
                }
            }
        }
    }
    
    public long searchMaxPoint(){
        return list.getHeader().getElement().getPoint();
    }
    
    public long search(String email){
        DoublyLinkedList.Node<Gamer> current = list.getHeader();
        while(!current.getElement().getEmail().equals(email)) { // tim email cua nguoi choi do trong danh sach
            current = current.getNext();
        }
        return current.getElement().getPoint();
    }
    

    public void removeMax() {
        list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.getSize();
    }

    @Override
    public String toString() {
        return list.toString() + "\n";
    }
}

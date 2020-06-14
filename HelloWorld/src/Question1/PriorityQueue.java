/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question1;

/**
 *
 * @author Thong
 */
public class PriorityQueue {

    LinkedList<Gamer> list = new LinkedList<>();
    
    public LinkedList<Gamer> getList() {
        return list;
    }

    public void AddAndSort(Gamer gamer) {
        if (list.isEmpty()) {
            list.insertFirst(gamer);
        } else if (gamer.getPoint() >= list.getHeader().getElement().getPoint()) {
            if (gamer.getPoint() > list.getHeader().getElement().getPoint()) {
                list.insertFirst(gamer);
            } else {
                LinkedList.Node<Gamer> current = list.getHeader();
                list.addBetween(gamer, current, current.getNext());
            }
        } else if (gamer.getPoint() <= list.getTrailer().getElement().getPoint()) {
            list.insertLast(gamer);
        } else {
            LinkedList.Node<Gamer> current = list.getHeader();
            while (current.getElement().getPoint() > gamer.getPoint()) {
                current = current.getNext();
            }
            list.addBetween(gamer, current.getPrev(), current);
        }
    }

    private int getNodePosition(String email) {
        for (int i = 0; i < list.size; i++) {
            if (list.get(i).getEmail().equals(email)) {
                return i;
            }
        }
        return -1;
    }
    

    public void update(String email, int point) {
        if(list.isEmpty()) { 
            System.out.println("List empty!");
            return;
        }
        
        int pos = getNodePosition(email);
        if(pos < 0) { 
            System.out.println("Error! Can't found.");
        } else { 
            list.get(pos).setPoint(point); 
            String updateEmail = list.get(pos).getEmail(); 
            int updatePoint = list.get(pos).getPoint(); 
            delete(list.get(pos).getEmail()); 
            Gamer gamer = new Gamer(updateEmail, updatePoint);
            AddAndSort(gamer);
        }
    }
    
    public void removeGamerHasMaxPoint() {
        list.removeFirst();
    }
    
    public int getGamerHasMaxPoint() {
        return list.getHeader().getElement().getPoint();
    }
    
    public void delete(String email) {
        if(list.isEmpty()) { 
            System.out.println("List Empty!");
            return;
        }
        
        int pos = getNodePosition(email);
        if(pos < 0) {
            System.out.println("Error! Can't found.");
        } else {
            list.removeAtPosition(pos);
        }
    }
    

    public int  getNodeGamerPoint(String email) {
        LinkedList.Node<Gamer> current = list.getHeader();
        while(!current.getElement().getEmail().equals(email)) { 
            current = current.getNext();
        }
        return current.getElement().getPoint();
    }
}
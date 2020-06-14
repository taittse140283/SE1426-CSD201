/**
 *
 * @author SE140834
 */
package problem1;

import collections.*;

public class SortedPriorityQueue extends DoubleLinkedList<Player> {
    private final DoubleLinkedList<Player> list =  new DoubleLinkedList<>();
    
    public void insert(String email, long point) {
        Player player = new Player(email, point);
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail() && walk.getNext().getElement().getPoint() >= player.getPoint()) walk = walk.getNext();
        list.addBetween(player, walk, walk.getNext());
    }
    
    public boolean isContains(String email) {
        boolean result = false;
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail()) {
            walk = walk.getNext();
            if (walk.getElement().getEmail().equals(email)) {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public long get(String email) {
        long result = 1L;
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail()) {
            walk = walk.getNext();
            if (walk.getElement().getEmail().equals(email)) {
                result = walk.getElement().getPoint();
                break;
            }
        }
        return result;
    }
    
    public void remove(String email) {
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail()) {
            walk = walk.getNext();
            if (walk.getElement().getEmail().equals(email)) {
                list.remove(walk);
            }
        }
    }
    
    public long getMin() {
        Node<Player> top = list.getHead();
        return top.getElement().getPoint();
    }
    
    
    
    @Override
    public String toString() {
        String result = "";
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail()) {
            walk = walk.getNext();
            result += walk.getElement() + "\n";
        }
        return result;
    }
}

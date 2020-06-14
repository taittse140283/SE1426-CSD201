/**
 *
 * @author SE140834
 */
package problem1;

import collections.*;

public class SortedPriorityQueue extends DoubleLinkedList<Player> {
    private final DoubleLinkedList<Player> list =  new DoubleLinkedList<>();
     /**
     * @argument String email, long point
     * @function insert new pair of email and point
     */
    public void insert(String email, long point) {
        Player player = new Player(email, point);
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail() && walk.getNext().getElement().getPoint() >= player.getPoint()) walk = walk.getNext();
        list.addBetween(player, walk, walk.getNext());
    }
     /**
     * @argument String email
     * @return if list is contains email or not
     */   
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
     /**
     * @argument String email
     * @return a point by specific email
     */ 
    public long get(String email) {
        long result = Long.MAX_VALUE;
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
     /**
     * @argument String email
     * @function remove a specific pair by email
     */   
    public void remove(String email) {
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail()) {
            walk = walk.getNext();
            if (walk.getElement().getEmail().equals(email)) {
                list.remove(walk);
            }
        }
    }
     /**
     * @argument void
     * @function remove the first element of list
     */    
    public void removeMin() {
        list.removeFirst();
    }
     /**
     * @argument void
     * @return the first element of list
     */      
    public long getMin() {
        Node<Player> top = list.getHead().getNext();
        return top.getElement().getPoint();
    }
     /**
     * @Override
     * @function toString();
     */       
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
     /**
     * @String email, long point
     * @function update point of email
     */     
    void update(String email, long point) {
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail()) {
            walk = walk.getNext();
            if (walk.getElement().getEmail().equals(email)) {
                walk.getElement().setPoint(point);
                break;
            }
        }
    }
}

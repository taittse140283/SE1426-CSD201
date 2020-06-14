/**
 *
 * @author SE140834
 */
package problem1;

import collections.*;

public class SortedPriorityQueue extends DoubleLinkedList<Player> {
    private final DoubleLinkedList<Player> list;

    public SortedPriorityQueue() {
        list = new DoubleLinkedList<>();
    }
    public void insert(Player player) {
        Node<Player> walk = list.getHead();
        while (walk.getNext() != list.getTail() && walk.getNext().getElement().getPoint() > player.getPoint()) walk = walk.getNext();
    }
}

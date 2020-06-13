package bai1;

/**
 *
 * @author Admin
 */
/** Class Doubly LinkedList Node
 * implements Cloneable(to clone node for update method in SortedPriorityList)
 *
 * */
public class DLLNode<Player> implements Cloneable{

    private Player info;//contains information of player include email and point
    private DLLNode<Player> prev;//reference to previous node
    private DLLNode<Player> next;//reference to next node
    //constructor, getter, setter

    /**
     * Default Constructor
     */
    public DLLNode() {
        info=null;
        prev=next=null;
    }

    /**
     * Parameter Constructor
     * @param info This is Player information include email and point
     * @param prev This is DLLNode reference to previous node
     * @param next This is DLLNode reference to next node
     */
    public DLLNode(Player info, DLLNode prev, DLLNode next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }

    public Player getInfo() {
        return info;
    }

    public void setInfo(Player info) {
        this.info = info;
    }

    public DLLNode<Player> getPrev() {
        return prev;
    }

    public void setPrev(DLLNode<Player> prev) {
        this.prev = prev;
    }

    public DLLNode<Player> getNext() {
        return next;
    }

    public void setNext(DLLNode<Player> next) {
        this.next = next;
    }

    /**
     * Override clone() method of Cloneable interface
     * @return DLLNode<Player>
     * @throws CloneNotSupportedException if can't not clone
     */
    @Override
    public DLLNode<Player> clone() throws CloneNotSupportedException {
        return (DLLNode<Player>) super.clone();
    }


}

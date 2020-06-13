package bai1;
/** Class Doubly LinkedList Node
 * implements Cloneable(to clone node for update method in SortedPriorityList)
 *
 * */
public class DDLNode<Player> implements Cloneable {
    private Player info;//contains information of player include email and point
    private DDLNode<Player> prev;//reference to previous node
    private DDLNode<Player> next;//reference to next node
    //constructor, getter, setter

    /**
     * Default Constructor
     */
    public DDLNode() {
        info=null;
        prev=next=null;
    }

    /**
     * Parameter Constructor
     * @param info This is Player information include email and point
     * @param prev This is DLLNode reference to previous node
     * @param next This is DLLNode reference to next node
     */
    public DDLNode(Player info, DDLNode prev, DDLNode next) {
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

    public DDLNode<Player> getPrev() {
        return prev;
    }

    public void setPrev(DDLNode<Player> prev) {
        this.prev = prev;
    }

    public DDLNode<Player> getNext() {
        return next;
    }

    public void setNext(DDLNode<Player> next) {
        this.next = next;
    }
    /**
     * Overrid clone() method of Cloneable interface
     * @return DLLNode<Player>
     * @throws CloneNotSupportedException if can't not clone
     */
    @Override
    public DDLNode<Player> clone() throws CloneNotSupportedException {
        return (DDLNode<Player>) super.clone();
    }

}

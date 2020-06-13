package bai1;
/**
 * Doubly Linked List implementation
 * Fields of DoublyLinkedList: DLLNode<Player> header, DLLNode<Player> trailer, int size
 */
public class DoublyLinkedList<Player> {
    private DDLNode<Player> header;//reference to the first node of the list
    private DDLNode<Player> trailer;//reference to the last node of the list
    private int size = 0;

    //constructor
    //change to default(be used to this way =))))))))

    /**
     * Default Constructor of DoublyLinkedList with header, trailer are null and size =0
     */
    public DoublyLinkedList() {
        header = trailer = null;
        size = 0;
    }

    /**
     *Getter, setter of DoublyLinkedList fields
     */
    public DDLNode<Player> getHeader() {
        return header;
    }

    public void setHeader(DDLNode<Player> header) {
        this.header = header;
    }

    public DDLNode<Player> getTrailer() {
        return trailer;
    }

    public void setTrailer(DDLNode<Player> trailer) {
        this.trailer = trailer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Check if the list is empty
     * @return true if size=0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     * This method gets information of header
     * @return Player of DLLNode<Player> header
     */
    public Player getHeaderInfo() {
        return header.getInfo();
    }

    /**
     * This method inserts new node into list at first position
     *
     * @param newest This is DLLNode will be added at first position
     * @return nothing
     */
    public void addFirst(DDLNode<Player> newest) {
        newest.setNext(header);//set next of newest reference to header
        header.setPrev(newest);//set previous of header reference to newest 
        header = newest;//newest become the header
        size++;//increasing size of the list
    }

    /**
     *This methods inserts new node into list at last position
     *
     * @param newest This is DLLNode will be added at last position
     */
    public void addLast(DDLNode<Player> newest) {
        newest.setPrev(trailer);//set prev of newest reference to trailer
        newest.setNext(null);//set next of newest refernce to null(next of trailer reference to null )
        if (size == 0)//if list is empty
        {
            header = trailer = newest;//set header and trailer are newest
        } else {
            trailer.setNext(newest);//set next of trailer reference to newest
            trailer = newest;//set newest become trailer
        }
        size++;//increading size of the list
    }

    /**
     * This method removes first node from list
     *
     * @return Player of the node be removed
     */
    public Player removeFirst() {
        if (isEmpty()) {//is list is empty
            System.out.println("Error:Empty list");//print error
        } else {
            Player value = header.getInfo();//get info of the node be removed
            header = header.getNext();//set header reference to next of header
            size--;//decrease size of the list
            if (size == 0)//if clear all node
            {
                header = trailer = null;//set header and trailer to be null(cause there's no more node)
            }
            return value;//return info of the node be removed
        }
        return null;
    }

    /**
     * This methods removes a DLLNode
     *
     * @param deleteNode DLLNode<Player> will be removed
     * @return Player of the node be removed
     */
    public Player remove(DDLNode<Player> deleteNode) {
        if (isEmpty()) {//is list is empty
            System.out.println("Error:Empty list");//print error
        } else {
            Player value = deleteNode.getInfo();//get info of the node be removed
            //link 2 node that the removed node places between
            deleteNode.getPrev().setNext(deleteNode.getNext());
            deleteNode.getNext().setPrev(deleteNode.getPrev());
            size--;//decrease size of the list
            if (size == 0)//if clear all node
            {
                header = trailer = null;//set header and trailer to be null(cause there's no more node)
            }
            return value;//return info of the node be removed
        }
        return null;
    }

    /**
     * This method removes Player in last position
     * @return Player of the node be removed
     */
    public Player removeLast() {
        if(isEmpty())
        {
            System.out.println("Error:Empty List");
        }
        else
        {
            Player value=trailer.getInfo();//get info of the node be removed
            trailer=trailer.getPrev();//set trailer reference to its prev
            size--;
            if (size == 0)//if clear all node
            {
                header = trailer = null;//set header and trailer to be null(cause there's no more node)
            }
            return value;
        }
        return null;
    }
}

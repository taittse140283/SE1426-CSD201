import java.io.*;

/**
 * <h1>DoubleLinkedList</h1>
 * The DoubleLinkedList program implement double linked list by the way
 * creating node to storing data. It can go to next or back to previous
 * node.
 *
 * @author Bach Duy Hoang
 * @since 2020/6/1
 */
public class DoubleLinkedList<E> {
    /**
     * The Node class use to declare Node and create
     * getter, setter, constructor of Node
     */
    private static class Node<E> {
        private E e;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> prev, Node<E> next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    /**
     * Method to create a new empty list
     */
    public DoubleLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    /**
     * This method used to find size of double linked list
     *
     * @return int This returns size of list
     */
    public int size() {
        return size;
    }

    /**
     * This method used to check list is empty or not
     *
     * @return boolean This returns true or false
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This method used to get first value of list
     *
     * @return E This returns Element type if it not null.
     * returns null if list is empty
     */
    public E first() {
        if (isEmpty()) return null;
        return header.getNext().getE();
    }

    /**
     * This method used to get last value of list
     *
     * @return E This returns Element type if it not null.
     * returns null if list is empty
     */
    public E last() {
        if (isEmpty()) return null;
        return trailer.getPrev().getE();
    }

    /**
     * This method used to insert value in the middle of node
     * and increase size by 1 unit
     *
     * @param e    values to insert
     * @param prev node behind
     * @param next node next
     */
    public void insert(E e, Node<E> prev, Node<E> next) {
        Node<E> newnode = new Node<>(e, prev, next);
        prev.setNext(newnode);
        next.setPrev(newnode);
        size++;
    }

    /**
     * This method used to add value to first of list. By the way
     * using method insert
     *
     * @param e value to insert
     */
    public void addFirst(E e) {
        insert(e, header, header.next);
    }

    /**
     * This method used to add value to last of list. By the way
     * using method insert
     *
     * @param e value to insert
     */
    public void addLast(E e) {
        insert(e, trailer.prev, trailer);
    }

    /**
     * This method used to remove node difference header or trailer
     * and decrease size by one unit
     *
     * @param node the node wants to delete
     */
    public void removeNode(Node<E> node) {
        if (node != header && node != trailer) {
            Node<E> font = node.getPrev();
            Node<E> back = node.getNext();
            font.next = back;
            back.prev = font;
            size--;
        }
    }

    /**
     * This method used to remove first node difference header or trailer
     * by using removeNode
     */
    public void removeFirst() {
        removeNode(header.getNext());
    }

    /**
     * This method used to remove last node difference header or trailer
     * by using removeNode
     */
    public void removeLast() {
        removeNode(trailer.getPrev());
    }

    /**
     * This method used to get value of node base on positive of node
     * by using getNode function
     *
     * @param post This is positive of node
     * @return E value of node
     */
    public E getElementNode(int post) {
        return getNode(post).getE();
    }

    /**
     * This method used to get node in list
     *
     * @param post This is positive of node
     * @return Node Node in list
     */
    public Node<E> getNode(int post) {
        Node<E> temp = header.next;
        for (int i = 0; i < post; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * This method used to print value of node in list
     */
    public void print() {
        for (Node<E> n = header.next; n != trailer; n = n.next) {
            System.out.println(n.getE() + " ");
        }
    }

    /**
     * This method used to print value of node in list to file
     *
     * @param file name of file that wants to write to
     */
    public void printtoFile(String file) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\".concat(file));
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeBytes("Email, Point\n");
        for (Node<E> n = trailer.prev; n != header; n = n.prev) {
            dos.writeBytes(n.getE() + "\n");
        }
        fos.close();
        dos.close();
    }

    /**
     * This method used to print value of node in list to file
     *
     * @param file name of file that wants to write to
     */
    public void printtoFileofhtml(String file) throws IOException {
        FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\".concat(file));
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeBytes("Tag, Frequency" + "\n");
        for (Node<E> n = trailer.prev; n != header; n = n.prev) {
            dos.writeBytes(n.getE() + "\n");
        }
        fos.close();
        dos.close();
    }

}





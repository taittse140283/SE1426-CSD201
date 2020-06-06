public class SingLyLinkedList<E> {

    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElenment() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SingLyLinkedList() {
    }

    public int size() {
        return size;
    }

    public boolean isEmty() {
        return size == 0;
    }

    public E first() {
        if (isEmty()) {
            return null;
        }
        return head.getElenment();
    }

    public E last() {
        if (isEmty()) {
            return null;
        }
        return tail.getElenment();
    }

    //method to update
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmty()) {
            return null; // nothing to remove
        }
        E answer = head.getElenment();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null; // special case as list is now empty
        }
        return answer;
    }

    public void print (){
        for (Node<E> n = head ; n != null ; n = n.next ) {
            System.out.println(n.getElenment());
        }
    }

}

/**
 *
 * @author SE140834
 */
package collections;

public class DoubleLinkedList<E> {
    /*Nested Node class*/
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
        public void setElement(E e) { element = e; }
    }
    /*Define variable*/
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;
    /*Constructor*/
    public DoubleLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }
    /*Return the number of elements in this list*/
    public int size() { return size; }
    /*Check if list is empty or not*/
    public boolean isEmpty() { return size == 0; }
    /*Return the fisrt element of the list*/
    public E getFirst() {
        if (isEmpty()) return null;
        return head.getNext().getElement();
    }
    /*Return the last element of the list*/
    public E getLast() {
        if (isEmpty()) return null;
        return tail.getPrev().getElement();
    } 
    /*Add an element at the first of the list*/
    public void addFirst(E e) {
        addBetween(e, head, head.getNext());
    }
    /*Add an element at the last of the list*/
    public void addLast(E e) {
        addBetween(e, tail.getPrev(), tail);
    }
    /*Remove and return the first element of the list*/
    public E removeFirst(E e) {
        if (isEmpty()) return null;
        return remove(head.getNext());
    }
    /*Remove and return the last elment of the list*/
    public E removeLast(E e) {
        if (isEmpty()) return null;
        return remove(tail.getPrev());
    }
    //Private
    /*Adds an element to between two next element in the list*/
    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    /*Remove an element of the list*/
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getNext();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}

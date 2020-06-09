/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author User
 */
public class DoublyLinkedList<E> {

    /**
     * Create inner class Node for doublyLinkedList
     *
     * @param <E>
     */
    public class Node<E> {

        private Player data;
        private Node<E> prev;
        private Node<E> next;

        public Node(Player data) {
            this.data = data;
        }

        public Node(Player data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        /*
            Return data of Node
         */
        public Player getElement() {
            return data;
        }

        /*
            Return Node is in front of it
         */
        public Node<E> getPrev() {
            return prev;
        }

        /*
            Return Node is behind it
         */
        public Node<E> getNext() {
            return next;
        }

        /*
            Create previous Node with param is specific Node
         */
        public void setPrev(Node<E> p) {
            prev = p;
        }

        /*
            Create next Node with param is specific Node
         */
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header; // Khai bao node header
    private Node<E> trailer; // khai bao node trailer
    public int size = 0; // khoi tao kich thuoc cua danh sach

    /*
        Constructor default
        Create Node header, trailer
     */
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    /*
        Return size fo list
     */
    public int size() {
        return size;
    }

    /*
        Return true if size = 0
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /*
        Return element in top of list 
        Chuc nang: neu list duoc sap xep, co the tim ra element largest or smallest
     */
    public Player getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    /*
        Return element in last of list
        Chuc nang: neu list duoc sap xep, co the tim ra element largest or smallest
     */
    public Player getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    /*
        Add new Node at between two given Node
     */
    private void addBetween(Player e, Node<E> p, Node<E> s) {
        Node<E> newNode = new Node<>(e, p, s); // create new node
        p.setNext(newNode);  // set address for pointer
        s.setPrev(newNode); // ""
        size++; // tang kich thuoc danh sach len 1
    }

    /*
        Remove existed Node in list
     */
    private Player remove(Node<E> node) {
        Node<E> p = node.getPrev();
        Node<E> s = node.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return node.getElement();
    }

    /*
        Add newNode in top of list
     */
    public void insertFirst(Player e) {
        addBetween(e, header, header.getNext());
    }

    /*
        Add newNode in last of list
     */
    public void insertLast(Player e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    /*
        Xoa node dau danh sach
     */
    public Player removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

    /*
        Xoa node cuoi cung
     */
    public Player removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    /*
        Xoa mot phan tu trong list tai vi tri bat ki cho truoc
     */
    public void removeAtPosition(int n) {
        if (size == 0 || n < 0) { // neu size = 0 thi ko co phan tu de remove, neu vi tri < 0 thi error index
            return;
        }
        Node current = header.getNext(); // gan node dau tien trong list cho node current
        for (int i = 0; (current != null) && (i < n); i++) { // duyet den vi tri can tim
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        remove(current);
    }

    /*
        Tim kiem element bat ki trong list.
     */
    public Player get(int index) {
        if (size != 0) {
            Node<E> current = header.getNext();
            for (int i = 0; (current != null) && (i < index); i++) {
                current = current.getNext();
            }
            if (current != null) {
                return current.getElement();
            }
        }
        return null;
    }
}

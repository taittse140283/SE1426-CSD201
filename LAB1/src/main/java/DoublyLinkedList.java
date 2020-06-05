/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DoublyLinkedList<E> {

    //tao lop node
    private class Node<E> {

        private E data;  // tham chieu den gia tri(du lieu) cua node
        private Node<E> prev; // tham chieu den node dung truoc trong danh sach(thanh phan lien ket giua cac node thong qua viec chua dia chi cua node dung truoc)
        private Node<E> next;// tham chieu den node dung sau trong danh sach(thanh phan lien ket giua cac node thong qua viec chua dia chi cua node dung sau)

        public Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return data;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrev(Node<E> p) {
            prev = p;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    private Node<E> header;
    private Node<E> tralier;
    private int size = 0;

    // tao constructor voi danh sach rong
    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        tralier = new Node<>(null, header, null);
        header.setNext(tralier);
    }

    // tra ve so luong cac thanh phan trong danh sach
    public int size() {
        return size;
    }

    //tra ve list rong neu size = 0
    public boolean isEmpty() {
        return size == 0;
    }

    // tra ve node dau tien trong danh sach ma khong remove no 0(1)
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }
    
    // tra ve node cuoi cung trong danh sach ma khong remove no
    public E last() {
        if(isEmpty()) {
            return null;
        }
        return tralier.getPrev().getElement();
    }
    // them vao dau
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }
    
    // them vao cuoi
    public void addLast(E e) {
        addBetween(e, tralier.getPrev(), tralier);
    }
    
    //xoa element dau O(1)
    public E removeFirst() {
        if(isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }
    
    // xoa element cuoi 
    public E removeLast() {
        if(isEmpty()) {
            return null;
        }
        return remove(tralier.getPrev());
    }
    
    // them node moi vao danh sach lien ket giua 2 node da cho
    private void addBetween(E e, Node<E> p, Node<E> s) {
        Node<E> newNode = new Node<>(e, p, s);
        p.setNext(newNode);
        s.setPrev(newNode);
        size++;
    }
    
    private E remove(Node<E> node) {
        Node<E> p = node.getPrev();
        Node<E> s = node.getNext();
        p.setNext(s);
        s.setPrev(p);
        size--;
        return node.getElement();
    }
    
}

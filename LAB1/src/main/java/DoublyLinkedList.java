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
        private Node prev; // tham chieu den node dung truoc trong danh sach(thanh phan lien ket giua cac node thong qua viec chua dia chi cua node dung truoc)
        private Node next;// tham chieu den node dung sau trong danh sach(thanh phan lien ket giua cac node thong qua viec chua dia chi cua node dung sau)

        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        
        public E getElement() {
            return data;
        }
        
        public Node getPrev() {
            return prev;
        }
        
        public Node getNext() {
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
    
    
}

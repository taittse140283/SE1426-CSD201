/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

/**
 *
 * @author Admin
 */
public class DoublyLinkedList {
    // khai báo class Node
    private class Node{
        private int value; // tham chiếu giá trị lưu trữ trong nodde
        private Node next; // tham chiếu giá trị tiếp theo
        private Node prev; // tham chiếu giá trị sau đó
        public Node (int v, Node n, Node p) {
            this.value = v;
            this.next = n;
            this.prev = p;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
        
    }

    private 
   

}

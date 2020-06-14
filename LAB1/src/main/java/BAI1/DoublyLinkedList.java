/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BAI1;

/**
 *
 * @author Thuan Le
 */
public class DoublyLinkedList<User> {
    private static class Node<User>{
        private User element;
        private Node<User> next;
        private Node<User> prev;  

        public Node() {
        }

        public Node(User element, Node<User> next, Node<User> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        public User getElement() {
            return element;
        }

        public void setElement(User element) {
            this.element = element;
        }

        public Node<User> getNext() {
            return next;
        }

        public void setNext(Node<User> next) {
            this.next = next;
        }

        public Node<User> getPrev() {
            return prev;
        }

        public void setPrev(Node<User> prev) {
            this.prev = prev;
        }
        
    }
}    

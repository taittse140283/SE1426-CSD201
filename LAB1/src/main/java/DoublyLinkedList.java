/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author TrinhAnhTai
 */

/*
 * Create class doublyLinkedList to save Player
 * Its class contains some method: 
    - isEmpty: return size == 0, list empty
    - insertFirst: insert Player in top of list
    - insertLast: insert Player in last of list
    - getFirst: return Node on the top of list
    - getLast: return Node in last of list
    - removeFirst: delete Node on the top of list
    - removeLast:  delete Node in last of list
    - removeAtPos: delete Node at any position
    - addbetween: add new Node between two given nodes
    - get: return value of node at specific position
 */
public class DoublyLinkedList<E> {
    /**
     * Create inner class Node for doublyLinkedList
     *
     * @param <E>
     */
    private class Node<E> {
        private E value;
        private Node<E> next;
        private Node<E> prev;
        
        public Node (E value) {
            this.value = value;
        }
        //* Constructor of class Node */
        public Node (E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        
        public E getElement() {
            return value;
        }
        
        public Node<E> getNext() {
            return next;
        }
        
        public void setNext(Node<E> ne) {
            next = ne;
        }
        
        public Node<E> getPrev() {
            return prev;
        }
        
        public void setPrev(Node<E> pr) {
            prev = pr;
        }
    }   
    private Node<E> header;
    private Node<E> trailer;
    public int size = 0;
    //* Constructor of class DoublyLinkedList */
    public DoublyLinkedList() {
        size = 0;
        header = new Node(null, null, null); 
        trailer = new Node(null, header, null);
        header.next = trailer;
    }
    /*
     *Getter, Setter for Node header and trailer
     */
    public Node<E> getHeader() {
        return header.getNext();
    }

    public void setHeader(Node<E> header) {
        this.header = header;
    }

    public Node<E> getTrailer() {
        return trailer.getPrev();
    }

    public void setTrailer(Node<E> trailer) {
        this.trailer = trailer;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }

    
    public E getFirst() {
        if (isEmpty()) {
            return null;
        }
        return header.getNext().getElement();
    }

    
    public E getLast() {
        if (isEmpty()) {
            return null;
        }
        return trailer.getPrev().getElement();
    }

    
    public void addBetween(E e, Node<E> p, Node<E> s) {
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

    /*
      *input: value of object
     */
    public void insertFirst(E e) {
        addBetween(e, header, header.getNext());
    }

    /*
     *input: value of object
     */
    public void insertLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }

    
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(header.getNext());
    }

  
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        return remove(trailer.getPrev());
    }

    /*
     *input: Node location to delete
     */
    public void removeAtPosition(int n) {
        if (size == 0 || n < 0) { // If size=0, there is no method to remove, if pos<0 then it will index an error index
            return;
        }
        Node current = header.getNext(); 
        for (int i = 0; (current != null) && (i < n); i++) { // Browse position to find
            current = current.getNext();
        }
        if (current == null) {
            return;
        }
        remove(current);
    }

    /*
     * input:  Node location to find
     * output: Return value of Node
     */   
    public E get(int index) {
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

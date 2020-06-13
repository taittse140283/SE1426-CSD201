/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

/**
 *
 * @author truong
 */
public class DoublyLinkedList {

    //---------nested Node class---------
    private static class Node {

        private double point;//reference to the point at this node
        private String email;//reference to email at this node
        private Node next;//reference to the subsequent node in the list 
        private Node prev;//reference to the previous node in the list

        /**
         *
         * @param point
         * @param next_node
         * @param prev_mode
         */
        public Node(double point, String email, Node next_node, Node prev_mode) {
            this.point = point;
            this.email = email;
            this.next = next_node;
            this.prev = prev_mode;
        }

        public double getPoint() {
            return point;
        }

        public void setPoint(double point) {
            this.point = point;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }

    }//------end of nested Node class---------
    //instance variables of the DoublyLinkedList
    private Node header;//header sentinel
    private Node trailer;//trailer sentinel

    /**
     * COnstructs a new empty list
     */
    /**
     *
     */
    public DoublyLinkedList() {
        header = new Node(Double.MAX_VALUE, null, null, null);//create header
        trailer = new Node(Double.MIN_VALUE, null, null, header);//trailer is preceded by header
        header.next = trailer;//header is followed by trailer
    }

    private void insert(double point, String email, Node font, Node back) {
        Node new_node = new Node(point, email, back, font);
        font.next = new_node;
        back.prev = new_node;

    }
//    /**add the first point of the list*/
//    public void addFirst(double point){
//        insert(point,header,header.next);//place just after the header
//    }
//    /**add the last point of the list*/
//    public void addLast(double point){
//        insert(point,trailer.prev,trailer);//place just before the trailer
//    }

    public void add(Node n) {
        if (header == null) {
            header = n;
            trailer = n;

        } else {
            Node tam = header;
            while (tam.point > n.point) {
                tam = tam.next;
                if (tam.next == trailer) {
                    tam.next = n;
                    trailer = n;
                } else {
                    Node X = tam.prev;
                    tam.prev = n;
                    n.prev = X;
                    X.next = n;
                    n.next = tam;
                }

            }

        }
    }

    /*remove and return the Node*/
    private Node remove(Node n) {
        if (n != header && n != trailer) {
            Node font = n.prev;
            Node back = n.next;
            font.next = back;
            back.prev = font;
        }
        return n;
    }

    /*removes and return the first point of the list*/
    public double removeFirst() {
        return remove(header.prev).point;
    }

    /**
     * removes and return the last point of the list
     */
    public double removeLast() {
        return remove(trailer.prev).point;
    }
    public Node seachByEmail(String email){
        if(email.equals("")){
            System.out.println("can't found, please add email ");
            
        }else{
            Node font=header.getNext();
            do{
                if(font.getEmail().equalsIgnoreCase(email)){
                    return font;
                }else{
                    font=font.getNext();
                }
            }while(font!=trailer);
        }
        return null;
    }
    /**
     * print point
     */
    public void print() {
        for (Node n = header.next; n != trailer; n = n.next) {
            System.out.println(n.point);
        }
    }

}

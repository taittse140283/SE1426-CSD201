/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class DoubleLinkedList<Gamer> {
    //Create class Node

    private class Node {

        private Gamer data;
        private Node start;
        private Node end;
        //Create contructors 

        public Node(Gamer data, Node start, Node end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }

        // Create getter and setter
        public Gamer getData() {
            return data;
        }

        public void setData(Gamer data) {
            this.data = data;
        }

        public Node getStart() {
            return start;
        }

        public void setStart(Node start) {
            this.start = start;
        }

        public Node getEnd() {
            return end;
        }

        public void setEnd(Node end) {
            this.end = end;
        }

    }
    private Node header;
    private Node trailer;
    public int sizeOfList = 0;

    public DoubleLinkedList() {
        header = new Node(null, null, null);
        trailer = new Node(null,null,header);
        header.start= trailer;
    }

}

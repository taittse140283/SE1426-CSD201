public class DoubleLinkedList<E> {
    private class Node<E> {
        private E e;
        private Node<Node> prev;
        private Node<Node> next;

        public Node(E e, Node<Node> prev, Node<Node> next) {
            this.e = e;
            this.prev = prev;
            this.next = next;
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node<Node> getPrev() {
            return prev;
        }

        public void setPrev(Node<Node> prev) {
            this.prev = prev;
        }

        public Node<Node> getNext() {
            return next;
        }

        public void setNext(Node<Node> next) {
            this.next = next;
        }
    }

    private Node header;
    private Node trailer;
    private int size=0;

    //create a new empty list
    public DoubleLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

}





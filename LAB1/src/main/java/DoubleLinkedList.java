public class DoubleLinkedList<E> {
    private static class Node<E> {
        private E e;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> prev, Node<E> next) {
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

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size=0;

    //create a new empty list
    public DoubleLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(isEmpty()) return null;
        return header.getNext().getE();
    }

    public E last(){
        if(isEmpty()) return null;
        return trailer.getPrev().getE();
    }

    public void insert(E e, Node<E> prev, Node<E> next){
        Node<E> newnode = new Node<>(e,prev,next);
        prev.setNext(newnode);
        next.setPrev(newnode);
        size++;
    }

    public void addFirst(E e){
        insert(e, header, header.next);
    }

    public void addLast(E e){
        insert(e, trailer.prev, trailer);
    }

    private E remove(Node<E> node) {
        if(node != header && node != trailer) {
            Node<E> font = node.getPrev();
            Node<E> back = node.getNext();
            font.next = back;
            back.prev = font;
            size--;
        }
        return node.getE();
    }


    public E removeFirst(){
        return remove(header.getNext());
    }

    public E removeLast(){
        return remove(trailer.getPrev());
    }

    public E getElementNode(int post){
        return getNode(post).getE();
    }

    public Node<E> getNode(int post){
        Node<E> temp = header.next;
        for (int i= 0; i<post; i++){
            temp = temp.next;
        }
        return temp;
    }

    public void print(){
        for (Node<E> n  = header.next; n != trailer; n=n.next){
            System.out.println(n.getE() + " ");
        }
    }
}





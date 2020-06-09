/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

/**
 *
 * @author Thanh Trung
 */
public class Function <Player>{
    private class Node{
        private Player value;
        private Node next;
        public Node(Player value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;

    public Function() {
    }
    public Player gethead(){
        return head.value;
    }
     public void add(Player e){
        head  = new Node(e,head);
        tail = head.next == null ? head: tail;
        System.out.println("Added");
}
      public void print() {
        for(Node n = head; n != null; n=n.next)
            System.out.print(n.value + " ");
        System.out.print("\r\n");
    }
}

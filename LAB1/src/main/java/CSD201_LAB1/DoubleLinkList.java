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
public class DoubleLinkList {

    public static class node {

        node left = null;
        node right = null;
        private String email;
        private int point;

        public node(String email, int point) {
            this.email = email;
            this.point = point;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getPoint() {
            return point;
        }

        public void setPoint(int point) {
            this.point = point;
        }
    }
    public node head,tail;
    public node createNode(String email,int point){
        node newNode=new node(email, point);
        return newNode;
    }
    

}

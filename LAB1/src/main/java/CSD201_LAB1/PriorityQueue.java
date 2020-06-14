/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSD201_LAB1;

import CSD201_LAB1.DoubleLinkList.node;

/**
 *
 * @author truong
 */
public class PriorityQueue {
    DoubleLinkList list=new DoubleLinkList();
    public void add(String email,int point){
        node newNode=list.createNode(email, point);
        if(list.isEmpty()){
            list.head.right=newNode;
            newNode.left=list.head;
            newNode.right=list.tail;
            list.tail.left=newNode;
        }else{
            if(newNode.getPoint()<list.tail.left.getPoint())
            {
                list.tail.left.right=newNode;
                newNode.left=list.tail.left;
                newNode.right=list.tail;
                list.tail.left=newNode;
            }else if(newNode.getPoint()>list.head.right.getPoint()){
                list.head.right.left=newNode;
                newNode.right=list.head.right;
                newNode.left=list.head;
                list.head.right=newNode;
                
            }else{
                node currentNode=list.head.right;
                while(currentNode.getPoint()>=newNode.getPoint()){
                    currentNode=currentNode.right;
                }
                newNode.right=currentNode;
                newNode.left=currentNode.left;
                currentNode.left.right=newNode;
                currentNode.left=newNode;
            }
        }
        
    }
    public node SearchByEmail(String email){
        node currentNode=list.head.right;
        while(!(currentNode.getEmail().contentEquals(email))&&(currentNode!=list.tail)){
            currentNode=currentNode.right;
        }
        return currentNode;
    }
    
    
}

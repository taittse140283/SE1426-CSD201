/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai_2;

/**
 *
 * @author Linh
 * Hien thuc stack bang doubly linked list
 */
public class Stack {
    TagHTML head, tail;
    
    //Stack constructor
    //Khoi tao 2 gia tri ban dau head va tail la null khi chuong trinh duoc thuc thi
    public Stack() {
        head = tail = null;
    }
    
    //Them 1 phan tu vao trong stack
    public void push(String tag) {
        TagHTML t = new TagHTML(tag, head, tail);
        
        //Code nay se thuc thi khi stack chua co phan tu nao
        if(head == null) {
            head = t;
            head.prev = null;
            tail = t;
            tail.next = null;
            return;
        }
        
        //Code nay se thuc thi khi trong stack co it nhat 1 phan tu
        t.prev = tail;
        tail.next = t;
        tail = t;
        tail.next = null;
    }
    
    //Xoa 1 phan tu o tren cung` (tail)
    public void pop() {
        
        //Stack rong~ thi` se khong lam gi ca
        if(head == null)
            return;
        
        //Khi stack co dung' 1 phan tu thi` head va tail se tro ve null
        if(head == tail) {
            head = null;
            tail = null;
            return;
        }
        
        //Khi stack co nhieu hon 1 phan tu thi se~ doi` tail ve node truoc do
        tail = tail.prev;
        tail.next = null;
    }
    
    /**
     * @return tag html o tren cung (tail la node tren cung)
     */
    public String getTop() {
        return tail.tag;
    }
    
}

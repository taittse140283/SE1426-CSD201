/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tri
 */
public class Ex2 {

    static final int CAPACITY = 1000;
    private int a = -1;
    private String[] tag;

    public Ex2(String[] tag) {
        this.tag = new String[CAPACITY];
    }

    public int size() {
        return a + 1;
    }

    public boolean isEmpty() {
        return a == -1;
    }

    public void push(String html_Tag) {
        if (size() == tag.length) {
            System.out.println("Stack is full");
        } else {
            tag[++a] = html_Tag;
        }
    }

    public String top() {
        if (isEmpty()) {
            return null;
        }
        return tag[a];
    }
    public String pop() {
	if (isEmpty()) {
	    return null;
	}
	String htmlTag = tag[a];
	tag[a] = null; 
	a--;
	return htmlTag;
    }
}

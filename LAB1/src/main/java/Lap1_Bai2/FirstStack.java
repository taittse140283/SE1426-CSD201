/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai2;

/**
 *
 * @author hoang minh
 */
public class FirstStack {
    public static final int SizeArray = 1000;
    private String[] html;
    private int top = -1;
    
    public FirstStack(){
        html = new String[SizeArray];
    }
    
    public int size(){
        int size = top;
        return (size + 1);
    }
    
    public boolean isEmpty(){
        return size() < 0;
    }
    
    public void push(String tag){
        if(top == html.length){
            System.out.println("Out of stack");
        } else{
            top++;
            html[top] = tag;
        }
    }
    
    public String pop(){
        String tag;
        if(isEmpty()){
            return null;
        }
        tag = html[top];
        html[top] = null;
        if(top > -1){
            top--;
        }
        return tag;
    }
    
    public String top(){
        if(isEmpty()){
            return null;
        }
        return html[top];
    }
}

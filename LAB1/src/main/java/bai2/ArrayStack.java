/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

/**
 *
 * @author Admin
 */

/**
 *ArrayStack class--stack contains list of tags
 */
public class ArrayStack implements Stack{

    private String[] list;//list of tags
    int count;//size of list
    private static final int capacity=500;//capacity of array

    /**
     * Default constructor for ArrayStack
     */
    public ArrayStack() {
        list=new String[capacity];//allocated a array of String has 500 element
        count=0;//default index of last element in the list

    }

    /**
     * Push new tag into last position of the list
     * @param tag This is tag will be added to the arraystack
     * @return nothing
     */
    @Override
    public void push(String tag) {
        if(count>capacity)//if over capacity of the list
        {
            System.out.println("Error:Stack over flow");
            return;
        }
        else
        {
            list[count]=tag;//insert new tag into last position
            count++;//increasing size
        }

    }

    /**
     * Pop tag in last position(delete)
     * @return tag in last position
     */

    @Override
    public String pop() {
        if(count==0)//if list is empty
        {
            System.out.println("Error: There's nothing in stack");
        }
        else
        {
            return list[count--];//no need to clear the last element, cause will have another element replace it

        }
        return null;
    }
    

    @Override
    public String top() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void print() {
    }
    
}

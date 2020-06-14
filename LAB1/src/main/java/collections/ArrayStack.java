/**
 *
 * @author SE140834
 */
package collections;

public class ArrayStack<E> {
    public static final int CAPACITY = 10000; 
    private E[] data;
    private int t = -1;
    /**
     * @Constructor
     */
    public ArrayStack() { this(CAPACITY); }
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    /**
     * @return size of Array Stack
     */
    public int size() { return t + 1; }
    /**
     * @return check if array is empty or not
     */
    public boolean isEmpty() { return t == -1; }
    /**
     * @function push on top one element
     */
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full!");
        data[++t] = e;
    }
    /**
     * @return top element but not remove
     */
    public E top() {
        if (isEmpty()) return null;
        return data[t];
    }
    /**
     * @return top element and remove
     */
    public E pop() {
        if (isEmpty()) return null;
        E result = data[t];
        data[t] = null;
        t--;
        return result;
    }
} 
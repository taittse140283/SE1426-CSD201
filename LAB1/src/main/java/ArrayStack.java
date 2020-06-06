public class ArrayStack<E> implements Stack<E> {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int top = -1;
    public ArrayStack(){
        this(CAPACITY);
    }

    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }


    @Override
    public void push(E e) throws IllegalStateException{
        if (size()==data.length) throw new IllegalStateException("Stack full");
        data[++top] = e;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = data[top];
        data[top] = null;
        top--;
        return answer;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return data[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return (top + 1);
    }

    @Override
    public void print() {
        for (int i = top ; i >=0 ; i--) {
            System.out.println(data[i] + "\n");
        }
    }
}

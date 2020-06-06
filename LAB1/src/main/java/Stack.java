public interface Stack<E> {
    void push(E e);
    E pop();
    E top();
    boolean isEmpty();
    int size();
    void print();
}

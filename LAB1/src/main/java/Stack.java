public interface Stack<E> {
    void push(E info);
    E pop();
    E top();
    boolean isEmpty();
    int size();
    void print();
}

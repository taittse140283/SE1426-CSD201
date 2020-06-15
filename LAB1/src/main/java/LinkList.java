/**
 * <h1> LinkList </h1>
 * The interface class used to contain function
 *
 * @author Bach Duy Hoang
 * @since 2020/6/1
 */

public interface LinkList {
    void removeMax();

    void findMax();

    void insert(Entry e);

    void remove(String mail);

    void find(String mail);

    void update(String mail, long new_point);
}

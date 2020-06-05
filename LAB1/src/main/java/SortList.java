import org.w3c.dom.Node;

public class SortList implements LinkList{
    private DoubleLinkedList<Entry> dbl = new DoubleLinkedList<>();

    @Override
    public void removeMax() {

    }

    @Override
    public void findMax() {

    }

    //parameter is Object, function find post to insert new node
    @Override
    public void insert(Entry e) {
        int rank = e.getRank();
        int size = dbl.size();
        if(size == 0){
            dbl.addFirst(e);
        }else{
            for (int i = size - 1; i >= 0 ; i--) {
                if (rank<= dbl.getElementNode(i).getRank()){
//                    Node<E> new_node = new Node<E>(e,dbl.getNode(i-1),dbl.getNode(i));
//
                    dbl.insert(e,dbl.getNode(i-1),dbl.getNode(i));
                }
            }
        }

    }

    @Override
    public void remove(String mail) {

    }

    @Override
    public void find(String mail) {

    }

    @Override
    public void update(String mail) {

    }
}



public class SortList implements LinkList {
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
        if (size == 0) {
            dbl.addFirst(e);
        }else {
            if (rank > dbl.last().getRank()) {
                dbl.addLast(e);
            } else if(rank <= dbl.first().getRank()){
                dbl.addFirst(e);
            }else {
                for (int i = 0 ; i < size; i++) {
                    if (rank <= dbl.getElementNode(i).getRank()) {
                        dbl.insert(e, dbl.getNode(i-1), dbl.getNode(i));
                        return;
                    }
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

    public void print(){
        dbl.print();
    }
}

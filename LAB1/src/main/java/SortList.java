import java.io.IOException;
import java.util.Scanner;

public class SortList implements LinkList {
    private DoubleLinkedList<Entry> dbl = new DoubleLinkedList<>();
    Scanner sc = new Scanner(System.in);
    @Override
    public void removeMax() {
        dbl.removeLast();
    }

    @Override
    public void findMax() {
        System.out.println("Max: " + dbl.last());
    }

    /*This method use to find post to insert new value
    and sort. parameter is Object.
     */
    @Override
    public void insert(Entry e) {
        int rank = e.getRank();
        int size = dbl.size();
        if (size == 0) {
            dbl.addFirst(e);
        } else {
            if (rank > dbl.last().getRank()) {
                dbl.addLast(e);
            } else if (rank <= dbl.first().getRank()) {
                dbl.addFirst(e);
            } else {
                for (int i = 0; i < size; i++) {
                    if (rank <= dbl.getElementNode(i).getRank()) {
                        dbl.insert(e, dbl.getNode(i - 1), dbl.getNode(i));
                        return;
                    }
                }
            }

        }
    }


    /*This method will delete info of player's email
    Parameter is email of player. If email is not exist,
    method will show a msg to warning
     */
    @Override
    public void remove(String mail) {
        int size = dbl.size();
        for (int i = 0; i < size; i++) {
            if (mail.equals(dbl.getElementNode(i).getInfo())) {
                dbl.removeNode(dbl.getNode(i));
                return;
            }
        }
        System.out.println("Data is not exist");
    }

    /*This method will find info of player
    Parameter is email of player. If email is not exist,
    method will show a msg to warning
     */
    @Override
    public void find(String mail) {
        int size = dbl.size();
        for (int i = 0; i < size; i++) {
            if (mail.equals(dbl.getElementNode(i).getInfo())) {
                System.out.println("Info:\n" + dbl.getElementNode(i));
                return;
            }
        }
        System.out.println("Data is not exist");
    }


    /*This method will update point of player
    Parameter is email of player. If email is not exist,
    method will show a msg to warning
     */
    @Override
    public void update(String mail) {
        String new_email;
        int size = dbl.size();
        for (int i = 0; i < size; i++) {
            if (mail.equals(dbl.getElementNode(i).getInfo())) {
                System.out.println("Enter Email to update: ");
                new_email = sc.nextLine();
                dbl.getElementNode(i).setInfo(new_email);
                System.out.println("Successfully!");
                return;
            }
        }
        System.out.println("Data is not exist");
    }

    public void print() {
        dbl.print();
    }

    public void printtoFile(String Filename) throws IOException {
        dbl.printtoFile(Filename);
    }
}

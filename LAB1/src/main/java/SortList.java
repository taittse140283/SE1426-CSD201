import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
<h1> SortList <h1>
implements LinkList. Using double linked list and sorted priority queue
@author Bach Duy Hoang
@since 2020/6/1
 */
public class SortList implements LinkList {
    private DoubleLinkedList<Entry> dbl = new DoubleLinkedList<>();
    Scanner sc = new Scanner(System.in);

    /*
    This method used to remove node have max value
     */
    @Override
    public void removeMax() {
        dbl.removeLast();
    }

    /*
    This method used to find max value of node in list
     */
    @Override
    public void findMax() {
        System.out.println("Max: " + dbl.last());
    }

    /*
    This method use to find post to insert new value
    and sort. if list is empty insert to first. if rank of
    Entry is bigger than max value of list then add to last of list.
    If rank of Entry is smaller or equal than min value of list then
    add to first of list. Else find post to insert value and insert.
    @param e This values wants to insert.
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


    /*
    This method will delete info of player's email
    .If email is not exist, method will show a msg
    to warning. Else delete player.
    @param mail Remove player base on mail.
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

    /*
    This method will find info of player. If email is not exist,
    method will show a msg to warning. Else print mail and point of player
    @param mail Email of player.
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


    /*
    This method will update point of player. If email is not exist,
    method will show a msg to warning. Else update info of player
    @param mail email of player.
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
    /*
    Print list
     */
    public void print() {
        dbl.print();
    }

    /*
    This method used to print value of node in list to file
    @param file name of file that wants to write to
     */
    public void printtoFile(String Filename) throws IOException {
        dbl.printtoFile(Filename);
    }

}

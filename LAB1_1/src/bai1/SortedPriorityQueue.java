package bai1;
/**
 * Class SortedPriorityQueue contains sorted list of DLLNode<Player>
 *     Field:DoublyLinkedList<Player> list
 */
public class SortedPriorityQueue {
    private DoublyLinkedList<Player> list = new DoublyLinkedList();

    public DoublyLinkedList<Player> getList() {
        return list;
    }

    public void setList(DoublyLinkedList<Player> list) {
        this.list = list;
    }

    /**
     *This method add new node into queue which sort by point of Player(high to low)
     *If size of list =0, then set header and trailer are newest
     *If if point of Player in newest Node greater than point of Player in header Node
     *then add it at first position of the list
     * If point of Player in newest Node lower than point of Player in trailer Node
     * then add it at last position of the list
     * Another case, then traverse the list to find right position
     * @param newest
     */
    public void add(DDLNode<Player> newest) {
        if (list.getSize() == 0) {
            list.setHeader(newest);
            list.setTrailer(newest);
            list.setSize(list.getSize() + 1);
        } else {
            //The header has the greatest point of Player 
            if (newest.getInfo().getPoint() > list.getHeader().getInfo().getPoint())//compare with header, 
            //if point of Player in newest Node greater than point of Player in header Node
            //then add it at first position of the list
            {
                list.addFirst(newest);
            } //The trailer has the lowest point of Player
            else if (newest.getInfo().getPoint() <= list.getTrailer().getInfo().getPoint())//compare with trailer
            //if point of Player in newest Node lower than point of Player in trailer Node
            //then add it at last position of the list
            {
                list.addLast(newest);
            } else {
                DDLNode<Player> temp = list.getHeader();
                //find the position can insert new node
                while (temp.getInfo().getPoint()>=newest.getInfo().getPoint()) {
                    temp = temp.getNext();
                }
                //new node is inserted in front of temp
                newest.setNext(temp);
                newest.setPrev(temp.getPrev());
                temp.getPrev().setNext(newest);
                temp.setPrev(newest);
                list.setSize(list.getSize() + 1);
            }
        }
    }

    /**
     * This method removes Player has highest point in the list(use removeFirst() method of DoublyLinkedList)
     *
     * @return Player be removed
     */
    public Player removeMax() {
        return list.removeFirst();
    }

    /**
     * Get Player has highest point in the list(use getHeaderInfo() method of DoublyLinkedList)
     *
     * @return Player has highest point in the list
     */
    public Player getMax() {
        return list.getHeaderInfo();
    }

    /**
     * Get the node in the list has the same email with parameter email
     *
     * @param email This is email need to find in the list
     * @return node in the list has the same email with parameter email, if
     * can't find, return null
     */
    public DDLNode<Player> getNode(String email) {
        DDLNode<Player> temp = list.getHeader();//get header
        while (temp != null&&!temp.getInfo().getEmail().equals(email))//traverse the list to find Node has the same email
        {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * Update player has the same email with parameter email
     *
     * @param email This is email need to find in the list
     * if can't find the DLLNode need to update, error
     * if can find, then update the point of Player, then clone this updateNode, delete updateNode in old place
     *and add clone of updateNode into the list at right position
     */
    public void updatePlayer(String email, String point) {
        DDLNode<Player> updatePlayer = getNode(email);//get player has the same email
        if (updatePlayer != null) {//if found
            //Update point of found player
            try {
                if (Long.parseLong(point) < 0) {
                    throw new Exception("Error:Must>0");
                }
                updatePlayer.getInfo().setPoint(Long.parseLong(point));
                //clone update node
                DDLNode<Player> tempUpdate = null;
                try {
                    tempUpdate = updatePlayer.clone();
                } catch (CloneNotSupportedException e) {
                    System.out.println(e);
                }
                //delete update node in old position
                deletePlayer(email);
                //Link clone update node with right position
                add(tempUpdate);
            } catch (NumberFormatException e) {
                System.out.println("Error:Must be integer");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Error:Not found player");
        }
    }

    /**
     * Delete player has the same email with parameter email
     *
     * @param email This is email need to find in the list
     *if can't find, print error
     *if can find, delete the node
     */
    public void deletePlayer(String email) {
        DDLNode<Player> deletePlayer = getNode(email);
        if (deletePlayer != null) {
            if(deletePlayer==list.getHeader())
            {
                list.removeFirst();
            }
            else if(deletePlayer==list.getTrailer())
            {
                list.removeLast();
            }
            else {
                list.remove(deletePlayer);
            }
        } else {
            System.out.println("Error:Not found player");
        }
    }
}

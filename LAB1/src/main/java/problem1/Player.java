/**
 *
 * @author SE140834
 */
package problem1;

public class Player implements Comparable<Player> {
    private String email;
    private long point;
     /**
     * @Constructor
     */
    public Player() {
    }
    
    public Player(String email, long point) {
        this.email = email;
        this.point = point;
    }
    /**
     * @Getter and Setter
     */
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPoint() {
        return this.point;
    }

    public void setPoint(long point) {
        this.point = point;
    }
     /**
     * @Override toString()
     */
    @Override
    public String toString() {
        return this.email + ", " + this.point;
    }
     /**
     * @Override compareTo()
     */
    @Override
    public int compareTo(Player player) {
        int result = 0;
        if (this.point > player.point) result = 1;
        else if (this.point < player.point) result = -1;
        return result;
    }
}

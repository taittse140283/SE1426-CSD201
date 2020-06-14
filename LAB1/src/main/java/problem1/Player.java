package problem1;

/**
 *
 * @author SE140834
 */
public class Player implements Comparable<Player> {
    private String email;
    private long point;
    
    public Player() {
    }
    
    public Player(String email, long point) {
        this.email = email;
        this.point = point;
    }

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
    
    @Override
    public String toString() {
        return this.email + ", " + this.point;
    }

    @Override
    public int compareTo(Player player) {
        int result = 0;
        if (this.point > player.point) result = 1;
        else if (this.point < player.point) result = -1;
        return result;
    }
}

package problem1;

/**
 *
 * @author SE140834
 */
public class Player implements Comparable<Player> {
    String email;
    long point;

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
    public int compareTo(Player player) {
        int result = 0;
        if (this.point > player.point) result = 1;
        else if (this.point < player.point) result = 0;
        return result;
    }
}

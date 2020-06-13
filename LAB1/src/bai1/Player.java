package bai1;

/**
 *
 * @author Admin
 */
/**
 Class Player stores information of player include email and point
 Fields: String email, int point
 */
public class Player {
    //Contain constructor, getter, setter and override toString()methods to get output be like: email,point;
    private String email;
    private int point;

    /**
     * Constructor, getter, setter
     */
    public Player() {
        email="";
        point=0;
    }


    public Player(String email, int point) {
        this.email = email;
        this.point = point;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * Override toString method
     * @return String that format like "Email, Point"
     */
    @Override
    public String toString() {
        return email+", "+point;
    }


}

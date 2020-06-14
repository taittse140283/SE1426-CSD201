
public class Gamer {
//    Khai báo thuộc tính 
//    Các constructor và phương thức getter,setter

    Comparable point;
    String email;
    Gamer next;
    Gamer previous;

    public Gamer(Comparable point, String email) {
        this.point = point;
        this.email = email;
        next = previous = null;
    }

    public Comparable getPoint() {
        return point;
    }

    public Gamer getNext() {
        return next;
    }

    public Gamer getPrevious() {
        return previous;
    }

    public void setPoint(Comparable point) {
        if (point != null) {
            this.point = point;
        }
    }

    public void setNext(Gamer next) {
        if (next != null) {
            this.next = next;
        }
    }

    public void setPrevious(Gamer previous) {
        if (previous != null) {
            this.previous = previous;
        }
    }

    @Override
    public String toString() {
        return email + " - " + point;
    }

}

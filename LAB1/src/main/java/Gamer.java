
public class Gamer {
//    Khai báo thuộc tính 
//    Các constructor và phương thức getter,setter
    private String email;
    private double ponit;

    public Gamer() {
    }

    public Gamer(String email, double ponit) {
        this.email = email;
        this.ponit = ponit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getPonit() {
        return ponit;
    }

    public void setPonit(double ponit) {
        this.ponit = ponit;
    }
    
    
    
}

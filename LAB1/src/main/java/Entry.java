public class Entry {
    private int rank;
    private String info;

    public Entry(int rank, String info) {
        this.rank = rank;
        this.info = info;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String toString(){
        return "Point: "+rank + "\tEmail: " + info;
    }
}

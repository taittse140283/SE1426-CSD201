public class Entry {
    private long rank;
    private String info;

    public Entry() {
    }

    public Entry(long rank, String info) {
        this.rank = rank;
        this.info = info;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String toString(){
        return info + ", " + rank;
    }
}

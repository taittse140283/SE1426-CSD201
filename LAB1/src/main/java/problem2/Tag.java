package problem2;

/**
 *
 * @author SE140834
 */
public class Tag implements Comparable<Tag> {
    private String name;
    private long frequency;
    
    public Tag() {
    }
    
    public Tag(String name, long frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getFrequency() {
        return this.frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }
    
    @Override
    public String toString() {
        return this.name + ", " + this.frequency;
    }

    @Override
    public int compareTo(Tag tag) {
        int result = 0;
        if (this.frequency > tag.frequency) result = -1;
        else if (this.frequency < tag.frequency) result = 1;
        return result;
    }
}

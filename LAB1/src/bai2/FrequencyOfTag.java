package bai2;

import java.util.*;

/**
 * Class FrequencyOfTag
 * Field: HashMap<String, Integer> frequencyOfTag
 * Create class to can get and compare frequency of Tag
 */
public class FrequencyOfTag{
    HashMap<String, Integer> frequencyOfTag;
    public FrequencyOfTag()
    {
        frequencyOfTag=new HashMap<>();
    }

    public HashMap<String, Integer> getFrequencyOfTag() {
        return frequencyOfTag;
    }

    public void setFrequencyOfTag(HashMap<String, Integer> frequencyOfTag) {
        this.frequencyOfTag = frequencyOfTag;
    }

    /**
     * Count frequency of tag
     * @param tag This is tag will be check if contain in hashmap or not
     * If not contain, then set value of this key Tag equals 1
     * If contain, then get the old value of this key Tag and add 1 into it
     */
    public void countOfTag(String tag)
    {
        if(!frequencyOfTag.containsKey(tag))//if tag is not one of key of this HashMap
        {
            frequencyOfTag.put(tag,1);//set value of it equals 1(cause appear first time)
        }
        else//if tag is one of key of this HashMap
        {
            frequencyOfTag.put(tag, frequencyOfTag.get(tag)+1);//set value of it equals past frequency plus 1(cause appear again)
        }
    }
    //test sort, do not comment clearly yet
    public  void sortHashMap()
    {
        //Get Entry Set of Hash Map and put it into ArrayList listEntry
        ArrayList<Map.Entry<String,Integer>> listEntry = new ArrayList(frequencyOfTag.entrySet());
        //Call method sort of class Collections
        //Create anonymous Comparator class(use one time) to compare value of entry
        Collections.sort(listEntry, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1,
                               Map.Entry<String, Integer> e2) {
                if(e1.getValue()<e2.getValue()) return 1;//frequency of e2.key higher than e1.key then swap two entry
                else if(e1.getValue()>e2.getValue()) return -1;//
                return 0;
            }
        });
        frequencyOfTag = new LinkedHashMap();
        for (Map.Entry<String,Integer> entry:listEntry)
        {
            frequencyOfTag.put(entry.getKey(),entry.getValue());
        }
    }

}

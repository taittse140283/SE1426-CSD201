package bai2;

import java.util.HashMap;

/**
 * Class FrequencyOfTag
 * Field: HashMap<String, Integer> frequencyOfTag
 * Create class to can compare frequency of Tag(override compareTo() method of HashMap)
 */
public class FrequencyOfTag {
    HashMap<String, Integer> frequencyOfTag;
    public FrequencyOfTag()
    {
        frequencyOfTag=new HashMap<>();
    }

    /**
     * Count frequency of tag
     * @param tag This is tag will be check if contain in hashmap or not
     * If not contain, then set value of this key Tag equals 1
     * If contain, then get the old value of this key Tag and add 1 into it
     */
    public void getFrequencyOfTag(String tag)
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


}

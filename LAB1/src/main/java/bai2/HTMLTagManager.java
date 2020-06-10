package bai2;

import java.util.HashMap;

public class HTMLTagManager {
    ArrayStack stack=new ArrayStack();
    public HashMap<String, Integer> countFrequencyOfTag(HashMap<String, Integer> frequencyOfTag, String tag){
        if(!frequencyOfTag.containsKey(tag))
        {
            frequencyOfTag.put(tag,1);
        }
        else
        {
            frequencyOfTag.put(tag, frequencyOfTag.get(tag)+1);
        }
        return frequencyOfTag;
    }
    public void getHTMLTag(/*String link*/)
    {
        String html=ContentWebsite.getContentOnWebsite("https://tuoitre.vn/");
        HashMap<String, Integer> frequencyOfTag=new HashMap<>();
        //Check for normal tag
        int j = html.indexOf('<'); // find first ’<’ character (if any)
        while (j!=(-1)) {
            int k = html.indexOf('>', j+1); // find next ’>’ character
            if (k ==(-1))
                //invalid tag
            {
               System.out.println("Error: Mismatch HTML tag");
                return;

          }
            String tag = html.substring(j, k+1);
            if (!tag.startsWith("</")) // this is an opening tag
            {
                if(!tag.contains(" ")&&!html.contains(tag.replace("<","</")))//check for unpaired tag like <br>
                {
                    if(!tag.matches("<[A-Za-z0-9!]+>"))
                    {
                        j = html.indexOf('<', k+1);
                        continue;
                    }
                    frequencyOfTag = this.countFrequencyOfTag(frequencyOfTag, tag);

                }
                else if (tag.contains(" ")) {
                    String[] validTag = tag.split(" ",2);//spit into 2 string like <tag and abcxyz>
                    tag = validTag[0] + validTag[1].substring(validTag[1].length() - 1, validTag[1].length());//concat string to it like <tag>
                    if(!tag.matches("<[A-Za-z0-9!]+>"))
                    {
                        j = html.indexOf('<', k+1);
                        continue;
                    }
                    if (!html.contains(tag.replace("<","</"))) {//check for unpaired tag like img
                        //just for debug so it's empty
                        frequencyOfTag=this.countFrequencyOfTag(frequencyOfTag,tag);

                    } else {
                        if(tag.equals("<script>"))
                        {
                            frequencyOfTag=this.countFrequencyOfTag(frequencyOfTag,tag);
                        }
                        else stack.push(tag);
                   }
                } else {//for some tag like <p>abcxyz<p>
                    if(tag.equals("<script>"))
                    {
                        frequencyOfTag=this.countFrequencyOfTag(frequencyOfTag,tag);
                    }
                    else stack.push(tag);
                }
            }

            else { // this is a closing tag
                if(!tag.equals("</script>"))
                {
                String checkTag=stack.pop();
              frequencyOfTag=this.countFrequencyOfTag(frequencyOfTag,tag.replace("</","<"));}
            }
            j = html.indexOf('<', k+1); // find next ’<’ character (if any)
        }
        frequencyOfTag=FrequencyOfTag.sortHashMap(frequencyOfTag);
        CSV.writeFile("output.csv", frequencyOfTag);

    }

}

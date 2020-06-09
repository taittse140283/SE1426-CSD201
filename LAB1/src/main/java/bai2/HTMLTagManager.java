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
        String html=ContentWebsite.getContentOnWebsite("https://vnexpress.net/");
        HashMap<String, Integer> frequencyOfTag=new HashMap<>();
        /*String html="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "	<meta charset=\"UTF-8\">\n" +
                "	<title>Photo Gallery</title>\n" +
                "	<link rel=\"stylesheet\" href=\"CSS\\gallery.css\">\n" +
                "	<script src = \"js/gallery.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "	\n" +
                "	<div id = \"image\">\n" +
                "		Hover over an image below to display here.\n" +
                "	</div>\n" +
                "	\n" +
                "	<img class = \"preview\" alt = \"Styling with a Bandana\" src = \"https://s3-us-west-2.amazonaws.com/s.cdpn.io/389177/bacon.jpg\" onmouseover = \"upDate(this)\" onmouseout = \"unDo()\">\n" +
                "	\n" +
                "	<img class = \"preview\" alt = \"With My Boy\" src = \"https://s3-us-west-2.amazonaws.com/s.cdpn.io/389177/bacon2.JPG\" onmouseover = \"upDate(this)\" onmouseout = \"unDo()\">\n" +
                "	\n" +
                "	<img class = \"preview\" src = \"https://s3-us-west-2.amazonaws.com/s.cdpn.io/389177/bacon3.jpg\" alt = \"Young Puppy\" onmouseover = \"upDate(this)\" onmouseout = \"unDo()\">\n" +
                "\n" +
                "</body>\n" +
                "</html>";*/
        //Check for normal tag
        int j = html.indexOf('<'); // find first ’<’ character (if any)
        while (j!=(-1)) {
            int k = html.indexOf('>', j+1); // find next ’>’ character
            //if (k ==(-1))
                //invalid tag
            //{
               // System.out.println("Error: Mismatch HTML tag");
                //return;

          // }
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
                        stack.push(tag);
                   }
                } else {//for some tag like <p>abcxyz<p>
                    stack.push(tag);
                }
            }

            else { // this is a closing tag
                //if (stack.isEmpty())
                     // no tag to match
                //{
                   // System.out.println("Error: Mismatch HTML tag");
                    //return;
                //}
                String checkTag=stack.pop();
                if (!tag.replace("</","<").equals(checkTag))
                {
                     // mismatched tag
                    //System.out.println("Error: Mismatch HTML tag");
                    //return;
                 }
                else
                {
                    //just for debug so it's empty
                    frequencyOfTag=this.countFrequencyOfTag(frequencyOfTag,tag.replace("</","<"));
                }

            }
            j = html.indexOf('<', k+1); // find next ’<’ character (if any)
        }
        frequencyOfTag=FrequencyOfTag.sortHashMap(frequencyOfTag);
        CSV.writeFile("output.csv", frequencyOfTag);

    }

}

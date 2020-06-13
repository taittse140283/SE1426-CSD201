package bai2;

import java.util.HashMap;

public class HTMLTagManager {
    ArrayStack stack=new ArrayStack();

    /**
     * Processing tag, Count frequency of Tag
     * @param link This is URL to get content of website want to count frequency of tag
     * @return HashMap<String, Interger> with key is tag và value is frequency of tag
     */
    private HashMap<String,Integer> countHTMLTag(String link)
    {
        String html=ContentWebsite.getContentOnWebsite(link);
        FrequencyOfTag frequency=new FrequencyOfTag();
        if(!html.equals("")) {
            int j = html.indexOf('<'); // find first ’<’ character (if any)
            while (j != (-1)) {
                int k = html.indexOf('>', j + 1); // find next ’>’ character
                String tag = html.substring(j, k + 1);
                if (!tag.startsWith("</")) // this is an opening tag
                {
                    if (!tag.contains(" ") && !html.contains(tag.replace("<", "</")))//check for unpaired tag like <br>
                    {
                        if (!tag.matches("<[A-Za-z0-9!]+>"))//if tag contains special character except ! then pass it and continue the loop
                        {
                            j = html.indexOf('<', k + 1);
                            continue;
                        }
                        //if not, then count this tag
                        frequency.countOfTag(tag);

                    } else if (tag.contains(" ")) {
                        String[] validTag = tag.split(" ", 2);//spit into 2 string like <tag and abcxyz>
                        tag = validTag[0] + ">";//concat string to it like <tag>
                        if (!tag.matches("<[A-Za-z0-9!]+>"))//if tag contains special character except ! then pass it and continue the loop
                        {
                            j = html.indexOf('<', k + 1);
                            continue;
                        }
                        //if not
                        if (!html.contains(tag.replace("<", "</"))) {//check for unpaired tag like img
                            frequency.countOfTag(tag);

                        } else {
                            if (tag.equals("<script>"))//script tag has some problem so it's treated specially
                            {
                                frequency.countOfTag(tag);
                            } else stack.push(tag);
                        }
                    } else {//for some tag like <p>abcxyz<p>
                        if (tag.equals("<script>")) {
                            frequency.countOfTag(tag);
                        } else stack.push(tag);
                    }
                } else { // this is a closing tag
                    if (!tag.equals("</script>"))//cause in above not push script into stack
                    {
                        String checkTag = stack.pop();
                        frequency.countOfTag(tag.replace("</", "<"));
                    }
                }
                j = html.indexOf('<', k + 1); // find next ’<’ character (if any)
            }
            frequency.sortHashMap();
        }
        else
        {
            System.out.println("Error: There's something wrong when load URL");
        }
        return frequency.getFrequencyOfTag();
    }

    /**
     * Parsing arguments for CLI for problem 2
     * @param args This is list of arguments will be parsed
     */
    public void parsingArguments(String[] args)
    {
        if(args.length==2)
        {
            HashMap<String,Integer> frequencyOfTag=countHTMLTag(args[0]);
            CSV.writeFile(args[1],frequencyOfTag);
            System.out.println("Check your output file!!!");
        }
        else
        {
            System.out.println("Error:Not enough/over arguments");
        }

    }
}

package bai2;

public class HTMLTagManager {
    ArrayStack stack=new ArrayStack();
    public void getHTMLTag(String link)
    {
        String html=ContentWebsite.getContentOnWebsite(link);
        int j = html.indexOf('<'); // find first ’<’ character (if any)
        while (j!=(-1)) {
            int k = html.indexOf('>', j+1); // find next ’>’ character
            if (k ==(-1))
            // invalid tag
            {

            }
            String tag = html.substring(j+1, k);
            if (!tag.startsWith("/")) // this is an opening tag
                if(tag.contains(" ")) {
                    String[] validTag = tag.split(" ");
                    stack.push(validTag[0]);
                }
                 else {
                    stack.push(tag);
                }

            else { // this is a closing tag
                if (buffer.isEmpty( ))
                     // no tag to match
                if (!tag.substring(1).equals(buffer.pop( )))
                     // mismatched tag
                 }
            j = html.indexOf('<', k+1); // find next ’<’ character (if any)
            }
        return buffer.isEmpty( ); // were all opening tags matched?
        }
    }

}

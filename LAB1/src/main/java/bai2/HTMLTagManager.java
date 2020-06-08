package bai2;

public class HTMLTagManager {
    ArrayStack stack=new ArrayStack();
    public void getHTMLTag(String link)
    {
        //String html=ContentWebsite.getContentOnWebsite(link);
        String html="<!DOCTYPE html>\n" +
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
                "</html>";
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
                if (stack.isEmpty())
                     // no tag to match
                {
                    System.out.println("Error: Mismatch HTML tag");
                    return;
                }
                String checkTag=stack.pop();
                if (!tag.substring(1).equals(checkTag))
                {
                     // mismatched tag
                    System.out.println("Error: Mismatch HTML tag");
                 }
                else
                {

                }
            j = html.indexOf('<', k+1); // find next ’<’ character (if any)
            }
        //return stack.isEmpty( ); // were all opening tags matched?
        }
    }

}

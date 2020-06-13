package bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ContentWebsite {
    /**
     * This method gets content(HTML commands and textual content) of Website(by its URL)
     * @param link This is URL of the website
     * @return content of Website
     */
    public static String getContentOnWebsite(String link)
    {
        String content="";
        URL url=null;
        InputStreamReader isr=null;
        BufferedReader br=null;

        try {
            url = new URL(link);//create a url object from link
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            if(http.getResponseCode()==200)//standard success response code
            {
                isr=new InputStreamReader(url.openStream());//openStream() method get a stream from which you can read the contents of the URL
                br=new BufferedReader(isr);//create buffer to get content of isr
                while(br.ready())//check EOF
                {
                    String s=br.readLine();//read line
                    content+=s+"\n";//concat string
                }
            }
            else
            {
                System.out.println("Error: Your url is not responded successfully");
            }


        } catch(MalformedURLException e)
        {
            System.out.println("Error: URL is not valid");
        }
        catch(IOException e)
        {
            System.out.println("Error: There's something wrong in file process");
        }
        catch (Exception e)
        {
            System.out.println("Error: Something's wrong");
        }
        finally {

            try {
                if(br!=null) br.close();
            }
            catch(Exception e)
            {
                System.out.println("Error: Something's wrong");
            }
        }
        return content;

    }
}

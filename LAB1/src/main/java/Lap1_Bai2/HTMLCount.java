/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.MalformedURLException;

/**
 *
 * @author PC
 */
public class HTMLCount {
    static DoWithFile file = new DoWithFile();
    FirstStack tagStack = new FirstStack(500);
    
    private boolean compareTag(String tag, String tagStack){
        tag = tag.replace("/", "");
        return tag.equals(tagStack);
    }
    /**
     * Hàm dùng để so sánh các tag đầu vào và các tag trong stack
     * @param tag
     * @param tagStack
     * @return true nếu tag đó là tag đóng
     */
    
    private String convertTag(String tag){
        String[] splitSpace = tag.split(" ");
        if(splitSpace.length == 1){
            return tag;
        } else{
            String normalTag = splitSpace[0] + '>';
	    return normalTag;
	}
    }
    /**
     * Có 1 vài tag đặc biệt có thẻ mở mà không có thẻ đóng, nên phải chuyển chúng thành tag bình thường 
     * @return tag bình thường
     */
    
    private boolean alongTag(String tag, String htmlBody) {
            String closeTag = tag.replace("<", "</");
            return !htmlBody.contains(closeTag);
    }
    /**
     * Chuyển đổi tag đặc biệt như <br>, </br> 
     * @param tag
     * @return closeTag
     */
    
    private void analysisHTML(String htmlBody) {
	String tag = "";
	boolean validTag = false;
	for (int i = 0; i < htmlBody.length(); i++) {
	    if (htmlBody.charAt(i) == '<') {
		tag = "<";
		validTag = true;
	    } else if((htmlBody.charAt(i) != '>' && htmlBody.charAt(i) != ' ') && validTag) {

		if(!(Character.isLetterOrDigit(htmlBody.charAt(i))) && (htmlBody.charAt(i) != '!') && (htmlBody.charAt(i) != '/')){ 
		    validTag = false;
		}
		tag = tag + htmlBody.charAt(i);
	    } else if((htmlBody.charAt(i) != '>' || htmlBody.charAt(i) != ' ') && validTag){
		tag = tag + '>';
		validTag = false;
		handlingTag(tag, htmlBody);
	    }
	}
    }
    /**
     * Dùng để quét tất cả thân HTML để tìm ra các nội dung có tag và có thể tìm ra 1 số tag đặc biệt
     * @param htmlBody 
     */
    
    private void handlingTag(String tag, String htmlBody) {
	tag = tag.toLowerCase();

	if(!tag.contains("</") && alongTag(tag, htmlBody) && !tag.contentEquals("<!doctype>")) {
	    file.tagValue(tag);
	} else{
	    tag = convertTag(tag);
	    if(!tag.contains("</")){
		tagStack.push(tag);
	    } else if(compareTag(tag, tagStack.top())){
		file.tagValue(tagStack.top());
		tagStack.pop();
	    }
	}
    }
    /**
     * Dùng để xử lý thẻ từ thân HTML, kiểm tra là tag mở hay tag đóng rồi đưa nó vào push hay pop
     * @param tag
     * @param htmlBody
     */
    
    public void inputCLI(String url, String fileName) throws IOException{
	try {
	    String body = downloadWebsite(url);
	    analysisHTML(body);
	    file.output(fileName);
	} catch (IOException e) {
	    System.out.println("Can't write to file =(((");
	} catch (Exception e) {
	    System.out.println("Can't read the URL");
	}
    }

    public static String downloadWebsite(String siteUrl) throws MalformedURLException, IOException{
	HttpURLConnection connection = (HttpURLConnection) new URL(siteUrl).openConnection();
	connection.setRequestProperty("outputHTML", "https://vnexpress.net/");
	StringBuilder htmlBody = new StringBuilder();
	try {
	    InputStream inputstream = connection.getInputStream();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
	    String line;
	    while((line = reader.readLine()) != null){
		htmlBody.append(line);
	    }
	    reader.close();
	} catch (IOException e) {
	    System.out.println("Can't open the link!!");
	}
	return htmlBody.toString();
    }
    /**
     * Dùng để tải xuống 1 trang wed HTML và nội dung sẽ chuyển thành dạng String
     * @param SiteUrl
     * @throws MalformedURLException
     * @throw IOException
     */
}
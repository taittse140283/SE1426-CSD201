/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai2;

/**
 *
 * @author PC
 */
public class HTMLCount {
    private DoWithFile file = new DoWithFile();
    private FirstStack stack = new FirstStack();
    
    private boolean openTag(String tag){
        return tag.contains("<") && !tag.contains("</");
    }
    /**
     * Kiểm tra xem có dấu mở tag hay không
     * @param tag
     * @return true hay false
     */
    
    private boolean closeTag(String tag){
        return tag.contains("</");
    }
    /**
     * Kiểm tra xem có dấu đóng tag hay không
     * @param tag
     * @return true hay false
     */
    
    public String convertCloseTag(String tag){
        tag = tag.replace("<", "</");
        return tag;
    }
    /**
     * Đổi dấu mở tag sang đóng tag
     * @param tag
     * @return tag
     */
    
    public boolean aloneTag(String tag, String stringHTML){
        tag = convertCloseTag(tag);
        return !stringHTML.contains(tag);
    }
    /**
     * Nếu satringHTML.contains(tag) là đúng khi có thể đóng và thẻ đó không phải là thẻ đơn.
     * @param tag
     * @param stringHTML
     * @return true hay false
     */
    
    public boolean compareTag(String tag, String tagStack){
        tagStack = convertCloseTag(tagStack);
        System.out.println("Compare tag function: " + tag.equals(tagStack));
        return tag.equals(tagStack);
    }
    /**
     * So sánh thẻ mở và đóng. Chuyển thẻ mở thành thẻ đóng để so sánh
     * @param tag
     * @param tagStack
     * @return true hay false
     */
    
    public void checkTag(String tag, String htmlString) {
	String tagCompare = "";
	boolean isValid;
	if (openTag(tag)) {
	    if (!aloneTag(tag, htmlString)) {
		System.out.println("Push: " + tag);
		stack.push(tag);
	    } else {
		System.out.println("Tag: " + tag + " isValid: " + aloneTag(tag, htmlString));
		file.updateValue(tag);
	    }
	} else if (closeTag(tag)) {
	    tagCompare = stack.top();
	    isValid = compareTag(tag, tagCompare);
	    if (isValid) {
		System.out.println("Pop: " + tag);
		file.updateValue(stack.pop());
	    }
	}
    }
    /**
     * Kiểm tra xem thẻ có giá trị hay không và đưa nó vào file để ghi vào csv
     * @param stringHTML 
     * @param tag
     */
    
    public void slitTag(String stringHTML){
        String tag = "";
        boolean stillValid = true;
        for(int i= 0; i < stringHTML.length(); i++){
            if(stringHTML.charAt(i) == '<'){
                for(int j = i ;j < stringHTML.length() && stillValid == true; j++){
                    if (regexCheckTag(Character.toString(stringHTML.charAt(j))) && stringHTML.charAt(j) != '>'){
                        tag += stringHTML.charAt(j);
                    } else{
                        stillValid = false;
                        tag += '>';
                        if(!tag.equals("<>")){
                        System.out.println("Tag in slip tag after compare '<>': " + tag);
                        checkTag(tag, stringHTML);
                        }
                        tag = "";
			j--;
			i = j;
                    }
                }
            } else{
                stillValid = true;
            }
        }
    }
    /**
     * Tách từng ký tự và đưa nó vao 1 thể. Dùng phương thức regex để xác minh nội dung, nếu là 1 thẻ thì đặt nó vào phương thức checktag để xác định là thẻ mở hay thẻ đóng hoặc thẻ đơn
     * @param stringHTML
     * @return 
     */
    
    public static boolean regexCheckTag(String character) {
	return character.matches("^[a-zA-Z0-9'/''<']+$");
    }   
    /**
     * Kiểm tra từng ký tự bằng phương thức regex
     * @param character
     * @return true hay false
     */
    
    public void manage(String csvFile, String fileName) {
	try {
	    String htmlString = DoWithFile.readFile(fileName);
	    slitTag(htmlString);
	    DoWithFile.output();
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

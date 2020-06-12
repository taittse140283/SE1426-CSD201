/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LAB1_2;

/**
 *
 * @author TAN
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Manager manager = new Manager();
        String url = "https://vi.wikipedia.org/wiki/Trang_Ch%C3%ADnh";
        String file = "output1.csv";
//        GetWebsite a = new GetWebsite();
//        Stack stack = new Stack();
//        stack.push("ABV");
//        stack.push("ABC");
//        stack.pop();
//        stack.print();
//        a.readContent(url);
//        a.print();
        manager.Manager(url,file);
    }
}

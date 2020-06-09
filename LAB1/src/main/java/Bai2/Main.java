/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.HashMap;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String url = "https://vi.wikipedia.org/wiki/Trang_Ch%C3%ADnh";
        String output = "output.csv";

        Manager.process(hashMap, Manager.readHtlmFromWeb(url));
        Manager.writeToFile(hashMap, output);
    }
}

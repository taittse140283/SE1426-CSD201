/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lap1_Bai2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author PC
 */
public class DoWithFile {
    class TagHTML implements Comparable<TagHTML>{
        private String tag;
        private int count;
        
        public TagHTML( ){
            tag = "";
            count = 0;
        }
        
        public TagHTML(String tag, int count){
            this.tag = tag;
            this.count = count;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
        
        public String toString(){
            return tag + ", " + count;
        }
        
        public int compareTo(TagHTML tag){
            if(count > tag.getCount()){
                return 1;
            } else if(count == tag.getCount()){
                return 0;
            } else{
                return -1;
            }
        }
    }
    
    private static HashMap<String, TagHTML> list;
    
    public DoWithFile(){
        list = new HashMap<>();
    }
    
    public static String readFile(String nameFile){
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder sb = null;
        try {
            fr = new FileReader(nameFile);
            br = new BufferedReader(fr);
            sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            System.err.println("File not founded!!!");
        } finally{
            try {
                if(fr != null){
                    fr.close();
                }
                if(br != null){
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    
    public void updateValue(String tag){
        TagHTML tagHTML = new TagHTML(tag, 1);
        if(list.isEmpty()){
            list.put(tag, tagHTML);
        } else{
            if(list.containsKey(tag)){
                list.get(tag).setCount(list.get(tag).getCount() + 1);
            } else{
                list.put(tag, tagHTML);
            }
        }
    }
    
    public static void writeFile(String nameFile) throws IOException{
        if(list.isEmpty()){
            System.out.println(list.isEmpty());
            return;
        }
        FileWriter fr = null;
        try {
            fr = new FileWriter(nameFile);
            fr.write("Tag, Frequency");
            Set key = list.keySet();
            Iterator it = key.iterator();
            while(it.hasNext()){
                fr.write(it.next().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(fr != null){
                    fr.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }  
    }
    
    public static void output(){
        Set key = list.keySet();
        Iterator it= key.iterator();
        while(it.hasNext()){
            System.out.println(list.get(it.next()));
        }
    }
}

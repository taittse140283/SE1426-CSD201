/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai_1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Dell
 */
public class PriorityQueue {
    public ArrayList<Infor> list= new ArrayList<>();

    public PriorityQueue() {
    }
    public void add(Infor infor){
    int size = this.size();

        for(int i = 0; i < size; ++i) {
            int index = size - i - 1;
            if (info.getPoint() <= ((MobileGameInfo)this._list.get(index)).getPoint()) {
                this._list.add(index + 1, info);
                return;
            }
        }

        this._list.add(0, info);
    }

    public long get(String email) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                return ((Infor)this.list.get(i)).getPoint();
            }
        }

        return -1L;
    }

    public void remove(String email) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                this.list.remove(i);
            }
        }

    }

    public void update(String email, long point) {
        for(int i = 0; i < this.size(); ++i) {
            if (((Infor)this.list.get(i)).getEmail().equals(email)) {
                Infor info = (Infor)this.list.remove(i);
                info.setPoint(point);
                this.insert(info);
            }
        }

    }

    public Infor removeMin() {
        return (Infor)this.list.remove(0);
    }

    public Infor min() {
        return (Infor)this.list.get(0);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int size() {
        return this.list.size();
    }

    public String toString() {
        String result = "";

        Infor info;
        for(Iterator var2 = this.list.iterator(); var2.hasNext(); result = result + info.toString() + "\n") {
            info = (Infor)var2.next();
        }

        return result;
    }
}

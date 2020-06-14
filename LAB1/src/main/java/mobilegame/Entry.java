/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobilegame;

/**
 *
 * @author Admin
 */
public class Entry {
    private int _rank;
    private String _info;

    public Entry(int rank, String info) {
        this._rank = rank;
        this._info = info;
    }

    public void set_info(String info) {
        this._info = info;
    }

    public void set_rank(int rank) {
        this._rank = rank;
    }

    public String get_info() {
        return _info;
    }

    public int get_rank() {
        return _rank;
    }

    public String toString() {
        return "(" + _rank + ", " + _info + ")";
    }
}

package com.company;

public class Entry {
    private int _rank;
    private String _job;
    public Entry(int rank, String job) {
        _rank = rank;
        _job = job;
    }
    public int getRank() {
        return _rank;
    }
    public String getJob() {
        return _job;
    }
    public void setRank(int rank) {
        _rank = rank;
    }
    public void setJob(String job) {
        _job = job;
    }
    public String toString() {
        return "(" + _rank + ", " + _job + ")";
    }
}
package com.example.qltc.model;

public class MyTime {
    private int fd;
    private int fm;
    private int fh;
    private long timeMilis;
    private String ngayThangNam;
    private String timeFull;

    public MyTime(int fd, int fm, int fh, long timeMilis, String ngayThangNam, String timeFull) {
        this.fd = fd;
        this.fm = fm;
        this.fh = fh;
        this.timeMilis = timeMilis;
        this.ngayThangNam = ngayThangNam;
        this.timeFull = timeFull;
    }

    public int getFd() {
        return fd;
    }

    public void setFd(int fd) {
        this.fd = fd;
    }

    public int getFm() {
        return fm;
    }

    public void setFm(int fm) {
        this.fm = fm;
    }

    public int getFh() {
        return fh;
    }

    public void setFh(int fh) {
        this.fh = fh;
    }

    public long getTimeMilis() {
        return timeMilis;
    }

    public void setTimeMilis(long timeMilis) {
        this.timeMilis = timeMilis;
    }

    public String getNgayThangNam() {
        return ngayThangNam;
    }

    public void setNgayThangNam(String ngayThangNam) {
        this.ngayThangNam = ngayThangNam;
    }

    public String getTimeFull() {
        return timeFull;
    }

    public void setTimeFull(String timeFull) {
        this.timeFull = timeFull;
    }

    public MyTime() {
    }
}

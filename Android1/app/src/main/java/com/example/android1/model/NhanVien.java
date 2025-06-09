package com.example.android1.model;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String mavn;
    private String tennv;
    private String tenpb;

    public NhanVien(String mavn, String tennv, String tenpb) {
        this.mavn = mavn;
        this.tennv = tennv;
        this.tenpb = tenpb;
    }

    public String getMavn() {
        return mavn;
    }

    public void setMavn(String mavn) {
        this.mavn = mavn;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }
}

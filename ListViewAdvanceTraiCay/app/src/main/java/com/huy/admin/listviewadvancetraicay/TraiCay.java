package com.huy.admin.listviewadvancetraicay;

/**
 * Created by admin on 28-Aug-17.
 */

public class TraiCay {
    private String Ten;
    private String MoTa;
    private int hinh;

    public TraiCay(String ten, String moTa, int hinh) {
        Ten = ten;
        MoTa = moTa;
        this.hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}

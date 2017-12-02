package com.huy.admin.intentexplicitbundle;

import java.io.Serializable;

/**
 * Created by admin on 02-Sep-17.
 */

public class SinhVien implements Serializable{
    private String Ten;
    private int Tuoi;

    public SinhVien(String ten, int tuoi) {
        Ten = ten;
        Tuoi = tuoi;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }
}

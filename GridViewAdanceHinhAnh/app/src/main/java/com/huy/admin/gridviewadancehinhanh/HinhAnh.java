package com.huy.admin.gridviewadancehinhanh;

/**
 * Created by admin on 28-Aug-17.
 */

public class HinhAnh {
    String Ten;
    int hinh;

    public HinhAnh(String ten, int hinh) {
        Ten = ten;
        this.hinh = hinh;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}

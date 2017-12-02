package com.huy.admin.intenexpicitdoituong;

import java.io.Serializable;

/**
 * Created by admin on 02-Sep-17.
 */

public class MonHoc implements Serializable {
    private String Ten;
    private int SoTinChi;

    public MonHoc(String ten, int soTinChi) {
        Ten = ten;
        SoTinChi = soTinChi;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getSoTinChi() {
        return SoTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        SoTinChi = soTinChi;
    }
}

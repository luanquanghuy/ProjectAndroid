package com.huy.admin.oobjava;

/**
 * Created by admin on 27-Aug-17.
 */

public class SinhVien {
    public String TenSV;
    public String DiaChi;
    private int NamSinh;

    public SinhVien(String tenSV, String diaChi, int namSinh) {
        TenSV = tenSV;
        DiaChi = diaChi;
        NamSinh = namSinh;
    }

    public void SetNamSinh(int namSinh){
        NamSinh = namSinh;
    }

    public int GetNamSinh(){
        return NamSinh;
    }
}




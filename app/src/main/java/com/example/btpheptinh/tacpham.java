package com.example.btpheptinh;

public class tacpham {
    private String TenTacGiac;
    private String TenTacPham;
    private String NamSangTac;

    public tacpham(String tenTacGiac, String tenTacPham, String namSangTac) {
        TenTacGiac = tenTacGiac;
        TenTacPham = tenTacPham;
        NamSangTac = namSangTac;
    }

    public String getTenTacGiac() {
        return TenTacGiac;
    }

    public void setTenTacGiac(String tenTacGiac) {
        TenTacGiac = tenTacGiac;
    }

    public String getTenTacPham() {
        return TenTacPham;
    }

    public void setTenTacPham(String tenTacPham) {
        TenTacPham = tenTacPham;
    }

    public String getNamSangTac() {
        return NamSangTac;
    }

    public void setNamSangTac(String namSangTac) {
        NamSangTac = namSangTac;
    }
}

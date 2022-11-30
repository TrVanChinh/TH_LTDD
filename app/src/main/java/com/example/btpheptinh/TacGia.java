package com.example.btpheptinh;

public class TacGia {

    private String TenTacGia;
    private String NamSinh;
    private String mota;
    private int hinhanh;



    public TacGia(String tenTacGia, String namSinh, String mota, int hinhanh) {
        TenTacGia = tenTacGia;
        NamSinh = namSinh;
        this.mota = mota;
        this.hinhanh = hinhanh;
    }


    public String getTenTacGia() {
        return TenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        TenTacGia = tenTacGia;
    }

    public String getNamSinh() {
        return NamSinh;
    }

    public void setNamSinh(String NamSinh) {
        this.NamSinh = NamSinh;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(int hinhanh) {
        this.hinhanh = hinhanh;
    }
}

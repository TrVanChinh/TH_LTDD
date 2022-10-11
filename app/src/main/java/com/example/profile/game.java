package com.example.profile;

public class game {

    private String ten;
    private String Mota;
    private String Danhgia;
    private String Dungluong;
    private int Star;
    private int hinh;
    private String stt;


    public game(String ten, String mota, String danhgia, String dungluong, int star, int hinh, String stt) {
        this.ten = ten;
        this.Mota = mota;
        this.Danhgia = danhgia;
        this.Dungluong = dungluong;
        this.Star = star;
        this.hinh = hinh;
        this.stt = stt;
    }

    public String getDanhgia() {
        return Danhgia;
    }

    public void setDanhgia(String danhgia) {
        Danhgia = danhgia;
    }

    public String getDungluong() {
        return Dungluong;
    }

    public void setDungluong(String dungluong) {
        Dungluong = dungluong;
    }

    public int getStar() {
        return Star;
    }

    public void setStar(int star) {
        Star = star;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String mota) {
        Mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }
}

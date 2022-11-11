package com.example.thsqlite;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String msv;
    private String tensv;
    private String tenLop;
    private int namsinh;
    private float DiemToan;
    private float DiemTin;
    private float DiemAnh;

    public SinhVien() {
    }

    public SinhVien(String msv, String tensv, String tenLop, int namsinh, float diemToan, float diemTin, float diemAnh) {
        this.msv = msv;
        this.tensv = tensv;
        this.tenLop = tenLop;
        this.namsinh = namsinh;
        DiemToan = diemToan;
        DiemTin = diemTin;
        DiemAnh = diemAnh;
    }

    public SinhVien(String msv, String tensv, String tenLop) {
        this.msv = msv;
        this.tensv = tensv;
        this.tenLop = tenLop;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getTensv() {
        return tensv;
    }

    public void setTensv(String tensv) {
        this.tensv = tensv;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public float getDiemToan() {
        return DiemToan;
    }

    public void setDiemToan(float diemToan) {
        DiemToan = diemToan;
    }

    public float getDiemTin() {
        return DiemTin;
    }

    public void setDiemTin(float diemTin) {
        DiemTin = diemTin;
    }

    public float getDiemAnh() {
        return DiemAnh;
    }

    public void setDiemAnh(float diemAnh) {
        DiemAnh = diemAnh;
    }
}

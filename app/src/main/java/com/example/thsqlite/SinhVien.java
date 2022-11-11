package com.example.thsqlite;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private String msv;
    private String tensv;
    private String malophoc;
    private int namsinh;
    private int DiemToan;
    private int DiemTin;
    private int DiemAnh;

    public SinhVien() {
    }

    public SinhVien(String msv, String tensv, String malophoc, int namsinh, int diemToan, int diemTin, int diemAnh) {
        this.msv = msv;
        this.tensv = tensv;
        this.malophoc = malophoc;
        this.namsinh = namsinh;
        DiemToan = diemToan;
        DiemTin = diemTin;
        DiemAnh = diemAnh;
    }

    public SinhVien(String msv, String tensv, String malophoc) {
        this.msv = msv;
        this.tensv = tensv;
        this.malophoc = malophoc;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public int getDiemToan() {
        return DiemToan;
    }

    public void setDiemToan(int diemToan) {
        DiemToan = diemToan;
    }

    public int getDiemTin() {
        return DiemTin;
    }

    public void setDiemTin(int diemTin) {
        DiemTin = diemTin;
    }

    public int getDiemAnh() {
        return DiemAnh;
    }

    public void setDiemAnh(int diemAnh) {
        DiemAnh = diemAnh;
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

    public String getMalophoc() {
        return malophoc;
    }

    public void setMalophoc(String malophoc) {
        this.malophoc = malophoc;
    }
}

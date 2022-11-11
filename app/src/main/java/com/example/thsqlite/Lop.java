package com.example.thsqlite;

public class Lop {
    private String malop;
    private String tenlop;
    private  int siso;

    public Lop() {
    }

    public Lop(String malop, String tenlop, int siso) {
        this.malop = malop;
        this.tenlop = tenlop;
        this.siso = siso;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public int getSiso() {
        return siso;
    }

    public void setSiso(int siso) {
        this.siso = siso;
    }
}

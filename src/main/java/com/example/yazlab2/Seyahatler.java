package com.example.yazlab2;

public class Seyahatler {
    public int tarih;
    public double mesafe;
    public int konum;

    public Seyahatler(int tarih, double mesafe, int konum) {
        this.tarih = tarih;
        this.mesafe = mesafe;
        this.konum = konum;
    }

    public int getTarih() {
        return tarih;
    }

    public void setTarih(int tarih) {
        this.tarih = tarih;
    }

    public double getMesafe() {
        return mesafe;
    }

    public void setMesafe(double mesafe) {
        this.mesafe = mesafe;
    }

    public int getkonum() {
        return konum;
    }

    public void setkonum(int konum) {
        this.konum = konum;
    }
}

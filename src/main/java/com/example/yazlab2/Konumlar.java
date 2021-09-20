package com.example.yazlab2;

public class Konumlar {
    int id;
    String konumBaslangic;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getkonumBaslangic() {
        return konumBaslangic;
    }

    public void setkonumBaslangic(String konumBaslangic) {
        this.konumBaslangic = konumBaslangic;
    }

    public Konumlar(int id, String konumBaslangic) {
        this.id = id;
        this.konumBaslangic = konumBaslangic;
    }
}

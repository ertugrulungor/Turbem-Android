package com.patates.patatesapp;

/**
 * Created by macintosh on 28.05.2017.
 */

public class Kullanici {
    private int id;
    private String email;
    private String kullaniciAdi;

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
}

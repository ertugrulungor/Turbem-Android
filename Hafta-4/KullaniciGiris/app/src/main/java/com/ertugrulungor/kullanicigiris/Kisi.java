package com.ertugrulungor.kullanicigiris;

import java.io.Serializable;

/**
 * Created by macintosh on 5.03.2017.
 */

public class Kisi implements Serializable{
    private String Ad;
    private  int Yas;

    public String getAd() {
        return Ad;
    }

    public int getYas() {
        return Yas;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public void setYas(int yas) {
        Yas = yas;
    }
}

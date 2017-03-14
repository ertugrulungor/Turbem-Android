package com.ertugrulungor.listviewuygulamasi;

/**
 * Created by macintosh on 12.03.2017.
 */

public class Kisi {
    private String isim;
    private  boolean kadinMi;

    public Kisi(String ad, boolean kadinMi){
        this.isim = ad;
        this.kadinMi = kadinMi;
    }

    public String getIsim() {
        return isim;
    }

    public boolean isKadinMi() {
        return kadinMi;
    }

    public void setKadinMi(boolean kadinMi) {
        this.kadinMi = kadinMi;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
}

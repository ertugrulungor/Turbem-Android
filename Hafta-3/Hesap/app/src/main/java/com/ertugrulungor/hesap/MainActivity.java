package com.ertugrulungor.hesap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public enum Islem{
        topla,
        cikar,
        carp,
        bol
    }

    float sonuc = 0;
    EditText edtSayi;
    public Islem seciliIslem = null;
    public boolean temizle = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSayi = (EditText) findViewById(R.id.edtSayi);

        Button sil = (Button) findViewById(R.id.sil);

        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtSayi.setText("0");
                seciliIslem = null;
            }
        });
    }

    public void SayiYaz(View v){
        Button b = (Button) v;

        if(edtSayi.getText().toString().equals("0")){
            edtSayi.setText("");
        }

        if(temizle){
            edtSayi.setText("");
            temizle = false;
        }

        edtSayi.setText(edtSayi.getText().toString() + b.getText().toString());

    }

    public void dortIslem(View v){
        Float gelenSayi = Float.valueOf(edtSayi.getText().toString());

        if(seciliIslem == null){
            sonuc = gelenSayi;
        }else {
            if(seciliIslem == Islem.topla){
                sonuc += gelenSayi;
            }else if (seciliIslem == Islem.carp){
                sonuc *= gelenSayi;
            }else if (seciliIslem == Islem.cikar){
                sonuc -= gelenSayi;
            }else if (seciliIslem == Islem.bol){
                sonuc /= gelenSayi;
            }
        }

        Button b = (Button) v;
        switch (b.getId()){
            case R.id.topla:
                seciliIslem = Islem.topla;
                temizle = true;
                break;
            case R.id.cikar:
                seciliIslem = Islem.cikar;
                temizle = true;
                break;
            case R.id.carp:
                seciliIslem = Islem.carp;
                temizle = true;
                break;
            case R.id.bol:
                seciliIslem = Islem.bol;
                temizle = true;
                break;
            case R.id.esit:
                edtSayi.setText(String.valueOf(sonuc));
                sonuc = Float.valueOf(edtSayi.getText().toString());
                seciliIslem = null;
                break;
        }
    }
}

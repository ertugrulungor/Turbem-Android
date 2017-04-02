package com.ertugrulungor.loginregister;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class KayitActivity extends AppCompatActivity {

    EditText edtKulAdi, edtSifre, edtAdSoyad;
    Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        vt = new Veritabani(KayitActivity.this);

        edtKulAdi = (EditText) findViewById(R.id.kayitKulAdi);
        edtSifre = (EditText) findViewById(R.id.kayitSifre);
        edtAdSoyad = (EditText) findViewById(R.id.kayitAdSoyad);

    }

    public void KayitOl(View view){
        String kulAdi = edtKulAdi.getText().toString();
        String sifre = edtSifre.getText().toString();
        String adSoyad = edtAdSoyad.getText().toString();

        SQLiteDatabase db = vt.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM Kisiler WHERE kullaniciAdi=?",new String[]{kulAdi});
        if(c.getCount()>0){
            Toast.makeText(KayitActivity.this, "Böyle bir kıllanıcı zaten var", Toast.LENGTH_SHORT).show();
            c.close();
            db.close();
        }else {
            ContentValues cv = new ContentValues();
            cv.put("kullaniciAdi",kulAdi);
            cv.put("sifre",sifre);
            cv.put("adSoyad",adSoyad);

            db.insert("Kisiler",null,cv);
            c.close();
            db.close();

            Intent i = new Intent(KayitActivity.this,MainActivity.class);
            startActivity(i);

        }

    }
}




















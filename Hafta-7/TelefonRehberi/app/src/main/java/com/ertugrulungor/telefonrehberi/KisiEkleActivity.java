package com.ertugrulungor.telefonrehberi;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class KisiEkleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kisi_ekle);

        final EditText edtAd = (EditText) findViewById(R.id.ad);
        final EditText edtSoyad = (EditText) findViewById(R.id.soyad);
        final EditText edtTel = (EditText) findViewById(R.id.telNo);

        final DBHelper dbHelper = new DBHelper();

        Button btnEkle = (Button) findViewById(R.id.btnEkle);
        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad = edtAd.getText().toString();
                String soyad = edtSoyad.getText().toString();
                String tel = edtTel.getText().toString();

                dbHelper.KisiEkle(KisiEkleActivity.this,ad,soyad,tel);

                Intent i = new Intent(KisiEkleActivity.this,MainActivity.class);
                startActivity(i);

            }
        });
    }
}

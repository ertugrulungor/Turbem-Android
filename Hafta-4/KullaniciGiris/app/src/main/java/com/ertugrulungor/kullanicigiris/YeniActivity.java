package com.ertugrulungor.kullanicigiris;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class YeniActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni);

        /*
        Basit yapıları alma
        Bundle bundle = getIntent().getExtras();
        Toast.makeText(this, bundle.getString("kullanici"), Toast.LENGTH_SHORT).show();
        */

        /*
        Obje alma
        Intent i = getIntent();
        Kisi k = (Kisi) i.getSerializableExtra("kisi");
        Toast.makeText(this, k.getAd(), Toast.LENGTH_SHORT).show();
        */

        Button b = (Button) findViewById(R.id.cikis);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("ertugrul",MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                edit.putBoolean("girisYapildi",false);
                edit.apply();

                Intent i = new Intent(YeniActivity.this,MainActivity.class);
                startActivity(i);
            }
        });
    }
}

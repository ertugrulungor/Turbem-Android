package com.ertugrulungor.kullanicigiris;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences pref = getApplicationContext().getSharedPreferences("ertugrul",MODE_PRIVATE);
        if(pref.getBoolean("girisYapildi",false) == true){
            Intent i = new Intent(MainActivity.this, YeniActivity.class);
            startActivity(i);
        }

        final EditText kulAdi = (EditText) findViewById(R.id.kulAdi);
        final EditText sifre = (EditText) findViewById(R.id.sifre);

        final Button yeniSayfa = (Button) findViewById(R.id.btnYeniSayfa);
        yeniSayfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kullanici, sfr;
                kullanici = kulAdi.getText().toString();
                sfr = sifre.getText().toString();

               if(kullanici.equals("admin") && sfr.equals("1")){

                   /*Kisi k = new Kisi();
                   k.setAd("ertuğrul");
                   k.setYas(22);*/


                   SharedPreferences.Editor edit = pref.edit();
                   edit.putBoolean("girisYapildi",true);
                   edit.apply();

                   Intent i = new Intent(MainActivity.this, YeniActivity.class);

                   /*
                   Basit yapıları gönderme
                   i.putExtra("kullanici",kullanici);
                   */

                   /*
                   Obje gönderme
                   i.putExtra("kisi",k);
                   */


                   startActivity(i);
               }
               else {
                   Toast.makeText(MainActivity.this, "Kullanıcı adı yada şifre yanlış", Toast.LENGTH_SHORT).show();
               }
            }
        });

    }
}

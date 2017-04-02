package com.ertugrulungor.loginregister;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtKulAdi, edtSifre;
    Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        vt = new Veritabani(MainActivity.this);
        edtKulAdi = (EditText) findViewById(R.id.girisKulAdi);
        edtSifre = (EditText) findViewById(R.id.girisSifre);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,KayitActivity.class);
                startActivity(i);
            }
        });
    }

    public void GirisYap(View view) {
        String kulAdi = edtKulAdi.getText().toString();
        String sifre = edtSifre.getText().toString();

        SQLiteDatabase db = vt.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM Kisiler WHERE kullaniciAdi=? AND sifre=?", new String[]{kulAdi, sifre});

        if (c.getCount() > 0) {
            c.moveToFirst();
            Toast.makeText(MainActivity.this, "Hoşgeldin " + c.getString(1), Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(MainActivity.this, "Kayıt Bulunamadı", Toast.LENGTH_SHORT).show();

        }
        c.close();
        db.close();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

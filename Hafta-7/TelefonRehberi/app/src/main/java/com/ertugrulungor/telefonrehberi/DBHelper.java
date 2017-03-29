package com.ertugrulungor.telefonrehberi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by macintosh on 26.03.2017.
 */

public class DBHelper {
    Database veritabanim;
    private SQLiteDatabase db;

    public List<Kisi> KisileriGetir(Context context){
        List<Kisi> kisiler = new ArrayList<>();
        try{
            veritabanim = new Database(context);
            veritabanim.createDataBase();
        }catch (IOException e){
            e.printStackTrace();
        }

        SQLiteDatabase dbInstance = veritabanim.getWritableDatabase();
        Cursor cursor = null;
        try{
            cursor = dbInstance.rawQuery("SELECT * FROM Kisiler",null);
            while(cursor.moveToNext()){
                Kisi k = new Kisi();
                k.setAdSoyad(cursor.getString(1) + " " + cursor.getString(2));
                k.setTelNo(cursor.getString(3));
                kisiler.add(k);
            }
        }finally {
            assert cursor != null;
            //cursor.close();
        }
        return kisiler;
    }

    public void KisiEkle(Context context, String ad, String soyad, String telNo){
        try{
            veritabanim = new Database(context);
            veritabanim.createDataBase();
        }catch (IOException e){
            e.printStackTrace();
        }

        ContentValues contentValues = new ContentValues();
        contentValues.put("Ad",ad);
        contentValues.put("Soyad",soyad);
        contentValues.put("TelNo",telNo);

        SQLiteDatabase db = veritabanim.getWritableDatabase();
        db.insert("Kisiler",null,contentValues);
    }
}











package com.ertugrulungor.loginregister;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by macintosh on 2.04.2017.
 */

public class Veritabani extends SQLiteOpenHelper{
    private static final String dbName = "Kisiler";
    private static final int version=1;

    public Veritabani(Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE Kisiler (id INTEGER PRIMARY KEY, adSoyad TEXT, kullaniciAdi TEXT, sifre TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Kisiler");
        onCreate(sqLiteDatabase);
    }
}

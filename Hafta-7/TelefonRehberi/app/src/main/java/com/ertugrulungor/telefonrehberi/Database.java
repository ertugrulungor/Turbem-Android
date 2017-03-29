package com.ertugrulungor.telefonrehberi;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by macintosh on 25.03.2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final int VERSION = 4;
    private static String DB_PATH = "/data/data/com.ertugrulungor.telefonrehberi/databases/";
    private static String DB_NAME = "telefonrehberi.db";
    private final Context myContext;
    private SQLiteDatabase myDataBase;

    public Database(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.myContext = context;
        SQLiteDatabase database = this.getWritableDatabase();
        boolean dbExist = checkDataBase();

        if(dbExist){

        }else {
            database.execSQL("CREATE TABLE Kisiler (id INTEGER PRIMARY KEY AUTOINCREMENT, Ad TEXT, Soyad TEXT, TelNo TEXT)");

        }

    }

    public void createDataBase() throws IOException{
        System.out.println("create database");
        boolean dbExist = checkDataBase();

        if(dbExist){

        }else{

            this.getReadableDatabase();

            try {

                copyDataBase();

            } catch (IOException e) {
                throw new Error("Error copying database");

            }
        }

    }

    private boolean checkDataBase(){

        File dbFile = myContext.getDatabasePath(DB_NAME);
        return dbFile.exists();
    }

    private void copyDataBase() throws IOException{


        System.out.println("copy database");
        InputStream myInput = myContext.getAssets().open(DB_NAME);


        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);


        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer))>0){
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    public void openDataBase() throws SQLException {

        //Open the database
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

    }

    @Override
    public synchronized void close() {

        if(myDataBase != null)
            myDataBase.close();

        super.close();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        boolean dbExist = checkDataBase();

        if(dbExist){

        }else {
            sqLiteDatabase.execSQL("CREATE TABLE Kisiler (id INTEGER PRIMARY KEY AUTOINCREMENT, Ad TEXT, Soyad TEXT, TelNo TEXT)");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(sqLiteDatabase);
    }

    /*@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }*/

}

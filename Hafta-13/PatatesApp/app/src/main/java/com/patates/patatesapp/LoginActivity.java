package com.patates.patatesapp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {

    EditText edtKullanici,edtSifre;
    BusinessLayer bl = new BusinessLayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtKullanici = (EditText) findViewById(R.id.kulAdi);
        edtSifre = (EditText) findViewById(R.id.sifre);
    }

    public void Giris(View view){
        String kullanici,sifre;
        kullanici = edtKullanici.getText().toString();
        sifre = edtSifre.getText().toString();

        new MultiTask().execute(kullanici,sifre);
    }

    private class MultiTask extends AsyncTask<String,String,String>{
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            if(progressDialog == null){
                progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Lütfen Bekleyiniz...");
                progressDialog.show();
                progressDialog.setCancelable(false);
                progressDialog.setCanceledOnTouchOutside(false);
            }
        }

        @Override
        protected String doInBackground(String... params) {
            String jsonResult = "";

            try {
                jsonResult = bl.Login(params[0],params[1]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonResult;
        }

        @Override
        protected void onPostExecute(String s) {
            if(progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            try {
                Kullanici kullanici = bl.parseLogin(s);
                if(kullanici.getId() != 0){      
                    Toast.makeText(LoginActivity.this, kullanici.getEmail(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this, "Kullanıcı adı yada şifre yanlış", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

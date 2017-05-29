package com.patates.patatesapp;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by macintosh on 28.05.2017.
 */

public class BusinessLayer {
    private String link = "", result = "";
    private final String URL = "http://patatesservice.azurewebsites.net/PatatesService.svc";

    //Bağlanılacak methodlar
    public String Login(String user, String password) throws IOException {
        link = URL + "/KullaniciGiris/?kulAdi="+user+"&sifre="+password;
        result = Connect(link);
        link = "";
        return result;
    }

    //Http istek
    private String Connect(String link) throws IOException {
        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters,5000);
        HttpConnectionParams.setSoTimeout(httpParameters,5000);
        HttpClient httpClient = new DefaultHttpClient(httpParameters);
        HttpGet httpGet = new HttpGet(link);

        String jsonResult = "";
        HttpResponse response = httpClient.execute(httpGet);

        jsonResult = inputStreamToString(response.getEntity().getContent()).toString();
        return  jsonResult;
    }

    private StringBuilder inputStreamToString(InputStream is){
        String rLine = "";
        StringBuilder answer = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        try {
            while ((rLine = br.readLine()) != null)
            {
                answer.append(rLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return answer;
    }

    //Json parçalayacak Methodlar
    public Kullanici parseLogin(String result) throws JSONException {
        JSONObject resultObject = null;
        Kullanici kullanici = new Kullanici();

        resultObject = new JSONObject(result);
        kullanici.setId(resultObject.getInt("id"));
        kullanici.setEmail(resultObject.getString("email"));
        kullanici.setKullaniciAdi(resultObject.getString("kulAdi"));

        return kullanici;
    }
}

package com.ertugrulungor.konumbelirle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void konumBul(View view) {
        GPSBul gpsBul = new GPSBul(MainActivity.this);

        String dateAsText = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(new Date(gpsBul.GetTime()));
        Toast.makeText(MainActivity.this, "lat:" + gpsBul.GetLatitute() + " lang:" + gpsBul.GetLongitude() + " time:" +
                dateAsText + " speed:" + gpsBul.GetSpeed(), Toast.LENGTH_SHORT).show();
    }
}

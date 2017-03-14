package com.ertugrulungor.listviewuygulamasi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {

    List<Kisi> kisiler = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        kisiler.add(new Kisi("Ertuğrul Üngör",false));
        kisiler.add(new Kisi("Şaduman Küçük",true));

        ListView list = (ListView) findViewById(R.id.customList);
        OzelAdapter adapter = new OzelAdapter(this,kisiler);
        list.setAdapter(adapter);
    }
}

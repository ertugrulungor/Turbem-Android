package com.ertugrulungor.listviewuygulamasi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by macintosh on 12.03.2017.
 */

public class OzelAdapter extends BaseAdapter{

    private LayoutInflater inf;
    private List<Kisi> kisiler;

    public OzelAdapter(Activity activity, List<Kisi> kisiler){
        inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.kisiler = kisiler;
    }

    @Override
    public int getCount() {
        return kisiler.size();
    }

    @Override
    public Object getItem(int i) {
        return kisiler.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View satir;

        satir = inf.inflate(R.layout.satir,null);
        TextView txt = (TextView) satir.findViewById(R.id.isim);
        ImageView img = (ImageView) satir.findViewById(R.id.resim);

        Kisi k = kisiler.get(i);

        txt.setText(k.getIsim());
        if(k.isKadinMi()){
            img.setImageResource(R.drawable.female);
        }else {
            img.setImageResource(R.drawable.male);
        }

        return satir;
    }
}

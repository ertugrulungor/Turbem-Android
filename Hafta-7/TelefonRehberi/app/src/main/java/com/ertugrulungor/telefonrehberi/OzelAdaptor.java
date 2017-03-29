package com.ertugrulungor.telefonrehberi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by macintosh on 26.03.2017.
 */

public class OzelAdaptor extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Kisi> kisis;

    public OzelAdaptor(Activity activity, List<Kisi> kisiler){
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        kisis = kisiler;
    }

    @Override
    public int getCount() {
        return kisis.size();
    }

    @Override
    public Object getItem(int i) {
        return kisis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View satirView;
        satirView = layoutInflater.inflate(R.layout.satir,null);

        TextView adSoyad = (TextView) satirView.findViewById(R.id.adSoyad);
        TextView telNo = (TextView) satirView.findViewById(R.id.no);

        Kisi k = kisis.get(i);
        adSoyad.setText(k.getAdSoyad());
        telNo.setText(k.getTelNo());

        return satirView;
    }
}



















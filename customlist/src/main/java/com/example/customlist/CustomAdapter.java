package com.example.customlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rahul on 11/28/2016.
 */

public class CustomAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<MyItem> countries;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<MyItem> countries) {
        this.context = context;
        this.countries = countries;

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return countries.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = null;

        if(convertView == null )  view = inflater.inflate(R.layout.custom_view,null,false);
        else view = convertView;

        ((ImageView)view.findViewById(R.id.imageview))
                .setImageResource(countries.get(position).getFlag());

        ((TextView)view.findViewById(R.id.textview)).setText(countries.get(position).getCountryName());


        return view;
    }
}

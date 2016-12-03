package com.example.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyItem> countries = new ArrayList<>();
        countries.add(new MyItem(1l,R.drawable.customerone,"India"));
        countries.add(new MyItem(2l,R.drawable.customertwo,"USA"));
        countries.add(new MyItem(3l,R.drawable.customerthree,"China"));
        countries.add(new MyItem(4l,R.drawable.customerfour,"Aus"));
        countries.add(new MyItem(5l,R.drawable.customerfive,"Japan"));

        CustomAdapter adapter = new CustomAdapter(this,countries);
        ListView list = (ListView)findViewById(R.id.listview);
        list.setAdapter(adapter);

    }
}

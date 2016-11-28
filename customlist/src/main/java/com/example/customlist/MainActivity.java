package com.example.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<MyItem> countries = new ArrayList<>();
        countries.add(new MyItem(1l,R.drawable.customerone,"India"));
        countries.add(new MyItem(2l,R.drawable.customertwo,"India"));
        countries.add(new MyItem(3l,R.drawable.customerthree,"India"));
        countries.add(new MyItem(4l,R.drawable.customerfour,"India"));
        countries.add(new MyItem(5l,R.drawable.customerfive,"India"));

        CustomAdapter adapter = new CustomAdapter(this,countries);
        ((ListView)findViewById(R.id.listview)).setAdapter(adapter);


    }
}

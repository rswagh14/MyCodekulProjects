package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> dataset = new ArrayList<>();
        dataset.add("India");
        dataset.add("USA");
        dataset.add("UK");
        dataset.add("RSA");
        dataset.add("Switzerland");
        dataset.add("Italy");
        dataset.add("France");
        dataset.add("Germany");
        dataset.add("Japan");
        dataset.add("RSA");
        dataset.add("Switzerland");
        dataset.add("Italy");
        dataset.add("France");
        dataset.add("Germany");
        dataset.add("Japan");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,dataset);

        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

    }
}

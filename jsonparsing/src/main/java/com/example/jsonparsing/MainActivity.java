package com.example.jsonparsing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import dto.Devices;
import dto.My;
import dto.Versions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btnParse).setOnClickListener(this::clicked);
    }

    private void clicked(View view) {
        parsingUsingGson(readJsonFromAssets());

    }

    private String readJsonFromAssets(){
        StringBuilder builder = new StringBuilder();

        try {
            InputStream is = getAssets().open("my.json");
            while(true){
                int ch = is.read();
                if(ch == -1) break;
                else builder.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private void parseUsingJsonObjectApi(String json) {

        StringBuilder builder = new StringBuilder();

        try {
            JSONObject rootObject = new JSONObject(json);
            String Name = rootObject.getString("name");
            String Os = rootObject.getString("os");
            double Version = rootObject.getDouble("ver");
            boolean IsUpdateAvaliable = rootObject.getBoolean("isUpdateAva");

            builder.append("\n Name ").append(Name);
            builder.append("\n Os ").append(Os);
            builder.append("\n Version ").append(Version);
            builder.append("\n IsUpdateAvaliable ").append(IsUpdateAvaliable);

            JSONObject innerObject = rootObject.getJSONObject("allVersions");
            double Base = innerObject.getDouble("base");
            double CupCake = innerObject.getDouble("cupCake");

            builder.append("\n Base ").append(Base);
            builder.append("\n CupCake ").append(CupCake);

            JSONArray devices = rootObject.getJSONArray("devices");

            for (int i = 0; i < devices.length(); i++) {

                JSONObject arrayObj = devices.getJSONObject(i);
                String Mobile = arrayObj.getString("mobile");
                int Cost = arrayObj.getInt("cost");

                builder.append("\n Mobile ").append(Mobile);
                builder.append("\n Cost ").append(Cost);
            }

            Log.i("@Rahul ", builder.toString());

            //((TextView)findViewById(R.id.text)).setText(builder.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void parsingUsingGson(String json){
        Gson gson = new Gson();
        My my = gson.fromJson(json, My.class);
        Log.i("@codekul","Gson - "+my);

        My myCon = new My();
        myCon.setName("codekul.com");
        myCon.setOs("Android");
        myCon.setVar(5.1);

        Versions vesrions = new Versions();
        vesrions.setBase("android");
        vesrions.setCupCake("androiod");
        myCon.setAllVersions(vesrions);

        ArrayList<Devices> devices = new ArrayList<>();
        Devices d1 = new Devices();
        d1.setCost(800);
        d1.setMobile("android");
        myCon.setDevices(devices);

        String newJson = gson.toJson(myCon);
        Log.i("@codekul","Converted - "+newJson);
    }
}

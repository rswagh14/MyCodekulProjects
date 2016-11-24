package com.example.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout layoutRoot = (LinearLayout)findViewById(R.id.layoutRoot);

        layoutRoot.addView(givemesocialcard("nbxbjbsdfkj"));
        layoutRoot.addView(givemesocialcard("nbxbjbsdfkj"));


        //givemesocialcard(status);
    }

    private View givemesocialcard(String status) {

        LayoutInflater inflater = getLayoutInflater();

        LinearLayout layoutRoot = (LinearLayout) findViewById(R.id.layoutRoot);

        /*LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);*/

        //LayoutInflater inflater = LayoutInflater.from(this);

        View compoundView = inflater.inflate(R.layout.social_layout,null,true);
        TextView textstatus = (TextView)compoundView.findViewById(R.id.textStatus);
        textstatus.setText(status);

        return compoundView;


    }


}

package com.example.activitylifecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int i=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i=12;
        msg("On Create");

    }

    @Override
    protected void onRestart() {
        msg("On Restart"+ i);
        super.onRestart();
    }

    @Override
    protected void onStart() {
        msg("On Start");
        super.onStart();
    }

    @Override
    protected void onPause() {
        msg("On Pause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        msg("On Destroy");
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        msg("On Stop");
        i = 99;
        super.onStop();
    }

    public void msg(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}

package com.example.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MY_OS = "myOs";
    public static final int REQ_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initrb();

        findViewById(R.id.btn).setOnClickListener(this::clicked);

    }

    private void clicked(View view) {
        opennewactivity();
    }

    private void opennewactivity() {

        Intent intent = new Intent(this,NewActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString(KEY_MY_OS,getOs());

        intent.putExtras(bundle);

       // startActivity(intent);

        startActivityForResult(intent,REQ_CODE);

    }

    private void initrb() {

        ((RadioButton)findViewById(R.id.rb1)).setOnCheckedChangeListener(this::checkchanged);

        ((RadioButton)findViewById(R.id.rb2)).setOnCheckedChangeListener(this::checkchanged);

        ((RadioButton)findViewById(R.id.rb3)).setOnCheckedChangeListener(this::checkchanged);

    }

    private void checkchanged(CompoundButton compoundButton, boolean checked) {

        if(checked){
            if(compoundButton instanceof RadioButton){
                RadioButton rb = (RadioButton)compoundButton;
                settext(rb.getText().toString());
            }
        }

    }

    private void settext(String s) {
       ((EditText)findViewById(R.id.edttxt)).setText(s);
    }

    private String getOs(){
        return ((EditText)findViewById(R.id.edttxt)).getText().toString();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_CODE){
            if(resultCode == RESULT_OK){
                settext(getBack(data));
            }
        }

    }

    private String getBack(Intent data) {

        return data.getStringExtra(NewActivity.KEY_BACK);
    }


}

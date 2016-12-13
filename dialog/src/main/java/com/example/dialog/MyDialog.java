package com.example.dialog;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.os.health.ServiceHealthStats;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyDialog extends DialogFragment {

    public static final String DIALOG_ALERT = "Alert";
    public static final String DIALOG_TIME = "Time" ;
    public static final String DIALOG_DATE = "date" ;
    public static final String DIALOG_PROGRESS = "Progress";
    public static final String DIALOG_CUSTOM = "Custom";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Dialog dialog = null;

        if(getTag().equals(DIALOG_ALERT)) dialog = showAlert();
        if(getTag().equals(DIALOG_TIME)) dialog = showTime();
        if(getTag().equals(DIALOG_DATE)) dialog = showDate();
        if(getTag().equals(DIALOG_PROGRESS)) dialog = showProgress();
        if(getTag().equals(DIALOG_CUSTOM)) dialog = showCustom();

        return dialog;
    }

    private Dialog showCustom() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.custom_layout,null,false);
        view.findViewById(R.id.btn123).setOnClickListener(v -> {
            Toast.makeText(getActivity(),"btnclicked", Toast.LENGTH_SHORT).show();});

        builder.setView(view);
        return builder.create();
    }

    private Dialog showProgress() {

        ProgressDialog progressdialog = new ProgressDialog(getActivity());
        progressdialog.setMessage("nbndbfjbd");
        progressdialog.setProgress(100);
        progressdialog.setProgressStyle(progressdialog.STYLE_SPINNER);

        return progressdialog;
    }

    /* Get Date picked*/

   public interface OnDatePicked{
       void date( int day,int month, int year);
   }

    private OnDatePicked datepicked;

    public void setdatepicked(OnDatePicked datepicked){
        this.datepicked = datepicked;
    }

    private Dialog showDate() {

        DatePickerDialog datepicker = new DatePickerDialog(getActivity(),
                (view, year, month, dayOfMonth) -> {
                    if(datepicked !=null)
                        datepicked.date(dayOfMonth,month,year);

                },2017,01,01);


        return datepicker;
    }


    public interface OnTimePicked{
        void time(int hr, int min);
    }

    private OnTimePicked timepicked;

    public void settimepicked(OnTimePicked timepicked){
        this.timepicked = timepicked;
    }

    private Dialog showTime() {

        TimePickerDialog timePicker =
                new TimePickerDialog(getActivity(),(view, hourOfDay, minute) ->{
                    if(timepicked!=null){
                        timepicked.time(hourOfDay,minute);
                    }
                },6,8,true);

        return timePicker;
    }

    private Dialog showAlert() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Title")
                .setMessage("Message")
                .setIcon(R.mipmap.ic_launcher);

        return builder.create();
    }
}

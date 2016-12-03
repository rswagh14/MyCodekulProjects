package com.example.login_fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View rootview = inflater.inflate(R.layout.fragment_main, container, false);

        // adding Font file
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"Otto.ttf");

        //Setting font to Textview
        ((TextView)rootview.findViewById(R.id.btnLogin)).setTypeface(tf);
        ((TextView)rootview.findViewById(R.id.textAppName)).setTypeface(tf);
        ((TextView)rootview.findViewById(R.id.btnRegister)).setTypeface(tf);

        rootview.findViewById(R.id.btnLogin).setOnClickListener(this::clicked);
        rootview.findViewById(R.id.btnRegister).setOnClickListener(this::clicked);

        return rootview;
    }

    private void clicked(View view) {
        if(view.getId() == R.id.btnLogin)
            ((MainActivity)getActivity()).runFragmentTransaction(new LoginFragment(),"Login");
        if(view.getId() == R.id.btnRegister)
            ((MainActivity)getActivity()).runFragmentTransaction(new RegisterFragment(),"Register");
    }

}

package com.example.evneet_759831_ft;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private Context context;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        this.context = inflater.getContext();
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            Button button = view.findViewById(R.id.add_user);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,UserDetailsActivity.class);
                    startActivity(intent);
                }
            });
        }
    }
}

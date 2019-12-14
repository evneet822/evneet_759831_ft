package com.example.evneet_759831_ft;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */

interface Listener {
    void onItemClick(int id);
}
public class MainFragment extends Fragment {


     private Listener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }



    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null){
            ListView listView = view.findViewById(R.id.list_view1);
            Button button = view.findViewById(R.id.add_user);

            UserAdaptor userAdaptor = new UserAdaptor(getContext(),R.layout.user_layout,User.userDetails);
            listView.setAdapter(userAdaptor);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getContext(),UserDetailsActivity.class);
                    startActivity(intent);
                }
            });

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (listener != null){
                       listener.onItemClick(position);
                   }
                }
            });

        }
    }




}

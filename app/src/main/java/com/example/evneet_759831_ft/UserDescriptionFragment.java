package com.example.evneet_759831_ft;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserDescriptionFragment extends Fragment {



    public void displayDetails(int id){
        View view = getView();
        if (view != null){
            ImageView imageView = view.findViewById(R.id.userImage);
            TextView name = view.findViewById(R.id.name_frag);
            TextView email = view.findViewById(R.id.email_frag);
            TextView phone = view.findViewById(R.id.phone_frag);
            User user = User.userDetails.get(id);

            imageView.setImageResource(User.userImage[user.getRandom()]);
            name.setText(user.getName());
            email.setText(user.getEmail());
            phone.setText(user.getPhone());
            Log.i("TAG", "displayDetails: " + id);


        }

    }


    public UserDescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_description, container, false);
    }



}

package com.example.evneet_759831_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserAdaptor extends ArrayAdapter {


    private ArrayList<User> users;
    private final LayoutInflater layoutInflater;
    private final int layoutResource;



    public UserAdaptor(@NonNull Context context,int resource,ArrayList<User> user){

        super(context, resource,resource);
        this.layoutInflater = LayoutInflater.from(context);
        layoutResource = resource;
        this.users = user;
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        if (v == null){
            v = layoutInflater.inflate(layoutResource, parent, false);}

            TextView nameText = v.findViewById(R.id.textView_name);
            TextView emailText = v.findViewById(R.id.email);
            TextView phoneText = v.findViewById(R.id.phone);
            ImageView imageView = v.findViewById(R.id.imageView);


            nameText.setText(users.get(position).getName());
            emailText.setText(users.get(position).getEmail());
            phoneText.setText(users.get(position).getPhone());
            imageView.setImageResource(User.userImage[users.get(position).getRandom()]);

            return v;

    }
}

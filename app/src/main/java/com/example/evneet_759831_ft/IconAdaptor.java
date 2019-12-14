package com.example.evneet_759831_ft;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IconAdaptor extends BaseAdapter {

    Context context;
    int[] images;

    public IconAdaptor(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }
    @Override
    public Object getItem(int position) {
        return images[position];
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.cell_item,null);
        ImageView imageView = convertView.findViewById(R.id.image_view);
        //shuffle(images);
        imageView.setBackgroundResource(images[position]);
//        imageView.setImageResource(images[position]);
        return convertView;
    }
/*
    public void shuffle(int[] intArray){
        Random random = new Random();
        for (int i = intArray.length-1;i>=0;i--){
            int index = random.nextInt(i+1);
            int temp = intArray[index];
            intArray[index] = intArray[i];
            intArray[i] = temp;

        }
    }*/

}

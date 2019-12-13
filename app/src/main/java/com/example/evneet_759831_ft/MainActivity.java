package com.example.evneet_759831_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private boolean mIsDualPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View deatilView = findViewById(R.id.description_frag);
        mIsDualPane = deatilView != null && deatilView.getVisibility() == View.VISIBLE;
    }
}

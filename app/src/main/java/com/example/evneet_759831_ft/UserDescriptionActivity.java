package com.example.evneet_759831_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class UserDescriptionActivity extends AppCompatActivity {


    public static final String TAG = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_description);

        UserDescriptionFragment userDescriptionFragment = (UserDescriptionFragment) getSupportFragmentManager().findFragmentById(R.id.description_frag);
        Intent intent = getIntent();
        int id = intent.getExtras().getInt(TAG);
        userDescriptionFragment.displayDetails(id);
    }
}

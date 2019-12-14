package com.example.evneet_759831_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements Listener{

    private boolean mIsDualPane = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View deatilView = findViewById(R.id.description_frag);
        mIsDualPane = deatilView != null && deatilView.getVisibility() == View.VISIBLE;


    }


    @Override
    public void onItemClick(int id) {

        if(mIsDualPane){
            UserDescriptionFragment userDescriptionFragment = (UserDescriptionFragment) getSupportFragmentManager().findFragmentById(R.id.description_frag);
            userDescriptionFragment.displayDetails(id);

        }else {
            Intent intent = new Intent(this,UserDescriptionActivity.class);
           intent.putExtra(UserDescriptionActivity.TAG,id);

            startActivity(intent);
        }

    }
}

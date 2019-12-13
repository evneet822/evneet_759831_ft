package com.example.evneet_759831_ft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        final EditText name = findViewById(R.id.name);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);

        Button button_save = findViewById(R.id.save_btn);

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name_entered = name.getText().toString();
                String email_entered = email.getText().toString();
                String phone_entered = phone.getText().toString();
                System.out.println(name_entered+"---------"+email_entered+"---------"+phone_entered);

                if (!name.getText().toString().isEmpty()&!email.getText().toString().isEmpty()&!phone.getText().toString().isEmpty()){
                    User u = new User(name_entered,email_entered,phone_entered);
                    User.userDetails.add(u);
                    Toast.makeText(UserDetailsActivity.this, "saved succesfully", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(UserDetailsActivity.this, "you should fill all the feilds", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

package com.example.evneet_759831_ft;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerifyActivity extends AppCompatActivity {
    GridView gridView;
    ImageButton refresh;
    Button verify;
    CheckBox checkBox;
    int rightcount = 0;
    int checkedCount = 0;

    int[] images = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};
    int[] traficImage = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    int[] selectedImages = {0,0,0,0,0,0,0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        gridView = findViewById(R.id.gridView);
        refresh = findViewById(R.id.image_btn);
        verify = findViewById(R.id.button);
        checkBox = findViewById(R.id.check_box);


        final IconAdaptor iconAdaptor = new IconAdaptor(this,images);
        gridView.setAdapter(iconAdaptor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ImageView iv = view.findViewById(R.id.image_view);
                selectedImages[position] = 1;
                 iv.setImageResource(R.drawable.checked);
                System.out.println("position"+position);
                System.out.println("size"+selectedImages.length);

                 for (int i = 0; i<selectedImages.length;i++){
                     System.out.println(selectedImages[i]);
                 }



            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int a = 0; a < 5 ; a++){

                    int t = images[a];
                    images[a] = images[a+2];
                    images[a+2] = t;

                }

                gridView.setAdapter(iconAdaptor);
                iconAdaptor.notifyDataSetChanged();


            }
        });
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < selectedImages.length;i++){
                    System.out.println("inside first for loop");
                    if (selectedImages[i] == 1){
                        checkedCount += 1;
                        for (int j = 0 ;j < traficImage.length;j++){
                            System.out.println("inside second for loop");
                            if (images[i] == traficImage[j]){
                                rightcount += 1;
                            }
                        }
                    }
                }

                if (checkedCount == 4 && rightcount == 4 && checkBox.isChecked()){
                    AlertDialog alertDialog = new AlertDialog.Builder(VerifyActivity.this).create();
                    alertDialog.setTitle("Verified");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = getIntent();
                            User user = (User) intent.getSerializableExtra("user");
                            User.userDetails.add(user);
                            Intent intent1 = new Intent(VerifyActivity.this,MainActivity.class);
                            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent1);
                        }
                    });
                    alertDialog.show();

                }else {
                    AlertDialog alertDialog = new AlertDialog.Builder(VerifyActivity.this).create();
                    alertDialog.setTitle("Not Verified");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent1 = new Intent(VerifyActivity.this,MainActivity.class);
                            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent1);
                        }
                    });
                    alertDialog.show();
                }


            }
        });
    }
}

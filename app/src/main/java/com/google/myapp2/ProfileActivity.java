package com.google.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity {
    private Button btn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btn_logout = (Button)findViewById(R.id.button_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent i =new Intent(ProfileActivity.this, LoginActivity1.class);
                startActivity(i);
            }
        });
    }
//    public void checkLogout (View view){
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(ProfileActivity.this, LoginActivity1.class));
//            }
//        }, 2000);
//    }
}
package com.google.myapp2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity1 extends AppCompatActivity {
    private ImageButton btn_login;
    private Button btn_goto_register;
    private EditText edUserName,edPassWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        edUserName =findViewById(R.id.et_username);
        edPassWord =findViewById(R.id.et_password);


        btn_login = findViewById(R.id.btn_login);
        btn_goto_register = findViewById(R.id.btn_goto_register);
        btn_goto_register.setOnClickListener(new View.OnClickListener() {
            String strU,strP;
            @Override
            public void onClick(View view) {

                Intent i =new Intent(LoginActivity1.this,SignupActivity.class);
                startActivity(i);
            }
        });

    }
    public int isLogin(String u,String p){
        if(u.equals("admin")&& p.equals("admin")){
            return 1;
        }else {
            return  01;
        }
    }
    String strU,strP;
    public void checkLogin(View view) {
        strU = edUserName.getText().toString();
        strP = edPassWord.getText().toString();
        if (strU.isEmpty() || strP.isEmpty()){
            Toast.makeText(getApplicationContext(),"U.P khong duco de trong",Toast.LENGTH_SHORT).show();
        }else
        {
            if(isLogin(strU,strP)>0)
            {
                Toast.makeText(getApplicationContext(),"Login thanh cong",Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(LoginActivity1.this,MainActivity.class ));
                    }
                },2000);
            }
            else{
                Toast.makeText(getApplicationContext(),"Sai User,Pass",Toast.LENGTH_LONG).show();
            }
        }
    }
}
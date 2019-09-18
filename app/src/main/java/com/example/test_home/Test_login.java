package com.example.test_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Test_login extends AppCompatActivity implements  View.OnClickListener{
    TextView TextView;
    Button Button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);
        TextView=(TextView)findViewById(R.id.TextView); //회원가입
        Button1=(Button)findViewById(R.id.login); //로그인
        TextView.setOnClickListener(this);
        Button1.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.TextView) {
            Intent intent = new Intent(getApplicationContext(), Test_join.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(), friends_list.class);
            startActivity(intent);
        }
    }
}

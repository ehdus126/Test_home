package com.example.test_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mButton;
    Button mButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.button);
        mButton1 = (Button)findViewById(R.id.button2);
        mButton.setOnClickListener(this);
        mButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.button) {
            Intent intent = new Intent(getApplicationContext(), Test_login.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(getApplicationContext(), Test_join.class);
            startActivity(intent);
        }
    }

    public void join(View v)
    {
        Toast.makeText(getApplicationContext(),"회원가입",Toast.LENGTH_LONG).show();
        finish();
    }
}

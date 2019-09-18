package com.example.test_home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Test_join extends AppCompatActivity {
    Button Button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_join);
        Button=(Button)findViewById(R.id.join);
        Button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.join) {
                    Toast.makeText(getApplicationContext(),"회원가입이 완료 되었습니다!",Toast.LENGTH_LONG).show();;
                    Intent intent = new Intent(getApplicationContext(), Test_login.class);
                    startActivity(intent);
                }
            }
        });
    }

}

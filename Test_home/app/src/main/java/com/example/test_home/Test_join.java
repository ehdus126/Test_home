package com.example.test_home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.test_home.model.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Test_join extends AppCompatActivity {
    private EditText email;
    private EditText name;
    private EditText password;
    private Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_join);
        email = (EditText) findViewById(R.id.signup_email);
        name = (EditText) findViewById(R.id.signup_name);
        password = (EditText) findViewById(R.id.signup_password);
        signup = (Button) findViewById(R.id.signup_signup);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString() == null || name.getText().toString() == null || password.getText().toString() == null){
                    return;
                }
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(Test_join.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                UserModel userModel = new UserModel();
                                userModel.userName = name.getText().toString();
                                String uid = task.getResult().getUser().getUid();
                                FirebaseDatabase.getInstance().getReference().child("users").child(uid).setValue(userModel);

                            }
                        });
            }
        });
    }
}

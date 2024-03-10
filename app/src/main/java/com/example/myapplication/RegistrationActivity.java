package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText userName, userEmail, userPassword;
    private Button register;
    private TextView userLogin;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        userName = (EditText)findViewById(R.id.etUserName);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        register = (Button) findViewById(R.id.btnRegister);
        userLogin = (TextView) findViewById(R.id.tvLogin);

        firebaseAuth = FirebaseAuth.getInstance();



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = check();
                if(x==1)
                {
                    String email = userEmail.getText().toString().trim();
                    String password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(RegistrationActivity.this, "Registration Successful",Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity( new Intent(RegistrationActivity.this,MainActivity.class));

                            }

                            else
                            {
                                Toast.makeText(RegistrationActivity.this, "Registration Failed",Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                    // FIREBASE//
                }

            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });

    }
    private int check()
    {
        int result=0;
        String name= userName.getText().toString();
        String email= userEmail.getText().toString();
        String password= userPassword.getText().toString();
        if(name.isEmpty()||email.isEmpty()||password.isEmpty())
        {
            Toast.makeText(this,"Please fill all the details", Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=1;
        }
        return result;
    }

}

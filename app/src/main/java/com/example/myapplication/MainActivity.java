package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText Email;
    private EditText Password;
    private Button Login;
    private TextView reg;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email= (EditText)findViewById(R.id.etEmail);
        Password= (EditText)findViewById(R.id.etPassword);
        Login= (Button) findViewById(R.id.btnLogin);
        reg=(TextView)findViewById(R.id.tvRegister);
        progressDialog = new ProgressDialog(this);


        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if(user!=null)
        {

            finish();
            startActivty(new Intent(MainActivity.this,SecondActivity.class));

        }

    Login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            validate(Email.getText().toString(),Password.getText().toString());

            if(Email.getText().toString().isEmpty()||Password.getText().toString().isEmpty())
            {
                Toast.makeText(MainActivity.this, " Login Failed",Toast.LENGTH_SHORT).show();

            }

        }
    });

    reg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this,RegistrationActivity.class));
        }
    });

    }

    private void startActivty(Intent intent) {
    }

    private void validate(String username , String userpassword)
    {

        progressDialog.setMessage("Verifying");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(username,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if(task.isSuccessful())
                {
                    startActivity(new Intent(MainActivity.this,SecondActivity.class));
                    Toast.makeText(MainActivity.this, " Logged in Successfully",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Toast.makeText(MainActivity.this, " Login Failed",Toast.LENGTH_SHORT).show();

                }
            }

        });





    }
}

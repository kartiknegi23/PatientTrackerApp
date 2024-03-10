package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ThirdActivity extends AppCompatActivity {

    private EditText FirstName, LastName,Age,Gender,MaritalStatus,Occupation,HealthProblem,BloodGroup;
    private Button Save;
    private FirebaseAuth firebaseAuth;
    String firstname,lastname,age,gender,maritalstatus,occupation,healthproblem,bloodgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        FirstName=(EditText)findViewById(R.id.etFirstName);
        LastName=(EditText)findViewById(R.id.etLastName);
        Age=(EditText)findViewById(R.id.etAge);
        Gender=(EditText)findViewById(R.id.etGender);
        MaritalStatus=(EditText)findViewById(R.id.etMaritalStatus);
        Occupation=(EditText)findViewById(R.id.etOccupation);
        HealthProblem=(EditText)findViewById(R.id.etHealthProblem);
        BloodGroup=(EditText)findViewById(R.id.etBloodGroup);
        Save=(Button)findViewById(R.id.btnSave);
        firebaseAuth = FirebaseAuth.getInstance();

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = check();
                if(x==1)
                {
                     firstname = FirstName.getText().toString().trim();
                     lastname = LastName.getText().toString().trim();
                     age = Age.getText().toString().trim();
                     gender = Gender.getText().toString().trim();
                     maritalstatus = MaritalStatus.getText().toString().trim();
                     occupation = Occupation.getText().toString().trim();
                     healthproblem = HealthProblem.getText().toString().trim();
                     bloodgroup = BloodGroup.getText().toString().trim();

                 senduserdata();
                    Toast.makeText(ThirdActivity.this,"Data Saved", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(ThirdActivity.this,SecondActivity.class));
                }


            }
        });

    }

    private void senduserdata()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());
        UserProfile userprofile= new UserProfile(firstname,lastname,age,gender,maritalstatus,occupation,healthproblem,bloodgroup);
        myRef.setValue(userprofile);
    }

    private int check()
    {
        int result=0;
        String firstname = FirstName.getText().toString();
        String lastname = LastName.getText().toString();
        String age = Age.getText().toString();
        String gender = Gender.getText().toString();
        String maritalstatus = MaritalStatus.getText().toString();
        String occupation = Occupation.getText().toString();
        String healthproblem = HealthProblem.getText().toString();
        String bloodgroup = BloodGroup.getText().toString();


        if(firstname.isEmpty()||lastname.isEmpty()||age.isEmpty()||gender.isEmpty()||maritalstatus.isEmpty()||occupation.isEmpty()||healthproblem.isEmpty()||bloodgroup.isEmpty())
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


package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FourthActivity extends AppCompatActivity {

    private TextView profilefirstame,profilelastname,profileage,profilegender,profilemaritalstatus,profileoccupation,profilehealthproblem,profilebloodgroup;
    private Button goback;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        profilefirstame = (TextView)findViewById(R.id.tvProfileFirstName);
        profilelastname = (TextView)findViewById(R.id.tvProfileLastName);
        profileage = (TextView)findViewById(R.id.tvProfileAge);
        profilegender = (TextView)findViewById(R.id.tvProfileGender);
        profilemaritalstatus = (TextView)findViewById(R.id.tvProfileMaritalStatus);
        profileoccupation = (TextView)findViewById(R.id.tvProfileOccupation);
        profilehealthproblem = (TextView)findViewById(R.id.tvProfileHealthProblem);
        profilebloodgroup = (TextView)findViewById(R.id.tvProfileBloodGrouo);
        goback = (Button) findViewById(R.id.btngoback);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());


        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(FourthActivity.this,SecondActivity.class));
            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            UserProfile userProfile = dataSnapshot.getValue(UserProfile.class);

                profilefirstame.setText("First Name :"+userProfile.getFirstName());
                profilelastname.setText("Last Name :"+userProfile.getLastName());
                profileage.setText("Age :"+userProfile.getAge());
                profilegender.setText("Gender:"+userProfile.getGender());
                profilemaritalstatus.setText("Marital Status  :"+userProfile.getMaritalStatus());
                profileoccupation.setText("Occupation :"+userProfile.getOccupation());
                profilehealthproblem.setText("Health Problem :"+userProfile.getHealthProblem());
                profilebloodgroup.setText("Blood Group :"+userProfile.getBloodGroup());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

                Toast.makeText(FourthActivity.this, databaseError.getCode(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}

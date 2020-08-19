package com.example.offlineproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    DatabaseReference database;
    private EditText email,newpassword,confirmpassword,firstname,lastname,dateofbirth;
    private ProgressBar progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        database= FirebaseDatabase.getInstance().getReference("Users");

        email=(EditText) findViewById(R.id.email);
        newpassword=(EditText) findViewById(R.id.newpassword);
        confirmpassword=(EditText) findViewById(R.id.confirmpassword);
        firstname=(EditText) findViewById(R.id.firstname);
        lastname=(EditText) findViewById(R.id.lastname);
        dateofbirth=(EditText) findViewById(R.id.dateofbirth);
        progress=(ProgressBar) findViewById(R.id.progress);
    }

    public void saveData(){
        String emailstring=email.getText().toString();
        String newpasswordstring=newpassword.getText().toString();
        String confirmpasswordstring=confirmpassword.getText().toString();
        String firstnamestring=firstname.getText().toString();
        String lastnamestring=lastname.getText().toString();
        String dateofbirthstring=dateofbirth.getText().toString();

        Users id= new Users(firstnamestring,lastnamestring,dateofbirthstring);
        String key = database.push().getKey();
        database.child(key).setValue(id);

    }


    public void register(View v){
        String emailstring=email.getText().toString();
        String newpasswordstring=newpassword.getText().toString();
        String confirmpasswordstring=confirmpassword.getText().toString();
        String firstnamestring=firstname.getText().toString();
        String lastnamestring=lastname.getText().toString();
        String dateofbirthstring=dateofbirth.getText().toString();

        if(!newpasswordstring.equals(confirmpasswordstring)){
            confirmpassword.setError("Password doesn't match!");
            confirmpassword.requestFocus();
            return;
        }
        else if(newpasswordstring.length()<6){
            newpassword.setError("At least 6 letters!");
            newpassword.requestFocus();
            return;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailstring).matches()){
            email.setError("Invalid Address");
            email.requestFocus();
            return;
        }
        progress.setVisibility(View.VISIBLE);


        mAuth.createUserWithEmailAndPassword(emailstring,newpasswordstring).addOnCompleteListener(SignUp.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progress.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), " Sign up successful", Toast.LENGTH_LONG).show();
                    saveData();
                } else {
                    Toast.makeText(getApplicationContext(), " Sign up failed", Toast.LENGTH_LONG).show();
                }
                Intent loginintent=new Intent(SignUp.this,MainActivity.class);
                startActivity(loginintent);
                finish();
            }
        });

    }
}

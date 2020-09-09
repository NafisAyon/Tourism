package com.example.offlineproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    static int a=0;
    private Button loginButton;
    private EditText email,password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        if(a++<=0)
        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String emailstring=email.getText().toString();
        String passwordstring=password.getText().toString();

        if(passwordstring.length()<6){
            password.setError("At least 6 letters!");
            password.requestFocus();
            return;
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(emailstring).matches()){
            email.setError("Invalid Address");
            email.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(emailstring, passwordstring).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Intent loginIntent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(loginIntent);
                    mAuth.signOut();
                    finish();
                }
                else {
                    Toast.makeText(MainActivity.this, " Log in failed", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    static int backpress=0;
    public void onBackPressed(){
        backpress = (backpress + 1);
        Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

        if (backpress>1) {
            this.finish();
        }
    }
    public void SignUp(View v) {
        Toast.makeText(getApplicationContext(), " Signing Up...", Toast.LENGTH_SHORT).show();
        Intent signupIntent = new Intent(MainActivity.this, SignUp.class);
        startActivity(signupIntent);
        finish();
    }

}

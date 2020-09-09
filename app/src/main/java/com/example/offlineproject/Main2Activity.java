package com.example.offlineproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    Button logout;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Toast.makeText(Main2Activity.this, "Login Successful", Toast.LENGTH_SHORT).show();

        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);
    }

    public void currenyconvert(View v){
        Intent currency= new Intent(Main2Activity.this,currencyconverter.class);
        startActivity(currency);
    }

    public void weather(View v){
        Intent weather= new Intent(Main2Activity.this,weather.class);
        startActivity(weather);
    }


    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onClick(View v) {
        Intent logoutIntent = new Intent(Main2Activity.this, MainActivity.class);
        startActivity(logoutIntent);
        mAuth.signOut();
        finish();
    }

    static int backpress=0;
    public void onBackPressed(){
        backpress = (backpress + 1);
        Toast.makeText(getApplicationContext(), " Press Back again to Exit ", Toast.LENGTH_SHORT).show();

        if (backpress>1) {
            this.finish();
        }
    }
}
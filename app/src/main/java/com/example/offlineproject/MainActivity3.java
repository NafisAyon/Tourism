package com.example.offlineproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.offlineproject.R.*;

public class MainActivity3 extends AppCompatActivity{

    private CardView editCard,weatherCard,placesCard,currencyCard,ratingsCard;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main_3);

        Toast.makeText(MainActivity3.this, "Login Successful", Toast.LENGTH_SHORT).show();

        editCard = (CardView)findViewById(id.edit_id);
        currencyCard = (CardView)findViewById(id.currency_id);
        weatherCard = (CardView)findViewById(id.weather_id);
        placesCard = (CardView)findViewById(id.place_id);
        ratingsCard = (CardView)findViewById(id.ratings_id);

    }

    public void currenyconvert(View v){
        Intent currency= new Intent(MainActivity3.this,currencyconverter.class);
        startActivity(currency);
    }

    public void weather(View v){
        Intent weather= new Intent(MainActivity3.this,weather.class);
        startActivity(weather);
    }

    public void rate(View v){
        Intent rate= new Intent(MainActivity3.this,rate.class);
        startActivity(rate);
    }

    public void logout(View v) {
        Intent logoutIntent = new Intent(MainActivity3.this, MainActivity.class);
        startActivity(logoutIntent);
        //mAuth.signOut();
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
package com.example.offlineproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import hotchemi.android.rate.AppRate;

public class rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);

        AppRate.with(this)
                .setInstallDays(0)
                .setLaunchTimes(0)
                .setRemindInterval(0)
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
    }
}
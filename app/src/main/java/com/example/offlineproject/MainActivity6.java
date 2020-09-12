package com.example.offlineproject;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity6 extends AppCompatActivity
{
  GridView grid;

    int icons[]=
            {
                    R.drawable.a,
                    R.drawable.b,
                    R.drawable.c,
                    R.drawable.d,
                    R.drawable.e,
                    R.drawable.f,
                    R.drawable.g,
                    R.drawable.h,
                    R.drawable.i
            };
    String name[]={"London","Paris","Rome","Barcelona","Turkey","Delhi","Croatia","NewYork","Dubai"};


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_6);

        grid=(GridView)findViewById(R.id.datagrid);
        gridAdapter obj=new gridAdapter(this,name,icons);
        grid.setAdapter(obj);
    }
}

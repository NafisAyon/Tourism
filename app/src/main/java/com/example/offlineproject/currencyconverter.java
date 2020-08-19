package com.example.offlineproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class currencyconverter extends AppCompatActivity {
    Button button;
    EditText currencyToBeConverted;
    EditText currencyConverted;
    Spinner convertToDropdown;
    Spinner convertFromDropdown;

    static double[][] multiplier=new double[11][11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currencyconverter);

        //Initialization
        currencyConverted = (EditText) findViewById(R.id.currency_converted);
        currencyToBeConverted = (EditText) findViewById(R.id.currency_to_be_converted);
        convertToDropdown = (Spinner) findViewById(R.id.convert_to);
        convertFromDropdown = (Spinner) findViewById(R.id.convert_from);
        button = (Button) findViewById(R.id.button);


        initialize();



        //Adding Functionality
        String[] dropDownList = {"01.Aus.Dollar", "02.Taka","03.Yuan","04.Euro","05.HK.Dollar","06.Rupee","07.Ringgit","08.Nep.Rupee","09.Riyal","10.Dollar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        convertToDropdown.setAdapter(adapter);
        convertFromDropdown.setAdapter(adapter);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int from=Integer.parseInt(convertFromDropdown.getSelectedItem().toString().substring(0,2));
            int to=Integer.parseInt(convertToDropdown .getSelectedItem().toString().substring(0,2));
            double currency=Double.parseDouble(currencyToBeConverted.getText().toString());
            currency=currency*multiplier[from][to];
            currencyConverted.setText(String.valueOf(currency));

        }
    });



    }
    public void initialize(){
        multiplier[1][1]=1;multiplier[1][2]=60.89;multiplier[1][3]=4.99;multiplier[1][4]=0.61;multiplier[1][5]=5.55;multiplier[1][6]=53.68;multiplier[1][7]=3;multiplier[1][8]=86.06;multiplier[1][9]=2.69;multiplier[1][10]=.72;

        multiplier[2][1]=.016;multiplier[2][2]=1;multiplier[2][3]=.082;multiplier[2][4]=.01;multiplier[2][5]=.091;multiplier[2][6]=0.88;multiplier[2][7]=.049;multiplier[2][8]=1.41;multiplier[2][9]=.044;multiplier[2][10]=0.012;

        multiplier[3][1]=.20;multiplier[3][2]=12.20;multiplier[3][3]=1;multiplier[3][4]=.12;multiplier[3][5]=1.11;multiplier[3][6]=10.76;multiplier[3][7]=.60;multiplier[3][8]=17.25;multiplier[3][9]=.54;multiplier[3][10]=0.14;

        multiplier[4][1]=1.65;multiplier[4][2]=100.26;multiplier[4][3]=8.22;multiplier[4][4]=1;multiplier[4][5]=9.14;multiplier[4][6]=88.39;multiplier[4][7]=4.94;multiplier[4][8]=149.69;multiplier[4][9]=4.42;multiplier[4][10]=1.18;

        multiplier[5][1]=.18;multiplier[5][2]=10.95;multiplier[5][3]=.9;multiplier[5][4]=.11;multiplier[5][5]=1;multiplier[5][6]=9.67;multiplier[5][7]=.54;multiplier[5][8]=15.45;multiplier[5][9]=.48;multiplier[5][10]=0.13;

        multiplier[6][1]=.019;multiplier[6][2]=1.13;multiplier[6][3]=.093;multiplier[6][4]=.011;multiplier[6][5]=.10;multiplier[6][6]=1;multiplier[6][7]=.056;multiplier[6][8]=1.60;multiplier[6][9]=.050;multiplier[6][10]=0.013;

        multiplier[7][1]=.33;multiplier[7][2]=20.23;multiplier[7][3]=1.66;multiplier[7][4]=.20;multiplier[7][5]=1.85;multiplier[7][6]=17.85;multiplier[7][7]=1;multiplier[7][8]=28.53;multiplier[7][9]=.89;multiplier[7][10]=0.24;

        multiplier[8][1]=.012;multiplier[8][2]=.71;multiplier[8][3]=.058;multiplier[8][4]=.0071;multiplier[8][5]=.065;multiplier[8][6]=.063;multiplier[8][7]=.035;multiplier[8][8]=1;multiplier[8][9]=.031;multiplier[8][10]=0.0084;

        multiplier[9][1]=.37;multiplier[9][2]=22.63;multiplier[9][3]=1.86;multiplier[9][4]=.23;multiplier[9][5]=2.07;multiplier[9][6]=19.97;multiplier[9][7]=1.12;multiplier[9][8]=31.92;multiplier[9][9]=1;multiplier[9][10]=0.27;

        multiplier[10][1]=1.40;multiplier[10][2]=84.87;multiplier[10][3]=6.96;multiplier[10][4]=.85;multiplier[10][5]=7.75;multiplier[10][6]=74.90;multiplier[10][7]=4.20;multiplier[10][8]=119.71;multiplier[10][9]=3.75;multiplier[10][10]=1;

    }

}

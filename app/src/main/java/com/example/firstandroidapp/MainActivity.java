package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    ArrayList<Integer> answers= new ArrayList<Integer>();

    public void chooseAnswer(View view){

    }

    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=findViewById(R.id.goButton);
        TextView sumTextView= findViewById(R.id.sumTextView);

        Random rand= new Random();


        int a= rand.nextInt(21);
        int b= rand.nextInt(21);

       sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));


    }
}

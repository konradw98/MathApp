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
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score=0;
    int numberOfQuestions=0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;

    public void chooseAnswer(View view){
      if( Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
        resultTextView.setText("Correct!");

        score++;
      }  else {resultTextView.setText("Wrong!");}
      numberOfQuestions++;
      scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
    }

    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);

    }

    public void newQuestion(){


        Random rand= new Random();


        int a= rand.nextInt(21);
        int b= rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));


        locationOfCorrectAnswer=rand.nextInt(4);

        for(int i=0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            } else {
                int wrongAnswer=rand.nextInt(41);
                while(wrongAnswer==a+b){
                    wrongAnswer=rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }

        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goButton=findViewById(R.id.goButton);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        sumTextView= findViewById(R.id.sumTextView);
        resultTextView=findViewById(R.id.resultTextView);
        scoreTextView=findViewById(R.id.scoreTextView);

      newQuestion();
    }
}

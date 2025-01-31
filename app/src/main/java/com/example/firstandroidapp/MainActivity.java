package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
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
    Button button4;
    Button button5;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;

    public void playAgain(View view){
        score=0;
        numberOfQuestions=0;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        timerTextView.setText("15s");
        newQuestion();
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        new CountDownTimer(15100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText( String.valueOf(millisUntilFinished/1000)+"s");

            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                resultTextView.setTextColor(Color.parseColor("#ff000000"));
                playAgainButton.setVisibility(View.VISIBLE);
            }
        }.start();
    }




    public void chooseAnswer(View view){
      if( Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
        resultTextView.setText("Correct!");
        resultTextView.setTextColor(Color.parseColor("#4CAF50"));
        score++;
      }  else {resultTextView.setText("Wrong!");
          resultTextView.setTextColor(Color.parseColor("#F44336"));}
      numberOfQuestions++;
      scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
      newQuestion();
    }



    public void newQuestion(){
        Random rand= new Random();
        locationOfCorrectAnswer=rand.nextInt(6);
        answers.clear();


        int operation=rand.nextInt(3);

       if(operation==0){
           int a= rand.nextInt(51);
           int b= rand.nextInt(51);

           sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));



           for(int i=0;i<6;i++){
               if(i==locationOfCorrectAnswer){
                   answers.add(a+b);
               } else {
                   int wrongAnswer=rand.nextInt(101);
                   while(wrongAnswer==a+b){
                       wrongAnswer=rand.nextInt(101);
                   }
                   answers.add(wrongAnswer);
               } }
       }

        if(operation==1){
            int a= rand.nextInt(11);
            int b= rand.nextInt(11);

            sumTextView.setText(Integer.toString(a)+" * "+Integer.toString(b));



            for(int i=0;i<6;i++){
                if(i==locationOfCorrectAnswer){
                    answers.add(a*b);
                } else {
                    int wrongAnswer=rand.nextInt(101);
                    while(wrongAnswer==a*b){
                        wrongAnswer=rand.nextInt(101);
                    }
                    answers.add(wrongAnswer);
                } }

        }





        if(operation==2){
            int a= 50+ rand.nextInt(51);
            int b= rand.nextInt(51);

            sumTextView.setText(Integer.toString(a)+" - "+Integer.toString(b));



            for(int i=0;i<6;i++){
                if(i==locationOfCorrectAnswer){
                    answers.add(a-b);
                } else {
                    int wrongAnswer=rand.nextInt(101);
                    while(wrongAnswer==a-b){
                        wrongAnswer=rand.nextInt(101);
                    }
                    answers.add(wrongAnswer);
                } }

        }
        
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
        button4.setText(Integer.toString(answers.get(4)));
        button5.setText(Integer.toString(answers.get(5)));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        sumTextView= findViewById(R.id.sumTextView);
        resultTextView=findViewById(R.id.resultTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        timerTextView=findViewById(R.id.timerTextView);
        playAgainButton=findViewById(R.id.playAgainButton);

      newQuestion();
        playAgain(findViewById(R.id.timerTextView));

}}

package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {
    // Duration of SPLASH SCREEN
    public static final int SPLASH_SCREEN = 2000;
    // ArrayList Container of all the QUESTIONS,OPTIONS AND IMAGE
    public static ArrayList<ModelClass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        allQuestion();

        /*
        here is the inBuild
        Constructor and inBuild Method to hold
        the Screen until the specified duration ended
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },SPLASH_SCREEN);
    }

    /*
    This method contain all the data.
    Like QUESTION,IMAGE AND OPTIONS. All the data
    stored 'list' variable
     */
    private void allQuestion() {
        list = new ArrayList<>();
        list.add(new ModelClass(R.string.first_question,R.string.first_question_option_a,R.string.first_question_option_b,R.string.first_question_option_correct_c,R.string.first_question_option_d,R.drawable.first_image,R.string.first_question_option_correct_c));
        list.add(new ModelClass(R.string.second_question,R.string.second_question_option_a,R.string.second_question_option_b,R.string.second_question_option_correct_c,R.string.second_question_option_d,R.drawable.two_image,R.string.second_question_option_correct_c));
        list.add(new ModelClass(R.string.three_question,R.string.three_question_option_a,R.string.three_question_option_b,R.string.three_question_option_correct_c,R.string.three_question_option_d,R.drawable.three_image,R.string.three_question_option_correct_c));
        list.add(new ModelClass(R.string.four_question,R.string.four_question_option_a,R.string.four_question_option_b,R.string.four_question_option_correct_c,R.string.four_question_option_d,R.drawable.four_image,R.string.four_question_option_correct_c));
        list.add(new ModelClass(R.string.five_question,R.string.five_question_option_a,R.string.five_question_option_b,R.string.five_question_option_correct_c,R.string.five_question_option_d,R.drawable.five_image,R.string.five_question_option_correct_c));
        list.add(new ModelClass(R.string.six_question,R.string.six_question_option_a,R.string.six_question_option_b,R.string.six_question_option_correct_c,R.string.six_question_option_d,R.drawable.six_image,R.string.six_question_option_correct_c));
        list.add(new ModelClass(R.string.seven_question,R.string.seven_question_option_a,R.string.seven_question_option_correct_b,R.string.seven_question_option_c,R.string.seven_question_option_d,R.drawable.seven_image,R.string.seven_question_option_correct_b));

        list.add(new ModelClass(R.string.eight_question,R.string.eight_question_option_a,R.string.eight_question_option_correct_b,R.string.eight_question_option_c,R.string.eight_question_option_d,R.drawable.eight_image,R.string.eight_question_option_correct_b));
        list.add(new ModelClass(R.string.nine_question,R.string.nine_question_option_a,R.string.nine_question_option_b,R.string.nine_question_option_correct_c,R.string.nine_question_option_d,R.drawable.nine_image,R.string.nine_question_option_correct_c));
        list.add(new ModelClass(R.string.ten_question,R.string.ten_question_option_a,R.string.ten_question_option_correct_b,R.string.ten_question_option_c,R.string.ten_question_option_d,R.drawable.ten_image,R.string.ten_question_option_correct_b));
        list.add(new ModelClass(R.string.eleven_question,R.string.eleven_question_option_a,R.string.eleven_question_option_b,R.string.eleven_question_option_c,R.string.eleven_question_option_correct_d,R.drawable.eleven_image,R.string.eleven_question_option_correct_d));
        list.add(new ModelClass(R.string.twelve_question,R.string.twelve_question_option_a,R.string.twelve_question_option_b,R.string.twelve_question_option_c,R.string.twelve_question_option_correct_d,R.drawable.twelve_image,R.string.twelve_question_option_correct_d));
        list.add(new ModelClass(R.string.thirteen_question,R.string.thirteen_question_option_a,R.string.thirteen_question_option_correct_b,R.string.thirteen_question_option_c,R.string.thirteen_question_option_d,R.drawable.thirteen_image,R.string.thirteen_question_option_correct_b));
        list.add(new ModelClass(R.string.fifteen_question,R.string.fifteen_question_option_a,R.string.fifteen_question_option_b,R.string.fifteen_question_option_c,R.string.fifteen_question_option_correct_d,R.drawable.fifteen_image,R.string.fifteen_question_option_correct_d));

        list.add(new ModelClass(R.string.sixteen_question,R.string.sixteen_question_option_a,R.string.sixteen_question_option_b,R.string.sixteen_question_option_c,R.string.sixteen_question_option_correct_d,R.drawable.sixteen_image,R.string.sixteen_question_option_correct_d));
        list.add(new ModelClass(R.string.seventeen_question,R.string.seventeen_question_option_a,R.string.seventeen_question_option_correct_b,R.string.seventeen_question_option_c,R.string.seventeen_question_option_correct_b,R.drawable.seventeen_image,R.string.seventeen_question_option_correct_b));
        list.add(new ModelClass(R.string.eighteen_question,R.string.eighteen_question_option_a,R.string.eighteen_question_option_b,R.string.eighteen_question_option_correct_c,R.string.eighteen_question_option_d,R.drawable.eighteen_image,R.string.eighteen_question_option_correct_c));
        list.add(new ModelClass(R.string.nineteen_question,R.string.nineteen_question_option_a,R.string.nineteen_question_option_correct_b,R.string.nineteen_question_option_c,R.string.nineteen_question_option_d,R.drawable.nineteen_image,R.string.nineteen_question_option_correct_b));
        list.add(new ModelClass(R.string.twenty_question,R.string.twenty_question_option_a,R.string.twenty_question_option_b,R.string.twenty_question_option_correct_c,R.string.twenty_question_option_d,R.drawable.twenty_image,R.string.twenty_question_option_correct_c));

    }
}
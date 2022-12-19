package com.example.quizapp;

import static com.example.quizapp.SplashScreen.list;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private TextView countDown, question, result;
    private TextView optionA, optionB, optionC, optionD;
    private ImageView image;
    private RelativeLayout nextBtn;
    private CircularProgressBar progressBar;
    private Animation animation;


    private CardView optionACard, optionBCard, optionCCard, optionDCard;
    private List<ModelClass> allQuestionList;
    private ModelClass modelClass;

    int position = 0;
    int correctCount = 0;
    int wrongCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        intiView();

        allQuestionList = list;
        Collections.shuffle(allQuestionList);
        modelClass = list.get(position);
        setAllQuestionAndOption();
        nextBtn.setEnabled(false);
        /*
        Show the Counter
         */
        new CountDownTimer(900000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String mDuration = String.format(Locale.ENGLISH, "%02d : %02d"
                        , TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)
                        , TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished)));

                countDown.setText(mDuration);
            }

            @Override
            public void onFinish() {
                timeUpDialog();
            }
        }.start();
    }

    /*
    Set All
    QUESTIONS,OPTIONS and IMAGE
    Function
     */
    private void setAllQuestionAndOption() {
        animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_question_change);
        question.setAnimation(animation);
        optionA.setAnimation(animation);
        optionB.setAnimation(animation);
        optionC.setAnimation(animation);
        optionD.setAnimation(animation);
        image.setAnimation(animation);

        question.setText(modelClass.getQuestion());
        optionA.setText(modelClass.getOptionOne());
        optionB.setText(modelClass.getOptionTwo());
        optionC.setText(modelClass.getOptionThree());
        optionD.setText(modelClass.getOptionFour());

        image.setImageResource(modelClass.getImage());
    }

    /*
    Check Correct
    Answer From the Options Function
     */
    public void checkAisCorrect(View view) {
        nextBtn.setEnabled(true);
        disableBtn();
        if (modelClass.getOptionOne() == modelClass.getOptionCorrect()) {
            optionACard.setCardBackgroundColor(getResources().getColor(R.color.quiz_green));
            if (position < list.size() - 1) {
                correct(optionACard);
            }
        } else {
            wrong(optionACard);
        }

    }

    public void checkBisCorrect(View view) {
        nextBtn.setEnabled(true);
        disableBtn();
        if (modelClass.getOptionTwo() == modelClass.getOptionCorrect()) {
            optionBCard.setCardBackgroundColor(getResources().getColor(R.color.quiz_green));
            if (position < list.size() - 1) {
                correct(optionBCard);
            }
        } else {
            wrong(optionBCard);
        }
    }

    public void checkCisCorrect(View view) {
        nextBtn.setEnabled(true);
        disableBtn();
        if (modelClass.getOptionThree() == modelClass.getOptionCorrect()) {
            optionCCard.setCardBackgroundColor(getResources().getColor(R.color.quiz_green));
            if (position < list.size() - 1) {
                correct(optionCCard);
            }
        } else {
            wrong(optionCCard);
        }
    }

    public void checkDisCorrect(View view) {
        disableBtn();
        nextBtn.setEnabled(true);
        if (modelClass.getOptionFour() == modelClass.getOptionCorrect()) {
            optionDCard.setCardBackgroundColor(getResources().getColor(R.color.quiz_green));
            if (position < list.size() - 1) {
                correct(optionDCard);

            }
        } else {
            wrong(optionDCard);
        }
    }

    /*
    All Card Button
    Enable and Disable Function
     */
    private void enabledBtn() {
        optionACard.setEnabled(true);
        optionBCard.setEnabled(true);
        optionCCard.setEnabled(true);
        optionDCard.setEnabled(true);
    }

    private void disableBtn() {
        optionACard.setEnabled(false);
        optionBCard.setEnabled(false);
        optionCCard.setEnabled(false);
        optionDCard.setEnabled(false);
    }

    /*
     Count How many
     correct Answer & Wrong Answer
     Function
     */
    private void correct(CardView cardView) {
        cardView.setCardBackgroundColor(getResources().getColor(R.color.quiz_green));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctCount++;
                if (position < list.size() - 1) {
                    position++;
                    modelClass = list.get(position);
                    setAllQuestionAndOption();
                    enabledBtn();
                    resetColor();
                    questionCountInProgressBar();

                } else {
                    resultDialog();
                }
            }
        });
    }

    private void wrong(CardView cardView) {
        cardView.setCardBackgroundColor(getResources().getColor(R.color.quiz_wrong_color));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongCount++;
                if (position < list.size() - 1) {
                    position++;
                    modelClass = list.get(position);
                    setAllQuestionAndOption();
                    resetColor();
                    enabledBtn();
                    questionCountInProgressBar();
                } else {
                    resultDialog();
                }
            }
        });
    }

    /*
      Check How many
      QUESTION are there.
      Shown in Progress Bar Function
     */
    private void questionCountInProgressBar() {
        progressBar.setProgress(position);
        result.setText(position + "/" + list.size());

    }

    /*
    Reset
    Color of CardView
    Button Function
     */
    private void resetColor() {
        optionACard.setCardBackgroundColor(getResources().getColor(R.color.white));
        optionBCard.setCardBackgroundColor(getResources().getColor(R.color.white));
        optionCCard.setCardBackgroundColor(getResources().getColor(R.color.white));
        optionDCard.setCardBackgroundColor(getResources().getColor(R.color.white));
    }

    /*
    Here is the
    Result & Time Up
    DIALOG Function
     */
    private void resultDialog() {

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.result_layout);
        // Progress Bar Count
        CircularProgressBar circularProgressBar = dialog.findViewById(R.id.dialog_progress_circular);
        circularProgressBar.setProgress(correctCount);
        // Result Count
        TextView dialogResult = dialog.findViewById(R.id.dialog_result);
        dialogResult.setText(correctCount + "/" + list.size());

        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.findViewById(R.id.dialog_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SplashScreen.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }

    private void timeUpDialog() {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
        dialog.setContentView(R.layout.diolog_time_out);
        dialog.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SplashScreen.class);
                startActivity(intent);
            }
        });

        dialog.show();
    }

    /*
    Initialize All
    View Id's Function
     */
    private void intiView() {
        // Hooks
        countDown = findViewById(R.id.timer_text);
        nextBtn = findViewById(R.id.nextBtn);
        question = findViewById(R.id.question);
        // Options TextView Initialize
        optionA = findViewById(R.id.option_a);
        optionB = findViewById(R.id.option_b);
        optionC = findViewById(R.id.option_c);
        optionD = findViewById(R.id.option_d);

        // image Hooks
        image = findViewById(R.id.image);

        // CardView Initialize
        optionACard = findViewById(R.id.option_a_card);
        optionBCard = findViewById(R.id.option_b_card);
        optionCCard = findViewById(R.id.option_c_card);
        optionDCard = findViewById(R.id.option_d_card);

        progressBar = findViewById(R.id.circularProgressBar);
        result = findViewById(R.id.result);
    }
}
package com.miguelcr.a01_randomdice;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    TextView tvPoints, tvName, tvTimer, tvNumber1, tvNumber2, tvNumber3;
    ImageView ivDice;
    Random random;
    int solution;
    int points = 0;
    boolean gameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Get references for all the view components
        tvPoints = (TextView) findViewById(R.id.text_view_points);
        tvName = (TextView) findViewById(R.id.text_view_player_name);
        tvTimer = (TextView) findViewById(R.id.text_view_timer);
        tvNumber1 = (TextView) findViewById(R.id.text_view_number_1);
        tvNumber2 = (TextView) findViewById(R.id.text_view_number_2);
        tvNumber3 = (TextView) findViewById(R.id.text_view_number_3);
        ivDice = (ImageView) findViewById(R.id.image_view_dice);

        // Random dice number
        random = new Random();

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                tvTimer.setText(millisUntilFinished / 1000 + "s");
            }

            public void onFinish() {
                tvTimer.setText("Game over!");
                gameOver = true;
            }
        }.start();

        generateNewRandomGame();

    }

    private void generateNewRandomGame() {
        if(gameOver) {
            Toast.makeText(this, "Sorry, the play is Game Over!", Toast.LENGTH_SHORT).show();
        } else {
            int randomValue = random.nextInt(6 - 1 + 1) + 1;
            solution = randomValue;

            switch (randomValue) {
                case 1:
                    ivDice.setImageResource(R.drawable.ic_dice_one);
                    break;
                case 2:
                    ivDice.setImageResource(R.drawable.ic_dice_two);
                    break;
                case 3:
                    ivDice.setImageResource(R.drawable.ic_dice_three);
                    break;
                case 4:
                    ivDice.setImageResource(R.drawable.ic_dice_four);
                    break;
                case 5:
                    ivDice.setImageResource(R.drawable.ic_dice_five);
                    break;
                case 6:
                    ivDice.setImageResource(R.drawable.ic_dice_six);
                    break;
            }


            int randomAnswerPosition = random.nextInt(3 - 1 + 1) + 1;

            // RANDOM 2
            int randomValue2 = random.nextInt(6 - 1 + 1) + 1;

            // While we have the same number for the second TextView
            // we must to generate another different number.
            while (randomValue2 == randomValue) {
                randomValue2 = random.nextInt(6 - 1 + 1) + 1;
            }

            // RANDOM 3
            int randomValue3 = random.nextInt(6 - 1 + 1) + 1;
            while (randomValue3 == randomValue || randomValue3 == randomValue2) {
                randomValue3 = random.nextInt(6 - 1 + 1) + 1;
            }


            switch (randomAnswerPosition) {
                case 1:
                    tvNumber1.setText(String.valueOf(randomValue));
                    tvNumber2.setText(String.valueOf(randomValue2));
                    tvNumber3.setText(String.valueOf(randomValue3));
                    break;

                case 2:
                    tvNumber1.setText(String.valueOf(randomValue2));
                    tvNumber2.setText(String.valueOf(randomValue));
                    tvNumber3.setText(String.valueOf(randomValue3));
                    break;

                case 3:
                    tvNumber1.setText(String.valueOf(randomValue2));
                    tvNumber2.setText(String.valueOf(randomValue3));
                    tvNumber3.setText(String.valueOf(randomValue));
                    break;
            }
        }
    }

    public void numberClicked(View view) {
        // generate a new random dice
        if(gameOver) {
            Toast.makeText(this, "Sorry, Game is Over!", Toast.LENGTH_SHORT).show();
        } else {
            TextView textViewClicked = (TextView) view;
            String text = textViewClicked.getText().toString();
            int number = Integer.parseInt(text);
            if(solution==number) {
                // Increase the number of points
                points++;
                tvPoints.setText(String.valueOf(points));
                //Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            } else {
                //Toast.makeText(this, "Sorry, it's not correct!", Toast.LENGTH_SHORT).show();
            }

            generateNewRandomGame();

        }
    }

}

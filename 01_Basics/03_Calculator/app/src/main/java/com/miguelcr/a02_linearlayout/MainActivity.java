package com.miguelcr.a02_linearlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    int number1, number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.textViewScreen);

        screen.setText("0");
    }

    public void calcNumberClicked(View view) {
        int idButtonClicked = view.getId();

        String number = "";

        switch (idButtonClicked) {
            case R.id.button7: number="7"; break;
            case R.id.button8: number="8"; break;
        }

        // Get the text that now is on the screen TextView
        String currentScreenText = screen.getText().toString();
        if(currentScreenText.equals("0")) {
            screen.setText(number);
        } else {
            screen.setText(currentScreenText + number);
        }
    }

    public void deleteLastNumber(View view) {
        String currentScreenText = screen.getText().toString();
        int lengthScreenText = currentScreenText.length();
        String newScreenText = currentScreenText.substring(0,lengthScreenText-1);
        screen.setText(newScreenText);
    }

    public void addOperation(View view) {
        number1 = Integer.parseInt(screen.getText().toString());
        screen.setText("0");
    }

    public void equalOperation(View view) {
        number2 = Integer.parseInt(screen.getText().toString());
        screen.setText(String.valueOf(number1+number2));
    }
}
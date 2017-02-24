package com.miguelcr.a01_randomdice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textViewLogo;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewLogo = (TextView) findViewById(R.id.text_view_logo);
        editTextName = (EditText) findViewById(R.id.editTextName);

        Typeface type = Typeface.createFromAsset(getAssets(),"crayon_font.ttf");
        textViewLogo.setTypeface(type);

        // Hide the toolbar
        getSupportActionBar().hide();

    }

    public void playGame(View view) {
        String name = editTextName.getText().toString();

        if(name.equals("")) {
            Toast.makeText(this, "Write your name please", Toast.LENGTH_SHORT).show();
            editTextName.setError("Write a name");
        } else {
            Intent i = new Intent(this, GameActivity.class);
            i.putExtra("nick", name);
            startActivity(i);
        }
    }
}

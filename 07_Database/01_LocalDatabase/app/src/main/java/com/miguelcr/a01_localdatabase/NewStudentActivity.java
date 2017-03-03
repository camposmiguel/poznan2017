package com.miguelcr.a01_localdatabase;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.miguelcr.a01_localdatabase.localdb.Students;
import com.miguelcr.a01_localdatabase.localdb.StudentsDao;

public class NewStudentActivity extends AppCompatActivity {
    EditText editTextName, editTextAge;
    CheckBox checkBoxRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveStudent();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle("New Student");

        editTextName = (EditText) findViewById(R.id.edit_text_name);
        editTextAge = (EditText) findViewById(R.id.edit_text_age);
        checkBoxRepeat = (CheckBox) findViewById(R.id.checkbox_repeat);
    }

    private void saveStudent() {

        String name = editTextName.getText().toString();
        int age = Integer.parseInt(editTextAge.getText().toString());
        boolean repeat = checkBoxRepeat.isChecked();

        // Save the information in the local database
        StudentsDao studentsDao = DatabaseConnection.getStudentsDao(this);
        Students newStudent = new Students();
        newStudent.setName(name);
        newStudent.setAge(age);
        newStudent.setRepeat(repeat);

        // Insert into
        studentsDao.insert(newStudent);

        // Destroy the current screen
        finish();


    }

}

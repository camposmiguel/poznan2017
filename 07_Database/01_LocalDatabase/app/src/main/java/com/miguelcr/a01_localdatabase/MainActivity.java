package com.miguelcr.a01_localdatabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.miguelcr.a01_localdatabase.localdb.Students;
import com.miguelcr.a01_localdatabase.localdb.StudentsDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<Students> studentsList;
    StudentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lista = (ListView) findViewById(R.id.list_view);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent
                Intent i = new Intent(MainActivity.this,NewStudentActivity.class);
                startActivity(i);
            }
        });

        studentsList = new ArrayList<>();

        // Load from the database all the students that we have saved
        StudentsDao studentsDao = DatabaseConnection.getStudentsDao(this);
        // SELECT * FROM Students > List<Students>
        studentsList = studentsDao.loadAll();


        adapter = new StudentsAdapter(
                this,
                R.layout.student_item,
                studentsList
        );

        lista.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        StudentsDao studentsDao = DatabaseConnection.getStudentsDao(this);
        studentsList.clear();
        studentsList.addAll(studentsDao.loadAll());
        adapter.notifyDataSetChanged();

    }
}

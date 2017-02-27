package com.miguelcr.a01_simplelist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lista;
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        // 1. Get a reference to the ListView component
        lista = (ListView) findViewById(R.id.list_view);

        // 2. Create data in the List<String> students
        students = new ArrayList<>();
        students.add("Dominik");
        students.add("Kacper");
        students.add("Patryk");
        students.add("Karol");
        students.add("Piotr");
        students.add("Mateusz");
        students.add("Patryk");
        students.add("Mikolaj");
        students.add("Adam");
        students.add("Bartek");
        students.add("Filip");
        students.add("Dario");
        students.add("Tomek");
        students.add("Kamil");
        students.add("Bartek");
        students.add("Patryk");

        // 3. Create the Adapter component to connect both
        // elements: ListView + List<String>
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        // 4. Connect ListView lista and the adapter
        lista.setAdapter(adapter);


        lista.setOnItemClickListener(this);

        // Connect lista with ContextMenu
        registerForContextMenu(lista);
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
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String studentClicked = students.get(position);
        Toast.makeText(this, "Clicked: "+ studentClicked, Toast.LENGTH_SHORT).show();

        // Change the textColor in the clicked element
        TextView textViewStudent = (TextView) view;
        textViewStudent.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));

        view.animate().setDuration(2000).rotationXBy(360).start();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
}

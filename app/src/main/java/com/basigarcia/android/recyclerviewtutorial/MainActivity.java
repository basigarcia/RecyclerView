package com.basigarcia.android.recyclerviewtutorial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Tutorial> tutorialList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TutorialsAdapter tutorialsAdapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tutorialList.add(1, new Tutorial("Navigation Drawer", 80001, "Awesome"));
                tutorialsAdapter.notifyItemInserted(1);
            }
        });

        tutorialsAdapter = new TutorialsAdapter(tutorialList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(tutorialsAdapter);

        loadTutorials();
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

    void loadTutorials(){
        tutorialList.add(new Tutorial("Navigation Drawer", 80000, "Awesome"));
        tutorialList.add(new Tutorial("Recycler View", 900, "Great"));
        tutorialList.add(new Tutorial("Gesture Recognition", 8500, "Good"));
        tutorialList.add(new Tutorial("The Toolbar", 20000, "Cool"));
        tutorialList.add(new Tutorial("Overflow Menu", 10000, "Great"));
        tutorialList.add(new Tutorial("Progress Bars", 45000, "Good"));
        tutorialList.add(new Tutorial("Activities", 3000, "Awesome"));
        tutorialList.add(new Tutorial("Navigation Drawer", 80000, "Awesome"));
        tutorialList.add(new Tutorial("Recycler View", 900, "Great"));
        tutorialList.add(new Tutorial("Gesture Recognition", 8500, "Good"));
        tutorialList.add(new Tutorial("The Toolbar", 20000, "Cool"));
        tutorialList.add(new Tutorial("Overflow Menu", 10000, "Great"));
        tutorialList.add(new Tutorial("Progress Bars", 45000, "Good"));
        tutorialList.add(new Tutorial("Activities", 3000, "Awesome"));
        tutorialsAdapter.notifyDataSetChanged();
    }

}

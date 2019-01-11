package com.example.dhruvik.iris_interview;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggleButton;
    RecyclerView recyclerView;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();         // for initialization of the activity view and definition of that view.

        navigationView.setNavigationItemSelectedListener(this);

        // set recycler view at Home activity by using of costume_row

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapter(this));
    }

    private void init(){

        // for initialization of the activity view and definition of that view.

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawer);
        toggleButton = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggleButton);
        toggleButton.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // this function return true if an option item is selected

        if(toggleButton.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        //this function is direct the activity according the item selected in navigation bar.

        int id = menuItem.getItemId();

        switch (id){
            case R.id.company_id :
                startActivity(new Intent(getApplicationContext(),Home.class));
                break;

            case R.id.my_application_id:
                startActivity(new Intent(getApplicationContext(),MyApplicaion.class));
                break;

            case R.id.search_id:
                startActivity(new Intent(getApplicationContext(),Search.class));
                break;

            case R.id.about_iris_id:
                startActivity(new Intent(getApplicationContext(),AboutIris.class));
                break;


            case R.id.feedback_id:
                startActivity(new Intent(getApplicationContext(),Feedback.class));
                break;

        }

        return false;
    }
}

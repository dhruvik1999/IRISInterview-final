package com.example.dhruvik.iris_interview;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggleButton;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        init();

        startActivity(new Intent(this,LodingScreen.class));

        String companyName[]={"Goldman Sanch","Goldman Sanch","Goldman Sanch","Goldman Sanch","Goldman Sanch","Goldman Sanch"};
        String companyType[]={"Dream","Dream","Dream","Dream","Dream","Dream"};
        String jobType[]={"Internship" ,"Internship" ,"Internship" ,"Internship" ,"Internship" ,"Internship" };
        String recruitment_date[]={"18-1-2018","18-1-2018","18-1-2018","18-1-2018","18-1-2018","18-1-2018"};
        String deadline[]={"18-1-2018","18-1-2018","18-1-2018","18-1-2018","18-1-2018","18-1-2018"};

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerAdapterLayout(this,companyName,companyType,jobType,recruitment_date,deadline));
    }

    private void init(){
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        drawerLayout = (DrawerLayout) this.findViewById(R.id.drawer);
        toggleButton = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggleButton);
        toggleButton.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggleButton.onOptionsItemSelected(item)){
                if(item.getItemId() == R.id.db)
                    Toast.makeText(getApplicationContext(),"This is it",Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}

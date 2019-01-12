package com.example.dhruvik.iris_interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Search extends AppCompatActivity {

    Button find_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        // this activity basically helping to the user for finding the companies' information which are registered in NITK IRIS.
        // not available NOW

        init();

        find_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Service is not Available now",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init(){
        find_btn = (Button)this.findViewById(R.id.find);
    }
}

package com.example.dhruvik.iris_interview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LodingScreen extends AppCompatActivity {

    private static final String url = "https://androidtask.iris.nitk.ac.in/hrms/placement/companies.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loding_screen);

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
              //  Log.d("Code" , response);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Detail[] detail= gson.fromJson(response,Detail[].class);

                //Log.d("obj",detail[i] + "");

                for(int i=0;i<detail.length;i++){

                    GsonBuilder comp_name_builder = new GsonBuilder();
                    Gson comp_gson = gsonBuilder.create();
                    Company[] comp_detail= gson.fromJson(response,Company[].class);
                  Log.d("obj",detail[i].getDeadline() + "");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error in connection",Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}

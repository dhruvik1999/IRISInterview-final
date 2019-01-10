package com.example.dhruvik.iris_interview;

import android.content.Intent;
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

                try {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    Detail[] detail = gson.fromJson(response, Detail[].class);

                    //Log.d("obj",detail[i] + "");

                    for (int i = 0; i < detail.length; i++) {

                        DataHelper.company_name.add(detail[i].getCompany().getName());
                        DataHelper.company_type.add(detail[i].getCompany().getCompanyType());
                        DataHelper.rec_date.add(detail[i].getRecruitmentDate());
                        DataHelper.ded_date.add(detail[i].getDeadline());
                        DataHelper.rec_type.add( detail[i].getRecruitmentType());
                        DataHelper.company_url.add(detail[i].getUrl());
                        //Log.d("obj",company.getName() + "");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Internet Connection Error",Toast.LENGTH_LONG).show();
                }finally {
                        startActivity(new Intent(getApplicationContext(),Home.class));
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

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}

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

        //this class is for fetching data from url and store in the DataHelper in different ArrayList<String>
        //String request through volly library .

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    // basically it make object of Detail Class and convert Json response in java objects

                    GsonBuilder gsonBuilder = new GsonBuilder();
                    Gson gson = gsonBuilder.create();
                    Detail[] detail = gson.fromJson(response, Detail[].class);


                    // this loop store all the data in DataHelper class' arrayList by category.

                    for (int i = 0; i < detail.length; i++) {


                        DataHelper.company_name.add(detail[i].getCompany().getName());
                        DataHelper.company_type.add(detail[i].getCompany().getCompanyType());
                        DataHelper.rec_date.add(detail[i].getRecruitmentDate());
                        DataHelper.ded_date.add(detail[i].getDeadline());
                        DataHelper.rec_type.add( detail[i].getRecruitmentType());
                        DataHelper.company_url.add(detail[i].getUrl());
                    }
                }catch (Exception e){

                    //if android device id not connected through internet then toast come up.

                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Internet Connection Error",Toast.LENGTH_LONG).show();
                }finally {

                    //after all data fetching it starts Home activity.

                        startActivity(new Intent(getApplicationContext(),Home.class));
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // if any connection error or response error come up the it will show toast.

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

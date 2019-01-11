package com.example.dhruvik.iris_interview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecyclerAdapterLayout extends RecyclerView.Adapter<RecyclerAdapterLayout.Item> {


    Context context;
    public  RecyclerAdapterLayout(Context context){
        this.context=context;
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.costume_row,parent ,false );

        View v = LayoutInflater.from(context)
                .inflate(R.layout.costume_row, parent, false);

        return new Item(v) ;
    }

    public void onBindViewHolder(@NonNull final Item viewHolder, int i) {
        viewHolder.comp_name.setText(DataHelper.company_name.get(i));
        viewHolder.comp_type.setText(DataHelper.company_type.get(i));
        viewHolder.rec_date.setText(DataHelper.rec_date.get(i));
        viewHolder.ded_date.setText(DataHelper.ded_date.get(i));
        viewHolder.job_type.setText(DataHelper.rec_type.get(i));

        viewHolder.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                JSONObject json = null;
                try {
                    json = new JSONObject();
                    json.put("commit", "true");
                } catch (JSONException error) {
                    Toast.makeText(context,"Someting might be wrong.",Toast.LENGTH_SHORT).show();
                    Log.d("SSSS","app");
                }
                String url = "https://androidtask.iris.nitk.ac.in/hrms/placement/status.json";

                JsonObjectRequest commitRequest = new JsonObjectRequest(Request.Method.POST, url, json,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(context,"request successfully applied.",Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }
                );
            }
        });
    }

    @Override
    public int getItemCount() {
        return DataHelper.company_name.size();
    }

    public  class Item extends RecyclerView.ViewHolder{
        TextView comp_name,job_type,rec_date,ded_date,comp_type;
        Button apply;
        public Item(@NonNull View itemView) {
            super(itemView);
            comp_name = itemView.findViewById(R.id.company_name);
            comp_type = itemView.findViewById(R.id.company_type);
            job_type = itemView.findViewById(R.id.job_type);
            rec_date = itemView.findViewById(R.id.rec_date);
            ded_date = itemView.findViewById(R.id.ded_date);
            apply = (Button) itemView.findViewById(R.id.apply_btn);
        }
    }
}

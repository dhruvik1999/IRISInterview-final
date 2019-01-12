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

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class RecyclerAdapterMyApplications extends RecyclerView.Adapter<RecyclerAdapterMyApplications.RecyclerViewHolder> {

    //this recycler view for MyApplication activity.

    Context context;

    public RecyclerAdapterMyApplications(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterMyApplications.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.costume_row_myapp, viewGroup, false);
        return new RecyclerAdapterMyApplications.RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerAdapterMyApplications.RecyclerViewHolder recyclerViewHolder, final int i) {
        recyclerViewHolder.comp_name.setText(DataHelper.applied_company_name.get(i));
        recyclerViewHolder.comp_type.setText(DataHelper.applied_company_type.get(i));
        recyclerViewHolder.rec_date.setText("Date : " + DataHelper.applied_rec_date.get(i));
        recyclerViewHolder.ded_date.setText("Deadline : " + DataHelper.applied_ded_date.get(i));
        recyclerViewHolder.job_type.setText(DataHelper.applied_rec_type.get(i));

    }


    @Override
    public int getItemCount() {
        return DataHelper.applied_company_name.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView comp_name, job_type, rec_date, ded_date, comp_type;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            comp_name = itemView.findViewById(R.id.company_name);
            comp_type = itemView.findViewById(R.id.company_type);
            job_type = itemView.findViewById(R.id.job_type);
            rec_date = itemView.findViewById(R.id.rec_date);
            ded_date = itemView.findViewById(R.id.ded_date);
        }
    }
}

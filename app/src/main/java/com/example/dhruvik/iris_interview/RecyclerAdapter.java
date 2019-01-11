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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    Context context;

    public RecyclerAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.costume_row, viewGroup, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewHolder recyclerViewHolder, final int i) {
        recyclerViewHolder.comp_name.setText(DataHelper.company_name.get(i));
        recyclerViewHolder.comp_type.setText(DataHelper.company_type.get(i));
        recyclerViewHolder.rec_date.setText("Date : " + DataHelper.rec_date.get(i));
        recyclerViewHolder.ded_date.setText("Deadline : " + DataHelper.ded_date.get(i));
        recyclerViewHolder.job_type.setText(DataHelper.rec_type.get(i));


        if(DataHelper.applied_company_index.contains(i)){
            recyclerViewHolder.apply.setVisibility(View.GONE);
        }

        recyclerViewHolder.apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Toast.makeText(context, "Click", Toast.LENGTH_LONG).show();

                postRequest(i,DataHelper.company_name.get(i),DataHelper.company_type.get(i),DataHelper.rec_type.get(i),DataHelper.rec_date.get(i),DataHelper.ded_date.get(i),recyclerViewHolder.apply);
            }
        });
    }


    @Override
    public int getItemCount() {
        return DataHelper.company_name.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView comp_name, job_type, rec_date, ded_date, comp_type;
        Button apply;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            comp_name = itemView.findViewById(R.id.company_name);
            comp_type = itemView.findViewById(R.id.company_type);
            job_type = itemView.findViewById(R.id.job_type);
            rec_date = itemView.findViewById(R.id.rec_date);
            ded_date = itemView.findViewById(R.id.ded_date);
            apply = (Button) itemView.findViewById(R.id.apply_btn);
        }
    }
    private void postRequest(final int i,final String applied_company_name, final String applied_company_type,final String applied_job_type,final String applied_rec_date,final String applied_ded_date ,final Button apply_btn) {
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            String URL = "https://androidtask.iris.nitk.ac.in/hrms/placement/status.json";
            JSONObject jsonBody = new JSONObject();
            jsonBody.put("Title", "Android Volley Demo");
            jsonBody.put("Author", "BNK");
            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                    Toast.makeText(context,"Applied Successfully",Toast.LENGTH_LONG).show();
                    DataHelper.applied_company_name.add(applied_company_name);
                    DataHelper.applied_company_type.add(applied_job_type);
                    DataHelper.applied_ded_date.add(applied_ded_date);
                    DataHelper.applied_rec_date.add(applied_rec_date);
                    DataHelper.applied_rec_type.add(applied_company_type);

                    DataHelper.applied_company_index.add(i);

                    apply_btn.setVisibility(View.GONE);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                    Toast.makeText(context,"Something might be wrong",Toast.LENGTH_LONG).show();

                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };
            requestQueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

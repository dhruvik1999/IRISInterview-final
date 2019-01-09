package com.example.dhruvik.iris_interview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class RecyclerAdapterLayout extends RecyclerView.Adapter<RecyclerAdapterLayout.Item> {

    String companyName[],jobType[],recruitment_date[],deadline[],companyType[];
    Context context;
    public  RecyclerAdapterLayout(Context context,String companyName[],String companyType[],String jobType[],String recruitment_date[],String deadline[]){
        this.context=context;
        this.companyName=companyName;
        this.companyType=companyType;
        this.jobType=jobType;
        this.recruitment_date=recruitment_date;
        this.deadline=deadline;
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.costume_row,parent ,false );
        return new Item(view) ;
    }

    public void onBindViewHolder(Item viewHolder, int i) {
        viewHolder.comp_name.setText(companyName[i]);
        viewHolder.job_type.setText(jobType[i]);
        viewHolder.rec_date.setText("Date : " + recruitment_date[i]);
        viewHolder.ded_date.setText("Deadline : " + deadline[i]);
        //viewHolder..setText();
    }

    @Override
    public int getItemCount() {
        return companyName.length;
    }

    public  class Item extends RecyclerView.ViewHolder{
        TextView comp_name,job_type,rec_date,ded_date,comp_type;
        Button apply_btn;
        public Item(@NonNull View itemView) {
            super(itemView);
            comp_name = itemView.findViewById(R.id.company_name);
            comp_type = itemView.findViewById(R.id.company_type);
            job_type = itemView.findViewById(R.id.job_type);
            rec_date = itemView.findViewById(R.id.rec_date);
            ded_date = itemView.findViewById(R.id.ded_date);
        }
    }
}

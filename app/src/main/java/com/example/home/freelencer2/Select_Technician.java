package com.example.home.freelencer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Select_Technician extends AppCompatActivity {
    RecyclerView recyclerView;
    private RecyclerView.Adapter<technicianViewholder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerView.Adapter<technicianViewholder>(){

            @Override
            public technicianViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
                View list_Technician = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cardview_technician,parent,false);
                return new technicianViewholder(list_Technician);
            }

            @Override
            public void onBindViewHolder(technicianViewholder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 1;
            }
        };
        recyclerView.setAdapter(adapter);
        setContentView(recyclerView);
    }
    private class technicianViewholder extends RecyclerView.ViewHolder{

        public technicianViewholder(View itemView) {
            super(itemView);
        }
    }
}

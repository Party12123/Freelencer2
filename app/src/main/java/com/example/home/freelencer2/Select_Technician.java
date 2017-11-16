package com.example.home.freelencer2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Select_Technician extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView;
    List<List_Technician> list_Dataset;
    FirebaseDatabase database ;
    DatabaseReference databaseReference;
    Adapter_List adapter;

    private Button buttonnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_technician);
        list_Dataset = new ArrayList<>();
        recyclerView = findViewById(R.id.list_technician);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("ช่าง");
        buttonnext = findViewById(R.id.buttonConncet);
        adapter = new Adapter_List(list_Dataset,this);
        recyclerView.setAdapter(adapter);
        List();
        buttonnext.setOnClickListener(this);

    }
    private void List(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list_Dataset.removeAll(list_Dataset);
                for (DataSnapshot datashot:dataSnapshot.getChildren()) {
                    String name = datashot.child("ชื่อ").getValue().toString();
                    String image = datashot.child("ภาพ").getValue().toString();
                    String phone = datashot.child("เบอร์").getValue().toString();
                    String time = datashot.child("เวลา").getValue().toString();
                    String uid = datashot.getKey();
                    List_Technician list = new List_Technician(name,phone,time,image,uid);
                    list_Dataset.add(list);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(this,SendLocation.class));
    }
}



package com.example.home.freelencer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Select_Technician extends AppCompatActivity {
    RecyclerView recyclerView;
    List<List_Technician> list_Dataset;
    FirebaseDatabase database ;
    DatabaseReference databaseReference;
    Adapter_List adapter;
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

        adapter = new Adapter_List(list_Dataset);
        recyclerView.setAdapter(adapter);
        list2();
        List();
    }
    private void List(){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list_Dataset.removeAll(list_Dataset);
                for (DataSnapshot datashot:dataSnapshot.getChildren()) {
                    String x = datashot.child("ชื่อ").getValue().toString();
                    String y = datashot.child("เบอร์").getValue().toString();
                    String z = datashot.child("เวลา").getValue().toString();
                    List_Technician list = new List_Technician(x,y,z);
                    list_Dataset.add(list);
                         Toast.makeText(Select_Technician.this," "+list_Dataset.size(),Toast.LENGTH_SHORT).show();
                   // Toast.makeText(Select_Technician.this,,Toast.LENGTH_SHORT).show();



                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void list2(){
        List_Technician news = new List_Technician("Party","55555","568941");
        list_Dataset.add(news);
    }

}



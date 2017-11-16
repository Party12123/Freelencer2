package com.example.home.freelencer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

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
	
	private static final String TAG = "Select_Technician";

    private static final int ERROR_DIALOG_REQUEST = 9001;
    
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
        List();
		
		if(isServicesOK()){
            init();
        }
		
		
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
	
	private void init(){
        Button btnMap = (Button) findViewById(R.id.btnMap);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Select_Technician.this, SendLocation.class);
                startActivity(intent);
            }
        });
    }

    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Select_Technician.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Select_Technician.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

}



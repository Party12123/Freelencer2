package com.example.home.freelencer2;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SendLocation extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    private Button saveData;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    SendDetail sendDetail =new SendDetail();
    String mAuth = FirebaseAuth.getInstance().getUid();
    public static String idTechnicain;
    Select_Technician select_technician = new Select_Technician();
    @Override
    public void onMapReady(GoogleMap googleMap) {
        Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onMapReady: map is ready");
        mMap = googleMap;
    }

    private static final String TAG = "SendLocation";

    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    //vars
    private Boolean mLocationPermissionsGranted = false;
    private GoogleMap mMap;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_location);
        saveData = findViewById(R.id.success);
        saveData.setOnClickListener(this);
        sendDetail.setUid(mAuth);
        firebaseDatabase = FirebaseDatabase.getInstance();

        if(select_technician.check == 0){
            databaseReference = firebaseDatabase.getReference().child("งานช่าง").child("บ้าน");
        }
        else if(select_technician.check == 1){
            databaseReference = firebaseDatabase.getReference().child("งานช่าง").child("รถยนต์");
        }
        else if(select_technician.check== 2){
            databaseReference = firebaseDatabase.getReference().child("งานช่าง").child("จักรยานยนต์");
        }

        Toast.makeText(SendLocation.this,sendDetail.getPhone(),Toast.LENGTH_SHORT).show();
        getLocationPermission();
    }

    private void initMap(){
        Log.d(TAG, "initMap: initializing map");
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(SendLocation.this);
    }

    private void getLocationPermission(){
        Log.d(TAG, "getLocationPermission: getting location permissions");
        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION};

        if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if(ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mLocationPermissionsGranted = true;
            }else{
                ActivityCompat.requestPermissions(this,
                        permissions,
                        LOCATION_PERMISSION_REQUEST_CODE);
            }
        }else{
            ActivityCompat.requestPermissions(this,
                    permissions,
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Log.d(TAG, "onRequestPermissionsResult: called.");
        mLocationPermissionsGranted = false;

        switch(requestCode){
            case LOCATION_PERMISSION_REQUEST_CODE:{
                if(grantResults.length > 0){
                    for(int i = 0; i < grantResults.length; i++){
                        if(grantResults[i] != PackageManager.PERMISSION_GRANTED){
                            mLocationPermissionsGranted = false;
                            Log.d(TAG, "onRequestPermissionsResult: permission failed");
                            return;
                        }
                    }
                    Log.d(TAG, "onRequestPermissionsResult: permission granted");
                    mLocationPermissionsGranted = true;
                    //initialize our map
                    initMap();
                }
            }
        }
    }

    @Override
    public void onClick(View view) {

        if(view == saveData){
            databaseReference.child(getIdTechnicain()).push().setValue(sendDetail);
            Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,Home_Toppicp_roblem.class));
        }
    }

    public String getIdTechnicain() {
        return idTechnicain;
    }

    public void setIdTechnicain(String idTechnicain) {
        this.idTechnicain = idTechnicain;
    }
}

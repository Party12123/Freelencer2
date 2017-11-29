package com.example.home.freelencer2;


import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.home.freelencer2.ProfileFragment.*;


public class Home_Toppicp_roblem extends AppCompatActivity  {

    private TextView mTextMessage;
    private FirebaseAuth mAuth;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Home();
                        return true;
                    case R.id.navigation_messenger:
                        messagerfragment();
                        return true;
                    case R.id.navigation_notifications:
                        mTextMessage.setText(R.string.title_notifications);
                        return true;
                    case R.id.navigation_profile:
                        Profile();
                         // ProfileFragment();

                        //Intent intent = new Intent(Home_Toppicp_roblem.this,Profile.class);
                        //startActivity(intent);
                        return true;

                }
                return false;
            }


        };
    }

    private void messagerfragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new messagerFragment())
                .commit();
    }

    private BottomNavigationView.OnNavigationItemReselectedListener bReselectedListener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            Toast.makeText(Home_Toppicp_roblem.this,"กดซ้ำหน้าเดิม",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__toppicp_roblem);
        mAuth = FirebaseAuth.getInstance();
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setOnNavigationItemReselectedListener(bReselectedListener);
                Home();
        }
    private void Home() {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,homeFragment.newInstance()).commit();
    }

    private void Profile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container,Profile.newInstance()).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.bar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            mAuth.signOut();
            startActivity(new Intent(this,SingIn.class));
            return true;
        }
        else if(id == R.id.set){
            startActivity(new Intent(this,EditProfile.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}


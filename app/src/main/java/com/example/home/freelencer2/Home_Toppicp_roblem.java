package com.example.home.freelencer2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Home_Toppicp_roblem extends AppCompatActivity  {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener

            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Home();
                    return true;
                case R.id.navigation_messenger:
                    messagerfragment();
                    return  true;
                case R.id.navigation_notifications:
                    navigation();
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    private void navigation() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, Navigation.newInstance()).commit();
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
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setOnNavigationItemReselectedListener(bReselectedListener);
                Home();
        }
    private void Home() {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,homeFragment.newInstance()).commit();
    }
    
}


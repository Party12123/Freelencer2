package com.example.home.freelencer2;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;


public class Profile extends Fragment {

    private FragmentManager fragmentManager;


    private TextView uname1;
    private TextView uemail1;
    private TextView uphone1;
    private TextView uface1;

    public DatabaseReference myRef;
    public FirebaseAuth mAuth;
    private String userID;
    DataProfile dp = new DataProfile();

    public Profile() {
        // Required empty public constructor
    }

    public static Profile newInstance() {
        Profile fragment = new Profile();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_profile_fragment, container, false);

      //  Toast.makeText(getContext(), m, Toast.LENGTH_SHORT).show();
        uemail1 = view.findViewById(R.id.uemail);
        uname1 = view.findViewById(R.id.urname);
        uphone1 = view.findViewById(R.id.uphone);
        uface1 = view.findViewById(R.id.uface);


        mAuth = FirebaseAuth.getInstance();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();




        myRef = database.getReference().child("User").child(userID);
        Toast.makeText(getContext(),userID,Toast.LENGTH_SHORT).show();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ShowData(dataSnapshot);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        return view;
        }

        private void ShowData(DataSnapshot dataSnapshot){
            String readname = dataSnapshot.child("Name").getValue().toString();
            uname1.setText(readname);
            String reademail = dataSnapshot.child("Email").getValue().toString();
            uemail1.setText("E-mail: "+reademail);
            String readphone = dataSnapshot.child("Phone").getValue().toString();
            uphone1.setText("Phone Number: "+readphone);
            String readface = dataSnapshot.child("facebook").getValue().toString();
            uface1.setText("Facebook: "+readface);
        }



        }






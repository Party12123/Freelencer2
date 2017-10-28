package com.example.home.freelencer2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SingIn extends AppCompatActivity implements View.OnClickListener {
    private EditText luserEmail;
    private EditText luserPassword;
    private Button luserSingin;
    private Button luserSingup;
    private Button googleSing;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button luserSingout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sing_in);
        mAuth = FirebaseAuth.getInstance();
        mProgress = new ProgressDialog(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser != null){
                    Toast.makeText(SingIn.this,"Using Working",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SingIn.this,"Not Using Working",Toast.LENGTH_SHORT).show();
                }
            }
        };
        /// ส่วนของ View
        luserEmail = (EditText) findViewById(R.id.luserEmail);
        luserPassword = (EditText) findViewById(R.id.luserpassword);
        luserSingin = (Button) findViewById(R.id.luserSignin);
        luserSingup = (Button) findViewById(R.id.luserSingup);
        luserSingout = (Button) findViewById(R.id.luserSingout);
       // googleSing = (Button) findViewById(R.id.googleSing);
        /// Event SingIn and SingUp
        luserSingin.setOnClickListener(this);
        luserSingup.setOnClickListener(this);
        luserSingout.setOnClickListener(this);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }
    private void  signIn(String email , String password){
        Log.d("EmailPassword","SingIn"+email);
        if(!validateForm()){
            return;
        }
        mProgress.setMessage("Sing Up....");
        mProgress.show();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(SingIn.this,"SingIn Successfuly",Toast.LENGTH_SHORT).show();
                    mProgress.dismiss();
                }
            }
        });
    }
    private void Singout(){
        mAuth.signOut();
        Toast.makeText(SingIn.this,"User Singout",Toast.LENGTH_SHORT).show();

    }

    private void SingUp(){
        startActivity(new Intent(SingIn.this,Singup.class));
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = luserEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            luserEmail.setError("Required.");
            valid = false;
        } else {
            luserEmail.setError(null);
        }

        String password = luserPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            luserPassword.setError("Required.");
            valid = false;
        } else {
            luserPassword.setError(null);
        }

        return valid;
    }

    @Override
    public void onClick(View v) {
        if (v == luserSingin){
            signIn(luserEmail.getText().toString().trim(),luserPassword.getText().toString().trim());
        }
        else if(v == luserSingup){
            SingUp();
        }
        else if(v == luserSingout){
            Singout();
        }
    }
}

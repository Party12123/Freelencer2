package com.example.home.freelencer2;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Singup extends AppCompatActivity implements View.OnClickListener {

    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;
    private EditText userPhone;
    private Button userCreate;
    private ProgressDialog mProgress;

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseRef;
    private FirebaseDatabase mFirebaseData;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        ///FireBase
        mAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("User");
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser != null){
                    saveDataUser(currentUser.getUid());
                }
            }
        };

        //View
        userName = (EditText) findViewById(R.id.userName);
        userPassword = (EditText) findViewById(R.id.userPassword);
        userEmail = (EditText) findViewById(R.id.userEmail);
        userPhone = (EditText) findViewById(R.id.userPhone);
        userCreate = (Button) findViewById(R.id.userCreate);
        mProgress = new ProgressDialog(this);

        //CileckEven
        userCreate.setOnClickListener(this);
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
    }
    @Override
    public void onClick(View v) {
        if(v == userCreate ){
            newCreateUser(userEmail.getText().toString().trim(),userPassword.getText().toString().trim());
        }
    }

    private void newCreateUser(final String email, final String password) {
        mProgress.setMessage("Sing Up....");
        mProgress.show();
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    mProgress.dismiss();
                    mAuth.addAuthStateListener(mAuthListener);
                }
                else{
                    Toast.makeText(Singup.this,"Not Sucressfuly",Toast.LENGTH_SHORT).show();
                    mProgress.dismiss();
                }
            }
        });
    }

    private boolean validateForm() {
        boolean valid = true;

        String email = userEmail.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            userEmail.setError("Required.");
            valid = false;
        } else {
            userEmail.setError(null);
        }

        String password = userPassword.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            userPassword.setError("Required.");
            valid = false;
        } else {
            userPassword.setError(null);
        }
        return valid;
    }
    private void saveDataUser (String id){
        String name = userName.getText().toString().trim();
        String email = userEmail.getText().toString().trim();
        String phone = userPhone.getText().toString().trim();
        mDatabaseRef.child(id).child("Name").setValue(name);
        mDatabaseRef.child(id).child("Email").setValue(email);
        mDatabaseRef.child(id).child("Phone").setValue(phone);
        Toast.makeText(Singup.this,"Sucressfuly",Toast.LENGTH_SHORT).show();
    }
}

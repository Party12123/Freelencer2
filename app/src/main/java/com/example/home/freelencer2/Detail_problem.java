package com.example.home.freelencer2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.support.v7.widget.RecyclerView;

import org.w3c.dom.Text;

public class Detail_problem extends AppCompatActivity {
    private Button next;
    private EditText detail_Name;
    private EditText detail_Phone;
    private EditText detail_Problem;
    private EditText detail_Address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_fragment);
        detail_Name = findViewById(R.id.editName);
        detail_Address = findViewById(R.id.editTextAddress);
        detail_Phone = findViewById(R.id.editTextPhone);
        detail_Problem = findViewById(R.id.editTextProblem);
    }

}

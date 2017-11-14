package com.example.home.freelencer2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class homeFragment extends Fragment implements View.OnClickListener {
     private Button problem_Home;
     private Button problem_Elec;
     private Button problem_Car;
     private Button problem_Cycle;
     private Button problem_Normal;
     private Button problem_Custum;

     private FragmentManager fragmentManager;

    public homeFragment() {
        // Required empty public constructor
    }
    public static Fragment newInstance() {
        homeFragment home = new homeFragment();
        Bundle bHome = new Bundle();
        home.setArguments(bHome);
        return home;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
         problem_Car =  view.findViewById(R.id.problem_Car);
         problem_Custum =  view.findViewById(R.id.problem_custum);
         problem_Cycle =  view.findViewById(R.id.problem_cycle);
         problem_Elec = view.findViewById(R.id.problem_Elec);
         problem_Home =  view.findViewById(R.id.problem_home);
         problem_Normal =  view.findViewById(R.id.problem_normal);

         //
        problem_Normal.setOnClickListener(this);
        problem_Home.setOnClickListener(this);
        problem_Elec.setOnClickListener(this);
        problem_Normal.setOnClickListener(this);
        problem_Cycle.setOnClickListener(this);
        problem_Car.setOnClickListener(this);

        return view;
    }


   @Override
    public void onClick(View view) {
       if (view == problem_Home){
           startActivity(new Intent(getActivity(),Detail_problem.class));
       }
       else if(view == problem_Car){
            startActivity(new Intent(getActivity(),Detail_problem.class));
       }
       else if(view == problem_Cycle){
           startActivity(new Intent(getActivity(),Detail_problem.class));
       }
    }
}

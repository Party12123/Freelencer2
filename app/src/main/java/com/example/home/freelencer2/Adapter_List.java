package com.example.home.freelencer2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Home on 11/8/2017.
 */

public class Adapter_List extends RecyclerView.Adapter<Adapter_List.Adapter_list2> {
    List<List_Technician> list;
    boolean check = false;
    int checkpossotion;
    Context context;
    List_Technician listTechnician;
    SendLocation sendLocation = new SendLocation();
    public Adapter_List(){
    }
    public Adapter_List(List<List_Technician> list,Context context) {
        this.context = context;
        this.list = list;
    }

    @Override
    public Adapter_list2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_technician,parent,false);
        return new Adapter_list2(view);
    }

    @Override
    public void onBindViewHolder(final Adapter_list2 holder,final int position) {
        listTechnician =list.get(position);
        holder.textViewname.setText(listTechnician.getName());
        holder.textViewPhone.setText(listTechnician.getPhone());
        holder.textViewTime.setText(listTechnician.getTime());
        Picasso.with(holder.imageView.getContext()).load(listTechnician.getImage()).into(holder.imageView);
        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check != true){
                    listTechnician =list.get(position);
                    holder.select.setBackgroundColor(-16711936);
                    holder.select.setText("ยกเลิก");
                    sendLocation.setIdTechnicain(listTechnician.getUid());
                    check = true;
                    checkpossotion = position;
                }
                else if(check == true && checkpossotion == position){
                    holder.select.setBackgroundColor(-12303292);
                    holder.select.setText("เลือก");
                    check = false;
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Adapter_list2 extends RecyclerView.ViewHolder  {
        ImageView imageView;
        TextView textViewname;
        TextView textViewTime;
        TextView textViewPhone;
        Button select;
        Button connect;
        public Adapter_list2(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewTechnician);
            textViewname = itemView.findViewById(R.id.textViewName);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            select=itemView.findViewById(R.id.buttonSelect);
            connect = itemView.findViewById(R.id.buttonConncet);

        }

    }
}

package com.example.home.freelencer2;

import android.graphics.Color;
import android.net.Uri;
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


    public Adapter_List(List<List_Technician> list) {
        this.list = list;
    }

    @Override
    public Adapter_list2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_technician,parent,false);
        return new Adapter_list2(view);
    }

    @Override
    public void onBindViewHolder(final Adapter_list2 holder, int position) {
        final List_Technician listTechnician =list.get(position);
        holder.textViewname.setText(listTechnician.getName());
        holder.textViewPhone.setText(listTechnician.getPhone());
        holder.textViewTime.setText(listTechnician.getTime());
        Picasso.with(holder.imageView.getContext()).load(listTechnician.getImage()).into(holder.imageView);
        holder.select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check != true){
                    holder.select.setBackgroundColor( -16711936);
                    holder.select.setText("เลือกแล้ว");
                    String uid = listTechnician.getUid();
                    check = true;
                }
            }
        });




    }
    @Override
    public int getItemCount() {

        return list.size();
    }

    public class Adapter_list2 extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewname;
        TextView textViewTime;
        TextView textViewPhone;
        Button select;
        public Adapter_list2(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewTechnician);
            textViewname = itemView.findViewById(R.id.textViewName);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            select=itemView.findViewById(R.id.buttonSelect);
        }
    }
}

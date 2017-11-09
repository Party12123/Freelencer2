package com.example.home.freelencer2;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 11/8/2017.
 */

public class Adapter_List extends RecyclerView.Adapter<Adapter_List.Adapter_list2> {
    List<List_Technician> list;

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
        List_Technician listTechnician =list.get(position);
        holder.textViewname.setText(listTechnician.getName());
        holder.textViewPhone.setText(listTechnician.getPhone());
        holder.textViewTime.setText(listTechnician.getTime());
       // holder.imageView.setI;


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
        public Adapter_list2(View itemView) {
            super(itemView);
           // imageView = itemView.findViewById(R.id.imageViewTechnician);
            textViewname = itemView.findViewById(R.id.textViewName);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewTime = itemView.findViewById(R.id.textViewTime);
        }
    }
}

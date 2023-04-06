package com.example.bookrecordapp;

import static com.example.bookrecordapp.Adapter.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{
    Context context;
    ArrayList<UserModel> list =new ArrayList<>();

    public Adapter(Context context, ArrayList<UserModel> list) {
        this.context = context;
       this.list = list;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).UserName);
        holder.email.setText(list.get(position).UserEmail);
        holder.phone.setText(list.get(position).UserPhone);


    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,phone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.Name);
            email = itemView.findViewById(R.id.Email);
            phone = itemView.findViewById(R.id.phone);
        }
    }
}




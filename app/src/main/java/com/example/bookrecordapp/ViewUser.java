package com.example.bookrecordapp;

import static com.example.bookrecordapp.R.*;
import static com.example.bookrecordapp.R.id.*;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewUser extends AppCompatActivity {
    private DatabaseHelper databaseHelper;

    RecyclerView recyclerView = findViewById(userRecycler);

    Adapter adapter;

    ArrayList<UserModel> List;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.model);

        recyclerView=findViewById(userRecycler);
       // recyclerView1=findViewById(main_recycler);
        List=new ArrayList<>();
        databaseHelper=new DatabaseHelper(ViewUser.this);

        List=databaseHelper.ReadUser();
        adapter=new Adapter(ViewUser.this,List);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
}

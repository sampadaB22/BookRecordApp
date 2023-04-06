package com.example.bookrecordapp;

import static com.example.bookrecordapp.R.id.userRecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class viewUserTool extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    RecyclerView recyclerView;

    Adapter adapter;

    ArrayList<UserModel> List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_tool);
        recyclerView = findViewById(R.id.userRecyclerYTwo);

        databaseHelper =new DatabaseHelper(viewUserTool.this);
        List=new ArrayList<>();
        List=databaseHelper.ReadUser();
        adapter=new Adapter(viewUserTool.this,List);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
package com.example.bookrecordapp;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;
import static com.example.bookrecordapp.R.id.Read;
import static com.example.bookrecordapp.R.id.userRecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Email;
    private EditText Phone;

    private Button add,read;
    private DatabaseHelper databaseHelper;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.User_Name);
        Email = findViewById(R.id.User_Email);
        Phone = findViewById(R.id.User_Phone);



        add=findViewById(R.id.add);
        read=findViewById(Read);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        add.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
              String User_Name=Name.getText().toString();
                String User_Email=Email.getText().toString();
                String User_Phone=Phone.getText().toString();

                if(User_Name.isEmpty()&&User_Email.isEmpty()&&User_Phone.isEmpty()){
                    Toast.makeText(MainActivity.this, "add the information", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    databaseHelper.addNewUser(User_Name, User_Email, User_Phone);

                    Toast.makeText(MainActivity.this, "Added Successfully", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    e.printStackTrace();
                }


                Name.setText("");
                Email.setText("");
                Phone.setText("");
            }
        }
        );
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,viewUserTool.class);
                startActivity(intent);
            }
        });







    }

}

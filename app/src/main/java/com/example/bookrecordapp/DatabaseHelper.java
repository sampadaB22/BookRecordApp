package com.example.bookrecordapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class DatabaseHelper extends SQLiteOpenHelper {
//static keyword use for runtime memory allocation
    private static final String DB_Name = "User_Information";

    private static final String DB_version= "1";

    private static final String Table_Name = "User";

    private static final String Id_Col = "User_Id";

    private static final String Name_Col = "User_Name";

    private static final String Email_Col = "User_Email";

    private static final String Phone_Col = "User_Phone";



    public DatabaseHelper(Context context){
        super(context, DB_Name ,null, Integer.parseInt(DB_version));
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String Query = "CREATE TABLE " + Table_Name + " ( "
                + Id_Col+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Name_Col + " TEXT,"
                + Email_Col + " TEXT,"
                + Phone_Col + " INTEGER)";
        sqLiteDatabase.execSQL(Query);
    }



   public  void addNewUser(String UserName, String UserEmail, String UserPhone){

        SQLiteDatabase Data = this.getWritableDatabase();
       ContentValues values = new ContentValues();

       values.put(Name_Col, UserName);
       values.put(Email_Col,UserEmail);
       values.put(Phone_Col, UserPhone);

       Data.insert(Table_Name,null,values);
       Data.close();
   }

   public ArrayList<UserModel>ReadUser(){

        SQLiteDatabase db=this.getReadableDatabase();

       Cursor cursor= db.rawQuery(" SELECT * FROM "+ Table_Name,null);

       ArrayList<UserModel>List=new ArrayList<>();

       if (cursor.moveToNext()){
           do{
               List.add(new UserModel(cursor.getString(0),cursor.getString(1),cursor.getString(2)));
           }while (cursor.moveToNext());
       }
          cursor.close();
       return List;

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
       sqLiteDatabase .execSQL(" DROP TABLE "+Table_Name);
       onCreate(sqLiteDatabase);
    }
}

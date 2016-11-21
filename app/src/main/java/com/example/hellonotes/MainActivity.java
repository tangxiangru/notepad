package com.example.hellonotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private NotesDB notesDB;
    private SQLiteDatabase dbWriter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesDB = new NotesDB(this);
        dbWriter = notesDB.getReadableDatabase();
        addDB();
    }

    public void addDB(){
        ContentValues cv = new ContentValues();
        cv.put(NotesDB.CONTENT, "hello");
        cv.put(NotesDB.TIME, getTime());
        dbWriter.insert(NotesDB.TABLE_NAME,null,cv);



    }
    public String getTime(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
//        SimpleDateFormat format = new Date("yyyy年MM月dd日 HH:MM:SS");
        Date curDate = new Date(System.currentTimeMillis());
        String str = format.format(curDate);

        return str;

    }

}

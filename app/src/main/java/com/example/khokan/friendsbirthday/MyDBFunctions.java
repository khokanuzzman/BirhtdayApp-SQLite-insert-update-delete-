package com.example.khokan.friendsbirthday;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 8/25/2018.
 */

public class MyDBFunctions extends SQLiteOpenHelper {

    private static final String DATABSE_NAME = "final_myfrnddb";
    private static final String TABLE_NAME = "friends_bd";

    private static final String TAB_ID = "id";
    private static final String TAB_NAME = "name";
    private static final String TAB_DAYS = "days";


    MyDBFunctions(Context c){
        super(c, DATABSE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String s = "CREATE TABLE "+TABLE_NAME+" ("+TAB_ID+" INTEGER PRIMARY KEY, "+TAB_NAME+" TEXT, "+TAB_DAYS+" TEXT)";
        db.execSQL(s);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // ---- ---- adding data to database --- -----

    void addingDataToTable(DataTemp dt){

        SQLiteDatabase sqd  = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TAB_NAME, dt.getName());
        cv.put(TAB_DAYS, dt.getBdate());

        sqd.insert(TABLE_NAME, null, cv);
        sqd.close();

    }

//    show data

    // --- ---- showing data ------ ----

    String[] my_data() {

        SQLiteDatabase sq = this.getReadableDatabase();

        String q = "SELECT * FROM "+TABLE_NAME;

        Cursor c = sq.rawQuery(q, null);

        String[] recvied_data = new String[c.getCount()];

        c.moveToFirst();

        if(c.moveToFirst()){
            int counter = 0 ;
            do {
                recvied_data[counter] = c.getString(c.getColumnIndex(TAB_NAME+"")) +"\nBirthday: "+
                        c.getString(c.getColumnIndex(TAB_DAYS+""));
                counter = counter+1;

            } while(c.moveToNext());

        }

        return recvied_data;
    }

//    fetch values;
    String fetch_bday(int id){
        SQLiteDatabase sq = this.getReadableDatabase();
        String q = "SELECT "+TAB_DAYS+" FROM "+TABLE_NAME+" WHERE "+TAB_ID+" = "+id;
        Cursor c = sq.rawQuery(q, null);
        String s="";
        c.moveToFirst();
        if (c.moveToFirst()){
            s=c.getString(c.getColumnIndex(TAB_DAYS+""));
        }
        return s;
    }
//    update birthday

    int update_birthday(int id, String bday){
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put(TAB_DAYS,bday);

        return sq.update(TABLE_NAME, cv, TAB_ID+" = ? ", new String[]{id+""});

    }

    int delete_bd(String bday){
        SQLiteDatabase s = this.getWritableDatabase();
        return s.delete(TABLE_NAME, TAB_DAYS+" = ?", new String[] {bday});
    }
}

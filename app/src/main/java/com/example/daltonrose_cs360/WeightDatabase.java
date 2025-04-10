package com.example.daltonrose_cs360;

import static android.content.ContentValues.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class WeightDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "weights.db";
    private static final int VERSION = 2;

    public WeightDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private static final class WeightTable {
        private static final String TABLE = "weight";
        private static final String COL_ID = "_id";
        private static final String COL_WEIGHT = "weight";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + WeightTable.TABLE + " (" +
                WeightTable.COL_ID + " integer primary key autoincrement, " +
                WeightTable.COL_WEIGHT + " float)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + WeightTable.TABLE);
        onCreate(db);
    }

    public void addWeight(float weight) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(WeightTable.COL_WEIGHT, weight);

        db.insert(WeightTable.TABLE, null, values);
        Log.d(TAG, "Done");
    }

    public void getWeight(int id) {
        SQLiteDatabase db = getReadableDatabase();

        //String sql = "select * from " + WeightTable.TABLE + " where _id = ?";
        Cursor cursor = db.rawQuery("select * from " + WeightTable.TABLE, null);
        cursor.moveToPosition(id);
        Float weight = cursor.getFloat(1);
        Log.d(TAG, String.valueOf(weight));
        cursor.close();
    }

    public void deleteItem(int id) {
        SQLiteDatabase db = getReadableDatabase();

        db.delete(WeightTable.TABLE, WeightTable.COL_ID + " = ?", new String[]{String.valueOf(id)});
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + WeightTable.TABLE, null);
    }
}

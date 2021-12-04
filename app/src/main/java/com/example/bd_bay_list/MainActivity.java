package com.example.bd_bay_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText product, col,type, cost,category;
    SQLiteHolper helper;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        product = findViewById(R.id.product);
        col = findViewById(R.id.col);
        type = findViewById(R.id.type);
        cost = findViewById(R.id.cost);
        category = findViewById(R.id.category);

        helper = new SQLiteHolper(this);
        database = helper.getWritableDatabase();
    }
    ///curosrsimpaladabter - посмотреть
    public void addNote(){
        ContentValues values = new ContentValues();
        values.put(SQLiteHolper.COLUMN_PRODUCT,product.getText().toString());
        values.put(SQLiteHolper.COLUMN_COL,Double.parseDouble(col.getText().toString()));
        values.put(SQLiteHolper.COLUMN_TYPE,type.getText().toString());
        values.put(SQLiteHolper.COLUMN_COST,Double.parseDouble(cost.getText().toString());
        values.put(SQLiteHolper.COLUMN_CATEGORY,category.getText().toString());
        database.insert(SQLiteHolper.DATABASE_TABLE,null, values);
    }

    @Override
    protected void onStop() {
        super.onStop();
        database.close();
    }
}
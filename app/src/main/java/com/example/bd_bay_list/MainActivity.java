package com.example.bd_bay_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText product, col,type, cost,category;
    SQLiteHolper helper;
    SQLiteDatabase database;
    Cursor cursor;

    //инициализация списка - RecyclerView
    ArrayList<State> listShape = new ArrayList<State>();
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
        try {
            database = helper.getWritableDatabase();
        }
        catch (SQLiteException ex){
            database = helper.getReadableDatabase();
        }
        showList();

        RecyclerView recyclerView = findViewById(R.id.list);

        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, listShape);

        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);;
    }

    private void setInitialData( Cursor cursor) {
        //считываем ответ с начало
        cursor.moveToFirst();

            while (cursor.moveToNext()) {
                int id =
                        cursor.getInt(
                                cursor.getColumnIndex(SQLiteHolper.COLUMN_ID));
                String PRODUCT =
                        cursor.getString(
                                cursor.getColumnIndex(SQLiteHolper.COLUMN_PRODUCT));
                String COL =
                        cursor.getString(
                                cursor.getColumnIndex(SQLiteHolper.COLUMN_COL));
                String TYPE =
                        cursor.getString(
                                cursor.getColumnIndex(SQLiteHolper.COLUMN_TYPE));
                String COST =
                        cursor.getString(
                                cursor.getColumnIndex(SQLiteHolper.COLUMN_COST));
                String CATEGORY =
                        cursor.getString(
                                cursor.getColumnIndex(SQLiteHolper.COLUMN_CATEGORY));
                //String DATE =
                        //cursor.getString(
                               // cursor.getColumnIndex(SQLiteHolper.COLUMN_DATE));
                listShape.add(new State(PRODUCT,CATEGORY,COL,COST));
            }

    }

    ///curosr simpal adabter - посмотреть
    public void addNote(View view){
        ContentValues values = new ContentValues();
        values.put(SQLiteHolper.COLUMN_PRODUCT,                product.getText().toString());
        values.put(SQLiteHolper.COLUMN_COL,Double.parseDouble( col.getText().toString()));
        values.put(SQLiteHolper.COLUMN_TYPE,                   type.getText().toString());
        values.put(SQLiteHolper.COLUMN_COST,Double.parseDouble(cost.getText().toString()));
        values.put(SQLiteHolper.COLUMN_CATEGORY,               category.getText().toString());
        database.insert(SQLiteHolper.DATABASE_TABLE,null, values);
    }

    public void showList(){

        //запрос  к бд
        cursor  = database.rawQuery("SELECT * FROM " + SQLiteHolper.DATABASE_TABLE, null);
        setInitialData(cursor);

        cursor.close();

    }

    @Override
    protected void onStop() {
        super.onStop();
        database.close();
    }
}
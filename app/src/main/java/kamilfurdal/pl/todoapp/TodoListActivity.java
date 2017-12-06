package kamilfurdal.pl.todoapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import kamilfurdal.pl.todoapp.data.DatabaseHelper;
import kamilfurdal.pl.todoapp.data.TodosContract.TodosEntry;




public class TodoListActivity extends AppCompatActivity {

    String[] itemname ={
            "Make shopping",
            "Remember to update CV",
            "Gym with Karol",
            "University meating",
            "Visit Parents",
            "Remember to buy tickets",
            "TDD"
    };

    private void readData(){

        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase database = helper.getReadableDatabase();
        //TODO

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //DatabaseHelper helper = new DatabaseHelper(this);
        //SQLiteDatabase database = helper.getReadableDatabase();
        CreateTodo();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ListView listView = (ListView) findViewById(R.id.lvTodos);

        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.todo_list_item,
                R.id.tvNote, itemname));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {

                Intent intent = new Intent(TodoListActivity.this, TodoActivity.class);
                String content= (String) listView.getItemAtPosition(pos);
                intent.putExtra("Content", content);
                startActivity(intent);
            }
        });

        FloatingActionButton floatingActionButton =(FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    private void CreateTodo(){

        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();
        String query = "INSERT INTO todos ("
                + TodosEntry.COLUMN_TEXT + ","
                + TodosEntry.COLUMN_CATEGORY + ","
                + TodosEntry.COLUMN_CREATED + ","
                + TodosEntry.COLUMN_EXPIRED + ","
                + TodosEntry.COLUMN_DONE + ")"
                + " VALUES(\"Go to the swiming pool\" , 1, \"2017-12-26\", \"\", 0)";
        database.execSQL(query);

        ContentValues values = new ContentValues();
        values.put(TodosEntry.COLUMN_TEXT, "Call to Mama");
        values.put(TodosEntry.COLUMN_CATEGORY, 1);
        values.put(TodosEntry.COLUMN_CREATED, "2017-06-12");
        values.put(TodosEntry.COLUMN_DONE, 0);
        long todo_id = database.insert(TodosEntry.TABLE_NAME, null, values);

    }
}

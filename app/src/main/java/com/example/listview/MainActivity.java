package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.InterruptedByTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewTodos ;
    TextView textViewTitle , textViewDescription ;
    ArrayList<Todo> arrTodo;
    TodoAdapter adapter;
    int indexTodo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listViewTodos = findViewById(R.id.listTodo);
        textViewTitle = findViewById(R.id.editTextTextPersonName2);
        textViewDescription = findViewById(R.id.editTextTextPersonName3);
        arrTodo = new ArrayList<>();
        adapter = new TodoAdapter(this , R.layout.row_todo ,arrTodo);
        listViewTodos.setAdapter(adapter);
        listViewTodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                indexTodo = i ;
                textViewTitle.setText(arrTodo.get(i).getTitle());
                textViewDescription.setText(arrTodo.get(i).getDescription());
            }
        });
        listViewTodos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Todo findedTodo = arrTodo.get(i) ;
                Intent intent  = new Intent() ;
                intent.setClass(MainActivity.this , ToDoDetails.class);
                intent.putExtra("todo" , findedTodo);
                startActivity(intent);
                return false;
            }
        });
    }

    public void resertValue(){
        textViewTitle.setText("");
        textViewDescription.setText("");
    }

    public void addTodo(View view){
        Todo newTodo = new Todo(textViewTitle.getText().toString() , textViewDescription.getText().toString());
        arrTodo.add(newTodo);
        adapter.notifyDataSetChanged();
        resertValue();
    }

    public void updateTodo(View view){
        Todo newTodo = new Todo(textViewTitle.getText().toString() , textViewDescription.getText().toString());
        arrTodo.set(indexTodo,newTodo);
        adapter.notifyDataSetChanged();
        resertValue();
    }

    public void deleteTodo(View view){
        arrTodo.remove(indexTodo);
        adapter.notifyDataSetChanged();
        resertValue();
    }

}
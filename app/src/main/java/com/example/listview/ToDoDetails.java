package com.example.listview;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ToDoDetails extends AppCompatActivity {
    TextView textViewTitle ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_detail);
        Todo todo = (Todo) getIntent().getSerializableExtra("todo");
        Toast.makeText(this, todo.getDescription(), Toast.LENGTH_SHORT).show();
        textViewTitle = findViewById(R.id.textView7);
        textViewTitle.setText(todo.getTitle());
    }
}
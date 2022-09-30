package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends BaseAdapter {
    private Context context ;
    private int layout ;
    private List<Todo> todoList ;

    public TodoAdapter(Context context, int layout, List<Todo> todoList) {
        this.context = context;
        this.layout = layout;
        this.todoList = todoList;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout , null);

        //get component in view
        TextView title = (TextView) view.findViewById(R.id.titleTodo);
        TextView description = (TextView) view.findViewById(R.id.descriptionTodo);

        //gan gia tri

        Todo todo = todoList.get(i);
        title.setText(todo.getTitle());
        description.setText(todo.getDescription());
        return view;
    }
}
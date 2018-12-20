package com.example.opera.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity {

    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter();
        recyclerView.setAdapter(taskAdapter);

        ArrayList<Task> entries = new ArrayList<Task>();
        entries.add(new Task("Learn Android"));
        entries.add(new Task("Code To do list app"));
        entries.add(new Task("Use list app"));
        entries.add(new Task("become more productive"));
        entries.add(new Task("once"));
        entries.add(new Task("upon"));
        entries.add(new Task("a"));
        entries.add(new Task("time"));
        entries.add(new Task("there"));
        entries.add(new Task("was"));
        entries.add(new Task("princess"));
        entries.add(new Task("ate"));
        entries.add(new Task("apples"));
        entries.add(new Task("and"));
        entries.add(new Task("died"));
        entries.add(new Task("there was no"));
        entries.add(new Task("happily ever after"));
        entries.add(new Task("testing testing"));
        entries.add(new Task("1 2 3"));
        entries.add(new Task("please work"));
        entries.add(new Task("dear god"));

        taskAdapter.setItems(entries);

    }

    public void clicked(View view){
        taskAdapter.ClickedChkBox(view);
    }
}
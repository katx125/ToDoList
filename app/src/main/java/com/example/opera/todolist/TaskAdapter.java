package com.example.opera.todolist;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter {
    private List<Task> mItems = new ArrayList<>();
    public List<Integer> mCheckBox = new ArrayList<>();
    private SparseBooleanArray itemStateArray = new SparseBooleanArray();

    static class TaskViewHolder extends RecyclerView.ViewHolder{

        private CheckBox checkBox;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

    public void setItems(List<Task> items){
        mItems = items;
        notifyDataSetChanged();
    }

    public void ClickedChkBox(View view){
        int position = (int) view.getTag();
        Toast.makeText(view.getContext(), mItems.get(position).task + " #" + mCheckBox.get(position), Toast.LENGTH_SHORT).show();
        CheckBox checkBox = view.findViewById(mCheckBox.get(position));
        int ChkBoxID = checkBox.getId();
        if(itemStateArray.get(ChkBoxID)){
            CheckBoxStyle(false, checkBox);
            itemStateArray.put(ChkBoxID, false);
        }
        else{
            CheckBoxStyle(true, checkBox);
            itemStateArray.put(ChkBoxID, true);
        }
    }

    public void CheckBoxStyle(boolean checked, CheckBox checkBox) {
        if (checked) {
            checkBox.setChecked(true);
            checkBox.setTextColor(Color.LTGRAY);
        } else {
            checkBox.setChecked(false);
            checkBox.setTextColor(Color.BLACK);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof TaskViewHolder){
            CheckBox itemChkBox = ((TaskViewHolder) viewHolder).checkBox;
            itemChkBox.setText(mItems.get(position).task);
            itemChkBox.setTag(position);
            int ChckBoxID = (int) (Math.random()*1000000000);
            itemChkBox.setId(ChckBoxID);
            mCheckBox.add(ChckBoxID);
            //figure out way to save checked state when scrolling
            //https://android.jlelse.eu/android-handling-checkbox-state-in-recycler-views-71b03f237022
            itemStateArray.put(ChckBoxID, false);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}